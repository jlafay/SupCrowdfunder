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
				<a href="<%=request.getContextPath()%>/admin/dashboardAddCategory" class="btn btn-primary">Ajouter une catégorie</a><br/>
				<table class="table table-bordered table-striped">
					<tr>
						<th><span class="coloration">Id</span></th>
						<th><span class="coloration">Nom</span></th>
						<th><span class="coloration">Administration</span></th>
					</tr>
					 
					<c:forEach items="${categories}" var="c">
						<tr>
							<td><c:out value="${c.id}" /></td>
							<td><c:out value="${c.name}" /></td>
							<td><a href="<%=request.getContextPath()%>/admin/dashboardEditCategory?id=${c.id}">modifier</a></td>
							<td><a href="<%=request.getContextPath()%>/admin/dashboardDeleteCategory?id=${c.id}">supprimer</a></td>
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