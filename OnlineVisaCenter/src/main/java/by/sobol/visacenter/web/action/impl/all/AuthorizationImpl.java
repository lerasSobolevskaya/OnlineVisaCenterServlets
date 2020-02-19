package by.sobol.visacenter.web.action.impl.all;

import static by.sobol.visacenter.web.util.RequestParamValidator.validateParamNotNull;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.User;
import by.sobol.visacenter.resoures.Resource;
import by.sobol.visacenter.service.UserService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;
import by.sobol.visacenter.web.util.RoleType;

public class AuthorizationImpl implements BaseAction {

	private static UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		String login = request.getParameter(PARAM_LOGIN);
		String pass = request.getParameter(PARAM_PASSWORD);
		validateParamNotNull(login);
		validateParamNotNull(pass);
		User user = userService.getUserByLoginAndPass(login, pass);

		return checkRecievedUser(user, request);
	}

	private String checkRecievedUser(User user, HttpServletRequest request) {
		if (user != null) {
			request.getSession().setAttribute(ATTR_USER, user);
			return identifyUser(user, request);
		} else {
			request.setAttribute(INVALID_LOGIN_PASS, Resource.getMessage(INVALID_LOGIN_PASS, request));
			return SIGN_IN_JSP;
		}
	}

	private String identifyUser(User user, HttpServletRequest request) {
		if (user.isAdmin()) {
			request.getSession().setAttribute(ATTR_ROLE_TYPE, RoleType.ADMIN);
			request.getSession().setAttribute(ATTR_PAGE_TYPE, ATTR_ADMIN_ACCOUNT);
			return REDIRECT_ADMIN;
		} else {
			request.getSession().setAttribute(ATTR_ROLE_TYPE, RoleType.USER);
			request.getSession().setAttribute(ATTR_PAGE_TYPE, ATTR_USER_ACCOUNT);
			return REDIRECT_USER;
		}
	}
}
