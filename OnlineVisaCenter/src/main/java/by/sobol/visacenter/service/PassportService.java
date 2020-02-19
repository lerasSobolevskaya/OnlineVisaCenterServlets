package by.sobol.visacenter.service;

import by.sobol.visacenter.model.Passport;
import by.sobol.visacenter.service.exception.ServiceException;

public interface PassportService {

	void updatePassport(Passport passport) throws ServiceException;

	Passport getPassportById(int id) throws ServiceException;
}
