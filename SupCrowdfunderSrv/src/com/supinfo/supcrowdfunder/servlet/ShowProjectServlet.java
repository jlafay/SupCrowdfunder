package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Project;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/showProject")
public class ShowProjectServlet extends HttpServlet {
	
	long id;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idParam = req.getParameter("id");

		try {
			id = Long.valueOf(idParam);
		} catch (NumberFormatException e) {
			resp.sendRedirect(req.getContextPath() + "/listProject");
			return;
		}

		ProjectDao projectdao = DaoFactory.getProjectDao();
		Project project = projectdao.findProjectById(id);
		
		if (null == project) {
			resp.sendRedirect(req.getContextPath() + "/listProject");
			return;
		}

		req.setAttribute("project", project);
		RequestDispatcher rd = req.getRequestDispatcher("/showProject.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String contributionParam = req.getParameter("contribution");

		float addContribution;
		addContribution = Float.parseFloat(contributionParam);

		ProjectDao projectdao = DaoFactory.getProjectDao();
		Project project = projectdao.findProjectById(id);
		
		float oldContribution = project.getContribution();
		float newContribution = oldContribution + addContribution;
		float price = project.getPrice();
		float newPercent = (newContribution / price)*100;
		
		project.setContribution(newContribution);
		project.setPercent(newPercent);
		
		DaoFactory.getProjectDao().updateProject(project);
		
		resp.sendRedirect(req.getContextPath() + "/");
	}
}
