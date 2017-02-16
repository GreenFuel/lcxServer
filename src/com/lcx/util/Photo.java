package com.lcx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sun.misc.BASE64Encoder;

import com.google.gson.JsonObject;

public class Photo {
	
	public JsonObject PhotoDownload(HttpServletRequest request,String savePath,String tempPath)
	{
        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            //������ʱĿ¼
            tmpFile.mkdir();
        }
        
        String value = null;
        JsonObject json = new JsonObject();
        new ArrayList<String>();
        
        //��Ϣ��ʾ
        int msg ;
        try{
            //ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
            //1������һ��DiskFileItemFactory����
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼���С�
            factory.setSizeThreshold(1024*100);//���û������Ĵ�СΪ1M�������ָ������ô�������Ĵ�СĬ����10KB
            //�����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
            factory.setRepository(tmpFile);
            //2������һ���ļ��ϴ�������
            ServletFileUpload upload = new ServletFileUpload(factory);
            //�����ļ��ϴ�����
            upload.setProgressListener(new ProgressListener(){
                public void update(long pBytesRead, long pContentLength, int arg2) {
                    System.out.println("�ļ���СΪ��" + pContentLength + ",��ǰ�Ѵ���" + pBytesRead);
                    /**
                     * �ļ���СΪ��14608,��ǰ�Ѵ���4096
			                                �ļ���СΪ��14608,��ǰ�Ѵ���7367
			                                �ļ���СΪ��14608,��ǰ�Ѵ���11419
			                                �ļ���СΪ��14608,��ǰ�Ѵ���14608
                     */
                }
            });
             //����ϴ��ļ�������������
            upload.setHeaderEncoding("UTF-8"); 
            //3���ж��ύ�����������Ƿ����ϴ���������
            if(!ServletFileUpload.isMultipartContent(request)){
                //���մ�ͳ��ʽ��ȡ����
            	msg = 4;
//            	msg = "��������ݲ��Ϲ淶";
            	json.addProperty("msg", msg);
                return json;
            }
            
            //�����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ������Ϊ1024*1024�ֽڣ�Ҳ����1MB
//            upload.setFileSizeMax(1024*1024*1);
            //�����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ��Ķ���ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ10MB
            upload.setSizeMax(1024*1024*10);
            //4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
            	//���fileitem�з�װ������ͨ�����������
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //�����ͨ����������ݵ�������������
                    value = item.getString("UTF-8");
                    
//                    value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    json.addProperty(name, value);
                    System.out.println(name + "=" + value);
                }
                else{//���fileitem�з�װ�����ϴ��ļ�
                    //�õ��ϴ����ļ�����
                    String filename = item.getName();
                    System.out.println(filename);
                    if(filename==null || filename.trim().equals("")){
                        continue;
                    }
                    //ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
                    //�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    //�õ��ϴ��ļ�����չ��
                    String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
                    //�����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
                    System.out.println("�ϴ����ļ�����չ���ǣ�"+fileExtName);
                    //��ȡitem�е��ϴ��ļ���������
                    InputStream in = item.getInputStream();
                    
                    //��UUID��Ψһʶ���룩ƴ�ӵ��ļ����У��õ��ļ����������
                    String saveFilename = UUID.randomUUID().toString() + "_" + value + "." + fileExtName;
                    //�õ��ļ�����hashCode��ֵ�����õ�filename����ַ����������ڴ��еĵ�ַ������hashcode�������㣬��ƴ�ӵõ��ļ��ı���Ŀ¼����ֹһ��Ŀ¼�������̫���ļ���Ҫʹ��hash�㷨��ɢ�洢
                    String realSavePath = makePath(saveFilename, savePath);
                    
                    //����һ���ļ������
                    FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
                    
                    //�洢ͼƬ��ʲôͼƬ�����Ĵ洢·��
//                    json.addProperty(value, realSavePath + "\\" + saveFilename);
                    json.addProperty(value, realSavePath + "\\" + saveFilename);
                    
                    //����һ��������
                    byte buffer[] = new byte[1024];
                    //�ж��������е������Ƿ��Ѿ�����ı�ʶ
                    int len = 0;
                    //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
                    while((len=in.read(buffer))>0){
                        //ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
                        out.write(buffer, 0, len);
                    }
                    //�ر�������
                    in.close();
                    //�ر������
                    out.close();
                    //ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
                    item.delete();
                }
            }
            msg = 1;
//            msg = "�ļ��ϴ��ɹ���";
            json.addProperty("msg", msg);
        }catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            msg = 2;
