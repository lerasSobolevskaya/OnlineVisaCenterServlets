package by.sobol.visacenter.web.action.impl.user;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.FORM_SEARCH_QUEST_JSP;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

public class SearchQuestPageImpl implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		return FORM_SEARCH_QUEST_JSP;
	}
}
