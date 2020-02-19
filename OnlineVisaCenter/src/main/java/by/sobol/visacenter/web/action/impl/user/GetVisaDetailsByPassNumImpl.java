package by.sobol.visacenter.web.action.impl.user;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.SchengenVisa;
import by.sobol.visacenter.resoures.Resource;
import by.sobol.visacenter.service.VisaService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

public class GetVisaDetailsByPassNumImpl extends ActionAssistant implements BaseAction {

	private VisaService visaService = ServiceFactory.getVisaService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		String passNum = request.getParameter(PARAM_PASS_NUM);
		if (validateInputPassNum(passNum, request)) {
			SchengenVisa visa = visaService.getVisaByPassNum(passNum);
			if (visa != null) {
				request.setAttribute(ATTR_VISA, visa);
				setAttrListVisaAndCustomerMap(request);
				return VISA_DETAILS_JSP;
			}
			request.setAttribute(VISA_NOT_FOUND, Resource.getMessage(VISA_NOT_FOUND, request));
		}
		return FORM_SEARCH_VISA_JSP;
	}
}
