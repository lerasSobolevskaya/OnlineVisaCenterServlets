package by.sobol.visacenter.web.action.impl.user;

import static by.sobol.visacenter.web.util.HttpRequestParamFormattor.formatLocalDate;
import static by.sobol.visacenter.web.util.WebControllerConstantPool.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import by.sobol.visacenter.resoures.Resource;
import by.sobol.visacenter.service.QuestionnaireService;
import by.sobol.visacenter.service.factory.ServiceFactory;
import by.sobol.visacenter.web.action.ActionAssistant;
import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.exception.ActionException;

public class FillQuestImpl extends ActionAssistant implements BaseAction {

	private QuestionnaireService questService = ServiceFactory.getQuestionnaireService();

	private static final String SUCCESS = "success";

	@Override
	public String executeAction(HttpServletRequest request) throws ActionException {
		Map<String, String> questionnarireParams = getQuestionnarireReqParams(request);
		Map<String, String> passportParams = getPassportReqParams(request);
		Map<String, String> visaParams = getVisaReqParams(request);
		Map<String, String> customerDataParams = getCustomerDataReqParams(request);
		if (validateQuestionnaireInputData(questionnarireParams, customerDataParams, passportParams, visaParams,
				request)) {
			Questionnaire questionnaire = buildQuestionnaire(questionnarireParams,
					buildCustomerData(customerDataParams, buildPassport(passportParams, request), request),
					buildVisa(visaParams,
							buildCustomerData(customerDataParams, buildPassport(passportParams, request), request),
							request),
					request);

			String message = questService.addQuest(questionnaire);
			return resultPage(message, request);
		}
		setAttrGenderUserList(request);
		setAttrSchengenCountries(request);
		setAttrVisaCategories(request);
		setVisaType(request);
		setNumOfEntries(request);
		return FORM_ADD_QUEST_JSP;
	}

	private String resultPage(String message, HttpServletRequest request) {
		if (SUCCESS.equals(message)) {
			request.getSession().setAttribute(SESSION_MESSAGE, Resource.getMessage(ATTR_SUCCESS_COMLETED, request));
			return REDIRECT_USER;
		} else {
			request.setAttribute(ATTR_DUP_PASS_NUM, message);
			setAttrGenderUserList(request);
			setAttrSchengenCountries(request);
			setAttrVisaCategories(request);
			setVisaType(request);
			setNumOfEntries(request);
			return FORM_ADD_QUEST_JSP;
		}
	}

	private Questionnaire buildQuestionnaire(Map<String, String> questionnaireParams, CustomerPersonalData customerData,
			SchengenVisa visa, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(ATTR_USER);
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setCustomerData(customerData);
		questionnaire.setVisa(visa);
		questionnaire.setQuestionnaireStatus(QuestionnaireStatus.UNDER_CONSIDERATION);
		questionnaire.setUserId(user.getId());
		return questionnaire;
	}

	private CustomerPersonalData buildCustomerData(Map<String, String> customerDataParams, Passport passport,
			HttpServletRequest request) {
		CustomerPersonalData customerData = new CustomerPersonalData();
		customerData.setName(customerDataParams.get(PARAM_CUSTOMER_NAME));
		customerData.setSurname(customerDataParams.get(PARAM_CUSTOMER_SURNAME));
		customerData.setSecondName(customerDataParams.get(PARAM_CUSTOMER_SECOND_NAME));
		customerData.setAddress(customerDataParams.get(PARAM_CUSTOMER_ADDRESS));
		customerData.setGender(Gender.valueOf(customerDataParams.get(PARAM_CUSTOMER_GENDER)));
		customerData.setPassport(passport);
		return customerData;
	}

	private Passport buildPassport(Map<String, String> passportParams, HttpServletRequest request) {
		Passport passport = new Passport();
		passport.setPassportNum(passportParams.get(PARAM_PASS_NUM));
		passport.setIssuedBy(passportParams.get(PARAM_PASS_ISSUED_BY));
		passport.setDateOfIssue(formatLocalDate(passportParams.get(PARAM_PASS_DATE_OF_ISSUE)));
		passport.setDateOfExpiry(formatLocalDate(passportParams.get(PARAM_PASS_DATE_OF_EXPIRY)));
		return passport;
	}

	private SchengenVisa buildVisa(Map<String, String> visaParams, CustomerPersonalData customerData,
			HttpServletRequest request) {
		SchengenVisa visa = new SchengenVisa();
		visa.setFirstDate(formatLocalDate(visaParams.get(PARAM_VISA_FIRS_DATE)));
		visa.setLastDate(formatLocalDate(visaParams.get(PARAM_VISA_LAST_DATE)));
		visa.setVisaCategory(VisaCategory.valueOf(visaParams.get(PARAM_VISA_CATEGORY)));
		visa.setVisaType(VisaType.valueOf(request.getParameter(PARAM_VISA_TYPE)));
		visa.setSchengenContries(SchengenCountries.valueOf(visaParams.get(PARAM_SCHENGEN_COUNTRY)));
		visa.setNumberOfEntries(NumberOfEntries.valueOf(visaParams.get(PARAM_NUM_OF_ENTRIES)));
		visa.setCustomerData(customerData);
		visa.setVisaStatus(VisaStatus.UNDER_CONSIDERATION);
		return visa;
	}
}
