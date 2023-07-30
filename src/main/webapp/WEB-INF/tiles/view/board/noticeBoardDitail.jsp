<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card text-center">
  <c:forEach var="board" items="${list}">
    <div class="card-body">
      <h5 class="card-title">${board.title}</h5>
      <p class="card-text">${board.content}</p>
      <p class="card-text"><small class="text-muted">${board.regdate}</small></p>
    </div>
  </c:forEach>
</div>