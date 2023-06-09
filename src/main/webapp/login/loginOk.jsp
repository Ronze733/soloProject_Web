<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="login-result">
		<div>
			<img alt="" src="./imgs/${sessionScope.account.pic }"
				style="max-width: 10px"> ${sessionScope.account.name }님 어서오세요.
			point: <span style="color: red;"> ${sessionScope.account.point }</span>
		</div>
		<div class="logout-button">
			<button onclick="location.href='LoginC'">로그아웃</button>
		</div>
	</div>
</body>
</html>