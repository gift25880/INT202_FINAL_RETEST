<%-- 
    Document   : Grade
    Created on : Dec 17, 2020, 3:25:17 PM
    Author     : Saraf
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Grade</title>
    </head>
    <body>
        <div style="padding: 15px">
            <h1>Your Registered Courses</h1>
            <hr>
            <form action="Grade" method="post">
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
                <form action="AddedGrade" method="post">
                    <input type="hidden" value="${param.semester}" name="semester"/>
                    
                    <table>
                        <thead>
                        <th>ลำดับ</th>
                        <th>รหัสวิชา</th>
                        <th>ชื่อวิชา</th>
                        <th>หน่วยกิต</th>
                        <th>เกรด</th>
                        </thead>
                        <c:forEach items="${courseList}" var="subject" varStatus="vs">
                            <tr>
                                <td style="text-align: center">${vs.count}</td>
                                <td>${subject.subjectId}</td>
                                <td>${subject.title}</td>
                                <td style="text-align: right; padding-right: 10px">${subject.credit}</td>
                                <td style="text-align: center">
                                    <select name="grade">
                                    <c:forEach items="${subject.allGradeString}" var="g" varStatus="vs">
                                            <option value="${g}" ${g == param.grade ?'selected' : ''}>${g}</option>
                                    </c:forEach>
                                    </select>
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
            <c:if test="${msg != null}">
                <h2>${msg}</h2>
            </c:if>
                <c:if test="${msg2 != null}">
                    <h2>${msg2}</h2>
                </c:if>
            <c:if test="${grade != null}">
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
                            <td>${subject.gradeString}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
                
            <hr>
            <a href='index.html'><button>Back</button></a>
        </div>
    </body>
</html>
