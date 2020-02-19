package by.sobol.visacenter.web.action;

import static by.sobol.visacenter.web.util.HttpRequestParamFormattor.*;
import static by.sobol.visacenter.web.util.RequestParamValidator.*;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.model.CustomerPersonalData;
import by.sobol.visacenter.model.Gender;
import by.sobol.visacenter.model.NumberOfEntries;
import by.sobol.visacenter.model.Questionnaire;
import by.sobol.visacenter.model.QuestionnaireStatus;
import by.sobol.visacenter.model.SchengenCountries;
import by.sobol.visacenter.model.SchengenVisa;
import by.sobol.visacenter.model.User;
import by.sobol.visacenter.model.VisaCategory;
import by.sobol.visacenter.model.VisaStatus;
import by.sobol.visacenter.model.VisaType;
import by.sobol.visacenter.resoures.Resource;
import by.sobol.visacenter.service.CustomerDataService;
import by.sobol.visacenter.service.QuestionnaireService;
import by.sobol.visacenter.service.UserService;
import by.sobol.visacenter.service.VisaService;
import by.sobol.visacenter.service.exception.ServiceException;
import by.sobol.visacenter.service.factory.ServiceFactory;

public class ActionAssistant {

	private static VisaService visaService = ServiceFactory.getVisaService();
	private static CustomerDataService customerDataService = ServiceFactory.getCustomerData();
	private static QuestionnaireService questService = ServiceFactory.getQuestionnaireService();
	private static UserService userService = ServiceFactory.getUserService();

	protected void setAttrListQuestAndCustomerMap(HttpServletRequest request) throws ServiceException {
		List<Questionnaire> questionnaires = questService.getAllQuest();
		request.setAttribute(ATTR_QUESTIONNAIRES, questionnaires);
		Map<Integer, CustomerPersonalData> mapCustomers = getCustomerDataForQuest(questionnaires, request);
		request.setAttribute(ATTR_MAP_CUSTOMERS, mapCustomers);

	}

	protected void setAttrListVisaAndCustomerMap(HttpServletRequest request) throws ServiceException {
		List<SchengenVisa> visas = visaService.getAllVisas();
		request.setAttribute(ATTR_VISAS, visas);
		Map<Integer, CustomerPersonalData> mapCustomers = getCustomerDataForVisa(visas, request);
		request.setAttribute(ATTR_MAP_CUSTOMERS, mapCustomers);
	}

	protected void setAttrListQuestAndVisaMap(HttpServletRequest request) throws ServiceException {
		List<Questionnaire> questionnaires = questService.getAllQuest();
		request.setAttribute(ATTR_QUESTIONNAIRES, questionnaires);
		Map<Integer, SchengenVisa> mapVisa = getVisaForQuest(questionnaires, request);
		request.setAttribute(ATTR_MAP_VISAS, mapVisa);

	}

	protected Map<Integer, SchengenVisa> getVisaForQuest(List<Questionnaire> questionnaires, HttpServletRequest request)
			throws ServiceException {
		Map<Integer, SchengenVisa> mapVisas = new HashMap<>();
		for (Questionnaire questionnaire : questionnaires) {
			int visaId = questionnaire.getVisa().getId();
			SchengenVisa visa = visaService.getVisaById(visaId);
			mapVisas.put(questionnaire.getId(), visa);
			request.setAttribute(ATTR_MAP_VISAS, mapVisas);
		}
		return mapVisas;
	}

	protected Map<Integer, CustomerPersonalData> getCustomerDataForQuest(List<Questionnaire> questionnaires,
			HttpServletRequest request) throws ServiceException {
		Map<Integer, CustomerPersonalData> mapCustomerDatas = new HashMap<>();
		for (Questionnaire questionnaire : questionnaires) {
			int customerId = questionnaire.getCustomerData().getId();
			CustomerPersonalData customerData = customerDataService.getCustomerDataById(customerId);
			mapCustomerDatas.put(questionnaire.getId(), customerData);
			request.setAttribute(ATTR_MAP_CUSTOMERS, mapCustomerDatas);
		}
		return mapCustomerDatas;
	}

