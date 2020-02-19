package by.sobol.visacenter.service.factory;

import by.sobol.visacenter.service.CustomerDataService;
import by.sobol.visacenter.service.PassportService;
import by.sobol.visacenter.service.QuestionnaireService;
import by.sobol.visacenter.service.UserService;
import by.sobol.visacenter.service.VisaService;
import by.sobol.visacenter.service.impl.CustomerDataServiceImpl;
import by.sobol.visacenter.service.impl.PassportServiceImpl;
import by.sobol.visacenter.service.impl.QuestionnaireServiceImpl;
import by.sobol.visacenter.service.impl.UserServiceImpl;
import by.sobol.visacenter.service.impl.VisaServiceImpl;

public class ServiceFactory {

	private ServiceFactory() {
	}

	public static QuestionnaireService getQuestionnaireService() {
		return new QuestionnaireServiceImpl();
	}

	public static UserService getUserService() {
		return new UserServiceImpl();
	}

	public static VisaService getVisaService() {
		return new VisaServiceImpl();
	}

	public static PassportService getPassportService() {
		return new PassportServiceImpl();
	}
	
	public static CustomerDataService getCustomerData() {
		return new CustomerDataServiceImpl();
	}
}
