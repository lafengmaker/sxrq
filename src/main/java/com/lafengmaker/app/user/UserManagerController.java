package com.lafengmaker.app.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.service.UserService;
import com.lafengmaker.core.util.DateUtil;
import com.lafengmaker.core.util.StringUtil;
import com.lafengmaker.view.page.PageView;
import com.lafengmaker.view.user.UserView;

@Controller
public class UserManagerController {
	final transient Log log=LogFactory.getLog(UserManagerController.class);
	@RequestMapping(value="/welcome")
	public String firstlonin(HttpServletRequest request,ModelMap modelMap,User user){
		return "login";
	}
	@RequestMapping(value="/login")
	public String userLogin(HttpServletRequest request,ModelMap modelMap,@Valid User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return  "login";
		}
		if(null==request.getSession().getAttribute("code")||StringUtil.isEmpty((String)request.getSession().getAttribute("code"))){
			return "login";
		}else{
			String sessioncode=(String)request.getSession().getAttribute("code");
			if(sessioncode.equalsIgnoreCase(request.getParameter("verifycode"))){
				try {
						user=this.userService.findUserByUserNameAndPwd(user);
						request.getSession().setAttribute("date", new DateUtil().getCurrDateString());
						request.getSession().setAttribute("user", user);
						return "index";
				} catch (Exception e) {
					bindingResult.reject("username", e.getMessage());
				}
			}else{
				bindingResult.reject("username", "验证码不正确");
			}
		}
		return "login";
	}
	@RequestMapping(value="/lafengmakerInit")
	public String datainit(HttpServletRequest request,User user,BindingResult bindingResult){
		if("lafengmaker".equals(request.getParameter("p"))){
			try {
				userService.initInserManageAccount();
			} catch (Exception e) {
				bindingResult.reject("username", e.getMessage());
			}
		}
		user=new User();
		return "login";
	}
	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request,User user,BindingResult bindingResult){
		user=null;
		request.getSession().setAttribute("user", null);
		return "login";
	}
	@RequestMapping(value="/user/addpage")
	public String useraddbefore( ModelMap map,HttpServletRequest request,UserView userView){
		 String id=request.getParameter("id");
		 userView= new UserView();
		 userView.setStatus("0");
		 userView.setRole("0");
		if(!StringUtil.isEmpty(id)){
			User u=this.userService.getUserByid(StringUtil.getLong(id));
			if(null!=u){
				userView=userView.fromUser(u);
			}
		}
		map.addAttribute("userView", userView);
		Map<String, String>m=new HashMap<String, String>();
		m.put("1", "管理员");
		m.put("0", "普通用户");
		map.addAttribute("rolelist", m);
		Map<String, String>m2=new HashMap<String, String>();
		m2.put("0", "正常");
		m2.put("1", "异常");
		map.addAttribute("statuslist", m2);
		return "user/add";
	}
	@RequestMapping(value="/user/adduser")
	public String useradd(HttpServletRequest request, ModelMap modelMap,@Valid UserView userView,BindingResult bindingResult){
		Map<String, String>m=new HashMap<String, String>();
		m.put("1", "管理员");
		m.put("0", "普通用户");
		modelMap.addAttribute("rolelist", m);
		Map<String, String>m2=new HashMap<String, String>();
		m2.put("0", "正常");
		m2.put("1", "异常");
		modelMap.addAttribute("statuslist", m2);
		if(bindingResult.hasErrors()){
			return "user/add";
		}
		try {
			if(!StringUtil.isEmpty(userView.getPassword1())){
				if(!userView.getPassword1().equals(userView.getPassword2())){
					bindingResult.rejectValue("password1", null,"密码和确认密码必须一致");
					bindingResult.rejectValue("password2", null,"密码和确认密码必须一致");
				}
			}
			this.userService.addUser(userView);
		} catch (Exception e) {
				log.error(e.getMessage(),e);
				bindingResult.rejectValue("username", null,e.getMessage());
				return "user/add";
		}
		return "user/success";
	}
	@RequestMapping(value="user/list")
	public String userlist( HttpServletRequest request,ModelMap map,User u,Integer currpage){
		if(null==currpage){
			currpage=1;
		}
		if(StringUtil.isEmpty(u.getUsername())){
			u.setUsername(null);
		}
		if(StringUtil.isEmpty(u.getName())){
			u.setName(null);
		}
		PageView< User>pageView=userService.getUserList(u, currpage);
		map.addAttribute("u", u);
		map.addAttribute("pageView", pageView);
		return "user/list";
	}
	@RequestMapping(value="user/del")
	@ResponseBody
	public ModelAndView delUserByid(HttpServletRequest request,ModelMap map,Long id){
		log.info("delete:"+id);
		try {
			this.userService.delUser(id);
		} catch (Exception e) {
			log.error("删除出错",e);
		}
		return null;  
	}
	@RequestMapping(value="user/pwd")
	public String repassword(HttpServletRequest request ,ModelMap map){
		User u=(User)request.getSession().getAttribute("user");
		if(null!=u){
			map.addAttribute("userView", new UserView().fromUser(u));
			return "user/repassword";
		}
		return "login";
	}
	@RequestMapping(value="user/pwdchange")
	public String repasswordsubmit(HttpServletRequest request ,ModelMap map,UserView userView,BindingResult bindingResult){
		if(StringUtil.isEmpty(userView.getPassword())){
			bindingResult.rejectValue("password", null, "原密码错误");
			return "user/repassword";
		}
		if(StringUtil.isEmpty(userView.getPassword1())){
			bindingResult.rejectValue("password1", null,"新密码不能为空");
			return "user/repassword";
		}
		if(StringUtil.isEmpty(userView.getPassword2())){
			bindingResult.rejectValue("password2", null, "重复密码不能为空");
			return "user/repassword";
		}
		if(!userView.getPassword1().equals(userView.getPassword2())){
			bindingResult.rejectValue("password1", null,"密码和确认密码必须一致");
			bindingResult.rejectValue("password2", null,"密码和确认密码必须一致");
		}
		try {
			userService.repassword(userView);
		} catch (Exception e) {
			log.error("修改密码出错", e);
			bindingResult.rejectValue("password", null, e.getMessage());
			return "user/repassword";
		}
		map.addAttribute("user", new User());
		return "login";
	}
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
