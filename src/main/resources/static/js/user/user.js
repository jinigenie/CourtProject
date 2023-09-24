//은행정보 확인
$("#selectBank").change(function() {
	let selected = $("#selectBank option:selected").val();
	if (selected == 'kb') {
		$("#bankIcon").attr("src", "/img/app/kbIcon.png");
		$(".selBank").html('국민은행');
	} else if (selected == 'ibk') {
		$("#bankIcon").attr("src", "/img/app/ibkIcon.png");
		$(".selBank").html('기업은행');
	} else if (selected == 'nh') {
		$("#bankIcon").attr("src", "/img/app/nhIcon.png");
		$(".selBank").html('농협은행');
	} else if (selected == 'sh') {
		$("#bankIcon").attr("src", "/img/app/shIcon.png");
		$(".selBank").html('신한은행');
	} else if (selected == 'wr') {
		$("#bankIcon").attr("src", "/img/app/wrIcon.png");
		$(".selBank").html('우리은행');
	} else if (selected == 'hn') {
		$("#bankIcon").attr("src", "/img/app/hnIcon.png");
		$(".selBank").html('하나은행');
	} else if (selected == 'sc') {
		$("#bankIcon").attr("src", "/img/app/scIcon.png");
		$(".selBank").html('SC제일은행');
	} else {
		$("#bankIcon").attr("src", "#");
		$(".selBank").html('');
	}

});

///////////////
let checkPhone = false;
let checkPw = false;
let checkId = false;
let idPattern = /^[a-z0-9]{7,16}$/;
let phonePattern = /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/;

//폰 인증받기
let certification = 0;
$("#phoneBtn").click(() => {
	const phone = $('#userphone').val();
	if (phone == '' || phone == 'null') {
		alert("휴대폰 번호를 입력해주세요.")
		return;
	} else if (!phonePattern.test(phone)) {
		alert("알맞은 휴대폰 번호를 입력해주세요.");
		return;
	}
	$('.showPhone').show();
	$.ajax({
		url: "send-one",
		method: "POST",
		data: {
			"phone": phone
		},
		dataType: "json",
		success: (data) => {
			console.log("통", certification);
			console.log(data);
			certification = data;
			console.log("통신하고 나서 콘솔", certification);
		},
		error: (status, error) => {
			console.log(status, error);
		}
	})
})
$("#phoneCheckBtn").click(() => {

	let checkNumber = $('#phoneCheck').val();
	console.log(certification, checkNumber);
	if (checkNumber == certification) {
		alert("인증되었습니다.")
		checkPhone = true;
	} else {
		alert("인증실패");
		checkPhone = false;
	}
})
//비밀번호 확인
$('#password-confirm').on('keyup', function() {
	var password = $('#password').val();
	var passwordConfirm = $(this).val();
	if (password === passwordConfirm) {
		$('#password-confirm-message').removeClass('password-mismatch').text('');
		checkPw = true;
	} else {
		$('#password-confirm-message').addClass('password-mismatch').text('비밀번호가 일치하지 않습니다.');
		checkPw = false;
	}
});

//가입버튼
$('#joinBtn').click(function(event) {
	// 폼을 제출
	if (checkId && checkPhone && checkPw) {
		$('#joinForm').submit();
	}
});

//아이디 중복확인
$("#checkDuple").click(function() {
	const userid = $("#userid").val();
	$("#resultMessage").text("");
	$("#validMessage").text("");

	if (userid == "" || userid == 'null') {
		alert("아이디를 입력해주세요")
		return;
	} else if (!idPattern.test(userid)) {
		alert("7~16자의 영문 소문자, 숫자의 조합으로 작성해주세요");
		return;
	}


	$.ajax({
		url: "checkDuplicateUsername",
		method: "POST",
		data: { userid: userid },
		success: function(response) {
			console.log(response)
			if (response) {
				$("#resultMessage").text("사용 가능한 아이디입니다.");
				checkId = true;
			} else {
				$("#resultMessage").text("이미 사용 중인 아이디입니다.");
				checkId = false;
			}
		},
		error: function(error) {
			console.error("중복 확인 요청 실패:", error);
		}
	});
});

//이메일 선택 시 값 넣기
$('#mailAddr').change(() => {
	$('#cvl_mail2').val($('#mailAddr').val())
})

//비밀번호 가리기 보이기
$('#showPw').change(() => {
	togglePasswordVisibility()
})

function togglePasswordVisibility() {
	var passwordField = document.getElementById("password");
	if (passwordField.type === "password") {
		passwordField.type = "text";
	} else {
		passwordField.type = "password";
	}
}
/////폰 번호 입력형식 010-0000-1111 로 변경하기
$('#phoneNumber').keyup(() => {
	var phoneNumberField = document.getElementById("phoneNumber");
	var formattedValue = phoneNumberField.value.replace(/\D/g, ''); // 숫자만 남기고 나머지 문자 제거

	// 전화번호 포맷 적용 (예: 01012341234 -> 010-1234-1234)
	if (formattedValue.length >= 3) {
		formattedValue = formattedValue.replace(/(\d{3})(?=\d)/, "$1-");
	}
	if (formattedValue.length >= 8) {
		formattedValue = formattedValue.replace(/(\d{4})(?=\d)/, "$1-");
	}

	phoneNumberField.value = formattedValue; // 포맷팅된 값으로 입력 필드 업데이트
	
	$('#userphone').val(formattedValue.replace(/-/g, '')); 
	
})
//예금주 입력값 검증
$('#userholder').keyup(()=>{
  var inputValue = $('#userholder').val();
  
  var regex = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/\-=|0-9]/;
  
  if (regex.test(inputValue)) {
    alert("특수 문자나 숫자는 입력할 수 없습니다.");
    $('#userholder').val('')
  } 
})
//계좌번호 입력값 검증
$('#useraccount').keyup(()=>{
  var inputValue = $('#useraccount').val();
  
   var regex = /^[0-9]+$/;
  
  if (!regex.test(inputValue)) {
    alert("숫자 외 입력할 수 없습니다.");
    $('#useraccount').val('')
  } 
})





