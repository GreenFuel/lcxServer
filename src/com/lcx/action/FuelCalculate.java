package com.lcx.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class FuelCalculate extends HttpServlet {

	public FuelCalculate() {
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

		Gson gson = new Gson();
//		String res = gson.toJson();
//		out.print();
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
