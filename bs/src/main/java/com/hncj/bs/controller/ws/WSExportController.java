package com.hncj.bs.controller.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 在系统中调用cxf 提供webservice
 * @author Administrator
 *
 */
@Controller
public class WSExportController {

	@RequestMapping("/ws/export/toedit.action")
	public String toedit(){
		
		return "/ws/export/ajaxExport.jsp";
		
	}
}
