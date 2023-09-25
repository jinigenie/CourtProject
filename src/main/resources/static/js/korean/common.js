/*-------------------------------------------------
Author      :parkgahye
Create date :2020-07-27
-------------------------------------------------*/

var hasAllMenuFunctionDone = false; // 2020.10.22 "..._Q.jsp"에서 allMenu()함수의 3번 호출을 방지한다.
$(document).ready(function() {
	thumbResize(); //img resize
	relateSiteSlide(); //관련기관 더보기
	selectDesign(); //select Custom
	if (!hasAllMenuFunctionDone)  // 2020.10.22
		allMenu(); //allmen

	$(window).trigger("resize");

	/* *********************************************************************************
	 * for action
	 * *********************************************************************************/
	setTimeout(function() {
		$("body").addClass("start");
	}, 100);

	/* *********************************************************************************
	 * header gnb fixed
	 * *********************************************************************************/
	var headerOffset = $("#header").offset();
	if ($(document).scrollTop() > (headerOffset.top + 100)) {
		$('body').addClass("header-fixed");
	} else {
		$('body').removeClass("header-fixed");
	}
	$(window).scroll(function() {
		if ($(document).scrollTop() > (headerOffset.top + 100)) {
			$('body').addClass("header-fixed");
		} else {
			$('body').removeClass("header-fixed");
		}
	});

	/* *********************************************************************************
	 * t-side
	 * *********************************************************************************/
	$("#header .t-side ul.t-side-left > li > a").on("click mouseenter focusin", function() {
		$(this).parent().addClass("active").siblings().removeClass("active");
	});
	$("#header .t-search-btn").on("click", function() {
		$("#header").toggleClass("t-search-btn-active").removeClass("allmenu-active");
	});
	$("#header .t-total-search-wrap button").on("click focusout", function() {
		$("#header").removeClass("t-search-btn-active");
	});
	$("#header .t-total-search-wrap button").on("focusout", function() {
		$("#header").removeClass("t-search-btn-active");
	});
	$(".t-total-search-wrap").on("mouseleave", function() {
		$("#header").removeClass("t-search-btn-active");
	});

	/* *********************************************************************************
	 * allmenu
	 * *********************************************************************************/
	$(".allmenu-gnav-wrap").mCustomScrollbar({
		theme: "minimal-dark",
		mouseWheelPixels: 500
	});
	$("#allmenu .allmenu-bg").click(function() {
		$("body").removeClass("allmenu-active");
	});

	/* *********************************************************************************
	 * gnb
	 * *********************************************************************************/
	$("#gnb .th1 > a").on("click mouseenter focusin", function() {
		$(this).parent().addClass("active").siblings().removeClass("active");
		$("#header").addClass("gnb-active");
	});
	$("#gnb .th1:first-of-type > a").on("click mouseenter focusin", function() {
		$("#header").removeClass("gnb-active2");
		$("#header").removeClass("gnb-active3");
		$("#header").removeClass("gnb-active4");
		$("#header").addClass("gnb-active1");
	});
	$("#gnb .th1:nth-of-type(2) > a").on("click mouseenter focusin", function() {
		$("#header").removeClass("gnb-active1");
		$("#header").removeClass("gnb-active3");
		$("#header").removeClass("gnb-active4");
		$("#header").addClass("gnb-active2");
	});
	$("#gnb .th1:nth-of-type(3) > a").on("click mouseenter focusin", function() {
		$("#header").removeClass("gnb-active1");
		$("#header").removeClass("gnb-active2");
		$("#header").removeClass("gnb-active4");
		$("#header").addClass("gnb-active3");
	});
	$("#gnb .th1:nth-of-type(4) > a").on("click mouseenter focusin", function() {
		$("#header").removeClass("gnb-active1");
		$("#header").removeClass("gnb-active2");
		$("#header").removeClass("gnb-active3");
		$("#header").addClass("gnb-active4");
	});
	$("#gnb .th1:last-of-type >.depth2 > li:last-of-type > a").on("focusout", function() {
		$("#header").removeClass("gnb-active");
		$("#header").removeClass("gnb-active1");
		$("#header").removeClass("gnb-active2");
		$("#header").removeClass("gnb-active3");
		$("#header").removeClass("gnb-active4");
	});
	$("#gnb").on("mouseleave", function() {
		$("#header").removeClass("gnb-active");
		$("#header").removeClass("gnb-active1");
		$("#header").removeClass("gnb-active2");
		$("#header").removeClass("gnb-active3");
		$("#header").removeClass("gnb-active4");
	});
	$("#gnb .th1 > a").on("click mouseenter focusin", function() {
		$(this).parent().addClass("active").siblings().removeClass("active");
		$("#header").addClass("gnb-active");
	});

	/* *********************************************************************************
	 * footer
	 * *********************************************************************************/
	$(".direct-link-wrap dt > a").on("click", function() {
		$(this).parent().toggleClass("fold");
		$(".direct-lst").slideToggle(300);

		$("#footer .familysite-wrap dt").removeClass("fold");
		$(".family-site").slideUp(300);
	});

	/* *********************************************************************************
	 * top button
	 * *********************************************************************************/
	$(".top-btn").hide(); // 탑 버튼 숨김 - 이걸 빼면 항상 보인다.

	$(window).scroll(function() {
		if ($(this).scrollTop() > 100) { // 스크롤 내릴 표시
			$('.top-btn').fadeIn();
		} else {
			$('.top-btn').fadeOut();
		}
	});

	$('.top-btn').click(function() {
		$('body,html').animate({
			scrollTop: 0 //탑 설정 클수록 덜올라간다
		}, 1000); // 탑 이동 스크롤 속도를 조절할 수 있다.
		return false;
	});

	/* *********************************************************************************
	 * scroll custom
	 * *********************************************************************************/
	$(".share-btn").on("click", function() {
		$("body").toggleClass("share-active");
	});

	/* *********************************************************************************
	 * scroll custom
	 * *********************************************************************************/
	$(".scroll-wrap").mCustomScrollbar({
		axis: "y",
		advanced: {
			autoExpandHorizontalScroll: true
		},
		theme: "minimal-dark",
		mouseWheelPixels: 300
	});

	//table
	// $(".table > table td.subject").on("mouseenter", function() {
	//   $(this).parents("tr").addClass("focus").siblings().removeClass("focus");
	// });
	// $(".table > table td.subject").on("mouseleave", function() {
	//   $(this).parents("tr").removeClass("focus");
	// });
	// $(".table-fixed tbody").mCustomScrollbar({
	//   axis: "y",
	//   advanced: {
	//     autoExpandHorizontalScroll: true
	//   },
	//   theme: "minimal-dark",
	//   mouseWheelPixels: 300
	// });

	/* *********************************************************************************
	 *  input focus
	 * *********************************************************************************/
	$(".input-wrap input").focus(function() {
		$(this).parent().addClass("focus");
	});
	$(".input-wrap input").focusout(function() {
		$(this).parent().removeClass("focus");
	});
	/* *********************************************************************************
	 *  textarea focus
	 * *********************************************************************************/
	$(".input-wrap textarea").focus(function() {
		$(this).parent().addClass("focus");
	});
	$(".input-wrap textarea").focusout(function() {
		$(this).parent().removeClass("focus");
	});



	$('img[src$="dot_y.gif"]').each(function(index, item) {
		if ($(item).next().prop('tagName') != 'LABEL') {
			$(item).after('<label>');
			$(item).parent().append('</label>');
		};
	});
});

