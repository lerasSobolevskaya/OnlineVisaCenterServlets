package by.sobol.visacenter.service.impl;

import java.util.List;

import by.sobol.visacenter.dao.QuestionnaireDao;
import by.sobol.visacenter.dao.factory.DaoFactory;
import by.sobol.visacenter.model.Questionnaire;
import by.sobol.visacenter.model.QuestionnaireStatus;
import by.sobol.visacenter.service.QuestionnaireService;
import by.sobol.visacenter.service.exception.ServiceException;

public class QuestionnaireServiceImpl implements QuestionnaireService {

	QuestionnaireDao questDao = DaoFactory.getQuestionnaireDao();

	private static final String SUCCESS = "success";
	private static final String DUP_PASS_NUM = "Номер паспорта уже используется";
	private static final int ADDED_QUEST = 0;

	@Override
	public List<Questionnaire> getAllQuest() throws ServiceException{
		return questDao.readAll();
	}

	@Override
	public Questionnaire getQuestById(int id) throws ServiceException{
		return questDao.getById(id);
	}

	@Override
	public void deleteQuest(int id) throws ServiceException{
		questDao.delete(id);

	}

	@Override
	public void updateQuest(Questionnaire quest) throws ServiceException{
		questDao.update(quest);

	}
	@Override
	public String addQuest(Questionnaire quest) throws ServiceException{
		int result = questDao.create(quest);
		String message = SUCCESS;
		if (result != ADDED_QUEST) {
			message = DUP_PASS_NUM;
		}
		return message;
	}

	@Override
	public Questionnaire getQuestByPassNum(String passNum) throws ServiceException{
		return questDao.getQuestByPassNum(passNum);
	}

	@Override
	public void updateQuestStatus(Questionnaire quest) throws ServiceException{
		questDao.updateQuestStatus(quest);

	}

	@Override
	public List<Questionnaire> getQuestByStatus(QuestionnaireStatus status) throws ServiceException{
		return questDao.getQuestByStatus(status);
	}

	@Override
	public boolean getQuestByUserId(int userId) throws ServiceException {
		Questionnaire questionnaires = questDao.getQuestByUserId(userId);
		if (questionnaires != null) {
			return false;
		}
		return true;
	}

}
