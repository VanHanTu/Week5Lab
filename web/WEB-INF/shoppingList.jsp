<%-- 
    Document   : shoppingList
    Created on : Oct 8, 2019, 12:02:18 PM
    Author     : 759841
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello ${userName} <a href="register" value="Log out">Log out</a> <input type="hidden" name="action" value="Logout">
        <h2>List</h2>
        
        <form method="post">
        Add item: <input type="text" name="item"> <input type="submit" value="Add"><br>
        <input type="hidden" name="action" value="Add">
        </form>
        
        <form method="post">
        <c:forEach var="foo" items="${itemList}">  
            <input type="radio" name="selected" value="${foo}">${foo} <br>
               
                   
        </c:forEach>
        <br>
        <input type="submit" name="delete" value="delete">
        <input type="hidden" name="action" value ="Delete">
        
        </form>
        
    </body>
</html>
