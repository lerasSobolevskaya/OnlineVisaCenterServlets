package by.sobol.visacenter.dao;

import java.util.List;

import by.sobol.visacenter.dao.exception.DaoException;
import by.sobol.visacenter.model.Questionnaire;
import by.sobol.visacenter.model.QuestionnaireStatus;

public interface QuestionnaireDao extends BaseDao<Questionnaire> {

	Questionnaire getQuestByPassNum(String passNum) throws DaoException;

	void updateQuestStatus(Questionnaire quest) throws DaoException;

	List<Questionnaire> getQuestByStatus(QuestionnaireStatus status) throws DaoException;
	
	Questionnaire getQuestByUserId(int userId) throws DaoException;
}
