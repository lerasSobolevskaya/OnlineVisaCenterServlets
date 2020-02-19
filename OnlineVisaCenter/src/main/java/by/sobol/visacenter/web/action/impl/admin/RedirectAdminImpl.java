package by.sobol.visacenter.web.action.impl.admin;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

public class RedirectAdminImpl implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		String page = (String) request.getSession().getAttribute(ATTR_PAGE_TYPE);
		switch (page) {
		case ATTR_ADMIN_ACCOUNT:
			setReqParamInfoMessage(request);
			return ADMIN_ACCOUNT_JSP;
		default:
			return INDEX_JSP;
		}
	}

	private void setReqParamInfoMessage(HttpServletRequest request) {
		request.setAttribute(ATTR_INFO_MESSAGE, request.getSession().getAttribute(SESSION_MESSAGE));
		request.getSession().removeAttribute(SESSION_MESSAGE);
	}
}
