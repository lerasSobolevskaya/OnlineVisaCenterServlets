<!DOCTYPE html>
<html class="aui ltr" dir="ltr" lang="ru-RU">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="resources"/>
<head>
<meta charset="utf-8">
<title><fmt:message key="title" /></title>
<link rel="shortcut icon" href="resources/images/icons/Belarus_Flag.png"
	type="image/png">
<link href="https://france-visas.gouv.fr/html/errors/styles/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link rel="stylesheet" href="https://france-visas.gouv.fr/html/errors/styles/customError.css">
<link rel="stylesheet" href="https://france-visas.gouv.fr/html/errors/styles/font-awesome.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body class="404Container">

<div class="container-fluid">
<div class="row-fluid">
	<header class="span12 pageError">
		<img src="resources/images/error.jpg"  alt="logo de la marianne" id="banner_logo"/>
		<h2 id="banner_h2"><fmt:message key="custom_slogan" /></h2>
		<h2 id="banner_404">404</h2>
	</header>
</div>
</div>

<div class="container-fluid">
<div class="row-fluid">
	<main class="span12 pageError">
	<section class="pageError">
		<p class="main_404" dir="ltr" lang="ru"> <fmt:message key="back"/></p>
<!-- 	<section> -->
	<aside>
	<a href="/OnlineVisaCenter/MainServlet?command=start_page" class="error">
		<i  aria-hidden="true"></i> <fmt:message key="start_page"/>
	</a>
	</aside>
</section>
	</main>
</div>
</div>
</body>
</html>