package by.sobol.visacenter.service;

import java.util.List;

import by.sobol.visacenter.model.Questionnaire;
import by.sobol.visacenter.model.QuestionnaireStatus;
import by.sobol.visacenter.service.exception.ServiceException;

public interface QuestionnaireService {

	List<Questionnaire> getAllQuest() throws ServiceException;

	Questionnaire getQuestById(int id) throws ServiceException;

	void deleteQuest(int id) throws ServiceException;

	void updateQuest(Questionnaire quest) throws ServiceException;

	String addQuest(Questionnaire quest) throws ServiceException;

	Questionnaire getQuestByPassNum(String passNum) throws ServiceException;

	void updateQuestStatus(Questionnaire quest) throws ServiceException;

	List<Questionnaire> getQuestByStatus(QuestionnaireStatus status) throws ServiceException;

	boolean getQuestByUserId(int userId) throws ServiceException;

}
