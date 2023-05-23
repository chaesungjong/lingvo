<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
#navbar {
  overflow: hidden;
  background-color: #333;
}
#navbar a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px;
  text-decoration: none;
}
.content {
  padding: 16px;
}
.sticky {
  position: fixed;
  top: 0;
  width: 100%;
}
.sticky + .content {
  padding-top: 60px;
}
</style>
<nav id="navbar" class="navbar fixed-bottom navbar-expand-sm navbar-dark bg-dark">
  <a href="#home">홈</a>
  <a href="#news">비상</a>
  <a href="#contact">위험신고</a>
  <a href="#contact">이슈</a>
</nav>