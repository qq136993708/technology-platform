package com.pcitc.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

public class OSSUtil {
	public static final String	ENDPOINT		= "http://stp-vpc1-sctepl.oss01-cn-beijing-sinopec-d01-a.yun-inc.sinopec.com";
	public static final String	ACCESSKEYID		= "B9x4bgsYgpK0Dlgq";
	public static final String	ACCESSKEYSECRET	= "Qr2xDxl3yxgVVU7ehw3heIgPh68ouy";
	public static final String	BUCKET			= "stp-vpc1-sctepl";
	public static final String	OSSPATH			= "http://oss01-cn-beijing-sinopec-d01-a.yun-inc.sinopec.com";

	public static void main(String[] args) throws Exception {
		// deleteDoc();
		// FileObject obj = OSSUtil.download("2017_6_29_51.pptx");
		// System.out.println(obj);
		Date date1 = new Date();
		String uuidFileName = UUID.randomUUID().toString().replace("-", "");
		String path = uploadFile(new File("D:/oracle导入.txt"), "test/tem", uuidFileName+".txt");
		String temNo = "201702";
		System.out.println("1===="+path);
		// deleteOssFile("test/tem/"+uuidFileName+".txt");

		InputStream tem = getOssFileIS("test/tem/"+uuidFileName+".txt");
		System.out.println("2===="+tem);

		String twoPath = uploadFileByInputStream(tem, "test/tem/ttt/", UUID.randomUUID().toString().replace("-", "")+".txt");
		System.out.println("3===="+twoPath);

		InputStream tem4 = getOssFileIS(path.split(OSSPATH+"/"+BUCKET+"/")[1]);
		System.out.println("4===="+tem4);
	}

