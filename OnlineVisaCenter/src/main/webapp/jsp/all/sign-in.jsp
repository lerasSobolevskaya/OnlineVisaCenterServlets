<!DOCTYPE html>
<html class="aui ltr" dir="ltr" lang="ru-RU">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="resources" />
<head>
<title><fmt:message key="title" /></title>
<link rel="shortcut icon" href="resources/images/icons/Belarus_Flag.png"
	type="image/png">
<meta content="initial-scale=1.0, width=device-width" name="viewport" />
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<link class="lfr-css-file"
	href="https&#x3a;&#x2f;&#x2f;france-visas&#x2e;gouv&#x2e;fr&#x2f;fv-fo-portal-inf-theme&#x2f;css&#x2f;aui&#x2e;css&#x3f;browserId&#x3d;other&#x26;themeId&#x3d;fvfoportalthemeinf_WAR_fvfoportalinftheme&#x26;minifierType&#x3d;css&#x26;languageId&#x3d;ru_RU&#x26;b&#x3d;6210&#x26;t&#x3d;1558621669000"
	rel="stylesheet" type="text/css" />
<link class="lfr-css-file"
	href="https&#x3a;&#x2f;&#x2f;france-visas&#x2e;gouv&#x2e;fr&#x2f;fv-fo-portal-inf-theme&#x2f;css&#x2f;main&#x2e;css&#x3f;browserId&#x3d;other&#x26;themeId&#x3d;fvfoportalthemeinf_WAR_fvfoportalinftheme&#x26;minifierType&#x3d;css&#x26;languageId&#x3d;ru_RU&#x26;b&#x3d;6210&#x26;t&#x3d;1558621669000"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body
	class="&#034;default&#034; yui3-skin-sam controls-visible signed-out public-page organization-site dockbar-split">
	<div class="container" id="wrapper">
		<div class="row-fluid">
			<div id="monCompte" class="span12">
				<div
					class="portlet-boundary portlet-boundary_DockBarSignIn_WAR_fvfoportalinfportlet_ portlet-static portlet-static-end portlet-borderless "
					id="p_p_id_DockBarSignIn_WAR_fvfoportalinfportlet_">
					<span id="p_DockBarSignIn_WAR_fvfoportalinfportlet"></span>
					<div class="portlet-borderless-container">
						<div class="portlet-body">
							<a
								id="_DockBarSignIn_WAR_fvfoportalinfportlet_-dockBar-signIn-link"
								class="customMonCompte"
								href="/OnlineVisaCenter/MainServlet?command=to_my_profile">
								<fmt:message key="account" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row-fluid">
			<header id="banner" role="banner" class="span12">
				<div
					class="portlet-boundary portlet-boundary_82_ portlet-static portlet-static-end portlet-borderless portlet-language "
					id="p_p_id_82_">
					<span id="p_82"></span>
					<div class="portlet-borderless-container">
						<div class="portlet-body">
							<form
								action="https&#x3a;&#x2f;&#x2f;france-visas&#x2e;gouv&#x2e;fr&#x2f;en_US&#x2f;web&#x2f;france-visas&#x2f;welcome-page&#x3f;p_p_id&#x3d;82&#x26;p_p_lifecycle&#x3d;1&#x26;p_p_state&#x3d;normal&#x26;p_p_mode&#x3d;view&#x26;_82_struts_action&#x3d;&#x25;2Flanguage&#x25;2Fview&#x26;_82_redirect&#x3d;&#x25;2Fen_US&#x25;2Fweb&#x25;2Ffrance-visas"
								class="form " id="_82_fm" method="post" name="_82_fm">
								<input name="formDate" type="hidden" value="1562350241769" />
								<div class="control-group input-select-wrapper"></div>
							</form>
						</div>
					</div>
				</div>
				<img src="resources/images/schengen_countries.jpg" class="marianne" />
				<p class="customSlogan">
					<fmt:message key="custom_slogan" />
				</p>
			</header>
		</div>
		<div class="row-fluid">
			<div id="menuPrincipal" class="span12 navbar">
				<div class="navbar-inner">
					<div class="container">
						<a class="btn btn-navbar btn-menu-custom unopen"
							data-toggle="collapse" data-target=".nav-collapse"> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
						</a>
					</div>
				</div>
			</div>
			<div id="imgBannerCentral" class="imgBanner"></div>
		</div>

		<div id="content" class="row-fluid niveauCentral">
			<div class="columns-max" id="main-content" role="main">
				<div class="portlet-layout row-fluid">
					<div class="portlet-column portlet-column-only span12"
						id="column-1">
						<div
							class="portlet-boundary portlet-boundary_58_ portlet-static portlet-static-end portlet-borderless portlet-login "
							id="p_p_id_58_">
							<span id="p_58"></span>
							<div class="portlet-borderless-container">
								<div class="portlet-borderless-bar"></div>
								<div class="portlet-body">
									<!-- Create account -->
									<div class="row-fluid">
										<div class="span4 offset2 loginContainer formContainer">
											<c:if test="${not empty dup_message}">
												<div class="alert alert-error" style="width: 100%">
													<c:out value="${dup_message}" />
												</div>
											</c:if>
											<c:if test="${not empty info_message}">
												<div class="alert alert-success" style="width: 15%">
													<strong><c:out value="${info_message}" /></strong>
												</div>
											</c:if>
											<form action="MainServlet" class="form " id="_58_fm"
												method="post">
												<input type="hidden" name="command" value="registration">
												<fieldset>
													<legend>
														<fmt:message key="create_an_account" />
													</legend>
													<div class="control-group input-String-wrapper">
														<label class="control-label" for="_58_lastName"> <fmt:message
																key="surname" />
														</label> <input class="field lfr-input-text" name="surname"
															value="${new_user.getSurname()}"
															style="max-width: 150px;" type="text" />
														<c:if test="${not empty invalid_surname}">
															<small class="form-text text-danger"> <c:out
																	value="${invalid_surname}" />
															</small>
														</c:if>
													</div>
													<div class="control-group input-String-wrapper">
														<label class="control-label" for="_58_firstName">
															<fmt:message key="name" />
														</label> <input class="field lfr-input-text" name="name"
															value="${new_user.getName()}" style="max-width: 150px;"
															type="text" />
														<c:if test="${not empty invalid_name}">
															<small class="form-text text-danger"> <c:out
																	value="${invalid_name}" />
															</small>
														</c:if>
													</div>
													<div class="control-group input-String-wrapper">
														<label class="control-label" for="_58_firstName">
															<fmt:message key="second_name" />
														</label> <input class="field lfr-input-text" name="second_name"
															value="${new_user.getSecondName()}"
															style="max-width: 150px;" type="text" />
														<c:if test="${not empty invalid_second_name}">
															<small class="form-text text-danger"> <c:out
																	value="${invalid_second_name}" />
															</small>
														</c:if>
													</div>
													<div class="control-group input-String-wrapper">
														<label class="control-label" for="_58_emailAddress">
															<fmt:message key="email" />
														</label> <input class="field lfr-input-text" name="email"
															value="${new_user.getEmail()}" style="max-width: 150px;"
															type="text" />
														<c:if test="${not empty invalid_email}">
															<small class="form-text text-danger"> <c:out
																	value="${invalid_email}" />
															</small>
														</c:if>
													</div>
													<div class="control-group input-String-wrapper">
														<label class="control-label" for="_58_emailAddress">
															<fmt:message key="login" />
														</label> <input class="field lfr-input-text" name="login"
															value="${new_user.getLogin()}" style="max-width: 150px;"
															type="text" />
														<c:if test="${not empty invalid_login}">
															<small class="form-text text-danger"> <c:out
																	value="${invalid_login}" />
															</small>
														</c:if>

													</div>
													<div class="control-group input-String-wrapper">
														<label class="control-label" for="_58_emailAddress">
															<fmt:message key="password" />
														</label> <input class="field lfr-input-text" name="password"
															style="max-width: 150px;" type="password" />
														<c:if test="${not empty invalid_password}">
															<small class="form-text text-danger"> <c:out
																	value="${invalid_password}" />
															</small>
														</c:if>
													</div>

													<div class="button-holder ">
														<button class="btn btn-primary" type="submit">
															<fmt:message key="create_an_account" />
														</button>
													</div>
												</fieldset>
											</form>
										</div>
										<!-- Log in -->
										<c:choose>
											<c:when test="${sessionScope.role_type == 'ADMIN'}">
												<a
													href="/OnlineVisaCenter/MainServlet?command=to_my_profile"><fmt:message
														key="account" /></a>
												<a href="/OnlineVisaCenter/MainServlet?command=sign_out"><fmt:message
														key="sign_out" /></a>
											</c:when>
											<c:when test="${sessionScope.role_type == 'USER'}">
												<a
													href="/OnlineVisaCenter/MainServlet?command=to_my_profile">
													<fmt:message key="account" />
												</a>
												<a href="/OnlineVisaCenter/MainServlet?command=sign_out"><fmt:message
														key="sign_out" /> </a>
											</c:when>
											<c:otherwise>
												<form action="MainServlet" method="post">
													<fieldset class="input-container">
														<input type="hidden" name="command" value="authorization" />
														<div class="formContainer loginContainer span8">
															<fieldset>
																<legend>
																	<fmt:message key="to_my_account" />
																</legend>
																<div class="control-group input-text-wrapper">
																	<label> <fmt:message key="login" />
																	</label> <input class="field clearable" name="login"
																		placeholder="Логин" type="text" />
																</div>
																<div class="control-group input-text-wrapper">
																	<label> <fmt:message key="password" />
																	</label> <input class="field loginPassword" name="password"
																		placeholder="Пароль" type="password" />
																	<c:if test="${not empty invalid_login_or_pass}">
																		<small class="form-text text-danger"> <c:out
																				value="${invalid_login_or_pass}" />
																		</small>
																	</c:if>
																</div>
																<div class="button-holder ">
																	<button class="btn btn-primary" type="submit">
																		<fmt:message key="sign_in" />
																	</button>


																</div>
															</fieldset>
														</div>
													</fieldset>
												</form>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<form action="#" id="hrefFm" method="post" name="hrefFm">
			<span></span>
		</form>
	</div>
</body>
</html>
