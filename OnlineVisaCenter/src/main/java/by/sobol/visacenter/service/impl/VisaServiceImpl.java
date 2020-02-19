package by.sobol.visacenter.service.impl;

import java.util.List;

import by.sobol.visacenter.dao.VisaDao;
import by.sobol.visacenter.dao.factory.DaoFactory;
import by.sobol.visacenter.model.SchengenVisa;
import by.sobol.visacenter.model.VisaStatus;
import by.sobol.visacenter.service.VisaService;
import by.sobol.visacenter.service.exception.ServiceException;

public class VisaServiceImpl implements VisaService {

	private VisaDao visaDao = DaoFactory.getVisaDao();

	@Override
	public void updateVisa(SchengenVisa visa) throws ServiceException{
		visaDao.update(visa);
	}

	@Override
	public SchengenVisa getVisaById(int id) throws ServiceException{
		return visaDao.getById(id);
	}

	@Override
	public void updateVisaStatus(SchengenVisa visa)throws ServiceException {
		visaDao.updateVisaStatus(visa);

	}

	@Override
	public SchengenVisa getVisaByPassNum(String passNum) throws ServiceException{
		return visaDao.getVisaByPassport(passNum);
	}

	@Override
	public List<SchengenVisa> getAllVisas()throws ServiceException {
		return visaDao.readAll();
	}

	@Override
	public List<SchengenVisa> getVisaByStatus(VisaStatus status) throws ServiceException{
		return visaDao.getVisasByStatus(status);
	}

}
