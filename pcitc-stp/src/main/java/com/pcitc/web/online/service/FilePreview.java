package com.pcitc.web.online.service;

import org.springframework.ui.Model;

/**
 * 文件查看接口（配置具体使用在线文件）
 */
public interface FilePreview {
    String filePreviewHandle(String url, Model model);
}
