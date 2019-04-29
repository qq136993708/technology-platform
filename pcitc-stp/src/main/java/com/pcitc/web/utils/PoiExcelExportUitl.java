package com.pcitc.web.utils;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;


public class PoiExcelExportUitl<T> {
	// excle导出名称
    private String fileName;
    // excel 表头
    private String[] heads;
    // excel 列
    private String[] cols;
    // 设置数值型的列 从0开始计数
    private int[] numerics;
    //list集合
    private List<T> list;
    // 输出流
    private OutputStream out;
    // 构造函数
    public PoiExcelExportUitl(String fileName, String[] heads, String[] cols, List<T> list, OutputStream out)
    {
        this.fileName = fileName;
        this.heads = heads;
        this.cols = cols;
        this.list = list;
        this.out = out;
    }

    // 构造函数 带数字类型
    public PoiExcelExportUitl(String fileName, String[] heads, String[] cols, List<T> list, int[] numerics, OutputStream out) {
        this.fileName = fileName;
        this.heads = heads;
        this.cols = cols;
        this.list = list;
        this.numerics = numerics;
        this.out = out;
    }

    public void exportExcel() {
        HSSFWorkbook hssfworkbook = new HSSFWorkbook(); // 创建一个excel对象
        for (int i = 0; i <= (list.size() / 65535); i++) {
            HSSFSheet hssfsheet = hssfworkbook.createSheet(); // 工作表
            hssfsheet.setDefaultColumnWidth(20);// 设置表格默认列宽度为20个字节  
            // 工作表名称
            hssfworkbook.setSheetName(i, fileName.replace(".xls", "") + "(第" + (i + 1) + "页)");
            int beginRows = 65535 * i;
            int endRows = (list.size() > 65535 * (i + 1)) ? 65535 * (i + 1) - 1 : list.size() - 1;
            HSSFRow hssfrowHead = hssfsheet.createRow(0);
            // 输出excel 表头
            if (heads != null && heads.length > 0) {
                for (int h = 0; h < heads.length; h++) {
                    HSSFCell hssfcell = hssfrowHead.createCell(h,Cell.CELL_TYPE_STRING);
                    hssfcell.setCellValue(heads[h]);
                }
            }
            // 要设置数值型 列表
            HSSFCellStyle cellstyle = hssfworkbook.createCellStyle();
            cellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("##0"));
            // 是否是数值型
            boolean isnum = false;
            // 输出excel 数据
            for (int curRow = beginRows; curRow <= endRows; curRow++) 
            {
                // 获取数据
                BeanToMap<T> btm = new BeanToMap<T>();
                Map<String,Object> hm = btm.getMap(list.get(curRow));
                // 创建excel行 表头1行 导致数据行数 延后一行
                HSSFRow hssfrow = hssfsheet.createRow(curRow % 65535 + 1);
                // 读取数据值
                for (int k = 0; k < cols.length; k++) {
                    HSSFCell hssfcell = hssfrow.createCell(k);
                    // hssfcell.setCellValue(hm.get(cols[k])==null?"":hm.get(cols[k]).toString());
                    isnum = false;
                    /*for (int z = 0; z < numerics.length; z++) {
                        if (numerics[z] == k) {
                            isnum = true;
                            break;
                        }
                    }*/

                    if (isnum) {
                        if (hm.get(cols[k]) == null || hm.get(cols[k]).equals("")) {

                        } else {
                            //hssfcell.setCellStyle(cellstyle);
                        	hssfcell.setCellStyle(cellstyle);
                            hssfcell.setCellValue(Double.parseDouble(
                                    hm.get(cols[k]) == null ? "" : hm.get(cols[k]).toString().replace(",", "")));
                        }
                    } else {
                        hssfcell.setCellValue(hm.get(cols[k]) == null ? "" : hm.get(cols[k]).toString());
                    }
                }
            }

        }
        // excel生成完毕，写到输出流
        try {
            hssfworkbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
