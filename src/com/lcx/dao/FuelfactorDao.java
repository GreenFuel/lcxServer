package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Fuelfactor;

public interface FuelfactorDao {
	//增加油耗因子信息
	public boolean addFuelfactor(Fuelfactor fuelfactor);
	
	//删除油耗因子信息
	public boolean deleteFuelfactor(int fuelfactorId);
	
	//查询一条油耗因子的信息
	public Fuelfactor queryOneFuelfactor(int fuelfactorId);
	
	//查询对应车型的油耗因子信息
	public List<Fuelfactor> queryFuelfactor(short carType);
	
	//修改油耗因子信息
	public boolean updateFuelfactor(Fuelfactor fuelfactor);
}
