package by.sobol.visacenter.web.action.impl.all;

import static by.sobol.visacenter.web.util.RequestParamValidator.validateEmail;
import static by.sobol.visacenter.web.util.RequestParamValidator.validateName;
import static by.sobol.visacenter.web.util.RequestParamValidator.validateSecondName;
import static by.sobol.visacenter.web.util.RequestParamValidator.validateSurname;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.User;
import by.sobol.visacenter.resoures.Resource;
import by.sobol.visacenter.service.UserService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;
import by.sobol.visacenter.web.util.RoleType;

public class ToChangedAccountImpl extends ActionAssistant implements BaseAction {

	private static final String SUCCESS = "success";
	private static UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		User user = newUserData(request);
		if (validateChangedUser(user, request)) {
			String message = userService.updateUser(user);
			return resultPage(message, user, request);
		} else {
			request.setAttribute(ATTR_USER, user);
			return FORM_CHANGE_ACCOUNT;
		}
	}

	private User newUserData(HttpServletRequest request) {
		User sessionUser = (User) request.getSession().getAttribute(ATTR_USER);
		User user = new User(sessionUser.getId());
		user.setAdmin(sessionUser.isAdmin());
		user.setName(request.getParameter(PARAM_USER_NAME));
		user.setSurname(request.getParameter(PARAM_USER_SURNAME));
		user.setSecondName(request.getParameter(PARAM_USER_SECOND_NAME));
		user.setEmail(request.getParameter(PARAM_USER_EMAIL));
		return user;

	}

	private String resultPage(String message, User user, HttpServletRequest request) {
		if (SUCCESS.equals(message)) {
			request.getSession().setAttribute(ATTR_USER, user);
			request.getSession().setAttribute(SESSION_MESSAGE, Resource.getMessage(ACCOUNT_CHANGED_SUCCESS, request));
			return identifyUser(user, request);
		} else {
			request.getSession().setAttribute(ATTR_DUP_MESSAGE, message);
			return FORM_CHANGE_ACCOUNT;
		}
	}

	private boolean validateChangedUser(User user, HttpServletRequest request) {
		boolean result = true;
		if (!validateName(user.getName())) {
			request.setAttribute(INVALID_NAME, Resource.getMessage(INVALID_NAME, request));
			result = false;
		}
		if (!validateSurname(user.getSurname())) {
			request.setAttribute(INVALID_SURNAME, Resource.getMessage(INVALID_SURNAME, request));
			result = false;
		}
		if (!validateSecondName(user.getSecondName())) {
			request.setAttribute(INVALID_SECOND_NAME, Resource.getMessage(INVALID_SECOND_NAME, request));
			result = false;
		}
		if (!validateEmail(user.getEmail())) {
			request.setAttribute(INVALID_EMAIL, Resource.getMessage(INVALID_EMAIL, request));
			result = false;
		}
		return result;
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