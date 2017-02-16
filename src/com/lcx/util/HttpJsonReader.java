package com.lcx.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;


public class HttpJsonReader {

	public static JSONObject getHttpJson(HttpServletRequest request){
		try {
			BufferedReader reader = request.getReader();
			StringBuffer json = new StringBuffer();
			String temp = "";
			while ( (temp = reader.readLine()) != null) {
				json.append(temp);
			}
			
			JSONObject jsonObject = JSONObject.fromObject(json.toString());
			System.out.println(jsonObject.toString());
			return jsonObject;
		} catch (IOException e) {
			System.out.println("Error parsing JSON request string");
			e.printStackTrace();
		}
		return null;
	}
}
