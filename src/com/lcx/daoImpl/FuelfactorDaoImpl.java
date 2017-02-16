package com.lcx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lcx.dao.FuelfactorDao;
import com.lcx.entity.Fuelfactor;
import com.lcx.entity.Fuelfactor;
import com.lcx.util.HibernateSessionFactory;

public class FuelfactorDaoImpl implements FuelfactorDao {

	@Override
	public boolean addFuelfactor(Fuelfactor fuelfactor) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.save(fuelfactor);
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
	public boolean deleteFuelfactor(int fuelfactorId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Fuelfactor fuelfactor = (Fuelfactor) session.get(Fuelfactor.class, fuelfactorId);
			session.delete(fuelfactor);
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
	public Fuelfactor queryOneFuelfactor(int fuelfactorId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Fuelfactor fuelfactor = (Fuelfactor) session.get(Fuelfactor.class, fuelfactorId);
			transaction.commit();
			return fuelfactor;
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
	public List<Fuelfactor> queryFuelfactor(short carType) {
		Session session = null;
		List<Fuelfactor> fuelfactors = new ArrayList<Fuelfactor>();
		String sql = null;
		try {
			session = HibernateSessionFactory.getSession();
			sql = "from Fuelfactor where carType = :carType";
			Query query = session.createQuery(sql);
			query.setParameter("carType", carType);
			fuelfactors = query.list();
			return fuelfactors;
		} catch (Exception e) {
	    	e.printStackTrace();
			return null;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateFuelfactor(Fuelfactor fuelfactor) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.update(fuelfactor);
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
