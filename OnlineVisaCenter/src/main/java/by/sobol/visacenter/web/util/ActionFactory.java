package by.sobol.visacenter.web.util;

import static by.sobol.visacenter.web.util.WebControllerConstantPool.REQUEST_PARAM_COMMAND;

import javax.servlet.http.HttpServletRequest;

import by.sobol.visacenter.web.action.BaseAction;
import by.sobol.visacenter.web.action.impl.admin.DeleteQuestImpl;
import by.sobol.visacenter.web.action.impl.admin.GetQuestDetailsByIdImpl;
import by.sobol.visacenter.web.action.impl.admin.GetVisaDetailsById;
import by.sobol.visacenter.web.action.impl.admin.RedirectAdminImpl;
import by.sobol.visacenter.web.action.impl.admin.ShowQuestByStatusImpl;
import by.sobol.visacenter.web.action.impl.admin.ShowVisaByStatusImpl;
import by.sobol.visacenter.web.action.impl.admin.UpdateQuestStatusImpl;
import by.sobol.visacenter.web.action.impl.admin.UpdateVisaStatusImpl;
import by.sobol.visacenter.web.action.impl.admin.ViewAllQuestImpl;
import by.sobol.visacenter.web.action.impl.admin.ViewAllUsersImpl;
import by.sobol.visacenter.web.action.impl.admin.ViewAllVisasImpl;
import by.sobol.visacenter.web.action.impl.all.AuthorizationImpl;
import by.sobol.visacenter.web.action.impl.all.DeleteAccountImpl;
import by.sobol.visacenter.web.action.impl.all.FormChangeAccountImpl;
import by.sobol.visacenter.web.action.impl.all.FormChangePassImpl;
import by.sobol.visacenter.web.action.impl.all.RedirectGuestImpl;
import by.sobol.visacenter.web.action.impl.all.RegistrationImpl;
import by.sobol.visacenter.web.action.impl.all.SignInPageImpl;
import by.sobol.visacenter.web.action.impl.all.SignOutImpl;
import by.sobol.visacenter.web.action.impl.all.StartPageImpl;
import by.sobol.visacenter.web.action.impl.all.ToChangedAccountImpl;
import by.sobol.visacenter.web.action.impl.all.ToMyAccountImpl;
import by.sobol.visacenter.web.action.impl.all.ToSaveChangedPasswordImpl;
import by.sobol.visacenter.web.action.impl.user.FillQuestImpl;
import by.sobol.visacenter.web.action.impl.user.FormSearchVisaForUpdateImpl;
import by.sobol.visacenter.web.action.impl.user.FormUpdateVisaImpl;
import by.sobol.visacenter.web.action.impl.user.GetQuestByPassImpl;
import by.sobol.visacenter.web.action.impl.user.GetVisaDetailsByPassNumImpl;
import by.sobol.visacenter.web.action.impl.user.PreparingFillQuestImpl;
import by.sobol.visacenter.web.action.impl.user.RedirectUserImpl;
import by.sobol.visacenter.web.action.impl.user.SearchQuestPageImpl;
import by.sobol.visacenter.web.action.impl.user.SearchVisaStatusPageImpl;
import by.sobol.visacenter.web.action.impl.user.ToSaveVisaChangesImpl;

public class ActionFactory {

	private ActionFactory() {
	}

	public static BaseAction chooseAction(HttpServletRequest request) {

		BaseAction action = null;

		String inputAction = request.getParameter(REQUEST_PARAM_COMMAND);
		Action actionName = Action.valueOfOrDefault(inputAction.toUpperCase());

		switch (actionName) {
		case VISA_DETAILS_BY_ID:
			action = new GetVisaDetailsById();
			break;
		case UPDATE_VISA_STATUS:
			action = new UpdateVisaStatusImpl();
			break;
		case SHOW_VISA_BY_STATUS:
			action = new ShowVisaByStatusImpl();
			break;
		case SHOW_QUEST_BY_STATUS:
			action = new ShowQuestByStatusImpl();
			break;
		case DELETE_ACCOUNT:
			action = new DeleteAccountImpl();
			break;
		case FORM_CHANGE_PASS:
			action = new FormChangePassImpl();
			break;
		case SAVE_CHANGED_PASS:
			action = new ToSaveChangedPasswordImpl();
			break;
		case FORM_ACCOUNT_CHANGE:
			action = new FormChangeAccountImpl();
			break;
		case SAVE_ACCOUNT_CHANGES:
			action = new ToChangedAccountImpl();
			break;
		case FORM_SEARCH_VISA_FOR_UPDATE:
			action = new FormSearchVisaForUpdateImpl();
			break;
		case FORM_UPDATE_VISA:
			action = new FormUpdateVisaImpl();
			break;
		case UPDATE_VISA:
			action = new ToSaveVisaChangesImpl();
			break;
		case VIEW_ALL_VISAS:
			action = new ViewAllVisasImpl();
			break;
		case VIEW_ALL_QUEST:
			action = new ViewAllQuestImpl();
			break;
		case FORM_ADD_QUEST:
			action = new PreparingFillQuestImpl();
			break;
		case SAVE_NEW_QUEST:
			action = new FillQuestImpl();
			break;
		case DELETE_QUEST:
			action = new DeleteQuestImpl();
			break;
		case GET_QUEST_BY_PASS:
			action = new GetQuestByPassImpl();
			break;
		case QUEST_DETAILS_BY_ID:
			action = new GetQuestDetailsByIdImpl();
			break;
		case UPDATE_QUEST_STATUS:
			action = new UpdateQuestStatusImpl();
			break;
		case GET_VISA_BY_PASS:
			action = new GetVisaDetailsByPassNumImpl();
			break;
		case FORM_SEARCH_QUEST:
			action = new SearchQuestPageImpl();
			break;
		case FORM_SEARCH_VISA:
			action = new SearchVisaStatusPageImpl();
			break;
		case TO_MY_ACCOUNT:
			action = new ToMyAccountImpl();
			break;
		case SIGN_IN_PAGE:
			action = new SignInPageImpl();
			break;
		case SIGN_OUT:
			action = new SignOutImpl();
			break;
		case AUTHORIZATION:
			action = new AuthorizationImpl();
			break;
		case START_PAGE:
			action = new StartPageImpl();
			break;
		case REDIRECT_ADMIN:
			action = new RedirectAdminImpl();
			break;
		case REDIRECT_USER:
			action = new RedirectUserImpl();
			break;
		case REDIRECT_GUEST:
			action = new RedirectGuestImpl();
			break;
		case VIEW_ALL_USERS:
			action = new ViewAllUsersImpl();
			break;
		case REGISTRATION:
			action = new RegistrationImpl();
			break;
		default:
			action = new StartPageImpl();
		}

		return action;
	}
}
