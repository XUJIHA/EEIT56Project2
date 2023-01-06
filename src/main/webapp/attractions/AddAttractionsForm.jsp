<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Attractions Form</title>
	
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
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
	
	

<!-- 	<link rel="stylesheet" href="/project2/css/bootstrap.min.css"> -->
<%-- 	<link rel="stylesheet" href="<%=basePath%>" type="text/css"> --%>
<link rel="stylesheet" href="/Team3_Hibernate/css/styleA.css" type="text/css">
	
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
				<img src="../img/flag.jpg" alt=""> <span>EN <i
					class="fa fa-angle-down"></i></span>
				<div class="flag-dropdown">
					<ul>
						<li><a href="#">Zi</a></li>
						<li><a href="#">Fr</a></li>
					</ul>
				</div>
			</div>
			<a href="<c:url value='/loginlogout/controller/searchAllServlet'/>" class="bk-btn">Customer Data</a>
		</div>
		<nav class="mainmenu mobile-menu">
			<ul>
				<li><a href="<c:url value='/LoginLogout/alreadyindex.jsp'/>">Home</a></li>
				<li><a href="<c:url value='/ShowAllServlet' />">Rooms</a></li>
				<li><a href="<c:url value='/Gift/gift.jsp'/>">Gifts</a></li>
				<li><a href="<c:url value='/showAttractionsServlet' />">Attractions</a>
					<ul class="dropdown">
						<li>
							<a href="<c:url value='/attractions/AddAttractionsForm.jsp' />">add Attractions</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="<c:url value='/jsp01/RestaurantHomepage.jsp'/>">Restaurant</a>
				</li>
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
							 <a href="<c:url value='/loginlogout/controller/searchAllServlet'/>" class="bk-btn">Customer
								Data</a>
							<div class="language-option">
								<img src="<c:url value='/img/flag.jpg'/>" alt="">
								<span>EN <i class="fa fa-angle-down"></i></span>
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
							<a href="<c:url value='/LoginLogout/alreadyindex.jsp'/>"> 
								<img src="<c:url value='/img/logo.png'/>" alt="">
							</a>
						</div>
					</div>
					<div class="col-lg-10">
						<div class="nav-menu">
							<nav class="mainmenu">
							  <ul>
								<li><a href="<c:url value='/LoginLogout/alreadyindex.jsp'/>">Home</a></li>
								<li><a href="<c:url value='/ShowAllServlet' />">Rooms</a></li>
								<li><a href="<c:url value='/Gift/gift.jsp'/>">Gifts</a></li>
								<li><a href="<c:url value='/showAttractionsServlet' />">Attractions</a>
									<ul class="dropdown">
										<li>
											<a href="<c:url value='/attractions/AddAttractionsForm.jsp' />">add Attractions</a>
										</li>
									</ul>
								</li>
								<li>
									<a href="<c:url value='/jsp01/RestaurantHomepage.jsp'/>">Restaurant</a>
								</li>
							  </ul>
							</nav>
							<a href="<c:url value='/orderRoom/SearchOrderServlet' />"><i
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

<div class="container">
        <form action="checkadd.controller" method="POST" enctype="multipart/form-data">
<!--        	    <header> -->
<!-- 		        <h1>新增景點</h1> -->
<!-- 		    </header> -->
			<h3>新增景點</h3><hr>
<!-- 			<div class="col-xs-7"> -->
<!--                 <label for=name class="form-label">景點名稱:</label> -->
<%-- 			    <input class="form-control" type="text" name="name" value="${param.name }" id="name" placeholder="景點名稱" size="20" autofocus autocomplete="off"> --%>
<%--                 <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.name}</div> --%>
<!--             </div> -->
<!-- <i class="fa-sharp fa-solid fa-circle-exclamation"></i>  -->
			<div class="row">
                <label for=name class="form-label col-sm-1">景點名稱</label>
