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
		
        //�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //�ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        
        JsonObject json = new JsonObject();
        Photo photo = new Photo(); 
        //����ͼƬ�ϴ�������Photo�ķ���PhotoDownload()ʵ��ͼƬ�洢�����أ�������ͼƬ�����ֺ���·��
        json = photo.PhotoDownload(request, savePath, tempPath);
        int msg;
        msg = json.get("msg").getAsInt();

        JSONObject data = HttpJsonReader.getHttpJson(request);
		int driId = data.getInt("driId");
		DriverDao driverDao = new DriverDaoImpl();
		if( driverDao.queryDriverById(driId) != null)
		{
	        //ɾ��ԭͷ��ͼƬ
	        Driver temp = new Driver();
	        temp = driverDao.queryDriverById(driId);
	        File file;
	        if(temp.getDriHeadPhoto() != null)
	        {
	        	file = new File(temp.getDriHeadPhoto()); // ����Ҫɾ�����ļ�λ��
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
