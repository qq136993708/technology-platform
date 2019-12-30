package com.pcitc.web.utils;

import com.pcitc.base.common.FileModel;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.MyBeanUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * @author zhf
 * 文件操作公共类
 */
@Component
public class FileUtil {

    @Value("${baseFilePath}")
    private String fileBasePath;

    private static String seed ="kjptFile";

    private static String key;

    //private static Key key;

    static {
        try {
             key = AESFileUtils.getSecretKey(seed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
     * 文件上传
     */
    public FileModel upload(MultipartFile file) throws Exception {

        FileModel fm = new FileModel();
        String fileName = "";
        String[] fileNames  =file.getOriginalFilename().split("\\\\");
        if (fileNames.length > 0) {
            fileName = fileNames[fileNames.length - 1];
        }
        String id = UUID.randomUUID().toString().replace("-","");
        String  relativePath= "/"+DateUtil.format(new Date(),"yyyyMM");

        fm.setId(id);


        File targetFile = new File(getFilePath(relativePath)+"/"+id);
        if (targetFile.exists())
        {
            targetFile.delete();
        }
        //file.transferTo(targetFile);
        //文件加密
        ///////////////////////////
        byte[] encryptByte;
        encryptByte = AESFileUtils.encrypt(file.getBytes(),key);
        OutputStream output = new FileOutputStream(targetFile);

        BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);

        bufferedOutput.write(encryptByte);
        /////////////////////////////

        fm.setFileName(fileName);
        fm.setCreateDate(new Date());
        fm.setFileSize(file.getSize());
        fm.setType(file.getContentType());
        //fm.setFilePath(relativePath+"/"+id+"."+fileName.split("\\.")[1]);
        fm.setFilePath(relativePath+"/"+id);
        //上传附件
        return fm;
    }

    /**
     *获取文件存储路径
     * @return
     */
    private String getFilePath(String path){
        String dirPath = fileBasePath;

        File file =new File(dirPath+path);
        if  (!file .exists()  && !file .isDirectory())
        {
            file.mkdirs();
        }
        return dirPath+path;
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

    /**
     * 复制文件流到新的文件
     *
     * @param inStream 文件流
     * @param file     新文件
     * @return 是否复制成功
     */
    public static boolean copyInputStreamToFile(final InputStream inStream, File file) throws IOException {
        int byteread = 0;
        byte[] buffer = new byte[1024];
        FileOutputStream fs = new FileOutputStream(file);
        while ((byteread = inStream.read(buffer)) != -1) {
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
                System.out.println("The file" + name + "could not be opened , it is not an image");
            }
        } catch (IOException ex) {
            valid = false;
            System.out.println("The file" + name + "could not be opened , an error occurred.");
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
        }catch (IOException ex){
            return null;
        }
    }
    /**
     * 响应客户端文件下载请求
     * @param file
     * @param res
     */
    public static void fileDownload(File file,HttpServletResponse res)
    {


        OutputStream out = null;
        InputStream in = null;
        try
        {
            res.setHeader("content-type", "application/octet-stream");
            res.setContentType("application/octet-stream");
            res.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));

            out = res.getOutputStream();
            in = new FileInputStream(file);

            byte[] b = new byte[1000];
            int len;
            while ((len = in.read(b)) > 0)
            {
                out.write(b, 0, len);
            }
            out.flush();
            closeIO(in);
            closeIO(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 响应客户端文件下载请求
     * @param file
     * @param res
     */
    public static void prepare(File file,HttpServletResponse res,String contentType) throws Exception {

        OutputStream out;
        InputStream in;
        try
        {
            res.setContentType(contentType);
            out = res.getOutputStream();
            in = new FileInputStream(file);

            AESFileUtils.downLoadDecryptFile(key,in,out);

//            byte[] b = new byte[1000];
//            int len;
//            while ((len = in.read(b)) > 0)
//            {
//                out.write(b, 0, len);
//            }
//            out.flush();
//            closeIO(in);
//            closeIO(out);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 响应附件
     * @param f
     * @param isAttachment
     * @param res
     */
    public void responseFile(FileModel f, boolean isAttachment,HttpServletResponse res) throws Exception {
        res.setContentType(f.getType());
        res.setContentLengthLong(f.getFileSize());
        res.setCharacterEncoding("UTF-8");
        File file = new File(getFilePath(f.getFilePath()));
        if(file.exists()==true && file!=null)
        {
            if(isAttachment) {
                String fileName = (f.getFileName() == null) ? "download" : new String(f.getFileName().getBytes("gb2312"),"iso-8859-1");
                res.addHeader("Content-Disposition", "attachment;fileName="  + fileName);
            }
            InputStream in = new FileInputStream(file);
            //输出
            OutputStream os = res.getOutputStream();
            //解密输出
            AESFileUtils.downLoadDecryptFile(key,in,os);
        }


    }

    /**
     * 关闭IO
     * @param io
     */
    public static void closeIO(Closeable io)
    {
        if(io != null)
        {
            try
            {
                io.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    /**
     * 读取配置文件
     * @param path
     * @return
     */
    public static Properties readPropertis(File file)
    {
        Properties pro = new Properties();
        try {
            FileInputStream in = new FileInputStream(file);
            pro.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pro;
    }
    public static void genFileTemplate(String tempName,String genPath,String genName,Map<String, Object> dataMap) {
        try
        {
            Configuration config = new Configuration(Configuration.VERSION_2_3_26);
            config.setClassForTemplateLoading(FileUtil.class, dataMap.get("tempPath").toString());
            Template template = config.getTemplate(tempName);
            FileOutputStream fos = new FileOutputStream(new File(genPath+File.separator+genName));
            Writer out = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"), 10240);
            template.process(dataMap, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //生成controller 类
    public static void createControllerByTemplate()
    {
        URL url = FileUtil.class.getResource("/");
        File f = new File(url.getPath() + "static/code_template/template_config.properties");
        Properties p = readPropertis(f);
        String genPath = p.get("projectPath").toString()+p.get("packagePath").toString();
        String genName = p.get("beanName")+"Controller.java";
        String tempName = p.get("tempName").toString();
        genFileTemplate(tempName,genPath,genName,MyBeanUtils.java2Map(p));
    }

    //生成Provider 类
    public static void createProviderByTemplate()
    {
        URL url = FileUtil.class.getResource("/");
        File f = new File(url.getPath() + "static/code_template/template_config.properties");
        Properties p = readPropertis(f);
        String genPath = p.get("clientProjectPath").toString()+p.get("clientPackagePath").toString();
        String genName = p.get("beanName")+"ProviderClient.java";
        String tempName = p.get("clientTempName").toString();
        genFileTemplate(tempName,genPath,genName,MyBeanUtils.java2Map(p));
    }
    //生成Service 类
    public static void createServiceByTemplate()
    {
        URL url = FileUtil.class.getResource("/");
        File f = new File(url.getPath() + "static/code_template/template_config.properties");
        Properties p = readPropertis(f);
        String genPath = p.get("svcProjectPath").toString()+p.get("svcPackagePath").toString();
        String genName = p.get("beanName")+"Service.java";
        String tempName = p.get("svcTempName").toString();
        genFileTemplate(tempName,genPath,genName,MyBeanUtils.java2Map(p));
    }
    //生成Service 类
    public static void createServiceImplByTemplate()
    {
        URL url = FileUtil.class.getResource("/");
        File f = new File(url.getPath() + "static/code_template/template_config.properties");
        Properties p = readPropertis(f);
        String genPath = p.get("svcImplProjectPath").toString()+p.get("svcImplPackagePath").toString();
        String genName = p.get("beanName")+"ServiceImpl.java";
        String tempName = p.get("svcImplTempName").toString();
        genFileTemplate(tempName,genPath,genName,MyBeanUtils.java2Map(p));
    }
    public static void main(String [] args)
    {
        //createControllerByTemplate();
        createProviderByTemplate();
        createServiceByTemplate();
        createServiceImplByTemplate();

    }
}
