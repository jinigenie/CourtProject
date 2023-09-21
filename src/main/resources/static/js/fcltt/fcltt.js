

////////////////////////////  fclttList.html 조력자 등재명단 page ////////////////////////////////////////////////

//모달창 ajax
function modalCont() {
	var closestTr = event.currentTarget.closest(".modal_ajax");
	var accept_proper_num = $(closestTr).find("input[name='accept_proper_num']").val();
	var user_proper_num = $(closestTr).find("input[name='user_proper_num']").val();
	console.log(closestTr);
	console.log(accept_proper_num);
	console.log(user_proper_num);

	$.ajax({
		type: "POST",
		url: "getfclttModal",
		data: {
			"accept_proper_num": accept_proper_num,
			"user_proper_num": user_proper_num
		},
		success: function(fclttData) {
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
			str += '<h3 id="fcltt_h3">현재활동상태 : ' + (content1.accept_act_yn == 'Y' ? '활동중' : '중지중') + '</h3>';
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
			str += '<tr style="border-bottom: 1px solid #777; border-top:1px solid #777; ">';
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
			str += '<tr style="border-bottom: 1px solid #777; border-top:1px solid #777; ">';
			str += '<th scope="col">재판번호</th>';
			str += '<th scope="col">출석일자</th>';
			str += '<th scope="col">완료여부</th>';
			str += '</tr>';
			str += '</thead>';
			str += '<tbody>'

				;
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
			str += '<tr style="border-bottom: 1px solid #777; border-top:1px solid #777; ">';
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
			str += '<tr style="border-bottom: 1px solid #777; border-top:1px solid #777; ">';
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





// 모달창 닫기버튼 스크립트
function closePop2() {
	document.getElementById("popup_layer2").style.display = "none";
}



// 등재명단 리스트 테이블생성 함수
function loadList(selectedValue, searchContent2, searchCont, pageNumber, pageSize) {

	var formData = new FormData();
	formData

	$.ajax({
		url: "fclttListAjax?page=" + pageNumber + "&amount=" + pageSize + "&searchContent2=" + searchContent2 + "&searchContent=" + searchCont + "&searchAccept_act_yn=" + selectedValue,

		/*		data: {
					"searchCont": searchCont, // 검색 조건을 파라미터로 보내기
				},
				
		*/
		success: function(data) {
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

			// 서버에서 받은 데이터를 반복하여 페이지 링크 생성
			$.each(data, function(index, FclttVO) {
				var pager = $(".pager");
				var str2 = '<div class="pager-wrap">';

				if (FclttVO.fclttPageVO.pageList.length > 1) {
					// 처음 페이지로 이동하는 링크 생성
					str2 += '<a href="#" data-page-action=1 class="arr first" ></a>';
				}
				// 이전 페이지로 이동하는 링크 생성
				if (FclttVO.fclttPageVO.pageList.length > 1 && FclttVO.fclttPageVO.prev) {
					str2 += '<a href="#" data-page-action="prev" class="arr prev"></a>';
				}

				// 페이지 번호를 생성
				for (var i = 0; i < FclttVO.fclttPageVO.pageList.length; i++) {
					var page = FclttVO.fclttPageVO.pageList[i];
					str2 += '<a href="#"';
					if (page == FclttVO.fclttPageVO.page) {
						str2 += 'class="active"';
					}
					str2 += '>' + page + '</a>';
				}

				// 다음 페이지로 이동하는 링크 생성
				if (FclttVO.fclttPageVO.pageList.length > 1 && FclttVO.fclttPageVO.next) {
					str2 += '<a href="#" data-page-action="next" class="arr next" ></a>';
				}

				// 맨 마지막 페이지로 이동하는 링크 생성
				if (FclttVO.fclttPageVO.pageList.length > 1) {
					str2 += '<a href="#" data-page-action="last"  class="arr last" data-total="' + FclttVO.fclttPageVO.total + '"></a>';
				}

				str2 += '</div>';

				// 표에 행 추가
				pager.empty().append(str2);
			});


		},
	});
}

/*
// email보내기
const send = document.querySelector(".send");

send.addEventListener('click', function(e){
    fetch('/email/send', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: 'to=hyem08111@gmail.com&subject=재판조력자로 등재되었습니다.&text=<html><body><h1>김혜민님 축하드립니다</h1><p>지원하신 재판조력자 공고에 합격되어 등재 되셨습니다.<br/> 자세한 내용은 사이트내에 마이페이지에서 확인하실 수 있습니다. <br/>감사합니다</p></body></html>',
    })
    .then(response => response.text())
    .then(data => console.log(data))
    .catch(e => console.log('이메일 전송 실패: ' + e));
});
*/
	// 승인처리 ajax
	/*$(document).on("click", ".pauseResult1, .pauseResult2", function (event) {
		event.preventDefault(); // a 링크의 기본 동작 중지
		var accept_proper_num = $(this).closest("tr").find("input[name='accept_proper_num']").val();
		var accept_act_yn = $(this).hasClass("pauseResult1") ? "Y" : "N";
		var selectedValue = $("#selectedValue").val();
		console.log(accept_act_yn);

		// 여기에 AJAX 요청 코드를 작성합니다.
		$.ajax({
			url: "../pauseResultSubmit", // 요청을 보낼 URL을 지정합니다.
			type: "POST", // HTTP 요청 메서드 (GET 또는 POST)
			data: {
				"accept_proper_num": accept_proper_num,
				"accept_act_yn": accept_act_yn
			},
			success: function (response) {
				// 성공적으로 응답을 받았을 때 실행될 코드를 작성합니다.
				console.log("AJAX 요청 성공");
				// 여기에서 응답 데이터를 처리하거나 필요한 작업을 수행합니다.

				// 목록을 다시 불러오는 AJAX 요청
				// 목록을 다시 불러오는 함수 호출
				pauseList(selectedValue, 1, 10);
				alert("승인되었습니다.");
				
			},
			error: function (xhr, status, error) {
				// AJAX 요청 중 오류가 발생했을 때 실행될 코드를 작성합니다.
				console.error("AJAX 요청 오류: " + error);
			}
		});

	});
	*/


	// 승인처리 ajax
	$(document).on("click", ".pauseResult1, .pauseResult2", function (event) {
		event.preventDefault(); // a 링크의 기본 동작 중지
		var accept_proper_num = $(this).closest("tr").find("input[name='accept_proper_num']").val();
		var accept_act_yn = $(this).hasClass("pauseResult1") ? "Y" : "N";
		var selectedValue = $("#selectedValue").val();
		console.log(accept_act_yn);
		var email = "hyemin0629@naver.com";
		var emailContent = `
    <html>
<body>
	<div class="">
		<div class="aHl"></div>
		<div id=":qa" tabindex="-1"></div>
		<div id=":ts" class="ii gt"
			jslog="20277; u014N:xr6bB; 1:WyIjdGhyZWFkLWY6MTc3NzYwMTc1MTgwNDM3NjEwMiIsbnVsbCxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsW11d; 4:WyIjbXNnLWY6MTc3NzYwMTc1MTgwNDM3NjEwMiIsbnVsbCxbXSxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsbnVsbCxbXSxbXSxbXV0.">
			<div id=":tt" class="a3s aiL ">
				<div class="adM">
				</div>
				<div>
					<div class="adM">
					</div>
					<div
						style="background:#ffffff;margin:0;padding:0;font-family:AppleSDGothicNeo-Regular,Malgun Gothic,'\\00b9d1\\00c740\\00ace0\\00b515','\\00b3cb\\00c6c0',dotum,sans-serif">
						<div class="adM">
						</div>
						<div
							style="background:#ffffff;margin:0 auto;padding:0;width:100%;max-width:600px;letter-spacing:-1px;,box-sizing:border-box">
							<div class="adM">
							</div>
							<table width="100%" style="margin:0;padding:0;max-width:600px" border="0" cellspacing="0"
								cellpadding="0">
								<tbody>
									<tr>
										<td height="12"></td>
									</tr>

									<tr>
										<td style="background:#f6f7fb;border-radius:20px 20px 0 0;padding:0 16px">
											<table width="100%" style="margin:0;padding:0" border="0" cellspacing="0"
												cellpadding="0">
												<tbody>
													<tr>
														<td height="48"></td>
													</tr>
													<tr>
														<td
															style="background:#fff;border-radius:10px;padding:24px 40px 48px">
															<table width="100%"
																style="margin:0;padding:0;border="0" cellspacing="0" cellpadding="0">
																<tbody>
																	<tr>
																		<td align="center"
																			style="padding:0 0 16px;border-bottom:1px solid #dee1ea;color:#222;font-size:20px;font-weight:bold;line-height:24px;letter-spacing:-0.5px">
																			재판조력자 신청결과
																		</td>
																	</tr>
																	<tr>
																		<td style="padding:0;text-align:center">
																			<table width="100%"
																				style="margin:0;padding:0;
																				border="0" cellspacing="0"
																				cellpadding="0">
																				<tbody>
																					<tr>
																						<td align="left"
																							style="margin:0;padding:0">
																							<div
																								style="padding:24px 0 16px;border-bottom:1px solid #dee1ea;color:#222;font-size:13px;line-height:18px">
																								<p
																									style="margin:0;padding:16px 0 0;color:rgb(128, 128, 128);font-size:12px;line-height:18px;letter-spacing:-0.5px;text-align:left">
																									<br /><br />
																									김혜민님<br /><br /><br />
																									지원하신 공고의 평가 결과
																									합격되었습니다.<br /><br />
																									사이트내에<a
																										style="font-size:14px; font-weight: 700; text-decoration: none;color:rgb(128, 128, 128);"
																										href="http://localhost:8585/user/mypage">
																										마이페이지</a>에서 등재
																									여부를
																									확인하실 수
																									있습니다.<br /><br />
																									당신의 뛰어난 능력으로, 재판
																									과정에서 공정성을 유지하는 데
																									기여하실 것을
																									기대합니다.<br /><br />
																									감사합니다.<br /><br /><br />
																								</p>
																							</div>
																						</td>
																					</tr>
																				</tbody>
																			</table>
																		</td>
																	</tr>
																</tbody>
															</table>
														</td>
													</tr>
													<tr>
														<td bgcolor="#8d919e">
															<table style="margin:0;padding:0;width:100%" border="0"
																cellspacing="0" cellpadding="0">
																<tbody>
																	<tr>
																		<td
																			style="margin:0;padding:16px;text-align:left">
																			<p
																				style="margin:0;padding:0;color:#e6e9f2;font-size:11px;line-height:16px;letter-spacing:-1px">

																				<a style="text-decoration: none;color:#e6e9f2;"
																					href="http://localhost:8585/main/main">재판조력자
																					홈페이지<br></a>
																				주소 :서울특별시 강남구 테헤란로 7길 7 재판조력자 서비스센터
																			</p>
																			<p
																				style="margin:0;padding:0;color:#e6e9f2;font-size:11px;line-height:16px;letter-spacing:-1px">
																				Copyright(c)Ministry of Employment and
																				Labor. All rights reserved.</p>
																		</td>
																	</tr>
																	<tr>
																		<td height="48"></td>
																	</tr>
																</tbody>
															</table>
														</td>
													</tr>
												</tbody>
											</table>
						</div>
					</div>
					<img height="0" width="0" border="0"
						src="https://ci6.googleusercontent.com/proxy/H15_w6u57QdeZqZW-zxbDp0YvoJ8AzQnsJVoW18Txn3_u3GRoPKeZ9yg2Atrz-Rh4pdrPi0IB7VkWhjMYkRNrX0eMS7mxJTFLrhxBNRl3AET4h15piDS5-x74BXaUQlWKZi8=s0-d-e1-ft#http://eventmailtrack.saramin.co.kr:80/9I-112635I-41E-8272822389I-4uPmuPzeI-4I-3"
						class="CToWUd" data-bit="iit">
				</div>
				<div class="yj6qo"></div>
				<div class="adL">
				</div>
			</div>
		</div>
		<div id=":tx" class="ii gt" style="display:none">
			<div id=":q6" class="a3s aiL "></div>
		</div>
		<div class="hi"></div>
	</div>
</body>
    </html>
`;
		// 여기에 AJAX 요청 코드를 작성합니다.
		$.ajax({
			url: "../pauseResultSubmit", // 요청을 보낼 URL을 지정합니다.
			type: "POST", // HTTP 요청 메서드 (GET 또는 POST)
			data: {
				"accept_proper_num": accept_proper_num,
				"accept_act_yn": accept_act_yn
			},
			success: function (response) {
				// 성공적으로 응답을 받았을 때 실행될 코드를 작성합니다.
				console.log("AJAX 요청 성공");
				// 여기에서 응답 데이터를 처리하거나 필요한 작업을 수행합니다.

				// 이메일 전송 코드 추가
				// 이메일 전송 코드 추가
				fetch('/email/send', {
					method: 'POST',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded',
					},
					body: `to=${email}&subject=재판조력자평가 결과 안내메일.&text=${encodeURIComponent(emailContent)}`,
				})
					.then(response => response.text())
					.then(data => console.log(data))
					.catch(e => console.log('이메일 전송 실패: ' + e));

				// 목록을 다시 불러오는 AJAX 요청
				// 목록을 다시 불러오는 함수 호출
				pauseList(selectedValue, 1, 10);
				alert("승인되었습니다.");
			},
			error: function (xhr, status, error) {
				// AJAX 요청 중 오류가 발생했을 때 실행될 코드를 작성합니다.
				console.error("AJAX 요청 오류: " + error);
			}
		});
	});

	$(document).ready(function () {
		pauseList($("#selectedValue").val(), 1, 10);

	});



	// 활동준비/ 승인준비 select change 값 별로 정렬
	$("#selectedValue").change(function () {
		var selectedValue = $(this).val();

		pauseList(selectedValue, 1, 10); // pageNumber와 pageSize를 직접 지정
	});

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////