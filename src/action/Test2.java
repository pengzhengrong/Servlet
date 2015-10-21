package action;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String path = req.getContextPath();
		String header = req.getHeader("HTTP1.1");
		ServletContext context = getServletContext();
		String contextUserName = context.getInitParameter("username");
		String contextEmail = context.getInitParameter("email");
		System.out.println(contextUserName+"   "+contextEmail);
		Writer w = resp.getWriter();
		w.write(path+" header:"+header);
		resp.sendRedirect("views/test/test.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
	
}
