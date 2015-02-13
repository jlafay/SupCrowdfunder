<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SupCrowdfunder - Modifier le projet</title>
	</head>
	<body>
		<%@ include file="/includes/filterHeader.jsp" %>
		
		<div class="span9">
			<div class="border">
				<h3>Modifier le projet</h3>
				<c:if test="${errors}">
					<p style="color: red">Le formulaire présente des erreurs.</p>
				</c:if>

				<form action="<%= request.getContextPath() %>/admin/dashboardEditProject" method="post">

					<p>
						<label for="name">Changer le nom :</label>
							<input type="text" size="40" name="name" id="name" /> (Nom actuel : ${project.name})
					</p>
					<p>
						
						<label for="content">Changer la description :</label>
							<input type="text" size="40" name="content" id="content" /> (Description actuelle : ${project.content})
					</p>
					<p>
						<label for="price">Changer le prix :</label>
							<input type="text" size="40" name="price" id="price" /> (Prix actuel : ${project.price})
					</p>
					<p>
						<label for="category">Changer de catégorie :</label>
							<input type="text" size="40" name="category" id="category" /> (Catégorie actuelle : ${project.category.name})
					</p>
					<p>
						<label for="creator">Changer de créateur :</label>
							<input type="text" size="40" name="creator" id="creator" /> (Créateur actuel : ${project.creator.email})
					</p>
					<p>
						<input type="submit" value="Editer" />
					</p>

				</form>
				<a href="<%=request.getContextPath()%>/admin/dashboard" class="btn btn-primary btn-block">Retour au Dashboard</a>
			</div>
		</div>
		<%@ include file="/includes/footer.jsp" %>
	</div>
	</div>
	</body>
</html>