package com.hncj.bs.controller.cargo.outproduct;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hncj.bs.controller.BaseController;
import com.hncj.bs.service.OutProductService;
import com.hncj.bs.vo.OutProductVO;
import com.hncj.util.DownloadUtil;

@Controller
public class OutProductController extends BaseController {

	@Resource
	OutProductService outProductService;
	
	// 转向编辑页面
	@RequestMapping("/cargo/outproduct/toedit.action")
	public String toedit(){
		
		return "/cargo/outproduct/jOutProduct.jsp";
	} 
	
	/*// 打印
	@RequestMapping("/cargo/outproduct/printNotemplate.action")
	public void printNotemplate(String inputDate) throws IOException{
		
		
		*//**
		 * POI实现Excel打印
		 * 1.大标题，合并单元格
		 * 2.标题，修饰
		 * 3.内容，修饰
		 *//*
		Workbook wb = new HSSFWorkbook();        // 创建一个工作簿
		Sheet sheet = wb.createSheet();          // 创建一个工作表
		Row nRow = null;                         // 创建一个行对象
		Cell nCell = null;
		int rowNo = 0;                           // 行号
		int colNo = 1;                           // 列号
		
       //创建样式和字体对象
		CellStyle curStyle = wb.createCellStyle();
		Font curFont = wb.createFont();
		
		sheet.setColumnWidth(0, 1*256);
		sheet.setColumnWidth(1, 26*256);
		sheet.setColumnWidth(2, 12*256);
		sheet.setColumnWidth(3, 29*256);
		sheet.setColumnWidth(4, 12*256);
		sheet.setColumnWidth(5, 15*256);
		sheet.setColumnWidth(6, 10*256);
		sheet.setColumnWidth(7, 10*256);
		sheet.setColumnWidth(8, 8*256);
		
		// 处理大标题
//		sheet.addMergedRegion(new CellRangeAddress(开始行，结束行，开始列，结束列));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 8)); //合并单元格
                                                                 //合并单元格就是在原有的区域上覆盖一个新对象，因此要为单元格赋值时就按照原来区域的第一个位置
		nRow = sheet.createRow(rowNo++);  
		nRow.setHeightInPoints(36);
		nCell = nRow.createCell(1);

		nCell.setCellStyle(bigTitleStyle(wb));
		
		nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-","年")+"月份出货表");
		
		//处理标题
		String[] title = new String[]{"客户","订单号","货号","数量","工厂","工厂交期","船期","贸易条款"};   //标题数组
	    nRow = sheet.createRow(rowNo++);
	    nRow.setHeightInPoints(26);
		for(int i=0;i<title.length;i++){
			nCell = nRow.createCell(i+1);
			nCell.setCellValue(title[i]);
			
			nCell.setCellStyle(this.titleStyle(wb));
		}
		
		// 处理内容
		List<OutProductVO> dataList = outProductService.find(inputDate);
		for(int j=0;j<dataList.size();j++){
			 colNo = 1;                                   //初始化列数，确保每行从同一个地方开始
			 OutProductVO op = dataList.get(j);
			 
			 nRow = sheet.createRow(rowNo++);
			 nRow.setHeightInPoints(24);
			
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getCustomName());
			 nCell.setCellStyle(this.textStyle(wb,curStyle,curFont));
			 
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getContractNo());
			 nCell.setCellStyle(this.textStyle(wb,curStyle,curFont));
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getProductNo());
			 nCell.setCellStyle(this.textStyle(wb,curStyle,curFont));
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getCnumber());
			 nCell.setCellStyle(this.textStyle(wb,curStyle,curFont));
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getFactoryName());
			 nCell.setCellStyle(this.textStyle(wb,curStyle,curFont));
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getDeliveryPeriod());
			 nCell.setCellStyle(this.textStyle(wb,curStyle,curFont));
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getShipTime());
			 nCell.setCellStyle(this.textStyle(wb,curStyle,curFont));
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getTradeTerms());
			 nCell.setCellStyle(this.textStyle(wb,curStyle,curFont));
		}
		
		OutputStream os = new FileOutputStream("E:\\毕设图\\outproduct.xls");
		wb.write(os);
		
		os.flush();
		os.close();
	 }
	
	// 大标题样式
		private CellStyle bigTitleStyle(Workbook wb){
			CellStyle curStyle = wb.createCellStyle();
			Font curFont = wb.createFont();
			
			curFont.setFontName("宋体");
			curFont.setFontHeightInPoints((short)16);
			curFont.setBoldweight(Font.BOLDWEIGHT_BOLD);               //字体加粗
			
			curStyle.setFont(curFont);
			
			curStyle.setAlignment(CellStyle.ALIGN_CENTER);             //横向居中
			curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  //纵向居中
			
			return curStyle;
		}
		
		// 小标题样式
		private CellStyle titleStyle(Workbook wb){
			CellStyle curStyle = wb.createCellStyle();
			Font curFont = wb.createFont();
			
			curFont.setFontName("黑体");
			curFont.setFontHeightInPoints((short)12);
			
			curStyle.setFont(curFont);
			
			curStyle.setAlignment(CellStyle.ALIGN_CENTER);             //横向居中
			curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  //纵向居中
			
			curStyle.setBorderTop(CellStyle.BORDER_THIN);              //设置四周边线，细线
			curStyle.setBorderBottom(CellStyle.BORDER_THIN);
			curStyle.setBorderLeft(CellStyle.BORDER_THIN);
			curStyle.setBorderRight(CellStyle.BORDER_THIN);
			
			return curStyle;
		}

		//文字样式
		private CellStyle textStyle(Workbook wb,CellStyle curStyle,Font curFont){
			
			curFont.setFontName("Times New Roman");
			curFont.setFontHeightInPoints((short)10);
			
			curStyle.setFont(curFont);
			
			curStyle.setAlignment(CellStyle.ALIGN_LEFT);             //横向居左
			curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  //纵向居中
			
			curStyle.setBorderTop(CellStyle.BORDER_THIN);              //设置四周边线，细线
			curStyle.setBorderBottom(CellStyle.BORDER_THIN);
			curStyle.setBorderLeft(CellStyle.BORDER_THIN);
			curStyle.setBorderRight(CellStyle.BORDER_THIN);
			
			return curStyle;
		}
		*/
	
	
	
