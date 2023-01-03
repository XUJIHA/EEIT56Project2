<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<! DOCTYPE  html >
<html lang="zh-Hant ">

<head>
<meta charset="UTF-8">
<meta name="description" content="Sona Template">
<meta name="keywords" content="Sona, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sona</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Cabin:400,500,600,700&display=swap"
	rel="stylesheet">

<%
String path = request.getContextPath();
String basePath10 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
  + "/js/jquery-3.3.1.min.js";
String basePath11 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/js/bootstrap.min.js";
String basePath12 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/js/jquery.magnific-popup.min.js";
String basePath13 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/js/jquery.nice-select.min.js";
String basePath14 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/js/jquery-ui.min.js";
String basePath15 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/js/jquery.slicknav.js";
String basePath16 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/js/owl.carousel.min.js";
String basePath17 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/js/main.js";
%>
<!-- Js Plugins -->
<script src="<%=basePath10%>"></script>
<script src="<%=basePath11%>"></script>
<script src="<%=basePath12%>"></script>
<script src="<%=basePath13%>"></script>
<script src="<%=basePath14%>"></script>
<script src="<%=basePath15%>"></script>
<script src="<%=basePath16%>"></script>
<script src="<%=basePath17%>"></script>
<script src="https://kit.fontawesome.com/27e0c99202.js" crossorigin="anonymous"></script>
<!-- Css Styles -->
<!-- 絕對路徑 -->
<% 
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
  + "/css/bootstrap.min.css";
String basePath1= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/css/font-awesome.min.css";
String basePath2= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/css/elegant-icons.css";
String basePath3= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/css/flaticon.css";
String basePath4= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/css/owl.carousel.min.css";
String basePath5= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/css/nice-select.css";
String basePath6= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/css/jquery-ui.min.css";
String basePath7= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/css/magnific-popup.css";
String basePath8= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/css/slicknav.min.css";
String basePath9= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
+ "/css/style.css";
%>


<link rel="stylesheet" href="<%=basePath%>" type="text/css">
<link rel="stylesheet" href="<%=basePath1%>" type="text/css">
<link rel="stylesheet" href="<%=basePath2%>" type="text/css">
<link rel="stylesheet" href="<%=basePath3%>" type="text/css">
<link rel="stylesheet" href="<%=basePath4%>" type="text/css">
<link rel="stylesheet" href="<%=basePath5%>" type="text/css">
<link rel="stylesheet" href="<%=basePath6%>" type="text/css">
<link rel="stylesheet" href="<%=basePath7%>" type="text/css">
<link rel="stylesheet" href="<%=basePath8%>" type="text/css">
<link rel="stylesheet" href="<%=basePath9%>" type="text/css">

<!-- 絕對路徑 -->
<!-- Css Styles -->
<!-- <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/elegant-icons.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/flaticon.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/nice-select.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/magnific-popup.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/slicknav.min.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/style.css" type="text/css"> -->
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
			<a href="<c:url value='/LoginLogout/login.jsp' />" class="bk-btn">Login Now</a>
		</div>
		<nav class="mainmenu mobile-menu">
			<ul>
				<li class="active"><a href="index.jsp">Home</a></li>
				<li><a href="<c:url value='index.jsp' />">Rooms</a></li>
				
<!-- 				<li><a href="./about-us.html">About Us</a></li> -->
<!-- 				<li><a href="./pages.html">Pages</a> -->
<!-- 					<ul class="dropdown"> -->
<!-- 						<li><a href="./room-details.html">Room Details</a></li> -->
<!-- 						<li><a href="#">Deluxe Room</a></li> -->
<!-- 						<li><a href="#">Family Room</a></li> -->
<!-- 						<li><a href="#">Premium Room</a></li> -->
<!-- 					</ul></li> -->
				<li><a href="index.jsp">Attractions
<!-- 					<ul class="dropdown"> -->
<%-- 						<li><a href="<c:url value='/attractions/AddAttractionsForm.jsp' />">add Attractions</a></li> --%>
<!-- 					</ul> -->
				</a></li>
