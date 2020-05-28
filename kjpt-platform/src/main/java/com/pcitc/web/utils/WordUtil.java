package com.pcitc.web.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.ClassUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

public class WordUtil {
	/**
	 * @param dataMap
	 *            word中需要展示的动态数据，用map集合来保存
	 * @param templateName
	 *            word模板名称，例如：teample.ftl
	 * @param filePath
	 *            文件生成的目标路径，例如：D:/
	 * @param fileName
	 *            生成的文件名称
	 */
	@SuppressWarnings("unchecked")
	public static boolean createWord(Map dataMap, String templateName, String filePath, String fileName) {
		boolean flag=true;
		try {
			
			System.out.println("---------------文件生成的目标路径:"+filePath);
			
			// 创建配置实例
			Configuration configuration = new Configuration();

			// 设置编码
			configuration.setDefaultEncoding("UTF-8");
			configuration.setClassicCompatible(true);

			// ftl模板文件
			File file = new File("src/main/resources/tem/ftl");
			System.out.println("--------------ftl模板文件路径:"+file.getPath());
			// configuration.setClassForTemplateLoading(WordUtil.class, "ftl");
			configuration.setDirectoryForTemplateLoading(file);

			// 获取模板
			Template template = configuration.getTemplate(templateName);

			// 输出文件
			File outFile = new File(filePath+fileName);

			// 如果输出目标文件夹不存在，则创建
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}

			// 将模板和数据模型合并生成文件
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

			// 生成文件
			template.process(dataMap, out);

			// 关闭流
			out.flush();
			out.close();
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
        return flag;
	}
	
	
	//根据模板生成文件
	@SuppressWarnings("unchecked")
	public static boolean createWord_new(HttpServletRequest request,Map dataMap, String templateName,  String fileName) {
		boolean flag=true;
		try {
			
			System.out.println("---------------目标文件生成的fileName="+fileName);
			
			//获取classes目录绝对路径
			System.out.println("--------------classes目录绝对路径:"+ClassUtils.getDefaultClassLoader().getResource("").getPath());
			// 创建配置实例
			Configuration configuration = new Configuration();
			String resourcePath=ClassUtils.getDefaultClassLoader().getResource("").getPath();

			// 设置编码
			configuration.setDefaultEncoding("UTF-8");
			configuration.setClassicCompatible(true);

			// ftl模板文件
			//File file = new File("src/main/resources/tem/ftl");
			File file = new File(resourcePath,"tem/ftl");
			System.out.println("--------------ftl模板文件路径:"+file.getPath());
			// configuration.setClassForTemplateLoading(WordUtil.class, "ftl");
			configuration.setDirectoryForTemplateLoading(file);

			// 获取模板
			Template template = configuration.getTemplate(templateName);

			// 输出文件
			//File outFile = new File(filePath+fileName);
			File outFile = new File(resourcePath,"tem/"+fileName);
			System.out.println("-------------输出文件路径:"+outFile.getPath());
			// 如果输出目标文件夹不存在，则创建
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}

			// 将模板和数据模型合并生成文件
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

			// 生成文件
			template.process(dataMap, out);

			// 关闭流
			out.flush();
			out.close();
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
        return flag;
	}
	
	
	//下载的文件
	public static HttpServletResponse download_new(String fileName, HttpServletResponse response) 
	{
        try {
        	String resourcePath=ClassUtils.getDefaultClassLoader().getResource("").getPath();
        	System.out.println("--------------要下载的文件:"+resourcePath+"tem/"+fileName);
            File file = new File(resourcePath,"tem/"+fileName);
            // 取得文件名。
            String file_name = file.getName();
            // 取得文件的后缀名。
            System.out.println("--------------以流的形式下载文件:"+resourcePath+"tem/"+file_name);
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(resourcePath+"tem/"+file_name));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(file_name.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }

	
	 //删除文件
	 public static  boolean deleteFile_new(String fileName)
	 {
	        //File file = new File(fileName);
		    String resourcePath=ClassUtils.getDefaultClassLoader().getResource("").getPath();
	        File file = new File(resourcePath,"tem/"+fileName);
	        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	        if (file.exists() && file.isFile())
	        {
	            if (file.delete())
	            {
	                System.out.println("删除单个文件" + fileName + "成功！");
	                return true;
	            } else 
	            {
	                System.out.println("删除单个文件" + fileName + "失败！");
	                return false;
	            }
	        } else 
	        {
	            System.out.println("删除单个文件失败：" + fileName + "不存在！");
	            return false;
	        }
	    }


	/**
	 * 将图片转换为BASE64为字符串
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static String getImageString(String filename) throws IOException {
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(filename);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			throw e;
		} finally {
			if (in!=null) in.close();
		}
        return data != null ? java.util.Base64.getEncoder().encodeToString(data) : "";  
	}
}
