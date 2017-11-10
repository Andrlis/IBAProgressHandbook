package edu.iba.sh.servlets.security;

import edu.iba.sh.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        {
            "/saveUser", "/saveGroup", "/saveStudy", "/saveStudent", "/saveProfessor", "/saveMark",
            "/deleteUser", "/deleteGroup", "/deleteStudy", "/deleteStudent", "/deleteProfessor", "/deleteMark"
        })
public class SaveFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest  httpRequest  = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String uri = httpRequest.getRequestURI();

        HttpSession session = httpRequest.getSession();
    	User user = (User)session.getAttribute("user");
        System.out.println(user.toString());
    	if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
        }
        
        
        if ((uri.endsWith("User") && !user.getRole().equals("ADMIN")) || user.getRole().equals("STUDENT")) {
            httpResponse.sendRedirect("accessDenied");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
