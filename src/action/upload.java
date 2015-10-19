package action;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class upload extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
//		InputStream is = req.getInputStream();
		
		
		Writer w = resp.getWriter();
		String s = req.getParameter("filename");
		System.out.println(s);	
		//w.write("test");
		
		
		
		
		
		
		
		
		
		
		/*//���ص���Դ���
		InputStream in = req.getInputStream();
		int dataLength = req.getContentLength();
		DataInputStream dis = new DataInputStream(in);
		//�����·��
		String filename = req.getParameter("file");
		System.out.println(req.getAttribute("file"));
		String path = req.getContextPath();
		
		
		//String fileOut = path+File.separator+"upload/";
		String fileOut = "D:\\opt/test.txt";
		System.out.println("fileOut:"+fileOut+" filename:"+filename);
		File file = new File(fileOut);
		//���õ��ֽ���
		byte[] bs = new byte[1024];
		int length = 0;
		int totalLength = 0;
		while(totalLength < dataLength){
			length = dis.read(bs, 0, 1024);
			totalLength += length;
		}
		//�����ļ�
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(bs);
		fos.close();
		dis.close();*/
		//���ؿͻ���
		
		/*InputStream in = req.getInputStream();
		int dataLength = req.getContentLength();
		DataInputStream dis = new DataInputStream(in);
		byte[] bs = new byte[1024];
		int length = 0,totalLength = 0;
		while(totalLength < dataLength){
			length = in.read(bs, 0, 1024);
			totalLength += length; 
		}*/
		//resp.sendRedirect("views/test/test.jsp");
		//o.write(b, off, len);
		
	}
	

}
