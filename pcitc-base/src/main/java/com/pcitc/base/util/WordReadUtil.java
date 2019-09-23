package com.pcitc.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WordReadUtil {
	/**
	 * 读取doc文件内容
	 * 
	 * @param file 想要读取的文件对象
	 * @return 返回文件内容
	 */
	public static String doc2String(XWPFDocument doc) {
		try 
		{
			StringBuffer sb = new StringBuffer();
			for (XWPFParagraph p : doc.getParagraphs())// 遍历段落
			{
				sb.append(p.getParagraphText());
				System.out.println(p.getParagraphText());
			}
			for (XWPFTable table : doc.getTables())// 遍历表格
			{
				for (XWPFTableRow row : table.getRows()) {
					for (XWPFTableCell cell : row.getTableCells()) {
						System.out.println(cell.getText());
						sb.append(cell.getText());
					}
				}
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 替换段落里面的变量
	 * 
	 * @param doc    要替换的文档
	 * @param params 参数
	 */
	private static void replaceInPara(XWPFDocument doc, Map<String, String> params) {
		Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
		XWPFParagraph para;
		while (iterator.hasNext()) {
			para = iterator.next();
			replaceInPara(para, params);
		}
	}

	/**
	 * 替换段落里面的变量
	 * 
	 * @param para   要替换的段落
	 * @param params 参数
	 */
	private static void replaceInPara(XWPFParagraph para, Map<String, String> params) {
		List<XWPFRun> runs = para.getRuns();
		Matcher matcher;
		for (int i = 0; i < runs.size(); i++) {
			XWPFRun run = runs.get(i);
			String runText = run.toString();
			System.out.println(runText);
			matcher = matcher(runText);
			if (matcher.find()) {
				System.out.println("++++++++");
				while ((matcher = matcher(runText)).find()) {
					runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
				}
				// 直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
				// 所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
				para.removeRun(i);
				para.insertNewRun(i).setText(runText);
			}
		}
	}

	/**
	 * 替换表格里面的变量
	 * 
	 * @param doc    要替换的文档
	 * @param params 参数
	 */
	private static void replaceInTable(XWPFDocument doc, Map<String, String> params) {
		Iterator<XWPFTable> iterator = doc.getTablesIterator();
		XWPFTable table;
		List<XWPFTableRow> rows;
		List<XWPFTableCell> cells;
		List<XWPFParagraph> paras;
		while (iterator.hasNext()) {
			table = iterator.next();
			rows = table.getRows();
			for (XWPFTableRow row : rows) {
				cells = row.getTableCells();
				for (XWPFTableCell cell : cells) {
					paras = cell.getParagraphs();
					for (XWPFParagraph para : paras) {
						replaceInPara(para, params);
					}
				}
			}
		}
	}

	/**
	 * 正则匹配字符串
	 * 
	 * @param str
	 * @return
	 */
	private static Matcher matcher(String str) {
		Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher;
	}

	/**
	 * 关闭输入流
	 * 
	 * @param is
	 */
	private static void close(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭输出流
	 * 
	 * @param os
	 */
	private static void close(OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void readByXWPF(String modulePath, String outPath, Map<String, String> params) throws IOException {
		File infile = new File(modulePath);
		File outfile = new File(outPath);
		if (!outfile.exists()) {
			outfile.createNewFile();
		}
		InputStream inputStream = new FileInputStream(infile);
		XWPFDocument document = new XWPFDocument(inputStream);

		// 获取整个文本对象
		List<XWPFParagraph> allParagraph = document.getParagraphs();
		for (XWPFParagraph p : allParagraph) {
			replaceInPara(p,params);
		}

		// 获取整个表格对象
		//List<XWPFTable> allTable = document.getTables();
		replaceInTable(document,params);
		

		OutputStream outputStream = new FileOutputStream(outfile);
		document.write(outputStream);

		outputStream.close();
		inputStream.close();
	}

	public static void readByHWPF(String modulePath, String outPath, Map<String, String> params) throws IOException {
		File infile = new File(modulePath);
		File outfile = new File(outPath);
		if (!outfile.exists()) {
			outfile.createNewFile();
		}

		InputStream inputStream = new FileInputStream(infile);
		HWPFDocument document = new HWPFDocument(inputStream);
		Range range = document.getRange();
		for (java.util.Iterator<String> iter = params.keySet().iterator(); iter.hasNext();) {
			String key = iter.next();
			range.replaceText("${" + key + "}", params.get(key));
		}
		OutputStream outputStream = new FileOutputStream(outfile);
		document.write(outputStream);

		outputStream.close();
		inputStream.close();
	}

	public static void main(String [] args) throws IOException {
		Map<String, String> params = new HashMap<String,String>();
		params.put("total_fee", "7450.00");
		
		String filePath = "d:\\payment_notice_template.docx";
		String outPath = "d:\\sample.docx";
		
		InputStream is = new FileInputStream(filePath);
		XWPFDocument doc = new XWPFDocument(is);
		// 替换段落里面的变量
		WordReadUtil.replaceInPara(doc, params);
		// 替换表格里面的变量
		WordReadUtil.replaceInTable(doc, params);
		OutputStream os = new FileOutputStream(outPath);
		doc.write(os);
		WordReadUtil.close(os);
		WordReadUtil.close(is);

	}

}
