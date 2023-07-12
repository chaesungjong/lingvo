$(document).ready(function() {
    var count = 0;
    /**
     * 
     */
    $("#next").click(function() {

      switch (count) {
        case 0:
          $("#title").text("새로운 현장에서는 신규자 안전교육을 받으셔야 합니다.");
          count++;
          break;
        case 1:
          $("#title").text("개인 안전 보호구를 작업에 적정한지 점검 후 착용합니다.");
          count++;
          break;
        case 2:
          $("#title").text("상부 작업 시 안전고리 체결을 철저히 합니다.");
          count++;
          break;
        case 3:
          $("#title").text("작업 전 작업장 주변 안전시설물 상태를 확인합니다.");
          count++;
          break;
        case 4:
          $("#title").text("주요 작업은 2인1조로 합니다.");
          count++;
        break;
        case 5:
          $("#title").text("중량물 취급 운반 시 무리한 작업은 하지 않습니다.");
          count++;
        break;
        case 6:
          $("#title").text("위험(중장비) 작업구간에는 출입 및 중복 작업을 하지 않습니다.");
          count++;
          break;
        case 7:
          $("#title").text("밀폐공간 작업 시 산소농도 및 유해가스 상태를 측정합니다.");
          count++;
          break;
        case 8:
          alert("일일 안전예방활동을 확인하였습니다. 관리자에게 전송 합니다.");
          location.href = "/work/workCheckStepConfirm";
          break;
      }
    });

});