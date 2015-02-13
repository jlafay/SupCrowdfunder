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
					<form action="<%= request.getContextPath() %>/admin/dashboardUser" method="post">
						<p>
							<label for="tri">Utilisateurs classés par :</label>
							<select name="tri">
									<option value="1">Id</option>
									<option value="2">Email</option>
									<option value="3">Prénom</option>
									<option value="4">Nom</option>
							</select>
							<input type="submit" value="Choisir" />
						</p>
					</form>
				</div>
				<a href="<%=request.getContextPath()%>/admin/dashboardAddUser" class="btn btn-primary">Ajouter un utilisateur</a>
				<table class="table table-bordered table-striped">
					<tr>
						<th><span class="coloration">Id</span></th>
						<th><span class="coloration">Email</span></th>
						<th><span class="coloration">Prénom</span></th>
						<th><span class="coloration">Nom</span></th>
						<th><span class="coloration">Administration</span></th>
					</tr>
					 
					<c:forEach items="${users}" var="u">
						<tr>
							<td><c:out value="${u.id}" /></td>
							<td><c:out value="${u.email}" /></td>
							<td><c:out value="${u.firstname}" /></td>
							<td><c:out value="${u.lastname}" /></td>
							<td><a href="<%=request.getContextPath()%>/admin/dashboardEditUser?id=${u.id}">modifier</a></td>
							<td><a href="<%=request.getContextPath()%>/admin/deleteUser?id=${u.id}">supprimer</a></td>
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