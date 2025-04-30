<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<div>
			<label>USERNAME</label>
			<input name="username" />
		</div>
		<div>
			<label>PASSWORD</label>
			<input name="password" type="password" />
		</div>
		<div>
			<label for="remember-me">로그인 상태 유지</label>
			<input type="checkbox" name="remember-me" id="remember-me"/>
		</div>
		<button>로그인</button>
		
	</form>
	${message}
	${param.error}
</body>
</html>