	protected Map<Integer, CustomerPersonalData> getCustomerDataForVisa(List<SchengenVisa> visas,
			HttpServletRequest request) throws ServiceException {
		Map<Integer, CustomerPersonalData> mapCustomerDatas = new HashMap<>();
		for (SchengenVisa visa : visas) {
			int customerId = visa.getCustomerData().getId();
			CustomerPersonalData customerData = customerDataService.getCustomerDataById(customerId);
			mapCustomerDatas.put(visa.getId(), customerData);
			request.setAttribute(ATTR_MAP_CUSTOMERS, mapCustomerDatas);
		}
		return mapCustomerDatas;
	}

	protected void setAttrListQuest(HttpServletRequest request) throws ServiceException {
		List<Questionnaire> questionnaires = questService.getAllQuest();
		request.setAttribute(ATTR_QUESTIONNAIRES, questionnaires);
	}

	protected void setAttrListUsers(HttpServletRequest request) throws ServiceException {
		List<User> users = userService.getAllUsers();
		request.setAttribute(ATTR_USERS, users);
	}

	protected void setAttrListVisa(HttpServletRequest request) throws ServiceException {
		List<SchengenVisa> visas = visaService.getAllVisas();
		request.setAttribute(ATTR_VISAS, visas);
	}

	protected Map<String, String> getUserReqParams(HttpServletRequest request) {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put(PARAM_USER_ID, request.getParameter(PARAM_USER_ID));
		requestParams.put(PARAM_USER_NAME, request.getParameter(PARAM_USER_NAME));
		requestParams.put(PARAM_USER_SURNAME, request.getParameter(PARAM_USER_SURNAME));
		requestParams.put(PARAM_USER_SECOND_NAME, request.getParameter(PARAM_USER_SECOND_NAME));
		requestParams.put(PARAM_USER_EMAIL, request.getParameter(PARAM_USER_EMAIL));
		return requestParams;
	}

	protected Map<String, String> getPassportReqParams(HttpServletRequest request) {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put(PARAM_PASS_ID, request.getParameter(PARAM_PASS_ID));
		requestParams.put(PARAM_PASS_NUM, request.getParameter(PARAM_PASS_NUM));
		requestParams.put(PARAM_PASS_ISSUED_BY, request.getParameter(PARAM_PASS_ISSUED_BY));
		requestParams.put(PARAM_PASS_DATE_OF_ISSUE, request.getParameter(PARAM_PASS_DATE_OF_ISSUE));
		requestParams.put(PARAM_PASS_DATE_OF_EXPIRY, request.getParameter(PARAM_PASS_DATE_OF_EXPIRY));
		return requestParams;
	}

	protected Map<String, String> getVisaReqParams(HttpServletRequest request) {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put(PARAM_VISA_ID, request.getParameter(PARAM_VISA_ID));
		requestParams.put(PARAM_VISA_CATEGORY, request.getParameter(PARAM_VISA_CATEGORY));
		requestParams.put(PARAM_NUM_OF_ENTRIES, request.getParameter(PARAM_NUM_OF_ENTRIES));
		requestParams.put(PARAM_VISA_TYPE, request.getParameter(PARAM_VISA_TYPE));
		requestParams.put(PARAM_VISA_FIRS_DATE, request.getParameter(PARAM_VISA_FIRS_DATE));
		requestParams.put(PARAM_VISA_LAST_DATE, request.getParameter(PARAM_VISA_LAST_DATE));
		requestParams.put(PARAM_SCHENGEN_COUNTRY, request.getParameter(PARAM_SCHENGEN_COUNTRY));
		requestParams.put(PARAM_VISA_STATUS, request.getParameter(PARAM_VISA_STATUS));
		requestParams.put(PARAM_СUSTOMER_ID, request.getParameter(PARAM_СUSTOMER_ID));
		return requestParams;

	}

