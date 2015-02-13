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
import com.supinfo.supcrowdfunder.entity.User;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/profile")
public class ProfilServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		boolean errors = false;

		String email = req.getParameter("email");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		

		if (email == null && email.trim().isEmpty() && firstname == null && firstname.trim().isEmpty() && lastname == null && lastname.trim().isEmpty() && password == null && password.trim().isEmpty()) {
			errors = true;
		}else if (!password.equals(password2)){
			errors = true;
		}

		if (errors) {
			req.setAttribute("errors", true);
			RequestDispatcher rd = req.getRequestDispatcher("/auth/profile.jsp");
			rd.forward(req, resp);
		} else {
			
			String emailSession = (String) req.getSession().getAttribute("username");
			
			UserDao userdao = DaoFactory.getUserDao();
			User user = userdao.findUserByEmail(emailSession);
			
			if (email != null && !email.trim().isEmpty()){
				user.setEmail(email);
				req.getSession().setAttribute("username", email);
				req.getSession().setAttribute("firstname", user.getFirstname());
				req.getSession().setAttribute("lastname", user.getLastname());
			}

			resp.sendRedirect(req.getContextPath() + "/");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/auth/profile.jsp");
		rd.forward(req, resp);
	}
}