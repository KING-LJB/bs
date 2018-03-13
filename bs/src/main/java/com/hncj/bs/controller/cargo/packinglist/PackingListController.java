package com.hncj.bs.controller.cargo.packinglist;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hncj.bs.controller.BaseController;
import com.hncj.bs.domain.PackingList;
import com.hncj.bs.service.PackingListService;

@Controller
public class PackingListController extends BaseController{

	@Resource
	PackingListService packingListService;
	
	@RequestMapping("/cargo/packinglist/list.action")
	public String list(Model model){
		List<PackingList> dataList = packingListService.find(null);
		model.addAttribute("dataList", dataList);

		return "/cargo/packinglist/jPackingListList.jsp";
	}
	
	@RequestMapping("/cargo/packinglist/tocreate.action")
	public String tocreate(String[] id,Model model){                      //出口报运的id集合
		
		String divData = packingListService.getDivDataCreate(id);               // 获取放在div中的报运的相关信息
		model.addAttribute("divData", divData);                           //显示装箱和报运的关系
		
		return "/cargo/packinglist/jPackingListCreate.jsp";
	}
	
	@RequestMapping("/cargo/packinglist/insert.action")
	public String insert(PackingList packingList){
		packingListService.insert(packingList);
		
		return "redirect:/cargo/packinglist/list.action";
	}
	
	
	@RequestMapping("/cargo/packinglist/toupdate.action")
	public String toupdate(String id, Model model){
		PackingList obj = packingListService.get(id);
		model.addAttribute("obj", obj);
		
		String _s = packingListService.getDivDataUpdate(obj.getExportIds().split("\\|"), obj.getExportNos().split("\\|"));
		model.addAttribute("divData", _s);
		
		return "/cargo/packinglist/jPackingListUpdate.jsp";
	}
	
	@RequestMapping("/cargo/packinglist/update.action")
	public String update(PackingList packingList){
		packingListService.update(packingList);
		
		return "redirect:/cargo/packinglist/list.action";
	}
	
	@RequestMapping("/cargo/packinglist/toview.action")
	public String toview(String id,Model model){
		PackingList obj = packingListService.get(id);
		model.addAttribute("obj", obj);
		model.addAttribute("divData", packingListService.getDivDataView(obj.getExportNos().split("\\|")));
		
		return "/cargo/packinglist/jPackingListView.jsp";
	}
	
	@RequestMapping("/cargo/packinglist/delete.action")
	public String delete(@RequestParam("id") String[] ids){
		packingListService.delete(ids);
		
		return "redirect:/cargo/packinglist/list.action";
	}
	
	@RequestMapping("/cargo/packinglist/deleteById.action")
	public String deleteById(String id){
		packingListService.deleteById(id);
		
		return "redirect:/cargo/packinglist/list.action";
	}
	
	// 上报
	@RequestMapping("/cargo/packinglist/submit.action")
	public String submit(@RequestParam("id") String[] ids){
		packingListService.submit(ids);
		
		return "redirect:/cargo/packinglist/list.action";
	}
	
	// 草稿
	@RequestMapping("/cargo/packinglist/cancel.action")
	public String cancel(@RequestParam("id") String[] ids){
		packingListService.cancel(ids);
		
		return "redirect:/cargo/packinglist/list.action";
	}
	
}
