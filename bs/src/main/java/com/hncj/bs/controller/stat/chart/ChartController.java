package com.hncj.bs.controller.stat.chart;

import java.io.FileNotFoundException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hncj.common.springdao.SqlDao;
import com.hncj.util.file.FileUtil;


/**
 * 统计查询中的图表统计
 * @author Administrator
 *
 */
@Controller
public class ChartController {
	
	@Resource
	SqlDao sqlDao;
	
	// 生成厂家销售饼形图
	/**
	 * 步骤
	 * 1.组织数据源
	 * 2.拼写xml
	 * 3.创建一个文件txt格式，xml工具
	 * 4.转向对应目录下的index.html
	 * @throws FileNotFoundException 
	 */
	@RequestMapping("/stat/chart/factorySale.action")
	public String factorySale(HttpServletRequest request) throws FileNotFoundException{
		String path = request.getSession().getServletContext().getRealPath("/");           //真实路径
		// 组织数据源
		String sql = "select f.factory_name,cp.countsum from (select factory_id,factory_name from factory_c) f "
				+ "right join (select factory_id,count(*) as countsum from contract_product_c group by factory_id) cp "
				+ "on f.factory_id = cp.factory_id";
	    List<String> dataList = sqlDao.executeSQL(sql);     //list<String>: 结果的list集合为String类型的一维数组
	    
	    // 拼接数据为一个xml字符串
	    StringBuffer sBuffer = new StringBuffer();
	    sBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    sBuffer.append("<pie>");
	    for (int i = 0; i < dataList.size();) { //在for循环中进行标识符的移动
	    	sBuffer.append("<slice title=\"").append(dataList.get(i++)).append("\">").append(dataList.get(i++)).append("</slice>");
		}
	    sBuffer.append("<pie>");
	    
	    // 输出  如果目录下没有文件就创建，如果存在就覆盖
	    FileUtil fileUtil = new FileUtil();
	    fileUtil.createTxt(path + "/stat/chart/factorysale", "data.xml", sBuffer.toString(), "utf-8");
	    
	    return "/stat/chart/jStat.jsp?forward=factorysale";
	}
	
	
	//产品销售排行，畅销产品排行
         	// 对方法中的过程进行了抽取，调用抽取的函数完成相关操作，而第一个方法  factorySale 没有抽取，为了进行参照
		@RequestMapping("/stat/chart/productSale.action")
		public String productSale(HttpServletRequest request) throws FileNotFoundException{
			String path = request.getSession().getServletContext().getRealPath("/");	//真实路径
			String dir = "productsale";
			
			String sql = "select cp.product_no,cp.cnum from (select product_no,sum(cnumber) as cnum "
					   + "from contract_product_c group by product_no order by cnum desc) cp"
					   + " where rownum <= 15";
			this.writeXML(path, dir, this.getColumnAndLineXml(this.getData(sql)));
			
			return "/stat/chart/jStat.jsp?forward=" + dir;
		}
	
	
	//系统访问压力的曲线图
		@RequestMapping("/stat/chart/onlineInfo.action")
		public String onlineInfo(HttpServletRequest request) throws FileNotFoundException{
			String path = request.getSession().getServletContext().getRealPath("/");	//真实路径
			String dir = "onlineinfo";
			
			String sql = "SELECT t.a1,p.countnum FROM (SELECT a1 FROM onlineinfo_t) t LEFT JOIN (SELECT substr(login_time,11,2) AS a1,COUNT(*) AS countnum FROM login_log_p GROUP BY substr(login_time,11,2)) p ON t.a1=p.a1";
			this.writeXML(path, dir, this.getColumnAndLineXml(this.getData(sql)));
			
			return "/stat/chart/jStat.jsp?forward=" + dir;
		}
		
		//获取数据
		public List<String> getData(String sql){
			return sqlDao.executeSQL(sql);			//List<String>
		}
		
		//获得柱状图xml
		public String getColumnAndLineXml(List<String> dataList){
			StringBuffer sBuf = new StringBuffer();
			sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sBuf.append("<chart>");
			sBuf.append("<series>");
			
			int xid = 0;			//对应标识
			for(int i=0;i<dataList.size();){
				sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
				i++;		//skip
			}
			sBuf.append("</series>");
			sBuf.append("<graphs>");
			sBuf.append("<graph gid=\"30\" color=\"#FFCC00\" gradient_fill_colors=\"#111111, #1A897C\">");
			
			xid = 0;
			for(int i=0;i<dataList.size();){
				i++;		//skip
				sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
			}
			
			sBuf.append("</graph>");
			sBuf.append("</graphs>");
			sBuf.append("</chart>");
			
			return sBuf.toString();
		}
		
		//写xml文本文件，格式utf-8
		public void writeXML(String path, String dir, String content) throws FileNotFoundException{
			//输出文件，如果目录下没有文件，直接创建；如果目录下文件存在，覆盖。
			FileUtil fu = new FileUtil();
			fu.createTxt(path + "/stat/chart/" + dir, "data.xml", content, "utf-8");
		}

	

}
