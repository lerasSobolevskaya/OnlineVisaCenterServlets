package by.sobol.visacenter.web.action.impl.user;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;
import static by.sobol.visacenter.web.util.HttpRequestParamFormattor.formatInt;
import static by.sobol.visacenter.web.util.RequestParamValidator.validatePositiveInt;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.SchengenVisa;
import by.sobol.visacenter.resoures.Resource;
import by.sobol.visacenter.service.VisaService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

public class ToSaveVisaChangesImpl extends ActionAssistant implements BaseAction {

	private static VisaService visaService = ServiceFactory.getVisaService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		String id = request.getParameter(PARAM_VISA_ID);
		Map<String, String> visaParams = getVisaReqParams(request);
		visaParams.put(PARAM_VISA_ID, id);
		if (!validatePositiveInt(id)) {
			return ERROR_JSP;
		}
		if (validateVisaInputData(visaParams, request)) {
			SchengenVisa visa = buildVisa(visaParams);
			visaService.updateVisa(visa);
			request.getSession().setAttribute(SESSION_MESSAGE, Resource.getMessage(SUCCESS_UPDATE_VISA, request));
			return REDIRECT_USER;
		} else {
			request.setAttribute(ATTR_VISA, visaService.getVisaById(formatInt(id)));
			setNumOfEntries(request);
			setAttrVisaCategories(request);
			setVisaType(request);
			setAttrSchengenCountries(request);
			return FORM_UPDATE_VISA;
		}
	}
}