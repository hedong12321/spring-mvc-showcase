package org.springframework.mystudy.controller;

import org.springframework.mystudy.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mystudy/*")
public class ShowUserInfoController {

	//@RequestMapping("/mystudy/userInfo")
	@RequestMapping(value="userInfo", method=RequestMethod.GET)
	public @ResponseBody ModelAndView simple() {
		UserModel um = new UserModel();
		um.setUsername("xiaoming");
		um.setPassword("123456");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", um);
        mv.setViewName("mystudy/mystudy");
		return mv;
	}

}
