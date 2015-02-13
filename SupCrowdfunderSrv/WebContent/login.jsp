<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SupCrowdfunder - Login</title>
	</head>
	<body>
		<%@ include file="/includes/header.jsp"%>
		<div class="span9">
			<div class="border">
				<h3>Login</h3>

				<c:if test="${errors}">
					<p style="color: red">Le formulaire présente des erreurs.</p>
				</c:if>

				<form method="POST" action="login">
					<p>
						<label for="email">Email : </label>
						<input type="text" id="email" name="email" />
					</p>
					<p>
						<label for="password">Mot de passe : </label>
						<input type="password" id="password" name="password" />
					</p>
					<p>	
						<input type="submit" value="Login" />
					</p>
				</form>
			</div>
		</div>
		<%@ include file="/includes/footer.jsp" %>
	</div>
	</div>
	</body>
</html>