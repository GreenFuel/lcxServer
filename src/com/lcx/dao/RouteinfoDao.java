package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Routeinfo;

public interface RouteinfoDao {
	//增加行程信息信息
	public boolean addRouteInfo(Routeinfo routeInfo);
	
	//删除行程信息信息
	public boolean deleteRouteInfo(int routeInfoId);
	
	//查询一条行程信息的信息
	public Routeinfo queryOneRouteInfo(int routeInfoId);
	
	//查询特定数量行程信息的信息
	public List<Routeinfo> queryRouteInfos(int num, int routeInfoId);
	
	//修改行程信息信息
	public boolean updateRouteInfo(Routeinfo routeInfo);
}
