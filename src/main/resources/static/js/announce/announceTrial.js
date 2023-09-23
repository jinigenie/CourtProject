/*    var msg = `[[${msg}]]`;
	if (msg !== 'null') {
		alert(msg);
	}*/

//////////////////////////////////////// 재판조력자 ////////////////////////////////////////
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

//////////////////////////////////////// 이미지 클릭 시 해당 공고 불러오기 ////////////////////////////////////////
/*
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
*/
$(document).ready(function() {
            function filterByCategory(category) {
                $(".table tbody tr").hide();
                $(".table tbody tr").each(function() {
                    if ($(this).find("td[data-cell-header='대분류']").text().includes(category)) {
                        $(this).show();
                    }
                });
            }

            // 카테고리 클릭 시
            $("#clickWhole").click(function() {
                filterByCategory(""); // 모든 카테고리 표시
            });

            $("#clickTrial").click(function() {
                filterByCategory("조력자");
            });

            $("#clickTranslator").click(function() {
                filterByCategory("통번역인");
            });

            $("#clickMediator").click(function() {
                filterByCategory("조정위원");
            });

            $("#clickPsychologist").click(function() {
                filterByCategory("전문심리위원");
            });

            $("#clickCounselor").click(function() {
                filterByCategory("상담위원");
            });
        });

        const pagingData = {
            whole: {
                page: 1,
                amount: 10,
                total: 0
            },
            trial: {
                page: 1,
                amount: 10,
                total: 0
            },
            translator: {
                page: 1,
                amount: 10,
                total: 0
            },
            mediator: {
                page: 1,
                amount: 10,
                total: 0
            },
            psychologist: {
                page: 1,
                amount: 10,
                total: 0
            },
            counselor: {
                page: 1,
                amount: 10,
                total: 0
            }
        };

        // 페이징 관련 함수
        function updatePaging(category, total) {
            const data = pagingData[category];
            const currentPage = data.page;
            const totalPages = Math.ceil(total / data.amount);

            // 페이지 번호 업데이트
            const pageNumbers = [];
            for (let i = 1; i <= totalPages; i++) {
                pageNumbers.push(i);
            }

            // 여기에서 페이지 번호를 표시하는 부분을 업데이트하도록 구현

            // 이전 버튼 활성화 여부 결정
            const prevButton = $("#prevButton");
            prevButton.prop("disabled", currentPage === 1);

            // 다음 버튼 활성화 여부 결정
            const nextButton = $("#nextButton");
            nextButton.prop("disabled", currentPage === totalPages);
        }

        // 카테고리 필터링 함수
        function filterByCategory(category) {
            const data = pagingData[category];
            const currentPage = data.page;
            const amount = data.amount;

            // 여기에서 해당 카테고리의 데이터를 가져와서 표시하는 부분을 구현

            // 데이터 개수와 총 개수를 업데이트
            const total = 100; // 여기에 총 데이터 개수를 설정
            data.total = total;

            // 페이징 업데이트
            updatePaging(category, total);
        }

        // 이전 페이지로 이동
        function goToPreviousPage(category) {
            const data = pagingData[category];
            if (data.page > 1) {
                data.page--;
                filterByCategory(category);
            }
        }

        // 다음 페이지로 이동
        function goToNextPage(category) {
            const data = pagingData[category];
            const totalPages = Math.ceil(data.total / data.amount);
            if (data.page < totalPages) {
                data.page++;
                filterByCategory(category);
            }
        }

        // 페이지 번호 클릭 시 특정 페이지로 이동
        function goToPage(category, pageNumber) {
            const data = pagingData[category];
            if (pageNumber >= 1 && pageNumber <= Math.ceil(data.total / data.amount)) {
                data.page = pageNumber;
                filterByCategory(category);
            }
        }

        // 각 카테고리에 대한 클릭 이벤트 등록
        $("#clickWhole").click(function() {
            filterByCategory("whole");
        });

        $("#clickTrial").click(function() {
            filterByCategory("trial");
        });

        // 나머지 카테고리에 대한 클릭 이벤트 등록

        // 이전 페이지로 이동 버튼 클릭 이벤트 등록
        $("#prevButton").click(function() {
            const activeCategory = ""; // 현재 활성화된 카테고리를 설정
            goToPreviousPage(activeCategory);
        });

        // 다음 페이지로 이동 버튼 클릭 이벤트 등록
        $("#nextButton").click(function() {
            const activeCategory = ""; // 현재 활성화된 카테고리를 설정
            goToNextPage(activeCategory);
        });

        // 페이지 번호 클릭 시 이벤트 등록
        $(".pageNumber").click(function() {
            const activeCategory = ""; // 현재 활성화된 카테고리를 설정
            const pageNumber = parseInt($(this).text()); // 클릭한 페이지 번호 가져오기
            goToPage(activeCategory, pageNumber);
        });

