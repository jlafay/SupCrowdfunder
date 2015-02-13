<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SupCrodfunder - Détail du projet</title>
	</head>
	<body>
		<%@ include file="/includes/header.jsp"%>
		<div class="span9">
			<div class="border">
				<h2><c:out value="${project.name}" /></h2>
				<p>
					Catégorie : <c:out value="${project.category.name}" />
				</p>
				<p>
					Créateur : <c:out value="${project.creator.email}" />
				</p>
				<p>
					Description :<br />
					<c:out value="${project.content}" />
				</p>
				<p>
					<c:out value="${project.contribution}" />/
					<c:out value="${project.price}" />€
					(<c:out value="${project.percent}" />%) 
				</p>
					<c:if test="${not empty username}">
						<form action="<%= request.getContextPath() %>/showProject" method="post">
						<p>
							<label for="contribution">Contribution :</label>
							<input type="text" size="10" name="contribution" id="contribution" />(€)
						</p>

						<p>
							<input type="submit" value="Donner" />
						</p>

						</form>
						<form method="post" action="<%=request.getContextPath()%>/auth/removeProject">
							<input type="hidden" name="id" value="${project.id}" />
							<input type="submit" value="Supprimer ce produit">
						</form>
					</c:if>
				</p>
			</div>
		</div>
		<%@ include file="/includes/footer.jsp" %>
	</div>
	</div>	
	</body>
</html>