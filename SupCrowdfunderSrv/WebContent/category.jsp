<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SupCrowdfunder - Projets par catégories</title>
	</head>
	<body>
		<%@ include file="/includes/header.jsp" %>

		<div class="span9">
			<div class="border">
				<h3>Projets par catégories</h3>
	
				<c:if test="${errors}">
					<p style="color: red">Le formulaire présente des erreurs.</p>
				</c:if>
				
				<form action="<%= request.getContextPath() %>/category" method="post">
					<p>
						<label for="category">Catégorie :</label>
						<select name="category">
							<c:forEach items="${categories}" var="c">
								<option value="${c.id}">${c.name}</option>
							</c:forEach>
						</select>
						<input type="submit" value="Choisir" />
					</p>

				</form>
				<div class="row">
					<c:forEach items="${projects}" var="p">
						<div class="border-project span2 center">
							<p>
								<strong> <c:out value="${p.name}" /> </strong>
							</p>
							<p>
								Description :<br />
								<c:out value="${p.shortContent}" />
							</p>
							<p>
								<c:out value="${p.contribution}" />/
								<c:out value="${p.price}" />€
								(<c:out value="${p.percent}" />%) <br/><br/>
								<a href="showProject?id=${p.id}">Détail</a>
							</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<%@ include file="/includes/footer.jsp" %>
	</div>
	</div>
	</body>
</html>