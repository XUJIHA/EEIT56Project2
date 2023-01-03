<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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

<!-- Css Styles -->
<!-- 絕對路徑 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<!-- 絕對路徑 -->
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


	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="https://kit.fontawesome.com/27e0c99202.js" crossorigin="anonymous"></script>

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
			<a href="<c:url value='/loginlogout/controller/searchAllServlet' />" class="bk-btn">Costmer Data</a>
		</div>
		<nav class="mainmenu mobile-menu">
			<ul>
				<li><a href="./LoginLogout/alreadyindex.jsp">Home</a></li>
				<li><a href="<c:url value='/ShowAllServlet' />">Rooms</a></li>
				<li><a href="./Gift/gift.jsp">Gifts</a></li>
				<li><a href="<c:url value='/showAttractionsServlet' />">Attractions</a>
					<ul class="dropdown">
						<li><a
							href="<c:url value='/attractions/AddAttractionsForm.jsp' />">add
								Attractions</a></li>
					</ul></li>

				<li><a href="<c:url value='./jsp01/RestaurantHomepage.jsp'/>">Restaurant</a></li>
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
							<a href="<c:url value='/loginlogout/controller/searchAllServlet' />" class="bk-btn">Costmer Data</a>
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
							<a href="../LoginLogout/alreadyindex.jsp"> <img src="../img/logo.png" alt="">
							</a>
						</div>
					</div>
					<div class="col-lg-10">
						<div class="nav-menu">
							<nav class="mainmenu">
								<ul>
									<li><a href="./LoginLogout/alreadyindex.jsp">Home</a></li>
									<li><a href="<c:url value='/ShowAllServlet' />">Rooms</a></li>
									<li><a href="./Gift/gift.jsp">Gifts</a></li>
									<li><a href="<c:url value='/showAttractionsServlet' />">Attractions</a>
										<ul class="dropdown">
											<li><a
												href="<c:url value='/attractions/AddAttractionsForm.jsp' />">add
													Attractions</a></li>
										</ul></li>

									<li><a
										href="<c:url value='./jsp01/RestaurantHomepage.jsp'/>">Restaurant</a></li>
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
	<%-- <% User u=(User)session.getAttribute("user"); %> --%>
	<p align="center">修改會員資料</p>

	<div>


		<form method="post" action="<c:url value='/loginlogout/controller/updateServlet' />">
			>

			<c:forEach var="hotelBean" items="${classList}">
				<input type="hidden" name="USER_ID" value="${hotelBean.USER_ID}">
				<p align="center">
					姓名：<label for="textfield"></label><input type="text"
						name="USER_NAME" id="textfield" value="${hotelBean.USER_NAME}" required/>
				</p>
				<p align="center">
					密码： <input type="password" name="USER_PASSWORD" id="textfield1"
						value="${hotelBean.USER_PASSWORD}" required/>
				</p>
				<p align="center">
					身分證字號： <input type="text" name="USER_IDENTITY" id="textfield2"
						value="${hotelBean.USER_IDENTITY}" required/>
				</p>
				<p align="center">
					E-mail： <input type="email" name="USER_EMAIL" id="textfield3"
						value="${hotelBean.USER_EMAIL}" required/>
				</p>
				<p align="center">
					電話號碼： <input type="tel" name="USER_PHONE" id="textfield4"
						value="${hotelBean.USER_PHONE}" required/>
				</p>
				<p align="center">
					生日： <input type="date" name="USER_BIRTHDAY" id="textfield5"
						value="${hotelBean.USER_BIRTHDAY}" required/>
				</p>
				<p align="center">
					註冊日期： <input type="date" name="USER_REGISTRATION" id="textfield6"
						value="${hotelBean.USER_REGISTRATION}" required/>
				</p>

				<div align="center">
<!-- 					<input type="hidden" value="儲存" /> -->
					<button class="update" value="${hotelBean.USER_ID}" name="userno" type="button">儲存</button>
				</div>

			</c:forEach>
		</form>
	</div>


	<br>

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

	<script>	
	$(function(){
        $('.update').click(function(){
            let id=$(this).attr("value");
            let USER_NAME=$("#textfield").val();
            let USER_PASSWORD=$("#textfield1").val();
            let USER_IDENTITY=$("#textfield2").val();
            let USER_EMAIL=$("#textfield3").val();
            let USER_PHONE=$("#textfield4").val();
            let USER_BIRTHDAY=$("#textfield5").val();
            let USER_REGISTRATION=$("#textfield6").val();
            console.log(textfield)
            Swal.fire({
              title: 'Are you sure?',
              text: "You won't be able to revert this!",
              icon: 'warning',
              showCancelButton: true,
              confirmButtonColor: '#3085d6',
              cancelButtonColor: '#d33',
              confirmButtonText: 'Yes, update it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                      url:'/Team3_Hibernate/loginlogout/controller/updateServlet',
                      method:"post",
                      dataType:"text",
                      data: {"USER_ID":id,"USER_NAME":USER_NAME,"USER_PASSWORD":USER_PASSWORD,"USER_IDENTITY":USER_IDENTITY,"USER_EMAIL":USER_EMAIL,"USER_PHONE":USER_PHONE,"USER_BIRTHDAY":USER_BIRTHDAY,"USER_REGISTRATION":USER_REGISTRATION},
                    })
                    	.done(function () {
                    		$(location).attr('href', '/Team3_Hibernate/loginlogout/controller/searchAllServlet');
                        	console.log("update")
             			})//done
             			.fail(function(error) {
             			    console.log(error)
             			})//fail end
                }//if
              })//then

          })//click end
	});
	//function end
</script>

</body>

</html>
