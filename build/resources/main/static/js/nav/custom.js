var footer={
	footerList:undefined,
	footerUlWidth:undefined,
	footerWrapWidth:780,

	goTop:function(){
		var topbtn=$("#topOnly");
		//var left=Math.ceil($(window).width()/2+965/2);
		var left=Math.ceil($(window).width()/2+1240/2);//1123 수정
		topbtn.css({"left":left+"px","display":"block"});
		topbtn.on({
			click:function(e){
				e.preventDefault();
				//$("html,body").scrollTop(0);
				$("html,body").animate({scrollTop: '0'}, 500);//1123 수정
				$("#skipnav a:first").focus();
			}
		});
	}
};


var common={
	commonHiddenPop:function(){
		$("#content").find(".hiddenPop").off().on({
			"mouseenter focus":function(){
				var popdiv=$(this).next();

				if($("#content").find(".hiddenPop").next().css("display")=="block"){
					$("#content").find(".hiddenPop").next().hide();
				}
				popdiv.show();

				popdiv.off().on({
					mouseleave:function(){
						$(this).hide();
					}
				});

				popdiv.children("a").off().on({
					blur:function(){
						popdiv.hide();
					}
				});
			},
			click:function(e){ e.preventDefault(); }
		});
	},

	// 키보드로 이동하여 메뉴에서 빠져나갈때 펼쳐진 하위메뉴 숨기기위함.
	naviOff:function(){
		$(".wrap").find("a").off().on({
			"focus":function(){
				var gnb=$("#gnb").find(".menus").children(".gnb.on").children("li");
				gnb.parent().find(".on").removeClass("on");
				navigation.liHeightNoPast=85;
				gnb.stop().animate({"height":navigation.liHeightNoPast+"px"},300,"easeOutQuad");
			}
		});
	},

	// 키보드로 이동하여 메뉴에서 빠져나갈때 펼쳐진 하위메뉴 숨기기위함. (메인은 별도 분리)
	naviOffMain:function(){
		$(".loginTopBtn").find("a").off().on({
			"focus":function(){
				var gnb=$("#gnb").find(".menus").children(".gnb.on").children("li");
				gnb.parent().find(".on").removeClass("on");
				navigation.liHeightNoPast=85;
				gnb.stop().animate({"height":navigation.liHeightNoPast+"px"},300,"easeOutQuad");
			},
			click:function(e){
				e.preventDefault();
			}
		});
	},

};


