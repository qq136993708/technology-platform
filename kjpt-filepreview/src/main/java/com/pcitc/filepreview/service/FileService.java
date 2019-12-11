package com.pcitc.filepreview.service;

public interface FileService {

    String getProViewImage(String fileName, String filePath, Integer page);

    int getProViewPageCount(String fileName, String filePath);
}
