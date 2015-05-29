package org.springframework.mystudy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.mystudy.entity.User;
import org.springframework.mystudy.model.UserModel;
import org.springframework.mystudy.service.UserService;
import org.springframework.mystudy.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mystudy/*")
public class UserController {

	@Resource
	private UserService userService;
	
	//@RequestMapping("/mystudy/userInfo")
	@RequestMapping(value = "login", method = RequestMethod.GET)
	@ModelAttribute("userModel")
	public ModelAndView simple() {
		UserModel um = new UserModel();
		//um.setUsername("xiaoming");
		//um.setPassword("123456");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userModel", um);
        mv.setViewName("mystudy/login");
		return mv;
	}

	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String doLogin (@ModelAttribute("userModel") UserModel userModel, RedirectAttributes ra,
		Model model, HttpSession session) {
	
		userModel.setPassword(Util.encryptMD5(userModel.getPassword()));
		User user = userService.findUserByCondition(userModel);
		if (user == null) {
			model.addAttribute("errorInfo", "you password is error!");
			return "mystudy/login";
		}
		
		session.setAttribute("loginUser", userModel);
		// forward方式可以共享userModel
		// return "forward:/user/index";
		
		// 重定向方式传递参数
		// ra.addFlashAttribute("username", user.getUsername());
		return "redirect:index";
	}
	
	@RequestMapping("index")
	public ModelAndView index(UserModel userModel, HttpSession session) {
		if(session.getAttribute("loginUser") == null){
			ModelAndView mav = new ModelAndView("mystudy/login");
			mav.addObject("errorInfo", "user is overdue!");
			return mav;
		}
	    return new ModelAndView("mystudy/success");
	}
}
