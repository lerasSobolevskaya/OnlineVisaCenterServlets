package by.sobol.visacenter.dao;

import by.sobol.visacenter.dao.exception.DaoException;
import by.sobol.visacenter.model.User;

public interface UserDao extends BaseDao<User> {

	User getUserByLoginAndPass(String login, String pass) throws DaoException;

	void updatePassword(User user) throws DaoException;
	
	String getUserPass(int id) throws DaoException;

}
