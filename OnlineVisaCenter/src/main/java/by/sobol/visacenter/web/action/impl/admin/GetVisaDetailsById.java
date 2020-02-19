package by.sobol.visacenter.web.action.impl.admin;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.SchengenVisa;
import by.sobol.visacenter.service.VisaService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.PARAM_VISA_ID;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.ATTR_VISA;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.VISA_DETAILS_BY_ID_JSP;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.ERROR_JSP;
import static by.sobol.visacenter.web.util.HttpRequestParamFormattor.formatInt;
import static by.sobol.visacenter.web.util.RequestParamValidator.validatePositiveInt;

public class GetVisaDetailsById extends ActionAssistant implements BaseAction {

	private static VisaService visaService = ServiceFactory.getVisaService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		String id = request.getParameter(PARAM_VISA_ID);
		if (!validatePositiveInt(id)) {
			return ERROR_JSP;
		}
		SchengenVisa visa = visaService.getVisaById(formatInt(id));
		request.setAttribute(ATTR_VISA, visa);
		setAttrListVisaAndCustomerMap(request);
		setVisaStatus(request);
		return VISA_DETAILS_BY_ID_JSP;
	}
}
