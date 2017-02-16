package com.lcx.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lcx.dao.CarDao;
import com.lcx.dao.DriverDao;
import com.lcx.daoImpl.CarDaoImpl;
import com.lcx.daoImpl.DriverDaoImpl;
import com.lcx.entity.Car;
import com.lcx.entity.Driver;
import com.lcx.util.HttpJsonReader;

public class DriverRegister extends HttpServlet {

	public DriverRegister() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-type", "application/json;charset=UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		int msg = 1;
		JSONObject data = HttpJsonReader.getHttpJson(request);
		System.out.println(data.toString());
		Driver driver = new Driver(data.getString("dri_phone"));
		DriverDao driverDao = new DriverDaoImpl();
		if(driverDao.addDriverInfo(driver) == false)
			msg = 0;
		
		String carBrand = data.getString("carBrand");
		String carType = data.getString("carType");
		String temp = data.getString("carEmissionStd");
		int carEmissionStd = 0;
		if(temp.equals("国五") || temp.equals("国四")){
			carEmissionStd = 3;
		}else if(temp.equals("国三")){
			carEmissionStd = 2;
		}else if(temp.equals("国二")){
			carEmissionStd = 1;
		}else if(temp.equals("国一")){
			carEmissionStd = 0;
		}
		
		Car car = new Car(driver, carBrand, carType, (short) carEmissionStd);
		CarDao carDao = new CarDaoImpl();
		if(carDao.addCarInfo(car) == false);
			msg = 0;
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("driId", driver.getDriId());
		jsonObject.addProperty("msg", msg);
		System.out.println( jsonObject.toString());
		out.print(jsonObject.toString());
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
