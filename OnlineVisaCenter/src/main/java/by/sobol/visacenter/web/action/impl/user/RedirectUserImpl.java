package by.sobol.visacenter.web.action.impl.user;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

public class RedirectUserImpl implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		String page = (String) request.getSession().getAttribute(ATTR_PAGE_TYPE);
		switch (page) {
		case ATTR_USER_ACCOUNT:
			setReqParamInfoMesasage(request);
			return USER_ACCOUNT_JSP;
		case PAGE_CHANGE_PASS:
			setReqParamInfoMesasage(request);
			return FORM_CHANGE_PASS;
		default:
			return INDEX_JSP;
		}
	}

	private void setReqParamInfoMesasage(HttpServletRequest request) {
		request.setAttribute(ATTR_INFO_MESSAGE, request.getSession().getAttribute(SESSION_MESSAGE));
		request.getSession().removeAttribute(SESSION_MESSAGE);
	}
}
