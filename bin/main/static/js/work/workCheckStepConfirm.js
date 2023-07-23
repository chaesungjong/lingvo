$(document).ready(function() {
    /**
     * 
     */
    $("#next").click(function() {
      nativeARSCall() ;
    });

});

function nativeARSCall() {
  ajaxRequest("/work/workStartARSCall","",function(res){
    if(res.errCode != null && res.errCode == "0"){
      location.href = "/work/resultWorkARSCall?gubun=AICALL_END&workGubun=N";
    }else{
      alert(res.errMsg);
    }
  },function(res){
    alert(res.errMsg);
  });
}