	// 模板开发 ，打印出的为老板的格式  即 .xls后缀
//	@RequestMapping("/cargo/outproduct/printHSSF.action")
//	public void printHSSF(String inputDate,HttpServletRequest request,HttpServletResponse response) throws IOException{
//
//		String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";  //获取模板
//		InputStream is = new FileInputStream(new File(path + "tOUTPRODUCT.xls"));
//		
//		Workbook wb = new HSSFWorkbook(is);        // 打开一个模板文件，工作簿
//		Sheet sheet = wb.getSheetAt(0);            // 获取第一个工作表 
//
//		Row nRow = null;                         // 创建一个行对象
//		Cell nCell = null;
//		int rowNo = 0;                           // 行号
//		int colNo = 1;                           // 列号
//		
//		//获取单元格上模板的样式
//		nRow = sheet.getRow(2);
//		
//		//客户的样式
//		nCell = nRow.getCell(1);
//		CellStyle customStyle = nCell.getCellStyle();
//
//		//订单号的样式
//		nCell = nRow.getCell(2);
//		CellStyle contractNoStyle = nCell.getCellStyle();
//
//		//货号的样式
//		nCell = nRow.getCell(3);
//		CellStyle productNoStyle = nCell.getCellStyle();
//
//		//数量的样式
//		nCell = nRow.getCell(4);
//		CellStyle numStyle = nCell.getCellStyle();
//
//		//工厂的样式
//		nCell = nRow.getCell(5);
//		CellStyle factoryStyle = nCell.getCellStyle();
//		
//		//日期的样式
//		nCell = nRow.getCell(6);
//		CellStyle dateStyle = nCell.getCellStyle();     // 中间缺少 7 ，是因为6和7的样式是一样的
//		
//		//贸易条款的样式
//		nCell = nRow.getCell(8);
//		CellStyle tradeStyle = nCell.getCellStyle();
//		
//		// 处理大标题
//		nRow = sheet.getRow(rowNo++);          //获取一个行对象
//		nCell = nRow.getCell(colNo);           //获取一个单元格对象
//		nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-","年")+"月份出货表");  
//		
//		rowNo++;                              //跳过静态表格头
//		
//		// 处理内容
//		List<OutProductVO> dataList = outProductService.find(inputDate);
//		for(int j=0;j<dataList.size();j++){
//			 colNo = 1;                                   //初始化列数，确保每行从同一个地方开始
//			 OutProductVO op = dataList.get(j);
//			 
//			 nRow = sheet.createRow(rowNo++);
//			 nRow.setHeightInPoints(24);
//			
//			 nCell = nRow.createCell(colNo++);
//			 nCell.setCellValue(op.getCustomName());
//			 nCell.setCellStyle(customStyle);
//			 
//			 
//			 nCell = nRow.createCell(colNo++);
//			 nCell.setCellValue(op.getContractNo());
//			 nCell.setCellStyle(contractNoStyle);
//			 
//			 nCell = nRow.createCell(colNo++);
//			 nCell.setCellValue(op.getProductNo());
//			 nCell.setCellStyle(productNoStyle);
//			 
//			 nCell = nRow.createCell(colNo++);
//			 nCell.setCellValue(op.getCnumber());
//			 nCell.setCellStyle(numStyle);
//			 
//			 nCell = nRow.createCell(colNo++);
//			 nCell.setCellValue(op.getFactoryName());
//			 nCell.setCellStyle(factoryStyle);
//			 
//			 nCell = nRow.createCell(colNo++);
//			 nCell.setCellValue(op.getDeliveryPeriod());
//			 nCell.setCellStyle(dateStyle);
//			 
//			 nCell = nRow.createCell(colNo++);
//			 nCell.setCellValue(op.getShipTime());
//			 nCell.setCellStyle(dateStyle);
//			 
//			 nCell = nRow.createCell(colNo++);
//			 nCell.setCellValue(op.getTradeTerms());
//			 nCell.setCellStyle(tradeStyle);
//		}
//		
////		OutputStream os = new FileOutputStream("E:\\毕设图\\outproduct.xls");
////		wb.write(os);
////		
////		os.flush();
////		os.close();
//		
//		ByteArrayOutputStream os = new ByteArrayOutputStream();
//		wb.write(os);
//		
//		DownloadUtil downloadUtil = new DownloadUtil();          //调用工具类中封装的下载文件的方法,直接弹出下载框，用户可以打开，可以保存
//		downloadUtil.download(os, response, "出货表.xls");
//		
//		os.flush();
//		os.close();
//	 }
	
