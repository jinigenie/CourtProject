


/* faq 수정화면으로 이동하기  */

function faqRegist() {
	location.href = "/faq/regist";
}




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
			// 현재 페이지의 URL에서 쿼리 매개변수를 가져옵니다.


			for (var i = 0; i < data.length; i++) {
				var vo = data[i];
				var str = "";

				str += '<li onclick="faqToggle(this)"  class="faqList list-item" value="' + vo.faq_proper_num + '">';
				str += '<h5 ><button type="button" id="header1" aria-controls="pane11" style=" border: none; outline: none;" title="축소됨" class="">';
				str += '<abbr title="Question">Q.</abbr>';
				str += '<span id="faq_question" style="font-size: 20px;font-weight: 500;">' + vo.faq_ask_content + '</span>';
				str += '	<!--  ============  관리자로그인 일떄만 보여지는 버튼  ===============  -->';
				str += '	<button type="button" onclick="faqRegist(' + vo.faq_proper_num + ')" class="faq_modify_btn1">수정</button>';
				str += '	<button type="button" onclick="faqDel(' + vo.faq_proper_num + ')" class="faq_modify_btn2">삭제</button>';
				str += '	<!--   \=============================================== \--></h5>';
				str += ' <div id="pane11" class="accopanel" aria-labelledby="header1" style ="display:' + (vo.faq_proper_num == divVal ? 'block' : 'none') + ';">';
				str += '<abbr title="Answer">A.</abbr><p></p>';
				str += '<p>' + vo.faq_ask_comment + '<br></p><p></p></div></li>';

				li.append(str);

			}


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













