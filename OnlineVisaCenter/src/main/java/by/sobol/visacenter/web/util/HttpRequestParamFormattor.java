package by.sobol.visacenter.web.util;

import java.time.LocalDate;

public class HttpRequestParamFormattor {

	private HttpRequestParamFormattor() {
	}

	public static int formatInt(String param) {
		return Integer.parseInt(param);
	}

	public static LocalDate formatLocalDate(String param) {
		return LocalDate.parse(param);
	}

}
