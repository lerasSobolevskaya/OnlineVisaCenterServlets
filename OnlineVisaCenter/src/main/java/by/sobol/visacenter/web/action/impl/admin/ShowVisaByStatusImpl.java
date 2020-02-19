package by.sobol.visacenter.web.action.impl.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.SchengenVisa;
import by.sobol.visacenter.model.VisaStatus;
import by.sobol.visacenter.service.VisaService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

public class ShowVisaByStatusImpl extends ActionAssistant implements BaseAction {

	private static VisaService visaService = ServiceFactory.getVisaService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		VisaStatus status = VisaStatus.valueOf(request.getParameter(PARAM_VISA_STATUS));
		List<SchengenVisa> visas = visaService.getVisaByStatus(status);
		request.setAttribute(ATTR_VISAS, visas);
		getCustomerDataForVisa(visas, request);
		setVisaStatus(request);
		return ALL_VISAS_JSP;
	}
}
