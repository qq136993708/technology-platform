package com.pcitc.filepreview.controller;

import com.pcitc.filepreview.service.FileService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = {"文件预览服务"})
@RestController
@RequestMapping("/preview")
public class PreviewController {

//    @Resource
//    private DocumentConverter documentConverter;

    @Autowired
    private FileService fileService;

//    @RequestMapping(value = "/openPDFTexet", method = RequestMethod.GET)
//    @ApiOperation(value = "word生成pdf")
//    @ResponseBody
//    public void openPDFTexet(@RequestParam(value="page",required=false)Integer page) throws Exception {
//        String path = "d:\\Test";
//        File f = new File(path);
//        if (!f.exists()) {
//            f.mkdirs();
//        }
//        String fileName = "test.pdf";
//        File file = new File(f, fileName);
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        File file111 = new File("d:\\Test\\test.docx");
//        //2.创建文件读入流对象
//        int dpi = 296;
//        FileInputStream fis = new FileInputStream(file111);
//        DocumentFormat in = null;
//        File file1 = new File("d:\\test\\test.pdf");
//        //ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        //FileOutputStream outputStream = new FileOutputStream("test.pdf");
//        documentConverter.convert(file111).to(file1).execute();
//        OfficeUtil officeUtil =new OfficeUtil();
//        officeUtil.pdfToImage(file1, page, "d:\\test\\test.png");
//
//    }


//    @GetMapping("/viewFile/{fileId}/{page}")
//    @ApiOperation(value = "预览word")
//    public void proView(@PathVariable String fileId, @PathVariable(required = false) Integer page) throws Exception {
//
//        InputStream input = this.getInput(fileId);
//        ByteArrayOutputStream output = this.getOutput();
//
//        documentConverter.convert(input).as(DefaultDocumentFormatRegistry.DOCX).to(output).as(DefaultDocumentFormatRegistry.PDF).execute();
//
//        input = new ByteArrayInputStream(output.toByteArray());
//
//        //设置响应头
//        HttpServletResponse res = getCurrentResponse();
//        res.setContentType("image/png");
//        res.setCharacterEncoding("UTF-8");
//        this.pdfToImage(input, page, res.getOutputStream());
//
//    }


//    @GetMapping("/viewFile/{fileId}/{page}")
//    @ApiOperation(value = "预览")
//    public void proView(@PathVariable String fileId, @PathVariable(required = false) Integer page) throws Exception {
//
//        //设置响应头
//        HttpServletResponse res = getCurrentResponse();
//
//        FileModel fileModel = this.fileService.getProViewImage(fileId, page);
//        res.setContentType(fileModel.getType());
//        res.setCharacterEncoding("UTF-8");
//
//        //输出
//        OutputStream os = res.getOutputStream();
//        File file = new File(fileModel.getFilePath());
//        byte[] buffer = this.getByteFromFile(file);
//        os.write(buffer);
//
//    }
//
//
//    @GetMapping("/viewFileCount/{fileId}")
//    @ApiOperation(value = "预览页数")
//    @ResponseBody
//    public Response<Integer> proViewCount(@PathVariable String fileId) throws Exception {
//
//        int count = this.fileService.getProViewPageCount(fileId);
//        return super.returnData(count);
//
//    }


    @GetMapping("/local")
    public String proView(@RequestParam("fileName") String fileName, @RequestParam("filePath") String filePath,
                        @RequestParam(value = "page", required = false) Integer page) throws Exception {
        return this.fileService.getProViewImage(fileName, filePath, page);
    }

    @GetMapping("/localPageCount")
    public int proView(@RequestParam("fileName") String fileName, @RequestParam("filePath") String filePath) throws Exception {
        return this.fileService.getProViewPageCount(fileName, filePath);
    }

    //该方法应该已存在
//    private byte[] getByteFromFile(File file) {
//        FileInputStream fis;
//        byte[] buffer = null;
//        try {
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            fis = new FileInputStream(file);
//            byte[] b = new byte[1024];
//            int n;
//            while ((n = fis.read(b)) != -1) {
//                bos.write(b, 0, n);
//            }
//            fis.close();
//            bos.close();
//            buffer = bos.toByteArray();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//        return buffer;
//    }


//    private InputStream getInput(String fileId) throws Exception {
//        return new FileInputStream("d:\\Test\\test.docx");
//    }
//
//    private ByteArrayOutputStream getOutput() {
//        return new ByteArrayOutputStream();
//    }
//
//
//    public void pdfToImage(InputStream file, Integer page, OutputStream output) {
//
//        PDDocument pdDocument = null;
//        try {
//            int dpi = 296;
//            pdDocument = PDDocument.load(file);
//            PDFRenderer renderer = new PDFRenderer(pdDocument);
//            int pageCount = pdDocument.getNumberOfPages();
//            /* dpi越大转换后越清晰，相对转换速度越慢 */
//            if (page<=pageCount){
//                BufferedImage image = renderer.renderImageWithDPI(page, dpi);
//                ImageIO.write(image, "png", output);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try {
//                // 这里需要关闭PDDocument，不然如果想要删除pdf文件时会提示文件正在使用，无法删除的情况
//                pdDocument.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
