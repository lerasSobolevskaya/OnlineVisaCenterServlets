package by.sobol.visacenter.web.action.impl.all;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.START_PAGE;

public class SignOutImpl implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		request.getSession().invalidate();
		return START_PAGE;
	}
}
