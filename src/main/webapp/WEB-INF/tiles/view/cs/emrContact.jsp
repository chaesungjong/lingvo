<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="list-group list-group-checkable d-grid gap-2 border-0 w-auto">
  <c:forEach items="${list}" var="emergencyInfo">
    <a href="tel:${emergencyInfo.hpno}"><label class="list-group-item rounded-3 py-3" for="listGroupCheckableRadios1">${emergencyInfo.companyName}<span class="material-symbols-outlined">call</span></label></a>
  </c:forEach>
</div>