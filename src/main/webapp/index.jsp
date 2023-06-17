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
					<a onclick="findWeather()">날씨</a>
					<a onclick="findCity()">지도API</a>
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
	<script type="text/javascript">
		function findWeather() {
			let city = prompt("검색할 도시를 영어로 입력하세요.");
			if(city !== null && city !== ""){
				let url = "WeatherC?city=" + city;
				location.href = url;
			} else
				return false;
		}
		
		function findCity() {
			let city = prompt("검색할 도시를 도로명 주소로 입력해 주세요");
			if(city !== null && city !== ""){
				let url = "MapC?place=" + city;
				location.href = url;
			} else
				return false;
		}
	</script>
</body>
</html>