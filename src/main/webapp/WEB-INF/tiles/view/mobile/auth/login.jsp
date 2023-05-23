<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">	
	<h2>Lingvo</h2>
	<form action="/auth/loginProcess.do" method="post">
		<div class="mb-3">
			<label class="form-label" for="id">아이디</label> 
			<input class="form-control" type="text" name="id" id="id" />
		</div>
		<div class="mb-3">
			<label class="form-label" for="pwd">비밀번호</label> 
			<input class="form-control" type="password" name="pwd" id="pwd" />
		</div>
		<button class="btn btn-outline-primary btn-sm" type="submit" id="loginBtn"">로그인</button>
	</form>
</div>
<script src="../js/mobile/auth/login.js"></script>