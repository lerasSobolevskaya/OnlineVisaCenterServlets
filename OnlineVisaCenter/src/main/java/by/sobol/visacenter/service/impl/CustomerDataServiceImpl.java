package by.sobol.visacenter.service.impl;

import java.util.List;

import by.sobol.visacenter.dao.CustomerDataDao;
import by.sobol.visacenter.dao.factory.DaoFactory;
import by.sobol.visacenter.model.CustomerPersonalData;
import by.sobol.visacenter.service.CustomerDataService;
import by.sobol.visacenter.service.exception.ServiceException;

public class CustomerDataServiceImpl implements CustomerDataService {

	private static CustomerDataDao customerDataDao = DaoFactory.getCustomerDataDao();

	@Override
	public List<CustomerPersonalData> getAllCustomerDatas() throws ServiceException{
		return customerDataDao.readAll();
	}

	@Override
	public CustomerPersonalData getCustomerDataById(int id) throws ServiceException{
		return customerDataDao.getById(id);
	}

	@Override
	public void deleteCustomerData(int id) throws ServiceException{
		customerDataDao.delete(id);
	}

	@Override
	public void updateCustomerData(CustomerPersonalData customerData) throws ServiceException{
		customerDataDao.update(customerData);
	}

	@Override
	public int addCustomerData(CustomerPersonalData customerData) {
		return addCustomerData(customerData);
	}

}
