package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Driver;

public interface DriverDao {
	//����˾����Ϣ
	public boolean addDriverInfo(Driver driver);
	
	//ɾ��˾����Ϣ
	public boolean deleteDriverInfo(int driverId);
	
	//ͨ��id��ѯһλ˾������Ϣ
	public Driver queryDriverById(int driverId);
	
	//ͨ���绰�����ѯһλ˾������Ϣ
	public Driver queryDriverByPhone(String driPhone);
	
	//��ѯ�ض�����˾������Ϣ
	public List<Driver> queryDriversInfo(int num, int driverId);
	
	//�޸�˾����Ϣ
	public boolean updateDriverInfo(Driver driver);
}
