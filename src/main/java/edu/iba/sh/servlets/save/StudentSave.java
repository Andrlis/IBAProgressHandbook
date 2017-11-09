package edu.iba.sh.servlets.save;

import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentSave")
public class StudentSave extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int oldId = Integer.parseInt(request.getParameter("oldId"));

            Student student = createStudent(request);

            if (oldId == 0) {
                DAOFactory.getStudentDao().saveStudent(student);
            } else {
                DAOFactory.getStudentDao().updateStudent(oldId, student);
            }

            request.setAttribute("student", student);
            request.getRequestDispatcher("JSP/StudentForm.jsp").forward(request, response);
        } catch (DAOException e){
            throw new ServletException(e);
        }
    }

    private Student createStudent(HttpServletRequest request) {
         String firstName = request.getParameter("firstName");
         String secondName = request.getParameter("secondName");
         double avgMark = Double.parseDouble(request.getParameter("avgMark"));
         String groupNumber = request.getParameter("groupNumber");

         Student student = new Student ();
         student.setFirstName(firstName);
         student.setSecondName(secondName);
         student.setGroupNumber(groupNumber);
         student.setAvgMark(avgMark);

         return student;
    }


}
