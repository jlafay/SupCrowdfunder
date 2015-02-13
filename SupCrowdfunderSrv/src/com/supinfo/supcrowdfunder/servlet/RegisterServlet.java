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
import com.supinfo.supcrowdfunder.entity.User;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		boolean errors = false;

		String email = req.getParameter("email");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		

		if (email == null || email.trim().isEmpty() || firstname == null || firstname.trim().isEmpty() || lastname == null || lastname.trim().isEmpty() || password == null || password.trim().isEmpty() || !password.equals(password2)) {
			errors = true;
		}

		if (errors) {
			req.setAttribute("errors", true);
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.forward(req, resp);
		} else {

			User user = new User();
			user.setEmail(email);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setPassword(password);
			DaoFactory.getUserDao().createUser(user);
			
			req.getSession().setAttribute("userId", user.getId());
			req.getSession().setAttribute("username", email);
			req.getSession().setAttribute("firstname", user.getFirstname());
			req.getSession().setAttribute("lastname", user.getLastname());
			req.getSession().setAttribute("admin", null);
			resp.sendRedirect(req.getContextPath() + "/listProject");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
		rd.forward(req, resp);
	}
}

