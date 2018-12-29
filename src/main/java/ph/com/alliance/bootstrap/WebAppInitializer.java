package ph.com.alliance.bootstrap;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import ph.com.alliance.listener.CustomHttpListener;

/**
 * This is the main bootstrap. Note the special interface, which is called on startup.
 * This declares the Spring contexts (root and mvc) and binds the dispatcher servlet.
 * 
 */
public class WebAppInitializer implements WebApplicationInitializer {

	private static final Logger logger = LoggerFactory.getLogger(WebApplicationInitializer.class);
	private static final String DISPATCHER_MAPPING_ROOT = "/";
	private static final String DISPATCHER_MAPPING_API = "/api/*";
	private static final short STARTUP_PRIORITY = 1;

	public void onStartup(ServletContext servletContext) throws ServletException {

		// Create the root appcontext
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		// since we registered RootConfig instead of passing it to the constructor
		rootContext.refresh();

		// Manage the lifecycle of the root appcontext
		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.setInitParameter("defaultHtmlEscape", "true");
		
		servletContext.addListener(new CustomHttpListener());
		
		// now the config for the Dispatcher servlet
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(MvcConfigView.class);
		mvcContext.register(MvcConfigAPI.class);

		// The main Spring MVC servlet.
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(mvcContext));
		dispatcher.setLoadOnStartup(STARTUP_PRIORITY);
		dispatcher.addMapping(DISPATCHER_MAPPING_API);
		Set<String> mappingConflicts = dispatcher.addMapping(DISPATCHER_MAPPING_ROOT);
		
		if (!mappingConflicts.isEmpty()) {
			for (String s : mappingConflicts) {
				logger.error("Mapping conflict: " + s);
			}
			throw new IllegalStateException("'dispatcher' cannot be mapped to '/' under Tomcat versions <= 7.0.14");
		}
	}
}