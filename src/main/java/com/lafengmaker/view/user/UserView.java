package com.lafengmaker.view.user;

import javax.validation.constraints.Size;

import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.util.MD5Util;
import com.lafengmaker.core.util.StringUtil;

public class UserView {
	@Size(max=20,min=1,message="用户名长度在{min}--{max}之间")
	private String username;
	@Size(max=20,min=1,message="姓名长度在{min}--{max}之间")
	private String name;
	private String status;
	private String role;
	private Long id;
	private String password;
	private String password1;
	private String password2;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public User toUser(){
		User u=new User();
		u.setId(id);
		u.setUsername(username);
		u.setName(name);
		u.setRole(role);
		u.setStatus(status);
		u.setPassword(StringUtil.isEmpty(password1)?MD5Util.getMD5Str("123456"):MD5Util.getMD5Str(password1));
		return u;
	}
	public UserView fromUser(User u){
		UserView userView=new UserView();
		if(null!=u){
			userView.setUsername(u.getUsername());
			userView.setName(u.getName());
			userView.setStatus(u.getStatus());
			userView.setRole(u.getRole());
			userView.setId(u.getId());
		}
		return userView;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
