package by.sobol.visacenter.web.util;

public class WebControllerConstantPool {

	private WebControllerConstantPool() {
	}

	public static final String REQUEST_PARAM_COMMAND = "command";

	public static final String INDEX_JSP = "/index.jsp";

	public static final String FORM_CHANGE_ACCOUNT = "/jsp/all/form-change-account.jsp";
	public static final String FORM_CHANGE_PASS = "/jsp/all/form-change-password.jsp";
	public static final String START_PAGE = "/jsp/all/start-page.jsp";
	public static final String SIGN_IN_JSP = "/jsp/all/sign-in.jsp";
	public static final String ERROR_JSP = "/jsp/all/error.jsp";

	public static final String ALL_USERS_JSP = "/jsp/admin/all-users.jsp";
	public static final String ALL_QUEST_JSP = "/jsp/admin/all-quest.jsp";
	public static final String ALL_VISAS_JSP = "/jsp/admin/all-visas.jsp";
	public static final String LIST_QUEST_WITH_STATUS = "/jsp/admin/quest-with-status.jsp";
	public static final String QUEST_DETAILS_BY_ID_JSP = "/jsp/admin/quest-details-by-id.jsp";
	public static final String ADMIN_ACCOUNT_JSP = "/jsp/admin/admin-account.jsp";
	public static final String VISA_DETAILS_BY_ID_JSP = "/jsp/admin/visa-details-by-id.jsp";

	public static final String ADD_QUEST_JSP = "/jsp/user/add-quest.jsp";
	public static final String FORM_ADD_QUEST_JSP = "/jsp/user/form-add-quest.jsp";
	public static final String VISA_DETAILS_JSP = "/jsp/user/visa-details.jsp";
	public static final String FORM_SEARCH_QUEST_JSP = "/jsp/user/form-search-quest.jsp";
	public static final String FORM_SEARCH_VISA_JSP = "/jsp/user/form-search-visa.jsp";
	public static final String USER_ACCOUNT_JSP = "/jsp/user/user-account.jsp";
	public static final String QUEST_DETAILS_BY_PASS_JSP = "/jsp/user/quest-details-by-pass.jsp";
	public static final String FORM_UPDATE_VISA = "/jsp/user/form-update-visa.jsp";
	public static final String FORM_SEARCH_VISA = "/jsp/user/search-visa.jsp";

	public static final String REDIRECT_ADMIN = "/MainServlet?command=redirect_admin";
	public static final String REDIRECT_USER = "/MainServlet?command=redirect_user";
	public static final String REDIRECT_GUEST = "/MainServlet?command=redirect_guest";

	public static final String PARAM_QUEST_ID = "questionnaire_id";
	public static final String PARAM_QUEST_STATUS = "questionnaire_status";

	public static final String PARAM_USER_ID = "user_id";
	public static final String PARAM_USER_NAME = "name";
	public static final String PARAM_USER_SURNAME = "surname";
	public static final String PARAM_USER_SECOND_NAME = "second_name";
	public static final String PARAM_USER_EMAIL = "email";
	public static final String PARAM_LOGIN = "login";
	public static final String PARAM_PASSWORD = "password";

	public static final String PARAM_СUSTOMER_ID = "customer_id";
	public static final String PARAM_СUSTOMER_NAME = "name";
	public static final String PARAM_СUSTOMER_SURNAME = "surname";
	public static final String PARAM_СUSTOMER_SECOND_NAME = "second_name";
	public static final String PARAM_СUSTOMER_ADDRESS = "address";
	public static final String PARAM_СUSTOMER_GENDER = "gender";

	public static final String PARAM_PASS_ID = "passport_id";
	public static final String PARAM_PASS_NUM = "passport_number";
	public static final String PARAM_PASS_ISSUED_BY = "issued_by";
	public static final String PARAM_PASS_DATE_OF_ISSUE = "date_of_issue";
	public static final String PARAM_PASS_DATE_OF_EXPIRY = "date_of_expiry";

	public static final String PARAM_VISA_ID = "visa_id";
	public static final String PARAM_VISA_CATEGORY = "visa_category";
	public static final String PARAM_VISA_TYPE = "visa_type";
	public static final String PARAM_NUM_OF_ENTRIES = "number_of_entries";
	public static final String PARAM_VISA_FIRS_DATE = "first_date";
	public static final String PARAM_VISA_LAST_DATE = "last_date";
	public static final String PARAM_SCHENGEN_COUNTRY = "schengen_countries";
	public static final String PARAM_VISA_STATUS = "visa_status";
	
