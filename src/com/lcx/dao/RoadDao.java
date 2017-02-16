package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Road;

public interface RoadDao {
	//增加道路信息
	public boolean addRoadInfo(Road road);
	
	//删除道路信息
	public boolean deleteRoadInfo(int roadId);
	
	//查询一条道路的信息
	public Road queryOneRoadInfo(int roadId);
	
	//查询特定数量道路的信息
	public List<Road> queryRoadsInfo(int num, int roadId);
	
	//修改道路信息
	public boolean updateRoadInfo(Road road);
}
