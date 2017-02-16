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
		//获取回话
		Session session = HibernateSessionFactory.getSession();
		//启动事务
		Transaction transaction = session.beginTransaction();
		//添加一个司机的信息到数据库中
//		session.save(driver);

		driver.setDriId(1);
		session.delete(driver);


		//按照id查询司机信息
//		driver = ( Driver) session.get( Driver.class, 1);
		//提交事务
		transaction.commit();
		//关闭会话，防止连接（Connection）数量无限增多
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
//		Car car = new  Car(driver, "奥迪", "a6", new Timestamp(System.currentTimeMillis()), (short) 4);
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