$(window).resize(function() {
	/* *********************************************************************************
	 *  for	menu responsive
	 * *********************************************************************************/
	if ($(window).width() <= 1024) {
		$(".allmenu-gnavigation > li > a").attr("href", "javascript:void(0);");
		$("#header #gnb .th1 > a").attr("href", "javascript:void(0);");

		$("#header #gnb .th1 > a").click(function() {
			$("body").addClass("allmenu-active");
		});
	}
	/* *********************************************************************************
	 *	관할서 찾기
	 * *********************************************************************************/
	if ($(window).width() > 480) {
		$("#directLink").css("display", "block");

	} else if ($(window).width() <= 480) {
		$("#directLink").css("display", "none");

		$("#footer .familysite-wrap dt > a").on("click", function() {
			$(".direct-link-wrap dt").removeClass("fold");
			$(".direct-lst").slideUp(300);
		});
	}

});

/* *********************************************************************************
 *	scroll 상단으로.
 * *********************************************************************************/

function scrollToTop() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}



/* *********************************************************************************
 *	layerPopup
 * *********************************************************************************/
function view_layer(name) {
	document.getElementById(name).classList.add('active');
}

function close_layer(name) {
	document.getElementById(name).classList.remove('active');
}

/* *********************************************************************************
 *	img resize
 * *********************************************************************************/
var thumbResize = function() {
	var divs = document.querySelectorAll(".imgcut .img");
	for (var i = 0; i < divs.length; ++i) {
		var div = divs[i];
		var divAspect = div.offsetHeight / div.offsetWidth;
		div.style.overflow = 'hidden';

		var img = div.querySelector(".imgcut .img > img");
		var imgAspect = img.height / img.width;

		if (imgAspect <= divAspect) {
			// 이미지가 div보다 납작한 경우 세로를 div에 맞추고 가로는 잘라낸다
			var imgWidthActual = div.offsetHeight / imgAspect;
			var imgWidthToBe = div.offsetHeight / divAspect;
			var marginLeft = -Math.round((imgWidthActual - imgWidthToBe) / 2)
			img.style.cssText = 'width: auto; height: 100%;'
		} else {
			// 이미지가 div보다 길쭉한 경우 가로를 div에 맞추고 세로를 잘라낸다
			img.style.cssText = 'width: 100%; height: auto;';
		}
	}
}

