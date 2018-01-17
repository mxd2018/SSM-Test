package com.mxd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxd.dao.IUserDao;
import com.mxd.pojo.po.User;

@Service
public class UserServiceImpl {
	@Autowired
	private IUserDao userDao;
	
	public User findUserByName(User user){
		User u = userDao.findUserByName(user);
		return u;
	}
	
}
