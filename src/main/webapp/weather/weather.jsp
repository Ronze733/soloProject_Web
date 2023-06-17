<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>지역 : ${countryName } ${cityName }</div>
		<c:forEach items="${weathers }" var="w">
			<div style="display: flex; border: 1px solid black">
				<div>
					시간 : ${w.day }
				</div>
				<div>
					<img alt="" src="https://openweathermap.org/img/wn/${w.icon }@2x.png">
				</div>
				<div>
					날씨 : ${w.condition }
					온도 : ${w.temp }도
					습도 : ${w.humidity }%
					풍속 : ${w.windSpeed }m/s
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>