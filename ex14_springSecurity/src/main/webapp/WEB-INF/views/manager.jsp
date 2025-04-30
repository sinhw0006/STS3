<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MANAGER</h1>
	<p>
		PRINCIPAL :
		<sec:authentication property="principal" />
	</p>
	<p>
		PRINCIPAL USERNAME :
		<sec:authentication property="principal.username" />
	</p>
	<p>
		USERDTO :
		<sec:authentication property="principal.userDto" />
	</p>
	<p>
		USERNAME :
		<sec:authentication property="principal.userDto.username" />
	</p>
	<p>
		PASSWORD :
		<sec:authentication property="principal.userDto.password" />
	</p>
	<p>
		ROLE :
		<sec:authentication property="principal.userDto.role" />
	</p>

	<sec:authorize access="isAuthenticated()">
		<p>로그인</p>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<p>비로그인</p>
	</sec:authorize>

	<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
</body>
</html>