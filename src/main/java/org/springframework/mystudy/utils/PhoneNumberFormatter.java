package org.springframework.mystudy.utils;

import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.format.Formatter;
import org.springframework.mystudy.model.PhoneNumberModel;
import org.springframework.util.StringUtils;

public class PhoneNumberFormatter implements Formatter<PhoneNumberModel> {

	Pattern pattern = Pattern.compile("^(\\d{3})-(\\d{8})|(\\d{4})-(\\d{7})$");
	
	@Override
	public String print(PhoneNumberModel phoneNumber, Locale locale) {
		if(phoneNumber == null) {
            return "";
        }
		
        return new StringBuilder().append(phoneNumber.getAreaCode()).append("-")
                                  .append(phoneNumber.getPhoneNumber()).toString();
	}

	@Override
	public PhoneNumberModel parse(String source, Locale locale)
			throws ParseException {
		if(!StringUtils.hasLength(source)) {
            //①如果source为空 返回null
            return null;
        }
		
        Matcher matcher = pattern.matcher(source);
        if(matcher.matches()) {
            //②如果匹配 进行转换
            PhoneNumberModel phoneNumber = new PhoneNumberModel();
            phoneNumber.setAreaCode(matcher.group(1));
            phoneNumber.setPhoneNumber(matcher.group(2));
            return phoneNumber;
        } else {
            //③如果不匹配 转换失败  
            throw new IllegalArgumentException(String.format("类型转换失败，需要格式[010-12345678]，但格式是[%s]", source));
        }
	}

}
