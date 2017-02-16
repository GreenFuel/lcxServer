package com.lcx.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.JsonObject;
import com.lcx.dao.DriverDao;
import com.lcx.daoImpl.DriverDaoImpl;
import com.lcx.entity.Driver;

public class NormalTest {

	@Test
	public void test() {
		int msg = 1;
		Driver driver = new Driver();
		DriverDao driverDao = new DriverDaoImpl();
		driver = driverDao.queryDriverById(1);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("driId", driver.getDriId());
		jsonObject.addProperty("msg", msg);
		System.out.println( jsonObject.toString());
	}

}
