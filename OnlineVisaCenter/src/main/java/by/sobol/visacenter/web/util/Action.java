package by.sobol.visacenter.web.util;

public enum Action {
	
	FORM_UPDATE_QUEST(RoleType.ADMIN),
	VIEW_ALL_QUEST(RoleType.ADMIN),
	VIEW_ALL_USERS(RoleType.ADMIN),
	VIEW_ALL_VISAS(RoleType.ADMIN),
	DELETE_USER(RoleType.ADMIN),
	DELETE_CUSTOMER(RoleType.ADMIN),
	UPDATE_QUEST_STATUS(RoleType.ADMIN),
	UPDATE_VISA_STATUS(RoleType.ADMIN),
	REDIRECT_ADMIN(RoleType.ADMIN),
	DELETE_QUEST(RoleType.ADMIN),
	SHOW_QUEST_BY_STATUS(RoleType.ADMIN),
	SHOW_VISA_BY_STATUS(RoleType.ADMIN),
	VISA_DETAILS_BY_ID(RoleType.ADMIN),

	QUEST_DETAILS_BY_ID(RoleType.ALL),
	TO_MY_ACCOUNT(RoleType.ALL),
	SIGN_OUT(RoleType.ALL),
	SIGN_IN_PAGE(RoleType.ALL),
	AUTHORIZATION(RoleType.ALL),
	START_PAGE(RoleType.ALL),
	REGISTRATION(RoleType.ALL),
	REDIRECT_GUEST(RoleType.ALL),
	FORM_CHANGE_PASS(RoleType.ALL),
	SAVE_CHANGED_PASS(RoleType.ALL),
	FORM_ACCOUNT_CHANGE(RoleType.ALL),
	SAVE_ACCOUNT_CHANGES(RoleType.ALL),
	DELETE_ACCOUNT(RoleType.ALL),

	FORM_SEARCH_QUEST(RoleType.USER),
	FORM_SEARCH_VISA(RoleType.USER),
	GET_VISA_BY_PASS(RoleType.USER),
	GET_QUEST_BY_PASS(RoleType.USER),
	FORM_ADD_QUEST(RoleType.USER),
	SAVE_NEW_QUEST(RoleType.USER),
	REDIRECT_USER(RoleType.USER),
	FORM_UPDATE_VISA(RoleType.USER),
	UPDATE_VISA(RoleType.USER),
	FORM_SEARCH_VISA_FOR_UPDATE(RoleType.USER);
	
	private RoleType roleType;


	private Action(RoleType roleType) {
		this.roleType = roleType;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public static Action valueOfOrDefault(String value) {
		for (Action command : Action.class.getEnumConstants()) {
			if (command.name().equals(value)) {
				return command;
			}
		}
		return Action.START_PAGE;
	}
}
