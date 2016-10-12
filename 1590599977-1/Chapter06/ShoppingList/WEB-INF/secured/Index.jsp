<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>Shopping List</title>
    <s:head />
</head>
<body>
    <h2><s:property value="#session[@shoppinglist.web.util.UserToken@KEY].login" />'s 
    shopping lists</h2>
    
    <%-- Create URL to use later on in the page --%>
    <s:url id="createUrl" action="Index" method="create" />
    
    <s:if test="shoppingLists.size > 0">
        <p>Listed below you'll find your current shopping lists. 
           <s:a href="%{createUrl}">Create</s:a> some more!</p>
    
        <%-- No funny stuff with the layout, please; theme=simple --%>
        <s:form action="Index" theme="simple">
            <table border="1">
                <s:iterator value="shoppingLists" status="status">
                    <tr>
                        <td><s:property value="name" /></td>
                        <td>
                            <s:submit name="view[%{#status.index}]" value="View" />
                            <s:submit name="edit[%{#status.index}]" value="Edit" /> 
                            <s:submit name="remove[%{#status.index}]" value="Remove" />
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:form>
    </s:if>
    <s:else>
        <p>You currently have no shopping lists. Perhaps you want to 
           <s:a href="%{createUrl}">create</s:a> one?</p>
    </s:else>
    
    <s:url id="logoutUrl" action="Logout" namespace="/" />
    <p>Take me <s:a href="%{logoutUrl}">out</s:a>.</p>
</body>
</html>