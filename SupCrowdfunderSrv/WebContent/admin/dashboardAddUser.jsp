<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SupCrowdfunder - Ajouter un utilisateur</title>
	</head>
	<body>
		<%@ include file="/includes/filterHeader.jsp" %>
		
		<div class="span9">
			<div class="border">
				<h3>Ajouter un utilisateur</h3>
				<c:if test="${errors}">
					<p style="color: red">Le formulaire présente des erreurs.</p>
				</c:if>

				<form action="<%= request.getContextPath() %>/admin/dashboardAddUser" method="post">

					<p>
						<label for="email">Email :</label>
							<input type="text" size="40" name="email" id="email" />
					</p>
					<p>
						<label for="firstname">Prénom :</label>
							<input type="text" size="40" name="firstname" id="firstname" />
					</p>
					<p>
						<label for="lastname">Nom :</label>
							<input type="text" size="40" name="lastname" id="lastname" />
					</p>
					<p>
						<label for="password">Mot de passe :</label>
							<input type="password" size="40" name="password" id="password" />
					</p>
					<p>
						<label for="password2">Confirmation du mot de passe :</label>
							<input type="password" size="40" name="password2" id="password2" />
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