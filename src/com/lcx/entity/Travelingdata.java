package com.lcx.entity;

/**
 * Travelingdata entity. @author MyEclipse Persistence Tools
 */

public class Travelingdata implements java.io.Serializable {

	// Fields

	private Integer tdId;
	private Driver driver;
	private Road road;
	private Routeinfo routeinfo;
	private Integer tdDistance;
	private Short tdSpeed;

	// Constructors

	/** default constructor */
	public Travelingdata() {
	}

	/** full constructor */
	public Travelingdata(Driver driver, Road road, Routeinfo routeinfo,
			Integer tdDistance, Short tdSpeed) {
		this.driver = driver;
		this.road = road;
		this.routeinfo = routeinfo;
		this.tdDistance = tdDistance;
		this.tdSpeed = tdSpeed;
	}

	// Property accessors

	public Integer getTdId() {
		return this.tdId;
	}

	public void setTdId(Integer tdId) {
		this.tdId = tdId;
	}

	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Road getRoad() {
		return this.road;
	}

	public void setRoad(Road road) {
		this.road = road;
	}

	public Routeinfo getRouteinfo() {
		return this.routeinfo;
	}

	public void setRouteinfo(Routeinfo routeinfo) {
		this.routeinfo = routeinfo;
	}

	public Integer getTdDistance() {
		return this.tdDistance;
	}

	public void setTdDistance(Integer tdDistance) {
		this.tdDistance = tdDistance;
	}

	public Short getTdSpeed() {
		return this.tdSpeed;
	}

	public void setTdSpeed(Short tdSpeed) {
		this.tdSpeed = tdSpeed;
	}

}