package by.sobol.project.online.visa.center.test.service;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.sobol.visacenter.model.Questionnaire;
import by.sobol.visacenter.service.QuestionnaireService;
import by.sobol.visacenter.service.impl.QuestionnaireServiceImpl;

public class QuestServiceImplMockTest {

	private QuestionnaireService questService;
	private Questionnaire quest;
	private List<Questionnaire> questionnaires;

	@Before
	public void initQuestService() {
		questService = mock(QuestionnaireServiceImpl.class);
		quest = mock(Questionnaire.class);
	}

	@Test
	public void getAllQuestTest() throws Exception {
		when(questService.getAllQuest()).thenReturn(questionnaires);
		questService.getAllQuest();
		verify(questService, times(1)).getAllQuest();
	}

	@Test
	public void updateQuesteTest() throws Exception {
		questService.updateQuest(quest);
		verify(questService, times(1)).updateQuest(quest);
	}

	@Test
	public void createQuestTest() throws Exception {
		when(questService.addQuest(quest)).thenReturn(anyString());
		questService.addQuest(quest);
		verify(questService, times(1)).addQuest(quest);
	}

	@Test
	public void deleteQuestTest() throws Exception {
		questService.deleteQuest(anyInt());
		verify(questService).deleteQuest(anyInt());
	}

	@Test
	public void getQuestById() throws Exception {
		when(questService.getQuestById(anyInt())).thenReturn(quest);
		questService.getQuestById(anyInt());
		verify(questService).getQuestById(anyInt());
	}

}
