$(document).ready(function() {
    /**
     * 
     */
    $('div[name=next]').click(function() {
        alert($("#name").val() + " 님 금일 "+ $("#siteName").val()  +" 작업 전 안전예방활동을  시작하겠습니다.");
        //$('div[name=next]').attr('value')
        location.href = "/work/workCheckStep?workType=''&" + "workGubun=" + $('div[name=next]').attr('value');
    });

});