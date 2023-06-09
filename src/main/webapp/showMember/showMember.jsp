<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div>
		<div>${member.name }님의 정보</div>
		<div>
			<div>ID</div>
			<div>
				${member.id }
			</div>
		</div>
		<div>
			<div>닉네임</div>
			<div>${member.name }</div>
		</div>
		<div>
			<div>생일</div>
			<div>${member.birth }</div>
		</div>
		<div>
			<div>회원 가입일</div>
			<div>${member.joinDate }</div>
		</div>
		<div>
			<div>성별</div>
			<div>${member.sex }</div>
		</div>
		<div>
			<button onclick="location.href='ShowMemberModifiC'">수정</button>
		</div>
	</div>
</div>
</body>
</html>