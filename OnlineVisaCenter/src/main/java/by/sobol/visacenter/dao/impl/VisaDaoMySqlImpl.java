package by.sobol.visacenter.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.sobol.visacenter.dao.VisaDao;
import by.sobol.visacenter.dao.exception.DaoException;
import by.sobol.visacenter.dao.pool.DataSource;
import by.sobol.visacenter.dao.util.BeanDaoBuilders;
import by.sobol.visacenter.model.SchengenVisa;
import by.sobol.visacenter.model.VisaStatus;

public class VisaDaoMySqlImpl extends BeanDaoBuilders implements VisaDao {

	private static final String UPDATE_VISA = "UPDATE visa SET visa_category=?, visa_type=?, number_of_entries=?, first_date=?, last_date=?, schengen_countries=?, visa_status=? WHERE visa_id=?";
	private static final String GET_VISA_BY_ID = "SELECT v.visa_id, v.visa_type, v.visa_category, v.number_of_entries, v.first_date, v.last_date, v.schengen_countries, v.visa_status, v.customer_id, c.customer_id, c.name, c.surname, c.second_name, c.gender, c.address, c.passport_number, c.issued_by, c.date_of_issue, c.date_of_expiry FROM visa v JOIN customer_personal_data c ON v.customer_id=c.customer_id WHERE v.visa_id=?";
	private static final String GET_ALL_VISAS = "SELECT v.visa_id, v.number_of_entries, v.customer_id, v.visa_type, v.visa_category, v.schengen_countries, v.first_date, v.last_date, v.visa_status, c.customer_id, c.name, c.surname, c.second_name, c.gender, c.address, c.passport_number, c.issued_by, c.date_of_issue, c.date_of_expiry FROM visa v JOIN customer_personal_data c ON v.customer_id=c.customer_id";
	private static final String ADD_VISA = "INSERT INTO visa (visa_type, visa_category, number_of_entries, first_date, last_date, schengen_countries, customerer_id, visa_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE_VISA = "DELETE FROM visa WHERE visa_id=?";
	private static final String UPDATE_VISA_STATUS = "UPDATE visa SET visa_status=? WHERE visa_id=?";
	private static final String SELECT_VISA_BY_PASS_NUM = "SELECT v.visa_id, v.visa_status, v.visa_category, v.visa_type, v.number_of_entries, v.schengen_countries, v.first_date, v.last_date, v.customer_id, c.customer_id, c.name, c.surname, c.second_name, c.gender, c.address, c.passport_number, c.issued_by, c.date_of_issue, c.date_of_expiry FROM visa v JOIN customer_personal_data c ON v.customer_id=c.customer_id WHERE c.passport_number=?";
	private static final String SELECT_VISA_BY_STATUS = "SELECT v.visa_id, v.visa_type, v.visa_category, v.number_of_entries, v.first_date, v.last_date, v.schengen_countries, v.visa_status, v.customer_id, c.customer_id, c.name, c.surname, c.second_name, c.gender, c.address, c.passport_number, c.issued_by, c.date_of_issue, c.date_of_expiry FROM visa v JOIN customer_personal_data c ON v.customer_id=c.customer_id WHERE v.visa_status=?";

	private static final String EX_IN_VISA_CREATE = "Error while adding visa to database";
	private static final String EX_IN_VISA_UPDATE = "Error while trying to update visa in database";
	private static final String EX_IN_VISA_DELETE = "Error while deleting visa from database";
	private static final String EX_IN_VISA_GET_BY_ID = "Error while getting visa from database";
	private static final String EX_IN_VISA_GET_ALL = "Error while getting visas from database";
	private static final String EX_IN_VISA_UPDATE_STATUS = "Error while trying to update visa status in database";
	private static final String EX_IN_VISA_BY_PASS = "Error while getting visa by passport number from database";
	private static final String EX_IN_VISA_GET_BY_STATUS = "Error while getting visa by status from database";

	@Override
	public List<SchengenVisa> readAll() throws DaoException {
		List<SchengenVisa> visas = new ArrayList<>();
		try (Connection connection = DataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(GET_ALL_VISAS)) {
			while (resultSet.next()) {
				visas.add(buildSchengenVisa(resultSet));
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_VISA_GET_ALL, ex);
		}
		return visas;
	}

	@Override
	public SchengenVisa getById(int id) throws DaoException {
		SchengenVisa visa = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(GET_VISA_BY_ID)) {
			preparedSt.setInt(1, id);
			try (ResultSet resultSet = preparedSt.executeQuery()) {
				while (resultSet.next()) {
					visa = buildSchengenVisa(resultSet);
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_VISA_GET_BY_ID, ex);
		}
		return visa;
	}

	@Override
	public int create(SchengenVisa visa) throws DaoException {
		int id = 0;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(ADD_VISA)) {
			preparedSt.setString(1, visa.getVisaType().toString());
			preparedSt.setString(2, visa.getVisaCategory().toString());
			preparedSt.setString(3, visa.getNumberOfEntries().toString());
			preparedSt.setString(4, visa.getFirstDate().toString());
			preparedSt.setString(5, visa.getLastDate().toString());
			preparedSt.setString(6, visa.getSchengenCountries().toString());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_VISA_CREATE, ex);
		}
		return id;
	}

	@Override
	public void delete(int id) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(DELETE_VISA)) {
			preparedSt.setInt(1, id);
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_VISA_DELETE, ex);
		}
	}

	@Override
	public int update(SchengenVisa visa) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(UPDATE_VISA)) {
			preparedSt.setString(1, visa.getVisaCategory().toString());
			preparedSt.setString(2, visa.getVisaType().toString());
			preparedSt.setString(3, visa.getNumberOfEntries().toString());
			preparedSt.setString(4, visa.getFirstDate().toString());
			preparedSt.setString(5, visa.getLastDate().toString());
			preparedSt.setString(6, visa.getSchengenCountries().toString());
			preparedSt.setString(7, visa.getVisaStatus().toString());
			preparedSt.setInt(8, visa.getId());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_VISA_UPDATE, ex);
		}
		return 0;
	}

	@Override
	public void updateVisaStatus(SchengenVisa visa) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(UPDATE_VISA_STATUS)) {
			preparedSt.setString(1, visa.getVisaStatus().toString());
			preparedSt.setInt(2, visa.getId());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_VISA_UPDATE_STATUS, ex);
		}

	}

	@Override
	public SchengenVisa getVisaByPassport(String passNum) throws DaoException {
		SchengenVisa visa = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(SELECT_VISA_BY_PASS_NUM)) {
			preparedSt.setString(1, passNum);
			try (ResultSet resultSet = preparedSt.executeQuery()) {
				while (resultSet.next()) {
					visa = buildSchengenVisa(resultSet);
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_VISA_BY_PASS, ex);
		}
		return visa;
	}

	@Override
	public List<SchengenVisa> getVisasByStatus(VisaStatus status) throws DaoException {
		List<SchengenVisa> visas = new ArrayList<>();
		SchengenVisa visa = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(SELECT_VISA_BY_STATUS)) {
			preparedSt.setString(1, status.toString());
			try (ResultSet resultSet = preparedSt.executeQuery()) {
				while (resultSet.next()) {
					visa = buildSchengenVisa(resultSet);
					visa.setCustomerData(buildCustomerData(resultSet));
					visas.add(visa);
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_VISA_GET_BY_STATUS, ex);
		}
		return visas;
	}

}
