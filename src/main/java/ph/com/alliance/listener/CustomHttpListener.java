package ph.com.alliance.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ph.com.alliance.util.SetVariables;

public class CustomHttpListener implements HttpSessionListener, ServletContextListener {
	
	@Autowired
	private SetVariables setVariables;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		WebApplicationContextUtils
        .getRequiredWebApplicationContext(sce.getServletContext())
        .getAutowireCapableBeanFactory()
        .autowireBean(this);
		
		setVariables.run();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}