package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Routeinfo;

public interface RouteinfoDao {
	//�����г���Ϣ��Ϣ
	public boolean addRouteInfo(Routeinfo routeInfo);
	
	//ɾ���г���Ϣ��Ϣ
	public boolean deleteRouteInfo(int routeInfoId);
	
	//��ѯһ���г���Ϣ����Ϣ
	public Routeinfo queryOneRouteInfo(int routeInfoId);
	
	//��ѯ�ض������г���Ϣ����Ϣ
	public List<Routeinfo> queryRouteInfos(int num, int routeInfoId);
	
	//�޸��г���Ϣ��Ϣ
	public boolean updateRouteInfo(Routeinfo routeInfo);
}
