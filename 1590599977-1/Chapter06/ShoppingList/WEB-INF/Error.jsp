<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Shopping List</title>
        <s:head/>
    </head>
    <body>
        <h2>Whoops! Something went wrong...</h2>
        <p><s:property value="exception" /></p>
        <pre>
        <s:property value="exceptionStack" />
        </pre>
    </body>
</html>