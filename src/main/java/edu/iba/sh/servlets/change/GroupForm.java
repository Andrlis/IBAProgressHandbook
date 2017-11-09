package edu.iba.sh.servlets.change;

import edu.iba.sh.bean.Group;
import edu.iba.sh.bean.User;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GroupForm")
public class GroupForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupNumber = request.getParameter("groupNumber");
        try{
            Group group;
            if(groupNumber != null){
                group = DAOFactory.getGroupDao().getGroupByNumber(groupNumber);
            } else {
                group = new Group();
            }
            request.setAttribute("group", group);
            request.getRequestDispatcher("JSP/GroupForm.jsp").forward(request, response);
        }catch(DAOException e){
            throw new ServletException(e);
        }
    }
}
