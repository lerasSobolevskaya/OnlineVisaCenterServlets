package by.sobol.visacenter.web.action.impl.all;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.ATTR_INFO_MESSAGE;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.SESSION_MESSAGE;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.INDEX_JSP;

public class RedirectGuestImpl implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		request.setAttribute(ATTR_INFO_MESSAGE, request.getSession().getAttribute(SESSION_MESSAGE));
		request.getSession().invalidate();
		return INDEX_JSP;
	}
}
