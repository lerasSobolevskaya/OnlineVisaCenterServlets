package by.sobol.visacenter.web.action.impl.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.Questionnaire;
import by.sobol.visacenter.model.QuestionnaireStatus;
import by.sobol.visacenter.service.QuestionnaireService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.PARAM_QUEST_STATUS;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.ATTR_QUESTIONNAIRES;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.ALL_QUEST_JSP;

public class ShowQuestByStatusImpl extends ActionAssistant implements BaseAction {

	private static QuestionnaireService questService = ServiceFactory.getQuestionnaireService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		QuestionnaireStatus status = QuestionnaireStatus.valueOf(request.getParameter(PARAM_QUEST_STATUS));
		List<Questionnaire> questionnaires = questService.getQuestByStatus(status);
		request.setAttribute(ATTR_QUESTIONNAIRES, questionnaires);
		getCustomerDataForQuest(questionnaires, request);
		getVisaForQuest(questionnaires, request);
		setQuestStatus(request);
		return ALL_QUEST_JSP;
	}
}