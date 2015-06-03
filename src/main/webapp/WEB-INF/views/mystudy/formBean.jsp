<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spring mvc study-formBean page</title>
<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />     

</head>
<body>
    <c:url var="actionUrl" value="/mystudy/formBeanInit/multiModels?${_csrf.parameterName}=${_csrf.token}"/>
    <form action="${actionUrl}" method="post" class="cleanform">
        <!-- clazz_name<input type="text" name="name">
        clazz_grade<input type="text" name="grade">
        student_name<input type="text" name="name">
        student_age<input type="text" name="age"> -->
        
        clazz_name<input type="text" name="clazz.name">
        clazz_grade<input type="text" name="clazz.grade">
        student_name<input type="text" name="student.name">
        student_age<input type="text" name="student.age">
        
        <p><button type="submit">submit</button></p>
    </form>
    
    <%-- <c:url var="actionUrl" value="/mystudy/formBeanInit/multiModels?${_csrf.parameterName}=${_csrf.token}"/>
    <form action="${actionUrl}" method="post" class="cleanform">
        clazz_name<input type="text" name="clazz.name">
        clazz_grade<input type="text" name="clazz.grade">
        student_name<input type="text" name="student.name">
        student_age<input type="text" name="student.age">
        success<input type="text" name="success">
        remark<input type="text" name="remark">
        student.clazz.name<input type="text" name="student.clazz.name">
        student.clazz.grade<input type="text" name="student.clazz.grade">
        <p><button type="submit">submit</button></p>
    </form> --%>
</body>
</html>