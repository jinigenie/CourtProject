
//////////////////////////  임시저장 모달창 ////////////////////////

const modal = document.querySelector('.modal');
let x = 0;

$(".prev_btn").click(function () {
    modal.style.display = 'block';
    x = 1;
    $("#xField").val(x);
})

$(".save").click(function () {

    $(location).attr("href", "../app/edu");
    x = 0;
    $("#xField").val(x);
})

$(".cancel").click(function () {
    $(location).attr("href", "../app/edu");
})

$(".dmui_dialog_btn").click(function () {
    modal.style.display = 'none';
})


//////////////////////////  최종제출 모달창 ////////////////////////

const modal2 = document.querySelector('.modal2');

$(".submit_btn").click(function () {
    modal2.style.display = 'block';
    x = 2;
    $("#xField").val(x);
})

$(".save2").click(function () {
    $(location).attr("href", "../app/submit");
    x = 0;
    $("#xField").val(x);
})

$(".cancel2").click(function () {
    modal2.style.display = 'none';
})

$(".dmui_dialog_btn").click(function () {
    modal2.style.display = 'none';
})


// --------------------------------------------------------------------

//////////////////////////  file upload & delete ////////////////////////

var file_code = '';         // 서류코드
var file_type = '';         // 서류타입

$('.fileBtn').click(function () {
    file_type = $(this).closest('td').attr('id');
    $(this).closest('td').find('.input-file').click();
});

$('.input-file').change(function () {

    var selectedFile = this.files[0];

    if (selectedFile) {
        var selectedFileName = selectedFile.name;
        $(this).closest('td').prev('td').find('input').val(selectedFileName);

        file_code = 'CO';

        var formData = new FormData();
        formData.append('file_data', selectedFile);
        formData.append('file_code', file_code);
        formData.append('file_type', file_type);

        fetch('/cloudUpload1', {
            method: 'post',
            body: formData
        })
            .then(response => response.text())
            .then(data => {
                console.log(data);
            })
            .catch(err => alert('업로드에 실패했습니다:' + err));
    }
});

$('.fileBtn2').click(function () {
    file_type = $(this).closest('td').attr('id');
    $(this).closest('td').find('.input-file2').click();
});

$('.input-file2').change(function () {

    var selectedFiles = this.files;
    var selectedFileNames = [];

    console.log(selectedFiles);

    if (selectedFiles.length === 0) {
        return;
    }

    for (var i = 0; i < selectedFiles.length; i++) {
        selectedFileNames.push(selectedFiles[i].name);
    }

    var displayFileName = selectedFileNames.join(',');
    $(this).closest('td').prev('td').find('input').val(displayFileName);

    file_code = 'PE';

    var formData = new FormData();
    for (var i = 0; i < selectedFiles.length; i++) {
        formData.append('file_data', selectedFiles[i]);
        formData.append('file_code', file_code);
        formData.append('file_type', file_type);
    }

    fetch('/cloudUpload2', {method: 'post', body: formData})
        .then(response => response.text())
        .then(data => {
            console.log(data);
        })
        .catch(err => alert('업로드에 실패했습니다:' + err));
});

$('.delBtn').click(function (){

    let del_file = $(this).closest('tr').find('[name="requiredFile"]').val();
    if(del_file != ''){

        let formData = new FormData();
        formData.append("del_file", del_file);

        fetch("/delete_file", {method: 'post', body: formData})
            .then(response => response.text())
            .then(data => {
                console.log(data);
            })
            .catch(err => alert("삭제 실패하였습니다." + err))

        $(this).closest('td').prev('td').find('input').val('');
    }
})


$('.delBtn2').click(function (){

    let del_files = $(this).closest('tr').find('[name="personalFile"]').val();
    if(del_files != ''){

        var delList = del_files.split(',');
        console.log(delList);
        console.log(delList[0]);
        console.log(delList[1]);

        let formData = new FormData();

        for (var i = 0; i < delList.length; i++) {
            formData.append('del_file', delList[i]);
        }

        fetch("/delete_files", {method: 'post', body: formData})
            .then(response => response.text())
            .then(data => {
                console.log(data);
            })
            .catch(err => alert("삭제 실패하였습니다." + err))

        $(this).closest('td').prev('td').find('input').val('');
    }
})


