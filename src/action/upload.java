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
import java.util.Enumeration;

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
		
		//获取上传的文件名称
//		String fileNameA = req.getParameter("filename");
//		int lastIndex = fileNameA.lastIndexOf("\\");
//		String fileName = fileNameA.substring(lastIndex+1);
		String fileName = "test.txt";
		//设定文件保存的路径
		String savePath = "/home/save/"+fileName;
		//读取文件内容
		InputStream is = req.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		int dataLength = req.getContentLength();
		String contentType = req.getHeader("Content-Type");
		System.out.println("ContentType:"+contentType);
		Enumeration<String> names = req.getHeaderNames();
		while(names.hasMoreElements()){
			System.out.println(names.nextElement());
		}
		//写入读取的内容
		int length = 0;
		int count = 0;
		byte[] bs = new byte[1024];
		if( count < dataLength ){
			System.out.println(count+"--"+length);
			length = dis.read(bs, length, 1024);
			count += length;
		}
		File outFile = new File(savePath);
		if(outFile.exists()){
			outFile.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(outFile);
		fos.write(bs);
		fos.close();
		dis.close();
		is.close();
		Writer w = resp.getWriter();
		//String s = req.getParameter("filename");
		//System.out.println(s);	
		w.write("test");
		
		
		
		
		
		
		
		
		
		
		//���ص���Դ���
		/*InputStream in = req.getInputStream();
		int dataLength = req.getContentLength();
		DataInputStream dis = new DataInputStream(in);
		//�����·��
		String filename = req.getParameter("file");
		System.out.println(req.getAttribute("file"));
		String path = req.getContextPath();
		
		
		//String fileOut = path+File.separator+"upload/";
		String fileOut = "/home/save/test.txt";
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
