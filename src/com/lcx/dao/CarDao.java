package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Car;

public interface CarDao {
	
	//���ӳ�����Ϣ
	public boolean addCarInfo(Car car);
	
	//ɾ��������Ϣ
	public boolean deleteCarInfo(int carId);
	
	//��ѯһ��������Ϣ
	public Car queryOneCarInfo(int carId);
	
	//��ѯ�ض�������������Ϣ
	public List<Car> queryCarsInfo(int num, int carId);
	
	//�޸ĳ�����Ϣ
	public boolean updateCarInfo(Car car);
}
