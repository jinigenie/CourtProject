
	
/* 클릭시 상세내역 토글로 확인하기 */	
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
	
	
	/* faq 수정화면으로 이동하기  */
	
	function faqRegist() {
    location.href = "/faq/regist";
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	