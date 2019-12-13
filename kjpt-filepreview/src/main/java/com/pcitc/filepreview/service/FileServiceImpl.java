package com.pcitc.filepreview.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.jodconverter.DocumentConverter;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.jodconverter.document.DocumentFormat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@Service
public class FileServiceImpl implements FileService {



    @Resource
    private DocumentConverter documentConverter;

    private Object lock = new Object();

    @Override
    public String getProViewImage(String fileName, String filePath, Integer page) {
         //修正页码
        if(page == null) {
            page = 0;
        }

        //计算预览图片的路径，= 原始文件-页码
        String imgPath = filePath + "-" + page.toString() + ".jpg";
        File file = null;

        try {
            synchronized (lock)
            {
                file = new File(imgPath);
                if (!file.exists()) {
                    file = this.getProViewPdf(fileName, filePath);
                    if(file != null && file.exists()) {
                        this.pdfToImage(file, page, imgPath);
                    }
                    file = new File(imgPath);
                } else {
                    //System.out.println("跳过img");
                }
            }

            if(file!=null && file.exists()) {
//                FileModel viewFile = new FileModel();
//                viewFile.setFilePath(imgPath);
//                viewFile.setFileName(fileName+ "." + page + ".jpg");
//                viewFile.setType("image/jpg");
                return imgPath;
            } else {
                throw new RuntimeException("获取预览文件错误");
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int getProViewPageCount(String fileName, String filePath)   {


        try {
            File file = this.getProViewPdf(fileName, filePath);
            if (file != null && file.exists()) {
                PDDocument pdDocument = PDDocument.load(file);
                return pdDocument.getNumberOfPages();
            } else {
                throw new RuntimeException("预览PDF生成错误");
            }
        } catch (Exception e) {
            throw new RuntimeException("获取页码错误, " + e.getMessage(), e);
        }
    }

    private File getProViewPdf(String fileName, String filePath) throws Exception {

        DocumentFormat inputType = this.getInputFileType(fileName);

        if(inputType == DefaultDocumentFormatRegistry.PDF) {
            return new File(filePath);
        } else if(inputType == null) {
            throw new RuntimeException("无法预览该文件，文件类型不支持");
        }

        String pdfPath = filePath + "-view";

        try {
            synchronized (lock)
            {
                File file = new File(pdfPath);
                if (file.exists()) {
                    System.out.println("跳过pdf");
                    return file;
                }
                File sourceFile  = new File(filePath);
                if(sourceFile.exists()) {
                    documentConverter.convert(sourceFile).as(inputType).to(file).as(DefaultDocumentFormatRegistry.PDF).execute();
                    return file;
                } else {
                  throw new RuntimeException("附件" + fileName + "不存在");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("生成预览PDF文件错误，" + e.getMessage(), e);
        }

    }




    private boolean isImageFile(String fileName) {
        String ext = this.getFileExt(fileName);
        return ("JPG".equals(ext) || "JPEG".equals(ext) || "PNG".equals(ext) || "BMP".equals("ext") || "GIF".equals(ext));
    }


    private DocumentFormat getInputFileType(String fileName) {

        String ext = this.getFileExt(fileName);
        if("DOCX".equals(ext)) {
            return DefaultDocumentFormatRegistry.DOCX;
        } else if("DOC".equals(ext)) {
            return DefaultDocumentFormatRegistry.DOC;
        } else if("PDF".equals(ext)) {
            return DefaultDocumentFormatRegistry.PDF;
        } else {
            return  null;
        }

    }


    private void pdfToImage(File file, Integer page, String path) {

        PDDocument pdDocument = null;

        try {
            int dpi = 296;
            pdDocument = PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            int pageCount = pdDocument.getNumberOfPages();
            /* dpi越大转换后越清晰，相对转换速度越慢 */

            if (page < pageCount){
                File outFile = new File(path);
                BufferedImage image = renderer.renderImageWithDPI(page, dpi);
                ImageIO.write(image, "jpg", outFile);
            }  else {
                throw new RuntimeException("已到达最后一页，共" + pageCount + "页");
            }

        }catch (Exception e){
            throw new RuntimeException("预览文件错误, " + e.getMessage(), e);
        }finally {
            try {
                // 这里需要关闭PDDocument，不然如果想要删除pdf文件时会提示文件正在使用，无法删除的情况
                pdDocument.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



    private String getFileExt(String filename) {
        int index = filename.lastIndexOf(".");

        if (index == -1) {
            return null;
        }
        String result = filename.substring(index + 1).toUpperCase();
        return result;
    }




}
