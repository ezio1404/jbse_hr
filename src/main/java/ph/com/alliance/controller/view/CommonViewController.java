package ph.com.alliance.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonViewController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String loadHome() {
		return "index";
	}
	
//	//ASI630
//		@ExceptionHandler(NoHandlerFoundException.class)
//	    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
//	        ModelAndView mav = new ModelAndView("unsupported");
//	        mav.addObject("exception", e);  
//	        mav.addObject("errorcode", "404");
//	        return mav;
//	    }
}