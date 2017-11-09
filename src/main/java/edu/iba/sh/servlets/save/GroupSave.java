package edu.iba.sh.servlets.save;

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

@WebServlet("/GroupSave")
public class GroupSave extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String oldGroupNumber = request.getParameter("oldGroupNumber");

            Group group = createGroup(request);

            if(oldGroupNumber.length()==0){
                DAOFactory.getGroupDao().saveGroup(group);
            }else{
                DAOFactory.getGroupDao().updateGroup(oldGroupNumber, group);
            }

            request.setAttribute("group", group);
            request.getRequestDispatcher("JSP/GroupForm.jsp").forward(request, response);
        }catch(DAOException e){
            throw new ServletException(e);
        }
    }

    private Group createGroup(HttpServletRequest request){
        String groupNumber = request.getParameter("groupNumber");
        double avgMark = Double.parseDouble(request.getParameter("avgMark"));

        Group group = new Group();
        group.setGroupNumber(groupNumber);
        group.setAvgMark(avgMark);

        return group;
    }
}
