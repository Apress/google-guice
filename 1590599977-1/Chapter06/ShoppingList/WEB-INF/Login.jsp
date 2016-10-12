<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Shopping List Login</title>
        <s:head/>
    </head>
    <body>
        <p>Enter your login and password</p>
        <s:form action="Login">
        	<s:textfield key="login" label="Username" />
        	<s:password name="password" label="Password" />
        	<s:submit />
        </s:form>
    </body>
</html>