package by.sobol.visacenter.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.sobol.visacenter.dao.UserDao;
import by.sobol.visacenter.dao.exception.DaoException;
import by.sobol.visacenter.dao.pool.DataSource;
import by.sobol.visacenter.dao.util.BeanDaoBuilders;
import by.sobol.visacenter.model.User;
import static by.sobol.visacenter.dao.util.TablesColumnNamesDeclaration.USER_PASSWORD;

public class UserDaoMySqlImpl extends BeanDaoBuilders implements UserDao {

	private static final String UPDATE_USER = "UPDATE user SET name=?, surname=?, second_name=?, email=? WHERE user_id=?";
	private static final String GET_USER_BY_ID = "SELECT user_id, name, surname, second_name, email FROM user WHERE user_id=?";
	private static final String DELETE_USER = "DELETE FROM user WHERE user_id=?";
	private static final String GET_ALL_USERS = "SELECT user_id, name, surname, second_name, is_admin, email FROM user WHERE is_admin = 0";
	private static final String ADD_USER = "INSERT INTO user (name, surname, second_name, email, login, password) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String FIND_USER_BY_LOGIN_PASSWORD = "SELECT user_id, name, surname, second_name, email, is_admin FROM user WHERE login=? AND password=?";
	private static final String UPDATE_PASSWORD = "UPDATE user SET password=? WHERE user_id=?";
	private static final String GET_USER_PASS = "SELECT password FROM user WHERE user_id=?";

	private static final String EX_IN_USER_CREATE = "Error while adding user to database";
	private static final String EX_IN_USER_UPDATE = "Error while trying to update user in database";
	private static final String EX_IN_USER_DELETE = "Error while deleting user from database";
	private static final String EX_IN_USER_GET_BY_ID = "Error while getting user from database";
	private static final String EX_IN_USER_GET_ALL = "Error while getting users from database";
	private static final String EX_IN_USER_GET_BY_LOG_PASS = "Error while getting user by login and password from database";
	private static final String EX_IN_USER_UPDATE_PASS = "Error while trying to update password in database";
	private static final String EX_IN_USER_GET_PASS = "Error while getting password from database";

	private static final int ERROR_DUP_CODE = 1062;
	private static final String END_LOGIN = "key 'login'";
	private static final String END_EMAIL = "key 'email'";

	@Override
	public List<User> readAll() throws DaoException {
		List<User> users = new ArrayList<>();
		try (Connection connection = DataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(GET_ALL_USERS)) {
			while (resultSet.next()) {
				users.add(buildUser(resultSet));
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_USER_GET_ALL, ex);
		}
		return users;
	}

	@Override
	public User getById(int id) throws DaoException {
		User user = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(GET_USER_BY_ID)) {
			preparedSt.setInt(1, id);
			try (ResultSet resultSet = preparedSt.executeQuery()) {
				while (resultSet.next()) {
					user = buildUser(resultSet);
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_USER_GET_BY_ID, ex);
		}
		return user;
	}

	@Override
	public int create(User user) throws DaoException {
		int code = 0;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(ADD_USER)) {
			preparedSt.setString(1, user.getName());
			preparedSt.setString(2, user.getSurname());
			preparedSt.setString(3, user.getSecondName());
			preparedSt.setString(4, user.getEmail());
			preparedSt.setString(5, user.getLogin());
			preparedSt.setString(6, user.getPassword());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			if (ex.getErrorCode() == ERROR_DUP_CODE) {
				code = indetifyDuplicateFields(ex.getMessage());
			}
			throw new DaoException(EX_IN_USER_CREATE, ex);
		}
		return code;
	}

	@Override
	public void delete(int id) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(DELETE_USER)) {
			preparedSt.setInt(1, id);
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_USER_DELETE, ex);
		}

	}

	@Override
	public int update(User user) throws DaoException {
		int code = 0;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(UPDATE_USER)) {
			preparedSt.setString(1, user.getName());
			preparedSt.setString(2, user.getSurname());
			preparedSt.setString(3, user.getSecondName());
			preparedSt.setString(4, user.getEmail());
			preparedSt.setInt(5, user.getId());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			if (ex.getErrorCode() == ERROR_DUP_CODE) {
				code = 2;
			} else {
				throw new DaoException(EX_IN_USER_UPDATE, ex);
			}
		}
		return code;
	}

	@Override
	public User getUserByLoginAndPass(String login, String pass) throws DaoException {
		User user = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(FIND_USER_BY_LOGIN_PASSWORD)) {
			preparedSt.setString(1, login);
			preparedSt.setString(2, pass);
			try (ResultSet resultSet = preparedSt.executeQuery()) {
				while (resultSet.next()) {
					user = buildUser(resultSet);
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_USER_GET_BY_LOG_PASS, ex);
		}
		return user;
	}

	@Override
	public void updatePassword(User user) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(UPDATE_PASSWORD)) {
			preparedSt.setNString(1, user.getPassword());
			preparedSt.setInt(2, user.getId());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_USER_UPDATE_PASS, ex);
		}
	}

	@Override
	public String getUserPass(int id) throws DaoException {
		String pass = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(GET_USER_PASS)) {
			preparedSt.setInt(1, id);
			try (ResultSet resultSet = preparedSt.executeQuery()) {
				while (resultSet.next()) {
					pass = resultSet.getString(USER_PASSWORD);
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_USER_GET_PASS, ex);
		}
		return pass;
	}

	private int indetifyDuplicateFields(String exMessage) {
		if (exMessage.endsWith(END_LOGIN)) {
			return 1;
		} else if (exMessage.endsWith(END_EMAIL)) {
			return 2;
		} else {
			return 0;
		}
	}

}