	//打印  打印新版的格式，后缀为 .xlsx    (xls 到 xlsx格式就是升级POI的过程只需换一个对象，   把HSSF换成XSSF)
	@RequestMapping("/cargo/outproduct/print.action")
	public void print(String inputDate,HttpServletRequest request,HttpServletResponse response) throws IOException{

		String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";  //获取模板
		InputStream is = new FileInputStream(new File(path + "tOUTPRODUCT.xlsx"));
		
		Workbook wb = new XSSFWorkbook(is);        // 打开一个模板文件，工作簿
		Sheet sheet = wb.getSheetAt(0);            // 获取第一个工作表 

		Row nRow = null;                         // 创建一个行对象
		Cell nCell = null;
		int rowNo = 0;                           // 行号
		int colNo = 1;                           // 列号
		
		//获取单元格上模板的样式
		nRow = sheet.getRow(2);
		
		//客户的样式
		nCell = nRow.getCell(1);
		CellStyle customStyle = nCell.getCellStyle();

		//订单号的样式
		nCell = nRow.getCell(2);
		CellStyle contractNoStyle = nCell.getCellStyle();

		//货号的样式
		nCell = nRow.getCell(3);
		CellStyle productNoStyle = nCell.getCellStyle();

		//数量的样式
		nCell = nRow.getCell(4);
		CellStyle numStyle = nCell.getCellStyle();

		//工厂的样式
		nCell = nRow.getCell(5);
		CellStyle factoryStyle = nCell.getCellStyle();
		
		//日期的样式
		nCell = nRow.getCell(6);
		CellStyle dateStyle = nCell.getCellStyle();     // 中间缺少 7 ，是因为6和7的样式是一样的
		
		//贸易条款的样式
		nCell = nRow.getCell(8);
		CellStyle tradeStyle = nCell.getCellStyle();
		
		// 处理大标题
		nRow = sheet.getRow(rowNo++);          //获取一个行对象
		nCell = nRow.getCell(colNo);           //获取一个单元格对象
		nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-","年")+"月份出货表");  
		
		rowNo++;                              //跳过静态表格头
		
		// 处理内容
		List<OutProductVO> dataList = outProductService.find(inputDate);
		for(int j=0;j<dataList.size();j++){
			 colNo = 1;                                   //初始化列数，确保每行从同一个地方开始
			 OutProductVO op = dataList.get(j);
			 
			 nRow = sheet.createRow(rowNo++);
			 nRow.setHeightInPoints(24);
			
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getCustomName());
			 nCell.setCellStyle(customStyle);
			 
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getContractNo());
			 nCell.setCellStyle(contractNoStyle);
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getProductNo());
			 nCell.setCellStyle(productNoStyle);
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getCnumber());
			 nCell.setCellStyle(numStyle);
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getFactoryName());
			 nCell.setCellStyle(factoryStyle);
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getDeliveryPeriod());
			 nCell.setCellStyle(dateStyle);
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getShipTime());
			 nCell.setCellStyle(dateStyle);
			 
			 nCell = nRow.createCell(colNo++);
			 nCell.setCellValue(op.getTradeTerms());
			 nCell.setCellStyle(tradeStyle);
		}
		
//		OutputStream os = new FileOutputStream("E:\\毕设图\\outproduct.xls");
//		wb.write(os);
//		
//		os.flush();
//		os.close();
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		wb.write(os);
		
		DownloadUtil downloadUtil = new DownloadUtil();          //调用工具类中封装的下载文件的方法,直接弹出下载框，用户可以打开，可以保存
		downloadUtil.download(os, response, "出货表.xlsx");
		
		os.flush();
		os.close();
	 }
	
	
	
	
	
  }
	

