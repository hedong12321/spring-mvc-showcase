package org.springframework.mystudy.utils;

import java.util.HashSet;
import java.util.Set;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.mystudy.model.PhoneNumberModel;

public class PhoneNumberAnnotationFormatter implements
		AnnotationFormatterFactory<PhoneNumber> {//①指定可以解析/格式化的字段注解类型

	private final Set<Class<?>> fieldTypes;
	private final PhoneNumberFormatter formatter;
	public PhoneNumberAnnotationFormatter() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(PhoneNumberModel.class);
		
		this.fieldTypes = set;
		this.formatter = new PhoneNumberFormatter();
	}
	
	//②指定可以被解析/格式化的字段类型集合
	@Override
	public Set<Class<?>> getFieldTypes() {
		return fieldTypes;
	}

	//③根据注解信息和字段类型获取解析器
	@Override
	public Parser<?> getParser(PhoneNumber annotation, Class<?> fieldType) {
		return formatter;
	}

	//④根据注解信息和字段类型获取格式化器
	@Override
	public Printer<?> getPrinter(PhoneNumber annotation, Class<?> fieldType) {
		return formatter;
	}

}
