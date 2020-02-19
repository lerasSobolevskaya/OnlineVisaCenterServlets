package by.sobol.visacenter.dao;

import java.util.List;

import by.sobol.visacenter.dao.exception.DaoException;
import by.sobol.visacenter.model.SchengenVisa;
import by.sobol.visacenter.model.VisaStatus;

public interface VisaDao extends BaseDao<SchengenVisa> {

	void updateVisaStatus(SchengenVisa visa) throws DaoException;
	
	SchengenVisa getVisaByPassport(String passNum) throws DaoException;

	List<SchengenVisa> getVisasByStatus(VisaStatus status) throws DaoException;
}
