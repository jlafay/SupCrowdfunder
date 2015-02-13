package com.supinfo.supcrowdfunder.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.Query;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoJpa implements UserDao {
    
	private static final Logger log = Logger.getLogger(ProjectDaoJpa.class.getName());
    private EntityManagerFactory emf;
    
    public UserDaoJpa(EntityManagerFactory emf) {
        this.emf = emf;
    }
    /*    
    @Override
	public User createUser(User user) {
    	User result = null;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(user);
			em.getTransaction().commit();
			result = user;
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
    public void createUser(User user) {
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Unable to persist user", e);
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
        }
    }
    /*
    @Override
	public void updateUser(User user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(user);
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
    public void updateUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(user);
            tx.commit();
        } catch (Exception e) {
            log.log(Level.SEVERE, "User adding fail !", e);
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
        }
    }
    /*
    @Override
    public User findUserById(Long id){
    	User result;
        EntityManager em = emf.createEntityManager();
		try { 
			result = em.find(User.class, id);
		} catch (NoResultException e) {
			result = null;
		} finally {
			em.close(); 
		}
        return result;
    }
    */
    @Override
    public User findUserById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, id);
    }
    /*
    @Override
    public User findUserByEmail(String email){
        EntityManager em = emf.createEntityManager();
		try { 
			Query query = em.createQuery("SELECT u FROM User AS u WHERE u.email=:emailSession");
			query.setParameter("emailSession", email);
			User userFound = (User) query.getSingleResult();
			return userFound;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close(); 
		}
    }
    */
    @Override
    public User findUserByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("findUserByEmail");
        query.setParameter("emailSession", email);
        return (User) query.getSingleResult();
    }

}