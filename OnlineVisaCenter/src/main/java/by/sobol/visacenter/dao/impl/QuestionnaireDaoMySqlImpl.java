package by.sobol.visacenter.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.sobol.visacenter.dao.QuestionnaireDao;
import by.sobol.visacenter.dao.exception.DaoException;
import by.sobol.visacenter.dao.pool.DataSource;
import by.sobol.visacenter.dao.util.BeanDaoBuilders;
import by.sobol.visacenter.model.Questionnaire;
import by.sobol.visacenter.model.QuestionnaireStatus;

public class QuestionnaireDaoMySqlImpl extends BeanDaoBuilders implements QuestionnaireDao {

	private static final String ADD_CUSTOMER_DATA = "INSERT INTO customer_personal_data (name, surname, second_name, address, gender, passport_number, issued_by, date_of_issue, date_of_expiry) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_QUESTIONNAIRES = "SELECT q.questionnaire_id, q.customer_id, q.visa_id, q.questionnaire_status, q.user_id, c.customer_id, c.name, c.surname, c.second_name, c.address, c.gender, c.passport_number, c.issued_by, c.date_of_issue, c.date_of_expiry, v.visa_id, v.visa_category, v.visa_type, v.number_of_entries, v.first_date, v.last_date, v.schengen_countries, v.visa_status, v.customer_id FROM questionnaire q JOIN visa v ON q.visa_id=v.visa_id JOIN customer_personal_data c ON q.customer_id=c.customer_id";
	private static final String DELETE_QUESTIONNAIRE = "DELETE FROM questionnaire WHERE questionnaire_id=?";
	private static final String GET_QUESTIONNAIRE_BY_ID = "SELECT q.questionnaire_id, q.visa_id, q.questionnaire_status, q.user_id, q.customer_id, c.customer_id, c.name, c.surname, c.second_name, c.passport_number, c.issued_by, c.date_of_issue, c.date_of_expiry, v.visa_id, v.visa_category, v.visa_type, v.number_of_entries, v.first_date, v.last_date, v.schengen_countries, v.visa_status FROM questionnaire q JOIN customer_personal_data c ON q.customer_id=c.customer_id JOIN visa v ON q.visa_id=v.visa_id WHERE q.questionnaire_id=?";
	private static final String ADD_VISA = "INSERT INTO visa (visa_type, visa_category, number_of_entries, first_date, last_date, schengen_countries, customer_id, visa_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String ADD_QUESTIONNAIRE = "INSERT INTO questionnaire (customer_id, user_id, visa_id, questionnaire_status) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_QUESTIONNAIRE = "UPDATE questionnaire SET questionnaire_status=? WHERE questionnaire_id=? ";
	private static final String UPDATE_STATUS = "UPDATE questionnaire SET questionnaire_status=? WHERE questionnaire_id=?";
	private static final String GET_QUEST_BY_PASS = "SELECT q.questionnaire_id, q.visa_id, q.questionnaire_status, q.user_id, q.customer_id, c.customer_id, c.name, c.surname, c.second_name, c.passport_number, c.issued_by, c.date_of_issue, c.date_of_expiry, v.visa_id, v.visa_category, v.visa_type, v.number_of_entries, v.first_date, v.last_date, v.schengen_countries, v.visa_status FROM questionnaire q JOIN customer_personal_data c ON q.customer_id=c.customer_id JOIN visa v ON q.visa_id=v.visa_id WHERE c.passport_number=?";
	private static final String GET_QUEST_WITH_STATUS = "SELECT q.questionnaire_id, q.visa_id, q.questionnaire_status, q.user_id, q.customer_id, c.customer_id, c.name, c.surname, c.second_name, c.gender, c.passport_number, c.address, c.issued_by, c.date_of_issue, c.date_of_expiry, v.visa_id, v.visa_category, v.visa_type, v.number_of_entries, v.first_date, v.last_date, v.schengen_countries, v.visa_status FROM questionnaire q JOIN customer_personal_data c ON q.customer_id=c.customer_id JOIN visa v ON q.visa_id=v.visa_id WHERE q.questionnaire_status=?";
	private static final String GET_QUEST_BY_USER_ID = "SELECT q.questionnaire_id, q.visa_id, q.questionnaire_status, q.user_id, q.customer_id, c.customer_id,c.address, c.gender, c.name, c.surname, c.second_name, c.passport_number, c.issued_by, c.date_of_issue, c.date_of_expiry, v.visa_id, v.visa_category, v.visa_type, v.number_of_entries, v.first_date, v.last_date, v.schengen_countries, v.visa_status FROM questionnaire q JOIN customer_personal_data c ON q.customer_id=c.customer_id JOIN visa v ON q.visa_id=v.visa_id WHERE q.user_id=?";

