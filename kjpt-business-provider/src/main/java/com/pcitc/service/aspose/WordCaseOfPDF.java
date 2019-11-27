//package com.pcitc.service.aspose;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//
//import com.aspose.words.Document;
//import com.aspose.words.License;
//import com.aspose.words.SaveFormat;
//
///**
// *
// * 项目名称：we2pdf<br>
// * *********************************<br>
// * <P>类名称：WordCaseOfPDF</P>
// * *********************************<br>
// * <P>类描述：Word转pdf</P>
// * 创建人：Wangdandan<br>
// * 创建时间：2017年8月18日 上午9:46:05<br>s
// * 修改人：Wangdandan<br>
// * 修改时间：2017年8月18日 上午9:46:05<br>
// * 修改备注：<br>
// * @version 1.0.0<br>
// */
//public class WordCaseOfPDF {
//	/**
//	 *
//	 * <p>方法描述: 验证License认证</p>
//	 *
//	 * <p>此方法支持Word转pdf--支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF<</p>
//	 *
//	 * <p>负责管理，不必自行就行维护。</p>
//	 *
//	 * @return boolean
//	 *
//	 * <p>创建人：Wangdandan</p>
//	 *
//	 * <p>创建时间：2017年8月18日 上午9:35:21</p>
//	 *
//	 */
//	public static boolean getLicense() {
//		boolean result = false;
//		try {
//			//认证license
//			InputStream is = WordCaseOfPDF.class.getClassLoader().getResourceAsStream("xlsxlicense.xml"); //  wordlicense.xml应放在..\WebRoot\WEB-INF\classes路径下
//			License aposeLic = new License();
//			aposeLic.setLicense(is);
//			result = true;
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	/**
//	 *
//	 * <p>方法描述: Word转pdf</p>
//	 *
//	 * <p>此方法支持Word转pdf--支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF<</p>
//	 *
//	 * <p>负责管理，不必自行就行维护。</p>
//	 *
//	 * @return boolean
//	 *
//	 * <p>创建人：Wangdandan</p>
//	 *
//	 * <p>创建时间：2017年8月18日 上午9:35:21</p>
//	 *
//	 */
//	public static File  word2pdf(String wordName) {
//		File result = null;
//		if (!getLicense()) {          // 验证License 若不验证则转化出的PDP文档会有水印产生
//			 return result;
//		}
//		try {
//			//修改文件后缀
//			String newwordName = wordName.substring(0, wordName.lastIndexOf("."))+".pdf";
//            File pdfFile = new File(newwordName);
//            FileOutputStream fileOS = new FileOutputStream(pdfFile);
//			Document doc = new Document(wordName);                    //wordName是将要被转化的word文档
//			doc.save(fileOS, SaveFormat.PDF);                            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换            os.close();
//			fileOS.close();
//			result = pdfFile;
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//
//			//TODO: log exception
//		}
//		return result;
//	}
//}
