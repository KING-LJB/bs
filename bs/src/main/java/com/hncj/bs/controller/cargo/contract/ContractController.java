package com.hncj.bs.controller.cargo.contract;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hncj.bs.controller.BaseController;
import com.hncj.bs.domain.Contract;
import com.hncj.bs.print.ContractPrint;
import com.hncj.bs.print.ContractPrintTemplate;
import com.hncj.bs.service.ContractService;
import com.hncj.bs.vo.ContractVO;

@Controller
public class ContractController extends BaseController{
	
	@Resource
	ContractService contractService;
	
	@RequestMapping("/cargo/contract/list.action")
	public String list(Model model){
		List<Contract> dataList = contractService.find(null);
		model.addAttribute("dataList", dataList);

		return "/cargo/contract/jContractList.jsp";
	}
	
	// 转向新增页面
    @RequestMapping("cargo/contract/tocreate.action")
	public String tocreate(){
		return "/cargo/contract/jContractCreate.jsp";
	}
    
	// 新增保存
	@RequestMapping("/cargo/contract/insert.action")
	public String insert(Contract contract){
		contractService.insert(contract);

		return "redirect:/cargo/contract/list.action";
	}

	// 转向查询页面
	@RequestMapping("/cargo/contract/toupdate.action")
    public String toupdate(String id, Model model){
    	Contract obj = contractService.get(id);
    	model.addAttribute("obj", obj);
		
    	return "/cargo/contract/jContractUpdate.jsp";
    } 	
	
	// 修改
	@RequestMapping("/cargo/contract/update.action")
	public String update(Contract contract){
		contractService.update(contract);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	// 删除
	@RequestMapping("/cargo/contract/delete.action")
	public String  delete(@RequestParam("id") String[] ids){
		contractService.delete(ids);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	// 查询
	@RequestMapping("/cargo/contract/toview.action")
	public String toview(String id,Model model){
//		Contract obj = contractService.get(id);
		ContractVO obj = contractService.view(id);
		model.addAttribute("obj", obj);
		
		return "/cargo/contract/jContractView.jsp";
	}
	
	// 上报
	@RequestMapping("/cargo/contract/submit.action")
	public String submit(@RequestParam("id") String[] ids){
		contractService.submit(ids);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	// 草稿
	@RequestMapping("/cargo/contract/cancel.action")
	public String cancel(@RequestParam("id") String[] ids){
		contractService.cancel(ids);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	   //合同打印  (不采用模板的打印方式)
		@RequestMapping("/cargo/contract/print.action")
		public void print(String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
			ContractPrint cp = new ContractPrint();
			
			ContractVO obj = contractService.view(id);
			cp.print(obj, request.getSession().getServletContext().getRealPath("/"), response);
		}
	
		//合同模板打印
		@RequestMapping("/cargo/contract/printTemplate.action")
		public void printTemplate(String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
			ContractPrintTemplate cp = new ContractPrintTemplate();
			
			ContractVO obj = contractService.view(id);
			cp.print(obj, request.getSession().getServletContext().getRealPath("/"), response);
			//cp.print();
		}
}
