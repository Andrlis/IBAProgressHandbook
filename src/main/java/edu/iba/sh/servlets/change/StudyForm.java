package edu.iba.sh.servlets.change;

import edu.iba.sh.bean.Study;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudyForm")
public class StudyForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studyId = request.getParameter("id");
        try{
            Study study;
            if(studyId != null){
                study = DAOFactory.getStudyDao().getStudyById(Integer.parseInt(studyId));
            } else {
                study = new Study();
            }
            request.setAttribute("study", study);
            request.getRequestDispatcher("JSP/StudyForm.jsp").forward(request, response);
        }catch(DAOException e){
            throw new ServletException(e);
        }
    }
}
