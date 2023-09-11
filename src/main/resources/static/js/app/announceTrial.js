// 재판조력자 선택
$('#selectType1').change(function () {

    $(".selectBox3").hide();
    $("#selectType2 option").hide();

    let selType2 = $("#selectType1 option:selected").val();
    if (selType2 === '선택') {
        $(".defaultOpt").show();
    } else {
        $("#selectType2 option").filter(function () {
            return selType2 === $(this).attr("class") && $(this).prev().val() !== $(this).val();
        }).show();
    }
})
$('#selectType2').change(function () {
   
    $(".selectBox3").hide();
    $("#selectType3 option").hide();

    let selType3 = $("#selectType2 option:selected").val();
    console.log(selType3);
    if(selType3 === '공사비등' || selType3 === '조종위원') {
        $(".selectBox3").show();
        if (selType3 === '선택') {
            $(".defaultOpt").show();
        } else {
            $("#selectType3 option").filter(function () {
                return selType3 === $(this).attr("class");
            }).show();
        }
    }
})
