<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%-- <%@ page session="false" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>表单数据提交|数据类型转换</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
</head>
<body>
	<div id="formsContent">
		<form:form id="form" method="post" modelAttribute="signupModel" cssClass="cleanform">
			<div class="header">
		  		<h2>请完成以下统计</h2>
		  		<c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>
		  		</c:if>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">注册发生异常！</div>
		  			</c:if>
		  		</s:bind>
			</div>
		  	<fieldset>
		  		<legend>基本信息</legend>
		  		<form:label path="name">
		  			昵称 <form:errors path="name" cssClass="error" />
		 		</form:label>
		  		<form:input path="name" />
	
		  		<form:label path="age">
		  			年龄 <form:errors path="age" cssClass="error" />
		 		</form:label>
		  		<form:input path="age" />
		  		
		  		<form:label path="birthDate">
		  			生日 (in form yyyy-mm-dd) <form:errors path="birthDate" cssClass="error" />
		 		</form:label>
		  		<form:input path="birthDate" />
		  		 
		  		<form:label path="formNo">
		  			表单编号 (in form (###) ###-####) <form:errors path="formNo" cssClass="error" />
		  		</form:label>
		  		<form:input path="formNo" />
		  		
		  		<form:label path="phone">
                                       电话 (in form AreaCode-PhoneNumber) <form:errors path="phone" cssClass="error" />
                </form:label>
                <form:input path="phone" />
	
				<form:label path="email">
			                邮箱 (in form xx@xx.com) <form:errors path="email" cssClass="error" />
                </form:label>
                <form:input path="email" />
                
		  		<form:label path="currency">
		  			薪资 (in form $#.##) <form:errors path="currency" cssClass="error" />
		  		</form:label>
		  		<form:input path="currency" />
	
		  		<form:label path="percent">
		  			生活满意度 (in form ##%) <form:errors path="percent" cssClass="error" />
		  		</form:label>
		  		<form:input path="percent" />
		  		
		  		<form:label path="statisticsDate">
                                        统计日期 (in form “yyyy-MM-dd”) <form:errors path="statisticsDate" cssClass="error" />
                </form:label>
                <form:input path="statisticsDate" />
	
		  	</fieldset>
	
	        <fieldset class="checkbox">
                <legend>喜欢的运动</legend>
                <label><form:checkbox path="sports[0]" value="basketball" />篮球</label>
                <label><form:checkbox path="sports[1]" value="football" />足球</label>
                <label><form:checkbox path="sports[2]" value="ping-pong" />乒乓</label>
            </fieldset>
	
			<fieldset>
				<legend>意见建议</legend>
				<form:label path="feedback">
					类型 
				</form:label>
				<form:select path="feedback">
					<form:option value="comment">意见</form:option>
					<form:option value="feedback">反馈</form:option>
					<form:option value="suggestion">建议</form:option>
				</form:select>
				
		  		<form:label path="feedbackDetails">
		  			详细
		  		</form:label>
		  		<form:textarea path="feedbackDetails" />
		  	</fieldset>
	
			<fieldset class="checkbox">
				<legend>还希望了解的信息</legend>
				<label><form:checkbox path="additionalInfo[mvc]" value="true" />on Spring MVC</label>
				<label><form:checkbox path="additionalInfo[java]" value="true" />on Java</label>				
			</fieldset>
		  		  	
			<fieldset class="radio">
				<legend>是否订阅实时新闻?</legend>
				<label><form:radiobutton path="subscribeNewsletter" value="true" />Yes</label>
				<label><form:radiobutton path="subscribeNewsletter" value="false" /> No</label>
			</fieldset>
	
			<p><button type="submit">提交</button></p>
		</form:form>
		<script type="text/javascript">
			
		</script>
	</div>
</body>
</html>
