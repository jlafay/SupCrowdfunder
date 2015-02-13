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
					<form action="<%= request.getContextPath() %>/admin/dashboardProject" method="post">
						<p>
							<label for="tri">Projets classés par :</label>
							<select name="tri">
									<option value="1">Id</option>
									<option value="2">Nom</option>
									<option value="3">Categorie</option>
									<option value="4">Créateur</option>
									<option value="5">Prix</option>
									<option value="6">Contribution</option>
									<option value="7">Avancement</option>
							</select>
							<input type="submit" value="Choisir" />
						</p>
					</form>
				</div>
				<a href="<%=request.getContextPath()%>/admin/dashboardAddProject" class="btn btn-primary">Ajouter un projet</a>
				<table class="table table-bordered table-striped">
					<tr>
						<th><span class="coloration">Id</span></th>
						<th><span class="coloration">Nom</span></th>
						<th><span class="coloration">Catégorie</span></th>
						<th><span class="coloration">Créateur</span></th>
						<th><span class="coloration">Prix</span></th>
						<th><span class="coloration">Contribution</span></th>
						<th><span class="coloration">Avancement</span></th>
						<th><span class="coloration">Administration</span></th>
					</tr>
					 
					<c:forEach items="${projects}" var="p">
						<tr>
							<td><c:out value="${p.id}" /></td>
							<td><a href="<%=request.getContextPath()%>/showProject?id=${p.id}">${p.name}</a></td>
							<td><c:out value="${p.category.name}" /></td>
							<td><c:out value="${p.creator.email}" /></td>
							<td><c:out value="${p.price}" />€</td>
							<td><c:out value="${p.contribution}" />€</td>
							<td><c:out value="${p.percent}" />%</td>
							<td><a href="<%=request.getContextPath()%>/admin/dashboardEditProject?id=${p.id}">modifier</a></td>
							<td><a href="<%=request.getContextPath()%>/admin/deleteProject?id=${p.id}">supprimer</a></td>
						</tr>	
					</c:forEach>
				</table>
				<a href="<%=request.getContextPath()%>/admin/dashboard" class="btn btn-primary btn-block">Retour au Dashboard</a>
			</div>
		</div>
		<%@ include file="/includes/footer.jsp"%>
	</div>
	</div>
	</body>
</html>