<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="joinPage">
		<!-- id, pw, 닉네임, 생일, 사진, 성별 -->
		<form action="JoinC" method="post" enctype="multipart/form-data">
			<div class="joinTbl">
				<div>회원가입 포맷</div>
				<div class="inputid">
					<div>ID</div>
					<div>
						<input name="idJoin">
					</div>
					<div>
						<button onclick="dupleCheck(event);">중복 체크</button>
					</div>
					<div>
						<input type="hidden" id="idtf">
					</div>
				</div>
				<div class="inputPw">
					<div>패스워드</div>
					<div>
						<input name="pw" id="pw"><br> <span
							style="color: black; font-size: 5pt">비밀번호는 영문, 숫자만 포함하여
							8자리 이상으로 설정해 주십시오.</span><br> <span id="resultMessage"
							style="color: black; font-size: 5pt"></span>
					</div>
				</div>
				<div class="inputRepw">
					<div>패스워드 재확인</div>
					<div>
						<input id="repw"><br> <span id="resultMessage2"
							style="font-size: 5pt"></span>
					</div>
				</div>
				<div class="inputname">
					<div>닉네임</div>
					<div>
						<input id="joinname" name="name">
					</div>
				</div>
				<div class="inputbirth">
					<div>생일</div>
					<div>
						<input id="joinbirth" type="date" name="birth">
					</div>
				</div>
				<div class="inputpic">
					<div>사진</div>
					<div>
						<span> <img alt="" src="" id="joinpic" style="max-width: 100px">
						</span> <input type="file" name="pic" id="pic" accept=".jpg, .jpeg">
					</div>
				</div>
				<div class="inputsex">
					<div>성별</div>
					<div>
						<input type="radio" name="gender" value="male">남
						<input type="radio" name="gender" value="female">여
					</div>
				</div>
				<div class="joinbutton">
					<button type="submit" onclick="return validCheck();">회원가입</button>
				</div>
			</div>
		</form>
	</div>

	<script>
		let passwordInput = document.getElementById("pw");
		passwordInput.addEventListener("input", function() {
			let resultMessage = document.getElementById("resultMessage");
			let validationResult = pwValidCheck();

			if (validationResult === 2) {
				resultMessage.textContent = "사용 불가능한 비밀번호 입니다.";
				resultMessage.style.color = "red";
			} else if (validationResult === 1) {
				resultMessage.textContent = "사용 가능한 비밀번호 입니다.";
				resultMessage.style.color = "blue";
			} else {
				resultMessage.textContent = "";
			}
		});
	</script>

	<script>
		let repwInput = document.getElementById("repw");
		repwInput.addEventListener("input", function() {
			let resultMessage = document.getElementById("resultMessage2");
			let validation = notEqualsPWjoin();

			if (validation) {
				resultMessage.textContent = "비밀번호가 같지 않습니다.";
				resultMessage.style.color = "red";
			} else {
				resultMessage.textContent = "";
				resultMessage.style.color = "black";
			}
		});
	</script>
	<script>
		const inputElement = document.getElementById("pic");
		const imageElement = document.getElementById("joinpic");

		inputElement.addEventListener("change", function(event) {
			const file = event.target.files[0];

			if (file && (file.type === "image/jpeg" || file.type === "image/jpg")) {
				const reader = new FileReader();

				reader.onload = function(e) {
					imageElement.src = e.target.result;
				};

				reader.readAsDataURL(file);
			}
		});
	</script>

</body>
</html>