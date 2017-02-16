package com.lcx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lcx.dao.RoadDao;
import com.lcx.entity.Road;
import com.lcx.entity.Road;
import com.lcx.util.HibernateSessionFactory;

public class RoadDaoImpl implements RoadDao {

	@Override
	public boolean addRoadInfo(Road road) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.save(road);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
	        if(transaction!=null){  
	            transaction.rollback();  
	        }
			return false;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean deleteRoadInfo(int roadId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Road road = (Road) session.get(Road.class, roadId);
			session.delete(road);
			transaction.commit();
			return true;
		} catch (Exception e) {
	        if(transaction!=null){  
	            transaction.rollback();  
	        }
	    	e.printStackTrace();
			return false;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public Road queryOneRoadInfo(int roadId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Road road = (Road) session.get(Road.class, roadId);
			transaction.commit();
			return road;
		} catch (Exception e) {
	        if(transaction!=null){  
	            transaction.rollback();  
	        }
	    	e.printStackTrace();
			return null;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<Road> queryRoadsInfo(int num, int roadId) {
		Session session = null;
		List<Road> roads = new ArrayList<Road>();
		String sql = null;
		try {
			session = HibernateSessionFactory.getSession();
			sql = "from Road";
			Query query = session.createQuery(sql);
			query.setMaxResults(num);
			roads = query.list();
			return roads;
		} catch (Exception e) {
	    	e.printStackTrace();
			return null;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateRoadInfo(Road road) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.update(road);
			transaction.commit();
			return true;
		} catch (Exception e) {
	        if(transaction!=null){  
	            transaction.rollback();  
	        }
	    	e.printStackTrace();
			return false;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
	}

}
