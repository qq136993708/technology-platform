package com.pcitc.web.common;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadProviderClient 
{

	@RequestMapping(value = "/stp-provider/common/file-upload", method = RequestMethod.POST)
	public Integer selectPlantByPage(MultipartFile [] files) throws IllegalStateException, IOException 
	{
		for(MultipartFile file:files)
		{
			File targetFile = new File("D://"+file.getName());
			if (targetFile.exists()) 
			{
				targetFile.delete();
			}
			file.transferTo(targetFile);
		}
		//test send mail
		return 0;
	}
}
