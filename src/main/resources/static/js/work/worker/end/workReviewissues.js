$(document).ready(function() {
    
    /**
     * 다음 버튼 클릭 시
     */
     $("#next").click(function() {

        // 체크된 체크박스의 값을 저장할 배열
        var checkedValues = [];

        // 체크된 체크박스의 값을 배열에 저장
        $("input[name='checkboxValues']:checked").each(function() {
            checkedValues.push($(this).val());
        });

        // 사용자 체크한 것을 로컬스토리지에 저장
        localStorage.setItem("issuesList", checkedValues);

        alert("개선이 필요한 부분의 사진을 등록해주세요. ");

        location.href = "/work/worker/end/workReviewEndPicturePlus";
    });

});