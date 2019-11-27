//package com.pcitc.service.aspose;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//import java.util.Map;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLEncoder;
//
//import org.apache.log4j.Logger;
//
//import com.caucho.hessian.client.HessianProxyFactory;
//import com.pcitc.imagemanager.cache.model.ImsFile;
//import com.pcitc.imagemanager.domain.remote.ImsLookUrlHessionNew;
//import com.pcitc.schremove.remove.IRemote;
//import com.pcitc.service.We2pdfService;
//import com.pcitc.util.ExcelCaseOfPDF;
//import com.pcitc.util.FileUploadToIms;
//import com.pcitc.util.WordCaseOfPDF;
//
///**
// *
// * urlName="http://localhost:8080/weTopdf/We2pdfService";
// *
// * 项目名称：we2pdf<br>
// * *********************************<br>
// * <P>类名称：We2pdfServiceImpl</P>
// * *********************************<br>
// * <P>类描述：</P>
// * 创建人：Wangdandan<br>
// * 创建时间：2017年8月24日 下午4:37:56<br>s
// * 修改人：Wangdandan<br>
// * 修改时间：2017年8月24日 下午4:37:56<br>
// * 修改备注：<br>
// * @version 1.0.0<br>
// */
//public class We2pdfServiceImpl {
//	private static final Logger log = Logger.getLogger(We2pdfServiceImpl.class);
//	private String urlName;
//	private String imsurl;
//	private String imsport;
//
//	public void setUrlName(String urlName) {
//		this.urlName = urlName;
//	}
//	public String getImsurl() {
//		return imsurl;
//	}
//	public void setImsurl(String imsurl) {
//		this.imsurl = imsurl;
//	}
//	public String getImsport() {
//		return imsport;
//	}
//	public void setImsport(String imsport) {
//		this.imsport = imsport;
//	}
//
//	public boolean word2pdf() {
//		boolean result=false;
//		log.info("Word2pdf#开始转换pdf#");
//		HessianProxyFactory factory = new HessianProxyFactory();
//		//String urlName="http://10.246.109.95:8089/ims/remote/imageUrlNew";
//
//		ImsLookUrlHessionNew service;
//		try {
//			service = (ImsLookUrlHessionNew) factory.create(ImsLookUrlHessionNew.class,urlName);
//			List<ImsFile> imsFiles = service.getImsFileForPdf();
//			//ImsFile imsFile=null;
//			for (ImsFile imsFile : imsFiles) {
//				String fileName = imsFile.getFastdfsPath();
//				String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
//				if (suffix.toLowerCase().contains("doc")) {
//					String downFile = this.downFile(imsFile);
//					if(downFile==null)
//						continue;
//
//					//转为pdf
//					File pdfFile  = WordCaseOfPDF.word2pdf(downFile);
//
//					if (pdfFile == null)
//						continue;
//
//					boolean r = this.fileUpload(pdfFile, imsFile.getBillcode());
//
//					if(r)
//						service.updateConvertState(imsFile.getFile_id(),"2");
//					log.info("Word2pdf#结束转换pdf#");
//					result=true;
//				}else if (suffix.toLowerCase().contains("xls")) {
//					String downFile = this.downFile(imsFile);
//
//					if(downFile==null)
//						continue;
//					//转为pdf
//					File pdfFile = ExcelCaseOfPDF.excel2pdf(downFile);
//					if (pdfFile == null)
//						continue;
//
//					//上传到文件服务器
//					boolean r = this.fileUpload(pdfFile, imsFile.getBillcode());
//
//					//修改转换状态
//					if(r)
//						service.updateConvertState(imsFile.getFile_id(),"2");
//					result=true;
//				}else if (suffix.toLowerCase().contains("pdf")) {
//					String downFile = this.downFile(imsFile);
//
//					if(downFile==null)
//						continue;
//
//					//上传到文件服务器
//					boolean r = this.fileUpload(new File(downFile), imsFile.getBillcode());
//
//					//修改转换状态
//					if(r)
//						service.updateConvertState(imsFile.getFile_id(),"2");
//					result=true;
//				}else {
//					service.updateConvertState(imsFile.getFile_id(),"4");
//					//throw new RuntimeException("文件格式错误");
//					continue;
//				}
//			}
//			return true;
//		} catch (MalformedURLException e) {
//			//service.updateConvertState(imsFile.getFile_id(),"3");
//
//			//TODO:	log exception
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	private String downFile(ImsFile imsFile)  {
//		log.info("downFile#开始下载文件#imsFile:"+"fileName:"+imsFile.getFile_name());
//		String pathstr=null;
//		BufferedInputStream bis=null;
//        BufferedOutputStream bos=null;
//        String fileName=imsFile.getFile_name();
//        String fileUrl=imsFile.getFastdfsPath();
//		try {
//		     URL url = new URL(fileUrl);
//		     HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
//		     connection.setRequestMethod("GET");
//		     connection.connect();
//		     InputStream is = connection.getInputStream();
//
//		     bis = new BufferedInputStream(is);
//		     File file0=new File("./loadFile");
//		     String path = file0.getCanonicalPath();
//		     pathstr = path+"\\"+fileName;
//		     //str = "C://Users/Administrator/Desktop/ok/"+fileName;
//		     File file = new File(pathstr);//名字截取 可以省略
//		     FileOutputStream fos = new FileOutputStream(file);
//		     bos = new BufferedOutputStream(fos);
//		     int b = 0;
//		     byte[] byArr = new byte[1024*4];
//		     while((b=bis.read(byArr))!=-1){
//		         bos.write(byArr, 0, b);
//		     }
//		     log.info("downFile##结束下载文件##imsFileName="+imsFile.getFile_name() + "imsFilePath=" + pathstr);
//		 } catch (Exception e) {
//		     e.printStackTrace();
//		     //TODO: log exception
//		     log.info("downFile#下载失败:");
//		 }finally{
//		     try {
//		         if(bis!=null){
//		             bis.close();
//		         }
//		         if(bos!=null){
//		             bos.close();
//		         }
//		     } catch (IOException e) {
//		         e.printStackTrace();
//		         log.info("downFile#下载失败:");
//		     }
//		 }
//		return pathstr;
//	 }
//
//	private  boolean fileUpload(File file,String billCode)   {
//		log.info("fileUpload#将文件上传至文件服务器中文件#file:"+file+" billCode:"+billCode);
//		//加到配置文件中
//		String uploadip = imsurl;
//		int port = Integer.parseInt(imsport);
//		String fileName = file.getName();
//		fileName = fileName.substring(fileName.indexOf("\\") + 1);
//		try {
//			FileUploadToIms.uploadFileAndSaveName(file, uploadip, "pdf", port, billCode, "sysadmin", "ims", "ims", "2", URLEncoder.encode(fileName.toLowerCase(),"UTF-8"));
//			log.info("fileUpload#结束文件上传至文件服务器中文件#file:"+fileName+" billCode:"+billCode);
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			//log exception
//			log.info("fileUpload#上传失败文件上传异常#fileName:"+fileName+" billCode:"+billCode);
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	@Override
//	public boolean remoteTask(Map<String, String> arg0) {
//		log.info("remoteTask#开始调用定时任务#");
//		return word2pdf();
//	}
//}
//
//
