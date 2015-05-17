package org.springframework.mystudy.controller;

import org.springframework.mystudy.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mystudy/*")
public class UserController {

	//@RequestMapping("/mystudy/userInfo")
	@RequestMapping(value = "login", method = RequestMethod.GET)
	@ModelAttribute("user")
	public @ResponseBody ModelAndView simple() {
		UserModel um = new UserModel();
		//um.setUsername("xiaoming");
		//um.setPassword("123456");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", um);
        mv.setViewName("mystudy/login");
		return mv;
	}

	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String doLogin (@ModelAttribute("user") UserModel user, RedirectAttributes ra) {
	
		ra.addFlashAttribute("username", user.getUsername());
		return "redirect:success";
	}
}
