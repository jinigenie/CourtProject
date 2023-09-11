<!--모달창 : 저장-->
const modal = document.querySelector('.modal');
let x = 0;

$(".prev_btn").click(function () {
    modal.style.display = 'block';
    x = 1;
})
$(".next_btn").click(function () {
    modal.style.display = 'block';
    x = 2;
})

$(".save").click(function () {
    if (x == 1) {
        $(location).attr("href", "../app/info");
    } else {
        $(location).attr("href", "../app/edu");
    }
    x = 0;
})

$(".cancel").click(function () {
    if (x == 1) {
        $(location).attr("href", "../app/info");
    } else {
        $(location).attr("href", "../app/edu");
    }
    x = 0;
})

$(".dmui_dialog_btn").click(function () {
    modal.style.display = 'none';
})


// <!--경력추가-->
$('#caAddBtn').click(function () {

    const ctId = Date.now();

    var career = '<tr style="cursor: pointer">'
    career += '<td data-cell-header="회사"><input type="text" class="input-wrap"></td>'
    career += '<td data-cell-header="경력구분" style="text-align: left">'
    career += '<div class="radio1">'
    career += '<input type="radio" name="ct' + ctId + '" id="radio-1' + ctId + '">'
    career += '<label class="custom-control-label" for="radio-1' + ctId + '">법정감정인 경력</label></div>'
    career += '<div class="radio2" style="margin-top: 3px">'
    career += '<input type="radio" name="ct' + ctId + '" id="radio-2' + ctId + '" checked>'
    career += '<label class="custom-control-label" for="radio-2' + ctId + '">기타 경력</label></div></td>'
    career += '<td data-cell-header="부서"><input type="text" class="input-wrap" style="width: 120px"></td>'
    career += '<td data-cell-header="직책"><input type="text" class="input-wrap" style="width: 120px"></td>'
    career += '<td data-cell-header="수행업무"><input type="text" class="input-wrap" style="width: 180px"></td>'
    career += '<td data-cell-header="근무시작일">'
    career += '<div class="calander-box" style="padding: 0">'
    career += '<input type="text" class="datepicker" readonly placeholder="날짜선택"'
    career += 'name="startDate" value="" style="width: 150px; height: 40px; border-radius: 0; background-position-x: 123px; background-position-y: 10px; cursor: pointer;"/></div></td>'
    career += '<td data-cell-header="근무종료일">'
    career += '<div class="calander-box" style="padding: 0">'
    career += '<input type="text" class="datepicker" readonly placeholder="날짜선택"'
    career += 'name="endDate" value="" style="width: 150px; height: 40px; border-radius: 0; background-position-x: 123px; background-position-y: 10px; cursor: pointer;"/></div></td>'
    career += '<td style="padding: 0.5rem 0">';
    career += '<button class="case case1 deleteInfo" onclick="deleteLine(this)">지우기</button>';
    career += '</td>';
    career += '</tr>';

    $('#careerTable').append(career);

    $(".datepicker").datepicker({
        dateFormat: 'yy-mm-dd',
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    });
    $(".datepicker").prop('readonly', false);
})

function deleteLine(obj) {
    var tr = $(obj).parent().parent();
    tr.remove();
}
