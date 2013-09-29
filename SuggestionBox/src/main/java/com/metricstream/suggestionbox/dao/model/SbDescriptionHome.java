package com.opensource.suggestionbox.dao.model;

// Generated Jul 5, 2013 12:11:37 PM by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.suggestionbox.dao.vo.SbDescription;

/**
 * Home object for domain model class SbDescription.
 * @see com.opensource.edge.dao.model.SbDescription
 * @author Hibernate Tools
 */
@Repository
public class SbDescriptionHome {

	private static final Log log = LogFactory.getLog(SbDescriptionHome.class);
	
	@Autowired
	private  SessionFactory sessionFactory ;

	public void persist(SbDescription transientInstance) {
		log.debug("persisting SbDescription instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SbDescription instance) {
		log.debug("attaching dirty SbDescription instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(SbDescription instance) {
		log.debug("attaching clean SbDescription instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SbDescription persistentInstance) {
		log.debug("deleting SbDescription instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SbDescription merge(SbDescription detachedInstance) {
		log.debug("merging SbDescription instance");
		try {
			SbDescription result = (SbDescription) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SbDescription findById(java.lang.String id) {
		log.debug("getting SbDescription instance with id: " + id);
		try {
			SbDescription instance = (SbDescription) sessionFactory
					.getCurrentSession()
					.get(SbDescription.class, id);
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
	public List<SbDescription> findByExample(SbDescription instance) {
		log.debug("finding SbDescription instance by example");
		try {
			List<SbDescription> results = (List<SbDescription>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							SbDescription.class).addOrder(Order.desc("updatedOn"))
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