	protected Map<String, String> getCustomerDataReqParams(HttpServletRequest request) {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put(PARAM_СUSTOMER_ID, request.getParameter(PARAM_СUSTOMER_ID));
		requestParams.put(PARAM_СUSTOMER_NAME, request.getParameter(PARAM_СUSTOMER_NAME));
		requestParams.put(PARAM_СUSTOMER_SURNAME, request.getParameter(PARAM_СUSTOMER_SURNAME));
		requestParams.put(PARAM_СUSTOMER_SECOND_NAME, request.getParameter(PARAM_СUSTOMER_SECOND_NAME));
		requestParams.put(PARAM_СUSTOMER_ADDRESS, request.getParameter(PARAM_СUSTOMER_ADDRESS));
		requestParams.put(PARAM_СUSTOMER_GENDER, request.getParameter(PARAM_СUSTOMER_GENDER));
		return requestParams;
	}

	protected Map<String, String> getQuestionnarireReqParams(HttpServletRequest request) {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put(PARAM_QUEST_ID, request.getParameter(PARAM_QUEST_ID));
		requestParams.put(PARAM_PASS_ID, request.getParameter(PARAM_PASS_ID));
		requestParams.put(PARAM_VISA_ID, request.getParameter(PARAM_VISA_ID));
		requestParams.put(PARAM_QUEST_STATUS, request.getParameter(PARAM_QUEST_STATUS));
		requestParams.put(PARAM_СUSTOMER_ID, request.getParameter(PARAM_СUSTOMER_ID));
		return requestParams;
	}

	protected SchengenVisa buildVisa(Map<String, String> visaParams) {
		SchengenVisa visa = new SchengenVisa();
		visa.setId(formatInt(visaParams.get(PARAM_VISA_ID)));
		visa.setVisaType(VisaType.valueOf(visaParams.get(PARAM_VISA_TYPE)));
		visa.setVisaCategory(VisaCategory.valueOf(visaParams.get(PARAM_VISA_CATEGORY)));
		visa.setNumberOfEntries(NumberOfEntries.valueOf(visaParams.get(PARAM_NUM_OF_ENTRIES)));
		visa.setSchengenContries(SchengenCountries.valueOf(visaParams.get(PARAM_SCHENGEN_COUNTRY)));
		visa.setFirstDate(formatLocalDate(visaParams.get(PARAM_VISA_FIRS_DATE)));
		visa.setLastDate(formatLocalDate(visaParams.get(PARAM_VISA_LAST_DATE)));
		visa.setVisaStatus(VisaStatus.UNDER_CONSIDERATION);
		return visa;
	}

	protected User buildUser(Map<String, String> userParams) {
		User user = new User();
		user.setId(formatInt(userParams.get(PARAM_USER_ID)));
		user.setName(userParams.get(PARAM_USER_NAME));
		user.setSurname(userParams.get(PARAM_USER_SURNAME));
		user.setSecondName(userParams.get(PARAM_USER_SECOND_NAME));
		user.setEmail(userParams.get(PARAM_USER_EMAIL));
		return user;

	}

	protected void setAttrGenderUserList(HttpServletRequest request) {
		List<String> customerGender = new ArrayList<>();
		for (Gender gender : Gender.values()) {
			customerGender.add(gender.toString());
		}
		request.setAttribute(ATTR_GENDER, customerGender);

	}

	protected void setQuestStatusList(HttpServletRequest request) {
		List<String> questStatus = new ArrayList<>();
		for (QuestionnaireStatus status : QuestionnaireStatus.values()) {
			questStatus.add(status.toString());
		}
		request.setAttribute(ATTR_QUEST_STATUS, questStatus);
	}

