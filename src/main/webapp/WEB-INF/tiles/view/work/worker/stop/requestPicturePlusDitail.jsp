<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
  .table {
      border: 1px solid #dee2e6;
  }

  .table th, .table td {
      border: 1px solid #dee2e6;
  }

  .table td {
      vertical-align: middle;
  }
</style>
<div class="container mt-5">
  <table class="table">
      <tbody>
        <tr>
          <th scope="row">위치</th>
          <td>${location}</td>
      </tr>
        <tr>
            <th scope="row">현장</th>
            <td>${siteName}</td>
        </tr>
        <tr>
            <th scope="row">요청자</th>
            <td>${name}</td>
        </tr>
        <tr>
            <th scope="row">작업중지<br>요청사유</th>
            <td id="requestWork"></td>
        </tr>
        <tr>
            <th scope="row">사진</th>
            <td id="imgDiv">사진 위치</td>
        </tr>
      </tbody>
  </table>
  <div class="row">
    <div class="col">
      <button class="btn btn-custom btn-block" id="next">확인</button>
    </div>
  </div>
</div>
<form id="Comfirm" action= "/work/worker/stop/requestPictureComfirm" method="post">
  <input type="hidden" id="imageList"  name="imageList">
  <input type="hidden" id="issuesList" name="issuesList">
  <input type="hidden" id="issue" name="issue">
</form>
<script src="/js/work/worker/stop/requestPicturePlusDitail.js"></script>