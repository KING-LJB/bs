package com.hncj.bs.controller.cargo.export;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hncj.bs.controller.BaseController;
import com.hncj.bs.domain.Contract;
import com.hncj.bs.domain.Export;
import com.hncj.bs.service.ExportService;
import com.hncj.bs.vo.ContractVO;

@Controller
public class ExportController extends BaseController {

	@Resource
	ExportService exportService;
	
	@RequestMapping("/cargo/export/list.action")
	public String list(Model model){
		List<Export> dataList = exportService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/export/jExportList.jsp";
	}
	
	
	// 购销合同的查询列表
	@RequestMapping("/cargo/export/contractList.action")
	public String contractList(Model model){
		List<Contract> dataList = exportService.getContractList();
		model.addAttribute("dataList", dataList);                    // 报运目录下调用购销合同列表
		
		return "/cargo/export/jContractList.jsp";
	}
	
	
	// 报运的新增，直接进行后台保存
	@RequestMapping("/cargo/export/insert.action")
	public String insert(@RequestParam("id")String[] contractIds){
		exportService.insert(contractIds);
		
		return "redirect:/cargo/export/list.action";
	}
	
	//到达修改页面
	@RequestMapping("/cargo/export/toupdate.action")
	public String toupdate(String id,Model model){
		Export obj = exportService.get(id);		
		model.addAttribute("obj", obj);
		
		// 准备批量修改的控件数据
		model.addAttribute("mRecordData", exportService.getMrecordData(id));
		
		return "/cargo/export/jExportUpdate.jsp";
	}
	
	// 修改
	@RequestMapping("/cargo/export/update.action")
	public String update(Export export,
				String[] mr_id,
				Integer[] mr_orderNo,
				Integer[] mr_cnumber,
				Double[] mr_grossWeight,
				Double[] mr_netWeight,
				Double[] mr_sizeLength,
				Double[] mr_sizeWidth,
				Double[] mr_sizeHeight,
				Double[] mr_exPrice,
				Double[] mr_tax
//     			Integer[] mr_changed
			){
		exportService.update(export,mr_id,mr_orderNo,mr_cnumber,mr_grossWeight,
				             mr_netWeight,mr_sizeLength,mr_sizeWidth,mr_sizeHeight,mr_exPrice,mr_tax);
		
		return "redirect:/cargo/export/list.action";
	}
	
	// 上报
	@RequestMapping("/cargo/export/submit.action")
	public String submit(@RequestParam("id") String[] ids){
		exportService.submit(ids);
		
		return "redirect:/cargo/export/list.action";
	}
	
	// 草稿
	@RequestMapping("/cargo/export/cancel.action")
	public String cancel(@RequestParam("id") String[] ids){
		exportService.cancel(ids);
		
		return "redirect:/cargo/export/list.action";
	}
	
	// 删除
		@RequestMapping("/cargo/export/delete.action")
		public String  delete(@RequestParam("id") String[] ids){
			exportService.delete(ids);
			
			return "redirect:/cargo/export/list.action";
		}
		
	/*	// 查询
		@RequestMapping("/cargo/contract/toview.action")
		public String toview(String id,Model model){
//			Contract obj = contractService.get(id);
			ContractVO obj = exportService.view(id);
			model.addAttribute("obj", obj);
			
			return "/cargo/contract/jExportView.jsp";
		}
*/	
		
		@RequestMapping("/cargo/export/toview.action")
		public String toview(String id,Model model){
			Export obj = exportService.get(id);
			model.addAttribute("obj", obj);
			
			return "/cargo/export/jExportView.jsp";

		}
		
}