//////////////////////////////////////// 검색 ////////////////////////////////////////
function srchMinwonDoc() {
	var queryString = document.getElementById("search_query").value.toLowerCase(); // 입력된 검색어를 소문자로 변환

	// 테이블 내의 공고문 제목 검색
	var table = document.querySelector(".table-responsive table");
	var rows = table.getElementsByTagName("tr");

	for (var i = 1; i < rows.length; i++) { // 첫 번째 행은 테이블 헤더이므로 제외
		var titleCell = rows[i].getElementsByTagName("td")[2]; // 제목이 있는 열(세 번째 열) 선택
		var title = titleCell.textContent.toLowerCase(); // 공고문 제목을 소문자로 변환

		// 검색어가 포함된 공고문만 표시
		if (title.includes(queryString)) {
			rows[i].style.display = ""; // 검색어가 포함된 공고문은 보이도록 설정
		} else {
			rows[i].style.display = "none"; // 검색어가 포함되지 않은 공고문은 숨김
		}
	}
}

// 검색 필드에서 엔터 키 누를 때 검색 수행
document.getElementById("search_query").addEventListener("keyup", function(event) {
	if (event.key === "Enter") {
		srchMinwonDoc();
	}
});

// 검색 조건 변경 시 이벤트 처리
document.getElementById("search_field").addEventListener("change", function() {
	var searchField = document.getElementById("search_field").value;

	// 검색 조건에 따라 placeholder 변경
	if (searchField === "0") {
		document.getElementById("search_query").placeholder = "검색어를 입력해주세요";
	} else if (searchField === "1") {
		document.getElementById("search_query").placeholder = "제목을 입력해주세요";
	} else if (searchField === "2") {
		document.getElementById("search_query").placeholder = "내용을 입력해주세요";
	}
});

//////////////////////////////////////// 게시글 보기 수 ////////////////////////////////////////
$(document).ready(function() {
	$('#view_cnt').change(function() {
		var selectedValue = $(this).val();
		var currentUrl = window.location.href;
		var newUrl = updateQueryStringParameter(currentUrl, 'view_cnt', selectedValue);
		window.location.href = newUrl;
	});

	function updateQueryStringParameter(uri, key, value) {
		var re = new RegExp("([?&])" + key + "=.*?(&|$)", "i");
		var separator = uri.indexOf('?') !== -1 ? "&" : "?";
		if (uri.match(re)) {
			return uri.replace(re, '$1' + key + "=" + value + '$2');
		}
		else {
			return uri + separator + key + "=" + value;
		}
	}
});

//////////////////////////////////////// 모집기간 ////////////////////////////////////////
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
			console.error('찾을 수 없음');
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

//////////////////////////////////////// 수정하기 ////////////////////////////////////////
// 공고 수정 버튼 클릭 이벤트 처리
/*function updateAnnouncement() {
	// 폼 데이터를 가져오기
	var admin_id = document.getElementById("admin_id").value;
	var announce_title = document.getElementById("title").value;
	var announce_start_date = document.getElementsByName("announce_start_date")[0].value;
	var announce_end_date = document.getElementsByName("announce_end_date")[0].value;
	var selectType1 = document.getElementById("selectType1").value;
	var selectType2 = document.getElementById("selectType2").value;
	var selectType3 = document.getElementById("selectType3").value;
	var announce_content = editor.getData();
	var announce_proper_num = document.getElementById("announce_proper_num").value;

	// 필수 필드의 유효성 검사
	if (
		admin_id === "" ||
		announce_title === "" ||
		announce_start_date === "" ||
		announce_end_date === "" ||
		selectType1 === "선택" ||
		selectType2 === "선택" ||
		selectType3 === "선택" ||
		announce_content === ""
	) {
		alert("입력하지 않은 정보가 있습니다. 모든 필드를 채워주세요.");
		return false; // 폼 제출을 중지합니다.
	}

	// 수정 확인 대화 상자를 표시하고, 사용자가 확인하면 폼을 제출합니다.
	if (confirm("수정하시겠습니까?")) {
		// 폼을 제출합니다.
		return true;
	} else {
		return false; // 폼 제출을 중지합니다.
	}
}*/






