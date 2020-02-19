package by.sobol.visacenter.web.action.impl.admin;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.service.QuestionnaireService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.PARAM_QUEST_ID;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.ALL_QUEST_JSP;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.ERROR_JSP;
import static by.sobol.visacenter.web.util.RequestParamValidator.validatePositiveInt;
import static by.sobol.visacenter.web.util.HttpRequestParamFormattor.formatInt;

public class DeleteQuestImpl implements BaseAction {

	private static QuestionnaireService questSerivce = ServiceFactory.getQuestionnaireService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		String id = request.getParameter(PARAM_QUEST_ID);
		if (!validatePositiveInt(id)) {
			return ERROR_JSP;
		}
		questSerivce.deleteQuest(formatInt(id));
		return ALL_QUEST_JSP;
	}
}
