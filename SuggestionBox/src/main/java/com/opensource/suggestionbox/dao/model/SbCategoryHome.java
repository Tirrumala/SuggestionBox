package com.opensource.suggestionbox.dao.model;

// Generated Jul 5, 2013 12:07:36 PM by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.suggestionbox.dao.vo.SbCategory;

/**
 * Home object for domain model class SbCategory.
 * @see com.opensource.edge.dao.model.SbCategory
 * @author Hibernate Tools
 */
@Repository
public class SbCategoryHome {

	private static final Log log = LogFactory.getLog(SbCategoryHome.class);

	@Autowired
	private SessionFactory sessionFactory ;
	
	public void persist(SbCategory transientInstance) {
		log.debug("persisting SbCategory instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SbCategory instance) {
		log.debug("attaching dirty SbCategory instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(SbCategory instance) {
		log.debug("attaching clean SbCategory instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SbCategory persistentInstance) {
		log.debug("deleting SbCategory instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SbCategory merge(SbCategory detachedInstance) {
		log.debug("merging SbCategory instance");
		try {
			SbCategory result = (SbCategory) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SbCategory findById(java.lang.String id) {
		log.debug("getting SbCategory instance with id: " + id);
		try {
			SbCategory instance = (SbCategory) sessionFactory
					.getCurrentSession().get(
							SbCategory.class, id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SbCategory> findByExample(SbCategory instance) {
		log.debug("finding SbCategory instance by example");
		try {
			List<SbCategory> results = (List<SbCategory>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							SbCategory.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
