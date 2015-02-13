package com.supinfo.supcrowdfunder.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.supinfo.supcrowdfunder.dao.CategoryDao;
import com.supinfo.supcrowdfunder.entity.Category;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CategoryDaoJpa implements CategoryDao {
    
	private static final Logger log = Logger.getLogger(CategoryDaoJpa.class.getName());
    private EntityManagerFactory emf;
    
    public CategoryDaoJpa(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    /*
    @Override
    public List<Category> findCategories() {
            EntityManager em = emf.createEntityManager();
            try { 
                    Query query = em.createQuery("SELECT c FROM Category AS c");
                    List<Category> categoriesList = query.getResultList();
                    return categoriesList;
            } catch (NoResultException e) {
                    return null;
            } finally { 
                    em.close(); 
            }
    }
    */
    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findCategories() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("findCategories");
        return query.getResultList();
    }
    /*
    @Override
    public Category findCategoryById(Long id){
        Category result;
        EntityManager em = emf.createEntityManager();
		try { 
			result = em.find(Category.class, id);
		} catch (NoResultException e) {
			result = null;
		} finally {
			em.close(); 
		}
        return result;
    }
    */
    @Override
    public Category findCategoryById(Long idCategory) {
        EntityManager em = emf.createEntityManager();
        return em.find(Category.class, idCategory);
    }
    /*
    @Override SELECT c FROM Category AS c WHERE c.name=:cate
    public Category findCategoryByName(String name) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("findCategoryByName");
        query.setParameter("cate", name);
        return (Category) query.getSingleResult();
    }
	*/
}