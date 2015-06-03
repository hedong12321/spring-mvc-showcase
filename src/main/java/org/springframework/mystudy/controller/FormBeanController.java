package org.springframework.mystudy.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mystudy.model.Clazz;
import org.springframework.mystudy.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.fabric.xmlrpc.base.Array;

@Controller
@RequestMapping("/mystudy")
public class FormBeanController {
	
	@RequestMapping(value = "/formBeanInit", method = RequestMethod.GET)
	public String formBeanInit(){
		
		return "/mystudy/formBean";
	}

	@RequestMapping(value = "/formBeanInit/multiModels", method = RequestMethod.POST)
	public String multiModels(Clazz clazz, Student student, HttpServletRequest req){
		System.out.println("*********************");
		System.out.println(clazz.getName());
		System.out.println(clazz.getGrade());
		System.out.println(student.getName());
		System.out.println(student.getAge());
		System.out.println("*******map***********");
		Map<String, String[]> map = req.getParameterMap();
		Set<Entry<String, String[]>> set = map.entrySet();
		Iterator<Entry<String, String[]>> it = set.iterator();
		Map<String, String> params = new HashMap<String, String>();
		while(it.hasNext()){
			Entry<String, String[]> et = it.next();
			params.put(et.getKey(), Arrays.toString(et.getValue()));
			System.out.println(et.getKey() + "--" + Arrays.toString(et.getValue()));
		}
		
		return "/mystudy/formBean";
	}
	
	/*@RequestMapping(value = "/formBeanInit/multiModels", method = RequestMethod.POST)
	public String multiModels(PackagingCS cs){
		System.out.println("*********************");
		System.out.println(cs.getClazz().getName());
		System.out.println(cs.getClazz().getGrade());
		System.out.println(cs.getStudent().getName());
		System.out.println(cs.getStudent().getAge());
		System.out.println(cs.isSuccess());
		System.out.println(cs.getRemark());
		System.out.println(cs.getStudent().getClazz().getName());
		System.out.println(cs.getStudent().getClazz().getGrade());
		
		return "/mystudy/formBean";
	}*/
	
	@InitBinder("clazz")
	public void initBinderUser(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("clazz.");
	}
	@InitBinder("student")
	public void initBinderDep(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("student.");
	}
}
