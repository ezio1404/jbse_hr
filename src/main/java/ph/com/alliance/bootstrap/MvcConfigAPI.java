package ph.com.alliance.bootstrap;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuration for controller classes that hadles api calls. * 
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ph.com.alliance.controller.api"})
public class MvcConfigAPI {
	
	@Bean
	public DozerBeanMapper dozerBeanMapper() {
		return new DozerBeanMapper();
	}
}
