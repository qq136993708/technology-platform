package com.pcitc.service.system.impl;

import com.pcitc.base.util.FileUtil;
import com.pcitc.service.system.FileService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author:Administrator
 * @date:2019/4/28
 */
public class FileServiceImpl implements FileService {

    @Override
    public String getGoogleUrl(boolean isCn, String longitude, String latitude) {
        return FileUtil.getGoogleUrl(isCn, longitude, latitude);
    }

    @Override
    public String[] getFileLatAndLong(String filePath, String[] strType) {
        return FileUtil.getFileLatAndLong(filePath, strType);
    }

    @Override
    public void delAllFile(String path) {
        FileUtil.delAllFile(path);
    }

    @Override
    public void delFolder(String folderPath) {
        FileUtil.delFolder(folderPath);
    }

    @Override
    public int copyFile(String oldPath, String newPath) {
        return FileUtil.copyFile(oldPath, newPath);
    }

    @Override
    public boolean copyInputStreamToFile(InputStream inStream, File file) {
        boolean flag = false;
        try {
            flag = FileUtil.copyInputStreamToFile(inStream, file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    @Override
    public void delFile(String filePathAndName) {
        FileUtil.delFile(filePathAndName);
    }

    @Override
    public boolean isImage(String name) {
        return FileUtil.isImage(name);
    }

    @Override
    public String generateZipFileZdy(String basePath, String zipFileName, String... fileNames) {
        return FileUtil.generateZipFileZdy(basePath, zipFileName, fileNames);
    }

    @Override
    public String getMD5ByInputStream(InputStream inStream) {
        return FileUtil.getMD5ByInputStream(inStream);

    }

    @Override
    public String getMD5ByFilePath(String path) {
        return FileUtil.getMD5ByFilePath(path);
    }

    @Override
    public boolean mkdir(String dir) {
        return FileUtil.mkdir(dir);

    }

    @Override
    public byte[] getFileBytes(String strFilePath) {
        return FileUtil.getFileBytes(strFilePath);

    }
}
