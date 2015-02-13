<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SupCrowdFunder - Nouvelle catégorie</title>
	</head>
	<body>
		<%@ include file="/includes/filterHeader.jsp" %>

		<div class="span9">
			<div class="border">
				<h3>Nouvelle catégorie</h3>

				<c:if test="${errors}">
					<p style="color: red">Le formulaire présente des erreurs.</p>
				</c:if>

				<form action="<%= request.getContextPath() %>/admin/dashboardAddCategory" method="post">
	
					<p>
						<label for="name">Nom :</label>
						<input type="text" name="name" id="" />
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