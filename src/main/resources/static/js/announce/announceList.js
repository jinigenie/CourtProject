
var selectedValue = '전체';

$(".classify").click(function() {
    selectedValue = $(this).find("span").text();
    var search_field = $("#search_field").val();
    var search_cont = $("#search_cont").val();
    var view_cnt = $("#view_cnt").val();

    var start_date = $("#startDate").val();
    var end_date = $("#endDate").val();

    loadList(selectedValue, search_field, search_cont, start_date, end_date, 1, view_cnt);


});

// 검색기능 함수
$(".searchform-wrap").on('click', 'button', function(e) {
    e.preventDefault();

    var search_field = $("#search_field").val();
    var search_cont = $("#search_cont").val();
    var view_cnt = $("#view_cnt").val();

    var start_date = $("#startDate").val();
    var end_date = $("#endDate").val();

    loadList(selectedValue, search_field, search_cont, start_date, end_date, 1, view_cnt);

    $("#search_cont").val('');
});

$("#searchDateBtn").on('click', function () {
    var search_field = $("#search_field").val();
    var search_cont = $("#search_cont").val();
    var view_cnt = $("#view_cnt").val();

    var start_date = $("#startDate").val();
    var end_date = $("#endDate").val();

    loadList(selectedValue, search_field, search_cont, start_date, end_date, 1, view_cnt);

})

$("#view_cnt").on('change', function() {

    var search_field = $("#search_field").val();
    var search_cont = $("#search_cont").val();
    var view_cnt = $("#view_cnt").val();

    var start_date = $("#startDate").val();
    var end_date = $("#endDate").val();

    loadList(selectedValue, search_field, search_cont, start_date, end_date, 1, view_cnt);

});

// enter키로 조회 버튼
$(".inputContent").on("keydown", function(event) {
    if (event.key === "Enter") {
        event.preventDefault(); // 폼의 기본 동작을 막음
        var search_field = $("#search_field").val();
        var search_cont = $("#search_cont").val();
        var view_cnt = $("#view_cnt").val();

        var start_date = $("#startDate").val();
        var end_date = $("#endDate").val();

        loadList(selectedValue, search_field, search_cont, start_date, end_date, 1, view_cnt);

        $("#search_cont").val('');
    }
});


/////////////////////////////////////////////////////////////////////////////////


