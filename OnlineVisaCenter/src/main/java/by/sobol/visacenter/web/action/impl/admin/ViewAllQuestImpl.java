package by.sobol.visacenter.web.action.impl.admin;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.ALL_QUEST_JSP;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

public class ViewAllQuestImpl extends ActionAssistant implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		setAttrListQuest(request);
		setQuestStatus(request);
		setVisaStatus(request);
		return ALL_QUEST_JSP;
	}
}
