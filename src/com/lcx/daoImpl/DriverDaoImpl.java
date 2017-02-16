package com.lcx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lcx.dao.DriverDao;
import com.lcx.entity.Driver;
import com.lcx.util.HibernateSessionFactory;

public class DriverDaoImpl implements DriverDao {

	@Override
	public boolean addDriverInfo(Driver driver) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.save(driver);
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
	public boolean deleteDriverInfo(int driverId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Driver driver = (Driver) session.get(Driver.class, driverId);
			session.delete(driver);
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
	public Driver queryDriverById(int driverId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Driver driver = (Driver) session.get(Driver.class, driverId);
			transaction.commit();
			return driver;
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
	public Driver queryDriverByPhone(String driPhone) {
		Session session = null;
		List<Driver> drivers = new ArrayList<Driver>();
		String sql = null;
		Driver driver = null;
		try {
			session = HibernateSessionFactory.getSession();
			sql = "from Driver where driPhone = :driPhone";
			Query query = session.createQuery(sql);
			query.setString("driPhone", driPhone);
			drivers = query.list();
			driver = drivers.get(0);
			return driver;
		} catch (Exception e) {
	    	e.printStackTrace();
			return null;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<Driver> queryDriversInfo(int num, int driverId) {
		Session session = null;
		List<Driver> drivers = new ArrayList<Driver>();
		String sql = null;
		try {
			session = HibernateSessionFactory.getSession();
			sql = "from Driver";
			Query query = session.createQuery(sql);
			query.setMaxResults(num);
			drivers = query.list();
			return drivers;
		} catch (Exception e) {
	    	e.printStackTrace();
			return null;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateDriverInfo(Driver driver) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.update(driver);
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
