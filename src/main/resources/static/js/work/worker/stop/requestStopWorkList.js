$(document).ready(function() {

    $(".col-md-4").click(function() {
        var pElement = $(this).find("p");
        localStorage.setItem("issue", pElement.text());
        location.href = "/work/worker/stop/stopMessageList?issueGubun=" + $(this).attr("value");
    });

});
