<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Sona Template">
<meta name="keywords" content="Sona, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>房型簡介</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Cabin:400,500,600,700&display=swap"
	rel="stylesheet">

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
<script src="https://kit.fontawesome.com/27e0c99202.js"
	crossorigin="anonymous"></script>
    <style>
        .t1 {
            width:350px;
            float:left;
            text-align:right;
        }
    </style>
    <style>
    	.ulabc{
    		list-style: none;
    		display:inline;
    	}
    </style>
    <style>
    	.li0 {
            border: 7px solid #FF0000	;
            width: 10px;
            height: 10px;
            border-radius: 50%;
            margin: 4px 0px;
        }
    	.li1 {
            border: 7px solid #00DD00	;
            width: 10px;
            height: 10px;
            border-radius: 50%;
            margin: 4px 0px;
        }
    </style>
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
		<div class="search-icon search-switch">
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
			<a href="<c:url value='/loginlogout/controller/searchAllServlet'/>" class="bk-btn">Customer
								Data</a>
		</div>
		<nav class="mainmenu mobile-menu">
			<ul>
				<li><a href="../LoginLogout/alreadyindex.jsp">Home</a></li>
				<li><a href="<c:url value='/ShowAllServlet' />">Rooms</a></li>
				<li><a href="../Gift/gift.jsp">Gifts</a></li>
				<li><a href="<c:url value='/showAttractionsServlet' />">Attractions</a>
					<ul class="dropdown">
						<li><a
							href="<c:url value='/attractions/AddAttractionsForm.jsp' />">add
								Attractions</a></li>
					</ul></li>

				<li><a href="<c:url value='../jsp01/RestaurantHomepage.jsp'/>">Restaurant</a></li>
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
	<header class="header-section header-normal">
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
							<a href="../LoginLogout/alreadyindex.jsp"> <img src="img/logo.png" alt="">
							</a>
						</div>
					</div>
					<div class="col-lg-10">
						<div class="nav-menu">
							<nav class="mainmenu">
								<ul>
									<li><a href="../LoginLogout/alreadyindex.jsp">Home</a></li>
									<li><a href="<c:url value='/ShowAllServlet' />">Rooms</a></li>
									<li><a href="../Gift/gift.jsp">Gifts</a></li>
									<li><a href="<c:url value='/showAttractionsServlet' />">Attractions</a>
										<ul class="dropdown">
											<li><a
												href="<c:url value='/attractions/AddAttractionsForm.jsp' />">add
													Attractions</a></li>
										</ul></li>

									<li><a
										href="<c:url value='../jsp01/RestaurantHomepage.jsp'/>">Restaurant</a></li>
								</ul>
							</nav>
							<a href="<c:url value='/orderRoom/SearchOrderServlet' />"><i
								class="fa-solid fa-cart-shopping" style="color: #dfa974"></i></a>
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

	<!-- Breadcrumb Section Begin -->
	<div class="breadcrumb-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb-text">
						<h2>房型介紹</h2>
						<div class="bt-option">
							<a href="<c:url value='/ShowAllServlet' />" style="color: darkgray"><b>顯示全部房型</b></a>
							<a href="<c:url value='/ShowAllServletM' />" style="color: darkgray"><b>管理房型</b></a>
							<hr>
							<form action="<c:url value='/SearchServlet' />" method="post">
								<select name="selection">
									<option value="none">請選擇入住人數</option>
									<option value="1">單人房</option>
									<option value="2">雙人房</option>
									<option value="4">四人房</option>
									<option value="6">六人房</option>
									<option value="8">八人房</option>
									<option value="10">十人房</option>
								</select> 
					<input type="checkbox" id="cbStatus" name="cbStatus" value="1">&nbsp;搜尋空房　　
								價格範圍 :&nbsp;<input type="number" name="minPrice">&nbsp;～&nbsp;<input
									type="number" name="maxPrice">
									<input type="submit" value="查詢">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb Section End -->

	<!-- Rooms Section Begin -->
	<section class="rooms-section spad">
		<div class="container" id="target">
			<div class="row">
				<c:forEach var="bean" items="${beans}">
