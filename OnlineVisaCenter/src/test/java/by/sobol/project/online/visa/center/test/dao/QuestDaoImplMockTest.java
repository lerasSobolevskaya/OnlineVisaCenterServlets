package by.sobol.project.online.visa.center.test.dao;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.sobol.visacenter.dao.QuestionnaireDao;
import by.sobol.visacenter.dao.impl.QuestionnaireDaoMySqlImpl;
import by.sobol.visacenter.model.Questionnaire;

public class QuestDaoImplMockTest {

	private QuestionnaireDao questDao;
	private Questionnaire quest;
	private List<Questionnaire> questionnaires;

	@Before
	public void initQuestDao() {
		questDao = mock(QuestionnaireDaoMySqlImpl.class);
		quest = mock(Questionnaire.class);

	}

	@Test
	public void readAllTest() throws Exception {
		when(questDao.readAll()).thenReturn(questionnaires);
		questDao.readAll();
		verify(questDao, times(1)).readAll();
	}

	@Test
	public void updateTest() throws Exception {
		when(questDao.update(quest)).thenReturn(0);
		questDao.update(quest);
		verify(questDao, times(1)).update(quest);
	}

	@Test
	public void deleteTest() throws Exception {
		questDao.delete(anyInt());
		verify(questDao, times(1)).delete(anyInt());
	}

	@Test
	public void getByIdTest() throws Exception {
		when(questDao.getById(anyInt())).thenReturn(quest);
		questDao.getById(anyInt());
		verify(questDao).getById(anyInt());
	}
}
