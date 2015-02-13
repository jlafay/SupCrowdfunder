package com.supinfo.supcrowdfunder.dao.jpa;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.Query;

import com.supinfo.supcrowdfunder.dao.CategoryDao;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.Project;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectDaoJpa implements ProjectDao {
    
	private static final Logger log = Logger.getLogger(ProjectDaoJpa.class.getName());
    private EntityManagerFactory emf;
    
    public ProjectDaoJpa(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    /*   
    @Override
	public Project createProject(Project project) {
    	Project result = null;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(project);
			em.getTransaction().commit();
			result = project;
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
		return result;
	}
    */
    
    @Override
    public void createProject(Project project) {
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(project);
            tx.commit();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Unable to persist project", e);
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
        }
    }
    /*
    @Override
	public void updateProject(Project project) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(project);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
    */
    @Override
    public void updateProject(Project project) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(project);
            tx.commit();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Project adding fail !", e);
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
        }
    }
    /*
    @Override
    public List<Project> findProjects() {
            EntityManager em = emf.createEntityManager();
            try { 
                    Query query = em.createQuery("SELECT p FROM Project AS p");
                    List<Project> projectsList = query.getResultList();
                    return projectsList;
            } catch (NoResultException e) {
                    return null;
            } finally { 
                    em.close(); 
            }
    }
    */
    @Override
    @SuppressWarnings("unchecked")
    public List<Project> findProjects() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("findProjects");
        return query.getResultList();
    }
    /*
    @Override
    public List<Project> findProjectsByCategory(Category category) {
            EntityManager em = emf.createEntityManager();
            try { 
                    Query query = em.createQuery("SELECT p FROM Project AS p WHERE p.category=:category");
                    query.setParameter("category", category);
                    List<Project> categoryList = query.getResultList();
                    return categoryList;
            } catch (NoResultException e) {
                    return null;
            } finally { 
                    em.close(); 
            }
    }
    */
    @Override
    public List<Project> findProjectsByCategory(Category category) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("findProjectsByCategory");
        query.setParameter("category", category);
        return (List<Project>) query.getResultList();
    }
    /*
    @Override
    public Project findProjectById(Long id){
    	Project result;
        EntityManager em = emf.createEntityManager();
		try { 
			result = em.find(Project.class, id);
		} catch (NoResultException e) {
			result = null;
		} finally {
			em.close(); 
		}
        return result;
    }
    */
    @Override
    public Project findProjectById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Project.class, id);
    }
}