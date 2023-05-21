<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav id="sidebar">
	<div class="sidebar-header">
		<h3>Trang quản trị</h3>
	</div>

	<ul class="list-unstyled components">
		<li><a href="<c:url value="/admin-trang-chu"/>">Dashboard</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#pageSubmenu" data-toggle="collapse"
			aria-expanded="false" class="dropdown-toggle">Quản lý <i class="fa-solid fa-caret-down"></i></a>
			<ul class="collapse list-unstyled" id="pageSubmenu">
				<li><a href="#">Danh mục sách</a></li>
				<li><a href="<c:url value="/admin-books?type=list"/>">Sách</a></li>
				<li><a href="#">Khách hàng</a></li>
				<li><a href="#">Đơn hàng</a></li>
			</ul></li>
		<li><a href="#">Portfolio</a></li>
		<li><a href="#">Contact</a></li>
	</ul>

	<ul class="list-unstyled CTAs">
		<li><a href="#" class="download">Download source</a></li>
		<li><a href="#" class="article">Back to article</a></li>
	</ul>
</nav>