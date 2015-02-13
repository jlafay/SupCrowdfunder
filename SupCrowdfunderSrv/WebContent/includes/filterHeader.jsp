<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="../css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="../css/tuto1.css" type="text/css" rel="stylesheet" />
<script type='text/javascript' src="http://code.jquery.com/jquery.js"></script>
<script type='text/javascript' src="../js/bootstrap.js"></script>

<div class="container">
	<div id="header" class="hero-unit">
		<h1><img src="../img/logo_supinfo_0063AF.png" alt="Logo de SUPINFO" />SupCrowdfunder</h1>
		<p>
			Permettez à des projets que vous aimez d'exister grâce à votre soutien !<br/>
			Créez votre propre projet et obtenez des fonds grâce au financement participatif de la communauté de SupCrowdfunder !
		</p>
	</div>
	<nav class="navbar navbar-static-top">
		<div class="navbar-inner">
			<div class="container">
				<ul class="nav nav-tabs nav-stacked">
					<li><a href="<%=request.getContextPath()%>/listProject">Tous les projets</a></li> 
					<li><a href="<%=request.getContextPath()%>/category">Projets par catégories</a></li>
					<c:choose>
						<c:when test="${not empty username}">
							<li><a href="<%=request.getContextPath()%>/auth/addProject">Nouveau projet</a></li>
							<li><a href="<%=request.getContextPath()%>/logout">Deconnexion</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="<%=request.getContextPath()%>/register">S'enregistrer</a></li>
							<li><a href="<%=request.getContextPath()%>/login">Connexion</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	<div class="row">
		<div id="menu" class="span3">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="<%=request.getContextPath()%>/listProject">Tous les projets</a></li> 
				<li><a href="<%=request.getContextPath()%>/category">Projets par catégories</a></li>
				<c:choose>
					<c:when test="${not empty username}">
						<li><a href="<%=request.getContextPath()%>/auth/addProject">Nouveau projet</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="<%=request.getContextPath()%>/login">Connexion</a></li>
						<li><a href="<%=request.getContextPath()%>/register">S'enregistrer</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${not empty admin}">
						<li><a href="<%=request.getContextPath()%>/admin/dashboard">Dashboard</a></li>
					</c:when>
				</c:choose>
			</ul>  
		</div>