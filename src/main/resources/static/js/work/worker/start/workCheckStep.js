$(document).ready(function() {

  // $("#message").val()로 가져온 값
  var dataString = $("#message").val();
  var countClick = 0;
  const stringWithoutBrackets = dataString.slice(1, -1);

  // 배열로 변환
  var parsedArray = convertStringToArray(stringWithoutBrackets);
  console.log(parsedArray);

  $("#title").text(parsedArray[countClick]);

  /**
   * 일 작업 리스트 점검 체크
   */
  $("#next").click(function() {

    // 버튼 비활성화
    $(this).prop('disabled', true);
    if(parsedArray.length == countClick){
      alert("일일 안전예방활동을 확인하였습니다. 관리자에게 전송 합니다.");
      location.href = "/work/worker/start/workCheckStepConfirm?" + "workGubun=" +localStorage.getItem('workGubun');
    }else{
      countClick++;
      $("#title").text(parsedArray[countClick]);
    }

    // 2초 후 버튼 활성화
    setTimeout(() => {
        $(this).prop('disabled', false);
    }, 2000);

  });

});

// 쉼표로 구분된 문자열을 배열로 변환하는 함수
function convertStringToArray(str) {
  return str.split(".,");
}
