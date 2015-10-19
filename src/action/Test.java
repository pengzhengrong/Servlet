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
import javax.servlet.http.HttpServletResponse;

public class Test extends GenericServlet{

	@Override
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
	}
	
	

}
