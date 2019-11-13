package com.pcitc.web.system;

import io.swagger.annotations.ApiOperation;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.pcitc.base.system.SysTableEncode;
import com.pcitc.service.system.SysTableEncodeService;

@RestController
@RequestMapping("/SystemCodeTool")
public class SystemCodeTool {

	@Autowired
	private SysTableEncodeService sysTableEncodeService;
	private final static Logger logger = LoggerFactory.getLogger(SysTableEncodeProviderClient.class);

	@RequestMapping(value = "/generate/create/{str}", method = RequestMethod.POST)
	public synchronized String createCode(@PathVariable(value = "str", required = true) String str) {
		JSONObject result = new JSONObject();
		;
		Calendar date = Calendar.getInstance();
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMdd");
		String code = "";
		String type;
		int number;
		String value;
		String value1;
		String joint;
		String numString = "";
		try {
			SysTableEncode steVO = sysTableEncodeService.findTableEncodeList(str).get(0);
			int i = Integer.parseInt(steVO.getTableEncodeGroupSum());
			JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(steVO));
			joint = obj.getString("tableEncodeItemValue0");
			for (int o = 1; o <= i; o++) {
				type = obj.getString("tableEncodeItemType" + o);
				value = obj.getString("tableEncodeItemValue" + o);
				if (o != i) {
					if ("ROOT_XTGL_BMGL_GDZ".equals(type)) {// 固定值
						code += value + joint;
					} else if ("ROOT_XTGL_BMGL_DQNF".equals(type)) {// 年份
						code += String.valueOf(date.get(Calendar.YEAR)) + joint;
					} else if ("ROOT_XTGL_BMGL_DQRH".equals(type)) {// 日号
						code += String.valueOf(date.get(Calendar.DAY_OF_MONTH)) + joint;
					} else if ("ROOT_XTGL_BMGL_DQRQ".equals(type)) {// 日期
						code += sdFormatter.format(new Date(System.currentTimeMillis())) + joint;
					} else if ("ROOT_XTGL_BMGL_DQYF".equals(type)) {// 月份
						code += String.valueOf(date.get(Calendar.MONTH)) + joint;
					} else if ("ROOT_XTGL_BMGL_WXM".equals(type)) {// 无序码
						code += UUID.randomUUID().toString().replace("-", "") + joint;
					} else if ("ROOT_XTGL_BMGL_LSH".equals(type)) {// 流水号
						number = Integer.parseInt(value) + 1;
						value1 = number + "";
						if (value1.length() > value.length()) {
							value1 = "1";
						}
						int zero = value.length() - value1.length();
						for (int x = 0; x < zero; x++) {
							numString += "0";
						}
						numString += value1;
						code += numString + joint;
						System.out.println("update +1 is numString");
					}
				} else {
					if ("ROOT_XTGL_BMGL_GDZ".equals(type)) {// 固定值
						code += value;
					} else if ("ROOT_XTGL_BMGL_DQNF".equals(type)) {// 年份
						code += String.valueOf(date.get(Calendar.YEAR));
					} else if ("ROOT_XTGL_BMGL_DQRH".equals(type)) {// 日号
						code += String.valueOf(date.get(Calendar.DAY_OF_MONTH));
					} else if ("ROOT_XTGL_BMGL_DQRQ".equals(type)) {// 日期
						code += sdFormatter.format(new Date(System.currentTimeMillis()));
					} else if ("ROOT_XTGL_BMGL_DQYF".equals(type)) {// 月份
						code += String.valueOf(date.get(Calendar.MONTH));
					} else if ("ROOT_XTGL_BMGL_WXM".equals(type)) {// 无序码
						code += UUID.randomUUID().toString().replace("-", "");
					} else if ("ROOT_XTGL_BMGL_LSH".equals(type)) {// 流水号
						number = Integer.parseInt(value) + 1;
						value1 = number + "";
						if (value1.length() > value.length()) {
							value1 = "1";
						}
						int zero = value.length() - value1.length();
						for (int x = 0; x < zero; x++) {
							numString += "0";
						}
						numString += value1;
						obj.put("tableEncodeItemValue" + o, numString);
						code += numString;
						System.out.println("update +1 is numString");
					}
				}
			}
			result.put("code", code);
			steVO = JSON.parseObject(obj.toJSONString(), SysTableEncode.class);
			steVO.setTableEncodeFullValue(code);
			sysTableEncodeService.updateSysTableEncode(steVO);
		} catch (Exception e) {
			logger.error("[编码管理-生成编码失败：]", e);
		}
		return result.toString();
	}

	@ApiOperation(value = "多文件下载", notes = "根据文件ID下载文件,返回字节流")
	@RequestMapping(value = "/qr-code/{value}")
	public String downloadFiles(@PathVariable("value") String value) {

		int width = 200;
		int height = 200;
		String format = "png";
		String retS = null;
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(value, BarcodeFormat.QR_CODE, width, height, hints);

			// 通过流写入文件，不需要flush()
			OutputStream temOS = new FileOutputStream("d:/new2.png");
			MatrixToImageWriter.writeToStream(bitMatrix, format, temOS);

			BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
			ByteArrayOutputStream os = new ByteArrayOutputStream();// 新建流。
			ImageIO.write(image, format, os);	// 利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
			byte b[] = os.toByteArray();	// 从流中获取数据数组。
			retS = new sun.misc.BASE64Encoder().encode(b);
			System.out.println(retS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retS;
	}

}
