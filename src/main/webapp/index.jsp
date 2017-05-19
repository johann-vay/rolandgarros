<%-- 
    Document   : index
    Created on : 19 mai 2017, 11:33:50
    Author     : Johann
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:if test="${!empty model.listCountries}">
            ${model.listCountries}
        </c:if>
    </body>
</html>
