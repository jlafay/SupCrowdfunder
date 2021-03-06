<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SupCrowfunder - Nouveau projet</title>
	</head>
	<body>
		<%@ include file="/includes/filterHeader.jsp" %>

		<div class="span9">
			<div class="border">
				<h3>Nouveau projet</h3>
	
				<c:if test="${errors}">
					<p style="color: red">Le formulaire présente des erreurs.</p>
				</c:if>

				<form action="<%= request.getContextPath() %>/auth/addProject" method="post">

					<p>
						<label for="name">Nom :</label>
						<input type="text" size="40" name="name" id="name" />
					</p>

					<p>
						<label for="content">Description :</label>
						<textarea name="content" id="content" cols="40"></textarea>
					</p>

					<p>
						<label for="price">Prix :</label>
						<input type="text" size="10" name="price" id="price" />
					</p>
			
					<p>
						<label for="category">Catégorie :</label>
						<select name="category">
							<c:forEach items="${categories}" var="c">
								<option value="${c.id}">${c.name}</option>
							</c:forEach>
						</select>
					</p>

					<p>
						<input type="submit" value="Ajouter" />
					</p>

				</form>
			</div>
		</div>
		<%@ include file="/includes/footer.jsp" %>
	</div>
	</div>
	</body>
</html>