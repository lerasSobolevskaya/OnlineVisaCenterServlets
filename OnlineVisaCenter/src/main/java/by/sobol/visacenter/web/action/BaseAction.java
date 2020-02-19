package by.sobol.visacenter.web.action;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.web.action.exception.ActionException;

public interface BaseAction {

	String executeAction(HttpServletRequest request) throws ActionException;
}
