package edu.iba.sh.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.sh.bean.User;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String oldUser = request.getParameter("oldUser");
					
			DAOFactory.getUserDao().removeUser(oldUser);

			request.getRequestDispatcher("/UserList").forward(request, response);
		}catch(DAOException e){
			throw new ServletException(e);
		}
	}

}
