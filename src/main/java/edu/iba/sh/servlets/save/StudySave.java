package edu.iba.sh.servlets.save;

import edu.iba.sh.bean.Study;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudySave")
public class StudySave extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int oldId = Integer.parseInt(request.getParameter("oldId"));

            Study study = createStudy(request);

            if (oldId == 0) {
                DAOFactory.getStudyDao().saveStudy(study);
            } else {
                DAOFactory.getStudyDao().updateStudy(oldId, study);
            }

            request.setAttribute("study", study);
            request.getRequestDispatcher("JSP/StudyForm.jsp").forward(request, response);
        } catch (DAOException e){
            throw new ServletException(e);
        }
    }

   private Study createStudy(HttpServletRequest request){
       String name = request.getParameter("name");
       int hours = Integer.parseInt(request.getParameter("hours"));
       int professorId = Integer.parseInt(request.getParameter("professorId"));
       double avgMark = Double.parseDouble(request.getParameter("avgMark"));

       Study study = new Study();
       study.setName(name);
       study.setHours(hours);
       study.setProfessorId(professorId);
       study.setAvgMark(avgMark);

       return study;
   }
}
