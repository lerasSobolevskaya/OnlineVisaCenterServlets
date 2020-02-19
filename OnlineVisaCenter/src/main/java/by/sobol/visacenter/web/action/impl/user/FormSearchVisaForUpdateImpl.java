package by.sobol.visacenter.web.action.impl.user;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.FORM_SEARCH_VISA;

public class FormSearchVisaForUpdateImpl implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		return FORM_SEARCH_VISA;
	}
}
