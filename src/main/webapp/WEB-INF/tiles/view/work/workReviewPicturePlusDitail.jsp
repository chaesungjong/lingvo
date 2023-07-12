<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <th scope="row">현장</th>
            <td>A아파트</td>
        </tr>
        <tr>
            <th scope="row">요청자</th>
            <td>홍길동</td>
        </tr>
        <tr>
            <th scope="row">작업중지<br>요청사유</th>
            <td>낙하물 방지망 파손</td>
        </tr>
        <tr>
            <th scope="row">사진</th>
            <td>사진 위치</td>
        </tr>
      </tbody>
  </table>
  <div class="row">
    <div class="col">
      <button class="btn btn-custom btn-block" id="next">확인</button>
    </div>
  </div>
</div>
<script>
    $("#next").click(function() {
        location.href = "/work/requestPictureComfirm";
    });
</script>