	protected void setAttrVisaCategories(HttpServletRequest request) {
		List<String> visaCategories = new ArrayList<>();
		for (VisaCategory category : VisaCategory.values()) {
			visaCategories.add(category.toString());
		}
		request.setAttribute(ATTR_CATEGORIES, visaCategories);
	}

	protected void setAttrSchengenCountries(HttpServletRequest request) {
		List<String> schengenCountries = new ArrayList<>();
		for (SchengenCountries countries : SchengenCountries.values()) {
			schengenCountries.add(countries.toString());
		}
		request.setAttribute(ATTR_COUNTRIES, schengenCountries);
	}

	protected void setVisaType(HttpServletRequest request) {
		List<String> visaTypes = new ArrayList<>();
		for (VisaType type : VisaType.values()) {
			visaTypes.add(type.toString());
		}
		request.setAttribute(ATTR_TYPES, visaTypes);
	}

	protected void setVisaStatus(HttpServletRequest request) {
		List<String> visaStatus = new ArrayList<>();
		for (VisaStatus status : VisaStatus.values()) {
			visaStatus.add(status.toString());
		}
		request.setAttribute(ATTR_VISA_STATUS, visaStatus);
	}

	protected void setNumOfEntries(HttpServletRequest request) {
		List<String> numOfEntries = new ArrayList<>();
		for (NumberOfEntries entries : NumberOfEntries.values()) {
			numOfEntries.add(entries.toString());
		}
		request.setAttribute(ATTR_ENTRIES, numOfEntries);
	}

	protected void setQuestStatus(HttpServletRequest request) {
		List<String> questStatus = new ArrayList<>();
		for (QuestionnaireStatus status : QuestionnaireStatus.values()) {
			questStatus.add(status.toString());
		}
		request.setAttribute(ATTR_QUEST_STATUS_LIST, questStatus);
	}

	protected boolean validateUserInputData(Map<String, String> requestParams, HttpServletRequest request) {
		boolean result = true;
		if (!validateName(requestParams.get(PARAM_USER_NAME))) {
			request.setAttribute(INVALID_NAME, Resource.getMessage(INVALID_NAME, request));
			result = false;
		} else {
			request.setAttribute(PARAM_USER_NAME, request.getParameter(PARAM_USER_NAME));
		}
		if (!validateSurname(requestParams.get(PARAM_USER_SURNAME))) {
			request.setAttribute(INVALID_SURNAME, Resource.getMessage(INVALID_SURNAME, request));
			result = false;
		} else {
			request.setAttribute(PARAM_USER_SURNAME, request.getParameter(PARAM_USER_SURNAME));
		}
		if (!validateEmail(requestParams.get(PARAM_USER_EMAIL))) {
			request.setAttribute(INVALID_EMAIL, Resource.getMessage(INVALID_EMAIL, request));
			result = false;
		} else {

			request.setAttribute(PARAM_USER_EMAIL, request.getParameter(PARAM_USER_EMAIL));
		}
		return result;
	}

	protected boolean validateCustomerInputData(Map<String, String> requestParams, HttpServletRequest request) {
		boolean result = true;
		if (!validateName(requestParams.get(PARAM_USER_NAME))) {
			request.setAttribute(INVALID_NAME, Resource.getMessage(INVALID_NAME, request));
			result = false;
		} else {
			request.setAttribute(PARAM_USER_NAME, requestParams.get(PARAM_USER_NAME));
		}
		if (!validateSurname(requestParams.get(PARAM_USER_SURNAME))) {
			request.setAttribute(INVALID_SURNAME, Resource.getMessage(INVALID_SURNAME, request));
			result = false;
		} else {
			request.setAttribute(PARAM_USER_SURNAME, requestParams.get(PARAM_USER_SURNAME));
		}
		if (!validateSecondName(requestParams.get(PARAM_USER_SECOND_NAME))) {
			request.setAttribute(INVALID_SECOND_NAME, Resource.getMessage(INVALID_SECOND_NAME, request));
			result = false;
		} else {
			request.setAttribute(PARAM_USER_SECOND_NAME, requestParams.get(PARAM_USER_SECOND_NAME));
		}

		return result;
	}

