package action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		System.out.println(request.getHeader("referer"));
		if(request.getHeader("referer")!=null){
			
			  String name="地址.txt";//文件名
//			  String uploadPath = UploadFileHelper.getRepositoryPath()+"//";//文件来源
			  String uploadPath = "/home/pzr/文档/";
			    
			   String filePath = name;
			  String fileName = name;
			  
			  
			  if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0){
			   fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");//firefox浏览器
			  }else {
			       if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0){
			        fileName = URLEncoder.encode(fileName, "UTF-8");//IE浏览器
			       }
			  }  
			  System.out.println(fileName);
/*			  response.setContentType("text/plain");
			  response.setHeader("Location",fileName);*/
			  response.reset();
			  response.setHeader("Cache-Control", "max-age=0" );
			  response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
			 BufferedInputStream bis = null;
			  BufferedOutputStream bos = null;
			  OutputStream fos = null;
			  InputStream fis = null;
			  filePath = uploadPath + filePath;
			  fis = new FileInputStream(filePath);
			     bis = new BufferedInputStream(fis);
			     fos = response.getOutputStream();
			     bos = new BufferedOutputStream(fos);
			     int bytesRead = 0;
			     byte[] buffer = new byte[5 * 1024];
			     while ((bytesRead = bis.read(buffer)) != -1) {
			         bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
			     }
			     System.out.println(fileName+"  "+filePath);
			     bos.close();
			     bis.close();
			     fos.close();
			     fis.close();
			
		}
	}
	
}
