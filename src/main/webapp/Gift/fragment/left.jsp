<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value='/css/left.css' />" rel="stylesheet"
  type="text/css" />
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<!--     <link rel="stylesheet" href="left.css" type="text/css"> -->
</head>
<!-- <table class='menuOuter'> -->
<!--   <tr height="48px"> -->
<body >
    <div id="container">
        <button class="learn-more">
            <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
            </span>
            
            <span class="button-text" >
            	<a href="<c:url value='/_03_listBooks/DisplayPageProducts' />">
                購物 
				</a>
            </span>
        </button><br><br>
        <button class="learn-more">
            <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
            </span>
             <span class="button-text" >
            	 <a href="<c:url value='/_04_ShoppingCart/ShowCartContent.jsp' />">
                    結帳 
				  </a>
            </span>
        </button><br><br>
        <button class="learn-more">
            <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
            </span>
           		<span class="button-text" >
            	 <a href="<c:url value='/_05_orderProcess/orderList.do' />">
                    訂單 </a>
            </span>
        </button><br><br>
        <button class="learn-more">
            <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
            </span>
            <span class="button-text">
            	<a href="<c:url value='/_20_productMaintain/DisplayPageProducts' />">
                    維護 </a>
            </span>
        </button>
    </div>
</body>

</html>