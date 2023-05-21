<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="w-50 mx-auto mt-5">
		<form method="POST" action="auth?action=login">
			<h1 class="text-center">Đăng nhập</h1>

			<c:if test="${not empty message}">
				<div class="note note-${alert} mb-3">
					<strong>${message}</strong>
				</div>
			</c:if>

			<!-- Email input -->
			<div class="form-outline mb-4">
				<input type="text" id="username" name="username"
					class="form-control" autocomplete="off" /> <label
					class="form-label" for="username">Username</label>
			</div>

			<!-- Password input -->
			<div class="form-outline mb-4">
				<input type="password" id="password" name="password"
					class="form-control" /> <label class="form-label" for="password">Password</label>
			</div>


			<!-- 2 column grid layout for inline styling -->
			<div class="row mb-4">
				<div class="col">
					<!-- Simple link -->
					<span>Bạn chưa có tài khoản?</span> <a href="auth?action=register">Đăng
						ký</a>
				</div>
			</div>



			<!-- Submit button -->
			<button type="submit" class="btn btn-primary btn-block">Đăng
				nhập</button>
		</form>

	</div>
</body>
</html>