	private static final String EX_IN_QUEST_CREATE = "Error while adding questionnaire to database";
	private static final String EX_IN_QUEST_UPDATE = "Error while trying to update questionnaire in database";
	private static final String EX_IN_QUEST_DELETE = "Error while deleting questionnaire from database";
	private static final String EX_IN_QUEST_GET_BY_ID = "Error while getting questionnaire from database";
	private static final String EX_IN_QUEST_GET_ALL = "Error while getting questionnaires from database";
	private static final String EX_IN_QUEST_GET_BY_PASS = "Error while adding questionnaire to database";
	private static final String EX_IN_QUEST_UPDATE_STATUS = "Error while trying to update questionnaire in database";
	private static final String EX_IN_QUEST_GET_BY_STATUS = "Error while deleting questionnaire from database";
	private static final String EX_IN_QUEST_GET_BY_USER_ID = "Error while getting questionnaire from database";

	private static final int ERROR_DUP_CODE = 1062;
	private static final String DUP_PASS_NUM = "key 'passport_number'";

	@Override
	public List<Questionnaire> readAll() throws DaoException {
		List<Questionnaire> questionnaires = new ArrayList<>();
		Questionnaire questionnaire = null;
		try (Connection connection = DataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(GET_ALL_QUESTIONNAIRES)) {
			while (resultSet.next()) {
				questionnaire = buildQuestionnaire(resultSet);
				questionnaire.setCustomerData(buildCustomerData(resultSet));
				questionnaire.setVisa(buildSchengenVisa(resultSet));
				questionnaires.add(questionnaire);
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_QUEST_GET_ALL, ex);
		}
		return questionnaires;
	}

	@Override
	public Questionnaire getById(int id) throws DaoException {
		Questionnaire questionnaire = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement prepareSt = connection.prepareStatement(GET_QUESTIONNAIRE_BY_ID)) {
			prepareSt.setInt(1, id);
			try (ResultSet resultSet = prepareSt.executeQuery()) {
				while (resultSet.next()) {
					questionnaire = buildQuestionnaire(resultSet);
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_QUEST_GET_BY_ID, ex);
		}
		return questionnaire;
	}

	@Override
	public int create(Questionnaire entity) throws DaoException {
		Connection connection = null;
		int id = 0;
		int code = 0;
		try {
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			try (PreparedStatement customerDataPreparedSt = connection.prepareStatement(ADD_CUSTOMER_DATA,
					Statement.RETURN_GENERATED_KEYS);
					PreparedStatement visaPreparedSt = connection.prepareStatement(ADD_VISA,
							Statement.RETURN_GENERATED_KEYS);
					PreparedStatement questionnairePreparedSt = connection.prepareStatement(ADD_QUESTIONNAIRE,
							Statement.RETURN_GENERATED_KEYS)) {
				customerDataPreparedSt.setString(1, entity.getCustomerData().getName());
				customerDataPreparedSt.setString(2, entity.getCustomerData().getSurname());
				customerDataPreparedSt.setString(3, entity.getCustomerData().getSecondName());
				customerDataPreparedSt.setString(4, entity.getCustomerData().getAddress());
				customerDataPreparedSt.setString(5, entity.getCustomerData().getGender().toString());
				customerDataPreparedSt.setString(6, entity.getCustomerData().getPassport().getPassportNum());
				customerDataPreparedSt.setString(7, entity.getCustomerData().getPassport().getIssuedBy());
				customerDataPreparedSt.setString(8, entity.getCustomerData().getPassport().getDateOfIssue().toString());
				customerDataPreparedSt.setString(9,
						entity.getCustomerData().getPassport().getDateOfExpiry().toString());
				customerDataPreparedSt.executeUpdate();
				ResultSet resultSet = customerDataPreparedSt.getGeneratedKeys();
				if (resultSet.next()) {
					entity.getCustomerData().setId(resultSet.getInt(1));
				}
				visaPreparedSt.setString(1, entity.getVisa().getVisaType().toString());
				visaPreparedSt.setString(2, entity.getVisa().getVisaCategory().toString());
				visaPreparedSt.setString(3, entity.getVisa().getNumberOfEntries().toString());
				visaPreparedSt.setString(4, entity.getVisa().getFirstDate().toString());
				visaPreparedSt.setString(5, entity.getVisa().getLastDate().toString());
				visaPreparedSt.setString(6, entity.getVisa().getSchengenCountries().toString());
				visaPreparedSt.setInt(7, entity.getCustomerData().getId());
				visaPreparedSt.setString(8, entity.getVisa().getVisaStatus().toString());
				visaPreparedSt.executeUpdate();
				resultSet = visaPreparedSt.getGeneratedKeys();
				if (resultSet.next()) {
					entity.getVisa().setId(resultSet.getInt(1));
				}
				questionnairePreparedSt.setInt(1, entity.getCustomerData().getId());
				questionnairePreparedSt.setInt(2, entity.getUserId());
				questionnairePreparedSt.setInt(3, entity.getVisa().getId());
				questionnairePreparedSt.setString(4, entity.getQuestionnaireStatus().toString());
				questionnairePreparedSt.executeUpdate();
				if (resultSet.next()) {
					id = resultSet.getInt(1);
				}
				connection.commit();
			} catch (SQLException ex) {
				if (ex.getErrorCode() == ERROR_DUP_CODE) {
					code = identifyDuplicateField(ex.getMessage());
					return code;
				}
				connection.rollback();
				throw new DaoException(EX_IN_QUEST_CREATE, ex);
			} finally {
				connection.setAutoCommit(true);
			}

		} catch (SQLException ex) {
			throw new DaoException(EX_IN_QUEST_CREATE, ex);
		}
		return id;
	}

