package com.pcitc.base.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:Administrator
 * @date:2018/5/9
 */
public class UploadType implements Serializable {
    public static Map fileIconMap = new HashMap();

    static {
        fileIconMap.put("doc", "<i class='fa fa-file-word-o text-primary'></i>");
        fileIconMap.put("docx", "<i class='fa fa-file-word-o text-primary'></i>");
        fileIconMap.put("xls", "<i class='fa fa-file-excel-o text-success'></i>");
        fileIconMap.put("xlsx", "<i class='fa fa-file-excel-o text-success'></i>");
        fileIconMap.put("ppt", "<i class='fa fa-file-powerpoint-o text-danger'></i>");
        fileIconMap.put("pptx", "<i class='fa fa-file-powerpoint-o text-danger'></i>");
        fileIconMap.put("jpg", "<i class='fa fa-file-photo-o text-warning'></i>");
        fileIconMap.put("pdf", "<i class='fa fa-file-pdf-o text-danger'></i>");
        fileIconMap.put("zip", "<i class='fa fa-file-archive-o text-muted'></i>");
        fileIconMap.put("rar", "<i class='fa fa-file-archive-o text-muted'></i>");
        fileIconMap.put("default", "<i class='fa fa-file-o'></i>");
    }
}
