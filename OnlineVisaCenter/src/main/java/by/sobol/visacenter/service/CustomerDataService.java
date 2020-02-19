package by.sobol.visacenter.service;

import java.util.List;

import by.sobol.visacenter.model.CustomerPersonalData;
import by.sobol.visacenter.service.exception.ServiceException;

public interface CustomerDataService {

	List<CustomerPersonalData> getAllCustomerDatas() throws ServiceException;

	CustomerPersonalData getCustomerDataById(int id) throws ServiceException;

	void deleteCustomerData(int id) throws ServiceException;

	void updateCustomerData(CustomerPersonalData customerData) throws ServiceException;

	int addCustomerData(CustomerPersonalData customerData) throws ServiceException;

}
