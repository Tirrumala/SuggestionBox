package com.opensource.suggestionbox.dao.model;

// Generated Jul 5, 2013 12:08:07 PM by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.suggestionbox.dao.vo.SbUserPriv;

/**
 * Home object for domain model class SbUserPriv.
 * @see com.opensource.edge.dao.model.SbUserPriv
 * @author Hibernate Tools
 */
@Repository
public class SbUserPrivHome {

	private static final Log log = LogFactory.getLog(SbUserPrivHome.class);

	@Autowired
	private SessionFactory sessionFactory ;
	
	public void persist(SbUserPriv transientInstance) {
		log.debug("persisting SbUserPriv instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SbUserPriv instance) {
		log.debug("attaching dirty SbUserPriv instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(SbUserPriv instance) {
		log.debug("attaching clean SbUserPriv instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SbUserPriv persistentInstance) {
		log.debug("deleting SbUserPriv instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SbUserPriv merge(SbUserPriv detachedInstance) {
		log.debug("merging SbUserPriv instance");
		try {
			SbUserPriv result = (SbUserPriv) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SbUserPriv findById(java.lang.String id) {
		log.debug("getting SbUserPriv instance with id: " + id);
		try {
			SbUserPriv instance = (SbUserPriv) sessionFactory
					.getCurrentSession().get(
							SbUserPriv.class, id);
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
	public List<SbUserPriv> findByExample(SbUserPriv instance) {
		log.debug("finding SbUserPriv instance by example");
		try {
			List<SbUserPriv> results = (List<SbUserPriv>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							SbUserPriv.class)
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
