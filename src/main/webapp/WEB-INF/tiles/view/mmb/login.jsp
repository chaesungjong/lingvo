<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="card">
				<div class="card-header card-header-custom">
					<h4>Lingvo</h4>
				</div>
				<div class="card-body">
					<div class="form-group">
						<label for="email">아이디</label>
						<input type="email" class="form-control" id="email" placeholder="아이디">
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" class="form-control" id="password" placeholder="비밀번호">
					</div>
					<div class="row">
						<div class="col">
							<button class="btn btn-custom btn-block" id="loginBtn">로그인</button>
						</div>
					</div>
					<div class="text-center mt-3">
						<a href="#" class="text-decoration-none">아이디 찾기</a> |
						<a href="#" class="text-decoration-none">비밀번호 찾기</a> |
						<a href="#" class="text-decoration-none">회원 가입</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="/js/mmb/login.js"></script>