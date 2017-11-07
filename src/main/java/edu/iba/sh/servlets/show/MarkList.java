package edu.iba.sh.servlets.show;

import edu.iba.sh.bean.Mark;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MarkList")
public class MarkList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List<Mark> marks = DAOFactory.getMarkDao().getAllMarks();
            request.setAttribute("marks", marks);
            request.getRequestDispatcher("JSP/MarkList.jsp").forward(request, response);
        }catch (DAOException e){
            throw new ServletException(e);
        }
    }
}
