package by.sobol.visacenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import by.sobol.visacenter.dao.exception.DaoException;

public interface BaseDao<T> {

	static final Logger LOG = Logger.getLogger(BaseDao.class);

	List<T> readAll() throws DaoException;

	T getById(int id) throws DaoException;

	int create(T t) throws DaoException;

	void delete(int id) throws DaoException;

	int update(T t) throws DaoException;

	default void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException ex) {
				LOG.error(ex);
			}
		}
	}
}
