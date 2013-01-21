package com.lafengmaker.core.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafengmaker.core.dao.UserDao;
import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.exception.UserException;
import com.lafengmaker.core.helper.ScheduleHelper;
import com.lafengmaker.core.util.MD5Util;
import com.lafengmaker.view.page.PageView;
import com.lafengmaker.view.user.UserView;
@Service
public class UserServiceImpl  implements UserService{
	private UserDao userDao;
	private ScheduleHelper scheduleHelper;
	public void initInserManageAccount() throws Exception {
		Log log =LogFactory.getLog(UserServiceImpl.class);
		User u=new User();
		u.setUsername("admin");
		List<User>ul=userDao.queryEnetityByT(u);
		if(null!=ul&&ul.size()>0){
			log.info("admin has been generated!");
		}else{
			u.setPassword(MD5Util.getMD5Str("1"));
			u.setRole("1");
			u.setStatus("0");
			u.setName("admin");
			userDao.insertEntity(u);
		}
	}
	public User findUserByUserNameAndPwd(User u) throws Exception {
		if(null!=u){
			User u2=new User();
			u2.setUsername(u.getUsername());
			List<User>ul=	userDao.queryEnetityByT(u2);
			if(null!=ul&&ul.size()>0){
				u2=ul.get(0);
				if(!MD5Util.getMD5Str(u.getPassword()).equals(u2.getPassword())){
					throw new UserException("密码不正确");
				}else{
					if(!"0".equals(u2.getStatus())){
						 throw new UserException("账户状态异常");
					}
					u2.setLogintimes(null==u2.getLogintimes()?1:u2.getLogintimes()+1);
					this.userDao.updateEntity(u2);
					return u2;
				}
			}else{
				throw new UserException("用户不存在");
			}
		}else{
			throw new UserException("");
		}
	}
	public PageView<User> getUserList(User u, int currpage) {
		PageView<User>pv=new PageView<User>(currpage);
		List<User>list=this.userDao.queryEnetityByTPage(u, pv.getFirstResult());
		long total=this.userDao.queryEnetityByTPageCount(u, null);
		pv.setTotalrecord(total);
		pv.setRecords(list);
		return pv;
	}
	public void addUser(UserView userView) throws Exception {
		if(null!=userView){
			User u=userView.toUser();
			User s=new User();
			s.setUsername(u.getUsername());
			List<User>ul=	this.userDao.queryEnetityByT(s);
			if(null!=u.getId()&&!"0".equals(u.getId())){
				if(null!=ul&&ul.size()>0){
					if(ul.get(0).equals(u.getId())){
						throw new UserException("用户名已经存在");
					}
				}
				this.userDao.updateEntity(u);
			}else{
				if(null!=ul&&ul.size()>0){
					throw new UserException("用户名已经存在");
				}
				this.userDao.insertEntity(u);
				this.scheduleHelper.insertWeekScheduleForUser(u.getId());
			}
		}
	}
	
	public void  delUser(Long id) throws Exception {
		User u=this.userDao.queryEnetityById(User.class,id);
		if(null==u){
			throw  new UserException("没有此id对应的数据");
		}
		u.setIsdelete("1");
		this.userDao.updateEntity(u);
	}
	
	public UserView repassword(UserView userView) {
		User u=this.getUserByid(userView.getId());
		if(null!=u){
			if(MD5Util.getMD5Str(userView.getPassword()).equals(u.getPassword())){
				u.setPassword(MD5Util.getMD5Str(userView.getPassword1()));
				this.userDao.updateEntity(u);
			}else{
				throw new UserException("原密码不对");
			}
		}else{
			throw new UserException("数据不对");
		}
		return null;
	}
	public User getUserByid(Long id) {
	return this.userDao.queryEnetityById(User.class,id);
	}
	
	public List<User> getAllUser() {
		try {
			return this.userDao.queryEnetityByT(new User());
		} catch (Exception e) {
			return new ArrayList<User>();
		}
	}
	public UserDao getUserDao() {
		return userDao;
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public ScheduleHelper getScheduleHelper() {
		return scheduleHelper;
	}
	@Autowired
	public void setScheduleHelper(ScheduleHelper scheduleHelper) {
		this.scheduleHelper = scheduleHelper;
	}
	
	
	
}
