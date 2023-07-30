<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="list-group list-group-flush border-bottom scrollarea">
  <c:forEach var="board" items="${list}">
    <a href="/board/noticeBoard?Gubun=boardView&seq=${board.seq}" class="list-group-item list-group-item-action py-3 lh-sm">
        <div class="col-10 mb-1 small">${board.regdate}</div>
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">${board.title}</strong>
        </div>
    </a>
  </c:forEach>
</div>