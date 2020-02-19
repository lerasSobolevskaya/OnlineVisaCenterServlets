package by.sobol.visacenter.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;
import by.sobol.visacenter.web.util.ActionFactory;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.REDIRECT_GUEST;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.REDIRECT_ADMIN;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.REDIRECT_USER;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.ERROR_JSP;

public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = -291307398254753889L;

	private static final Logger LOG = Logger.getLogger(MainServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BaseAction action = ActionFactory.chooseAction(request);
		String path = null;
		try {
			path = action.executeAction(request);
			if (path.equals(REDIRECT_ADMIN)) {
				response.sendRedirect(request.getContextPath() + REDIRECT_ADMIN);
			} else if (path.equals(REDIRECT_USER)) {
				response.sendRedirect(request.getContextPath() + REDIRECT_USER);
			} else if (path.equals(REDIRECT_GUEST)) {
				response.sendRedirect(request.getContextPath() + REDIRECT_GUEST);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}
		} catch (ActionException ex) {
			request.getRequestDispatcher(ERROR_JSP).forward(request, response);
			LOG.error(ex.getMessage(), ex);
		}
	}

}
