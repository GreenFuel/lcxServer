package com.lcx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lcx.dao.RouteinfoDao;
import com.lcx.entity.Routeinfo;
import com.lcx.util.HibernateSessionFactory;

public class RouteinfoDaoImpl implements RouteinfoDao {

	@Override
	public boolean addRouteInfo(Routeinfo routeInfo) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.save(routeInfo);
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
	public boolean deleteRouteInfo(int routeInfoId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Routeinfo routeInfo = (Routeinfo) session.get(Routeinfo.class, routeInfoId);
			session.delete(routeInfo);
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
	public Routeinfo queryOneRouteInfo(int routeInfoId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Routeinfo routeInfo = (Routeinfo) session.get(Routeinfo.class, routeInfoId);
			transaction.commit();
			return routeInfo;
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
	public List<Routeinfo> queryRouteInfos(int num, int routeInfoId) {
		Session session = null;
		List<Routeinfo> routeInfos = new ArrayList<Routeinfo>();
		String sql = null;
		try {
			session = HibernateSessionFactory.getSession();
			sql = "from Routeinfo";
			Query query = session.createQuery(sql);
			query.setMaxResults(num);
			routeInfos = query.list();
			return routeInfos;
		} catch (Exception e) {
	    	e.printStackTrace();
			return null;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}

	}

	@Override
	public boolean updateRouteInfo(Routeinfo routeInfo) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.update(routeInfo);
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
