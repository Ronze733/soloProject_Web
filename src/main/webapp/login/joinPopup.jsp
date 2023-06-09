<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/validCheck.js"></script>
<script type="text/javascript" src="./js/join.js"></script>
</head>
<body>
<span id="result">${result }</span>
<form action="JoinPopupC">
	<input id="idJoin" name="idJoin" value="${param.idJoin }">
	<button onclick="return inPopupduple();">중복 체크</button>
</form>
 <button onclick="popupCheck('${param.idJoin }', '${resultI }')" >확인</button>
</body>
</html>