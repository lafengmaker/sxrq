package com.lafengmaker.app.pub;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lafengmaker.core.entity.NoticePub;
import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.exception.UserException;
import com.lafengmaker.core.service.NoticePubService;
import com.lafengmaker.core.util.SessionUtil;
import com.lafengmaker.core.util.StringUtil;
@Controller
public class NoticePubController {
	private NoticePubService noticePubService;
	@RequestMapping(value="pub/publist")
	public String showNoticeListPage(@ModelAttribute NoticePub noticePub,HttpServletRequest request,ModelMap modelMap,Integer currpage ,BindingResult bindingResult){
		if(null==currpage){
			currpage=1;
		}
		modelMap.addAttribute("pageView", this.noticePubService.getNotcePub(currpage,noticePub));
		modelMap.addAttribute("noticePub", noticePub);
		return "pub/publist";
	}
	@RequestMapping(value="pub/addNoticeBefore")
	public String addNoticeBefore( HttpServletRequest request ,ModelMap map,@ModelAttribute NoticePub noticePub){
		User u= SessionUtil.getUserFromRequest(request);
		if(!"1".equals(u.getRole())){
			throw new UserException("用户状态异常，请重新登录");
		}
		noticePub.setShowindex(1);
		noticePub.setUserid(u.getId());
		noticePub.setAdduser(u.getName());
		String id=request.getParameter("id");
		if(!StringUtil.isEmpty(id)){
			noticePub=	this.noticePubService.getNoticePubById(StringUtil.getLong(id));
		}
		map.addAttribute("noticePub", noticePub);
		return "pub/pubedit";		
	}
	@RequestMapping(value="pub/noticeadd")
	public String addNotice(ModelMap	 modelMap,HttpServletRequest request,@ModelAttribute NoticePub noticePub){
		this.noticePubService.insertOrupdateNoticePub(noticePub);
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"publist";
	}
	public NoticePubService getNoticePubService() {
		return noticePubService;
	}
	@Autowired
	public void setNoticePubService(NoticePubService noticePubService) {
		this.noticePubService = noticePubService;
	}
	
}
