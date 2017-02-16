package com.lcx.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lcx.dao.CarDao;
import com.lcx.daoImpl.CarDaoImpl;
import com.lcx.entity.Car;
import com.lcx.entity.Driver;
import com.lcx.entity.Routeinfo;
import com.lcx.util.HibernateSessionFactory;

public class MysqlTest {

	@Test
	public void DriverTest() {
		
		 Driver driver = new  Driver("12345678901");
		try {
		//��ȡ�ػ�
		Session session = HibernateSessionFactory.getSession();
		//��������
		Transaction transaction = session.beginTransaction();
		//���һ��˾������Ϣ�����ݿ���
//		session.save(driver);

		driver.setDriId(1);
		session.delete(driver);


		//����id��ѯ˾����Ϣ
//		driver = ( Driver) session.get( Driver.class, 1);
		//�ύ����
		transaction.commit();
		//�رջỰ����ֹ���ӣ�Connection��������������
		HibernateSessionFactory.closeSession();
		
		} catch (Exception e) {
			System.out.println("falsefalsefalsefalse");
		}
	}
	
	@Test
	public void CarTest() {
		
		CarDao carDao = new CarDaoImpl();
		Driver driver = new Driver();
		driver.setDriId(1);
//		Car car = new  Car(driver, "�µ�", "a6", new Timestamp(System.currentTimeMillis()), (short) 4);
//		carDao.addCarInfo(car);
		
		carDao.deleteCarInfo(5);
		
		Car queryCar = carDao.queryOneCarInfo(1);
		System.out.println(queryCar.getDriver().getDriId());

		List<Car> cars = carDao.queryCarsInfo(2, 1);
		for( Car temp:cars){
			System.out.println(temp.getDriver().getDriId());
		}
	}
	
	@Test
	public void RouteInfoTest() {
		
		 Driver driver = new  Driver("12345678912");
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(driver);

		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

}
