package com.lcx.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.google.gson.JsonObject;
import com.lcx.dao.DriverDao;
import com.lcx.daoImpl.DriverDaoImpl;
import com.lcx.entity.Driver;
import com.lcx.util.HttpJsonReader;

public class DriverLogin extends HttpServlet {

	public DriverLogin() {
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
		Driver driver = new Driver(data.getString("dri_phone"));
		DriverDao driverDao = new DriverDaoImpl();
		
		if(driverDao.queryDriverByPhone(driver.getDriPhone()) == null)
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
