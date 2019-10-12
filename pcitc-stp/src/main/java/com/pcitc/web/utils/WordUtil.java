package com.pcitc.web.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

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
	
	
	
	@SuppressWarnings("unchecked")
	public static boolean createWord_new(HttpServletRequest request,Map dataMap, String templateName, String filePath, String fileName) {
		boolean flag=true;
		try {
			
			String realPath=request.getSession().getServletContext().getRealPath("/");
			System.out.println("---------------文件生成的目标路径:"+filePath+"fileName="+fileName);
			
			//获取classes目录绝对路径
			String path = ResourceUtils.getURL("classpath:").getPath();
			System.out.println("--------------获取classes目录绝对路径:"+filePath+"  ==:"+ClassUtils.getDefaultClassLoader().getResource("").getPath());
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
			System.out.println("-------------输出文件路径:"+filePath+fileName+" outFile.getPath"+outFile.getPath());
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
