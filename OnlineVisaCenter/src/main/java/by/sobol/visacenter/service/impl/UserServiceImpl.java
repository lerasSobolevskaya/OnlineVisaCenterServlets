package by.sobol.visacenter.service.impl;

import java.util.List;

import by.sobol.visacenter.dao.UserDao;
import by.sobol.visacenter.dao.factory.DaoFactory;
import by.sobol.visacenter.model.User;
import by.sobol.visacenter.service.UserService;
import by.sobol.visacenter.service.exception.ServiceException;
import by.sobol.visacenter.service.util.PasswordEncryptor;

public class UserServiceImpl implements UserService {

	private UserDao userDao = DaoFactory.getUserDao();

	private static final int DUP_LOGIN_CODE = 1;
	private static final int DUP_EMAIL_CODE = 2;

	private static final String SUCCESS = "success";
	private static final String DUP_LOGIN_MESSAGE = "Этот логин уже используется";
	private static final String DUP_EMAIL_MESSAGE = "Этот электронный адрес уже используется";

	@Override
	public User getUserById(int id) throws ServiceException {
		return userDao.getById(id);
	}

	@Override
	public void deleteUser(int id) throws ServiceException {
		userDao.delete(id);
	}

	@Override
	public String updateUser(User cutomer) throws ServiceException {
		int code = userDao.update(cutomer);
		String message = SUCCESS;
		if (code == DUP_EMAIL_CODE) {
			message = DUP_EMAIL_MESSAGE;
		}
		return message;
	}

	@Override
	public List<User> getAllUsers() throws ServiceException {
		return userDao.readAll();
	}

	@Override
	public String addUser(User user) throws ServiceException {
		user.setPassword(PasswordEncryptor.md5Apache(user.getPassword()));
		int code = userDao.create(user);
		String message = SUCCESS;
		if (code == DUP_LOGIN_CODE) {
			message = DUP_LOGIN_MESSAGE;
		} else if (code == DUP_EMAIL_CODE) {
			message = DUP_EMAIL_MESSAGE;
		}
		return message;

	}

	@Override
	public User getUserByLoginAndPass(String login, String pass) throws ServiceException {
		return userDao.getUserByLoginAndPass(login, PasswordEncryptor.md5Apache(pass));
	}

	@Override
	public void changePassword(User user) throws ServiceException {
		user.setPassword(PasswordEncryptor.md5Apache(user.getPassword()));
		userDao.updatePassword(user);
	}

	@Override
	public String getUserPass(int id) throws ServiceException {
		return userDao.getUserPass(id);
	}

}
