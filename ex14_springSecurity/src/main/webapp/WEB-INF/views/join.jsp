<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/join" method="post">
		<div>
			<h1>회원가입</h1>
		</div>
		<div>
			<label>username : </label><span style="color:red;font-size:.7rem;">${username}</span><br>
			<input name="username" />
		</div>
		<div>
			<label>password : </label><span style="color:red;font-size:.7rem;">${password}</span><br>
			<input name="password" type="password" />
		</div>
		
		<div>
			<input type="submit" value="회원가입" />
		</div>

	
	</form>
</body>
</html>