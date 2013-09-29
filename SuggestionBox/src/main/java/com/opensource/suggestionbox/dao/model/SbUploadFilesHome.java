package com.opensource.suggestionbox.dao.model;

// Generated Jul 5, 2013 6:52:20 PM by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.suggestionbox.dao.vo.SbUploadFiles;

/**
 * Home object for domain model class SbUploadFiles.
 * @see com.opensource.edge.dao.model.SbUploadFiles
 * @author Hibernate Tools
 */
@Repository
public class SbUploadFilesHome {

	private static final Log log = LogFactory.getLog(SbUploadFilesHome.class);

	@Autowired
	private  SessionFactory sessionFactory;

	public void persist(SbUploadFiles transientInstance) {
		log.debug("persisting SbUploadFiles instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SbUploadFiles instance) {
		log.debug("attaching dirty SbUploadFiles instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(SbUploadFiles instance) {
		log.debug("attaching clean SbUploadFiles instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SbUploadFiles persistentInstance) {
		log.debug("deleting SbUploadFiles instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SbUploadFiles merge(SbUploadFiles detachedInstance) {
		log.debug("merging SbUploadFiles instance");
		try {
			SbUploadFiles result = (SbUploadFiles) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SbUploadFiles findById(java.lang.String id) {
		log.debug("getting SbUploadFiles instance with id: " + id);
		try {
			SbUploadFiles instance = (SbUploadFiles) sessionFactory
					.getCurrentSession()
					.get(SbUploadFiles.class, id);
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
	public List<SbUploadFiles> findByExample(SbUploadFiles instance) {
		log.debug("finding SbUploadFiles instance by example");
		try {
			List<SbUploadFiles> results = (List<SbUploadFiles>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							SbUploadFiles.class)
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
