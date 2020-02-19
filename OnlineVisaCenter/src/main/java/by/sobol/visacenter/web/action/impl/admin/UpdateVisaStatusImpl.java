package by.sobol.visacenter.web.action.impl.admin;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.PARAM_VISA_STATUS;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.ATTR_VISA;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.VISA_DETAILS_BY_ID_JSP;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.PARAM_VISA_ID;
import static by.sobol.visacenter.web.util.HttpRequestParamFormattor.formatInt;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.SchengenVisa;
import by.sobol.visacenter.model.VisaStatus;
import by.sobol.visacenter.service.VisaService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

public class UpdateVisaStatusImpl extends ActionAssistant implements BaseAction {

	private VisaService visaService = ServiceFactory.getVisaService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException{
		int id = formatInt(request.getParameter(PARAM_VISA_ID));
		VisaStatus status = VisaStatus.valueOf(request.getParameter(PARAM_VISA_STATUS));
		SchengenVisa visa = new SchengenVisa();
		visa.setId(id);
		visa.setVisaStatus(status);
		visaService.updateVisaStatus(visa);

		request.setAttribute(ATTR_VISA, visaService.getVisaById(id));
		setAttrListVisaAndCustomerMap(request);
		setVisaStatus(request);
		return VISA_DETAILS_BY_ID_JSP;
	}
}
