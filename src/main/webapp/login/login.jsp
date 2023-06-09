<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="login-main">
	<div class="login">
		<form action="LoginC" method="post">
			ID <input name="id">
			PW <input name="pw">
			<button>로그인</button>
		</form>
	</div>
	<div class="join">
		<form action="JoinC">
			<button>회원가입</button>
		</form>
	</div>
</div>
</body>
</html>