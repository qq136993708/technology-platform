package com.pcitc.web.online.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcitc.web.common.BaseController;
import com.pcitc.web.online.service.FilePreview;
import com.pcitc.web.online.service.FilePreviewFactory;
import com.pcitc.web.online.utils.FileUtils;

/**
 * @author yudian-it
 */
@Controller
public class OnlinePreviewController extends BaseController {

	@Autowired
	FilePreviewFactory			previewFactory;

	@Autowired
	FileUtils					fileUtils;

	private static final String	FileDownload	= "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/download/";

	/**
	 * @param url
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/onlinePreview")
	public String onlinePreview(HttpServletRequest req, Model model) {

		// 根据文件id，从后台获取文件流，根据文件类型，转换此文件流（生成对应类型的文件，用于前台显示）
		String fileId = req.getParameter("fileId");
		String fileType = req.getParameter("fileType");
		// 测试值
		fileId = "16537793944_8bd9a039";
		fileType = "docx";
		String fileName = UUID.randomUUID().toString().replaceAll("-", "")+"."+fileType;
		MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
		form.add("id", fileId);
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, this.httpHeaders);
		ResponseEntity<byte[]> fileStream = this.restTemplate.postForEntity(FileDownload+fileId, httpEntity, byte[].class);
		byte[] fileByte = fileStream.getBody();
		System.out.println("1================2222"+fileByte);
		// 把文件流复制到 此服务的 静态路径下
		fileUtils.writeFile(fileByte, fileName);
		
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/";

		System.out.println("1================2222"+basePath);
		String url = basePath+fileName;
		System.out.println("1================"+url);
		req.setAttribute("fileKey", req.getParameter("fileKey"));

		System.out.println("2================"+req.getParameter("fileKey"));
		FilePreview filePreview = previewFactory.get(url);

		String fileShow = filePreview.filePreviewHandle(url, model);
		System.out.println("3================"+fileShow);
		System.out.println("4================"+model.asMap().get("pdfUrl"));
		return "/online/"+fileShow;
	}

	/**
	 * 多图片切换预览
	 *
	 * @param model
	 * @param req
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "picturesPreview", method = RequestMethod.GET)
	public String picturesPreview(String urls, String currentUrl, Model model, HttpServletRequest req) throws UnsupportedEncodingException {
		// 路径转码
		String decodedUrl = URLDecoder.decode(urls, "utf-8");
		String decodedCurrentUrl = URLDecoder.decode(currentUrl, "utf-8");
		// 抽取文件并返回文件列表
		String[] imgs = decodedUrl.split("\\|");
		List imgurls = Arrays.asList(imgs);
		model.addAttribute("imgurls", imgurls);
		model.addAttribute("currentUrl", decodedCurrentUrl);
		return "picture";
	}

	@RequestMapping(value = "picturesPreview", method = RequestMethod.POST)
	public String picturesPreview(Model model, HttpServletRequest req) throws UnsupportedEncodingException {
		String urls = req.getParameter("urls");
		String currentUrl = req.getParameter("currentUrl");
		// 路径转码
		String decodedUrl = URLDecoder.decode(urls, "utf-8");
		String decodedCurrentUrl = URLDecoder.decode(currentUrl, "utf-8");
		// 抽取文件并返回文件列表
		String[] imgs = decodedUrl.split("\\|");
		List imgurls = Arrays.asList(imgs);
		model.addAttribute("imgurls", imgurls);
		model.addAttribute("currentUrl", decodedCurrentUrl);
		return "picture";
	}

	/**
	 * 根据url获取文件内容 当pdfjs读取存在跨域问题的文件时将通过此接口读取
	 *
	 * @param urlPath
	 * @param resp
	 */
	@RequestMapping(value = "/getCorsFile", method = RequestMethod.GET)
	public void getCorsFile(String urlPath, HttpServletResponse resp) {
		InputStream inputStream = null;
		try {
			String strUrl = urlPath.trim();
			URL url = new URL(strUrl);
			// 打开请求连接
			URLConnection connection = url.openConnection();
			HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
			httpURLConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			inputStream = httpURLConnection.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			while (-1!=(len = inputStream.read(bs))) {
				resp.getOutputStream().write(bs, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream!=null) {
				IOUtils.closeQuietly(inputStream);
			}
		}
	}

	/**
	 * 通过api接口入队
	 * 
	 * @param url
	 *            请编码后在入队
	 */
	@GetMapping("/addTask")
	@ResponseBody
	public String addQueueTask(String url) {
		// final RBlockingQueue<String> queue =
		// redissonClient.getBlockingQueue(FileConverQueueTask.queueTaskName);
		// queue.addAsync(url);
		return "success";
	}

}
