/* ------------------조력자 등재 page  fclttRegist --------------------*/
document.addEventListener("DOMContentLoaded", function() {
	var registerButton = document.querySelector('.register-button');
	var cancelButton = document.querySelector('.cancel-button');

	registerButton.addEventListener('click', function() {
		// 등록 버튼 클릭 시 수행할 동작
		alert("등록되었습니다.");
	});

	cancelButton.addEventListener('click', function() {
		// 취소 버튼 클릭 시 수행할 동작
		alert("취소되었습니다.");
	});
});
/* ------------------조력자 등재 page  fclttRegist --------------------*/






/* ------------------조력자 등재명단 목록 fclttList --------------------*/
/* ------------------조력자 등재명단 목록 fclttList --------------------*/

//상세보기 스크립트
function openPop2(){
	window.scrollTo(0, 0);
	document.getElementById("popup_layer2").style.display = "block";
}

//그냥 닫기버튼 스크립트
function closePop2() {
	document.getElementById("popup_layer2").style.display = "none";
}

/*//--------------------------pause List-----------------------//*/
function pauseOpen(){
	document.getElementById("pause_text2").style.display = "block";
}

document.addEventListener("DOMContentLoaded", function() {
  var toggleRows = document.querySelectorAll(".toggle-row");

  toggleRows.forEach(function(row) {
    row.addEventListener("click", function() {
      var hiddenRow = this.nextElementSibling;

      if (hiddenRow.style.display === "none") {
        hiddenRow.style.display = "table-row";
      } else {
        hiddenRow.style.display = "none";
      }
    });
  });
});
