package org.springframework.mystudy.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mystudy.model.FeedbackType;
import org.springframework.mystudy.model.PhoneNumberModel;
import org.springframework.mystudy.model.SingupModel;
import org.springframework.mystudy.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

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
		System.out.println(signupModel.getFormNo());
		System.out.println(signupModel.getCurrency());
		System.out.println(signupModel.getPercent());
		System.out.println(signupModel.getFeedback().getValue());
		System.out.println(signupModel.getFeedbackDetails());
		System.out.println("checkbook -->  map");
		System.out.println(signupModel.getAdditionalInfo().get("mvc"));
		System.out.println(signupModel.getAdditionalInfo().get("java"));
		System.out.println(signupModel.isSubscribeNewsletter());
		System.out.println("checkbook -->  list");
		System.out.println(signupModel.getSports().get(0));
		System.out.println(signupModel.getSports().get(1));
		System.out.println(signupModel.getSports().get(2));
		System.out.println("验证通过的日期String");
		System.out.println(signupModel.getStatisticsDate());
		System.out.println("自定义类型转换String  -->  PhoneNumber");
		System.out.println("区号：" + signupModel.getPhone().getAreaCode());
		System.out.println("电话号码：" + signupModel.getPhone().getPhoneNumber());
		System.out.println("***************************");
		
		String message = "表单数据提交成功！";
		model.addAttribute("message", message);
		return "/mystudy/signup";
	}
	
	@RequestMapping(value = "/format", method=RequestMethod.GET)
	public ModelAndView format(HttpServletRequest request, @RequestParam(value="langType", defaultValue="zh") String langType){
		Locale locale = new Locale("zh", "CN");
		if(langType.equals("zh")){
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
        }
        else if(langType.equals("en")){
            locale = new Locale("en", "US");
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
        }
        else
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
		
		SingupModel sm = new SingupModel();
		sm.setName(Util.getMessage(request, "user.name"));
		sm.setAge(22);
		sm.setBirthDate(new Date());
		sm.setFormNo("1231231234");
		sm.setEmail("xx@xx.com");
		sm.setCurrency(new BigDecimal(5000));
		sm.setPercent(new BigDecimal(0.88));
		sm.setStatisticsDate("2015-05-28");
		sm.setFeedback(FeedbackType.feedback);
		sm.setFeedbackDetails("feedback details!");
		sm.setSubscribeNewsletter(true);
		
		Map<String, String> additionalInfo = new HashMap<String, String>();
		additionalInfo.put("mvc", "true");
		additionalInfo.put("java", "true");
		sm.setAdditionalInfo(additionalInfo);
		
		List<String> sports = new ArrayList<String>();
		sports.add("basketball");
		sports.add("football");
		sports.add("ping-pong");
		sm.setSports(sports);
		
		PhoneNumberModel phone = new PhoneNumberModel();
		phone.setAreaCode("028");
		phone.setPhoneNumber("12345678");
		sm.setPhone(phone);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("signupModel", sm);
        mv.setViewName("/mystudy/format");
		return mv;
	}
	
}
