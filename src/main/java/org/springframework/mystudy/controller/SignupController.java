package org.springframework.mystudy.controller;

import javax.validation.Valid;

import org.springframework.mystudy.model.SingupModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mystudy/signup")
public class SignupController {

	@RequestMapping(method=RequestMethod.GET)
	@ModelAttribute("signupModel")
	public SingupModel createSignupModel() {
		SingupModel sm = new SingupModel();
		sm.setName("匿名者");
		sm.setAge(18);
		return sm;
	}
	

	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@Valid @ModelAttribute("signupModel")SingupModel signupModel,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return null;
		}
		
		System.out.println("***************************");
		System.out.println(signupModel.getName());
		System.out.println(signupModel.getAge());
		System.out.println(signupModel.getBirthDate());
		System.out.println(signupModel.getPhone());
		System.out.println(signupModel.getCurrency());
		System.out.println(signupModel.getPercent());
		System.out.println(signupModel.getFeedback().getValue());
		System.out.println(signupModel.getFeedbackDetails());
		System.out.println(signupModel.getAdditionalInfo().get("mvc"));
		System.out.println(signupModel.getAdditionalInfo().get("java"));
		System.out.println(signupModel.isSubscribeNewsletter());
		System.out.println("***************************");
		
		String message = "Form submitted successfully.  Bound " + signupModel;
		model.addAttribute("message", message);
		return "/mystudy/signup";
	}
	
}