package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Car;

public interface CarDao {
	
	//增加车辆信息
	public boolean addCarInfo(Car car);
	
	//删除车辆信息
	public boolean deleteCarInfo(int carId);
	
	//查询一辆车的信息
	public Car queryOneCarInfo(int carId);
	
	//查询特定数量车辆的信息
	public List<Car> queryCarsInfo(int num, int carId);
	
	//修改车辆信息
	public boolean updateCarInfo(Car car);
}
