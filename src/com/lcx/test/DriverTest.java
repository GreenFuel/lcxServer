package com.lcx.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import com.lcx.dao.CarDao;
import com.lcx.dao.DriverDao;
import com.lcx.daoImpl.CarDaoImpl;
import com.lcx.daoImpl.DriverDaoImpl;
import com.lcx.entity.Car;
import com.lcx.entity.Driver;

public class DriverTest {

	@Test
	public void test() {
		DriverDao driverDao = new DriverDaoImpl();
		Driver driver = new  Driver("18328040000");
//		driverDao.addDriverInfo(driver);
//		System.out.println(driver.getDriId());
		
		driver = driverDao.queryDriverByPhone("18328040000");
		System.out.println(driver.getDriId());
//		driverDao.deleteDriverInfo(5);
//		
//		Driver queryDriver = driverDao.queryOneDriverInfo(1);
//		System.out.println(queryDriver.getDriPhone());
//
//		List<Driver> drivers = driverDao.queryDriversInfo(2, 1);
//		for( Driver temp:drivers){
//			System.out.println(temp.getDriPhone());
//		}
	}

}
