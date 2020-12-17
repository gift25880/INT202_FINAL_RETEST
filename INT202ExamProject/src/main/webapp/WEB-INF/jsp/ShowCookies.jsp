<%-- 
    Document   : ShowCookies
    Created on : Dec 17, 2020, 9:29:13 PM
    Author     : Saraf
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookies</title>
    </head>
    <body style="margin-left: 50px">
        <h1>Cookies</h1>
        <hr>
        <table>
            <tr>
                <th>No</th>
                <th>Name</th>
                <th>Value</th>
            </tr>
        <c:forEach items="${cookies}" var="c" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${c.name}</td>
                <td>${c.value}</td>
            </tr>
        </c:forEach>
            </table>
        <div style="padding-left: 50px"><a href='index.html'><button>Back</button></a></div>
    </body>
</html>
