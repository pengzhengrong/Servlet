package listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class context implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("servletContext destroy");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("servlet init");
	}


}
