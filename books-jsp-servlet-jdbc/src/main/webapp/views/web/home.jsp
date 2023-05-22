<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<div class="row">
		<c:forEach var="item" items="${model}">
			<div class="col-3">
				<div class="card">
					<img
						src="data:${item.bookImages.get(0).format};base64, ${item.bookImages.get(0).base64Image}"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">${item.name }</h5>
						<h5 class="card-title">ID: ${item.id }</h5>
						<p class="card-text">${item.author }</p>
						<p class="card-text">${item.category.name }</p>
						<p class="card-text">${item.description }</p>
						<p class="card-text">${item.price }</p>
						<div class="">
							<a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
							<a href="#" class="btn btn-success mt-2">Chi tiết</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		
	</div>
</body>
</html>