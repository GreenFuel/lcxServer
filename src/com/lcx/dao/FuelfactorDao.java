package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Fuelfactor;

public interface FuelfactorDao {
	//�����ͺ�������Ϣ
	public boolean addFuelfactor(Fuelfactor fuelfactor);
	
	//ɾ���ͺ�������Ϣ
	public boolean deleteFuelfactor(int fuelfactorId);
	
	//��ѯһ���ͺ����ӵ���Ϣ
	public Fuelfactor queryOneFuelfactor(int fuelfactorId);
	
	//��ѯ��Ӧ���͵��ͺ�������Ϣ
	public List<Fuelfactor> queryFuelfactor(short carType);
	
	//�޸��ͺ�������Ϣ
	public boolean updateFuelfactor(Fuelfactor fuelfactor);
}
