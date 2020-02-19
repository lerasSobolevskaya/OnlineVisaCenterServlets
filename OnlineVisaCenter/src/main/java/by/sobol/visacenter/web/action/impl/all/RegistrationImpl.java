package by.sobol.visacenter.web.action.impl.all;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.User;
import by.sobol.visacenter.resoures.Resource;
import by.sobol.visacenter.service.UserService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.RequestParamValidator.*;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

public class RegistrationImpl implements BaseAction {

	private static final String SUCCESS = "success";

	private static UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		User user = newUser(request);
		if (validateNewUser(user, request)) {
			String message = userService.addUser(user);
			return relultPage(message, user, request);
		} else {
			request.setAttribute(ATTR_NEW_USER, user);
			return SIGN_IN_JSP;
		}
	}

	private User newUser(HttpServletRequest request) {
		String name = request.getParameter(PARAM_USER_NAME);
		String surname = request.getParameter(PARAM_USER_SURNAME);
		String secondName = request.getParameter(PARAM_USER_SECOND_NAME);
		String login = request.getParameter(PARAM_LOGIN);
		String password = request.getParameter(PARAM_PASSWORD);
		String email = request.getParameter(PARAM_USER_EMAIL);
		return new User(name, surname, secondName, login, password, email);
	}

	private String relultPage(String message, User user, HttpServletRequest request) {
		if (SUCCESS.equals(message)) {
			request.getSession().setAttribute(SESSION_MESSAGE, Resource.getMessage(SUCCESS_REGISTRATION, request));
			return REDIRECT_GUEST;
		} else {
			request.setAttribute(ATTR_DUP_MESSAGE, message);
			request.setAttribute(ATTR_NEW_USER, user);
			return SIGN_IN_JSP;
		}

	}

	protected boolean validateNewUser(User user, HttpServletRequest request) {
		boolean result = true;
		if (!validateLogin(user.getLogin())) {
			request.setAttribute(INVALID_LOGIN, Resource.getMessage(INVALID_LOGIN, request));
			result = false;
		}
		if (!validatePassword(user.getPassword())) {
			request.setAttribute(INVALID_PASSWORD, Resource.getMessage(INVALID_PASSWORD, request));
			result = false;
		}
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
}
