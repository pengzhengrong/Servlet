package action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class upload extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		/*FileUpload file = new FileUpload();
		boolean flag = ServletFileUpload.isMultipartContent(req);
		System.out.println(" ismultipartContent:"+flag);
		file.setFileSizeMax(300);
		long size = file.getFileSizeMax();//单位为字节 一个汉字=2字节
		System.out.println("file size:"+size);
		file.setHeaderEncoding("utf-8");
//		ServletFileUpload.
		String realPath = this.getServletContext().getRealPath("/upload");
		System.out.println("上传路径："+realPath);*/
		
		DiskFileItemFactory factroy = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factroy);
		
		//判断提交表单的类型是否为multipart/form-data
		boolean isM = upload.isMultipartContent(req);
		if(!isM){
			System.out.println("不是符合的格式！");
		}
		
		BufferedInputStream bis = null;
		FileOutputStream fos =null;
		BufferedOutputStream bos = null;
		try {
				List list = upload.parseRequest(req);
				Iterator it = list.iterator();
				while(it.hasNext()){
					FileItem item = (FileItem)it.next();
					String name = item.getName(); //这是上传的文件名称
					String fieldname = item.getFieldName(); 
					System.out.println(name+"   "+fieldname);
					InputStream is = item.getInputStream();
					long size2 = item.getSize();
					System.out.println(size2+"=size2");
					bis = new BufferedInputStream(is);
					fos= new FileOutputStream("/home/save/"+name);
					bos = new BufferedOutputStream(fos);
					byte[] by = new byte[1024]; 
					
					int len = 0;
					while((len = bis.read(by)) != -1){
						bos.write(by, 0, len);
					}
					
				}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bos.close();
			fos.close();
			bis.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		//获取上传的文件名称
//		String fileNameA = req.getParameter("filename");
//		int lastIndex = fileNameA.lastIndexOf("\\");
//		String fileName = fileNameA.substring(lastIndex+1);
	/*	String fileName = "test.txt";
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
		w.write("test");*/
		
		
		
		/*DiskFileItemFactory dis = new DiskFileItemFactory();
		FileUpload up = new FileUpload(factroy);
		up.setHeaderEncoding("utf-8");
		up.setSizeMax(100);
		up.setFileItemFactory(dis);
		
		ServletFileUpload sf = new ServletFileUpload();
		try {
			sf.parseRequest(req);
			boolean flag = ServletFileUpload.isMultipartContent(req);
			if (!flag) {
				return;
			}
			List<FileItem> li = sf.parseRequest(req);
			Iterator<FileItem> its = li.iterator();
			while(its.hasNext()){
				FileItem item = its.next();
				InputStream is = item.getInputStream();
				BufferedInputStream bi = new BufferedInputStream(is);
				OutputStream ops = item.getOutputStream();
				BufferedOutputStream bo = new BufferedOutputStream(ops);
				int len = 0;
				byte[] bs = new byte[1024];
				while( (len = bi.read(bs)) != -1){
					bo.write(bs, 0, len);
				}
			}
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
//		up.setProgressListener();
		/*try {
			List l = up.parseRequest(req);
			Iterator it = l.iterator();
			while(it.hasNext()){
				FileItem item = (FileItem) it.next();
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
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
//		req.setCharacterEncoding("utf-8");
	}
	

}
