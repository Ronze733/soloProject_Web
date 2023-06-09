/**
 * 
 */
let openwin;

function checkKorSpecial(idValue) {
	let regex = /[ㄱ-힣|~!@#$%^&*()_+|<>?:{}]/;
	return regex.test(idValue);
}

function duplicateCheck() {
	let idValue = document.getElementsByName("idJoin")[0].value;
	let url = "http://localhost/1peopleCardgame/JoinPopupC?idJoin=" + idValue;
	let name = "ID 중복 체크 창";

	openwin = window.open(url, name, "width=500, height=300, toolbar=no, status=no, location=no,scrollbars=yes,menubar=no, resizable=no,left=50,right=50");
}

function idValidCheck() {
	let idValue = document.getElementsByName("idJoin")[0].value;

	if (idValue != null && idValue != "")
		if (!checkKorSpecial(idValue))
			return true;
		else
			alert("한글, 특수문자를 포함할 수 없습니다.");
	else
		alert("ID를 입력해 주세요");
	return false;
}

function dupleCheck(event) {
	event.preventDefault();
	if (idValidCheck()) {
		duplicateCheck();
	}
}

function inPopupduple() {
	if (idValidCheck()) {
		return true;
	}

	document.getElementById("result").textContent = "사용 불가능한 아이디입니다.";

	return false;
}

function sendValue() {
	window.opener.document.getElementsByName("idJoin")[0].value = document.getElementsByName("idJoin")[0].value;
	window.opener.document.getElementById("idtf").value = "true";
}

function validCheck() {
	let a = document.getElementById("idtf").value;
	let b1 = document.getElementById("resultMessage").style.color;
	let b2 = document.getElementById("resultMessage2").style.color;
	if (a == "true")
		if (b1 == "blue" && b2 == "black")
			if(document.getElementById("joinname").value != "")
				if(document.getElementById("joinbirth").value != "")
					if(document.getElementById("pic").value != "")
						if(document.getElementsByName("gender")[0].checked || 
							document.getElementsByName("gender")[1].checked){
								alert("회원가입을 축하드립니다!")
								return true;
							}
						else {
							alert("성별을 체크해주세요");
							return false;
						}
					else {
						alert("사진을 넣어주세요");
						return false;
					}
				else {
					alert("생일을 입력해 주세요");
					return false;
				}
			else {
				alert("닉네임을 입력해주세요");
				return false;
			}
		else {
			alert("pw를 확인해주세요.");
			return false;
		}
	else {
		alert("Id 중복 검사를 시행해 주세요.");
		return false;
	}

}

function pwValidCheck() {
	let pw = document.getElementById("pw");

	if (pw.value == '')
		return 3;

	if (!lessThan(pw, 8))
		if (!containKR(pw))
			if (!notContains(pw, "1234567890"))
				if (!notContains(pw, "qwertyuiopasdfghjklzxcvbnm"))
					if (!notContains(pw, "QWERTYUIOPASDFGHJKLZXCVBNM"))
						return 1;

	return 2;

}

function notEqualsPWjoin() {
	let pw = document.getElementById("pw");
	let repw = document.getElementById("repw");

	return notEqualsPW(pw, repw);
}


function popupCheck(str, checkNum) {
	/*console.log(str);
	console.log(checkNum);*/
	let a = document.getElementById("idJoin");
	if (str == a.value) { 
		if (checkNum == '2') { 
			sendValue();
			window.close(); 
		} else { 
			alert('중복 체크를 다시 시도해 주십시오.'); 
		}
	} else { 
		alert('중복 체크를 다시 시도해 주십시오.'); 
	}
}