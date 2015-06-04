<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spring mvc study-format page</title>
<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />     
<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>

<script type="text/javascript">
    $(document).ready(function() {
        
    });
</script>
</head>
<body>
    <a href="<c:url value="/mystudy/signup/format?langType=zh" />">中文</a> | <a href="<c:url value="/mystudy/signup/format?langType=en" />">英文</a><br/>
    <br>
    <br>
    ${signupModel.name }
    <br>
    <s:eval expression="signupModel.currency"></s:eval>
    <br><br><br>
    ${requestScope.signupModel.birthDate }
    ${signupModel.phone }
    <form:form commandName="signupModel">
       <form:input path="birthDate"/>
       <form:input path="phone"/>
    </form:form>
    
    <s:bind path="signupModel.birthDate">${status.value}</s:bind>
    <s:bind path="signupModel.formNo">${status.value}</s:bind>
    <s:bind path="signupModel.currency">${status.value}</s:bind>
    <s:bind path="signupModel.phone">${status.value}</s:bind>
    <br>
    <s:eval expression="signupModel.birthDate"></s:eval>
    <s:eval expression="signupModel.formNo"></s:eval>
    <s:eval expression="signupModel.currency"></s:eval>
    <s:eval expression="signupModel.phone"></s:eval>
    
    <br>
    <c:out value="${signupModel.currency}"></c:out>
    <br>
    <c:forEach items="${signupModel.sports}" var="sp">
        ${sp}
        <%-- 
        <s:eval expression="sp"></s:eval>
        <c:out value="${sp}"></c:out>
         --%>
    </c:forEach>
    <p>jstl--fmt</p>
    <p>
        <fmt:formatDate value="${signupModel.birthDate}" type="both" timeStyle="long" dateStyle="long"/>
        <fmt:formatNumber value="${signupModel.currency}" type="currency" pattern="$#,#00.00"/>
    </p>
</body>
</html>