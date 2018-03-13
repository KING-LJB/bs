package com.hncj.bs.controller.cargo.contracthis;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hncj.bs.controller.BaseController;
import com.hncj.bs.domain.Contract;
import com.hncj.bs.service.ContractHisService;
import com.hncj.bs.vo.ContractVO;

@Controller
public class ContractHisController extends BaseController {
	@Resource 
	ContractHisService contractHisService;
	
	// 历史购销合同列表
	@RequestMapping("/cargo/contracthis/list.action")
	public String list(Model model){
		List<Contract> dataList = contractHisService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/contracthis/jContractHisList.jsp";
	}
	
	//归档
	@RequestMapping("/cargo/contracthis/pigeinhole.action")
	public String pigeinhole(String[] id){
		contractHisService.pigeinhole(id);
		
		return "redirect:/cargo/contracthis/list.action";
	}
	
	// 取消归档
	@RequestMapping("/cargo/contracthis/pigeouthole.action")
	public String pigeouthole(String[] id){
		contractHisService.pigeouthole(id);	
		
		return "redirect:/cargo/contracthis/list.action";
	}
	
	// 查询
		@RequestMapping("/cargo/contracthis/toview.action")
		public String toview(String id,Model model){
//			Contract obj = contractService.get(id);
			ContractVO obj = contractHisService.view(id);
			model.addAttribute("obj", obj);
			
			return "/cargo/contracthis/jContractHisView.jsp";
		}
		
		
		// 删除
		@RequestMapping("/cargo/contracthis/delete.action")
		public String  delete(@RequestParam("id") String[] ids){
			contractHisService.delete(ids);
			
			return "redirect:/cargo/contracthis/list.action";
		}
	

}
