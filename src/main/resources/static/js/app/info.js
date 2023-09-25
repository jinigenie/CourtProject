// <!-- 학력 선택에 따라 테이블 보이기 -->
$("#selectEdu").change(function () {
    let state = $("#selectEdu option:selected").val();
    if (state == "" || state == null) {
        $(".university").hide();
        $(".highschool").hide();
    } else if (state == "고졸") {
        $(".university").hide();
        $(".highschool").show();
    } else {
        $(".highschool").show();
        $(".university").show();
    }
});

// <!-- 자격증 추가하기 -->
$('#certAddBtn').click(function () {
    var addtr = '<tr style="cursor: pointer">';
    addtr += '<td data-cell-header="종목"><input type="text" class="input-wrap certificationName" name="crtfc_type" style="width: 200px; margin-left: 30px">';
    addtr += '<input type="button" class="certiSearch"';
    addtr += 'style="background: url(../../img/app/search.png); border: none; width: 30px; height: 30px; background-size: cover; position: absolute;';
    addtr += 'margin-left: -38px; margin-top: 5px; cursor: pointer"></td>';
    addtr += '<td data-cell-header="기관"><input type="text" class="input-wrap" name="issue_agency" style="width: 150px"></td>';
    addtr += '<td data-cell-header="면허번호"><input type="text" class="input-wrap" name="crtfc_number" style="width: 150px"></td>';
    addtr += '<td data-cell-header="발급일">';
    addtr += '<div class="calander-box" style="padding: 0">';
    addtr += '<input type="text" class="datepicker" readonly placeholder="날짜선택"';
    addtr += 'name="issue_date" value="" style="width: 150px; height: 40px; border-radius: 0;';
    addtr += 'background-position-x: 123px; background-position-y: 10px; cursor: pointer;"/>';
    addtr += '</div>';
    addtr += '</td>';
    addtr += '<td>';
    addtr += '<button class="case case1 deleteInfo" onclick="deleteLine(this)" style="margin-right: 30px">지우기</button>';
    addtr += '</td></tr>';
    addtr += '</tr>';

    $('#certiTable').append(addtr);
    $(".datepicker").datepicker({
        dateFormat: 'yy-mm-dd',
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    });
    $(".datepicker").prop('readonly', false);

});
function deleteLine(obj) {
    var tr = $(obj).parent().parent();
    tr.remove();
}


