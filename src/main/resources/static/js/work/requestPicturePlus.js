$(document).ready(function() {
    /**
     * 사진 추가
     */
    $("#addPicture").click(function() { callCamera("imageDiv"); });

    /**
     * 확인 버튼
     */
    $("#next").click(function() {
        location.href = "/work/requestPicturePlusDitail";
    });

});