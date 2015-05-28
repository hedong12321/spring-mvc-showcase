package org.springframework.mystudy.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.mystudy.model.FeedbackType;
import org.springframework.mystudy.model.PhoneNumberModel;
import org.springframework.mystudy.model.SingupModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mystudy")
public class AjaxController {
	
	@RequestMapping("/ajax")
	public String toAjaxPage(){
		
		return "/mystudy/ajax";
	}

	@RequestMapping("/ajax/data")
	public @ResponseBody SingupModel getAjaxData(){
		SingupModel sm = new SingupModel();
		sm.setName("zhangsan");
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
		
		return sm;
	}
}
