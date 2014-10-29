package com.lafengmaker.app.gasuse;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.exception.UserException;
import com.lafengmaker.core.service.GasUseService;
import com.lafengmaker.core.service.UserService;
import com.lafengmaker.core.util.SessionUtil;
import com.lafengmaker.view.gasuse.GasUseSearch;
import com.lafengmaker.view.gasuse.GasUseView;

@Controller
public class GasUseController {
	private UserService userService;
	private GasUseService gasUseService;
	@RequestMapping(value="gasuse/uselist")
	public String getUseList(ModelMap map,HttpServletRequest request, @ModelAttribute GasUseSearch search,Integer currpage){
		if(null==currpage){
			currpage=1;
		}
		User u=SessionUtil.getUserFromRequest(request);
		map.addAttribute("usedisable", true);
		if(!"1".equals(u.getRole())){
			search.setUserid(u.getId());
		}else{
			map.addAttribute("usedisable", false);
		}
		List<User>uss=this.userService.getcommUser();
		map.addAttribute("users", uss);
		map.addAttribute("search",search);
		map.addAttribute("pageView", this.gasUseService.getGesUsePageView(search, currpage.intValue()));
		return "gas/gasuselist";
	}
	@RequestMapping(value="gasuse/gasaddbefore")
	public String addBrefor(ModelMap map,HttpServletRequest request){
		User u=SessionUtil.getUserFromRequest(request);
		String p=request.getParameter("p");
		
		if(!"1".equals(u.getRole())){
			throw new UserException("用户异常，请重新登录");
		}
		List<User>uss=this.userService.getcommUser();
		map.addAttribute("users", uss);
		GasUseView gv=this.gasUseService.findgasUseViewById(p);
		map.addAttribute(gv);
		return "gas/useradd";
	}
	@RequestMapping(value="gasuse/gasadd")
	public String add(ModelMap map,HttpServletRequest request,@Valid @ModelAttribute GasUseView gasUseView,BindingResult result){
		List<User>uss=this.userService.getcommUser();
		map.addAttribute("users", uss);
		if(result.hasErrors()){
			return "gas/useradd";
		}
		try {
			this.gasUseService.addGasuse(gasUseView.toGasUse());
		} catch (Exception e) {
			result.rejectValue("addtime", null, e.getMessage());
			return "gas/useradd";
		}
		map.addAttribute(gasUseView);
		return  "success";
	}
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public GasUseService getGasUseService() {
		return gasUseService;
	}
	@Autowired
	public void setGasUseService(GasUseService gasUseService) {
		this.gasUseService = gasUseService;
	}
	
}
