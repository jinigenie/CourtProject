/*-------------------------------------------------
Author      :parkgahye
Create date :2020-07-27
-------------------------------------------------*/
$(function() {
	
  snbMenu(); //snb
  filePath(); //����÷��

  $(window).trigger("resize");

  /* *********************************************************************************
   * folding-List
   * *********************************************************************************/
  $(".folding-lst .folding-tit").on("click", function() {
    $(this).attr("title", "Ŭ���� �ش� ���� ���� ���� (Ȯ�忩�� : ���)");
    $(this).parent().find(".folding-tit").removeClass("active");
    $(this).parent().find(".folding-cont").slideUp(300);
    if ($(this).next(".folding-cont").is(":hidden")) {
      $(this).next(".folding-cont").slideToggle(300);
      $(this).toggleClass("active");
      $(this).parent().find(".folding-tit").attr("title", "Ŭ���� �ش� ���� ���� ���� (Ȯ�忩�� : Ȯ��)");
    }
    return false;
  });
  //folding-List ���ټ�
  $(".folding-lst > li .folding-cont .bul-lst01 > li:last-of-type > a").on("focusout", function() {
    $(this).parents().find(".folding-tit").attr("title", "Ŭ���� �ش� ���� ���� ���� (Ȯ�忩�� : ���)");
    $(this).parents(".folding-cont").siblings(".folding-tit").removeClass("active");
    $(this).parents(".folding-cont").slideUp(300);
    return false;
  });
  
  /* *********************************************************************************
   * tab
   * *********************************************************************************/
  $(".tab-wrap .tab > li > a").click(function() {
    $(this).parent().addClass("active").siblings().removeClass("active");
    $(this).parents(".tab").toggleClass("active");
  });
  var $tabButtonItem = $(".tab-wrap .tab > li"),
    $tabContents = $(".tab-cont"),
    activeClass = "active";

  $tabButtonItem.first().addClass(activeClass);
  $tabContents.hide();
  $(".tab-wrapper .tab-wrap + .tab-cont").show();

  $tabButtonItem.find("a").on("click", function(e) {
    var target = $(this).attr("href");
    $(this).parent().removeClass(activeClass);
    $(this).parent().addClass(activeClass);
    $(this).parents(".tab-wrapper").children(".tab-cont").hide();
    $(target).show();
    e.preventDefault();
  });

  /* *********************************************************************************
   * layer popup
   * *********************************************************************************/
  $('.layer-btn').click(function() {
    var $href = $(this).attr('href');
    layer_popup($href);

    $("html").toggleClass("layer-active");
  });

  function layer_popup(el) {
    var $el = $(el); //���̾��� id�� $el ������ ����

    $el.fadeIn();
  }

  function layer_popupClose(el) {
    var $el = $(el); //���̾��� id�� $el ������ ����

    $el.fadeOut();
  }
  $(".layer-close").click(function() {
    var $href = $(this).attr('href');
    layer_popupClose($href);

    $("html").removeClass("layer-active");
  });
  // $(".pop-scoll").mCustomScrollbar({
  //   theme: "minimal-dark",
  //   mouseWheelPixels: 100
  // });

  /* *********************************************************************************
   * tab
   * *********************************************************************************/
  $(".heading-wrap .lang-selecct-lst > li > a").click(function() {
    $(this).parent().addClass("active").siblings().removeClass("active");
    $(this).parents(".lang-selecct-lst-wrap").toggleClass("active");
  });
  $(".lang-selecct-lst-wrap").mCustomScrollbar({
    axis: "y",
    advanced: {
      autoExpandHorizontalScroll: true
    },
    theme: "minimal-dark",
    mouseWheelPixels: 3000
  });
  $(".lang-selecct-lst-wrap").mouseleave(function() {
    $(this).removeClass("active");
  });

  $(".select-box .info-select").focus(function(){
    $(this).parent().addClass("focus");
  });
  $(".select-box .info-select").focusout(function(){
    $(this).parent().removeClass("focus");
  });
  
  /* *********************************************************************************
   * inputTable
   * *********************************************************************************/
   $(".inputTable").addClass("table-scroll");
   $(".inputTable").addClass("table-responsiveYM");
   
   $('#nm_office').parents('.table-responsiveYM').attr('class','table table-responsive table-responsiveYM table-scroll');
   
   
   $('.table-responsiveYM tr th').each(function(index,item){
	   $(item).next('td').attr('data-cell-header',$(item).text());
	   var srcPath = $(item).find('img').attr('src');
	   if(srcPath != undefined){
		   if(srcPath.indexOf('img/korean/sub/dot_y.html') > -1){
			   $(item).next('td').addClass('essential-responsive');
		   }
	   }
   });
	   
   
   
   /* *********************************************************************************
    * selecbox focus label outline
    * *********************************************************************************/
   
   $('.info-select').focusin(function(){
		$(this).prev('label').css('outline','solid 1px black');
		$(this).prev('label').css('outline','-webkit-focus-ring-color auto 1px');
	});

	$('.info-select').focusout(function(){
		$(this).prev('label').css('outline','');
	});
	
	$('.essential-txt').attr('title','�ʼ��׸�');
});


/* *********************************************************************************
 * snb
 * *********************************************************************************/
function snbMenu() {
  var relate_param = $(".snb-menu");
  var relate_obj = relate_param.find(".snb-menu-list");
  var relate_btn = relate_param.find("dt > a");

  relate_obj.hide();
  relate_btn.on("click", function(event) {
    event.preventDefault();
    var t = $(this);
    t.parent().toggleClass("fold");
    t.parents('#wrap').addClass("fold-active");
    if (t.parent().next('.snb-menu-list').css("display") == "none") {
      relate_btn.parent().removeClass("fold");
      t.parent().addClass("fold");
      relate_obj.stop(true, true).slideUp(300);
      t.parent().next('.snb-menu-list').stop(true, true).slideDown(300);
    } else {
      t.parent().next('.snb-menu-list').stop(true, true).slideUp(300);
    }
    return false;
  });
  relate_param.parent().on("mouseleave", function(event) {
    event.preventDefault();
    relate_btn.parent().removeClass("fold");
    relate_obj.stop(true, true).slideUp(300);
  });
  //���ټ�
  relate_obj.children().find("li:last-of-type > a").on("focusout", function(event) {
    event.preventDefault();
    relate_btn.parent().removeClass("fold");
    relate_obj.stop(true, true).slideUp(300);
  });
}

function filePath() {
  var $fileBox = $('.filetype');

  $fileBox.each(function() {
    var $fileUpload = $(this).find('.input-file'),
      $fileText = $(this).find('.file-text')
    $fileUpload.on('change', function() {
      var fileName = $(this).val();
      $fileText.attr('disabled', 'disabled').val(fileName);
    })
  })
}



function skipFocusMove(e){
	e.preventDefault();
	$('#contents').attr('tabindex','0');
	$('#contents').focus();
	$('#contents').attr('tabindex',false);
}



