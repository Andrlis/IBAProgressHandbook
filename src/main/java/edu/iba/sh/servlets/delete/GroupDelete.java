package edu.iba.sh.servlets.delete;

import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GroupDelete")
public class GroupDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String oldGroupNumber = request.getParameter("oldGroupNumber");

            DAOFactory.getGroupDao().removeGroup(oldGroupNumber);

            request.getRequestDispatcher("/GroupList").forward(request, response);
        }catch(DAOException e){
            throw new ServletException(e);
        }
    }
}
