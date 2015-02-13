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

import java.util.List;

@Path("/user")
public class UserResources {

    private UserDao userDao;
    

    public UserResources() {
        userDao = DaoFactory.getUserDao();
    }
    
    @PUT
    public User updateUser(User user) {
        userDao.updateUser(user);
        return user;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public User postUserByIdInJson(@PathParam("id") Long id) {
        return userDao.findUserById(id);
    }
    
    @POST
    public void createUser(User user) {
        userDao.createUser(user);
    }
}
