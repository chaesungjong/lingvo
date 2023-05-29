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
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<div class="topnav">
  <a href="#home" class="active">Lingvo</a>
  <div id="myLinks">
    <a href="#news">메인</a>
    <a href="#contact" class="navitem">금일 작업 시작하기</a>
    <a href="#about" class="navitem">나의 지난 작업</a>
    <a href="#about" class="navitem">비상 연락망</a>
    <a href="#about" class="navitem">위험 신고</a>
    <a href="#about" class="navitem">이슈 게시판</a>
    <a href="#about">고객센터</a>
    <a href="#about" class="navitem">공지사항</a>
    <a href="#about" class="navitem">FAQ</a>
    <a href="#about" class="navitem">고객센터 전화 걸기</a>
    <a href="#about">회원정보</a>
    <a href="#about" class="navitem">회원정보 수정</a>
    <a href="#about" class="navitem">생체 인증 로그인 설정</a>
    <a href="#about">로그아웃</a>
  </div>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>