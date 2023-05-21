<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light mb-2">
			<div class="container-fluid">

				<button type="button" id="sidebarCollapse" class="btn btn-info">
					<i class="fa-solid fa-bars"></i> <span>Toggle Sidebar</span>
				</button>
				

				<!-- Avatar -->
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbar-list-4" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-end" id="navbar-list-4">
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle d-flex align-items-center" href="#"
							id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"> 
							<img
								src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg"
								width="40" height="40" class="rounded-circle">
							<span class="text-center">Welcome <br/> <strong>${USERMODEL.fullName }</strong> </span>
						</a>
							<div class="dropdown-menu right-0 left-unset"
								aria-labelledby="navbarDropdownMenuLink">
								<a class="dropdown-item" href="#">Dashboard</a> <a
									class="dropdown-item" href="#">Edit Profile</a> <a
									class="dropdown-item" href="auth?action=logout">Log Out</a>
							</div></li>
					</ul>
				</div>
			</div>
		</nav>