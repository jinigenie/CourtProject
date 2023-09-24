

/* faq list 불러오기 */

function faqList(page, amount, content1, content2) {

	var formData = new FormData();
	formData
	// 현재 페이지의 URL에서 쿼리 매개변수를 가져옵니다.
	var queryString = window.location.search;
	var urlParams = new URLSearchParams(queryString);

	// divVal 값을 가져옵니다.
	var divVal = urlParams.get('divVal');
	/*	console.log(divVal);*/

	$.ajax({
		url: "faqListAjax?page=" + page + "&amount=" + amount + "&searchContent=" + content1 + "&searchContent2=" + content2,

		success: function(data) {
			var li = $("#faqAccordion");
			li.empty();
			var strong = $(".color_orange");
			strong.empty();

			for (var i = 0; i < data.length; i++) {
				var vo = data[i];
				var str = "";

				str += '<li onclick="faqToggle(this)"  class="faqList list-item" value="' + vo.faq_proper_num + '">';
				str += '<h5 ><button type="button" id="header1" aria-controls="pane11" style=" border: none; outline: none;" title="축소됨" class="">';
				str += '<abbr title="Question">Q.</abbr>';
				str += '<span id="faq_question" style="font-size: 17px;font-weight: 800; color:#808080;">' + vo.faq_ask_content + '</span>';
				str += '    <!--  ============  관리자로그인 일떄만 보여지는 버튼  ===============  -->';
				str += '    <button type="button"  class="faq_modify_btn1" onclick="faqRegist(' + vo.faq_proper_num + ')">수정</button>';
				str += '    <button type="button"  class="faq_modify_btn2" onclick="faqDel(' + vo.faq_proper_num + ')">삭제</button>';
				str += '    <!--   \=============================================== \--></div></h5>';
				str += ' <div id="pane11" class="accopanel" aria-labelledby="header1" style ="display:' + (vo.faq_proper_num == divVal ? 'block' : 'none') + ';">';
				str += '<abbr title="Answer">A.</abbr><p></p>';
				str += '<p>' + vo.faq_ask_comment + '<br></p><br><br><p style="text-align:right; font-size:13px;">등록자: ' + vo.admin_name + ', 등록일: ' + vo.faq_ask_date + '</p></div><br/></li>';

				li.append(str);
			}

			// FAQ 아이템을 모두 생성한 후에 사용자 권한에 따라 버튼을 설정
			userHasAdminRole();

			// 서버에서 받은 데이터를 반복하여 페이지 링크 생성
			$.each(data, function(index, FaqVO) {
				var pager = $(".pager");
				var str2 = '<div class="pager-wrap">';
				strong.html(FaqVO.fclttPageVO.total);
				if (FaqVO.fclttPageVO.pageList.length > 1) {
					// 처음 페이지로 이동하는 링크 생성
					str2 += '<a href="#" data-page-action=1 class="arr first" ></a>';
				}
				// 이전 페이지로 이동하는 링크 생성
				if (FaqVO.fclttPageVO.pageList.length > 1 && FaqVO.fclttPageVO.prev) {
					str2 += '<a href="#" data-page-action="prev" class="arr prev"></a>';
				}

				// 페이지 번호를 생성
				for (var i = 0; i < FaqVO.fclttPageVO.pageList.length; i++) {
					var page = FaqVO.fclttPageVO.pageList[i];
					str2 += '<a href="#"';
					if (page == FaqVO.fclttPageVO.page) {
						str2 += 'class="active"';
					}
					str2 += '>' + page + '</a>';
				}

				// 다음 페이지로 이동하는 링크 생성
				if (FaqVO.fclttPageVO.pageList.length > 1 && FaqVO.fclttPageVO.next) {
					str2 += '<a href="#" data-page-action="next" class="arr next" ></a>';
				}

				// 맨 마지막 페이지로 이동하는 링크 생성
				if (FaqVO.fclttPageVO.pageList.length > 1) {
					str2 += '<a href="#" data-page-action="last"  class="arr last" ></a>';
				}

				str2 += '</div>';

				// 표에 행 추가
				pager.empty().append(str2);

			});
		}

	});

}




