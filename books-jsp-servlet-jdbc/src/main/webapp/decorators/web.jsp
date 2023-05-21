<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="<c:url value = "/assets/web/css/grid.css"/> ">
<link rel="stylesheet" href="<c:url value = "/assets/web/css/base.css"/> ">
<link rel="stylesheet" href="<c:url value = "/assets/web/css/app.css"/> ">
<link rel="stylesheet"
	href="<c:url value = "/assets/css/responsive.css"/> ">

</head>
<body>
	<!-- header -->
	<%@include file="/common/web/header.jsp"%>

	<div class="container">
		<dec:body />
	</div>

	<!-- footer -->
	<%@include file="/common/web/footer.jsp"%>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>