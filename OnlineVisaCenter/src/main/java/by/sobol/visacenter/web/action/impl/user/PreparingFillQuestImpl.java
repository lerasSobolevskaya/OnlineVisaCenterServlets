package by.sobol.visacenter.web.action.impl.user;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;
import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.User;
import by.sobol.visacenter.resoures.Resource;
import by.sobol.visacenter.service.QuestionnaireService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

public class PreparingFillQuestImpl extends ActionAssistant implements BaseAction {

	private static QuestionnaireService questService = ServiceFactory.getQuestionnaireService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		User user = (User) request.getSession().getAttribute(ATTR_USER);
		if (questService.getQuestByUserId(user.getId())) {
			setAttrGenderUserList(request);
			setAttrSchengenCountries(request);
			setAttrVisaCategories(request);
			setVisaType(request);
			setNumOfEntries(request);
			return FORM_ADD_QUEST_JSP;
		}
		request.getSession().setAttribute(QUEST_HAVE_FILLED, Resource.getMessage(QUEST_HAVE_FILLED, request));
		return REDIRECT_USER;
	}
}
