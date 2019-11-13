package com.pcitc.base.util;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectoryBase;


/**
 * @author zhf
 * 文件操作公共类
 */
public class FileUtil {

    /**
     * 删除文件夹里面的所有文件
     *
     * @param path 文件夹路径 如 c:/fqf
     */
    public static void delAllFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);// 再删除空文件夹
            }
        }
    }

    /**
     * 删除文件夹
     *
     * @param folderPath 文件夹路径及名称 如c:/fqf
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); // 删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); // 删除空文件夹

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 复制单个文件
     *
     * @param oldPath 源文件路径
     * @param newPath 复制后路径
     * @return 文件大小
     */
    public static int copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) {
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
                fs.close();
            }
            return bytesum;
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
            return 0;
        }
    }

//    public static void main(String[] args) {
//        File file = new File("D:\\files\\uploadPath\\file\\upload\\a.txt");
//        try {
//        getFileBytes("D:\\files\\uploadPath\\file\\upload\\a.txt");
//            FileInputStream fis = new FileInputStream(file);
//            copyInputStreamToFile(fis,file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 复制文件流到新的文件
     *
     * @param inStream 文件流
     * @param file     新文件
     * @return 是否复制成功
     */
    public static boolean copyInputStreamToFile(final InputStream inStream, File file) throws IOException {
        Integer bytesum = 0;
        Integer byteread = 0;
        byte[] buffer = new byte[1024];
        FileOutputStream fs = new FileOutputStream(file);
        while ((byteread = inStream.read(buffer)) != -1) {
            bytesum += byteread; //字节数 文件大小
            fs.write(buffer, 0, byteread);
        }
        inStream.close();
        fs.close();
        return true;
    }

    /**
     * 删除指定路径下的文件
     *
     * @param filePathAndName 文件路径
     */
    public static void delFile(String filePathAndName) {
        try {
            String filePath = filePathAndName;
            filePath = filePath.toString();
            java.io.File myDelFile = new java.io.File(filePath);
            myDelFile.delete();

        } catch (Exception e) {
            System.out.println("删除文件操作出错");
            e.printStackTrace();
        }

    }

    /**
     * 判断文件是否是图像文件
     */
    public static boolean isImage(String name) {
        boolean valid = true;
        try {
            Image image = ImageIO.read(new File(name));
            if (image == null) {
                valid = false;
            }
        } catch (IOException ex) {
            valid = false;
        }
        return valid;
    }


    public static String generateZipFile(String basePath, String zipFileName, String... fileNames) {
        byte[] buffer = new byte[1024];
        String strZipName = basePath + zipFileName;
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(strZipName));
            for (String fileName : fileNames) {
                File file = new File(basePath + fileName);
                FileInputStream fis = new FileInputStream(file);
                out.putNextEntry(new ZipEntry(file.getName()));
                int len;
                //读入需要下载的文件的内容，打包到zip文件

                while ((len = fis.read(buffer)) > 0) {

                    out.write(buffer, 0, len);

                }
                out.closeEntry();
                fis.close();
            }
            out.close();
            return strZipName;
        } catch (IOException ex) {
            return null;
        }
    }

    public static String generateZipFileZdy(String basePath, String zipFileName, String... fileNames) {
        byte[] buffer = new byte[1024];
        String strZipName = basePath + zipFileName;
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(strZipName));
            for (String fileName : fileNames) {
                if (fileName == null || "".equals(fileName)) {
                    continue;
                }
                File file = new File(fileName);
                FileInputStream fis = new FileInputStream(file);
                out.putNextEntry(new ZipEntry(file.getName()));
                int len;
                //读入需要下载的文件的内容，打包到zip文件

                while ((len = fis.read(buffer)) > 0) {

                    out.write(buffer, 0, len);

                }
                out.closeEntry();
                fis.close();
            }
            out.close();
            return strZipName;
        } catch (IOException ex) {
            return null;
        }
    }

    public static byte[] getFileBytes(String strFilePath) {
        // 定义一个输入流对象
        FileInputStream fis = null;
        byte[] buffer = null;
        // 定义一个存放输入流的缓冲对象
        BufferedInputStream bis = null;
        // 定义一个输出流，相当StringBuffer（），会根据读取数据的大小，调整byte的数组长度
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            // 把文件路径和文件名作为参数 告诉读取流
            fis = new FileInputStream(strFilePath);
            // 把文件读取流对象传递给缓存读取流对象
            bis = new BufferedInputStream(fis);
            // 获得缓存读取流开始的位置
            int len = bis.read();
            // 定义一个容量来盛放数据
            byte[] buf = new byte[1024];
            while ((len = bis.read(buf)) != -1) {
                // 如果有数据的话，就把数据添加到输出流
                //这里直接用字符串StringBuffer的append方法也可以接收
                baos.write(buf, 0, len);
//                System.out.println(new String(baos.toByteArray(), "utf-8"));
            }
            // 把文件输出流的数据，放到字节数组
            buffer = baos.toByteArray();
            // 打印输出
            System.out.println(new String(buffer, "utf-8"));
            System.out.println("----------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭所有的流
                baos.close();
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return buffer;
    }

    /**
     * 创建目录
     *
     * @param dir
     */
    public static boolean mkdir(String dir) {
        boolean retVal = false;
        String dirTemp = dir;
        File dirPath = new File(dirTemp);
        if (!dirPath.exists()) {
            retVal = dirPath.mkdirs();
        }
        return retVal;
    }


    /**
     * 获取文件MD5
     * @param path
     * @return
     */
    public static String getMD5ByFilePath(String path) {
        BigInteger bi = null;
        try {
            byte[] buffer = new byte[8192];
            int len = 0;
            MessageDigest md = MessageDigest.getInstance("MD5");
            File f = new File(path);
            FileInputStream fis = new FileInputStream(f);
            while ((len = fis.read(buffer)) != -1) {
                md.update(buffer, 0, len);
            }
            fis.close();
            byte[] b = md.digest();
            bi = new BigInteger(1, b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi.toString(16);
    }
    /**
     * 获取文件MD5
     * @param inStream
     * @return
     */
    public static String getMD5ByInputStream(InputStream inStream) {
        BigInteger bi = null;
        try {
            byte[] buffer = new byte[8192];
            int len = 0;
            MessageDigest md = MessageDigest.getInstance("MD5");
            while ((len = inStream.read(buffer)) != -1) {
                md.update(buffer, 0, len);
            }
            inStream.close();
            byte[] b = md.digest();
            bi = new BigInteger(1, b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return bi.toString(16);
        }
    }

    public static String getFileCreate(){
        return "" ;
    }

    /**
     * 获取图片经纬度
     * @param filePath
     * @param strType
     * @return
     */
    public static String[] getFileLatAndLong(String filePath,String[] strType){
        File jpegFile = new File(filePath);
        Metadata metadata = null;
        String[] strVals = new String[strType.length];
        try {
            metadata = JpegMetadataReader.readMetadata(jpegFile);
            Directory exif =metadata.getFirstDirectoryOfType(ExifDirectoryBase.class);
            String model = exif.getString(ExifDirectoryBase.TAG_DATETIME);
//            System.out.println(exif.getString(ExifDirectoryBase.TAG_DATETIME));
//            System.out.println(exif.getString(ExifDirectoryBase.TAG_X_RESOLUTION));
//            System.out.println(exif.getString(ExifDirectoryBase.TAG_Y_RESOLUTION));
            for(Directory directory : metadata.getDirectories()){
                for(Tag tag : directory.getTags()){
                    System.out.println(" " + tag.getTagName() + "  -->"+ tag.getDescription()+"  "+tag.getTagTypeHex()+"  "+tag.getTagType());
                    for (int i = 0; i < strType.length; i++) {
                        if(strType[i].equals(tag.getTagName())){
                            strVals[i] = tag.getDescription();
                        }
                    }
                }
            }
        } catch (JpegProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return strVals;
        }
    }

    public static String getGoogleUrl(boolean isCn, String longitude,String latitude) {
        if (!isCn) {
            return "http://maps.google.com/maps/api/geocode/json?latlng="+latitude+","+longitude+"&sensor=false&language="
                    + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
        } else {
            return "http://ditu.google.cn/maps/api/geocode/json?latlng="+latitude+","+longitude+"&sensor=false&language="
                    + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
        }
    }
    /**
	 * 
	 * @param fs
	 * @param path
	 * @param includeDir 是否包含文件夹
	 * @return
	 */
	public static List<File> findAllFiles(String path)
	{
		return findAllFiles(null,path,true);
	}
	/**
	 * 
	 * @param fs
	 * @param path
	 * @param includeDir 是否包含文件夹
	 * @return
	 */
	public static List<File> findAllFiles(List<File> fs, String path)
	{
		return findAllFiles(fs,path,true);
	}
	/**
	 * 查找目录下的所有文件
	 * 
	 * @param Path
	 * @return
	 */
	public static List<File> findAllFiles(List<File> fs, String path,Boolean includeDir)
	{
		if (fs == null)
		{
			fs = new ArrayList<File>();
		}
		File file = new File(path);
		if (file.exists() && includeDir)
		{
			fs.add(file);
		}
		if(file.exists() && !includeDir && file.isFile())
		{
			fs.add(file);
		}
		
		if (file.exists() && file.isDirectory())
		{
			File[] files = file.listFiles();
			for (File f : files)
			{
				if (f.isFile())
				{
					fs.add(f);
				} else
				{
					findAllFiles(fs, f.getAbsolutePath());
				}
			}
		}
		return fs;
	}
    public static void main(String[] args) throws ParseException {
        String strLongitude = "GPS Longitude";//经度
        String strLatitude   = "GPS Latitude";//纬度
        String[] s = getFileLatAndLong("D:\\files\\uploadPath\\file\\00c7503834434f5c8c2983fe99c1de61\\mobile.jpg",new String[]{strLongitude,strLatitude,"Date/Time"});
//        System.out.println(s[2]);
                String result = getGoogleUrl(true,"116° 25' 57.25\"","39° 55' 20.02\"");
        System.out.println(result);

//                String str = "星期一 十月 08 15:25:03 +08:00 2018";
//                String str = "十月 08 15:25:03 +08:00 2018";
//                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM ddHH:mm:ss 'GMT' yyyy");
//        System.out.println(sdf.parse(str));
//        String strCjsj = "2018-04-02T00:35:36.201Z";
//        strCjsj = DateUtil.dateToStr(DateUtil.strToDate(strCjsj,DateUtil.FMT_YMDTHMS),DateUtil.FMT_SS);
//        System.out.println(strCjsj);
//            System.out.println(formatter.parse(strCjsj));
//            System.out.println(DateUtil.dateToStr(formatter.parse(strCjsj),DateUtil.FMT_SS));



    }
}
