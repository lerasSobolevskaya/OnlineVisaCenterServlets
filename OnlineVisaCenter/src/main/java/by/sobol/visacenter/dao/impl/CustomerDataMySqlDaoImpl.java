package by.sobol.visacenter.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.sobol.visacenter.dao.CustomerDataDao;
import by.sobol.visacenter.dao.exception.DaoException;
import by.sobol.visacenter.dao.pool.DataSource;
import by.sobol.visacenter.dao.util.BeanDaoBuilders;
import by.sobol.visacenter.model.CustomerPersonalData;

public class CustomerDataMySqlDaoImpl extends BeanDaoBuilders implements CustomerDataDao {

	private static final String ADD_CUSTOMER_DATA = "INSERT INTO customer_personal_data (name, surname, second_name, address, gender, passport_number, issued_by, date_of_issue, date_of_expiry) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_FROM_CUSTOMER_DATA = "SELECT customer_id, name, surname, second_name, address, gender, passport_number, issued_by, date_of_issue, date_of_expiry FROM customer_personal_data";
	private static final String UPDATE_CUSTOMER_DATA = "UPDATE customer_personal_data SET name=?,surname=?, second_name=?, address=?, gender=?, passport_number=?, issued_by=?, date_of_issue=?, date_of_expiry=? WHERE customer_id=?";
	private static final String DELETE_CUSTOMER_DATA = "DELETE FROM customer_personal_data WHERE customer_id=?";
	private static final String GET_CUSTOMER_DATA_BY_ID = "SELECT customer_id, name, surname, second_name, address, gender, passport_number, issued_by, date_of_issue, date_of_expiry FROM customer_personal_data WHERE customer_id=?";

	private static final String EX_IN_CDATA_CREATE = "Error while adding customer personal data to database";
	private static final String EX_IN_CDATA_UPDATE = "Error while trying to update customer personal data in database";
	private static final String EX_IN_CDATA_DELETE = "Error while deleting customer personal data from database";
	private static final String EX_IN_CDATA_GET_BY_ID = "Error while getting customer personal data from database";
	private static final String EX_IN_CDATA_GET_ALL = "Error while getting customer personal datas from database";

	@Override
	public List<CustomerPersonalData> readAll() throws DaoException {
		List<CustomerPersonalData> personalDatas = new ArrayList<>();
		try (Connection connection = DataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(GET_ALL_FROM_CUSTOMER_DATA)) {
			while (resultSet.next()) {
				personalDatas.add(buildCustomerData(resultSet));
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_CDATA_GET_ALL, ex);
		}
		return personalDatas;
	}

	@Override
	public CustomerPersonalData getById(int id) throws DaoException {
		CustomerPersonalData customerData = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(GET_CUSTOMER_DATA_BY_ID)) {
			preparedSt.setInt(1, id);
			try (ResultSet resultSet = preparedSt.executeQuery()) {
				while (resultSet.next()) {
					customerData = buildCustomerData(resultSet);
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_CDATA_GET_BY_ID, ex);
		}
		return customerData;
	}

	@Override
	public int create(CustomerPersonalData customerData) throws DaoException {
		int id = 0;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(ADD_CUSTOMER_DATA)) {
			preparedSt.setString(1, customerData.getName());
			preparedSt.setString(2, customerData.getSurname());
			preparedSt.setString(3, customerData.getSecondName());
			preparedSt.setString(4, customerData.getAddress());
			preparedSt.setString(5, customerData.getGender().toString());
			preparedSt.setString(6, customerData.getPassport().getPassportNum());
			preparedSt.setString(7, customerData.getPassport().getIssuedBy());
			preparedSt.setString(8, customerData.getPassport().getDateOfIssue().toString());
			preparedSt.setString(9, customerData.getPassport().getDateOfExpiry().toString());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_CDATA_CREATE, ex);

		}
		return id;
	}

	@Override
	public void delete(int id) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(DELETE_CUSTOMER_DATA)) {
			preparedSt.setInt(1, id);
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_CDATA_DELETE, ex);
		}
	}

	@Override
	public int update(CustomerPersonalData customerData) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(UPDATE_CUSTOMER_DATA)) {
			preparedSt.setString(1, customerData.getName());
			preparedSt.setString(2, customerData.getSurname());
			preparedSt.setString(3, customerData.getSecondName());
			preparedSt.setString(4, customerData.getAddress());
			preparedSt.setString(5, customerData.getGender().toString());
			preparedSt.setString(6, customerData.getPassport().getPassportNum());
			preparedSt.setString(7, customerData.getPassport().getIssuedBy());
			preparedSt.setString(8, customerData.getPassport().getDateOfIssue().toString());
			preparedSt.setString(9, customerData.getPassport().getDateOfExpiry().toString());
			preparedSt.setInt(10, customerData.getId());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_CDATA_UPDATE, ex);

		}
		return 0;
	}
}
