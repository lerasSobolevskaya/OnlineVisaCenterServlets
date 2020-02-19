package by.sobol.visacenter.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestParamValidator {

	private RequestParamValidator() {
	}

	private static final String PASS_NUM_REGEX = "((AB|BM|HB|KH|MP|MC|KB|)(\\d{7}))";
	private static final String DATE_REGEX = "((19|20)\\d\\d)\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])";
	private static final String NAME_AND_SURNAME_REGEX = "(^[А-ЯЁ][А-Яа-яЁё]{0,20})([\\-]?)([А-ЯЁ]?[А-Яа-яЁё]{0,20})";
	private static final String LOGIN_REGEX = "[0-9a-zA-Z]{5,}";
	private static final String PASSWORD_REGEX = "(?=.*[a-zA-z])(?=.*[0-9]).{5,}";
	private static final String POSITIVE_NUM_REGEX = "([1-9])([0-9]*)";
	private static final String EMAIL_REGEX = "^((\\w|[-+])+(\\.[\\w-]+)*@[\\w-]+((\\.[\\d\\p{Alpha}]+)*(\\.\\p{Alpha}{2,})*)*)$";
	private static final String ADDRESS_REGEX = "[0-9а-яА-Я_.]{5,}";

	public static void validateParamNotNull(String param) {
		if (param == null) {
			throw new RequestParamValidationException();
		}
	}

	public static boolean validateAddress(String address) {
		validateParamNotNull(address);
		return matchToRegex(address, ADDRESS_REGEX);
	}

	public static boolean validateEmail(String email) {
		validateParamNotNull(email);
		return matchToRegex(email, EMAIL_REGEX);
	}

	public static boolean validatePassNum(String passNum) {
		validateParamNotNull(passNum);
		return matchToRegex(passNum, PASS_NUM_REGEX);
	}

	public static boolean validateLogin(String login) {
		return matchToRegex(login, LOGIN_REGEX);
	}

	public static boolean validatePassword(String password) {
		return matchToRegex(password, PASSWORD_REGEX);
	}

	public static boolean validateName(String name) {
		validateParamNotNull(name);
		return matchToRegex(name, NAME_AND_SURNAME_REGEX);
	}

	public static boolean validateSurname(String surname) {
		validateParamNotNull(surname);
		return matchToRegex(surname, NAME_AND_SURNAME_REGEX);
	}

	public static boolean validateSecondName(String secondName) {
		validateParamNotNull(secondName);
		return matchToRegex(secondName, NAME_AND_SURNAME_REGEX);
	}

	public static void validateGender(String gender) {
		validateParamNotNull(gender);
	}

	public static boolean validateDate(String date) {
		validateParamNotNull(date);
		return matchToRegex(date, DATE_REGEX);
	}

	public static boolean validatePositiveInt(String value) {
		validateParamNotNull(value);
		if (matchToRegex(value, POSITIVE_NUM_REGEX)) {
			try {
				Integer.parseInt(value);
			} catch (NumberFormatException ex) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	private static boolean matchToRegex(String input, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

}
