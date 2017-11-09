package edu.iba.sh.servlets.change;

import edu.iba.sh.bean.Mark;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MarkForm")
public class MarkForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String markId = request.getParameter("id");
        try{
            Mark mark;
            if(markId != null){
                mark = DAOFactory.getMarkDao().getMarkById(Integer.parseInt(markId));
            } else {
                mark = new Mark();
            }
            request.setAttribute("mark", mark);
            request.getRequestDispatcher("JSP/MarkForm.jsp").forward(request, response);
        }catch(DAOException e){
            throw new ServletException(e);
        }
    }
}
