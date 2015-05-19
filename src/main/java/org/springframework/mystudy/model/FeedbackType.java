package org.springframework.mystudy.model;

public enum FeedbackType {
	comment("意见"), feedback("反馈"), suggestion("建议");
	
	private final String value;
	private FeedbackType(String value) {
		this.value = value;
	}
	
	public String getValue() {
        return value;
    }
}