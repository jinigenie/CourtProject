
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

/*------------------*/

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
    });
    
    
    
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

