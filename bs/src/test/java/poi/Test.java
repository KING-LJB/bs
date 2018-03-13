package poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Test {
	
	@org.junit.Test
	public void testHSSF_base() throws IOException{
		
		/**
		 * 开发步骤
		 * 1.创建一个工作簿
		 * 2.创建一个工作表
		 * 3.创建一个行对象
		 * 4.创建一个单元格对象，指定它的列
		 * 5.给单元格设置内容
		 * 6.对内容的样式进行修饰（不写了）
		 * 7.保存，写入文件
		 * 8.关闭对象
		 */
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row nRow = sheet.createRow(5);          //第6行
		Cell nCell = nRow.createCell(5);        //第6列
		
		nCell.setCellValue("河南大城建");
		
		OutputStream os = new FileOutputStream("E:\\毕设图\\testpoi.xls");
		wb.write(os);
		
		os.flush();
		os.close();
		
	}
	
	   @org.junit.Test
       public void testHSSFStyle() throws IOException{
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row nRow = sheet.createRow(5);                     //第6行
		Cell nCell = nRow.createCell(5);                   //第6列
		
		nCell.setCellValue("河南大城建");
		
		CellStyle titleStyle = wb.createCellStyle();       //创建单元格样式
		Font titleFont = wb.createFont();                  //创建字体样式
		
		titleFont.setFontName("华文隶书");                    //设置样式名称
		titleFont.setFontHeightInPoints((short)24);        //设置字体大小
		
		titleStyle.setFont(titleFont);                     //绑定字体对象
		
		nCell.setCellStyle(titleStyle);
		
		OutputStream os = new FileOutputStream("E:\\毕设图\\testpoi.xls");
		wb.write(os);
		
		os.flush();
		os.close();
		
	}

}
