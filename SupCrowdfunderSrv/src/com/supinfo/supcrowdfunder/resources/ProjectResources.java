package com.supinfo.supcrowdfunder.resources;




import com.supinfo.supcrowdfunder.dao.CategoryDao;
import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;

import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/project")
public class ProjectResources {

    private ProjectDao projectDao;
    private CategoryDao categoryDao;
    private UserDao userDao;
    

    public ProjectResources() {
        projectDao = DaoFactory.getProjectDao();
        categoryDao = DaoFactory.getCategoryDao();
        userDao = DaoFactory.getUserDao();
    }
    
    @POST
    public Response createProject(Project project) {
        projectDao.createProject(project);
        String uri = "/" + project.getId();
        return Response.created(URI.create(uri)).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getAllProjectsInJson() {
        return projectDao.findProjects();
    }
    
    @PUT
    public Project updateProject(Project project) {
        projectDao.updateProject(project);
        return project;
    }
}