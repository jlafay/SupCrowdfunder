package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.CategoryDao;
import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.Project;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CategoryDao categorydao = DaoFactory.getCategoryDao();
	    List<Category> categories = categorydao.findCategories();
		req.setAttribute("categories", categories);
		
		RequestDispatcher rd = req.getRequestDispatcher("/category.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long categoryId = Long.valueOf(req.getParameter("category"));

		CategoryDao categorydao = DaoFactory.getCategoryDao();
		Category category = categorydao.findCategoryById(categoryId);
		
		ProjectDao projectdao = DaoFactory.getProjectDao();
		List<Project> projects = projectdao.findProjectsByCategory(category);
		
		List<Category> categories = categorydao.findCategories();
		
		req.setAttribute("projects", projects);
		req.setAttribute("categories", categories);

		RequestDispatcher rd = req.getRequestDispatcher("/category.jsp");
		rd.forward(req, resp);
	}

}