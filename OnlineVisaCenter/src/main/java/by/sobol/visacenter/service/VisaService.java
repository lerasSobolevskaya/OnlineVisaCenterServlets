package by.sobol.visacenter.service;

import java.util.List;

import by.sobol.visacenter.model.SchengenVisa;
import by.sobol.visacenter.model.VisaStatus;
import by.sobol.visacenter.service.exception.ServiceException;

public interface VisaService {

	List<SchengenVisa> getAllVisas() throws ServiceException;

	void updateVisa(SchengenVisa visa) throws ServiceException;

	SchengenVisa getVisaById(int id) throws ServiceException;
 
	void updateVisaStatus(SchengenVisa visa) throws ServiceException;

	SchengenVisa getVisaByPassNum(String passNum) throws ServiceException;

	List<SchengenVisa> getVisaByStatus(VisaStatus status) throws ServiceException;
}