function faqToggle(clickedItem) {
	var accopanel = clickedItem.querySelector(".accopanel");
	if (accopanel.style.display === "none" || accopanel.style.display === "") {
		accopanel.style.display = "block";
	} else {
		accopanel.style.display = ""
		accopanel.style.display = "none";
	}
}


function faqRegist(faq_proper_num) {
	window.location.href = '/faq/modify?faq_proper_num=' + faq_proper_num;

}
function faqDel(faq_proper_num) {
	var result = confirm("삭제 하시겠습니까");

	if (result) {
		window.location.href = '/faq/faqDel?faq_proper_num=' + faq_proper_num;
		alert("삭제되었습니다.");
	} else {
		alert("취소되었습니다.");
	}

}


// 권한에 따라 버튼을 숨김 또는 표시
function userHasAdminRole() {
	// 사용자 권한 정보를 가져옴
	var userRole = $("#userRole").text().trim(); // trim()으로 앞뒤 공백 제거
	console.log(userRole);

	// 모든 FAQ 아이템에 대해 반복문 수행
	$(".faqList").each(function(index, element) {
		var btn1 = element.querySelector(".faq_modify_btn1");
		var btn2 = element.querySelector(".faq_modify_btn2");

		// 사용자 권한 정보와 'ROLE_SUPERADMIN'을 비교하여 버튼 표시 여부 결정
		if (userRole == "[ROLE_SUPERADMIN]") {
			console.log("if 구문");
			btn1.style.display = "line-block";
			btn2.style.display = "line-block";
		} else {
			console.log("else 구문");
			btn1.style.display = "none";
			btn2.style.display = "none";
		}
	});
}


// 페이징
$(".pager").on('click', 'a', function(e) {
	e.preventDefault();
	var pageAction = $(this).data('page-action');
	var pageUnit = $("#pageUnit").val();
	var srchTycd = $("#srchTycd").val();
	var srchKwrd = $("#srchKwrd").val();


	var currentPage = ($(".pager a.active").text());
	if (pageAction === 1) {
		// 맨 처음 페이지로 이동하는 동작 수행
		faqList(1, pageUnit, srchTycd, srchKwrd);
	} else if (pageAction === 'prev') {
		// 이전 페이지로 이동하는 동작 수행
		var currentPage = ($(".pager a.active").text());
		if (currentPage > 1) {
			faqList(currentPage - 1, pageUnit, srchTycd, srchKwrd);
		}
	} else if (pageAction === 'next') {
		// 다음 페이지로 이동하는 동작 수행
		var currentPage = ($(".pager a.active").text());
		if (currentPage < totalPages) {
			faqList(currentPage + 1, pageUnit, srchTycd, srchKwrd);
		}
	} else if (pageAction === 'last') {
		var totalPages = parseInt($(".pager a:last").prev().text()); // 맨 마지막 페이지 번호
		faqList(totalPages, pageUnit, srchTycd, srchKwrd);
	} else {
		// 페이지 번호를 클릭한 경우
		var pageNumber = $(this).text();
		// 페이지 번호를 사용하여 데이터를 불러오는 동작 수행
		faqList(pageNumber, pageUnit, srchTycd, srchKwrd);
	}
});

$("#pageUnit").change(function() {
	var pageUnit = $(this).val();
	faqList(1, $("#pageUnit").val(), $("#srchTycd").val(), $("#srchKwrd").val());
});


// 검색기능 함수
function faqSearchBtn() {
	var pageUnit = $("#pageUnit").val();
	var srchTycd = $("#srchTycd").val();
	var srchKwrd = $("#srchKwrd").val();
	faqList(1, pageUnit, srchTycd, srchKwrd);
}
// enter키로 조회 버튼 
$("#srchKwrd").on("keydown", function(event) {
	if (event.key === "Enter") {
		event.preventDefault(); // 폼의 기본 동작을 막음
		var pageUnit = $("#pageUnit").val();
		var srchTycd = $("#srchTycd").val();
		var srchKwrd = $("#srchKwrd").val();
		faqList(1, pageUnit, srchTycd, srchKwrd);
	}
});

//검색된것 초기화 하기
function faqSearchBtn2() {
	var pageUnit = $("#pageUnit").val();
	var srchTycd = $("#srchTycd").val();
	var srchKwrd = $("#srchKwrd").val();
	faqList(1, pageUnit, '', '');
}