<!-- 				style=" height:612px; weight:360px" -->
					<div class="col-lg-4 col-md-6" >
						<div class="room-item">
							<img src="<c:url value='/ShowImgServlet?roomId=${bean.roomId}' />" height="220px" alt="">
							<div class="ri-text">
								<span style="font-size: 26px"><b>${bean.name}</b></span>
								<c:choose>
							    <c:when test="${bean.status == 0}">
							       <span style="color:#7B7B7B;float:right;font-size:17px"><b><i>&nbsp;使用中</i></b></span><ul class="ulabc"  style="float:right;"><li class="li0" ></li></ul>
							    </c:when>
							    <c:when test="${bean.status == 1}">
							       <span style="color:#7B7B7B;float:right;font-size:17px"><b><i>&nbsp;空房</i></b></span><ul class="ulabc" style="float:right; "><li class="li1" ></li></ul>
							    </c:when>
							    <c:otherwise>
							    </c:otherwise>
							</c:choose>
								<h3>
									$${bean.price}<span>/每晚</span>
								</h3>
								<table>
									<tbody>
										<tr>
											<td class="r-o">空間:</td>
											<td>${bean.size} 坪</td>
										</tr>
										<tr>
											<td class="r-o">人數:</td>
											<td>最多 ${bean.capacity} 人</td>
										</tr>
										<tr>
											<td class="r-o">床數:</td>
											<td>${bean.bed}張床</td>
										</tr>
										<tr>
											<td class="r-o">設施:</td>
											<td>${bean.equipment}</td>
										</tr>
									</tbody>
								</table>
								<form class="detailsform" action="<c:url value='/DetailsServlet'/>" method="post">
									<input name="roomId" value="${bean.roomId}" type="hidden">
									<a href="#" class="primary-btn">More Details</a>
								</form>
							</div>
						</div>
					</div>
				</c:forEach>
<!-- 				<div class="col-lg-12"> -->
<!-- 					<div class="room-pagination"> -->
<!-- 						<a href="#">1</a> <a href="#">2</a> <a href="#">Next <i -->
<!-- 							class="fa fa-long-arrow-right"></i></a> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
		</div>
	</section>
	<!-- Rooms Section End -->

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

	<script>
// 		$(function(){
// 			$('#insertBtn').on('click', function(){
// 				let content = '<div style="text-align:center">'
// 				+ '<form action="http://localhost:8080/jspExercise/TestDaoAction" method="post" enctype="multipart/form-data">'
// 				+ '<p><label class="t1" for="">客房編號: </label><input type="text" name="roomId" size="30px" style="margin:100px, 100px"></p>'
// 				+ '<p><label class="t1" for="">客房名稱: </label><input type="text" name="name" size="30px"></p>'
// 				+ '<p><label class="t1" for="">客房狀態: </label><input type="text" name="status" size="30px"></p>'
// 				+ '<p><label class="t1" for="">容納人數: </label><input type="text" name="capacity" size="30px"></p>'
// 				+ '<p><label class="t1" for="">床數: </label><input type="text" name="bed" size="30px"></p>'
// 				+ '<p><label class="t1" for="">坪數: </label><input type="text" name="size" size="30px"></p>'
// 				+ '<p><label class="t1" for="">價格: </label><input type="text" name="price" size="30px"></p>'
// 				+ '<p><label class="t1" for="">圖片: </label><input type="file" name="img" size="30px" multiple/></p>'
// 				+ '<p><label class="t1" for="">設備: </label><input type="text" name="equipment" size="30px"></p>'
// 				+ '<p><label class="t1" for="">描述: </label><input type="text" name="description" size="30px"></p>'
// 				+ '<p><label class="t1" for=""></label><input type="submit" value="提交" id="submit"></p>'
// 				+ '</form></div>'	
// 				$('#target').html(content);
// 			})
// 		})
	</script>
	<script>
		function callMe(){
		    $.ajax({
		      type: "POST",
		      url: "/DetailsServlet",
		      data: { roomId: "${bean.roomId}"}
		    }).done(function( msg ) {
		      alert( "Data Saved: " + msg );
		    });
		}
	</script>
	<script>
		$('.primary-btn').on('click',function(){
			$(this).parent('.detailsform').submit();
		})
	
	</script>
</body>

</html>