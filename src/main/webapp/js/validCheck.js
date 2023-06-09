 // 일반적으로 유효성 검사 하는 것들
 // 함수 형태로 정리해서
 // 나중에 필요할때 쓸라고(쓰기 편하게)
 // .jar 가져다 쓰는 것 처럼(lib)
 
 
 // 문제가 있으면 true, 없으면 false
 
 
 // <input>을 넣으면..
 // 거기에 글자가 없으면 true, 있으면 false
 
 function isEmpty(input){
 	return !input.value;
 }
 
 // <input>과, 글자 수를 넣으면
 // 그 글자 수 보다 적으면 true, 아니면 false
 
 function lessThan(input, len){
	return input.value.length < len;
}

// <input> 을 넣어서
// 값이 숫자가 아니면 true, 숫자면 false

function isNotNumber(input){
	return isNaN(input.value);
}

// <input> X 2 넣으면
// 내용이 다르면 true, 아니면 false

function notEqualsPW(input1, input2){
	if(input1.value == input2.value)
		return false;
	return true;
}

// <input> 넣으면
// 한글/ 특수문자 들어있으면 true, 아니면 false
// id, pw, e-mail

function containKR(input){
	// 상혁
	// mz세상
	// sh1004
	let ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM_@.1234567890";
	
	for(let i = 0; i < input.value.length; i++){
		if(ok.indexOf(input.value[i]) == -1)
			return true;
	}
	
	return false;
	
}

// <input>, 문자열 세트
// 그 문자열 세트가 포함이 안되어 있으면 true
// 들어있으면 false

// 비밀번호 조합

function notContains(input, set){
	// input : ASD
	// input : 1qASD
	
	// set : 1234567890			// 반드시 숫자를 포함 시키고 싶다.
	// set : QWERTYUIOPASDFGHJKLZXCVBNM	// 대문자를 반드시 포함 시키고 싶다.
	
	for(let i = 0; i < set.length; i++){
		if(input.value.indexOf(set[i]) != -1)
			return false;
	}
	
	return true;
}

// <input>, 확장자를 넣으면
// 그 파일이 아니면 true, 맞으면 false

// jpg, jpeg, png, gif

// asd.jpg
						// "jpg"
function isNotType(input, type) {
	type = "." + type;	// .jpg
	return input.value.indexOf(type) == - 1;
}



