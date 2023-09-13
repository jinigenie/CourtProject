/* ------------------조력자 등재 page  fclttRegist --------------------*/
/*document.addEventListener("DOMContentLoaded", function() {
	var registerButton = document.querySelector('.register-button');
	var cancelButton = document.querySelector('.cancel-button');

	registerButton.addEventListener('click', function() {
		// 등록 버튼 클릭 시 수행할 동작
		alert("등록되었습니다.");
	});

	cancelButton.addEventListener('click', function() {
		// 취소 버튼 클릭 시 수행할 동작
		alert("취소되었습니다.");
	});
});*/
/* ------------------조력자 등재 page  fclttRegist --------------------*/





/* ------------------조력자 등재명단 목록 fclttList --------------------*/

	function loadList(selectedValue) {
		$.ajax({
			url: "fclttListAjax",
			type: "GET",
			data: {
				"searchAccept_act_yn": selectedValue // 검색 조건을 파라미터로 보내기
			},

			success: function (data) {
				var tbody = $("#fclttListId");
				tbody.empty(); // 테이블 내용 초기화

				for (var i = 0; i < data.length; i++) {
					var vo = data[i];
					var str = "";
					str += '<tr>';
					str += '<td data-cell-header="번호">' + (i + 1) + '</td>';
					str += '<td data-cell-header="민원서식명">' + vo.trial_fcltt_description + '</td>';
					str += '<td data-cell-header="법원명">' + vo.court_name + '</td>';
					str += '<td data-cell-header="이름">' + vo.user_name + '</td>';
					str += '<td data-cell-header="날짜">' + vo.accept_date + '</td>';
					str += '<td onclick="modalCont()" class="modal_ajax">';
					str += '<input type="hidden" class="find1" name="accept_proper_num" value="' + vo.accept_proper_num + '" />';
					str += '<input type="hidden" class="find2" name="user_proper_num" value="' + vo.user_proper_num + '" />';
					str += '<a class="fcltt_content" style="cursor: pointer"><em>상세보기</em></a></td>';
					str += '<td><a class="' + (vo.accept_act_yn == 'Y' ? 'fclttStatus1' : 'fclttStatus2') + '">';
					str += '<em>' + (vo.accept_act_yn == 'Y' ? '활동중' : '중지중') + '</em></a></td>';
					str += '</tr>';

					// 표에 행 추가
					tbody.append(str);
				}
			}
		});
	}

	// 페이지 로드 시 목록을 불러옵니다.
	loadList();


	// 페이징 AJAX
	function loadPaging() {
		$.ajax({
			url: "fclttTotal",
			type: "GET",
			success: function (data) {
				// data를 JavaScript 변수로 할당
				var FclttPageVO = data;
				var pager = $(".pager");
				var str2 = '<div class="pager-wrap">';

				if (FclttPageVO.pageList.length > 1) {
					str2 += '<a href="/fcltt/fclttList?page=1&amount=' + FclttPageVO.amount +
						'&searchAccept_act_yn=' + FclttPageVO.cri.searchAccept_act_yn +
						'&searchUser_name=' + FclttPageVO.cri.searchUser_name +
						'&searchAct=' + FclttPageVO.cri.searchAct +
						'&searchDate=' + FclttPageVO.cri.searchDate +
						'&searchCourt=' + FclttPageVO.cri.searchCourt +
						'&searchCourtName=' + FclttPageVO.cri.searchCourtName +
						'&searchContent=' + FclttPageVO.cri.searchContent + '"><strong class="sr-only">맨 처음 목록으로 이동</strong></a>';
				}
				if (FclttPageVO.pageList.length > 1 && FclttPageVO.prev) {
					str2 += '<a href="/fcltt/fclttList?page=' + (FclttPageVO.start - 1) +
						'&amount=' + FclttPageVO.amount +
						'&searchAccept_act_yn=' + FclttPageVO.cri.searchAccept_act_yn +
						'&searchUser_name=' + FclttPageVO.cri.searchUser_name +
						'&searchAct=' + FclttPageVO.cri.searchAct +
						'&searchDate=' + FclttPageVO.cri.searchDate +
						'&earchCourt=' + FclttPageVO.cri.searchCourt +
						'&searchCourtName=' + FclttPageVO.cri.searchCourtName +
						'&searchContent=' + FclttPageVO.cri.searchContent + '"><strong class="sr-only">이전페이지로 이동</strong></a>';
				}
				for (var i = 0; i < FclttPageVO.pageList.length; i++) {
					var page = FclttPageVO.pageList[i];
					str2 += '<a href="/fcltt/fclttList?page=' + page +
						'&amount=' + FclttPageVO.amount +
						'&searchAccept_act_yn=' + FclttPageVO.cri.searchAccept_act_yn +
						'&searchUser_name=' + FclttPageVO.cri.searchUser_name +
						'&searchAct=' + FclttPageVO.cri.searchAct +
						'&searchDate=' + FclttPageVO.cri.searchDate +
						'&searchCourt=' + FclttPageVO.cri.searchCourt +
						'&searchCourtName=' + FclttPageVO.cri.searchCourtName +
						'&searchContent=' + FclttPageVO.cri.searchContent + '" ';
					if (page == FclttPageVO.page) {
						str2 += 'class="active"';
					}

					str2 += '>' + page + '</a>';
				}
				if (FclttPageVO.pageList.length > 1 && FclttPageVO.next) {
					str2 += '<a href="/fcltt/fclttList?page=' + (FclttPageVO.end + 1) +
						'&amount=' + FclttPageVO.amount +
						'&searchAccept_act_yn=' + FclttPageVO.cri.searchAccept_act_yn +
						'&searchUser_name=' + FclttPageVO.cri.searchUser_name +
						'&searchAct=' + FclttPageVO.cri.searchAct +
						'&searchDate=' + FclttPageVO.cri.searchDate +
						'&searchCourt=' + FclttPageVO.cri.searchCourt +
						'&searchCourtName=' + FclttPageVO.cri.searchCourtName +
						'&searchContent=' + FclttPageVO.cri.searchContent + '"><strong class="sr-only">다음페이지로 이동</strong></a>';
				}
				if (FclttPageVO.pageList.length > 1) {
					str2 += '<a href="/fcltt/fclttList?page=' + FclttPageVO.realEnd +
						'&amount=' + FclttPageVO.amount +
						'&searchCourt=' + FclttPageVO.cri.searchCourt +
						'&searchCourtName=' + FclttPageVO.cri.searchCourtName +
						'&searchAct=' + FclttPageVO.cri.searchAct +
						'&searchDate=' + FclttPageVO.cri.searchDate +
						'&searchCourt=' + FclttPageVO.cri.searchCourt +
						'&searchCourtName=' + FclttPageVO.cri.searchCourtName +
						'&searchContent=' + FclttPageVO.cri.searchContent + '"><strong class="sr-only">맨 마지막목록으로 이동</strong></a>';
				}
				str2 += '</div>';
				// 표에 행 추가
				pager.empty().append(str2);
			}
		});
	}

	// 페이지 로드 시 페이징을 불러옵니다.
	loadPaging();

	;


	//모달창 ajax
	function modalCont() {
		var closestTr = event.target.closest(".modal_ajax");
		var accept_proper_num = $(closestTr).find("input[name='accept_proper_num']").val();
		var user_proper_num = $(closestTr).find("input[name='user_proper_num']").val();

		$.ajax({
			type: "POST",
			url: "getfclttModal",
			data: {
				"accept_proper_num": accept_proper_num,
				"user_proper_num": user_proper_num
			},
			success: function (fclttData) {
				var modal = $("#popup_layer2");
				modal.css("display", "block");

				var content1 = fclttData.content1;
				var content2 = fclttData.content2;
				var content3 = fclttData.content3;
				var content4 = fclttData.content4;
				var content5 = fclttData.content5;

				var str = '<div class="popup_cont2" style="overflow: hidden;">';
				str += '<div class="popup_cont2_title">';
				str += '<p>조력자 상세정보</p>';
				str += '</div>';
				str += '<div class="popup_contText">';
				str += '<h3 id="fcltt_h3">재판조력자</h3>';
				str += '<h2 id="fcltt_h2">' + content1.user_name + '</h2>';
				str += '<h3 id="fcltt_h3">현재활동상태 : ' + (content1.accept_act_yn == "Y" ? '활동중' : '중지중') + '</h3>';
				str += '<p id="fcltt_p_right">등재번호: ' + content1.accept_proper_num + '</p>';
				str += '</div>';
				str += '<div class="fcltt_cont_top" style="width: 50%; float:left;">';
				str += '<table>';
				str += '<colgroup>';
				str += '<col style="width: 30%" />';
				str += '<col style="width: 70%" />';
				str += '</colgroup>';
				str += '<tbody>';
				str += '<tr>';
				str += '<th>조력자분류</th>';
				str += '<td>' + content1.trial_fcltt_clasifi_code + '>' + content1.trial_fcltt_description + '</td>';
				str += '</tr>';
				str += '<tr>';
				str += '<th>법원</th>';
				str += '<td>' + content1.court_region + '>' + content1.court_name + '</td>';
				str += '</tr>';
				str += '</tbody>';
				str += '</table>';
				str += '</div>';
				str += '<div class="fcltt_cont_top" style="width: 50%; float:right;">';
				str += '<h3></h3>';
				str += '<table>';
				str += '<colgroup>';
				str += '<col style="width: 30%" />';
				str += '<col style="width: 70%" />';
				str += '</colgroup>';
				str += '<tbody>';
				str += '<tr>';
				str += '<th>휴대전화</th>';
				str += '<td>' + content1.user_phone + '</td>';
				str += '</tr>';
				str += '<tr>';
				str += '<th>이메일</th>';
				str += '<td>' + content1.user_email_f + '@' + content1.user_email_b + '</td>';
				str += '</tr>';
				str += '</tbody>';
				str += '</table>';
				str += '</div>';
				str += '<div class="fcltt_cont_left" style="width: 48%; float: left;">';
				str += '<h3>학력정보</h3>';
				str += '<table>';
				str += '<colgroup>';
				str += '<col style="width: 40%" />';
				str += '<col style="width: 40%" />';
				str += '<col style="width: 20%" />';
				str += '</colgroup>';
				str += '<thead>';
				str += '<tr style="border-bottom: 1px solid #777;">';
				str += '<th scope="col">학교</th>';
				str += '<th scope="col">전공</th>';
				str += '<th scope="col">학위</th>';
				str += '</tr>';
				str += '</thead>';
				str += '<tbody>';


				//학력정보 반복문으로 적기
				var str2 = "";
				for (var i = 0; i < fclttData.content2.length; i++) {
					var vo = fclttData.content2[i]; // 각 학력 정보 객체

					str2 += '<tr>';
					str2 += '<td data-cell-header="번호">' + vo.edctn_school_name + '</td>';
					str2 += '<td data-cell-header="민원서식명">' + vo.edctn_major + '</td>';
					str2 += '<td data-cell-header="법원명">' + vo.edctn_degree + '</td>';
					str2 += '</tr>';
				}

				str += str2;
				str += '</tbody>';
				str += '</table>';
				str += '</div>';
				str += '<div class="fcltt_cont_left" style="width: 48%; float: right;">';
				str += '<h3>참여재판이력</h3>';
				str += '<table>';
				str += '<colgroup>';
				str += '<col style="width: 20%" />';
				str += '<col style="width: 60%" />';
				str += '<col style="width: 20%" />';
				str += '</colgroup>';
				str += '<thead>';
				str += '<tr style="border-bottom: 1px solid #777;">';
				str += '<th scope="col">재판번호</th>';
				str += '<th scope="col">출석일자</th>';
				str += '<th scope="col">완료여부</th>';
				str += '</tr>';
				str += '</thead>';
				str += '<tbody>';
				//재판이력 반복문으로 적기
				var str2 = "";
				for (var i = 0; i < fclttData.content3.length; i++) {
					var vo = fclttData.content3[i];

					str2 += '<tr>';
					str2 += '<td data-cell-header="번호">' + vo.trial_num + '</td>';
					str2 += '<td data-cell-header="민원서식명">' + (vo.attendance_date === null ? '미정 또는 미참석' : vo.attendance_date) + '</td>';
					str2 += '<td data-cell-header="법원명">' + (vo.act_complete_yn == 'Y' ? '완료' : '진행중') + '</td>';
					str2 += '</tr>';
				}
				str += str2;
				str += '</tbody>';
				str += '</table>';
				str += '</div>';
				str += '<div class="fcltt_cont_left" style="width: 48%; float: left;">';
				str += '<h3>자격증정보</h3>';
				str += '<table>';
				str += '<colgroup>';
				str += '<col style="width: 50%" />';
				str += '<col style="width: 50%" />';
				str += '</colgroup>';
				str += '<thead>';
				str += '<tr style="border-bottom: 1px solid #777;">';
				str += '<th scope="col">자격증명</th>';
				str += '<th scope="col">발급기관</th>';
				str += '</tr>';
				str += '</thead>';
				str += '<tbody>';
				//자격증명 반복문으로 적기
				var str2 = "";
				for (var i = 0; i < fclttData.content4.length; i++) {
					var vo = fclttData.content4[i];
					str += '<tr>';
					str += '<td>' + vo.crtfc_type + '</td>';
					str += '<td>' + vo.issue_agency + '</td>';
					str += '</tr>';
				}
				str += str2;
				str += '</tbody>';
				str += '</table>';
				str += '</div>';
				str += '<div class="fcltt_cont_left" style="width: 48%; float: right;">';
				str += '<h3>경력정보</h3>';
				str += '<table>';
				str += '<colgroup>';
				str += '<col style="width: 30%" />';
				str += '<col style="width: 10%" />';
				str += '<col style="width: 40%" />';
				str += '<col style="width: 20%" />';
				str += '</colgroup>';
				str += '<thead>';
				str += '<tr style="border-bottom: 1px solid #777;">';
				str += '<th scope="col">회사명/활동기관</th>';
				str += '<th scope="col">구분</th>';
				str += '<th scope="col">근무기간</th>';
				str += '<th scope="col">부서</th>';
				str += '</tr>';
				str += '</thead>';
				str += '<tbody>';

				//경력내역 반복문으로 적기
				var str2 = "";
				for (var i = 0; i < fclttData.content5.length; i++) {
					var vo = fclttData.content5[i];
					str += '<tr>';
					str += '<td data-cell-header="번호">' + vo.company_name + '</td>';
					str += '<td data-cell-header="민원서식명">' + vo.carer_type + '</td>';
					str += '<td data-cell-header="민원서식명">' + vo.work_start_date + ' ~ ' + vo.work_end_date + '</td>';
					str += '<td data-cell-header="법원명">' + vo.work_department + '</td>';
					str += '</tr>';
				}
				str += str2;

				str += '</tbody>';
				str += '</table>';
				str += '</div>';
				str += '</div>';
				str += '<div class="popup_btn22"><a href="javascript:closePop2();">닫기</a></div>';
				str += '</div>';
				str += '</div>';

				var popupBox = $(".popup_box2");
				popupBox.html(str);
				window.scrollTo(0, 0);
			}
		});

	};


	// 활동여부 onchange fclttChange

	$(document).ready(function () {
		// 페이지 로드 시 목록을 불러옵니다.
		loadList($("#fclttChange").val());

		// 페이지 로드 시 페이징을 불러옵니다.
		loadPaging();

		// 활동여부 onchange 이벤트 핸들러
		$("#fclttChange").change(function () {
			var selectedValue = $(this).val();
			console.log(selectedValue);
			loadList(selectedValue);
			loadPaging();
		});
	});


	//그냥 닫기버튼 스크립트
	function closePop2() {
		document.getElementById("popup_layer2").style.display = "none";
	}



/* ------------------조력자 등재명단 목록 fclttList --------------------*/

//상세보기 스크립트
/*function openPop2(){
	document.getElementById("popup_layer2").style.display = "block";
}*/

//그냥 닫기버튼 스크립트
/*function closePop2() {
	document.getElementById("popup_layer2").style.display = "none";
}*/

/*//--------------------------pause List-----------------------//*/



