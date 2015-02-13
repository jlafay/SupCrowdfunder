<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SupCrowdfunder - Tous les projets</title>
	</head>
	
	<body>
		<%@ include file="/includes/header.jsp"%>
	
		<div class="span9">
			<div class="border">
				<h3>Tous les projets</h3>
				
				<c:if test="${not empty username}"><br />
					<a href="<%=request.getContextPath()%>/auth/becomeAdmin" class="btn btn-primary btn-block">Devenir administrateur (bouton provisoir pour voir le dashboard)</a>
				</c:if>
				
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
								<a href="showProject?id=${p.id}">Voir en détail</a>
							</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<%@ include file="/includes/footer.jsp"%>
	</div>
	</div>
	</body>
</html>