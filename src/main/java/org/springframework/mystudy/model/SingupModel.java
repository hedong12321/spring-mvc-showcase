package org.springframework.mystudy.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.samples.mvc.convert.MaskFormat;

public class SingupModel {
	
	/* 验证 */
	@NotEmpty(message = "{msg.username.notempty}")
	private String name;
	
	/* 验证 */
	@Min(value = 18, message = "{msg.age.min}")
	@Max(value = 120, message = "{msg.age.max}")
	private int age;

	/* 类型转换 + 验证 + 格式化 */
	@DateTimeFormat(iso=ISO.DATE, pattern = "yyyy-MM-dd")
	@Past(message = "{msg.birthDate.past}")
	private Date birthDate;

	/* 自定义格式化 */
	@MaskFormat("(###) ###-####")
	private String formNo;
	
	/* 验证 */
	@Email(message="{msg.email.formart}")
	private String email;

	/* 格式化 */
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal currency;

	/* 格式化 */
	@NumberFormat(style=Style.PERCENT, pattern = "##%")
	private BigDecimal percent;
	
	/* 验证 */
	@Pattern(regexp="[1-9][0-9]{3}-([0][1-9]|[1][0-2])-([0][1-9]|[1-2][0-9]|[3][0-1])", message="{msg.statisticsDate.formart}")
	private String statisticsDate;
	
	/* 类型转换 */
	private FeedbackType feedback;
	
	private String feedbackDetails;
	
	private boolean subscribeNewsletter;
	
	/* 类型转换 */
	private Map<String, String> additionalInfo;
	
	/* 类型转换 */
	private List<String> sports;
	
	/* 自定义类型转换 */
	private PhoneNumberModel phone;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public BigDecimal getCurrency() {
		return currency;
	}

	public void setCurrency(BigDecimal currency) {
		this.currency = currency;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public boolean isSubscribeNewsletter() {
		return subscribeNewsletter;
	}

	public void setSubscribeNewsletter(boolean subscribeNewsletter) {
		this.subscribeNewsletter = subscribeNewsletter;
	}

	public Map<String, String> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public FeedbackType getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedbackType feedback) {
		this.feedback = feedback;
	}

	public String getFeedbackDetails() {
		return feedbackDetails;
	}

	public void setFeedbackDetails(String feedbackDetails) {
		this.feedbackDetails = feedbackDetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatisticsDate() {
		return statisticsDate;
	}

	public void setStatisticsDate(String statisticsDate) {
		this.statisticsDate = statisticsDate;
	}

	public List<String> getSports() {
		return sports;
	}

	public void setSports(List<String> sports) {
		this.sports = sports;
	}

	public String getFormNo() {
		return formNo;
	}

	public void setFormNo(String formNo) {
		this.formNo = formNo;
	}

	public PhoneNumberModel getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumberModel phone) {
		this.phone = phone;
	}
}
