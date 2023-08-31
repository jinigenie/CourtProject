/*	ComLib.pagination = function(textSelector, objPaginationInfo, textPageFunction) {
	objPaginationInfo = objPaginationInfo || {};
	if (objPaginationInfo.totalRecordCount) {
		$(textSelector).html(''.concat(
				'<a href="javascript:' + textPageFunction + '(' + objPaginationInfo.firstPageNo + ');" class="first" title="처음 목록"><i class="split"></i></a>'
				, '<a href="javascript:' + textPageFunction + '(' + (objPaginationInfo.firstPageNoOnPageList > objPaginationInfo.firstPageNo ? objPaginationInfo.firstPageNoOnPageList - 1 : objPaginationInfo.firstPageNo) + ');" class="prev" title="이전 목록"><i class="split"></i></a>'));
		for (var i = objPaginationInfo.firstPageNoOnPageList; i <= objPaginationInfo.lastPageNoOnPageList; i++) {
			if (i == objPaginationInfo.currentPageNo) {
				$('<a href="javascript:;" class="active" title="' + i + ' 페이지">' + i + '</a>').appendTo(textSelector);
			} else {
				$('<a href="javascript:' + textPageFunction + '(' + i + ');" title="' + i + ' 페이지">' + i + '</a>').appendTo(textSelector);
			}
		}
		$(textSelector).append(''.concat(
				'<a href="javascript:' + textPageFunction + '(' + (objPaginationInfo.lastPageNoOnPageList >= objPaginationInfo.lastPageNo ? objPaginationInfo.lastPageNo : objPaginationInfo.lastPageNoOnPageList + 1) + ');" class="next" title="다음 목록"><i class="split"></i></a>'
				, '<a href="javascript:' + textPageFunction + '(' + objPaginationInfo.lastPageNo + ');" class="last" title="마지막 목록"><i class="split"></i></a>'));
	} else {
		$(textSelector).html(''.concat(
				'<a href="javascript:;" class="first" title="처음 목록"><i class="split"></i></a>'
				, '<a href="javascript:;" class="prev" title="이전 목록"><i class="split"></i></a>'
				, '<a href="javascript:;" class="next" title="다음 목록"><i class="split"></i></a>'
				, '<a href="javascript:;" class="last" title="마지막 목록"><i class="split"></i></a>'));
	}
	if ($(textSelector).data("focusClass")) {
		$(textSelector).find("." + $(textSelector).data("focusClass"))[0].focus();
		$(textSelector).removeData("focusClass");
	}
	$(textSelector).off("click", "a").on("click", "a", function(e) {
		if (this.href == "javascript:;") {
			return;
		}
		$(textSelector).data("focusClass", $(this).prop("class") || "active");
	});

};
	
	
	 사업소개 
	intro = {
		accordion: function () {
			var $accordion = $(".accordion");
			var $accobutton = $accordion.find("button");
			var $accopanel = $accordion.find(".accopanel");

			$accobutton.on("click", function(){
				if(!$(this).hasClass("active")) {
					$accobutton.removeClass("active").attr('title', '축소됨');
					$accopanel.slideUp(150);
					$(this).addClass("active").attr('title', '확장됨').parent().next().slideDown(150);
				}
			});
		}
	}*/
	
	
	
document.addEventListener("DOMContentLoaded", function() {
    var listItems = document.querySelectorAll(".faqList");

    listItems.forEach(function(item) {
      item.addEventListener("click", function() {
        var panel = this.querySelector(".accopanel");
        if (panel.style.display === "block") {
          panel.style.display = "none";
        } else {
          panel.style.display = "block";
        }
      });
    });
  });
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	