	public static final String PARAM_CUSTOMER_NAME = "name";
	public static final String PARAM_CUSTOMER_SURNAME = "surname";
	public static final String PARAM_CUSTOMER_SECOND_NAME = "second_name";
	public static final String PARAM_CUSTOMER_ADDRESS = "address";
	public static final String PARAM_CUSTOMER_GENDER = "gender";

	public static final String PARAM_OLD_PAS = "old_password";
	public static final String PARAM_NEW_PAS = "new_password";
	public static final String PARAM_CONFIRM_PAS = "confirm_password";

	public static final String ATTR_VISAS = "visas";
	public static final String ATTR_USERS = "users";
	public static final String ATTR_STATUS = "status";
	public static final String ATTR_USER = "user";
	public static final String ATTR_VISA = "visa";
	public static final String ATTR_QUEST = "questionnaire";
	public static final String ATTR_QUESTIONNAIRES = "questionnaires";
	public static final String ATTR_GENDER = "customer_gender";
	public static final String ATTR_CATEGORIES = "visa_categories";
	public static final String ATTR_TYPES = "visa_types";
	public static final String ATTR_COUNTRIES = "schengen_countries";
	public static final String ATTR_VISA_STATUS = "visa_status_list";
	public static final String ATTR_QUEST_STATUS = "quest_status";
	public static final String ATTR_ENTRIES = "entries";
	public static final String ATTR_QUEST_STATUS_LIST = "quest_status_list";
	public static final String ATTR_VISA_STATUS_LIST = "visa_status_list";
	public static final String ATTR_MAP_VISAS = "map_visas";
	public static final String ATTR_MAP_CUSTOMERS = "map_customer_datas";

	public static final String ATTR_ROLE_TYPE = "role_type";
	public static final String ATTR_PAGE_TYPE = "session_page_type";
	public static final String ATTR_ADMIN_ACCOUNT = "admin_account_page";
	public static final String ATTR_USER_ACCOUNT = "user_account_page";
	public static final String PAGE_CHANGE_PASS = "change_pass_page";

	public static final String INVALID_NAME = "invalid_name";
	public static final String INVALID_SURNAME = "invalid_surname";
	public static final String INVALID_SECOND_NAME = "invalid_second_name";
	public static final String INVALID_PASS_NUM = "invalid_passport_number";
	public static final String INVALID_GENDER = "invalid_gender";
	public static final String INVALID_FORMAT_DATE_OF_ISSUE = "invalid_format_date_of_issue";
	public static final String INVALID_FORMAT_DATE_OF_EXPIRY = "invalid_format_date_of_expiry";
	public static final String INVALID_FORMAT_FIRST_DATE = "invalid_format_first_date";
	public static final String INVALID_FORMAT_LAST_DATE = "invalid_format_last_date";
	public static final String INVALID_FIRST_DATE = "invalid_first_date";
	public static final String INVALID_LAST_DATE = "invalid_last_date";
	public static final String INVALID_PASSPORT_PERIOD = "invalid_passport_period";
	public static final String INVALID_EMAIL = "invalid_email";
	public static final String INVALID_LOGIN = "invalid_login";
	public static final String INVALID_PASSWORD = "invalid_password";
	public static final String INVALID_LOGIN_PASS = "invalid_login_or_pass";
	public static final String INVALID_DATE_OF_ISSUE = "invalid_date_of_issue";
	public static final String INCORRECT_DATE_OF_EXPIRY = "incorrect_date_of_expiry";
	
	public static final String PASSPORT_HAVE_EXPIRED = "passport_have_expired";

	public static final String QUEST_NOT_FOUND = "quest_not_found";
	public static final String VISA_NOT_FOUND = "visa_not_found";
	public static final String QUEST_HAVE_FILLED = "quest_have_filled";

	public static final String ATTR_INFO_MESSAGE = "info_message";
	public static final String SESSION_MESSAGE = "session_message";
	public static final String SUCCESS_UPDATE_VISA = "success_update_visa";
	public static final String ATTR_NEW_USER = "new_user";
	public static final String ATTR_DUP_PASS_NUM = "dup_pass_num";
	public static final String ATTR_DUP_MESSAGE = "dup_message";
	public static final String ACCOUNT_CHANGED_SUCCESS = "account_changed_success";
	public static final String ATTR_SUCCESS_COMLETED = "quest_success_completed";
	public static final String WRONG_OLD_PASS = "wrong_old_pass";
	public static final String SUCCESS_REGISTRATION = "success_registration";
	public static final String WRONG_CONFIRMATION = "wrong_confirmation";
	public static final String PASS_CHANGED = "changed_pass";
	public static final String SUCCESS_USER_DELETE = "success_user_delete";
}
