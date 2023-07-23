$(document).ready(function() {
    /**
     * 
     */
    $("#next").click(function() {


      location.href = "/work/workedList";
    });

});


function nativeARSCall() {
  ajaxRequest("","",function(){},function(){});
}