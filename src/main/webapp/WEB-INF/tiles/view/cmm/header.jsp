<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.topnav {
  overflow: hidden;
  background-color: #333;
  position: relative;
  background-color: #018786;
  border-color: #018786;
  color: white;
}

.topnav #myLinks {
  display: none;
}

.topnav a {
  color: white;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
  display: block;
}

.topnav a.icon {
  background: black;
  display: block;
  position: absolute;
  background-color: #018786;
  border-color: #018786;
  color: white;
  right: 0;
  top: 0;
}

.navitem {
  background-color: #04AA6D;
  color: white;
}

.me-2 {
    margin-right: 0.5rem!important;
}
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<div class="topnav">
  <a href="/work/main" class="active"><span class="me-2"><img src="/image/lingvo.svg" ></span>Lingvo</a>
  <div id="myLinks">
    <a href="javascript:void(0);" onclick="CustomAlert();" >메인</a>
    <a href="javascript:void(0);" onclick="CustomAlert();"  class="navitem">금일 작업 시작</a>
    <a href="javascript:void(0);" onclick="CustomAlert();"  class="navitem">작업 중지 요청</a>
    <a href="javascript:void(0);" onclick="CustomAlert();"  class="navitem">작업 후기</a>
    <a href="javascript:void(0);" onclick="CustomAlert();"  class="navitem">비상연락망</a>
    <a href="javascript:void(0);" onclick="CustomAlert();"  class="navitem">전달 사항</a>
    <a href="javascript:void(0);" onclick="CustomAlert();" >고객센터</a>
    <a href="javascript:void(0);" onclick="CustomAlert();"  class="navitem">공지사항</a>
    <a href="javascript:void(0);" onclick="CustomAlert();"  class="navitem">FAQ</a>
    <a href="javascript:void(0);" onclick="CustomAlert();"  class="navitem">고객센터 전화 걸기</a>
    <a href="javascript:void(0);" onclick="CustomAlert();" >회원정보</a>
    <a href="javascript:void(0);" onclick="CustomAlert();"  class="navitem">회원정보 수정</a>
    <a href="javascript:void(0);" onclick="CustomAlert();"  class="navitem">생체 인증 로그인 설정</a>
    <a href="javascript:void(0);" onclick="CustomAlert();" >로그아웃</a>
  </div>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>