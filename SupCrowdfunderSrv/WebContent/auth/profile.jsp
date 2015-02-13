<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Mon profil</title>
	</head>
	<body>
		<%@ include file="/includes/filterHeader.jsp" %>
		
		<div class="span9">
			<div class="border">
				<h3>Mon profil</h3>

				Email : ${username}<br/>
				Prénom : ${firstname}<br/>
				Nom : ${lastname}<br/><br/>
				
				<a href="<%=request.getContextPath()%>/auth/editProfile" class="btn btn-primary btn-block">Modfier</a>
		
			</div>
		</div>
		<%@ include file="/includes/footer.jsp" %>
	</div>
	</div>
	</body>
</html>