<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<div class="w-50 mx-auto mt-5">
		<form>
			<h1 class="text-center">Đăng ký</h1>
			
			<!-- Username input -->
			<div class="form-outline mb-4">
				<input type="email" id="form1Example1" class="form-control" /> <label
					class="form-label" for="form1Example1">Username</label>
			</div>

			<!-- Email input -->
			<div class="form-outline mb-4">
				<input type="email" id="form1Example1" class="form-control" /> <label
					class="form-label" for="form1Example1">Email address</label>
			</div>

			<!-- Password input -->
			<div class="form-outline mb-4">
				<input type="password" id="form1Example2" class="form-control" /> <label
					class="form-label" for="form1Example2">Password</label>
			</div>

			<!-- 2 column grid layout for inline styling -->
			<div class="row mb-4">
				<div class="col d-flex justify-content-center">
					
				</div>

				<div class="col">
					<!-- Simple link -->
					<span>Bạn đã có tài khoản?</span>
					<a href="auth?action=login">Đăng nhập</a>
				</div>
			</div>

			<!-- Submit button -->
			<button type="submit" class="btn btn-primary btn-block">Đăng ký</button>
		</form>

	</div>
</body>
</html>