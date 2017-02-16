package com.lcx.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Road entity. @author MyEclipse Persistence Tools
 */

public class Road implements java.io.Serializable {

	// Fields

	private Integer roadId;
	private String roadName;
	private Short roadLv;
	private Integer roadLength;
	private Double roadOilRatio;
	private Double roadCoemRatio;
	private Double roadHcemRatio;
	private Double roadNoemRatio;
	private Short roadCongestionLv;
	private Short roadAverageSpeed;
	private Double roadCenterLng;
	private Double roadCenterLat;
	private Set travelingdatas = new HashSet(0);

	// Constructors

	/** default constructor */
	public Road() {
	}

	/** minimal constructor */
	public Road(String roadName, Short roadLv, Integer roadLength,
			Double roadOilRatio, Double roadCoemRatio, Double roadHcemRatio,
			Double roadNoemRatio, Short roadCongestionLv,
			Short roadAverageSpeed, Double roadCenterLng, Double roadCenterLat) {
		this.roadName = roadName;
		this.roadLv = roadLv;
		this.roadLength = roadLength;
		this.roadOilRatio = roadOilRatio;
		this.roadCoemRatio = roadCoemRatio;
		this.roadHcemRatio = roadHcemRatio;
		this.roadNoemRatio = roadNoemRatio;
		this.roadCongestionLv = roadCongestionLv;
		this.roadAverageSpeed = roadAverageSpeed;
		this.roadCenterLng = roadCenterLng;
		this.roadCenterLat = roadCenterLat;
	}

	/** full constructor */
	public Road(String roadName, Short roadLv, Integer roadLength,
			Double roadOilRatio, Double roadCoemRatio, Double roadHcemRatio,
			Double roadNoemRatio, Short roadCongestionLv,
			Short roadAverageSpeed, Double roadCenterLng, Double roadCenterLat,
			Set travelingdatas) {
		this.roadName = roadName;
		this.roadLv = roadLv;
		this.roadLength = roadLength;
		this.roadOilRatio = roadOilRatio;
		this.roadCoemRatio = roadCoemRatio;
		this.roadHcemRatio = roadHcemRatio;
		this.roadNoemRatio = roadNoemRatio;
		this.roadCongestionLv = roadCongestionLv;
		this.roadAverageSpeed = roadAverageSpeed;
		this.roadCenterLng = roadCenterLng;
		this.roadCenterLat = roadCenterLat;
		this.travelingdatas = travelingdatas;
	}

	// Property accessors

	public Integer getRoadId() {
		return this.roadId;
	}

	public void setRoadId(Integer roadId) {
		this.roadId = roadId;
	}

	public String getRoadName() {
		return this.roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public Short getRoadLv() {
		return this.roadLv;
	}

	public void setRoadLv(Short roadLv) {
		this.roadLv = roadLv;
	}

	public Integer getRoadLength() {
		return this.roadLength;
	}

	public void setRoadLength(Integer roadLength) {
		this.roadLength = roadLength;
	}

	public Double getRoadOilRatio() {
		return this.roadOilRatio;
	}

	public void setRoadOilRatio(Double roadOilRatio) {
		this.roadOilRatio = roadOilRatio;
	}

	public Double getRoadCoemRatio() {
		return this.roadCoemRatio;
	}

	public void setRoadCoemRatio(Double roadCoemRatio) {
		this.roadCoemRatio = roadCoemRatio;
	}

	public Double getRoadHcemRatio() {
		return this.roadHcemRatio;
	}

	public void setRoadHcemRatio(Double roadHcemRatio) {
		this.roadHcemRatio = roadHcemRatio;
	}

	public Double getRoadNoemRatio() {
		return this.roadNoemRatio;
	}

	public void setRoadNoemRatio(Double roadNoemRatio) {
		this.roadNoemRatio = roadNoemRatio;
	}

	public Short getRoadCongestionLv() {
		return this.roadCongestionLv;
	}

	public void setRoadCongestionLv(Short roadCongestionLv) {
		this.roadCongestionLv = roadCongestionLv;
	}

	public Short getRoadAverageSpeed() {
		return this.roadAverageSpeed;
	}

	public void setRoadAverageSpeed(Short roadAverageSpeed) {
		this.roadAverageSpeed = roadAverageSpeed;
	}

	public Double getRoadCenterLng() {
		return this.roadCenterLng;
	}

	public void setRoadCenterLng(Double roadCenterLng) {
		this.roadCenterLng = roadCenterLng;
	}

	public Double getRoadCenterLat() {
		return this.roadCenterLat;
	}

	public void setRoadCenterLat(Double roadCenterLat) {
		this.roadCenterLat = roadCenterLat;
	}

	public Set getTravelingdatas() {
		return this.travelingdatas;
	}

	public void setTravelingdatas(Set travelingdatas) {
		this.travelingdatas = travelingdatas;
	}

}