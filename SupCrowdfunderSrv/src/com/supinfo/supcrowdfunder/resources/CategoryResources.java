package com.supinfo.supcrowdfunder.resources;

import com.supinfo.supcrowdfunder.dao.CategoryDao;
import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.Project;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/category")
public class CategoryResources {

    private CategoryDao categoryDao;
    private ProjectDao projectDao;

    public CategoryResources() {
        categoryDao = DaoFactory.getCategoryDao();
        projectDao = DaoFactory.getProjectDao();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAllCategoriesInJson() {
        return categoryDao.findCategories();
    }
}
