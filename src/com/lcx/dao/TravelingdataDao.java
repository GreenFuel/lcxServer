package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Travelingdata;

public interface TravelingdataDao {
	//增加行程记录信息
	public boolean addTravelingdata(Travelingdata travelingdata);
	
	//删除行程记录信息
	public boolean deleteTravelingdata(int travelingdataId);
	
	//查询一条行程记录的信息
	public Travelingdata queryOneTravelingdata(int travelingdataId);
	
	//查询特定数量行程记录的信息
	public List<Travelingdata> queryTravelingdatas(int num, int travelingdataId);
	
	//修改行程记录信息
	public boolean updateTravelingdata(Travelingdata travelingdata);
}
