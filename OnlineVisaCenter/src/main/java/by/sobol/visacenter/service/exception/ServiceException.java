package by.sobol.visacenter.service.exception;

import by.sobol.visacenter.web.action.exception.ActionException;

public class ServiceException extends ActionException {

	private static final long serialVersionUID = -4624180076018114357L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