<%-- 			    <input class="form-control col-sm-5" type="text" name="name" value="${param.name }" id="name" placeholder="請輸入景點名稱" size="20" autofocus autocomplete="off"> --%>
			    <input class="form-control col-sm-5" type="text" name="name" id="name" placeholder="請輸入景點名稱" size="20" autofocus autocomplete="off">
                <div class="col-sm-2" style="color:#FF0000; font-size:80%; display: inline">${errors.name}</div>
            </div><br>
            <div class="row">
                <label for=address class="form-label col-sm-1">地址</label>
<%--                 <input class="form-control col-sm-5" type="text" name="address" value="${param.address }" id="address" placeholder="請輸入景點地址" size="20" autofocus autocomplete="off"> --%>
                <input class="form-control col-sm-5" type="text" name="address" id="address" placeholder="請輸入景點地址" size="20" autofocus autocomplete="off">
                <div class="col-sm-2" style="color:#FF0000; font-size:80%; display: inline">${errors.address}</div>
            </div><br>
	  		<div class="row">
	  			<label for="serviceHour" class="form-label col-sm-1">營業時間</label>
<%-- 				<input class="form-control col-sm-2" id="serviceHour" type="time" name="serviceHour" value="${param.serviceHour } " min="00:00" max="24:00"/> --%>
               	<input class="form-control col-sm-2" id="serviceHour" type="time" name="serviceHour" min="00:00" max="24:00"/>
               	<input class="form-control col-sm-2" id="serviceHour2" type="time" name="serviceHour2" min="00:00" max="24:00"/>
               	<div class="col-sm-2" style="color:#FF0000; font-size:80%; display: inline">${errors.serviceHour}</div>
	    	</div><br>
            <div class="row">
                <label for="introduction" class="form-label col-sm-1">介紹</label>
<%--                 <textarea class="form-control col-sm-5" name="introduction" id="introduction" cols="40" rows="7">${param.introduction }</textarea> --%>
                <textarea class="form-control col-sm-5" name="introduction" id="introduction" cols="40" rows="7"></textarea>
                <div class="col-sm-2" style="color:#FF0000; font-size:80%; display: inline">${errors.introduction}</div>
            </div><br>
            <div class="row">
                <label for="phone" class="form-label col-sm-1">電話</label>
<%--                 <input class="form-control col-sm-5" type="text" name="phone" value="${param.phone }" id="phone" maxlength="10" autocomplete="off"> --%>
                <input class="form-control col-sm-5" type="text" name="phone" id="phone" maxlength="10" autocomplete="off">
                <div class="col-sm-2" style="color:#FF0000; font-size:80%; display: inline">${errors.phone}</div>
            </div><br>
             <div class="row upload-header">
                <label for="file1" class="form-label col-sm-1 input-group-text">上傳照片</label>
<%--                 <input class="form-control col-sm-5" type="file" name="file1" value="${param.file1 }" id="file1" multiple> --%>
                <input class="form-control col-sm-5" type="file" name="file1" id="file1" multiple>
            	<div class="img-box" id="frames" ><!-- 存放預覽圖片 --></div>
            </div>
            <br>
            <div class="row">
	            <input class="form-control col-sm-6" type="submit" value="送出">
        	</div>
        </form>
        <hr>
<%-- 		<a href="<c:url value='/' />" >回首頁</a> --%>
    </div>
<!--     <script src="/project2/js/bootstrap.min.js"> -->
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

	<!-- Js Plugins -->
<!-- 	<script src="js/jquery-3.3.1.min.js"></script> -->
<!-- 	<script src="js/bootstrap.min.js"></script> -->
<!-- 	<script src="js/jquery.magnific-popup.min.js"></script> -->
<!-- 	<script src="js/jquery.nice-select.min.js"></script> -->
<!-- 	<script src="js/jquery-ui.min.js"></script> -->
<!-- 	<script src="js/jquery.slicknav.js"></script> -->
<!-- 	<script src="js/owl.carousel.min.js"></script> -->
<!-- 	<script src="js/main.js"></script> -->
<!-- 	<script src="https://kit.fontawesome.com/35ee305c92.js" crossorigin="anonymous"></script> -->
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<script src="/Team3/js/attractions.js"></script>
</body>

</html>