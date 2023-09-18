/* 재판조력자 선택 */
$('#selectType1').change(function() {

	$(".selectBox3").hide();
	$("#selectType2 option").hide();

	let selType2 = $("#selectType1 option:selected").val();

	$("#selectType2 option").filter(function() {
		return selType2 === $(this).attr("class") && $(this).prev().val() !== $(this).val();
	}).show();
})
$('#selectType2').change(function() {

	$(".selectBox3").hide();
	$("#selectType3 option").hide();

	let selType3 = $("#selectType2 option:selected").val();

	if (selType3 === '공사비등' || selType3 === '조정위원') {
		$(".selectBox3").show();
		$("#selectType3 option").filter(function() {
			return selType3 === $(this).attr("class");
		}).show();
	}
})

/*이미지 클릭 시 해당 공고 불러오기*/
$(document).ready(function() {
	// 전체 카테고리 클릭 시
	$("#clickWhole").click(function() {
		$(".table tbody tr").show();
	});

	// 조력자 카테고리 클릭 시
	$("#clickTrial").click(function() {
		$(".table tbody tr").hide();
		// 통번역인에 해당하는 필터링 코드 추가
		$(".table tbody tr").each(function() {
			if ($(this).find("td[data-cell-header='대분류']").text() === "조력자") {
				$(this).show();
			}
		});
	});

	// 통번역인 카테고리 클릭 시
	$("#clickTranslator").click(function() {
		$(".table tbody tr").hide();
		// 통번역인에 해당하는 필터링 코드 추가
		$(".table tbody tr").each(function() {
			if ($(this).find("td[data-cell-header='대분류']").text() === "통번역인") {
				$(this).show();
			}
		});
	});

	// 조정위원 카테고리 클릭 시
	$("#clickMediator").click(function() {
		$(".table tbody tr").hide();
		// 조정위원에 해당하는 필터링 코드 추가
		$(".table tbody tr").each(function() {
			if ($(this).find("td[data-cell-header='대분류']").text() === "조정위원") {
				$(this).show();
			}
		});
	});

	// 전문심리위원 카테고리 클릭 시
	$("#clickPsychologist").click(function() {
		$(".table tbody tr").hide();
		// 전문심리위원에 해당하는 필터링 코드 추가
		$(".table tbody tr").each(function() {
			if ($(this).find("td[data-cell-header='대분류']").text() === "전문심리위원") {
				$(this).show();
			}
		});
	});

	// 상담위원 카테고리 클릭 시
	$("#clickCounselor").click(function() {
		$(".table tbody tr").hide();
		// 상담위원에 해당하는 필터링 코드 추가
		$(".table tbody tr").each(function() {
			if ($(this).find("td[data-cell-header='대분류']").text() === "상담위원") {
				$(this).show();
			}
		});
	});
});


