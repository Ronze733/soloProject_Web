<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
HOME!!

<button id="openModalBtn">모달 열기</button>

<div id="myModal" class="modal">
	<div class="modal-content">
		<span class="close">&times;</span>
		<p>모달 내용입니다.</p>
	</div>
</div>
<div id="modalOverlay"></div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="./js/modal.js"></script>
</body>
</html>