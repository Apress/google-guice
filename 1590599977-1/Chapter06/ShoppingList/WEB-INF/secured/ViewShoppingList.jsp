<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Shopping List View</title>
    <s:head/>
</head>

<body>
    <h2>Shopping list: <s:property value="shoppingList.name"/></h2>
    <ul>
    <s:iterator value="shoppingList.products">
    	<li><s:property value="name"/></li>
    </s:iterator>
    </ul>
    <s:url id="indexUrl" action="Index"/>
    <p>Take me <s:a href="%{indexUrl}">back</s:a>.</p>
    </body>
</html>