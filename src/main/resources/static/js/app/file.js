$('.fileBtn').click(function () {
    $(this).closest('td').find('.input-file').click();
});

$('.input-file').change(function () {
    var selectedFileName = $(this).val().split('\\').pop();
    $(this).closest('td').prev('td').find('input').val(selectedFileName);
});

$('.fileBtn2').click(function () {
    $(this).closest('td').find('.input-file2').click();
});

$('.input-file2').change(function () {

    var selectedFiles = this.files;
    var selectedFileNames = [];

    for (var i = 0; i < selectedFiles.length; i++) {
        selectedFileNames.push(selectedFiles[i].name);
    }

    // 파일명을 쉼표로 구분된 문자열로 만듭니다.
    var displayFileName = selectedFileNames.join(', ');

    // 현재 파일 입력 필드의 부모 <td>를 찾고, 그 안에 있는 <input> 값을 업데이트합니다.
    $(this).closest('td').prev('td').find('input').val(displayFileName);

});
