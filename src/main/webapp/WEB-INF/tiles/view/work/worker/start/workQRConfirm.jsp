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
  <h6 class="border-bottom pb-2 mb-0">아래 정보를 꼭 확인 후  진행하여 주세요.</h6>
  <h6 class="border-bottom pb-2 mb-0">실제 현장과 다른 경우 고객센터 1234-1111로 문의 바랍니다.</h6>
  <table class="table">
      <tbody>
        <tr>
            <th scope="row">위치</th>
            <td>${siteAddress}</td>
        </tr>
        <tr>
            <th scope="row">현장</th>
            <td>${siteName}</td>
        </tr>
        <tr>
            <th scope="row">시공사</th>
            <td>${constName}</td>
        </tr>
        <tr>
            <th scope="row">소속회사</th>
            <td>${companyName}</td>
        </tr>
        <tr>
            <th scope="row">공종</th>
            <td>${workType}</td>
        </tr>
      </tbody>
  </table>
  <div class="row">
    <div class="col">
      <button class="btn btn-custom btn-block" id="next">다음</button>
    </div>
  </div>
</div>
<script src="/js/work/worker/start/workQRConfirm.js"></script>