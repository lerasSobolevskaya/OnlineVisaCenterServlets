package by.sobol.visacenter.web.action.impl.all;

import static by.sobol.visacenter.web.util.RequestParamValidator.validatePassword;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.User;
import by.sobol.visacenter.resoures.Resource;
import by.sobol.visacenter.service.UserService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.service.util.PasswordEncryptor;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;
import by.sobol.visacenter.web.util.RoleType;

public class ToSaveChangedPasswordImpl implements BaseAction {

	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		String oldPass = request.getParameter(PARAM_OLD_PAS);
		String newPass = request.getParameter(PARAM_NEW_PAS);
		String confirmPass = request.getParameter(PARAM_CONFIRM_PAS);
		if (validateNewPass(newPass, request)) {
			return changePass(oldPass, newPass, confirmPass, request);
		} else {
			return FORM_CHANGE_PASS;
		}
	}

	private String changePass(String oldPass, String newPass, String confirmPass, HttpServletRequest request)
			throws ActionException {
		User sessionUser = (User) request.getSession().getAttribute(ATTR_USER);
		String sessionUserPass = userService.getUserPass(sessionUser.getId());
		if (checkPassData(sessionUserPass, oldPass, newPass, confirmPass, request)) {
			User user = new User(sessionUser.getId());
			user.setAdmin(sessionUser.isAdmin());
			user.setPassword(newPass);
			userService.changePassword(user);
			request.getSession().setAttribute(SESSION_MESSAGE, Resource.getMessage(PASS_CHANGED, request));
			return identifyRoleType(user, request);
		} else {
			return REDIRECT_USER;
		}
	}

	private boolean checkPassData(String sessionUserPass, String oldPass, String newPass, String confirmPass,
			HttpServletRequest request) {
		boolean result = true;
		if (!sessionUserPass.equals(PasswordEncryptor.md5Apache(oldPass))) {
			request.getSession().setAttribute(ATTR_PAGE_TYPE, PAGE_CHANGE_PASS);
			request.getSession().setAttribute(SESSION_MESSAGE, Resource.getMessage(WRONG_OLD_PASS, request));
			result = false;
		} else if (!newPass.equals((confirmPass))) {
			request.getSession().setAttribute(ATTR_PAGE_TYPE, PAGE_CHANGE_PASS);
			request.getSession().setAttribute(SESSION_MESSAGE, Resource.getMessage(WRONG_CONFIRMATION, request));
			result = false;
		}
		return result;
	}

	private boolean validateNewPass(String newPass, HttpServletRequest request) {
		boolean result = true;
		if (!validatePassword(newPass)) {
			request.setAttribute(INVALID_PASSWORD, Resource.getMessage(INVALID_PASSWORD, request));
			result = false;
		}
		return result;
	}

	private String identifyRoleType(User user, HttpServletRequest request) {
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
