<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/index.css">
<link rel="stylesheet" href="./css/login.css">
<link rel="stylesheet" href="./css/join.css">
<script type="text/javascript" src="./js/validCheck.js"></script>
<script type="text/javascript" src="./js/join.js"></script>
<script type="text/javascript">
let message = '${alert }';
console.log(message);
if(message != null && message != ""){
	alert(message);
	location.href="HC";
}
</script>
</head>
<body>
	<div class="container">
		<div class="in-container">
			<div class="loginandmenu">
				<div class="login_status">
					<jsp:include page="${loginStatus }" />
				</div>
				<div class="menus">
					<a href="HC">홈</a>
					<a href="BoardC">게시판</a>
					<a href="Game1C">게임1</a>
					<a href="Game2C">게임2</a>
					<a href="ShowMember2C?id=${sessionScope.account.name }">회원 정보</a>
				</div>
			</div>
			<div class="contents">
				<div></div>
				<div>
					<jsp:include page="${contentPage }" />
				</div>
				<div></div>
			</div>
		</div>
	</div>
</body>
</html>