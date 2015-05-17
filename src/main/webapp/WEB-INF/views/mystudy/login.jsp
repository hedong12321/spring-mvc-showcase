<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spring mvc study-login page</title>
<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />     
<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>

<script type="text/javascript">
    $(document).ready(function() {
        /* $("#form").submit(function() {
            $.post($(this).attr("action"), $(this).serialize(), function(html) {
                //$("#formsContent").replaceWith(html);
                //$('html, body').animate({ scrollTop: $("#message").offset().top }, 500);
            });
            return false;
        }); */
    });
</script>
</head>
<body>
     <div id="formsContent">
        <form:form id="form" action="doLogin" method="post" modelAttribute="user" cssClass="cleanform">
            <div class="header">
                <%-- <c:if test="${not empty message}">
                    <div id="message" class="error">${message}</div>
                </c:if> --%>
                <s:bind path="*">
                    <c:if test="${status.error}">
                        <div id="message" class="error">Form has errors</div>
                    </c:if>
                </s:bind>
            </div>
            
            <fieldset>
                <legend>Account</legend>
                <form:label path="username">
                    Name <form:errors path="username" cssClass="error" />
                </form:label>
                <form:input path="username" />
    
                <form:label path="password">
                    PWord <form:errors path="password" cssClass="error" />
                </form:label>
                <form:password path="password" />
            </fieldset>
    
            <p><button type="submit">Login</button></p>
        </form:form>
    </div>
</body>
</html>