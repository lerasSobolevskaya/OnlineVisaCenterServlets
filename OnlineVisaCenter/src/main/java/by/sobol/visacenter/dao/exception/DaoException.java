package by.sobol.visacenter.dao.exception;

import by.sobol.visacenter.service.exception.ServiceException;

public class DaoException extends ServiceException {

	private static final long serialVersionUID = 763226552131818232L;

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