// <!-- 학력 추가하기 -->
const uniId = Date.now();
$('#eduAddBtn').click(function () {
    var addtr2 = '<tr style="cursor: pointer">';
    addtr2 += '<td data-cell-header="학교명"><input type="text" class="input-wrap universityName" name="edctn_school_name[]" style="width: 200px; margin-left: 50px">';
    addtr2 += '<input type="button" class="UnivSearch"'
    addtr2 += 'style="background: url(../../img/app/search.png); border: none; width: 30px;' ;
    addtr2 += 'height: 30px; background-size: cover; position: absolute;' ;
    addtr2 += 'margin-left: -38px; margin-top: 5px; cursor: pointer"></td>';
    addtr2 += '<td data-cell-header="학과"><input type="text" class="input-wrap"  name="edctn_major[]" style="width: 150px">';
    addtr2 += '</td>';
    addtr2 += '<td data-cell-header="학위">';
    addtr2 += '<div class="select-box2" style="width: 140px">';
    addtr2 += '<label for="edu"' + uniId + ' >선택</label>';
    addtr2 += '<select class="info-select" id="edu"' + uniId + ' name="edctn_degree[]">';
    addtr2 += '<option value="선택">선택</option>';
    addtr2 += '<option value="학사">학사</option>';
    addtr2 += '<option value="석사">석사</option>';
    addtr2 += '<option value="박사">박사</option>';
    addtr2 += '<option value="전문학사">전문학사</option>';
    addtr2 += '</select>';
    addtr2 += '</div>';
    addtr2 += '</td>';
    addtr2 += '<td data-cell-header="졸업구분">';
    addtr2 += '<div class="select-box2" style="width: 140px">';
    addtr2 += '<label for="st"' + uniId + ' >선택</label>';
    addtr2 += '<select class="info-select" name="edctn_final[]" title="검색조건을 선택해주세요." id="st"' + uniId + '>';
    addtr2 += '<option value="">선택</option>';
    addtr2 += '<option value="졸업">졸업</option>';
    addtr2 += '<option value="졸업예정">졸업예정</option>';
    addtr2 += '<option value="수료">수료</option>';
    addtr2 += '<option value="중퇴">중퇴</option>';
    addtr2 += '</select></div></td>';
    addtr2 += '<td data-cell-header="입학일">';
    addtr2 += '<div class="calander-box" style="padding: 0">';
    addtr2 += '<input type="text" class="datepicker" placeholder="날짜선택"';
    addtr2 += 'name="edctn_admsn_date[]" value="" style="width: 130px; height: 40px; border-radius: 0; background-position-x: 100px; background-position-y: 10px; cursor: pointer;"/>';
    addtr2 += '</div></td>';
    addtr2 += '<td data-cell-header="졸업일">';
    addtr2 += '<div class="calander-box" style="padding: 0">';
    addtr2 += '<input type="text" class="datepicker" readonly placeholder="날짜선택" name="edctn_grdtn_date[]" value=""';
    addtr2 += 'style="width: 130px; height: 40px; border-radius: 0;background-position-x: 100px; background-position-y: 10px; cursor: pointer;"/>';
    addtr2 += '</div></td>';
    addtr2 += '<td style="padding: 0.5rem 0">';
    addtr2 += '<button class="case case1 deleteInfo" onclick="deleteLine(this)">지우기</button>';
    addtr2 += '</td>';
    addtr2 += '</tr>';

    $('#eduTable').append(addtr2);
    $(".datepicker").datepicker({
        dateFormat: 'yy-mm-dd',
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    });
    $(".datepicker").prop('readonly', false);

});
function deleteLine(obj) {
    var tr = $(obj).parent().parent();
    tr.remove();
}


// <!-- 모달창 : 저장-->
const modal = document.querySelector('.modal');
let x = 0;

$(".prev_btn").click(function () {
    modal.style.display = 'block';
    x = 1;
    $("#xField").val(x);
})
$(".next_btn").click(function () {
    modal.style.display = 'block';
    x = 2;
    $("#xField").val(x);
})

$(".save").click(function () {
    var form = document.forms["actionForm"];
    form.submit();

    x = 0;
    $("#xField").val(x);
})

$(".cancel").click(function () {
    if (x == 1) {
        $(location).attr("href", "../app/career");
    } else {
        $(location).attr("href", "../app/file");
    }
    x = 0;
})

$(".dmui_dialog_btn").click(function () {
    modal.style.display = 'none';
})

//모달창3 : 고등학교 검색창
const modal3 = document.querySelector('.modal3');
$("#highTable").on("click", ".highSearch", function () {

    $("#highschool").val('');
    $(".addLi2").remove();
    $(".defaultLi2").show();

    modal3.style.display = 'block';
    dataApi2();
})

$(".modalOff").click(function () {
    modal2.style.display = 'none';
    modal3.style.display = 'none';
    modal4.style.display = 'none';
})

//모달창2 : 자격증 검색창
var certiTd;
const modal2 = document.querySelector('.modal2');
$("#certiTable").on("click", ".certiSearch", function () {

    $("#certification").val('');
    $(".addLi").remove();
    $(".defaultLi").show();

    certiTd = $(this).closest("td");

    modal2.style.display = 'block';
    dataApi();
})

// 자격증 검색
let apiData = [];

function dataApi(){
    $.ajax({
        url:"http://api.odcloud.kr/api/15082998/v1/uddi:950a6280-b56a-417e-b97c-de941adbfc9f?page=1&perPage=600&serviceKey=wVFM1V%2FCXCg4fUs1i3%2FxM8%2BC6l9ymKY%2BXAUoe9PbRw68Jah1QmTPEIPKtYx4jF0HUKVUI4YPZqW%2F0EH%2FWDwIjg%3D%3D",
        type:"GET",
        success:function(data){
            apiData = data.data;
            console.log(apiData);
        },error:function(status,err){
            console.log(err)
        }

    })
}

