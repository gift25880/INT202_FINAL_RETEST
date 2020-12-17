/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int202.exam.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sit.int202.exam.model.CourseList;
import sit.int202.exam.model.CourseRegisteredHistory;
import sit.int202.exam.model.Semester;

/**
 *
 * @author Khaitong Lim
 */
public class RegisterCourseServlet extends HttpServlet {

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
        String[] subjects = request.getParameterValues("subjects");
        int semesterInt = Integer.valueOf(semester);
        Semester s = new Semester(semesterInt);
        HttpSession session = request.getSession();
        CourseRegisteredHistory registerHistory = (CourseRegisteredHistory) session.getAttribute("registerHistory");
        if (registerHistory == null) {
            registerHistory = new CourseRegisteredHistory();
            session.setAttribute("registerHistory", registerHistory);
        }
        registerHistory.addCourseRegistered(s);
        for (String subject : subjects) {
            s.registerSubject(CourseList.getSubject(semesterInt, subject));
        }

//        String cookieName = "ck-"+ Math.random()*100000;
//        Cookie ck = new Cookie(cookieName, new Date().toString());
//        ck.setMaxAge(60*60*24*7);
//        response.addCookie(ck);
        request.setAttribute("semester", s);
 //       request.setAttribute("semesterNumber", semesterInt);
        request.setAttribute("allSemesterText", Semester.getAllSemesterText());
        request.getRequestDispatcher("/WEB-INF/jsp/CourseList.jsp").forward(request, response);
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
