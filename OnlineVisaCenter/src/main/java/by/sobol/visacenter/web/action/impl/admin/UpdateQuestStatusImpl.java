package by.sobol.visacenter.web.action.impl.admin;

import static by.sobol.visacenter.web.util.HttpRequestParamFormattor.formatInt;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.ATTR_QUEST;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.PARAM_QUEST_ID;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.PARAM_QUEST_STATUS;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.QUEST_DETAILS_BY_ID_JSP;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.Questionnaire;
import by.sobol.visacenter.model.QuestionnaireStatus;
import by.sobol.visacenter.service.QuestionnaireService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

public class UpdateQuestStatusImpl extends ActionAssistant implements BaseAction {

	private QuestionnaireService questService = ServiceFactory.getQuestionnaireService();
	
	@Override
	public String executeAction(HttpServletRequest request) throws ActionException{
		int id = formatInt(request.getParameter(PARAM_QUEST_ID));
		QuestionnaireStatus status = QuestionnaireStatus.valueOf(request.getParameter(PARAM_QUEST_STATUS));
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setId(id);
		questionnaire.setQuestionnaireStatus(status);
		questService.updateQuestStatus(questionnaire);

		request.setAttribute(ATTR_QUEST, questService.getQuestById(id));
		setAttrListQuestAndVisaMap(request);
		setAttrListQuestAndCustomerMap(request);
		setQuestStatus(request);
		return QUEST_DETAILS_BY_ID_JSP;
	}
}
