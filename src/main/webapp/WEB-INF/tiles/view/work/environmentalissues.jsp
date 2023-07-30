<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
    <c:forEach items="${result}" var="workIssueMsgListResponse">
        <div class="col-md-4" name="next">
            <div class="card mb-4">
                <div class="row g-0">
                    <div class="col">
                        <div class="card-body">
                            <p class="card-text">${workIssueMsgListResponse.issueDetail}</p>
                        </div>
                    </div>
                    <div class="col-auto">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                            <label class="form-check-label" for="inlineCheckbox1">${workIssueMsgListResponse.choice1}</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                            <label class="form-check-label" for="inlineCheckbox2">${workIssueMsgListResponse.choice2}</label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    <div class="row">
        <div class="col">
            <button class="btn btn-custom btn-block" id="next">확인</button>
        </div>
    </div>
</div>
<script>
$(document).ready(function() {
    
    /**
     * 
     */
     $("#next").click(function() {
      alert("개선이 필요한 부분의 사진을 등록해주세요. ");
      location.href = "/work/requestPicturePlus";
    });

});
</script>


