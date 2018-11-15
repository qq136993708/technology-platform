package com.pcitc.web.common;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value="/common/file")
public class FileUtilController 
{
	 @RequestMapping(value="/upload",method=RequestMethod.POST)
     public String upload(HttpServletRequest request,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file) throws Exception {
		 
		 if(file != null){
			 
			 java.io.InputStream input = file.getInputStream();
			 File f = new File("/test.txt");
			 if(!f.exists()){
				 f.createNewFile();
			 }
			 java.io.FileOutputStream fout = new FileOutputStream(f);
			 fout.write(file.getBytes());
			 
			 input.close();
			 fout.flush();
			 fout.close();
		 }
		 
		 return "";
	 }
}
