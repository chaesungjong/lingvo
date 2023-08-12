$(document).ready(function() {

    $(".col-md-4").click(function() {
        location.href = "/work/worker/end/workReviewissues?issueGubun=" + $(this).attr("value");
    });
  

});
