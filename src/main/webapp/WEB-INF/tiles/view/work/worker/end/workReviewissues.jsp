<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
    <c:forEach items="${result}" var="workIssueMsgListResponse" varStatus="status">
        <div class="col-md-4">
            <div class="card mb-4">
                <div class="row g-0">
                    <div class="col">
                        <div class="card-body">
                            <p class="card-text">${workIssueMsgListResponse.issueDetail}</p>
                        </div>
                    </div>
                    <div class="col-auto">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="checkboxValues" id="inlineCheckbox${status.index * 2 + 1}" value="${workIssueMsgListResponse.issueDetail}${workIssueMsgListResponse.choice1}">
                            <label class="form-check-label" for="inlineCheckbox${status.index * 2 + 1}">${workIssueMsgListResponse.choice1}</label>
                        </div>
                        <c:if test="${not empty workIssueMsgListResponse.choice2}">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" name="checkboxValues" id="inlineCheckbox${status.index * 2 + 2}" value="${workIssueMsgListResponse.issueDetail}${workIssueMsgListResponse.choice2}">
                                <label class="form-check-label" for="inlineCheckbox${status.index * 2 + 2}">${workIssueMsgListResponse.choice2}</label>
                            </div>
                        </c:if>
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
<script src="/js/work/worker/end/workReviewissues.js"></script>