<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="breadcrumb-section" style="padding-bottom: 20px;">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb-text">
						<h2>房型介紹</h2>
						<div class="bt-option">
							<a href="<c:url value='/ShowAllServlet' />">顯示全部房型</a>
							<a href="<c:url value='/ShowAllServletM' />">管理房型</a>
							<a href="InsertRoom.jsp" id="insertBtn">新增房型</a><br>
							<hr>
							<c:choose>
							    <c:when test="${row == 0}">
							    	<script>alert('\n\n　　　　　　　　　　　　　修改失敗!!');</script> 
							    </c:when>
							    <c:when test="${row == 1}">
							    	<script>alert('\n\n　　　　　　　　　　　　　修改成功!!');</script>
							    </c:when>
							    <c:otherwise>
							    </c:otherwise>
							</c:choose>
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
<%-- 		<c:set var="bean" value="${bean}" scope="session"/> --%>
			<form action="<c:url value='/UpdateConfirmServlet'/>" method="post" enctype="multipart/form-data">
				<p><label class="t1" for="">客房編號:</label>&nbsp;<input type="text" name="roomId" readonly value="${bean.roomId}"></p>
				<p><label class="t1" for="">客房名稱:</label>&nbsp;<input type="text" name="name" value="${bean.name}"></p>
				<p><label class="t1" for="">客房狀態: </label>　
				<input type="radio" name="status" value="1" <c:if test="${bean.status==1}"><c:out value="checked"/></c:if>>空房 
														　　<input type="radio" name="status" value="0" <c:if test="${bean.status==0}"><c:out value="checked"/></c:if>>使用中</p>
				<p><label class="t1" for="">容納人數:</label>&nbsp;<input type="text" name="capacity" value="${bean.capacity}"></p>
				<p><label class="t1" for="">床數:</label>&nbsp;<input type="text" name="bed" value="${bean.bed}"></p>
				<p><label class="t1" for="">坪數:</label>&nbsp;<input type="text" name="size" value="${bean.size}"></p>
				<p><label class="t1" for="">價格:</label>&nbsp;<input type="text" name="price" value="${bean.price}"></p>
				<p><label class="t1" for="">設施: </label>　
				<input type="checkbox" name="cbEquipment1" value="電視" <c:if test="${e0==1}"><c:out value="checked" /></c:if> >&nbsp;電視
				<input type="checkbox" name="cbEquipment2" value="沙發" <c:if test="${e1==1}"><c:out value="checked" /></c:if> >&nbsp;沙發
				<input type="checkbox" name="cbEquipment3" value="陽台" <c:if test="${e2==1}"><c:out value="checked" /></c:if> >&nbsp;陽台
				<input type="checkbox" name="cbEquipment4" value="三溫暖" <c:if test="${e3==1}"><c:out value="checked" /></c:if> >&nbsp;三溫暖
				<input type="checkbox" name="cbEquipment5" value="按摩椅" <c:if test="${e4==1}"><c:out value="checked" /></c:if> >&nbsp;按摩椅
				<input type="checkbox" name="cbEquipment6" value="吸菸房" <c:if test="${e5==1}"><c:out value="checked" /></c:if> >&nbsp;吸菸房
				<input type="checkbox" name="cbEquipment7" value="攜帶寵物" <c:if test="${e6==1}"><c:out value="checked" /></c:if> >&nbsp;攜帶寵物
				<input type="checkbox" name="cbEquipment8" value="按摩浴缸" <c:if test="${e7==1}"><c:out value="checked" /></c:if> >&nbsp;按摩浴缸</p>
				<p><label class="t1" for="">描述:</label>&nbsp;<textarea name="description" style="width: 300px; height: 80px">${bean.description}</textarea></p>
				<p><label class="t1" for="">圖片:</label>&nbsp;<input type="file" name="img" value="${bean.img}" id="selectedImg" multiple/></p>
				<p style="margin:0 350px"><img src="<c:url value='/ShowImgServlet?roomId=${bean.roomId}' />" id="preImg" width="70%" alt=""></p><br>
				<p><label class="t1" for=""></label> <input type="submit" value="修改"></p>
			</form>
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
	$("#selectedImg").change(function(){
        readURL(this);
          });

       function readURL(input){
             if(input.files && input.files[0]){
               var reader = new FileReader();
               reader.onload = function (e) {
                  $("#preImg").attr('src', e.target.result);
               }
               reader.readAsDataURL(input.files[0]);
             }
           }
	</script>
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
</body>

</html>