$(document).ready(function(){
	$("#quickMenu").css("left", ($("body").width()/2)+580);

	if($("body.main").length>0){
		// main
		//if($("#footer").length>0) footer.init();
		if($("#topGnb").length>0) navigation.topGnb();
		$("#topOnly").hide();
		main.init();
		common.naviOffMain();

	}else if($("body.singo").length>0){
		// main
//		$("#header").load("/ei/include/gnb_singo.html",function(){
//			$("#lnb").load("/ei/include/lnb_singo.html",function(){
//				$("#footer").load("/ei/include/footer.html",function(){
//					if($("#footer").length>0) footer.init();
//					$("#topOnly").hide();
//				});
//			});
//		});
	}else{
		// sub
//		$("#header").load("/ei/include/gnb.html",function(){
//			$("#lnb").load("/ei/include/lnb.html",function(){
//				$("#footer").load("/ei/include/footer.html",function(){
//					$("#quickMenu").load("/ei/include/quickMenu.html",function(){
						//if($("#footer").length>0) footer.init();
						if($("#topGnb").length>0) navigation.topGnb();
						if($("#content").find(".hiddenPop").length>0) common.commonHiddenPop();
						if($("#content").find(".btnPreview").length>0) common.windowPop();
						if($("#quickMenu").find(".quick").length>0) common.quickMenu();
						footer.goTop();
						//common.quickTopPosi();
						common.naviOff();
//					});
//				});
//			});
//		});
	}
	if($("#popClose").length>0) common.windowPop();
	if($("#tab").length>0) common.tab();
	if($(".inTabWrap").length>0) common.inTab();



	//20201127 메인네비게이션 UI 재정의
	$('.main-nav-list > li > a').on('click', function(e) {
		e.preventDefault();
		$(this).parent().siblings().find('a.open').removeClass('open');//1뎊스메뉴 스타일초기화
		$(this).toggleClass('open');
		$(this).parent().siblings().find('.menus').hide();//다른메뉴의 열려있는 하위메뉴 닫기
		$(this).next('.menus').stop().toggle();//하위뎊스 메뉴열기
		$('.nav-close').addClass('on');
		$('#site-map').hide(); //20210119 사이트맵 닫기
		$('.button-sitemap').removeClass('open'); //20210119 사이트맵 닫기
		$('body').removeClass('fixed'); //20210119 사이트맵 닫기

		$(".main-nav-list > li > a").each(function(){
			$(this).attr("title", $(this).text() + " 열기");
		});

		if($(this).hasClass("open")){
			$(this).attr("title", $(this).text() + " 닫기 (열림)");
		}
	});

	//header 영역 마우스이탈시 전체메뉴 닫힘
	$('.header-section').on('mouseleave', function() {
		$('.main-navigation .main-nav-list > li > .menus').hide();
		$('.nav-close').removeClass('on');
		$('.main-nav-list > li > a').removeClass('open');

		$(".main-nav-list > li > a").each(function(){
			$(this).attr("title", $(this).text() + " 열기");
		});
	});
	//메인네이게이션 닫기버튼 정의
	$('.main-navigation .nav-close').on('click', function() {
		$('.main-navigation .main-nav-list > li > .menus').hide();
		$('.nav-close').removeClass('on');
		$('.main-nav-list > li > a').removeClass('open');
	});

	//lnb 메뉴, gnb 링크 포커스일때 메인네비게이션 닫힘
	$('#lnb > .menu > ul > li > a, .gnb-area a').on('focus', function() {
		$('.main-navigation .main-nav-list > li > .menus').hide();
	});

	//2020.11.23 신규작성
	//하위depth를 가진 lnb 메뉴를 .has-sub 로 특정
	$('#lnb > .menu > ul > li > .sub').parent().addClass('has-sub');
	$('#lnb > .menu > ul > li > .sub').hide();//lnb 하위뎊스메뉴 감추기
	$('#lnb > .menu > ul > li.has-sub.on > .sub').slideDown();//현재페이지 메뉴 활성화

	//하위depth를 가진 메뉴 클릭시 하위depth노출/비노출
	$('#lnb > .menu > ul > li.has-sub > a').on('click', function(event) {
		event.preventDefault();
		$(this).parent().toggleClass('on');
		$(this).next().slideToggle();//하위메뉴 열기/닫기
		$(this).parent().siblings().removeClass('on').find('ul.sub').slideUp();//다른 상위메뉴의 하위메뉴 닫기

		$(".has-sub > a").each(function(){
			$(this).attr("title", $(this).text() + " 열기");
		});

		if($(this).parent().hasClass("on")){
			$(this).attr("title", $(this).text() + " 닫기 (열림)");
		}
	});

	//하위메뉴 숨김노출
	$("#lnb > .menu > ul > li.has-sub > ul.sub > li.on").each(function(){
		var tObj = $(this).parents("li.has-sub");
		if(tObj.length > 0 && !tObj.is(".on")) {
			tObj.children("a").click();
		}
	});

	//윈도우 스크롤시 헤더고정:20210204 수정
	$(window).on('scroll',function(){
		var wint = $(window).scrollTop();
		if(wint >= 132){
			//$('.gnb-area').addClass('hidden');
			$('#site-map').addClass('move-up');//sitemap 위치조정
		}else{
			//$('.gnb-area').removeClass('hidden');
			$('#site-map').removeClass('move-up');//sitemap 위치조정
		}
	});


	//인터넷 실업인정 신청: 다음단계 이동
	$('#app-step-01 .next-step').on('click', function(e) {
		if(!fn_nextChk()){
			return false;
		}

		e.preventDefault();

		//alert('다음단계 이동');
		//$('.loading').animate({opacity: '1'}, 1000, function() {$('.loading').animate({opacity: '0'},1000)});
		$('.loading').fadeIn();
		$('html,body').stop().delay(1000).animate({scrollTop: '0'}, 400);
		$('#app-step-01').attr('aria-hidden','true');
		$('#app-step-01').find("a[href], input, button").attr('tabindex','-2');

		$('#app-step-01').hide();
  		$('#app-step-02').show();
		$('#app-step-02').attr('aria-hidden','false');

		if($('.recruit-formbox').hasClass("hidden")){
			$('.recruit-formbox').find("a[href], input, button").attr('tabindex','-2');
		}

		if($('#jhactNrsnAtCeck-formbox').hasClass("hidden")){
			$('#jhactNrsnAtCeck-formbox').find("a[href], input, button").attr('tabindex','-2');
		}

		if($('#JhactListTop').hasClass("hidden")){
			$('#JhactListTop').find("a[href], input, button").attr('tabindex','-2');
		}

		setTimeout(function() {
			$('.loading').fadeOut();
			$('#content').focus();
		}, 1000);
	});
	//인터넷 실업인정 신청: 이전단계 이동
	$('#app-step-02 .prev-step').on('click', function(e) {
		e.preventDefault();
		//alert('이전단계 이동');
		$('.loading').fadeIn();
		$('html,body').stop().delay(1000).animate({scrollTop: '0'}, 400);
		$('#app-step-02').hide();
		$('#app-step-02').attr('aria-hidden','true');
		$('#app-step-01').attr('aria-hidden','true');
		$('#app-step-01').show();
		$('#app-step-01').find("a[tabindex=-2], input[tabindex=-2], button[tabindex=-2]").attr('tabindex','0');
		setTimeout(function() {
			$('.loading').fadeOut();
			$('#content').focus();
		}, 1000);
	});

	//20201222 추가: 더보기 정보 열고,닫기
	$('.fold-button').on('click', function(e) {
		e.preventDefault();
		console.log('정보 더보기');
		$(this).toggleClass('close');
		$(this).parent().next().toggle();
	});

	//20201223 추가: 인터넷 신청방법 안내레이어 show. hide
	$('.guide-open, .guide-close').on('click', function() {
		var target_id = $(this).attr("data-target-id");
		if(target_id == "apply-guide2") {
			$('#apply-guide1').hide();
			$('#apply-guide1').removeClass('open')
			$('#apply-guide1').attr('aria-hidden', 'true');

			$('.appy-info-layer .nav li .menu-4').click();
		} else {
			$('#apply-guide2').hide();
			$('#apply-guide2').removeClass('open')
			$('#apply-guide2').attr('aria-hidden', 'true');

			$('.appy-info-layer .nav li .menu-1').click();
		}

		$(this).toggleClass('open');
		$('#'+target_id).toggle();
		$('#'+target_id).attr('aria-hidden', function(index, attr) {
			return attr == 'true' ? 'false' : 'true';
		});
	});

	$('.appy-info-layer .nav li a').on('click', function() {
		$(this).addClass('active');
		$(this).parent().siblings().find('a').removeClass('active');
	});

	$('.appy-info-layer .nav li .menu-1').on('click', function(e) {
		e.preventDefault();
		$('.info-con').addClass('hidden');
		$('#info-con-1').removeClass('hidden');
	});

	$('.appy-info-layer .nav li .menu-2').on('click', function(e) {
		e.preventDefault();
		$('.info-con').addClass('hidden');
		$('#info-con-2').removeClass('hidden');
	});

	$('.appy-info-layer .nav li .menu-3').on('click', function(e) {
		e.preventDefault();
		$('.info-con').addClass('hidden');
		$('#info-con-3').removeClass('hidden');
	});

	$('.appy-info-layer .nav li .menu-4').on('click', function(e) {
		e.preventDefault();
		$('.info-con').addClass('hidden');
		$('#info-con-4').removeClass('hidden');
	});

	$('.appy-info-layer .nav li .menu-5').on('click', function(e) {
		e.preventDefault();
		$('.info-con').addClass('hidden');
		$('#info-con-5').removeClass('hidden');
	});

	//20201223 추가: 구직활동내역 show, hide
	$('#jhacYn1').on('click', function() {
		$('.recruit-formbox').removeClass('hidden');
		$('.recruit-formbox').find("a[tabindex=-2], input[tabindex=-2], button[tabindex=-2]").attr('tabindex','0');
		$("#form1 #jhactAtCeck").prop("checked",true);
		fnJhactAtCeckSet();
	});
	$('#jhacYn2').on('click', function() {
		$('.recruit-formbox').addClass('hidden');
		$('.recruit-formbox').find("a[href], input, button").attr('tabindex','-2');
		$("#form1 #jhactAtCeck").prop("checked",false);
		fnJhactAtCeckSet();
	});

	//20210119 추가: 구직활동 외 활동사항 show, hide
	$('#jhactNrsnAtCeck1').on('click', function() {
		$("#jhactNrsnAtCeck-formbox").removeClass('hidden');
		$('#jhactNrsnAtCeck-formbox').find("a[tabindex=-2], input[tabindex=-2], button[tabindex=-2]").attr('tabindex','0');
		$("#form1 #jhactNrsnAtCeck").prop("checked",true);
		fnJhactNrsnAtCeckSet();
	});
	$('#jhactNrsnAtCeck2').on('click', function() {
		$("#jhactNrsnAtCeck-formbox").addClass('hidden');
		$('#jhactNrsnAtCeck-formbox').find("a[href], input, button").attr('tabindex','-2');
		$("#form1 #jhactNrsnAtCeck").prop("checked",false);
		fnJhactNrsnAtCeckSet();
	});

	//새창열기 링크 스타일 정의
	$('a[target="_blank"]').addClass('bg1');

	$("#lnb .has-sub > a").each(function(){
		$(this).attr("title", $(this).text() + " 열기");
	});
});
