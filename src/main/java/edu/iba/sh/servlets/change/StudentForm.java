package edu.iba.sh.servlets.change;

import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentForm")
public class StudentForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("id");
        try{
            Student student;
            if(studentId != null){
                student = DAOFactory.getStudentDao().getStudentById(Integer.parseInt(studentId));
            } else {
                student = new Student();
            }
            request.setAttribute("student", student);
            request.getRequestDispatcher("JSP/StudentForm.jsp").forward(request, response);
        }catch(DAOException e){
            throw new ServletException(e);
        }
    }
}
