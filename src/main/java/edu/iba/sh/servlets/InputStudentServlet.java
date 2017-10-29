package edu.iba.sh.servlets;

import edu.iba.sh.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/addStudent")
public class InputStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student = createStudent(request);

        if(request.getAttributeNames().toString().indexOf("students")<0){
            ArrayList<Student> students = new ArrayList<Student>();
            students.add(student);
            request.setAttribute("students", students);
        }
        else {
            ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students");
            request.removeAttribute("students");
            students.add(student);
            request.setAttribute("students",students);
        }

        request.getRequestDispatcher("JSP/Students.jsp").forward(request,response);
        response.sendRedirect("JSP/Students.jsp");
    }

    private Student createStudent(HttpServletRequest request){
        Student student = new Student();
        student.setFirstName((String)request.getParameter("firstName"));
        student.setSecondName((String)request.getParameter("secondName"));
        student.setAvgMark(Double.parseDouble((String)request.getParameter("avgMark")));
        student.setGroupNumber((String)request.getParameter("groupName"));
        return student;
    }
}
