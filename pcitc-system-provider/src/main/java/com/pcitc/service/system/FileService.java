package com.pcitc.service.system;

import java.io.File;
import java.io.InputStream;

/**
 * @author:Administrator
 * @date:2019/4/28
 */
public interface FileService {

    /**
     * 获取谷歌经纬度
     *
     * @param isCn
     * @param longitude
     * @param latitude
     * @return
     */
    public String getGoogleUrl(boolean isCn, String longitude, String latitude);

    /**
     * 获取图片经纬度
     *
     * @param filePath
     * @param strType  getFileLatAndLong("D:\\files\\uploadPath\\file\\00c7503834434f5c8c2983fe99c1de61\\mobile.jpg",new String[]{strLongitude,strLatitude,"Date/Time"});
     * @return
     */
    public String[] getFileLatAndLong(String filePath, String[] strType);

    /**
     * 删除文件夹里面的所有文件
     *
     * @param path 文件夹路径 如 c:/fqf
     */
    public void delAllFile(String path);

    /**
     * 删除文件夹
     *
     * @param folderPath 文件夹路径及名称 如c:/fqf
     */
    public void delFolder(String folderPath);

    /**
     * 复制单个文件
     *
     * @param oldPath 源文件路径
     * @param newPath 复制后路径
     * @return 文件大小
     */
    public int copyFile(String oldPath, String newPath);

    /**
     * 复制文件流到新的文件
     *
     * @param inStream 文件流
     * @param file     新文件
     * @return 是否复制成功
     */
    public boolean copyInputStreamToFile(final InputStream inStream, File file);

    /**
     * 删除指定路径下的文件
     *
     * @param filePathAndName 文件路径
     */
    public void delFile(String filePathAndName);

    /**
     * 判断文件是否为图片
     *
     * @param name
     * @return
     */
    public boolean isImage(String name);

    /**
     * 压缩文件到指定目录
     *
     * @param basePath    目标文件夹
     * @param zipFileName 目标文件夹名称
     * @param fileNames   待压缩文件
     * @return
     */
    public String generateZipFileZdy(String basePath, String zipFileName, String... fileNames);

    /**
     * 根据文件流获取文件MD5
     *
     * @param inStream
     * @return
     */
    public String getMD5ByInputStream(InputStream inStream);

    /**
     * 根据文件路径获取文件MD5
     *
     * @param path
     * @return
     */
    public String getMD5ByFilePath(String path);

    /**
     * 创建目录
     *
     * @param dir
     * @return
     */
    public boolean mkdir(String dir);

    /**
     * 获取文件输出流
     *
     * @param strFilePath
     * @return
     */
    public byte[] getFileBytes(String strFilePath);
}
