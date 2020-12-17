/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int202.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sit.int202.exam.model.CourseRegisteredHistory;
import sit.int202.exam.model.Semester;
import sit.int202.exam.model.Subject;

/**
 *
 * @author Saraf
 */
public class AddGradeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String semester = request.getParameter("semester");
        String[] grade = request.getParameterValues("grade");

        if (grade == null) {
            String msg2 = "Grade is not pass";
            request.setAttribute("msg2", msg2);
        } else {
            HttpSession session = request.getSession(false);
            CourseRegisteredHistory history = (CourseRegisteredHistory) session.getAttribute("registerHistory");
            Semester s = history.getRegisteredCoursebySemeter(semester);
            List<Subject> subjects = s.getRegisteredCourse();
            Object[] subjectsObjects = subjects.toArray();
            Subject[] subjectsArray = new Subject[subjectsObjects.length];
            for (int i = 0; i < subjectsArray.length; i++) {
                subjectsArray[i] = (Subject) subjectsObjects[i];
                //log(grade[i]);
                subjectsArray[i].setGradeString(grade[i]);
            }
            
            String name = "ck-"+Math.random()*10000;
            String value = request.getRemoteAddr();
            Cookie ck = new Cookie(name,value);
            response.addCookie(ck);

            request.setAttribute("grade", grade);
            request.setAttribute("semester", s);
            request.setAttribute("allSemesterText", Semester.getAllSemesterText());
            session.setAttribute("registerHistory", history);
        }

        request.getRequestDispatcher("/WEB-INF/jsp/Grade.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
