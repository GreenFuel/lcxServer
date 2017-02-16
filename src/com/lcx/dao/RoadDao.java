package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Road;

public interface RoadDao {
	//���ӵ�·��Ϣ
	public boolean addRoadInfo(Road road);
	
	//ɾ����·��Ϣ
	public boolean deleteRoadInfo(int roadId);
	
	//��ѯһ����·����Ϣ
	public Road queryOneRoadInfo(int roadId);
	
	//��ѯ�ض�������·����Ϣ
	public List<Road> queryRoadsInfo(int num, int roadId);
	
	//�޸ĵ�·��Ϣ
	public boolean updateRoadInfo(Road road);
}
