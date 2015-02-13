package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDao userdao = DaoFactory.getUserDao();
		User user = userdao.findUserByEmail(email);
		
		if (email == null || !email.equals(user.getEmail()) || password == null || !password.equals(user.getPassword())) {
			req.setAttribute("errors", true);
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		} else {
			req.getSession().setAttribute("username", email);
			req.getSession().setAttribute("firstname", user.getFirstname());
			req.getSession().setAttribute("lastname", user.getLastname());
			req.getSession().setAttribute("userId", user.getId());
			
			if(user.getAdmin() == 1){
				req.getSession().setAttribute("admin", user.getAdmin());
			}else{
				req.getSession().setAttribute("admin", null);
			}
			resp.sendRedirect(req.getContextPath() + "/listProject");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		rd.forward(req, resp);
	}
}