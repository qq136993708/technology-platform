package com.pcitc.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

public class OSSUtil {
	public static final String ENDPOINT = "http://stp-vpc1-sctepl.oss01-cn-beijing-sinopec-d01-a.yun-inc.sinopec.com";
	public static final String ACCESSKEYID = "B9x4bgsYgpK0Dlgq";
	public static final String ACCESSKEYSECRET = "Qr2xDxl3yxgVVU7ehw3heIgPh68ouy";
	public static final String BUCKET = "stp-vpc1-sctepl";
	public static final String OSSPATH = "http://oss01-cn-beijing-sinopec-d01-a.yun-inc.sinopec.com";
	
	public static void main(String[] args) throws Exception {
		// deleteDoc();
		// FileObject obj = OSSUtil.download("2017_6_29_51.pptx");
		// System.out.println(obj);
		Date date1 = new Date();
		String path = uploadFile(new File("D:/oracle导入.txt"), "test/tem", "txt");
		String temNo = "201702";
		System.out.println("1===="+path);
		Date date2 = new Date();
		
		InputStream tem =  getOssFileIS("test/tem/7119d6a20b6e4bf390fc7ab6f218b267.txt");
		
		String twoPath = uploadFileByInputStream(tem, "test/tem", "txt");
		System.out.println("2====" + tem);
		System.out.println("3====" + twoPath);
	}

	/**
	 * 上传某个文件到oss上，返回保存路径
	 * 
	 * @author zhf
	 * @date 2019年5月15日 上午11:03:48
	 */
	public static String uploadFile(File file, String directory, String postfix) {
		byte[] buffer = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while ((n = fis.read(b)) != -1) {
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
		OSSClient ossClient = null;
		ossClient = new OSSClient(ENDPOINT, ACCESSKEYID, ACCESSKEYSECRET);

		// 在oss存储中的directory（文件夹）下，保存某个文档到这个地方，文件名称为uuid
		String uuid = UUID.randomUUID().toString().replace("-", "") + "." + postfix;
		ossClient.putObject("stp-vpc1-sctepl", directory + "/" + uuid, new ByteArrayInputStream(buffer));
		ossClient.shutdown();
		return OSSPATH + "/stp-vpc1-sctepl/" + directory + "/" + uuid;
	}

	/**
	 * 上传某个文件到oss上，返回保存路径
	 * 
	 * @author zhf
	 * @date 2019年5月15日 上午11:03:48
	 */
	public static String uploadFileByInputStream(InputStream is, String directory, String postfix) {
		String resultStr = null;
		// 在oss存储中的directory（文件夹）下，保存某个文档到这个地方，文件名称为uuid
		String uuidFileName = UUID.randomUUID().toString().replace("-", "") + "." + postfix;
		try {
			int fileSize = is.available();
			// 创建上传Object的Metadata
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(is.available());
			metadata.setCacheControl("no-cache");
			metadata.setHeader("Pragma", "no-cache");
			metadata.setContentEncoding("utf-8");

			// 连接oss
			OSSClient ossClient = null;
			ossClient = new OSSClient(ENDPOINT, ACCESSKEYID, ACCESSKEYSECRET);

			metadata.setContentType(getContentType(uuidFileName));
			metadata.setContentDisposition("filename/filesize=" + uuidFileName + "/" + fileSize + "Byte.");
			PutObjectResult putResult = ossClient.putObject("stp-vpc1-sctepl", directory + uuidFileName, is, metadata);
			// 解析结果
			resultStr = putResult.getETag();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OSSPATH + "/stp-vpc1-sctepl/" + directory + uuidFileName;
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
		if ("bmp".equalsIgnoreCase(fileExtension))
			return "image/bmp";
		if ("gif".equalsIgnoreCase(fileExtension))
			return "image/gif";
		if ("jpeg".equalsIgnoreCase(fileExtension) || "jpg".equalsIgnoreCase(fileExtension) || "png".equalsIgnoreCase(fileExtension))
			return "image/jpeg";
		if ("html".equalsIgnoreCase(fileExtension))
			return "text/html";
		if ("txt".equalsIgnoreCase(fileExtension))
			return "text/plain";
		if ("vsd".equalsIgnoreCase(fileExtension))
			return "application/vnd.visio";
		if ("ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension))
			return "application/vnd.ms-powerpoint";
		if ("doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension))
			return "application/msword";
		if ("xml".equalsIgnoreCase(fileExtension))
			return "text/xml";
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
	 * 创建oss客户端
	 * 
	 * @author zhf
	 * @date 2019年5月15日 上午11:43:14
	 */
	public static OSSClient createOssclient() {

		OSSClient ossClient = null;
		ossClient = new OSSClient(ENDPOINT, ACCESSKEYID, ACCESSKEYSECRET);
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
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	public static void deleteDoc() throws Exception {
		// OSSUtil.delete("21111111.txt");
	}
}
