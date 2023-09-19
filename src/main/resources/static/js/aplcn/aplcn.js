/**
 * 
 */

 // 리스트에서 검색기능 함수

$(".select_box").on('click', 'a', function(e) {
	e.preventDefault();

	var searchField = $("#searchTitle").val();
	var searchContent = $("#searchContent").val();
	var selectedValue = $("#aplcnChange").val();
	console.log("click함수 실행");
	console.log(searchField);
	console.log(searchContent);
	console.log(aplcnChange);

	loadList(selectedField, searchContent, selectedValue, 1, 10);
});

// 등재명단 리스트 테이블생성 함수
function loadList(selectedField, searchContent, selectedValue, pageNumber, pageSize) {
	console.log("list함수 작동: 시작 "+"selectedField: "+selectedField+", searchContent: "+searchContent+",selectedValue: " + selectedValue+"      ...." + pageNumber+pageSize);
	console.log("fclttListAjax?page=" + pageNumber + "&amount=" + pageSize + "&searchContent=" + searchContent + "&searchContent=" + searchContent + "&searchAccept=" + selectedValue);

	var formData = new FormData();
	formData

	$.ajax({
		url: "fclttListAjax?page=" + pageNumber + "&amount=" + pageSize + "&searchContent2=" + searchContent + "&searchContent=" + searchContent + "&searchAccept=" + selectedValue,

		/*		data: {
					"searchCont": searchCont, // 검색 조건을 파라미터로 보내기
				},
				
		*/
		success: function(data) {
			var tbody = $("#aplcnListId");
			tbody.empty(); // 테이블 내용 초기화

			for (var i = 0; i < data.length; i++) {
				var vo = data[i];
				var str = "";
				str += '<tr>';
				str += '<td data-cell-header="번호">' + (i + 1) + '</td>';
				str += '<td data-cell-header="신청자 상세정보 고유번호">' + vo.user_proper_num + '</td>';
				str += '<td data-cell-header="신청자 이름">' + vo.user_name + '</td>';
				str += '<td data-cell-header="이름">' + vo.trial_fcltt_clasifi_code + '</td>';
				str += '<td data-cell-header="날짜">' + vo.court_name + '</td>';
				str += '<td onclick="modalCont()" class="modal_ajax">';
				str += '<input type="hidden" class="find1" name="accept_proper_num" value="' + vo.accept_proper_num + '" />';
				str += '<input type="hidden" class="find2" name="user_proper_num" value="' + vo.user_proper_num + '" />';
				str += '<a class="fcltt_content" style="cursor: pointer"><em>상세보기</em></a></td>';
				str += '<td><a class="' + (vo.aplicn_dtls_sts == 'Y' ? 'fclttStatus1' : 'fclttStatus2') + '">';
				str += '<em>' + (vo.aplicn_dtls_sts == 'Y' ? '활동중' : '중지중') + '</em></a></td>';
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
					str2 += '<a href="#" data-page-action="last"  class="arr last" ></a>';
				}

				str2 += '</div>';

				// 표에 행 추가
				pager.empty().append(str2);
			});


		},
	});
}

$(document).ready(function() {
	// 페이지 로드 시 목록을 불러오기
	loadList($("#aplcnChange").val(), $("#selectTit").val("#aplcnSearch_Btn"), $("#").val(), 1, 10);
	// 활동여부 onchange 이벤트 핸들러, 전체, 검색

});