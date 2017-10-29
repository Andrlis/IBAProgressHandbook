package edu.iba.sh.servlets;

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
 * Servlet implementation class UserSave
 */
@WebServlet("/UserSave")
public class UserSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String oldUser = request.getParameter("oldUser");
			
			User user = createUser(request);
			
			if(oldUser.length()==0){
				DAOFactory.getUserDao().saveUser(user);
			}else{
				DAOFactory.getUserDao().updateUser(oldUser, user);
			}
		
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/pages/UserForm.jsp").forward(request, response);
		}catch(DAOException e){
			throw new ServletException(e);
		}
	}
	
	
	private User createUser(HttpServletRequest request){
		
		String userId = request.getParameter("user");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		User user = new User();
		user.setUser(userId);
		user.setPassword(password);
		user.setRole(role);
		
		return user;
	}

}
