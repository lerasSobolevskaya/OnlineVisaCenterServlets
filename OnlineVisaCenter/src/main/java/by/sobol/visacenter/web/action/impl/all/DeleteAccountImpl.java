package by.sobol.visacenter.web.action.impl.all;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.ATTR_USER;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.User;
import by.sobol.visacenter.resoures.Resource;
import by.sobol.visacenter.service.UserService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.SUCCESS_USER_DELETE;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.REDIRECT_GUEST;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.SESSION_MESSAGE;

public class DeleteAccountImpl implements BaseAction {

	private static UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		User user = (User) request.getSession().getAttribute(ATTR_USER);
		userService.deleteUser(user.getId());
		request.getSession().setAttribute(SESSION_MESSAGE, Resource.getMessage(SUCCESS_USER_DELETE, request));
		return REDIRECT_GUEST;
	}
}
