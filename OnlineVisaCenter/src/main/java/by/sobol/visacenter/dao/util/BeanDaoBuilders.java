package by.sobol.visacenter.dao.util;

import static by.sobol.visacenter.dao.util.TablesColumnNamesDeclaration.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import by.sobol.visacenter.model.CustomerPersonalData;
import by.sobol.visacenter.model.Gender;
import by.sobol.visacenter.model.NumberOfEntries;
import by.sobol.visacenter.model.Passport;
import by.sobol.visacenter.model.Questionnaire;
import by.sobol.visacenter.model.QuestionnaireStatus;
import by.sobol.visacenter.model.SchengenCountries;
import by.sobol.visacenter.model.SchengenVisa;
import by.sobol.visacenter.model.User;
import by.sobol.visacenter.model.VisaCategory;
import by.sobol.visacenter.model.VisaStatus;
import by.sobol.visacenter.model.VisaType;

public class BeanDaoBuilders {

	protected Questionnaire buildQuestionnaire(ResultSet resultSet) throws SQLException {
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setId(resultSet.getInt(QUESTIONNAIRE_ID));
		questionnaire.setUserId(resultSet.getInt(USER_ID));
		questionnaire.setVisa(new SchengenVisa(resultSet.getInt(VISA_ID)));
		questionnaire.setQuestionnaireStatus(QuestionnaireStatus.valueOf(resultSet.getString(QUESTIONNAIRE_STATUS)));
		return questionnaire;
	}
	
	protected CustomerPersonalData buildCustomerData(ResultSet resultSet) throws SQLException{
		CustomerPersonalData customerData = new CustomerPersonalData();
		customerData.setId(resultSet.getInt(CUSTOMER_ID));
		customerData.setName(resultSet.getString(CUSTOMER_NAME));
		customerData.setSurname(resultSet.getString(CUSTOMER_SURNAME));
		customerData.setSecondName(resultSet.getString(CUSTOMER_SECOND_NAME));
		customerData.setAddress(resultSet.getString(CUSTOMER_ADDRESS));
		customerData.setGender(Gender.valueOf(resultSet.getString(CUSTOMER_GENDER)));
		customerData.setPassport(buildPassport(resultSet));
		return customerData;
	}
	
	protected User buildUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setId(resultSet.getInt(USER_ID));
		user.setName(resultSet.getString(USER_NAME));
		user.setSurname(resultSet.getString(USER_SURNAME));
		user.setSecondName(resultSet.getString(USER_SECOND_NAME));
		user.setAdmin(resultSet.getBoolean(USER_IS_ADMIN));
		user.setEmail(resultSet.getString(USER_EMAIL));
		return user;
	}

	protected Passport buildPassport(ResultSet resultSet) throws SQLException {
		Passport passport = new Passport();
		passport.setPassportNum(resultSet.getString(PASSPORT_NUMBER));
		passport.setIssuedBy(resultSet.getString(PASSPORT_ISSUED_BY));
		passport.setDateOfIssue(LocalDate.parse(resultSet.getString(PASSPORT_DATE_OF_ISSUE)));
		passport.setDateOfExpiry(LocalDate.parse(resultSet.getString(PASSPORT_DATE_OF_EXTIRY)));
		return passport;
	}

	protected SchengenVisa buildSchengenVisa(ResultSet resultSet) throws SQLException {
		SchengenVisa schengenVisa = new SchengenVisa();
		schengenVisa.setId(resultSet.getInt(VISA_ID));
		schengenVisa.setVisaType(VisaType.valueOf(resultSet.getString(VISA_TYPE)));
		schengenVisa.setVisaCategory(VisaCategory.valueOf(resultSet.getString(VISA_CATEGORY)));
		schengenVisa.setNumberOfEntries(NumberOfEntries.valueOf(resultSet.getString(VISA_NUMBER_OF_ENTRIES)));
		schengenVisa.setFirstDate(LocalDate.parse(resultSet.getString(VISA_FIRST_DATE)));
		schengenVisa.setLastDate(LocalDate.parse(resultSet.getString(VISA_LAST_DATE)));
		schengenVisa.setSchengenContries(SchengenCountries.valueOf(resultSet.getString(VISA_SCHENGEN_COUNTRIES)));
		schengenVisa.setVisaStatus(VisaStatus.valueOf(resultSet.getString(VISA_STATUS)));
		schengenVisa.setCustomerData(buildCustomerData(resultSet));
		return schengenVisa;
	}
}
