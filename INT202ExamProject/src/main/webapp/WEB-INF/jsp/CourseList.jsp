<%-- 
    Document   : CourseList
    Created on : Dec 5, 2020, 11:22:13 PM
    Author     : Khaitong Lim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="padding: 15px">
            <h1>Course List</h1><hr>
            <form action="CourseList" method="post">
                Semester : <select name="semester">
                    <c:forEach items="${allSemesterText}" var="title" varStatus="vs">
                        <c:if test="${title != null}">
                            <option value="${vs.index}" ${vs.index==param.semester ?'selected' : ''}>${title}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <input type="submit" value="Search"/>
            </form>
            <hr>
            <c:if test="${courseList != null}">
                <form action="Register" method="post">
                    <input type="hidden" value="${param.semester}" name="semester"/>
                    <table>
                        <thead>
                        <th>ลำดับ</th>
                        <th>รหัสวิชา</th>
                        <th>ชื่อวิชา</th>
                        <th>หน่วยกิต</th>
                        <th>เลือกลงทะเบียน</th>
                        </thead>
                        <c:forEach items="${courseList}" var="subject" varStatus="vs">
                            <tr>
                                <td style="text-align: center">${vs.count}</td>
                                <td>${subject.subjectId}</td>
                                <td>${subject.title}</td>
                                <td style="text-align: right; padding-right: 10px">${subject.credit}</td>
                                <td style="text-align: center">
                                    <input type="checkbox" name="subjects" value="${subject.subjectId}" 
                                           ${param.semester !=9? 'checked' : ''}>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="4"></td>
                            <td><input type="submit" value="Submit"/></td>
                        </tr>
                    </table>
                </form>
            </c:if>
            <c:if test="${semester != null}">
                <hr>
                <table>
                    <thead>
                    <th colspan="4" style="text-align: left;background-color: lightsalmon">รายวิชาที่ลงทะเบียนใน ${semester.semesterText}</th>
                    </thead>
                    <thead>
                    <th>ลำดับ</th>
                    <th>รหัสวิชา</th>
                    <th>ชื่อวิชา</th>
                    <th>หน่วยกิต</th>
                    </thead>
                    <c:forEach items="${semester.registeredCourse}" var="subject" varStatus="vs">
                        <tr>
                            <td style="text-align: center">${vs.count}</td>
                            <td>${subject.subjectId}</td>
                            <td>${subject.title}</td>
                            <td style="text-align: right; padding-right: 10px">${subject.credit}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <hr>
            <a href='index.html'><button>Back</button></a>
        </div>
    </body>
</html>
