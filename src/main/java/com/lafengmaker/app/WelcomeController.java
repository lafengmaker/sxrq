package com.lafengmaker.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lafengmaker.core.service.NoticePubService;
import com.lafengmaker.core.util.StringUtil;
@Controller
public class WelcomeController {
	private NoticePubService noticePubService;
	@RequestMapping(value="welcomeinfo")
	public String showWelcomeInfo(HttpServletRequest request,ModelMap modelMap){
		modelMap.addAttribute("pubs", this.noticePubService.showNoticeOnWelcome());
		return "welcome";
	}
	@RequestMapping(value="shownoticeinfo")
	public String showNotice(HttpServletRequest request,ModelMap modelMap){
		String ids=request.getParameter("id");
		Long id=StringUtil.getLong(ids);
		modelMap.addAttribute("pub",this.noticePubService.getNoticePubById(id));
		return "noticeinfo";
	}
	public NoticePubService getNoticePubService() {
		return noticePubService;
	}
	@Autowired
	public void setNoticePubService(NoticePubService noticePubService) {
		this.noticePubService = noticePubService;
	}
	
}