	@Override
	public void delete(int id) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(DELETE_QUESTIONNAIRE)) {
			preparedSt.setInt(1, id);
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_QUEST_DELETE, ex);
		}
	}

	@Override
	public int update(Questionnaire questionnaire) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement questionnairePreparedSt = connection.prepareStatement(UPDATE_QUESTIONNAIRE);) {
			questionnairePreparedSt.setString(1, questionnaire.getQuestionnaireStatus().toString());
			questionnairePreparedSt.setInt(2, questionnaire.getId());
			questionnairePreparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_QUEST_UPDATE, ex);
		}
		return 0;
	}

	@Override
	public Questionnaire getQuestByPassNum(String passNum) throws DaoException {
		Questionnaire quest = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(GET_QUEST_BY_PASS)) {
			preparedSt.setString(1, passNum);
			try (ResultSet resultSet = preparedSt.executeQuery()) {
				while (resultSet.next()) {
					quest = buildQuestionnaire(resultSet);
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_QUEST_GET_BY_PASS, ex);
		}
		return quest;
	}

	@Override
	public void updateQuestStatus(Questionnaire quest) throws DaoException {
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(UPDATE_STATUS)) {
			preparedSt.setString(1, quest.getQuestionnaireStatus().toString());
			preparedSt.setInt(2, quest.getId());
			preparedSt.executeUpdate();
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_QUEST_UPDATE_STATUS, ex);
		}

	}

	@Override
	public List<Questionnaire> getQuestByStatus(QuestionnaireStatus status) throws DaoException {
		List<Questionnaire> questionnaires = new ArrayList<>();
		Questionnaire quest = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(GET_QUEST_WITH_STATUS)) {
			preparedSt.setString(1, status.toString());
			try (ResultSet resultSet = preparedSt.executeQuery()) {
				while (resultSet.next()) {
					quest = buildQuestionnaire(resultSet);
					quest.setCustomerData(buildCustomerData(resultSet));
					quest.setVisa(buildSchengenVisa(resultSet));
					questionnaires.add(quest);
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_QUEST_GET_BY_STATUS, ex);
		}
		return questionnaires;
	}

	@Override
	public Questionnaire getQuestByUserId(int userId) throws DaoException {
		Questionnaire quest = null;
		try (Connection connection = DataSource.getConnection();
				PreparedStatement preparedSt = connection.prepareStatement(GET_QUEST_BY_USER_ID)) {
			preparedSt.setInt(1, userId);
			try (ResultSet resultSet = preparedSt.executeQuery()) {
				while (resultSet.next()) {
					quest = buildQuestionnaire(resultSet);
					quest.setVisa(buildSchengenVisa(resultSet));
				}
			}
		} catch (SQLException ex) {
			throw new DaoException(EX_IN_QUEST_GET_BY_USER_ID, ex);
		}
		return quest;
	}

	private int identifyDuplicateField(String exMessage) {
		if (exMessage.endsWith(DUP_PASS_NUM)) {
			return 1;
		}
		return 0;
	}

}
