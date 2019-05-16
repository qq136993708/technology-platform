package com.pcitc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;

public class GetTextFromFile {
	public static String getText(String filePath) throws Exception {
		if (filePath.toUpperCase().endsWith(".PDF")) {
			return getTextFromPDF(filePath);
		} else if (filePath.toUpperCase().endsWith(".DOCX")||filePath.toUpperCase().endsWith(".DOC")) {
			return getTextFromWord(filePath);
		} else if (filePath.toUpperCase().endsWith(".TXT")) {
			return getTextFromTxt(filePath);
		} else if (filePath.toUpperCase().endsWith(".XLS")||filePath.toUpperCase().endsWith(".XLSX")) { 
			return getTextFromExcel(filePath); }
		return "";
	}

	private static String getTextFromPDF(String pdfFilePath) throws Exception {
		String result = null;
		InputStream is = null;
		PDDocument document = null;
		try {
			is = OSSUtil.getOssFileIS(pdfFilePath.split(OSSUtil.OSSPATH+"/"+OSSUtil.BUCKET+"/")[1]);
			document = PDDocument.load(is);
			PDFTextStripper stripper = new PDFTextStripper();
			result = stripper.getText(document);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (document!=null) {
				try {
					document.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static String getTextFromWord(String worldFilePth) throws Exception {
		InputStream fis = null;
		WordExtractor extractor2003 = null;
		XWPFWordExtractor extractor2007 = null;
		try {

			fis = OSSUtil.getOssFileIS(worldFilePth.split(OSSUtil.OSSPATH+"/"+OSSUtil.BUCKET+"/")[1]);
			if (worldFilePth.toUpperCase().endsWith(".DOC")) {
				extractor2003 = new WordExtractor(fis);
				return extractor2003.getText();
			} else {
				XWPFDocument doc = new XWPFDocument(fis);
				extractor2007 = new XWPFWordExtractor(doc);
				return extractor2007.getText();
			}

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (fis!=null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (extractor2003!=null) {
					extractor2003.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (extractor2007!=null) {
					extractor2007.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static String getTextFromTxt(String txtFilePth) throws Exception {
		StringBuilder result = new StringBuilder();
		FileReader fis = null;
		BufferedReader br = null;
		try {
			// fis = new
			// FileReader(OSSUtil.getOssFileIS(txtFilePth.split(OSSUtil.OSSPATH+"/"+OSSUtil.BUCKET+"/")[1]));
			br = new BufferedReader(fis);// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine())!=null) {// 使用readLine方法，一次读一行
				result.append(s);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis!=null) fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (br!=null) br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result.toString();

	}

	private static String getTextFromExcel(String fileName) throws InvalidFormatException, IOException, OpenXML4JException, XmlException {
		File inputFile = new File(fileName);
		POITextExtractor extractor = ExtractorFactory.createExtractor(inputFile);
		return extractor.getText();
	}

	public static void main(String[] args) {
		String strFilePath = "C:\\Users\\Administrator\\Desktop\\工程项目管理系统2.0版本详细设计-v2.0-2018.6.26-v1.2.docx";
		try {
			String strContent = GetTextFromFile.getText(strFilePath);
			System.out.println("strContent = "+strContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
