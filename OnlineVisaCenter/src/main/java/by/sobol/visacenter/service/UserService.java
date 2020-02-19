package by.sobol.visacenter.service;

import java.util.List;

import by.sobol.visacenter.model.User;
import by.sobol.visacenter.service.exception.ServiceException;

public interface UserService {

	User getUserById(int id) throws ServiceException;

	void deleteUser(int id) throws ServiceException;

	String updateUser(User user) throws ServiceException;

	List<User> getAllUsers() throws ServiceException;

	String addUser(User user) throws ServiceException;

	User getUserByLoginAndPass(String login, String pass) throws ServiceException;

	void changePassword(User user) throws ServiceException;

	String getUserPass(int id) throws ServiceException;

}
