package com.mxd.web;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mxd.pojo.po.User;
import com.mxd.service.UserServiceImpl;

@Controller
@RequestMapping(value="/user")
public class UserLogin {
	@Autowired
	private UserServiceImpl uService;
	
	@RequestMapping(value="/tologin.do")
	public String toLogin(){
		return "login";
	}
	@RequestMapping(value="/login")
	public String findUserByName(User user,HttpSession session){
		if(user!=null){
			User u = uService.findUserByName(user);
			if(u==null){
				return "redirect:tologin.do";
			}else{
				session.setAttribute("sessionUser", u);
				return "success";
			}
		}else{
			return "redirect:tologin.do";
		}
		
		
		
	}
	
}
