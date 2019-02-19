package com.pcitc.web.online.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pcitc.base.online.OfficeDocumentConverter;
import com.pcitc.base.online.office.DefaultOfficeManagerConfiguration;
import com.pcitc.base.online.office.OfficeManager;
import com.pcitc.web.online.extend.ControlDocumentFormatRegistry;
import com.sun.star.document.UpdateDocMode;

/**
 * 创建文件转换器
 *
 * @author yudian-it
 * @date 2017/11/13
 */
@Component
public class ConverterUtils {

	@Value("${office.home}")
	String			officeHome;
	// OpenOfficeConnection connection;
	OfficeManager	officeManager;

	@PostConstruct
	public void initOfficeManager() throws IOException, InterruptedException {
		// // connection = new SocketOpenOfficeConnection(host,8100);
		// // connection.connect();
		this.destroyOfficeManager();
		DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
		configuration.setOfficeHome(officeHome);
		configuration.setPortNumber(8100);
		System.out.println("officeManager------------------"+officeManager);

		String osName = System.getProperties().getProperty("os.name");
		System.out.println("系统环境.......-------------"+osName);
		if (osName!=null&&osName.toLowerCase().contains("linux")) {

			Process process = Runtime.getRuntime().exec(new   String[]{"sh","-c","ps -ef | grep soffice"});
			Scanner in = new Scanner(process.getInputStream());
			while (in.hasNextLine()) {
				String processString = in.nextLine();
				System.out.println("进程.......-------------"+processString);
				if (processString.contains("soffice")) {
					// 关闭soffice进程的命令
					String[] cmd ={"sh","-c","killall -9 "};
					process = Runtime.getRuntime().exec(cmd);
					System.out.println("openoffice正常关闭.......");
				}
			}
		} else {
			// 显示进程
			Process process = Runtime.getRuntime().exec("tasklist");
			Scanner in = new Scanner(process.getInputStream());
			while (in.hasNextLine()) {
				String processString = in.nextLine();
				System.out.println("进程.......-------------"+processString);
				if (processString.contains("soffice")) {
					// 关闭soffice进程的命令
					String cmd = "taskkill /f /im soffice.bin";
					process = Runtime.getRuntime().exec(cmd);
					System.out.println("openoffice正常关闭.......");
				}
			}
		}

		Thread.sleep(1000);

		officeManager = configuration.buildOfficeManager();
		officeManager.start();
		// 设置任务执行超时为5分钟
		// configuration.setTaskExecutionTimeout(1000 * 60 * 5L);//
		// 设置任务队列超时为24小时
		// configuration.setTaskQueueTimeout(1000 * 60 * 60 * 24L);//
	}

	public OfficeDocumentConverter getDocumentConverter() {
		OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager, new ControlDocumentFormatRegistry());
		converter.setDefaultLoadProperties(getLoadProperties());
		return converter;
	}

	private Map<String, ?> getLoadProperties() {
		Map<String, Object> loadProperties = new HashMap<>(10);
		loadProperties.put("Hidden", true);
		loadProperties.put("ReadOnly", true);
		loadProperties.put("UpdateDocMode", UpdateDocMode.QUIET_UPDATE);
		loadProperties.put("CharacterSet", Charset.forName("UTF-8").name());
		return loadProperties;
	}

	@PreDestroy
	public void destroyOfficeManager() {
		if (null!=officeManager&&officeManager.isRunning()) {
			officeManager.stop();
		}
	}

}