	protected boolean validatePassportInputData(Map<String, String> requestParams, HttpServletRequest request) {
		boolean result = true;
		if (!validatePassNum(requestParams.get(PARAM_PASS_NUM))) {
			request.setAttribute(INVALID_PASS_NUM, Resource.getMessage(INVALID_PASS_NUM, request));
			result = false;
		} else {
			request.setAttribute(PARAM_PASS_NUM, requestParams.get(PARAM_PASS_NUM));
		}
		if (validateFormatPassportDates(requestParams, request)) {
			if (!verifyValidatyOfPassport(formatLocalDate(requestParams.get(PARAM_PASS_DATE_OF_ISSUE)),
					formatLocalDate(requestParams.get(PARAM_PASS_DATE_OF_EXPIRY)), request))
				result = false;
		} else
			result = false;
		return result;
	}

	protected boolean validateFormatPassportDates(Map<String, String> requestParams, HttpServletRequest request) {
		boolean result = true;
		if (!validateDate(requestParams.get(PARAM_PASS_DATE_OF_ISSUE))) {
			request.setAttribute(INVALID_FORMAT_DATE_OF_ISSUE,
					Resource.getMessage(INVALID_FORMAT_DATE_OF_ISSUE, request));
			result = false;
		} else {
			request.setAttribute(PARAM_PASS_DATE_OF_ISSUE, requestParams.get(PARAM_PASS_DATE_OF_ISSUE));
		}
		if (!validateDate(requestParams.get(PARAM_PASS_DATE_OF_EXPIRY))) {
			request.setAttribute(INVALID_FORMAT_DATE_OF_EXPIRY,
					Resource.getMessage(INVALID_FORMAT_DATE_OF_EXPIRY, request));
			result = false;
		} else {
			request.setAttribute(PARAM_PASS_DATE_OF_EXPIRY, requestParams.get(PARAM_PASS_DATE_OF_EXPIRY));
		}
		return result;
	}

	protected boolean validateVisaInputData(Map<String, String> requestParams, HttpServletRequest request) {
		boolean result = true;
		if (validateVisaFormatDates(requestParams, request)) {
			if (!validateDatesOfVisit(requestParams, request)) {
				result = false;
			}
		} else
			result = false;
		return result;
	}

	protected boolean validateDatesOfVisit(Map<String, String> requestParams, HttpServletRequest request) {
		boolean result = true;
		if (checkTheDatesOThePass(requestParams, request)) {
			if (!verifyDateOfExpiry(formatLocalDate(requestParams.get(PARAM_VISA_FIRS_DATE)),
					formatLocalDate(requestParams.get(PARAM_VISA_LAST_DATE)), request)) {
				request.setAttribute(INCORRECT_DATE_OF_EXPIRY, Resource.getMessage(INCORRECT_DATE_OF_EXPIRY, request));
				result = false;
			}
		} else
			result = false;
		return result;
	}

	protected boolean checkTheDatesOThePass(Map<String, String> requestParams, HttpServletRequest request) {
		boolean result = true;
		if (!validateDatesOfVisit(formatLocalDate(requestParams.get(PARAM_VISA_FIRS_DATE)))) {
			request.setAttribute(INVALID_FIRST_DATE, Resource.getMessage(INVALID_FIRST_DATE, request));
			result = false;
		}
		if (!validateDatesOfVisit(formatLocalDate(requestParams.get(PARAM_VISA_LAST_DATE)))) {
			request.setAttribute(INVALID_LAST_DATE, Resource.getMessage(INVALID_LAST_DATE, request));
			result = false;
		}
		return result;
	}

