package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Driver;

public interface DriverDao {
	//增加司机信息
	public boolean addDriverInfo(Driver driver);
	
	//删除司机信息
	public boolean deleteDriverInfo(int driverId);
	
	//通过id查询一位司机的信息
	public Driver queryDriverById(int driverId);
	
	//通过电话号码查询一位司机的信息
	public Driver queryDriverByPhone(String driPhone);
	
	//查询特定数量司机的信息
	public List<Driver> queryDriversInfo(int num, int driverId);
	
	//修改司机信息
	public boolean updateDriverInfo(Driver driver);
}
