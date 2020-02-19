package by.sobol.visacenter.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.sobol.visacenter.dao.PassportDao;
import by.sobol.visacenter.dao.exception.DaoException;
import by.sobol.visacenter.dao.pool.DataSource;
import by.sobol.visacenter.dao.util.BeanDaoBuilders;
import by.sobol.visacenter.model.Passport;

public class PassportDaoMySqlImpl extends BeanDaoBuilders implements PassportDao {

	private static final String UPDATE_PASSPORT = "UPDATE passport SET passport_number=?, issued_by=?, date_of_issue=?, date_of_expiry=? WHERE passport_id=?";
	private static final String GET_PASSPORT_BY_ID = "SELECT p.passport_id, p.passport_number, p.issued_by, p.date_of_issue, p.date_of_expiry, p.user_id, u.user_id, u.name, u.surname, u.second_name, u.gender, u.address FROM passport p JOIN user u ON p.user_id=c.user_id WHERE p.passport_id=?";
	private static final String DELETE_PASSPORT = "DELETE FROM passport WHERE passport_id=?";
	private static final String ADD_PASSPORT = "INSERT INTO passport (passport_number, issued_by, date_of_issue, date_of_expiry, user_id) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_PASSPORTS = "SELECT p.user_id, p.issued_by, p.date_of_issue, p.date_of_expiry, u.user_id, u.name, u.surname, u.second_name, u.gender, u.address FROM passport p JOIN user u ON p.user_id=u.user_id";

	private static final String EX_IN_PASS_CREATE = "Error while adding passport to database";
	private static final String EX_IN_PASS_UPDATE = "Error while trying to update passport in database";
	private static final String EX_IN_PASS_DELETE = "Error while deleting passport from database";
	private static final String EX_IN_PASS_GET_BY_ID = "Error while getting passport from database";
	private static final String EX_IN_PASS_GET_ALL = "Error while getting passports from database";

	@Override
	public List<Passport> readAll() throws DaoException {
		List<Passport> passports = new ArrayList<>();
		try (Connection connection = DataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(GET_ALL_PASSPORTS)) {
			while (resultSet.next()) {
				passports.add(buildPassport(resultSet));
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_PASS_GET_ALL, ex);
		}
		return passports;
	}

	@Override
	public Passport getById(int id) throws DaoException {
		Passport passport = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(GET_PASSPORT_BY_ID)) {
			preparedSt.setInt(1, id);
			try (ResultSet resultSet = preparedSt.executeQuery()) {
				while (resultSet.next()) {
					passport = buildPassport(resultSet);
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_PASS_GET_BY_ID, ex);
		}
		return passport;
	}

	@Override
	public int create(Passport passport) throws DaoException {
		int id = 0;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(ADD_PASSPORT)) {
			preparedSt.setString(1, passport.getPassportNum());
			preparedSt.setString(2, passport.getIssuedBy());
			preparedSt.setString(3, passport.getDateOfIssue().toString());
			preparedSt.setString(4, passport.getDateOfExpiry().toString());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_PASS_CREATE, ex);
		}
		return id;
	}

	@Override
	public void delete(int id) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(DELETE_PASSPORT)) {
			preparedSt.setInt(1, id);
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_PASS_DELETE, ex);
		}
	}

	@Override
	public int update(Passport passport) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(UPDATE_PASSPORT)) {
			preparedSt.setString(1, passport.getPassportNum());
			preparedSt.setString(2, passport.getIssuedBy());
			preparedSt.setString(3, passport.getDateOfIssue().toString());
			preparedSt.setString(4, passport.getDateOfExpiry().toString());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_PASS_UPDATE, ex);
		}
		return 0;
	}

}
