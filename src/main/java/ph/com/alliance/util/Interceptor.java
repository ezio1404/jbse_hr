package ph.com.alliance.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import eu.bitwalker.useragentutils.UserAgent;

public class Interceptor  extends HandlerInterceptorAdapter {

	@Autowired
	Environment env;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
			// remove the root url part
			String strURI = request.getRequestURI().replace(env.getProperty("root_url"), Constant.EMPTY_STRING);
			// get the user id if it exists
			String strUserId = (String) request.getSession().getAttribute("masterId");
			String sessionId = request.getSession().getId();
			
			//Sample: only Chrome browser is allowed
			UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
			if(!Common.isNullOrEmpty(userAgent.getBrowser().getName()) 
					&& "Chrome".equals(userAgent.getBrowser().getName())) {
					//throw new NoHandlerFoundException(sessionId, sessionId, null);
			}

			// if user id is empty and not login page and not api call, redirect to
			// login page
			if (Common.isNullOrEmpty(strUserId) 
					&& !env.getProperty("url_separator").equals(strURI)
					&& !env.getProperty("login_api_url").equals(strURI)) {
				response.sendRedirect(env.getProperty("root_url"));
				return false;
			}

			/*
			 * Disables caching of the page so when back browser is clicked, will
			 * not show cached page Reference:
			 * http://stackoverflow.com/questions/14219749/servlet-session-after-
			 * logout-when-back-button-of-browser-is-pressed-again
			 */
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setHeader("X-XSS-Protection", "1; mode=block");
			response.setHeader("X-Content-Type-Options", "nosniff");
			response.setHeader("Content-Security-Policy", "script-src 'self' 'unsafe-eval' 'unsafe-inline'");
			response.setHeader("X-Frame-Options", "DENY");

			return true;
	}
}
