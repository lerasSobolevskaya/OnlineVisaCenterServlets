package by.sobol.visacenter.web.action.impl.admin;

import static by.sobol.visacenter.web.util.HttpRequestParamFormattor.formatInt;
import static by.sobol.visacenter.web.util.RequestParamValidator.validatePositiveInt;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.ATTR_QUEST;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.PARAM_QUEST_ID;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.QUEST_DETAILS_BY_ID_JSP;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.ERROR_JSP;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.Questionnaire;
import by.sobol.visacenter.service.QuestionnaireService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

public class GetQuestDetailsByIdImpl extends ActionAssistant implements BaseAction {

	private QuestionnaireService questService = ServiceFactory.getQuestionnaireService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		String id = request.getParameter(PARAM_QUEST_ID);
		if (!validatePositiveInt(id)) {
			return ERROR_JSP;
		}
		Questionnaire questionnaire = questService.getQuestById(formatInt(id));
		request.setAttribute(ATTR_QUEST, questionnaire);
		setAttrListQuestAndCustomerMap(request);
		setAttrListQuestAndVisaMap(request);
		setQuestStatus(request);
		setVisaStatus(request);
		return QUEST_DETAILS_BY_ID_JSP;
	}
}