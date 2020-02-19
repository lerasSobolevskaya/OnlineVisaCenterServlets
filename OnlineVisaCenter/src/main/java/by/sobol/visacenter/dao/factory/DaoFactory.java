package by.sobol.visacenter.dao.factory;

import by.sobol.visacenter.dao.CustomerDataDao;
import by.sobol.visacenter.dao.PassportDao;
import by.sobol.visacenter.dao.QuestionnaireDao;
import by.sobol.visacenter.dao.UserDao;
import by.sobol.visacenter.dao.VisaDao;
import by.sobol.visacenter.dao.impl.CustomerDataMySqlDaoImpl;
import by.sobol.visacenter.dao.impl.PassportDaoMySqlImpl;
import by.sobol.visacenter.dao.impl.QuestionnaireDaoMySqlImpl;
import by.sobol.visacenter.dao.impl.UserDaoMySqlImpl;
import by.sobol.visacenter.dao.impl.VisaDaoMySqlImpl;

public class DaoFactory {

	private DaoFactory() {
	}

	public static QuestionnaireDao getQuestionnaireDao() {
		return new QuestionnaireDaoMySqlImpl();
	}

	public static UserDao getUserDao() {
		return new UserDaoMySqlImpl();
	}

	public static VisaDao getVisaDao() {
		return new VisaDaoMySqlImpl();
	}

	public static PassportDao getPassportDao() {
		return new PassportDaoMySqlImpl();
	}

	public static CustomerDataDao getCustomerDataDao() {
		return new CustomerDataMySqlDaoImpl();
	}
}