<!-- 				<li><a href="./contact.html">Contact</a></li> -->
				<li><a href="index.jsp">Gifts</a></li>
				<li><a href="index.jsp">Restaurant</li>
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
							<a href="<c:url value='/LoginLogout/login.jsp' />" class="bk-btn">Login Now</a>
							<div class="language-option">
								<img src="../img/flag.jpg" alt=""> <span>EN <i
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
							<a href="../index.jsp"> <img src="../img/logo.png" alt="">
							</a>
						</div>
					</div>
					<div class="col-lg-10">
						<div class="nav-menu">
							<nav class="mainmenu">
								<ul>
									<li class="active"><a href="../index.jsp">Home</a></li>
									<li><a href="<c:url value='../index.jsp' />">Rooms</a></li>
									<li><a href="../index.jsp">Attractions</a></li>
									<li><a href="../index.jsp">Gifts</a></li>
									<li><a href="../index.jsp">Restaurant</a></li>
								</ul>
							</nav>
							<a href="<c:url value='../index.jsp' />"><i
								class="fa-solid fa-cart-shopping" style="color: black"></i></a>
							<div class="nav-right search-switch">
								<i class="icon_search"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Header End -->

	<script type="text/javascript">
		
	<%-- 對輸入的賬號資訊進行判斷，賬號密碼不能為空且必須輸入驗證碼 --%>
		function validate() {

			if (login.USER_EMAIL.value === "") {
				alert("帳號不能為空");
				return;
			}
			if (login.USER_PASSWORD.value === "") {
				alert("密碼不能為空");
				return;
			}
			if (login.code.value === "") {
				alert("請輸入驗證碼");
				return;
			}
			login.submit();

		}
		function refresh() {
			login.imgValidate.src = "<%=request.getContextPath()%>/confirm.jsp?id=" + Math.random();
		}
	</script>


	<form name="login" action="<c:url value="/LoginServlet" />" method="Post">
		<label for="USER_EMAIL">E-mail :</label>
		<input type="email" id="USER_EMAIL" name="USER_EMAIL"><br> 
		<label for="USER_PASSWORD">密碼:</label>
		<input type="password" id="USER_PASSWORD" name="USER_PASSWORD"><br>
		<div style="text-align: center">
			驗證碼：<input type="text" name="code" size=10>
			<%--點選圖片可進行驗證碼重新整理--%>
			<img name="imgValidate"
				src="<%=request.getContextPath()%>/LoginLogout/confirm.jsp"
				onclick="refresh()">
		</div>
		<br>
		<div style="text-align: center">
			<input type="checkbox" name="keep">兩週內免登陸<br>
		</div>
		<br>
		<p>${errorMsgMap.LoginError}</p>
		<div style="text-align: center">
			<input type="button" value="登入" onclick="validate()">
		</div>
	</form>

	<%
		String USER_EMAIL = null;
		String USER_PASSWORD = null;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {

			if ("USER_EMAIL".equals(cookies[i].getName())) {

				USER_EMAIL = cookies[i].getValue();
			} else if ("USER_PASSWORD".equals(cookies[i].getName())) {

				USER_PASSWORD = cookies[i].getValue();
			}
		}
		if (USER_EMAIL != null && USER_PASSWORD != null) {
			response.sendRedirect("index.jsp?uname=" + USER_EMAIL + " &password=" + USER_PASSWORD);
		}
		%>

	</form>
	<form action="<c:url value="/LoginLogout/register.jsp" />" method="post">
		<div style="text-align: center">
			<input type="submit" value="註冊">
		</div>
	</form>
	<br>
	<!-- Footer Section Begin -->
	<footer class="footer-section">
		<div class="container">
			<div class="footer-text">
				<div class="row">
					<div class="col-lg-4">
						<div class="ft-about">
							<div class="logo">
								<a href="#"> <img src="../img/footer-logo.png" alt="">
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


</body>

</html>