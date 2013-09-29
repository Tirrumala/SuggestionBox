package com.opensource.suggestionbox.dao.model;

// Generated Jul 5, 2013 12:11:16 PM by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.suggestionbox.dao.vo.SbMain;

/**
 * Home object for domain model class SbMain.
 * @see com.opensource.edge.dao.model.SbMain
 * @author Hibernate Tools
 */

@Repository
public class SbMainHome {

	private static final Log log = LogFactory.getLog(SbMainHome.class);

	@Autowired
	private SessionFactory sessionFactory ;

	public void persist(SbMain transientInstance) {
		log.debug("persisting SbMain instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SbMain instance) {
		log.debug("attaching dirty SbMain instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(SbMain instance) {
		log.debug("attaching clean SbMain instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SbMain persistentInstance) {
		log.debug("deleting SbMain instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SbMain merge(SbMain detachedInstance) {
		log.debug("merging SbMain instance");
		try {
			SbMain result = (SbMain) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SbMain findById(java.lang.String id) {
		log.debug("getting SbMain instance with id: " + id);
		try {
			SbMain instance = (SbMain) sessionFactory.getCurrentSession().get(
					SbMain.class, id);
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
	public List<SbMain> findByExample(SbMain instance) {
		log.debug("finding SbMain instance by example");
		try {
			List<SbMain> results = (List<SbMain>) sessionFactory
					.getCurrentSession()
					.createCriteria(SbMain.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SbMain> findSearchPattern(String searchPattern) {
		log.debug("finding SbMain instance by example");
		try {
			
			Session session = sessionFactory
					.getCurrentSession();
			
			Criteria criteria = session.createCriteria(SbMain.class);

			Criterion sgid = Restrictions.ilike("sgId","%"+searchPattern+"%");
			Criterion title = Restrictions.ilike("title","%"+searchPattern+"%");
			Criterion category = Restrictions.ilike("category","%"+searchPattern+"%");
			Criterion owner = Restrictions.ilike("owner","%"+searchPattern+"%");

			// To get records matching with OR condistions
			LogicalExpression orExp1 = Restrictions.or(sgid,title);
			LogicalExpression orExp2 = Restrictions.or(category,owner);
			LogicalExpression orExp3 = Restrictions.or(orExp1,orExp2);
			criteria.add( orExp3 );
//			criteria.add( orExp2 );

//			criteria.add(sgid);
//			criteria.add(title);
//			criteria.add(category);
//			criteria.add(owner);

			List<SbMain> results = (List<SbMain>)criteria.list();
			
			log.debug("find by example successful, result size: "
					+ results.size());
			
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	
}
