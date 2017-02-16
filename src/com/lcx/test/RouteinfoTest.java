package com.lcx.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import com.lcx.dao.DriverDao;
import com.lcx.dao.FuelfactorDao;
import com.lcx.dao.RouteinfoDao;
import com.lcx.daoImpl.CarDaoImpl;
import com.lcx.daoImpl.DriverDaoImpl;
import com.lcx.daoImpl.FuelfactorDaoImpl;
import com.lcx.daoImpl.RouteinfoDaoImpl;
import com.lcx.entity.Car;
import com.lcx.entity.Driver;
import com.lcx.entity.Fuelfactor;
import com.lcx.entity.Routeinfo;
import com.lcx.util.FuelCalculate;

public class RouteinfoTest {

	@Test
	public void test() {
		RouteinfoDao routeinfoDao = new RouteinfoDaoImpl();
		Car car = new Car();
		car = new CarDaoImpl().queryOneCarInfo(1);
		Driver driver = new Driver();
		driver = new DriverDaoImpl().queryDriverById(1);
		Routeinfo routeinfo = new  Routeinfo(car, driver, 11.00, 11.23, 11.00, 11.00, new Timestamp(System.currentTimeMillis()), 0.11, 0.22, 0.23, 0.34);
//		routeinfoDao.addRouteInfo(routeinfo);
		
		routeinfoDao.deleteRouteInfo(1);
		
		Routeinfo queryRouteinfo = routeinfoDao.queryOneRouteInfo(1);
		if( queryRouteinfo != null)
			System.out.println(queryRouteinfo.getRouteId());

		List<Routeinfo> routeinfos = routeinfoDao.queryRouteInfos(2, 1);
		if( routeinfos != null)
			for( Routeinfo temp:routeinfos){
				System.out.println(temp.getRouteId());
			}
	}

	@Test
	public void fuelFactorTest() {
		FuelfactorDao fuelfactorDao = new FuelfactorDaoImpl();
		Fuelfactor fuelfactor = new  Fuelfactor(4, (short) 2, 267.2655391);
//		fuelfactorDao.addFuelfactor(fuelfactor);
		List<Fuelfactor> fuelfactors = null;
		fuelfactors = fuelfactorDao.queryFuelfactor((short) 2);
		for(Fuelfactor fuelfactor1 : fuelfactors){
			System.out.println(fuelfactor1.getFuelFactorId());
		}
		
	}
}
