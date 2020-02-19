package by.sobol.visacenter.resoures;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class Resource {

	private static final String RESOURCES_PATH = "resources";

	public static String getMessage(String key, HttpServletRequest request) {
		ResourceBundle bundle = ResourceBundle.getBundle(RESOURCES_PATH);
		return bundle.getString(key);
	}
}
