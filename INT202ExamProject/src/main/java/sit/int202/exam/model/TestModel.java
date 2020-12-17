/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int202.exam.model;

/**
 *
 * @author Khaitong Lim
 */
public class TestModel {

    public static void main(String[] args) {
        //System.out.println(CourseList.getAllCourseInString());
        Semester semester1 = new Semester(1);
        Subject s1 = CourseList.getSubject(1, "INT100");
        s1.setGrade(3.5);
//        System.out.println(s1);

        Subject s2 = CourseList.getSubject(1, "INT102");
        s2.setGradeString("c+");
//        System.out.println(s2);

        semester1.registerSubject(s1);
        semester1.registerSubject(s2);
//     -----

        Semester semester2 = new Semester(2);
        s1 = CourseList.getSubject(2, "GEN111");
        s1.setGrade(2.5);
//        System.out.println(s1);

        s2 = CourseList.getSubject(2, "LNG120");
        s2.setGradeString("B");
//        System.out.println(s2);

        semester2.registerSubject(s1);
        semester2.registerSubject(s2);

        CourseRegisteredHistory history = new CourseRegisteredHistory();
        history.addCourseRegistered(semester1);
        history.addCourseRegistered(semester2);

        for (Semester semester : history.getAllRegisteredCourses()) {

            System.out.println(semester.getSemesterText());
            for (Subject subject : semester.getRegisteredCourse()) {
                System.out.println("\t"+ subject);
            }
            System.out.println("----------------------");
            System.out.println(semester2.getSubject("LNG120"));
        }
    }
}