package com.pcitc.service.job;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.pcitc.base.util.DateUtil;
import com.pcitc.utils.OSSUtil;

/**
 * mysql定时备份到oss
 */
public class MysqlTimeBackup implements Job, Serializable {
	private static final long serialVersionUID = 1L;

	public void execute(JobExecutionContext job) throws JobExecutionException {

		System.out.println("==========" + DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "---mysql定时备份到oss");

		String backupFilePath = "/usr/local/backup/mysql/pcitc_stp1-" + DateUtil.dateToStr(new Date(), DateUtil.FMT_DD) + ".zip";
		System.out.println("==========" + backupFilePath + "---定时任务---开始=============");

		File mysqlFile = new File(backupFilePath);
		if (mysqlFile.exists() && mysqlFile.length() > 0) {
			// 判断是否存在这个文件，如果存在，上传到oss固定文件夹
			String uuidFileName = UUID.randomUUID().toString().replace("-", "");
			String path = OSSUtil.uploadFile(new File(backupFilePath), "backup/mysql", uuidFileName + ".zip");
			System.out.println(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "备份文件保存路径到--====" + path);
		} else {
			System.out.println(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS) + "备份文件不存在" );
		}
		
		
		

	}
}
