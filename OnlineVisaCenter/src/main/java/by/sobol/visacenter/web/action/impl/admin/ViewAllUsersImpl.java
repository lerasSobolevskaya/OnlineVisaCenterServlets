package by.sobol.visacenter.web.action.impl.admin;

import javax.servlet.http.HttpServletRequest;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.ALL_USERS_JSP;

public class ViewAllUsersImpl extends ActionAssistant implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		setAttrListUsers(request);
		return ALL_USERS_JSP;
	}
}
