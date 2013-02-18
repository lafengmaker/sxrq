package com.lafengmaker.core.service;

import java.util.List;

import com.lafengmaker.core.entity.User;
import com.lafengmaker.view.page.PageView;
import com.lafengmaker.view.user.UserView;

public interface UserService {
	public void addUser(UserView userView) throws Exception;
	public void initInserManageAccount() throws Exception;
	public User findUserByUserNameAndPwd(User u)  throws Exception;
	public PageView<User> getUserList(User u,int currpage);
	public void delUser(Long id) throws Exception;
	public User getUserByid(Long id);
	public UserView repassword(UserView userView);
	public List<User> getAllUser();
	public List<User> getcommUser();
	public List<User> getcommUserNoEmpty();
	
}
