package com.pcitc.base.util;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class DocxUtil {
	/**
	 * @Description: 将t中的字段转换成替换模板需要的数据${字段}-->字段值
	 *               在word模板中变量为${valuename},为每个值建一个以‘${valuename}’为键，‘value’为值的Map集合，
	 *               利用键去和Word模板中寻找相等的变量
	 *//*
	public <T> Map<String, String> copyParamFromBean(T t, Map<String, String> params) {
		Field[] fields = t.getClass().getDeclaredFields();
		String key;
		String value;
		for (Field field : fields) {
			String fieldName = field.getName();
			key = "${" + fieldName + "}";
			String name = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			try {
				value = String.valueOf(t.getClass().getMethod(name).invoke(t));
				params.put(key, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return params;
	}*/

	/***
	 * 替换Word模板中的对应变量。 两种情况：1-段落中的变量。 2-表格中的变量
	 */
	public static void searchAndReplace(XWPFDocument document, Map<String, String> map) {
		try {
			// 替换段落中的指定文字
			Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();// 获得word中段落
			while (itPara.hasNext()) { // 遍历段落
				XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
				Set<String> set = map.keySet();
				Iterator<String> iterator = set.iterator();
				while (iterator.hasNext()) {
					String key = iterator.next();
					List<XWPFRun> run = paragraph.getRuns();
					for (int i = 0; i < run.size(); i++) {
						if (run.get(i).getText(run.get(i).getTextPosition()) != null
								&& run.get(i).getText(run.get(i).getTextPosition()).equals(key)) {
							/**
							 * 参数0表示生成的文字是要从哪一个地方开始放置,设置文字从位置0开始 就可以把原变量替换掉
							 */
							run.get(i).setText(map.get(key), 0);
						}
					}
				}
			}
			// 替换表格中的指定文字
			Iterator<XWPFTable> itTable = document.getTablesIterator();// 获得Word的表格
			while (itTable.hasNext()) { // 遍历表格
				XWPFTable table = (XWPFTable) itTable.next();
				int count = table.getNumberOfRows();// 获得表格总行数
				for (int i = 0; i < count; i++) { // 遍历表格的每一行
					XWPFTableRow row = table.getRow(i);// 获得表格的行
					List<XWPFTableCell> cells = row.getTableCells();// 在行元素中，获得表格的单元格
					for (XWPFTableCell cell : cells) { // 遍历单元格
						for (Entry<String, String> e : map.entrySet()) {
							if (cell.getText().equals(e.getKey())) {// 如果单元格中的变量和‘键’相等，就用‘键’所对应的‘值’代替。
								cell.removeParagraph(0);// 所以这里就要求每一个单元格只能有唯一的变量。
								cell.setText(e.getValue());
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭输出流
	 *
	 * @param os
	 */
	public static void close(Closeable os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String [] args) throws IOException {
		Map<String, String> params = new HashMap<String,String>();
		//m_ysnd
		params.put("total_fee", "7450.00");
		params.put("create_time", "2019年9月8日");
		
		
		String filePath = "d:\\payment_notice_template.docx";
		String outPath = "d:\\sample.docx";
		
		
		InputStream is = new FileInputStream(filePath);
		XWPFDocument doc = new XWPFDocument(is);
		searchAndReplace(doc,params);
		
		OutputStream os = new FileOutputStream(outPath);
		doc.write(os);
		
		close(os);
		close(is);

	}
}
