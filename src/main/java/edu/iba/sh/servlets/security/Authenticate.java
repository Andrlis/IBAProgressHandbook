package edu.iba.sh.servlets.security;

import edu.iba.sh.bean.User;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            String userId = request.getParameter("userId");
            String password = request.getParameter("password");

            User user = DAOFactory.getUserDao().getUserByIDandPassword(userId, password);

            if(user == null){
                request.setAttribute("message", "Incorrect login or password");
                request.getRequestDispatcher("JSP/Login.jsp").forward(request, response);
            }
            else{
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("JSP/Welcome.jsp").forward(request, response);
            }
        }catch(DAOException e){
            throw new ServletException(e);
        }
    }
}
