package com.hncj.bs.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hncj.bs.controller.BaseController;
import com.hncj.bs.domain.ContractProduct;
import com.hncj.bs.domain.Factory;
import com.hncj.bs.service.ContractProductService;
import com.hncj.bs.service.FactoryService;

@Controller
public class ContractProductController extends BaseController {

	@Resource
	ContractProductService contractProductService;
	
	@Resource
	FactoryService factoryService;
	
	// 转向新增页面
	@RequestMapping("/cargo/contractproduct/tocreate.action")
	public String tocreate(String contractId, Model model){
		model.addAttribute("contractId", contractId);                          //传递主表的ID
		
		//准备生产产家的下拉列表
		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		// 某个合同下的货物列表
		Map paraMap = new HashMap();
		paraMap.put("contractId", contractId);
		List<ContractProduct> dataList = contractProductService.find(paraMap);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/contract/jContractProductCreate.jsp";                   //货物的新增页面
	}
	
	// 新增保存
	@RequestMapping("/cargo/contractproduct/insert.action")
	public String insert(ContractProduct contractProduct, Model model){
		contractProductService.insert(contractProduct);
		model.addAttribute("contractId", contractProduct.getContractId());    //传递主表的ID
		
		return "redirect:/cargo/contractproduct/tocreate.action";            //新增完成后再转向新增页面—批量新增
	}
	
	// 转向修改页面
	@RequestMapping("/cargo/contractproduct/toupdate.action")
	public String toupdate(String id, Model model){
		ContractProduct obj = contractProductService.get(id);
		model.addAttribute("obj", obj);
		//准备生产产家的下拉列表
		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		
		return "/cargo/contract/jContractProductUpdate.jsp"; 
	}
	
	// 修改保存
	@RequestMapping("/cargo/contractproduct/update.action")
	public String update(ContractProduct contractProduct){
		contractProductService.update(contractProduct);
		
		return "redirect:/cargo/contractproduct/tocreate.action"; 
	}
	
	// 删除
	@RequestMapping("/cargo/contractproduct/deleteById.action")
	public String deleteById(String id,String contractId,Model model){
		contractProductService.deleteById(id);
		model.addAttribute("contractId",contractId);       // 传递主键ID
		
		return "redirect:/cargo/contractproduct/tocreate.action"; 
	}
	
	
}
