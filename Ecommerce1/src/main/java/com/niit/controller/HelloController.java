package com.niit.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.User;
import com.niit.model.UserStatus;
import com.niit.dao.UserDao;

@Controller
public class HelloController {
    @Autowired
	private UserDao userDao;
	@Autowired
	private User user;
	@RequestMapping("/indexopen")
	public String setindex() {
		return "index";
	}

	@RequestMapping({"/index", "/"})
	public String setupHome() {
		return "home";
	}
	@RequestMapping("/loginopen")
	public String loginForm(Map<String, Object> map) {

		return "login";
	}

	@RequestMapping("/registeropen")
	public String regForm(Map<String, Object> map) {

		return "register";
	}
	
    @RequestMapping("/register")
	public String regFormSubmit(HttpServletRequest req, HttpServletResponse res) {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		 user = new User();
		//user.setId(125);
		user.setFirstname(fname);
		user.setLastname(lname);
		user.setEmail(email);
		user.setUsername(uname);
		user.setPassword(pwd);
		user.setStatus(UserStatus.ACTIVE);
		userDao.saveUser(user);
		return "login";
	}


 @RequestMapping("/login")
/*public ModelAndView loginCheck(HttpServletRequest req,HttpServletResponse res) {
	 String username=req.getParameter("uname");
	 String password=req.getParameter("pwd");
	 ModelAndView mav = new ModelAndView();
	 boolean userExists = userDao.checklogin(username,password);
		if(userExists){		
			//System.out.println("in controller");
			mav.addObject("uname",username);		
			mav.setViewName("loginSuccess");
		} else {
			mav.setViewName("loginFailed");

		}
		return mav;

 }*/
 public String doLogin(){
		return "login";
	}
 
}
