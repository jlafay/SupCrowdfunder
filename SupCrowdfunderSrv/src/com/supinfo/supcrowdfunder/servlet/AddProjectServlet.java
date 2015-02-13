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
import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addProject")
public class AddProjectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		boolean errors = false;
		
		CategoryDao categorydao = DaoFactory.getCategoryDao();
	    List<Category> categories = categorydao.findCategories();
		
		req.setAttribute("categories", categories);

		String name = req.getParameter("name");
		String content = req.getParameter("content");
		String priceParam = req.getParameter("price");

		if (name == null || name.trim().isEmpty() || content == null || content.trim().isEmpty()) {
			errors = true;
		}

		float price = 0;

		try {
			price = Float.valueOf(priceParam);
		} catch (NumberFormatException e) {
			errors = true;
		}

		long categoryId = 0;

		try {
			categoryId = Long.valueOf(req.getParameter("category"));
		} catch (NumberFormatException e) {
			errors = true;
		}

		if (errors) {
			req.setAttribute("errors", true);
			RequestDispatcher rd = req.getRequestDispatcher("/auth/addProject.jsp");
			rd.forward(req, resp);
		} else {
			
			Project project = new Project();
			project.setName(name);
			project.setContent(content);
			project.setPrice(price);
			project.setContribution(0);
			project.setPercent(0);
			
			if(content.length() > 20){
				String shortContent = content.substring(0, 20) + "...";
				project.setShortContent(shortContent);
			}else{
				String shortContent = content + "...";
				project.setShortContent(shortContent);
			}
			
			Category category = categorydao.findCategoryById(categoryId);
			project.setCategory(category);
			
			long userId = (Long) req.getSession().getAttribute("userId");

			UserDao userdao = DaoFactory.getUserDao();
			User creator = userdao.findUserById(userId);
			project.setCreator(creator);

			DaoFactory.getProjectDao().createProject(project);
			
			resp.sendRedirect(req.getContextPath() + "/showProject?id=" + project.getId());
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CategoryDao categorydao = DaoFactory.getCategoryDao();
	    List<Category> categories = categorydao.findCategories();

		req.setAttribute("categories", categories);

		RequestDispatcher rd = req.getRequestDispatcher("/auth/addProject.jsp");
		rd.forward(req, resp);
	}
}
