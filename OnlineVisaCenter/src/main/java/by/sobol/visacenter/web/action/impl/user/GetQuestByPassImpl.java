package by.sobol.visacenter.web.action.impl.user;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.Questionnaire;
import by.sobol.visacenter.resoures.Resource;
import by.sobol.visacenter.service.QuestionnaireService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

public class GetQuestByPassImpl extends ActionAssistant implements BaseAction {

	private QuestionnaireService questService = ServiceFactory.getQuestionnaireService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		String passNum = request.getParameter(PARAM_PASS_NUM);
		if (validateInputPassNum(passNum, request)) {
			Questionnaire quest = questService.getQuestByPassNum(passNum);
			if (quest != null) {
				request.setAttribute(ATTR_QUEST, quest);
				setAttrListQuestAndCustomerMap(request);
				setAttrListQuestAndVisaMap(request);
				return QUEST_DETAILS_BY_PASS_JSP;
			}
			request.setAttribute(QUEST_NOT_FOUND, Resource.getMessage(QUEST_NOT_FOUND, request));
		}
		return FORM_SEARCH_QUEST_JSP;
	}
}