	/**
	 * 上传某个文件到oss上，返回保存路径 uuidFileName包含后缀
	 * 
	 * @author zhf
	 * @date 2019年5月15日 上午11:03:48
	 */
	public static String uploadFile(File file, String directory, String uuidFileName) {
		byte[] buffer = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while ((n = fis.read(b))!=-1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 连接oss
		OSSClient ossClient = new OSSClient(ENDPOINT, ACCESSKEYID, ACCESSKEYSECRET);

		// 在oss存储中的directory（文件夹）下，保存某个文档到这个地方，文件名称为uuidFileName
		ossClient.putObject(BUCKET, directory+"/"+uuidFileName, new ByteArrayInputStream(buffer));
		ossClient.shutdown();
		return OSSPATH+"/"+BUCKET+"/"+directory+"/"+uuidFileName;
	}

	/**
	 * 上传某个文件到oss上，返回保存路径 uuidFileName包含后缀
	 * 
	 * @author zhf
	 * @date 2019年5月15日 上午11:03:48
	 */
	public static String uploadFileByInputStream(InputStream inputStream, String directory, String uuidFileName) {
		String resultStr = null;
		try {
			int fileSize = inputStream.available();
			// 创建上传Object的Metadata
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(inputStream.available());
			metadata.setCacheControl("no-cache");
			metadata.setHeader("Pragma", "no-cache");
			metadata.setContentEncoding("utf-8");

			// 连接oss
			OSSClient ossClient = new OSSClient(ENDPOINT, ACCESSKEYID, ACCESSKEYSECRET);

			metadata.setContentType(getContentType(uuidFileName));
			metadata.setContentDisposition("filename/filesize="+uuidFileName+"/"+fileSize+"Byte.");
			PutObjectResult putResult = ossClient.putObject(BUCKET, directory+uuidFileName, inputStream, metadata);
			// 解析结果
			resultStr = putResult.getETag();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OSSPATH+"/"+BUCKET+"/"+directory+uuidFileName;
	}

	/**
	 * 通过文件名判断并获取OSS服务文件上传时文件的contentType
	 * 
	 * @param fileName
	 *            文件名
	 * @return 文件的contentType
	 */
	public static final String getContentType(String fileName) {
		String fileExtension = fileName.substring(fileName.lastIndexOf("."));
		if ("bmp".equalsIgnoreCase(fileExtension)) return "image/bmp";
		if ("gif".equalsIgnoreCase(fileExtension)) return "image/gif";
		if ("jpeg".equalsIgnoreCase(fileExtension)||"jpg".equalsIgnoreCase(fileExtension)||"png".equalsIgnoreCase(fileExtension)) return "image/jpeg";
		if ("html".equalsIgnoreCase(fileExtension)) return "text/html";
		if ("txt".equalsIgnoreCase(fileExtension)) return "text/plain";
		if ("vsd".equalsIgnoreCase(fileExtension)) return "application/vnd.visio";
		if ("ppt".equalsIgnoreCase(fileExtension)||"pptx".equalsIgnoreCase(fileExtension)) return "application/vnd.ms-powerpoint";
		if ("doc".equalsIgnoreCase(fileExtension)||"docx".equalsIgnoreCase(fileExtension)) return "application/msword";
		if ("xml".equalsIgnoreCase(fileExtension)) return "text/xml";
		return "text/html";
	}

	/**
	 * 获取oss上某个文件的输入流
	 * 
	 * @author zhf
	 * @date 2019年5月15日 上午11:43:53
	 */
	public static InputStream getOssFileIS(String key) throws Exception {
		OSSClient ossClient = createOssclient();
		OSSObject ossObject = ossClient.getObject(BUCKET, key);
		InputStream in = ossObject.getObjectContent();
		return in;
	}

	/**
	 * 删除某个文件
	 * 
	 * @author zhf
	 * @date 2019年5月15日 上午11:43:53
	 */
	public static String deleteOssFile(String key) throws Exception {
		OSSClient ossClient = createOssclient();
		ossClient.deleteObject(BUCKET, key);
		return "true";
	}

	/**
	 * 创建oss客户端
	 * 
	 * @author zhf
	 * @date 2019年5月15日 上午11:43:14
	 */
	public static OSSClient createOssclient() {

		OSSClient ossClient = new OSSClient(ENDPOINT, ACCESSKEYID, ACCESSKEYSECRET);
		return ossClient;
	}

	/**
	 * 从输入流中获取字节数组
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer))!=-1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	/**
	 * 下载多个文件成zip
	 * fileNames是上传后的文件全路径，类似：http://oss01-cn-beijing-sinopec-d01-a.yun-inc.sinopec.com/stp-vpc1-sctepl/files/uploadPath/modelFile/20190517100724118_file_16ac38b3fd6_6a8d8f58.bpmn 需要处理一下
	 * 
	 * @return
	 */
	public static String generateZipFile(String basePath, String zipFileName, String... fileNames) {
		byte[] buffer = new byte[1024];
		String zipFilePath = "";
		try {
			// 创建临时文件
			File zipFile = File.createTempFile(zipFileName, ".zip");
			FileOutputStream f = new FileOutputStream(zipFile);
			/**
			 * 作用是为任何OutputStream产生校验和 第一个参数是制定产生校验和的输出流，第二个参数是指定Checksum的类型
			 * （Adler32（较快）和CRC32两种）
			 */
			CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
			
			// 用于将数据压缩成Zip文件格式
			ZipOutputStream zos = new ZipOutputStream(csum);

			for (String fileName : fileNames) {
				if (fileName==null||"".equals(fileName)) {
					continue;
				}
				System.out.println("fileName------------"+fileName);
				InputStream fis = getOssFileIS(basePath+"/"+fileName);
				zos.putNextEntry(new ZipEntry(fileName));
				int len;
				// 读入需要下载的文件的内容，打包到zip文件
				while ((len = fis.read(buffer))>0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
			// 把压缩后的文件上传到oss服务器
			zipFilePath = uploadFile(zipFile, basePath, zipFileName);
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		
		return zipFilePath;
	}

	public static void deleteDoc() throws Exception {
		// OSSUtil.delete("21111111.txt");
	}
}