	protected boolean validateVisaFormatDates(Map<String, String> requestParams, HttpServletRequest request) {
		boolean result = true;
		if (!validateDate(requestParams.get(PARAM_VISA_FIRS_DATE))) {
			request.setAttribute(INVALID_FORMAT_FIRST_DATE, Resource.getMessage(INVALID_FORMAT_FIRST_DATE, request));
			result = false;
		} else {
			request.setAttribute(PARAM_VISA_FIRS_DATE, requestParams.get(PARAM_VISA_FIRS_DATE));
		}
		if (!validateDate(requestParams.get(PARAM_VISA_LAST_DATE))) {
			request.setAttribute(INVALID_FORMAT_LAST_DATE, Resource.getMessage(INVALID_FORMAT_LAST_DATE, request));
			result = false;
		} else {
			request.setAttribute(PARAM_VISA_LAST_DATE, requestParams.get(PARAM_VISA_LAST_DATE));
		}
		return result;
	}

	protected boolean validateQuestionnaireInputData(Map<String, String> requestParams,
			Map<String, String> customerDataParams, Map<String, String> passportParams, Map<String, String> visaParams,
			HttpServletRequest request) {
		boolean result = true;
		if (!validateCustomerInputData(customerDataParams, request)) {
			result = false;
		}
		if (!validatePassportInputData(passportParams, request)) {
			result = false;
		}
		if (!validateVisaInputData(visaParams, request)) {
			result = false;
		}
		return result;
	}

	protected boolean validateInputPassNum(String passNum, HttpServletRequest request) {
		boolean result = true;
		passNum = request.getParameter(PARAM_PASS_NUM);
		if (!validatePassNum(passNum)) {
			request.setAttribute(INVALID_PASS_NUM, Resource.getMessage(INVALID_PASS_NUM, request));
			result = false;
		} else {
			request.setAttribute(PARAM_PASS_NUM, passNum);
		}
		return result;
	}

	protected boolean verifyValidatyOfPassport(LocalDate dateOfIssue, LocalDate dateOfExpiry,
			HttpServletRequest request) {
		boolean result = true;
		if (verifyPassportPeriod(dateOfIssue, dateOfExpiry, request)) {
			if (!verifyDatesOfPassport(dateOfIssue, dateOfExpiry, request)) {
				result = false;
			}
		} else
			result = false;
		return result;
	}

	protected boolean verifyDatesOfPassport(LocalDate dateOfIssue, LocalDate dateOfExpiry, HttpServletRequest request) {
		boolean result = true;
		LocalDate now = LocalDate.now();
		if (now.isBefore(dateOfIssue)) {
			result = false;
			request.setAttribute(INVALID_DATE_OF_ISSUE, Resource.getMessage(INVALID_DATE_OF_ISSUE, request));
		}
		if (now.isAfter(dateOfExpiry)) {
			result = false;
			request.setAttribute(PASSPORT_HAVE_EXPIRED, Resource.getMessage(PASSPORT_HAVE_EXPIRED, request));
		}
		return result;
	}

	protected boolean verifyPassportPeriod(LocalDate dateOfIssue, LocalDate dateOfExpiry, HttpServletRequest request) {
		boolean result = true;
		Period period = Period.between(dateOfIssue, dateOfExpiry);
		if (period.getYears() != 10) {
			result = false;
			request.setAttribute(INVALID_PASSPORT_PERIOD, Resource.getMessage(INVALID_PASSPORT_PERIOD, request));
		}
		return result;
	}

	protected boolean validateDatesOfVisit(LocalDate date) {
		LocalDate now = LocalDate.now();
		if (now.isBefore(date)) {
			return true;
		}
		return false;
	}

	protected boolean verifyDateOfExpiry(LocalDate dateOfIssue, LocalDate dateOfExpiry, HttpServletRequest request) {
		boolean result = true;
		if (dateOfExpiry.isBefore(dateOfIssue)) {
			result = false;
		}
		return result;
	}

}
