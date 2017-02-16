package com.lcx.action;

import java.io.File;
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
import com.lcx.util.Photo;

public class DriverHeadPhotoUpload extends HttpServlet {

	public DriverHeadPhotoUpload() {
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
		PrintWriter out = response.getWriter();
		
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //上传时生成的临时文件保存目录
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        
        JsonObject json = new JsonObject();
        Photo photo = new Photo(); 
        //调用图片上传工具类Photo的方法PhotoDownload()实现图片存储到本地，并返回图片的名字和其路径
        json = photo.PhotoDownload(request, savePath, tempPath);
        int msg;
        msg = json.get("msg").getAsInt();

        JSONObject data = HttpJsonReader.getHttpJson(request);
		int driId = data.getInt("driId");
		DriverDao driverDao = new DriverDaoImpl();
		if( driverDao.queryDriverById(driId) != null)
		{
	        //删除原头像图片
	        Driver temp = new Driver();
	        temp = driverDao.queryDriverById(driId);
	        File file;
	        if(temp.getDriHeadPhoto() != null)
	        {
	        	file = new File(temp.getDriHeadPhoto()); // 输入要删除的文件位置
	        	if(file.exists())
	             	file.delete();
	        }
		}
		out.print(msg);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
