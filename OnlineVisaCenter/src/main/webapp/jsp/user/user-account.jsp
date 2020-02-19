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
<link
	href="https://france-visas.gouv.fr/fv-fo-portal-accueilusager-portlet/css/main.css?browserId=other&amp;themeId=fvfoportalthemeinf_WAR_fvfoportalinftheme&amp;minifierType=css&amp;languageId=ru_RU&amp;b=6210&amp;t=1558621899000"
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

					</div>
				</div>
			</div>
			<div id="imgBannerCentral" class="imgBanner"></div>
		</div>

		<div class="columns-1" id="main-content" role="main">
			<div class="portlet-layout row-fluid">
				<div class="portlet-column portlet-column-only span12" id="column-1">
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
												onClick="location.href = '/OnlineVisaCenter/MainServlet?command=form_change_pass';"
												type='button'>
												<fmt:message key="change_password" />
											</button>
											<button class="btn" onclick="swa()" type="button">
												<fmt:message key="delete_account" />
											</button>
											<div id="overlay">

												<div class="popup">
													<button class="close" title="Закрыть окно" onclick="swa2()"></button>
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
		<c:if test="${not empty info_message}">
			<div class="alert alert-success" style="width: 20%">
				<c:out value="${info_message}" />
			</div>
		</c:if>
		<c:if test="${not empty quest_have_filled}">
			<div class="alert alert-error" style="width: 22%">
				<c:out value="${quest_have_filled}" />
			</div>
		</c:if>

		<div id="content" class="row-fluid niveauCentral">


			<table style="width: 100.0%;">
				<tbody>
					<tr>
						<td style="text-align: center; width: 20.0%;"><a
							href="/OnlineVisaCenter/MainServlet?command=form_add_quest"
							style="outline: 0;"><img
								src="resources/images/icons/stage1.png" style="width: 45.0%;" /></a>
							<p style="color: rgb(8, 112, 173); font-size: 18.0px;">
								<a href="#Etape1"
									style="color: rgb(8, 112, 173); text-decoration: none; outline: 0;"><fmt:message
										key="step_first" /> </a>
							</p></td>
						<td style="text-align: center; width: 20.0%;"><a
							href="/OnlineVisaCenter/MainServlet?command=form_search_quest"
							style="outline: 0;"><img
								src="resources/images/icons/stage2.png" style="width: 45.0%;" /></a>
							<p style="font-size: 18.0px;">
								<a href="#Etape2"
									style="color: rgb(8, 112, 173); text-decoration: none; outline: 0;"><fmt:message
										key="step_second" /> </a>
							</p></td>
						<td style="text-align: center; width: 20.0%;"><a
							href="/OnlineVisaCenter/MainServlet?command=form_search_visa"
							style="outline: 0;"><img
								src="resources/images/icons/stage2.png" style="width: 45.0%;" /></a>
							<p style="font-size: 18.0px;">
								<a href="#Etape3"
									style="color: rgb(8, 112, 173); text-decoration: none; outline: 0;"><fmt:message
										key="step_third" /> </a>
							</p></td>
						<td style="text-align: center; width: 20.0%;"><a
							href="/OnlineVisaCenter/MainServlet?command=form_search_visa_for_update"
							style="outline: 0;"><img alt=""
								src="resources/images/icons/stage3.png" style="width: 45.0%;" /></a>
							<!-- 						<p --> <!-- 							style="text-transform: uppercase; background-color: rgb(251, 176, 59); padding: 5.0px; font-weight: bold; width: 70.0px; margin: 10.0px auto;"> -->
							<!-- 							<a href="#Etape4" --> <!-- 								style="color: rgb(255, 255, 255); font-weight: bold; text-decoration: none; outline: 0;">шаг -->
							<!-- 								4</a> --> <!-- 						</p> -->
							<p style="font-size: 18.0px;">
								<a href="#Etape4"
									style="color: rgb(8, 112, 173); text-decoration: none; outline: 0;">
									<fmt:message key="step_fourth" />
								</a>
							</p></td>
						<td style="text-align: center; width: 20.0%;"><a
							href="#Etape5" style="outline: 0;"><img alt=""
								src="/documents/66002/17040223/etape5.png/e2c08b76-04ac-9c86-5ee8-4b4e9fe437e8?t=1529394897564"
								style="width: 45.0%;" /></a>
							<p style="font-size: 18.0px;">
								<a href="#Etape5"
									style="color: rgb(8, 112, 173); text-decoration: none; outline: 0;">

								</a>
							</p></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
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