/* *********************************************************************************
 *	관련기관 더보기
 * *********************************************************************************/
function relateSiteSlide() {
	var relate_param = $(".familysite-wrap");
	var relate_obj = relate_param.find(".family-site");
	var relate_btn = relate_param.find("dt > a");
	setTimeout(function() { }, 100);
	relate_obj.hide();
	relate_btn.on("click", function(event) {
		event.preventDefault();

		var t = $(this);
		t.parent().toggleClass("fold");
		if (t.parent().next('.family-site').css("display") == "none") {
			relate_btn.parent().removeClass("fold");
			t.parent().addClass("fold");
			relate_obj.stop(true, true).slideUp(300);
			t.parent().next('.family-site').stop(true, true).slideDown(300);
		} else {
			t.parent().next('.family-site').stop(true, true).slideUp(300);
		}
		return false;
	});
	relate_param.parent().on("mouseleave", function(event) {
		event.preventDefault();
		relate_btn.parent().removeClass("fold");
		relate_obj.stop(true, true).slideUp(300);
	});
}

/* *********************************************************************************
 *	팝업창 가운데 정렬
 * *********************************************************************************/
function popupCenter(href, w, h) {
	var xPos = (document.body.clientWidth / 2) - (w / 2);
	xPos += window.screenLeft; //듀얼 모니터일때
	var yPos = (screen.availHeight / 2) - (h / 2);

	window.open(href, "pop_window", "width=" + w + ",height=" + h + ", left=" + xPos + ", top=" + yPos + ", toolbars=no, resizable=no, scrollbars=no");
};

/* *********************************************************************************
 *	selectbox custom
 * *********************************************************************************/
function selectDesign() {
	var select = $("select.info-select");
	select.siblings('label').remove().end().before('<label></label>');
	$(document).on('change', 'select.info-select', function() {
		var select_name = $(this).find('option:selected').text();
		$(this).siblings('label').text(select_name);
	});
	select.trigger('change');

	// 2020.10.16
	select = $("select.info-select-notrigger");
	select.siblings('label').remove().end().before('<label></label>');
	$(document).on('change', 'select.info-select-notrigger', function() {
		var select_name = $(this).find('option:selected').text();
		$(this).siblings('label').text(select_name);
	});

	//select.trigger('change');

	$('select.info-select-notrigger').each(function() {
		var select_name = $(this).find('option:selected').text();
		$(this).siblings('label').text(select_name);
	});

}


/* *********************************************************************************
 *	모바일 메뉴
 * *********************************************************************************/
function allMenu() {
	hasAllMenuFunctionDone = true; // 2020.10.22
	var allBtn = $("#header .all-menu-btn > a");
	var allMenu = $("#allMenu");
	var body = $("body");
	var closeBtn = $(".site-map-btn > a");
	var aM_dep2li = $(".allmenu-gnavigation .depth2 > li");
	var aM_dep1a = $(".allmenu-gnavigation > li > a");
	var aM_dep2 = $(".allmenu-gnavigation .depth2");
	var aM_dep2a = $(".allmenu-gnavigation .depth2 > li > a");
	var aM_dep3 = $(".allmenu-gnavigation .depth3");

	if ($(window).width() <= 1100) {
		aM_dep2.hide();
		aM_dep3.hide();
	}

	aM_dep3.siblings().parent("li").addClass("under-on");

	allBtn.click(function() {
		body.toggleClass("allmenu-active");

		var winW = $(window).width();

		if (winW <= 1100) {
			aM_dep2.hide();
			aM_dep3.hide();
		} else {
			aM_dep2.show();
			aM_dep3.show();
		}
	});
	closeBtn.click(function() {
		body.removeClass("allmenu-active");
	});


	aM_dep1a.click(function() {
		var winW = $(window).width();
		if (winW <= 1100) {
			$(this).toggleClass("active").next().slideToggle();
			aM_dep1a.not(this).removeClass("active").next().stop().slideUp();
			return false;
		}
	});

	aM_dep2a.click(function() {
		var winW = $(window).width();

		if (winW <= 1100 && $(this).next().length > 0) {
			$(this).toggleClass("active").next().slideToggle();
			aM_dep2a.not(this).removeClass("active").next().stop().slideUp();
		}
		if (this.nextSibling.childElementCount) {
			return false;
		}
	});

	$("#allMenu > div").click(function(e) {
		if (winW <= 1100) {
			e.stopPropagation();
		}
	});

	$(window).resize(function() {
		var winW = $(window).width();

		if (winW <= 1100) {
			aM_dep2.hide();
			aM_dep3.hide();
		} else {
			aM_dep2.show();
			aM_dep3.show();
		}
	});
}
