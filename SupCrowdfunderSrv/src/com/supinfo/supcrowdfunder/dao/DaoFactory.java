package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.dao.CategoryDao;
import com.supinfo.supcrowdfunder.dao.jpa.CategoryDaoJpa;
import com.supinfo.supcrowdfunder.dao.jpa.ProjectDaoJpa;
import com.supinfo.supcrowdfunder.dao.jpa.UserDaoJpa;
import com.supinfo.supcrowdfunder.utils.PersistenceManager;

public abstract class DaoFactory {
    
    public static CategoryDao getCategoryDao() {
        return new CategoryDaoJpa(PersistenceManager.getEntityManagerFactory());
    }
    
    public static ProjectDao getProjectDao() {
        return new ProjectDaoJpa(PersistenceManager.getEntityManagerFactory());
    }
    
    public static UserDao getUserDao() {
        return new UserDaoJpa(PersistenceManager.getEntityManagerFactory());
    }
}