//            msg = "�����ļ��������ֵ������";
            json.addProperty("msg", msg);
            return json;
        }catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            msg = 3;
//            msg = "�ϴ��ļ����ܵĴ�С�������Ƶ����ֵ������";
            json.addProperty("msg", msg);
            return json;
        }catch (Exception e) {
        	msg = 4;
//            msg= "�ļ��ϴ�ʧ�ܣ�";
            json.addProperty("msg", msg);
            e.printStackTrace();
        }
		return json;
    }
    
    /**
     * Ϊ��ֹһ��Ŀ¼�������̫���ļ���Ҫʹ��hash�㷨��ɢ�洢
    * @Method: makePath
    * @Description: 
    * @param filename �ļ�����Ҫ�����ļ������ɴ洢Ŀ¼
    * @param savePath �ļ��洢·��
    * @return �µĴ洢Ŀ¼
    */ 
    private String makePath(String filename,String savePath){
        //�õ��ļ�����hashCode��ֵ���õ��ľ���filename����ַ����������ڴ��еĵ�ַ
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        //�����µı���Ŀ¼
        String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        //File�ȿ��Դ����ļ�Ҳ���Դ���Ŀ¼
        File file = new File(dir);
        //���Ŀ¼������
        if(!file.exists()){
            //����Ŀ¼
            file.mkdirs();
        }
        return dir;
    }

    
    
    //ͼƬת����base64�ַ���
    public static String GetImageStr(String filePath) {// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
    	if( filePath == null)
    		return "0";
    	InputStream in = null;
	    byte[] data = null;
	    // ��ȡͼƬ�ֽ�����
	    try {
		    in = new FileInputStream(filePath);
		    data = new byte[in.available()];
		    in.read(data);
		    in.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    // ���ֽ�����Base64����
	    BASE64Encoder encoder = new BASE64Encoder();
	    return encoder.encode(data);// ����Base64��������ֽ������ַ���
    }
   
    /*
    // base64�ַ���ת����ͼƬ
    public static boolean GenerateImage(String imgStr) { // ���ֽ������ַ�������Base64���벢����ͼƬ
	    if (imgStr == null) // ͼ������Ϊ��
	    	return false;
	    BASE64Decoder decoder = new BASE64Decoder();
	    try {
		    // Base64����
		    byte[] b = decoder.decodeBuffer(imgStr);
		    for (int i = 0; i < b.length; ++i) 
		    {
			    if (b[i] < 0) {// �����쳣����
			    	b[i] += 256;
		    }
		    // ����jpegͼƬ
		    String imgFilePath = "C:/Users/Star/Desktop/test22.png";// �����ɵ�ͼƬ
		    OutputStream out = new FileOutputStream(imgFilePath);
		    out.write(b);
		    out.flush();
		    out.close();
	    	return true;
	    	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }
	    */
    
    
    
    
    
    
    //����˽��ļ������ͻ���
	public void PhotoUpload(OutputStream out,String fileName, String fileSaveRootPath) throws IOException{
	
		//ͨ���ļ����ҳ��ļ�������Ŀ¼
        String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
        //�õ�Ҫ���ص��ļ�
        File file = new File(path + "\\" + fileName);
        //����ļ�������
        if(!file.exists()){
        	return;
        }
        fileName.substring(fileName.indexOf("_")+1);
        //������Ӧͷ��������������ظ��ļ�
//        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
        //��ȡҪ���ص��ļ������浽�ļ�������
        FileInputStream in = new FileInputStream(path + "\\" + fileName);
        //����������
        byte buffer[] = new byte[1024];
        int len = 0;
        //ѭ�����������е����ݶ�ȡ������������
        while((len=in.read(buffer))>0){
            //��������������ݵ��������ʵ���ļ�����
            out.write(buffer, 0, len);
            out.flush();
        }
        //�ر��ļ�������
        in.close();
    }
    
    /**
    * @Method: findFileSavePathByFileName
    * @Description: ͨ���ļ����ʹ洢�ϴ��ļ���Ŀ¼�ҳ�Ҫ���ص��ļ�������·��
    * @param filename Ҫ���ص��ļ���
    * @param saveRootPath �ϴ��ļ�����ĸ�Ŀ¼��Ҳ����/WEB-INF/uploadĿ¼
    * @return Ҫ���ص��ļ��Ĵ洢Ŀ¼
    */ 
    public String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        File file = new File(dir);
        if(!file.exists()){
            //����Ŀ¼
            file.mkdirs();
        }
        return dir;
    }
}