$('#certification').keypress(function(event) {
    // 엔터 키의 키 코드는 13입니다.
    if (event.keyCode === 13) {
        event.preventDefault();
        $('#searchCerti-btn').click(); // 검색 버튼 클릭 이벤트 호출
        event.preventDefault();
    }
});

$('#searchCerti-btn').click(()=>{

    var search = $('#certification').val();
    var addLi='';
    const filteredData = apiData.filter(item => item.종목명.includes(search));

    if (filteredData.length > 0) {
        $(".defaultLi").hide();
        for (const f of filteredData){
            addLi += '<li class="addLi">'+f.종목명+'</li>';

        }
    }

    $('#searchResult').append(addLi);

})

$(document).on('click', '.addLi', function () {
    certiTd.find('.certificationName').val($(this).text());
    modal2.style.display = 'none';
});


// 고등학교 검색
let highData = [];

function dataApi2(){
    $.ajax({
        url:"https://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=0a0d73e5c24d9109a976b4fd0793c531&svcType=api&svcCode=SCHOOL&contentType=json&gubun=high_list&perPage=2370",
        type:"GET",
        success:function(data){
            highData = data.dataSearch.content;

        },error:function(status,err){
            console.log(err)
        }

    })
}

$('#highschool').keypress(function(event) {
    // 엔터 키의 키 코드는 13입니다.
    if (event.keyCode === 13) {
        event.preventDefault();
        $('#searchHigh_btn').click(); // 검색 버튼 클릭 이벤트 호출
        event.preventDefault();
    }
});

$('#searchHigh_btn').click(()=>{
    var search2 = $('#highschool').val();
    var addLi2='';
    const filteredData = highData.filter(item => item.schoolName.includes(search2));

    console.log(filteredData);
    if (filteredData.length > 0) {
        $(".defaultLi2").hide();
        for (const f of filteredData){
            addLi2 += '<li class="addLi2">'+f.schoolName+'</li>';

        }
    }

    $('#searchResult2').append(addLi2);

})

$(document).on('click', '.addLi2', function () {
    $('.highSchoolName').val($(this).text())
    modal3.style.display = 'none';
});


// 대학교 검색
let UnivData = [];
function dataApi3(){
    $.ajax({
        url:"https://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=0a0d73e5c24d9109a976b4fd0793c531&svcType=api&svcCode=SCHOOL&contentType=json&gubun=univ_list&perPage=443",
        type:"GET",
        success:function(data){
            UnivData = data.dataSearch.content;

        },error:function(status,err){
            console.log(err)
        }

    })
}


//모달창4 : 대학교 검색창
var parentTd;
const modal4 = document.querySelector('.modal4');
$("#eduTable").on("click", ".UnivSearch", function (event) {

    $("#univercity").val('');
    $(".addLi3").remove();
    $(".defaultLi3").show();
    parentTd = $(this).closest("td");

    modal4.style.display = 'block';
    dataApi3();
})

$('#univercity').keypress(function(event) {
    // 엔터 키의 키 코드는 13입니다.
    if (event.keyCode === 13) {
        event.preventDefault();
        $('#searchUniv_btn').click(); // 검색 버튼 클릭 이벤트 호출
        event.preventDefault();
    }
});

$('#searchUniv_btn').click(()=>{
    var search3 = $('#univercity').val();
    var addLi3='';
    const filteredData = UnivData.filter(item => item.schoolName.includes(search3));

    if (filteredData.length > 0) {
        $(".defaultLi3").hide();
        for (const f of filteredData){
            addLi3 += '<li class="addLi3">'+f.schoolName+'</li>';

        }
    }
    $('#searchResult3').append(addLi3);
})

$(document).on('click', '.addLi3', function () {
    parentTd.find('.universityName').val($(this).text());
    //parentTd.find('input.universityName').val($(this).text());
    modal4.style.display = 'none';
});


