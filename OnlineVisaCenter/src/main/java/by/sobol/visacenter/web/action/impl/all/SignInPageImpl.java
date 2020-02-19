package by.sobol.visacenter.web.action.impl.all;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.SIGN_IN_JSP;

public class SignInPageImpl implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		return SIGN_IN_JSP;
	}

}
