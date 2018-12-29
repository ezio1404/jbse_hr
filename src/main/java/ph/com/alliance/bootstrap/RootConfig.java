package ph.com.alliance.bootstrap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Bootstrap for service layer.
 * 
 */
@Configuration
@Import(DatabaseConfigMySQL.class)
//@PropertySource({ "classpath:project.properties" })
@ComponentScan(basePackages = { "ph.com.alliance.service", "ph.com.alliance.dao", "ph.com.alliance.util" })
public class RootConfig {

}