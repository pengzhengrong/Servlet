package action;

import java.io.IOException;
import java.io.Writer;

import javax.jws.WebService;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		
		String test = req.getParameter("test");
		
		System.out.println(test);
		
		Writer out = resp.getWriter();
		
		out.write(test);
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		doPost(req, resp);
	}
	
	
	/*@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取servletContext
		ServletContext context = this.getServletContext();
		ServletConfig config = this.getServletConfig();
		String admin = config.getInitParameter("admin");
		String email = config.getInitParameter("email");
		String str = admin+"=="+email;
		//Writer w = response.getWriter();
		//w.write(str);
	}*/
	
	

}
