package com.lcx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lcx.dao.TravelingdataDao;
import com.lcx.entity.Travelingdata;
import com.lcx.entity.Travelingdata;
import com.lcx.util.HibernateSessionFactory;

public class TravelingdataDaoImpl implements TravelingdataDao {

	@Override
	public boolean addTravelingdata(Travelingdata travelingdata) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.save(travelingdata);
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
	public boolean deleteTravelingdata(int travelingdataId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Travelingdata travelingdata = (Travelingdata) session.get(Travelingdata.class, travelingdataId);
			session.delete(travelingdata);
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
	public Travelingdata queryOneTravelingdata(int travelingdataId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Travelingdata travelingdata = (Travelingdata) session.get(Travelingdata.class, travelingdataId);
			transaction.commit();
			return travelingdata;
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
	public List<Travelingdata> queryTravelingdatas(int num, int travelingdataId) {
		Session session = null;
		List<Travelingdata> travelingdatas = new ArrayList<Travelingdata>();
		String sql = null;
		try {
			session = HibernateSessionFactory.getSession();
			sql = "from Travelingdata";
			Query query = session.createQuery(sql);
			query.setMaxResults(num);
			travelingdatas = query.list();
			return travelingdatas;
		} catch (Exception e) {
	    	e.printStackTrace();
			return null;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateTravelingdata(Travelingdata travelingdata) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.update(travelingdata);
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
