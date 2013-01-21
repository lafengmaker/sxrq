package com.lafengmaker.app.user;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lafengmaker.core.entity.User;


@Controller
@RequestMapping("user")
public class UserController {

	public final static Map<String,User> map=new HashMap<String, User>();
	
	public UserController(){
		map.put("zhangsan", new User("zhangsan","张三"));
		map.put("lisi", new User("lisi","李四"));
		map.put("wangwu", new User("wangwu","王五"));
		map.put("zhuliu", new User("zhuliu","朱六"));
	}
	@RequestMapping(value="/users")
	public String list(Model model){
		model.addAttribute("users",map);//
		return "user/list";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute(new User());//
		return "user/add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid User user,BindingResult binding){
		if(binding.hasErrors()){
			return "user/add";
		}
		map.put(user.getUsername(), user);
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/user/users";
	}
}
