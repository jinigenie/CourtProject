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
			if ($(this).find("td[data-cell-header='대분류']").text().includes("조력자")) {
				$(this).show();
			}
		});
	});

	// 통번역인 카테고리 클릭 시
	$("#clickTranslator").click(function() {
		$(".table tbody tr").hide();
		// 통번역인에 해당하는 필터링 코드 추가
		$(".table tbody tr").each(function() {
			if ($(this).find("td[data-cell-header='대분류']").text().includes("통번역인")) {
				$(this).show();
			}
		});
	});

	// 조정위원 카테고리 클릭 시
	$("#clickMediator").click(function() {
		$(".table tbody tr").hide();
		// 조정위원에 해당하는 필터링 코드 추가
		$(".table tbody tr").each(function() {
			if ($(this).find("td[data-cell-header='대분류']").text().includes("조정위원")) {
				$(this).show();
			}
		});
	});

	// 전문심리위원 카테고리 클릭 시
	$("#clickPsychologist").click(function() {
		$(".table tbody tr").hide();
		// 전문심리위원에 해당하는 필터링 코드 추가
		$(".table tbody tr").each(function() {
			if ($(this).find("td[data-cell-header='대분류']").text().includes("전문심리위원")) {
				$(this).show();
			}
		});
	});

	// 상담위원 카테고리 클릭 시
	$("#clickCounselor").click(function() {
		$(".table tbody tr").hide();
		// 상담위원에 해당하는 필터링 코드 추가
		$(".table tbody tr").each(function() {
			if ($(this).find("td[data-cell-header='대분류']").text().includes("상담위원")) {
				$(this).show();
			}
		});
	});
});

function filterAnnouncements() {
    var startDateInput = document.querySelector('input[name="startDate"]');
    var endDateInput = document.querySelector('input[name="endDate"]');

    if (!startDateInput || !endDateInput) {
        // 요소를 찾을 수 없을 때 처리
        console.error('Input elements not found.');
        return;
    }

    var startDate = startDateInput.value;
    var endDate = endDateInput.value;

    // startDate와 endDate가 유효한 날짜 형식인지 확인
    if (!isValidDate(startDate) || !isValidDate(endDate)) {
        console.error('Invalid date format.');
        return;
    }

    // 모집기간에 해당하는 공고문만 출력
    var announcements = document.querySelectorAll('.table-responsive table tbody tr');
    announcements.forEach(function(announcement) {
        var startDateElement = announcement.querySelector('td[data-cell-header="모집기간"] a:first-child');
        var endDateElement = announcement.querySelector('td[data-cell-header="모집기간"] a:last-child');

        if (!startDateElement || !endDateElement) {
            // 요소를 찾을 수 없을 때 처리
            console.error('Announcement date elements not found.');
            return;
        }

        var announcementStartDate = startDateElement.textContent.trim();
        var announcementEndDate = endDateElement.textContent.trim();

        // startDate와 endDate 사이에 있는 공고문만 표시
        if (isDateInRange(startDate, endDate, announcementStartDate, announcementEndDate)) {
            announcement.style.display = '';
        } else {
            announcement.style.display = 'none';
        }
    });
}

// 유효한 날짜 형식인지 확인하는 함수
function isValidDate(dateString) {
    var pattern = /^\d{4}-\d{2}-\d{2}$/;
    return pattern.test(dateString);
}

// 날짜 범위를 비교하는 함수 (모집기간에 해당하는 공고만 표시)
function isDateInRange(startDate, endDate, announcementStartDate, announcementEndDate) {
    startDate = new Date(startDate);
    endDate = new Date(endDate);
    announcementStartDate = new Date(announcementStartDate);
    announcementEndDate = new Date(announcementEndDate);

    // 공고의 시작일과 종료일이 모집기간에 포함되어야 함
    return (
        announcementStartDate >= startDate &&
        announcementEndDate <= endDate
    );
}










