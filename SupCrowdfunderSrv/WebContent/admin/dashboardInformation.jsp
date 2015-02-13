<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SupCrowdFunder - Dashboard</title>
	</head>
	
	<body>
		<%@ include file="/includes/dashboardHeader.jsp"%>
	
		<div class="span12">
			<div class="border decal">
				<h3>Dashboard</h3>
				<div class="centre">
					<p>
						Nombre de projets créés : <c:out value="${nbProjects}" /><br/>
						Nombre de projets achevés : <c:out value="${nbProjectsDone}" /><br/>
						Nombre de projets non achevés : <c:out value="${nbProjectsNotDone}" /><br/>
						Nombre d'utilisateurs enregistrés : <c:out value="${nbUsers}" /><br/>
						Prix de tous les projets cumulés : <c:out value="${price}" /></br>
						Contribution totale : <c:out value="${contribution}" /></br>
						Contribution attendue : <c:out value="${contributionWaited}" />
						
						
					</p>
				</div>
				<a href="<%=request.getContextPath()%>/admin/dashboard" class="btn btn-primary btn-block">Retour au Dashboard</a>
			</div>
		</div>
		<%@ include file="/includes/footer.jsp"%>
	</div>
	</div>
	</body>
</html>