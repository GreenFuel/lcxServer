package com.lcx.dao;

import java.util.List;

import com.lcx.entity.Travelingdata;

public interface TravelingdataDao {
	//�����г̼�¼��Ϣ
	public boolean addTravelingdata(Travelingdata travelingdata);
	
	//ɾ���г̼�¼��Ϣ
	public boolean deleteTravelingdata(int travelingdataId);
	
	//��ѯһ���г̼�¼����Ϣ
	public Travelingdata queryOneTravelingdata(int travelingdataId);
	
	//��ѯ�ض������г̼�¼����Ϣ
	public List<Travelingdata> queryTravelingdatas(int num, int travelingdataId);
	
	//�޸��г̼�¼��Ϣ
	public boolean updateTravelingdata(Travelingdata travelingdata);
}
