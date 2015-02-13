<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SupCrowdfunder - Dashboard</title>
	</head>
	<body>
		<%@ include file="/includes/filterHeader.jsp"%>

		<div class="span9">
			<div class="border">
				<h3>Dashboard</h3>
				<a href="<%=request.getContextPath()%>/admin/dashboardInformation" class="btn btn-primary btn-block">Informations générales</a>
				<a href="<%=request.getContextPath()%>/admin/dashboardProject" class="btn btn-primary btn-block">Administrer les projets</a>
				<a href="<%=request.getContextPath()%>/admin/dashboardUser" class="btn btn-primary btn-block">Administrer les utilisateurs</a>
				<a href="<%=request.getContextPath()%>/admin/dashboardCategory" class="btn btn-primary btn-block">Administrer les catégories</a>
			</div>
		</div>
		<%@ include file="/includes/footer.jsp" %>
	</div>
	</div>
	</body>
</html>