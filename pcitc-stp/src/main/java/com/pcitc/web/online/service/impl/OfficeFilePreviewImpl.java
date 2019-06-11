package com.pcitc.web.online.service.impl;

import com.pcitc.web.online.model.FileAttribute;
import com.pcitc.web.online.model.ReturnResponse;
import com.pcitc.web.online.service.FilePreview;
import com.pcitc.web.online.utils.DownloadUtils;
import com.pcitc.web.online.utils.FileUtils;
import com.pcitc.web.online.utils.OfficeToPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import java.io.File;

/**
 * Created by kl on 2018/1/17.
 * Content :处理office文件
 */
@Service
public class OfficeFilePreviewImpl implements FilePreview {

    @Autowired
    FileUtils fileUtils;

    @Value("${onlineFilePath}")
    String fileDir;

    @Autowired
    DownloadUtils downloadUtils;

    @Autowired
    private OfficeToPdf officeToPdf;

    @Override
    public String filePreviewHandle(String url, Model model) {
        FileAttribute fileAttribute=fileUtils.getFileAttribute(url);
        String suffix=fileAttribute.getSuffix();
        String fileName=fileAttribute.getName();
        String decodedUrl=fileAttribute.getDecodedUrl();
        boolean isHtml = suffix.equalsIgnoreCase("xls") || suffix.equalsIgnoreCase("xlsx");
        System.out.println("isHtml================="+isHtml);
        String pdfName = fileName.substring(0, fileName.lastIndexOf(".") + 1) + (isHtml ? "html" : "pdf");
        System.out.println("pdfName================="+pdfName);
        // 判断之前是否已转换过，如果转换过，直接返回，否则执行转换
        /*if (!fileUtils.listConvertedFiles().containsKey(pdfName)) {
            
        }*/
        
        String filePath = fileDir + fileName;
        if (!new File(filePath).exists()) {
        	System.out.println("!exists================="+filePath);
            ReturnResponse<String> response = downloadUtils.downLoad(decodedUrl, suffix, null);
            if (0 != response.getCode()) {
                model.addAttribute("msg", response.getMsg());
                return "fileNotSupported";
            }
            filePath = response.getContent();
        }
        String outFilePath = fileDir + pdfName;
        System.out.println("outFilePath================="+outFilePath);
        if (StringUtils.hasText(outFilePath)) {
        	System.out.println("StringUtils================="+filePath);
            officeToPdf.openOfficeToPDF(filePath, outFilePath);
            System.out.println("officeToPdf================="+filePath);
            File f = new File(filePath);
            System.out.println("officeToPdffileUtils================="+isHtml);
            if (isHtml) {
            	System.out.println("isHtml================="+outFilePath);
                // 对转换后的文件进行操作(改变编码方式)
                fileUtils.doActionConvertedFile(outFilePath);
            }
            // 加入缓存
            //fileUtils.addConvertedFile(pdfName, fileUtils.getRelativePath(outFilePath));
        }
        model.addAttribute("pdfUrl", pdfName);
        return isHtml ? "html" : "pdf";
    }
}
