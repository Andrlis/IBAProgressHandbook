package edu.iba.sh.servlets.change;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;
import edu.iba.sh.bean.User;

/**
 * Servlet implementation class UserForm
 */
@WebServlet("/UserForm")
public class UserForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("id");
		try{
			User user;
			if(userId != null){
				user = DAOFactory.getUserDao().getUserById(userId);
			} else {
				user = new User();
			}
			request.setAttribute("user", user);
			request.getRequestDispatcher("JSP/UserForm.jsp").forward(request, response);
		}catch(DAOException e){
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
