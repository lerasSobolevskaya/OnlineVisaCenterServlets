<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="resources" />
<html class="aui ltr" dir="ltr" lang="ru-RU">
<head>
<title><fmt:message key="account" /></title>
<link rel="shortcut icon" href="resources/images/icons/Belarus_Flag.png"
	type="image/png">
<meta content="initial-scale=1.0, width=device-width" name="viewport" />
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<meta content="Account, request, password, cerfa" lang="ru-RU"
	name="keywords" />
<link class="lfr-css-file"
	href="https&#x3a;&#x2f;&#x2f;france-visas&#x2e;gouv&#x2e;fr&#x2f;fv-fo-portal-inf-theme&#x2f;css&#x2f;aui&#x2e;css&#x3f;browserId&#x3d;other&#x26;themeId&#x3d;fvfoportalthemeinf_WAR_fvfoportalinftheme&#x26;minifierType&#x3d;css&#x26;languageId&#x3d;ru_RU&#x26;b&#x3d;6210&#x26;t&#x3d;1558621669000"
	rel="stylesheet" type="text/css" />
<link class="lfr-css-file"
	href="https&#x3a;&#x2f;&#x2f;france-visas&#x2e;gouv&#x2e;fr&#x2f;fv-fo-portal-inf-theme&#x2f;css&#x2f;main&#x2e;css&#x3f;browserId&#x3d;other&#x26;themeId&#x3d;fvfoportalthemeinf_WAR_fvfoportalinftheme&#x26;minifierType&#x3d;css&#x26;languageId&#x3d;ru_RU&#x26;b&#x3d;6210&#x26;t&#x3d;1558621669000"
	rel="stylesheet" type="text/css" />
<link
	href='${pageContext.request.contextPath}/resources/css/modal-window.css'
	rel="stylesheet" type="text/css" />
</head>
<body
	class="&#034;default&#034; yui3-skin-sam controls-visible signed-in private-page organization-site dockbar-split">
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
								href="/OnlineVisaCenter/MainServlet?command=sign_out"> <fmt:message
									key="sign_out" /></a> <a
								id="_DockBarSignIn_WAR_fvfoportalinfportlet_-dockBar-signIn-link"
								class="customMonCompte"
								href="/OnlineVisaCenter/MainServlet?command=to_my_account">
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
				<p class="customMainTitle"></p>
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
						<nav class="nav-collapse collapse menu-custom-off">
							<ul class="nav-menu nav">
								<li class="nav-item"></li>
								<li class="nav-item" id="layout_2"><a
									href="/OnlineVisaCenter/MainServlet?command=view_all_quest">
										<fmt:message key="list_quest" />
								</a>
								<li class="nav-item" id="layout_9"><a
									aria-labelledby="layout_9"
									href="/OnlineVisaCenter/MainServlet?command=view_all_users">
										<fmt:message key="list_users" />
								</a></li>
								<li class="nav-item" id="layout_10"><a
									aria-labelledby="layout_10"
									href="/OnlineVisaCenter/MainServlet?command=view_all_visas">
										<fmt:message key="list_visas" />
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<div id="imgBannerCentral" class="imgBanner"></div>
		</div>
		<div id="content" class="row-fluid niveauCentral">
			<div class="columns-1" id="main-content" role="main">
				<div class="portlet-layout row-fluid">
					<div class="portlet-column portlet-column-only span12"
						id="column-1">
						<div
							class="portlet-dropzone portlet-column-content portlet-column-content-only"
							id="layout-column_column-1">
							<div
								class="portlet-boundary portlet-boundary_accueilusager_WAR_fvfoportalaccueilusagerportlet_ portlet-static portlet-static-end portlet-borderless "
								id="p_p_id_accueilusager_WAR_fvfoportalaccueilusagerportlet_">
								<span id="p_accueilusager_WAR_fvfoportalaccueilusagerportlet"></span>
								<div class="portlet-borderless-container">
									<div class="portlet-body">
										<div class="gestionUtilisateur">
											<div class="button-holder ">
												<button class="btn"
													onClick="location.href = '/OnlineVisaCenter/MainServlet?command=form_account_change';"
													type='button'>
													<fmt:message key="change_account" />
												</button>
												<button class="btn"
													onClick="location.href = '/OnlineVisaCenter/MainServlet?command=form_change_pass';">
													<fmt:message key="change_password" />
												</button>
												<button class="btn" onclick="swa()" type="button">
													<fmt:message key="delete_account" />
												</button>
												<div id="overlay">

													<div class="popup">
														<button class="close" title="Закрыть окно"
															onclick="swa2()"></button>
														<p class="zag">
															<fmt:message key="modal_win_message" />
														</p>
														<a
															href="/OnlineVisaCenter/MainServlet?command=delete_account"><fmt:message
																key="yes" /></a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${not empty info_message}">
		<div class="alert alert-success">
			<c:out value="${info_message}" />
		</div>
	</c:if>
	
	<script>
		var b = document.getElementById('overlay');
		function swa() {
			b.style.visibility = 'visible';
			b.style.opacity = '1';
			b.style.transition = 'all 0.7s ease-out 0s';
		}
		function swa2() {
			b.style.visibility = 'hidden';
			b.style.opacity = '0';
		}
	</script>
</body>
</html>
