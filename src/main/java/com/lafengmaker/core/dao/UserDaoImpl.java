package com.lafengmaker.core.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lafengmaker.core.dao.impl.BaseDaoImpl;
import com.lafengmaker.core.entity.User;
@Repository(value="userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	

}
