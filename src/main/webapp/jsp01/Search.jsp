<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/flaticon.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Offcanvas Menu Section Begin -->
	<div class="offcanvas-menu-overlay"></div>
	<div class="canvas-open">
		<i class="icon_menu"></i>
	</div>
	<div class="offcanvas-menu-wrapper">
		<div class="canvas-close">
			<i class="icon_close"></i>
		</div>
		<div class="search-icon  search-switch">
			<i class="icon_search"></i>
		</div>
		<div class="header-configure-area">
			<div class="language-option">
				<img src="img/flag.jpg" alt=""> <span>EN <i
					class="fa fa-angle-down"></i></span>
				<div class="flag-dropdown">
					<ul>
						<li><a href="#">Zi</a></li>
						<li><a href="#">Fr</a></li>
					</ul>
				</div>
			</div>
			<a href="<c:url value='/CRUD/searchAllServlet'/>" class="bk-btn">Customer
				Data</a>
		</div>
		<nav class="mainmenu mobile-menu">
			<ul>
				<li><a href="./alreadyindex.jsp">Home</a></li>
				<li class="active"><a href="<c:url value='/ShowAllServlet' />">Rooms</a></li>
				<li><a href="./surviors.jsp">Gifts</a></li>
				<li><a href="<c:url value='/showAttractionsServlet' />">Attractions</a>
					<ul class="dropdown">
						<li><a
							href="<c:url value='/attractions/AddAttractionsForm.jsp' />">add
								Attractions</a></li>
					</ul></li>
				<li><a href="<c:url value='/RestaurantHomepage.jsp'/>">Restaurant</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap"></div>
		<div class="top-social">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i
				class="fa fa-tripadvisor"></i></a> <a href="#"><i
				class="fa fa-instagram"></i></a>
		</div>
		<ul class="top-widget">
			<li><i class="fa fa-phone"></i> (12) 345 67890</li>
			<li><i class="fa fa-envelope"></i> info.colorlib@gmail.com</li>
		</ul>
	</div>
	<!-- Offcanvas Menu Section End -->

	<!-- Header Section Begin -->
	<header class="header-section">
		<div class="top-nav">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<ul class="tn-left">
							<li><i class="fa fa-phone"></i> (12) 345 67890</li>
							<li><i class="fa fa-envelope"></i> info.colorlib@gmail.com</li>
						</ul>
					</div>
					<div class="col-lg-6">
						<div class="tn-right">
							<div class="top-social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-tripadvisor"></i></a> <a href="#"><i
									class="fa fa-instagram"></i></a>
							</div>
							<a href="<c:url value='/CRUD/searchAllServlet'/>" class="bk-btn">Customer
								Data</a>
							<div class="language-option">
								<img src="img/flag.jpg" alt=""> <span>EN <i
									class="fa fa-angle-down"></i></span>
								<div class="flag-dropdown">
									<ul>
										<li><a href="#">Zi</a></li>
										<li><a href="#">Fr</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="menu-item">
			<div class="container">
				<div class="row">
					<div class="col-lg-2">
						<div class="logo">
							<a href="./index.jsp"> <img src="img/logo.png" alt="">
							</a>
						</div>
					</div>
					<div class="col-lg-10">
						<div class="nav-menu">
							<nav class="mainmenu">
								<ul>
									<li><a href="./alreadyindex.jsp">Home</a></li>
									<li class="active"><a
										href="<c:url value='/ShowAllServlet' />">Rooms</a></li>
									<li><a href="./surviors.jsp">Gifts</a></li>
									<li><a href="<c:url value='/showAttractionsServlet' />">Attractions</a>
										<ul class="dropdown">
											<li><a
												href="<c:url value='/attractions/AddAttractionsForm.jsp' />">add
													Attractions</a></li>
										</ul></li>
									<li><a href="<c:url value='/RestaurantHomepage.jsp'/>">Restaurant</a></li>
								</ul>
							</nav>
							<div class="nav-right search-switch">
								<i class="icon_search"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- 我的內容 -->
	<form action="<c:url value='/SearchRestaurantServerlet'/>" method="post"
		align="center">

		<button type="submit" name="1">查詢全部資料</button>




	</form>
	<form action="<c:url value='/SearchRestaurantServletbyid'/>"
		method="post">
		<table align="center">
			<tr>
				<td align="Right">用ID查詢餐廳資料:</td>
				<td align="Left"><input type="number" min="1"
					onkeyup="value=value.replace(/[^\d]/g,'') " name="restaurantid">
					<span style="color: red"><b>${nullError2} ${nullError9}</b></span></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>

	<form action="<c:url value='/searchRestype'/>" method="post">
		<table align="center">
			<tr>
				<td align="Right">用種類找餐廳:</td>
				<td align="Left"><input type="text" name="resturanttype">
					<span style="color: red"><b>${nullError3}</b></span></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>

	<form action="<c:url value='/SearchRestaurantServletbyname'/>"
		method="post">
		<table align="center">
			<tr>
				<td align="Right">用名子找餐廳:</td>
				<td align="Left"><input type="text" name="resturantname">
					<span style="color: red"><b>${nullError4}</b></span></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
	<form action="<c:url value='/SearchRestaurantServletbyaddress'/>"
		method="post">
		<table align="center">
			<tr>
				<td align="Right">用地址找餐廳:</td>
				<td align="Left"><input type="text" name="resturantaddress">
					<span style="color: red"><b>${nullError5}</b></span></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>

	<!-- Footer Section Begin -->
	<footer class="footer-section">
		<div class="container">
			<div class="footer-text">
				<div class="row">
					<div class="col-lg-4">
						<div class="ft-about">
							<div class="logo">
								<a href="#"> <img src="img/footer-logo.png" alt="">
								</a>
							</div>
							<p>
								We inspire and reach millions of travelers<br /> across 90
								local websites
							</p>
							<div class="fa-social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-tripadvisor"></i></a> <a href="#"><i
									class="fa fa-instagram"></i></a> <a href="#"><i
									class="fa fa-youtube-play"></i></a>
							</div>
						</div>
					</div>
					<div class="col-lg-3 offset-lg-1">
						<div class="ft-contact">
							<h6>Contact Us</h6>
							<ul>
								<li>(12) 345 67890</li>
								<li>info.colorlib@gmail.com</li>
								<li>856 Cordia Extension Apt. 356, Lake, United State</li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3 offset-lg-1">
						<div class="ft-newslatter">
							<h6>New latest</h6>
							<p>Get the latest updates and offers.</p>
							<form action="#" class="fn-form">
								<input type="text" placeholder="Email">
								<button type="submit">
									<i class="fa fa-send"></i>
								</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="copyright-option">
			<div class="container">
				<div class="row">
					<div class="col-lg-7">
						<ul>
							<li><a href="#">Contact</a></li>
							<li><a href="#">Terms of use</a></li>
							<li><a href="#">Privacy</a></li>
							<li><a href="#">Environmental Policy</a></li>
						</ul>
					</div>
					<div class="col-lg-5">
						<div class="co-text">
							<p>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;
								<script>
									document.write(new Date().getFullYear());
								</script>
								All rights reserved | This template is made with <i
									class="fa fa-heart" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Section End -->

	<!-- Search model Begin -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch">
				<i class="icon_close"></i>
			</div>
			<form class="search-model-form">
				<input type="text" id="search-input" placeholder="Search here.....">
			</form>
		</div>
	</div>
	<!-- Search model end -->

	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>