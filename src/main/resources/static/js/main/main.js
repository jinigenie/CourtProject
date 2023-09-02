/*
$(function() {
	$('.visual .ctrl .bar span').css('width', '0').animate({ 'width': '100%' }, 5000);
	$('.visual .slide').on('init reInit afterChange', function(event, slick, currentSlide, nextSlide) {
		$('.visual .ctrl .bar span').css('width', '0').animate({ 'width': '100%' }, 5000);
		var i = (currentSlide ? currentSlide : 0) + 1;
		$('.visual .ctrl .current').text('0' + i);
		$('.visual .ctrl .total').text('0' + slick.slideCount);
	}).on('beforeChange init', function(event, slick, currentSlide, nextSlide) {
		$('.visual .ctrl .bar span').stop();
	});
	$('.visual .slide').slick({
		slidesToShow: 1, slidesToScroll: 1,
		infinite: true, fade: true,
		autoplay: true, autoplaySpeed: 5000,
		prevArrow: $('.visual .ctrl .prev'),
		nextArrow: $('.visual .ctrl .next')
	});
	$('.visual .ctrl .stop').on('click', function() {
		$(this).hide();
		$('.visual .slide').slick('slickPause');
		$('.visual .ctrl .play').show().focus();
		$('.visual .ctrl .bar span').stop();
	});
	$('.visual .ctrl .play').on('click', function() {
		$(this).hide();
		$('.visual .slide').slick('slickPlay');
		$('.visual .ctrl .stop').show().focus();
		$('.visual .ctrl .bar span').css('width', '0').animate({ 'width': '100%' }, 5000);
	});

	// 기관소개
	$('.visual .boxR .link').mouseenter(function() {
		$('.visual .linkOpen').fadeOut(200);
		$('.visual .linkList').fadeIn(200);
		$('.visual .link').addClass('hov');
	});
	$('.visual .boxR .link').mouseleave(function() {
		$('.visual .linkOpen').fadeIn(200);
		$('.visual .linkList').fadeOut(200);
		$('.visual .link').removeClass('hov');
		$('.visual .linkClose').hide();
	});

	$('.visual .linkOpen').click(function() {
		$(this).fadeOut(200);
		$('.visual .linkClose').show();
		$('.visual .linkList').fadeIn(200);
		$('.visual .link').addClass('hov');
	});
	$('.visual .linkClose').click(function() {
		$('.visual .linkOpen').fadeIn(200);
		$(this).hide();
		$('.visual .linkList').fadeOut(200);
		$('.visual .link').removeClass('hov');
		//setTimeout(function(){$('.visual .linkList').removeAttr('style');},500);
	});

});
*/
/*------------------*/
/*
    // 스와이퍼 초기화
    var mySwiper = new mySwiper('.mySwiper', {
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        slidesPerView: 3,
        spaceBetween: 0,
        freeMode: true,
    });*/
    
/*    var swiper = new Swiper(".mySwiper", {
    effect: "fade", // 페이드 효과 사용
    loop: true, // 무한 루프 활성화
});
    */
    /* top 위로 가는 버튼*/

window.onscroll = function() {
    scrollFunction();
};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("topButton").style.display = "block";
    } else {
        document.getElementById("topButton").style.display = "none";
    }
}

function scrollToTop() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}

/* 메인 공지 ,faq  화면 바꾸기 */
// '공지사항 보기' 클릭 시
function main_notice_view(){
    var noticeItems = document.querySelectorAll(".notice_left");
    var faqItems = document.querySelectorAll(".faq_left");
    document.querySelector(".main_noticeLink").style.display = "block";
    document.querySelector(".main_faqList").style.display = "none";
    document.querySelector(".main_notice").style.borderBottom="3px solid rgb(128, 128, 128)";
    document.querySelector(".main_notice").style.color="black";
    document.querySelector(".main_faq").style.color="#666";
    document.querySelector(".main_faq").style.borderBottom="3px solid rgb(240, 240, 240)";
    
    

    // 모든 공지사항 보이기, FAQ 숨기기
    for (var i = 0; i < noticeItems.length; i++) {
        noticeItems[i].style.display = "block";
    }
    for (var i = 0; i < faqItems.length; i++) {
        faqItems[i].style.display = "none";
    }
}

// 'FAQ 보기' 클릭 시
function main_faq_view(){
    var noticeItems = document.querySelectorAll(".notice_left");
    var faqItems = document.querySelectorAll(".faq_left");
    document.querySelector(".main_faqList").style.display = "block";
    document.querySelector(".main_noticeLink").style.display = "none";
        document.querySelector(".main_faq").style.borderBottom="3px solid rgb(128, 128, 128)";
    document.querySelector(".main_notice").style.borderBottom="3px solid rgb(240, 240, 240)";
       document.querySelector(".main_faq").style.color="black";
    document.querySelector(".main_notice").style.color="#666";

    // 모든 FAQ 보이기, 공지사항 숨기기
    for (var i = 0; i < faqItems.length; i++) {
        faqItems[i].style.display = "block";
    }
    for (var i = 0; i < noticeItems.length; i++) {
        noticeItems[i].style.display = "none";
    }
}
















