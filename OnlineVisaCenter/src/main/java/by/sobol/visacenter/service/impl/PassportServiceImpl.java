package by.sobol.visacenter.service.impl;

import by.sobol.visacenter.dao.PassportDao;
import by.sobol.visacenter.dao.factory.DaoFactory;
import by.sobol.visacenter.model.Passport;
import by.sobol.visacenter.service.PassportService;
import by.sobol.visacenter.service.exception.ServiceException;

public class PassportServiceImpl implements PassportService {

	private PassportDao passportDao = DaoFactory.getPassportDao();

	@Override
	public void updatePassport(Passport passport) throws ServiceException{
		passportDao.update(passport);
	}

	@Override
	public Passport getPassportById(int id) throws ServiceException{
		return passportDao.getById(id);
	}

}
