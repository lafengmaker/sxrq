package com.lafengmaker.app.pub;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lafengmaker.core.entity.NoticePub;
import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.exception.UserException;
import com.lafengmaker.core.service.NoticePubService;
import com.lafengmaker.core.service.UserService;
import com.lafengmaker.core.util.SessionUtil;
import com.lafengmaker.core.util.StringUtil;
@Controller
public class NoticePubController {
	private Logger logger=Logger.getLogger(NoticePubController.class);
	private NoticePubService noticePubService;
	private UserService userService;
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
		map.addAttribute("users", userService.getAllUser());
		noticePub.setShowindex(1);
		noticePub.setUserid(u.getId());
		noticePub.setAdduser(u.getName());
		noticePub.setTouser(null);
		String id=request.getParameter("id");
		if(!StringUtil.isEmpty(id)){
			noticePub=	this.noticePubService.getNoticePubById(StringUtil.getLong(id));
		}
		map.addAttribute("noticePub", noticePub);
		return "pub/pubedit";		
	}
	@RequestMapping(value="pub/noticeadd")
	public String addNotice(ModelMap	 modelMap,MultipartHttpServletRequest request,@ModelAttribute NoticePub noticePub) throws Exception{
		noticePub.setDeleteflag(0);
			List<MultipartFile> files = request.getFiles("file");  
			String [] vfid=request.getParameterValues("vfid");
			this.noticePubService.insertOrupdateNoticePub(noticePub,files,vfid);
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"publist";
	}
	@RequestMapping(value="pub/pubdel")
	@ResponseBody
	public ModelAndView delUserByid(HttpServletRequest request,ModelMap map,Long id){
		logger.info("delete:"+id);
		try {
			this.noticePubService.delNoticePub(id);
		} catch (Exception e) {
			logger.error("删除出错",e);
		}
		return null;  
	}
	
	public NoticePubService getNoticePubService() {
		return noticePubService;
	}
	@Autowired
	public void setNoticePubService(NoticePubService noticePubService) {
		this.noticePubService = noticePubService;
	}
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
