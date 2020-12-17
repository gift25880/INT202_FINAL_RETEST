/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int202.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sit.int202.exam.model.CourseList;
import sit.int202.exam.model.CourseRegisteredHistory;
import sit.int202.exam.model.Semester;
import sit.int202.exam.model.Subject;

/**
 *
 * @author Saraf
 */
public class GradeServlet extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        CourseRegisteredHistory history = (CourseRegisteredHistory) session.getAttribute("registerHistory");
        session.setAttribute("registerHistory", history);
        
        String semester = request.getParameter("semester");
        if (semester != null) {
            int semesterInt = Integer.valueOf(semester);
            Semester  semesterObj = history.getRegisteredCoursebySemeter(semesterInt);
            if (semesterObj != null) {
                List<Subject> courseList = semesterObj.getRegisteredCourse();
                request.setAttribute("courseList", courseList);
            } else {
                String msg = "No Data Here";
                request.setAttribute("msg", msg);
            }
        }
        
        request.setAttribute("allSemesterText",Semester.getAllSemesterText());
        
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
 