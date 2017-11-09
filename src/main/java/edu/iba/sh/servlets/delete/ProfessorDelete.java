package edu.iba.sh.servlets.delete;

import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProfessorDelete")
public class ProfessorDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int oldId = Integer.parseInt(request.getParameter("oldId"));

            DAOFactory.getProfessorDao().removeProfessor(oldId);

            request.getRequestDispatcher("/ProfessorList").forward(request, response);
        }catch(DAOException e){
            throw new ServletException(e);
        }
    }
}
