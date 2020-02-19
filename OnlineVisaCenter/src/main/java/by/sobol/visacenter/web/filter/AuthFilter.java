package by.sobol.visacenter.web.filter;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.ATTR_USER;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.ERROR_JSP;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.REQUEST_PARAM_COMMAND;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.sobol.visacenter.model.User;
import by.sobol.visacenter.web.util.Action;
import by.sobol.visacenter.web.util.RoleType;

public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		User currentUser = (User) session.getAttribute(ATTR_USER);
		String inputCommand = request.getParameter(REQUEST_PARAM_COMMAND);
		Action action = null;
		if (inputCommand != null && !inputCommand.isEmpty()) {
			action = Action.valueOfOrDefault(inputCommand.toUpperCase());

			if (currentUser != null) {
				if (currentUser.isAdmin() && action.getRoleType() == RoleType.ADMIN) {
					chain.doFilter(request, response);
				} else if (!currentUser.isAdmin() && action.getRoleType() == RoleType.USER) {
					chain.doFilter(request, response);
				} else if (action.getRoleType() == RoleType.ALL) {
					chain.doFilter(request, response);
				} else {
					request.getRequestDispatcher(ERROR_JSP).forward(request, response);
				}
			} else {
				if (action.getRoleType() == RoleType.ALL) {
					chain.doFilter(request, response);
				} else {
					request.getRequestDispatcher(ERROR_JSP).forward(request, response);
				}
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

}
