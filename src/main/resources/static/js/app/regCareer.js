// <!--모달창 : 저장-->
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
        $(location).attr("href", "../app/info");
    } else {
        $(location).attr("href", "../app/edu");
    }
    x = 0;
})

$(".dmui_dialog_btn").click(function () {
    modal.style.display = 'none';
})



function deleteLine(obj) {
    var tr = $(obj).parent().parent();
    tr.remove();
}
