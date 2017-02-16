package com.lcx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lcx.dao.CarDao;
import com.lcx.entity.Car;
import com.lcx.util.HibernateSessionFactory;

public class CarDaoImpl implements CarDao {
	
	@Override
	public boolean addCarInfo(Car car) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.save(car);
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
	public boolean deleteCarInfo(int carId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Car car = (Car) session.get(Car.class, carId);
			session.delete(car);
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
	public Car queryOneCarInfo(int carId) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			Car car = (Car) session.get(Car.class, carId);
			transaction.commit();
			return car;
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
	public List<Car> queryCarsInfo(int num, int carId) {
		Session session = null;
		List<Car> cars = new ArrayList<Car>();
		String sql = null;
		try {
			session = HibernateSessionFactory.getSession();
			sql = "from Car";
			Query query = session.createQuery(sql);
			query.setMaxResults(num);
			cars = query.list();
			return cars;
		} catch (Exception e) {
	    	e.printStackTrace();
			return null;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateCarInfo(Car car) {
		Session session = null;
		Transaction transaction  = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction  = session.beginTransaction();
			session.update(car);
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
