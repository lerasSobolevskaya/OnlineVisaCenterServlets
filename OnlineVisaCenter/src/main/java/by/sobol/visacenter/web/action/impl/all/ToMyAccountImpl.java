package by.sobol.visacenter.web.action.impl.all;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;
import by.sobol.visacenter.web.util.RoleType;

public class ToMyAccountImpl implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		RoleType roleType = (RoleType) request.getSession().getAttribute(ATTR_ROLE_TYPE);
		if (roleType == RoleType.ADMIN) {
			return ADMIN_ACCOUNT_JSP;
		} else if (roleType == RoleType.USER) {
			request.getSession().setAttribute(ATTR_PAGE_TYPE, ATTR_USER_ACCOUNT);
			return REDIRECT_USER;
		} else {
			return START_PAGE;

		}
	}

}
