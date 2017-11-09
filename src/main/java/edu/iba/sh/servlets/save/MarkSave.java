package edu.iba.sh.servlets.save;

import edu.iba.sh.bean.Mark;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MarkSave")
public class MarkSave extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int oldId = Integer.parseInt(request.getParameter("oldId"));

            Mark mark = createMark(request);

            if (oldId == 0) {
                DAOFactory.getMarkDao().saveMark(mark);
            } else {
                DAOFactory.getMarkDao().updateMark(oldId, mark);
            }

            request.setAttribute("mark", mark);
            request.getRequestDispatcher("JSP/MarkForm.jsp").forward(request, response);
        } catch (DAOException e){
            throw new ServletException(e);
        }
    }

   protected Mark createMark(HttpServletRequest request){
        Mark mark = new Mark();

        int studentId = Integer.parseInt(request.getParameter("studentId"));;
        String date = request.getParameter("date");
        int professorId = Integer.parseInt(request.getParameter("professorId"));;
        int markValue = Integer.parseInt(request.getParameter("markValue"));;
        int studyId = Integer.parseInt(request.getParameter("studyId"));;
        String comments = request.getParameter("comments");

        mark.setStudentId(studentId);
        mark.setStudyId(studyId);
        mark.setDate(date);
        mark.setProfessorId(professorId);
        mark.setMark(markValue);
        mark.setComments(comments);

        return mark;
   }
}
