<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Create Shopping List</title>
    <!-- s:head makes optiontransferselect *gogogo* -->
    <s:head/>
</head>

<body>
<h2>Create shopping list.</h2>

<%-- Call another action to get the productList --%>
<s:action name="ProductList" id="productList">
    <%-- Don't load all products for selection when editing --%>
    <s:param name="selectedProducts" value="shoppingList.products"/>
</s:action>

<s:form action="ShoppingList!createSubmit" method="POST">
    <s:hidden name="shoppingList.id" value="%{shoppingList.id}"/>
    <s:hidden name="shoppingList.login" 
 	          value="%{#session[@shoppinglist.web.util.UserToken@KEY].login}"/>
    <s:textfield name="shoppingList.name" label="Shopping list name"/>
    <s:optiontransferselect 
      label="Products"
      name="%{#productList.productList}"
      leftTitle="Available Products"
      rightTitle="Selected Products"
      list="%{#productList.productList}"
      listKey="id"
      listValue="name"
      headerKey="headerKey"
      headerValue="--- Please Select ---"
      doubleName="selectedProducts"
      doubleList="shoppingList.products"
      doubleListKey="id"
      doubleListValue="name"
      doubleHeaderKey="doubleHeaderKey"
      doubleHeaderValue="--- Shopping List ---" />
    <s:submit/>
    <s:submit value="Cancel" name="redirect-action:Index"/>
</s:form>
</body>
</html>