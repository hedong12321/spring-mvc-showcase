<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spring mvc study-success page</title>
<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />     
<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>

<script type="text/javascript">
    $(document).ready(function() {
        
    });
</script>
</head>
<body>
     <div id="message" class="success">${sessionScope.loginUser.username}</div>
</body>
</html>