// 등재명단 리스트 테이블생성 함수
function loadList(selectedValue, search_field, search_cont, start_date, end_date, pageNumber, pageSize) {

    var formData = new FormData();

    formData
    $.ajax({
        url: "announceListAjax?page=" + pageNumber + "&amount=" + pageSize + "&selectedValue=" + selectedValue + "&search_field=" + search_field + "&search_cont=" + search_cont + "&start_date=" + start_date + "&end_date=" + end_date,

        success: function(data) {
            var tbody = $("#announceListId");
            tbody.empty(); // 테이블 내용 초기화

            $('#totalElement').text(data[0].total);

            for (var i = 0; i < data.length; i++) {
                var vo = data[i];
                var str = "";
                str += '<tr style="cursor: pointer">';
                str += '<td data-cell-header="번호"><a ';
                str += 'href="/announce/announceDetail?id=' + vo.announce_proper_num + '">';
                str += ((pageNumber - 1) * 10 + i + 1) + '</a></td>';
                str += '<td data-cell-header="모집유형"><a ';
                str += 'href="/announce/announceDetail?id=' + vo.announce_proper_num + '">';
                str += vo.trial_fcltt_main_code + ' > ' + vo.trial_fcltt_clasifi_code;
                str += (vo.trial_fcltt_sbcls_code == null ? '' : ' > ' + vo.trial_fcltt_sbcls_code) + '</a></td>';
                str += '<td data-cell-header="제목"><a class="trialList" ';
                str += 'href="/announce/announceDetail?id=' + vo.announce_proper_num + '">';
                str += vo.announce_title + '</a></td>';
                str += '<td data-cell-header="모집기간"><a ';
                str += 'href="/announce/announceDetail?id=' + vo.announce_proper_num + '">';
                str += vo.announce_start_date + ' ~ ' + vo.announce_end_date + '</a></td>';
                str += '<td data-cell-header="진행여부"><a ';
                str += 'href="/announce/announceDetail?id=' + vo.announce_proper_num + '">';
                str += '<p>진행중</p></a></td>';
                str += '<td><a href="/app/start?listNum=' + vo.announce_proper_num + '" ';
                str += 'class="case case1"><em>신청</em></a></td>';
                str += '</tr>';

                // 표에 행 추가
                tbody.append(str);
            }

            // 서버에서 받은 데이터를 반복하여 페이지 링크 생성
            $.each(data, function(index, AnnounceVO) {
                var pager = $(".pager");
                var str2 = '<div class="pager-wrap">';

                if (AnnounceVO.announcePageVO.pageList.length > 1) {
                    // 처음 페이지로 이동하는 링크 생성
                    str2 += '<a href="#" data-page-action=1 class="arr first" ></a>';
                }
                // 이전 페이지로 이동하는 링크 생성
                if (AnnounceVO.announcePageVO.pageList.length > 1 && AnnounceVO.announcePageVO.prev) {
                    str2 += '<a href="#" data-page-action="prev" class="arr prev"></a>';
                }

                // 페이지 번호를 생성
                for (var i = 0; i < AnnounceVO.announcePageVO.pageList.length; i++) {
                    var page = AnnounceVO.announcePageVO.pageList[i];
                    str2 += '<a href="#"';
                    if (page == AnnounceVO.announcePageVO.page) {
                        str2 += 'class="active"';
                    }
                    str2 += '>' + page + '</a>';
                }

                // 다음 페이지로 이동하는 링크 생성
                if (AnnounceVO.announcePageVO.pageList.length > 1 && AnnounceVO.announcePageVO.next) {
                    str2 += '<a href="#" data-page-action="next" class="arr next" ></a>';
                }

                // 맨 마지막 페이지로 이동하는 링크 생성
                if (AnnounceVO.announcePageVO.pageList.length > 1) {
                    str2 += '<a href="#" data-page-action="last"  class="arr last" data-total="' + AnnounceVO.announcePageVO.total + '"></a>';
                }

                str2 += '</div>';

                // 표에 행 추가
                pager.empty().append(str2);
            });


        },
    });
}


// 활동여부 onchange fclttChange
$(document).ready(function() {
    // 페이지 로드 시 목록을 불러오기
    loadList($("#fclttChange").val(), $("#fcltt_searchC").val(), $("#fclttSearch_btnID").val(), 1, 10);
    // 활동여부 onchange 이벤트 핸들러

});

var pageNumber = 1;
$(".pager").on('click', 'a', function(e) {
    e.preventDefault();

    var currentPage = ($(".pager a.active").text());
    var pageAction = $(this).data('page-action');
    var search_field = $("#search_field").val();
    var search_cont = $("#search_cont").val();
    var view_cnt = $("#view_cnt").val();

    var start_date = $("#startDate").val();
    var end_date = $("#endDate").val();

    if (pageAction === 1) {
        // 맨 처음 페이지로 이동하는 동작 수행
        loadList(selectedValue, search_field, search_cont, start_date, end_date, 1, view_cnt);

    } else if (pageAction === 'prev') {
        // 이전 페이지로 이동하는 동작 수행
        var currentPage = ($(".pager a.active").text());
        if (currentPage > 1) {
            loadList(selectedValue, search_field, search_cont, start_date, end_date, currentPage - 1, view_cnt);
        }
    } else if (pageAction === 'next') {
        // 다음 페이지로 이동하는 동작 수행
        var currentPage = ($(".pager a.active").text());
        var totalPages = ($(".pager a:last").prev().text()); // 맨 마지막 페이지 번호
        if (currentPage < totalPages) {
            loadList(selectedValue, search_field, search_cont, start_date, end_date, currentPage + 1, view_cnt);
        }
    } else if (pageAction === 'last') {
        // 맨 마지막 페이지로 이동하는 동작 수행
        var totalPages = ($(".pager a:last").prev().text()); // 맨 마지막 페이지 번호
        loadList(selectedValue, search_field, search_cont, start_date, end_date, totalPages, view_cnt);

    } else {
        // 페이지 번호를 클릭한 경우
        pageNumber = $(this).text();
        // 페이지 번호를 사용하여 데이터를 불러오는 동작 수행
        loadList(selectedValue, search_field, search_cont, start_date, end_date, pageNumber, view_cnt);
    }

});

