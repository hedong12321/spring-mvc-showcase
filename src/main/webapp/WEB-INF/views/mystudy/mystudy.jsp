<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spring mvc study home page</title>
</head>
<body>
<h1>spring mvc study home page</h1>
<a href="<c:url value="/mystudy/userInfo" />">ShowUserInfo</a>
<br>
${user.username }
<br>
${user.password }
</body>
</html>