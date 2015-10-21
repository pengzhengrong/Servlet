package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		String username=req.getParameter("username");
		String passwd = req.getParameter("password");
		if(username.equals("pzr") && passwd.equals("pzr")){
			System.out.println("登入成功");
		}
//		resp.setHeader("Method", "post");
//		req.getRequestDispatcher("/Servlet/test2.do").forward(req, resp);
		resp.sendRedirect("/Servlet/test2.do");
	}
	
}
