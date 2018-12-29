package ph.com.alliance.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.com.alliance.entity.Variables;
import ph.com.alliance.model.ResponseModel;
import ph.com.alliance.service.VariablesService;
import ph.com.alliance.util.Common;

@Controller
public class VariablesAPIController {

	@Autowired
	private VariablesService variablesService;
	
	@RequestMapping(value="/variables/setVariable", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel<Boolean> setVariable(HttpServletRequest request) {
		ResponseModel<Boolean> responseModel = new ResponseModel<Boolean>();
		String strMessageCode = "Success";
		int iStatusCode = HttpServletResponse.SC_OK;
		Variables variables = new Variables();
		String strVariableName = null;
		String strValue = null;
		String strRemarks = null;
		boolean isSet = false;
		
		try {			
			if (Common.isNullOrEmpty(request.getParameter("variableName"))) {
				throw new Exception("[ERROR] required parameter: {variableName}; cannot be null or empty");
			}
			
			if (Common.isNullOrEmpty(request.getParameter("value"))) {
				throw new Exception("[ERROR] required parameter: {value}; cannot be null or empty");
			}
			
			if (!Common.isNullOrEmpty(request.getParameter("remarks"))) {
				strRemarks = request.getParameter("remarks");
			}
			
			strVariableName = request.getParameter("variableName");
			strValue = request.getParameter("value");
			
			variables = new Variables();
			variables.setVariableName(strVariableName);
			variables.setValue(strValue);
			variables.setRemarks(strRemarks);
			// TODO: Get user session and set it in updatedBy
			// variables.setUpdatedBy(updatedBy);
			
			isSet = variablesService.setVariable(variables);
		} catch (Exception e) {
			strMessageCode = e.getMessage();
			iStatusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			isSet = false;
		}
		
		responseModel.setResponsecode(iStatusCode);
		responseModel.setResponsemessage(strMessageCode);
		responseModel.setResponsedata(isSet);
		
		return responseModel;
	}
}