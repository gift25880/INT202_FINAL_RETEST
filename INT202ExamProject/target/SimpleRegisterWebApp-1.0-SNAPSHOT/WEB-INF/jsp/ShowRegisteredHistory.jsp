<%-- 
    Document   : ShowRegister
    Created on : Dec 5, 2020, 7:41:28 PM
    Author     : Khaitong Lim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register History</title>
    </head>
    <body style="margin-left: 50px">
        <h1>ประวัติการลงทะเบียน</span></h1><hr>
    <table>
        <c:forEach items="${registerHistory.allRegisteredCourses}" var="semester" varStatus="vs">
            <thead>
            <th colspan="5" style="text-align: left;background-color: lightsalmon">${semester.semesterText}</th>
        </thead>
        <thead>
        <th>ลำดับ</th>
        <th>รหัสวิชา</th>
        <th>ชื่อวิชา</th>
        <th>หน่วยกิต</th>
        <th>เกรด</th>        
    </thead>

    <c:forEach items="${semester.registeredCourse}" var="subject" varStatus="vs">
        <tr>
            <td style="text-align: center">${vs.count}</td>
            <td>${subject.subjectId}</td>
            <td>${subject.title}</td>
            <td style="text-align: right; padding-right: 10px">${subject.credit}</td>
            <td style="text-align: left; padding-left: 10px">${subject.gradeString}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5"></td>
    </tr>
</c:forEach>
</table>
<hr>
<div style="padding-left: 50px"><a href='index.html'><button>Back</button></a></div>
</body>
</html>
