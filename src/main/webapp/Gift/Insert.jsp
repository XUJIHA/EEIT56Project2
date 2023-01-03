<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='/css/Left.css' />" rel="stylesheet"
  type="text/css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${AppName}</title>
  
<link href="<c:url value='/css/Insert.css' />" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function setFocus(fld) {
     document.getElementById(fld).focus();
}

</script>

</head>
<body onload="setFocus('title')" background="<c:url value='/images/bookMaintain.jpg' />">
<!-- 引入共同的頁首 -->  
<%-- <jsp:include page="/fragment/topMVC.jsp" /> --%>
<div id='main' align='center'>

  <div id="afterBookInsert">
     <font color='red' size='-1'>${successMsg.success}${ErrMsg.Exception}</font><br/>
     <c:remove var="successMsg" scope='session'/>
  </div>
<!--   <div id="backToBookMaintainList"> -->
<%--       <a href="DisplayPageProducts?pageNo=${param.pageNo}">回維護首頁</a>    --%>
<!--   </div> -->

<form  id="form1" name="form1" method="post" 
       action="SouInsert.do"  enctype="multipart/form-data" >
<div class="card">
  <div class="left">
	<div id="container">
<!--         <button class="learn-more"> -->
<!--             <span class="circle" aria-hidden="true"> -->
<!--                 <span class="icon arrow"></span> -->
<!--             </span> -->
            
<!--             <span class="button-text"> -->
<%--             	<a href="<c:url value='/_03_listBooks/DisplayPageProducts' />"> --%>
<!--                 購物  -->
<!-- 				</a> -->
<!--             </span> -->
<!--         </button><br><br> -->
<!--         <button class="learn-more"> -->
<!--             <span class="circle" aria-hidden="true"> -->
<!--                 <span class="icon arrow"></span> -->
<!--             </span> -->
<!--              <span class="button-text" > -->
<%--             	 <a href="<c:url value='/_04_ShoppingCart/ShowCartContent.jsp' />"> --%>
<!--                     結帳  -->
<!-- 				  </a> -->
<!--             </span> -->
<!--         </button><br><br> -->
<!--         <button class="learn-more"> -->
<!--             <span class="circle" aria-hidden="true"> -->
<!--                 <span class="icon arrow"></span> -->
<!--             </span> -->
<!--            		<span class="button-text" > -->
<%--             	 <a href="<c:url value='/_05_orderProcess/orderList.do' />"> --%>
<!--                     訂單 </a> -->
<!--             </span> -->
<!--         </button><br><br> -->
        <button class="learn-more">
            <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
            </span>
            <span class="button-text">
            	<a href="<c:url value='/giftMaintain/DisplayPageProducts' />">
                    維護 </a>
            </span>
        </button>
    </div>
  </div>
  <div class="right">
      <div class="log">
          <div class="logo">新增商品<br><br></div>
          <div class="block">
               <div class="lw">名字&emsp;
              <input type="text" class="inputbox" name="souvenir_name"id="souvenir_name"value="${requestScope.souvenir_name}"  ><br>
              <font color='red' size='-1'>
              ${ErrMsg.errsouvenir_name}
           </font>
        </div> 
                <div class="lw">編號&emsp;
              <input type="text" class="inputbox" name="souvenir_no" id="souvenir_no" 
              value="${requestScope.souvenir_no}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_no}
              
           </font>
        </div> 
<!--               <div class="lw">介紹&emsp; -->
<!--               <input name="souvenir_des" class='inputbox' type="text" id="souvenir_des"  -->
<%--               value="${requestScope.souvenir_des}" size="100" /> --%>
<!--            <font color='red' size='-1'> -->
<%--               ${ErrMsg.errSouvenir_des} --%>
<!--            </font> -->
             
<!--         </div>  -->
			 <div class="lw">介紹&emsp;
			  <textarea class="te" name="souvenir_des"  type="text" id="souvenir_des" 
              value="${requestScope.souvenir_des}">
                </textarea>
           <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_des}
           </font>
             
        </div> 
             <div class="block">
               <div class="lw">價錢&emsp;
              <input type="text" class="inputbox" name="souvenir_price"  id="souvenir_price" 
              value="${requestScope.souvenir_price}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_price}
           </font>
        </div> 
                 <div class="block">
               <div class="lw">數量&emsp;
              <input class="inputbox"  name="souvenir_num"  type="text" id="souvenir_num" 
              value="${requestScope.souvenir_num}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_num}
           </font>
        </div> 
          </div>
      </div>
      <tr height='36' class="title_font">
        <td width="45">圖片</td>
        <td colspan="1">
            <input style="background:#FFFFFF" class='InputClass'  type="file" 
            name="uploadFile" size="40" /><br>
            <font color='red' size='-1'>${ErrMsg.errSouvenir_pic}</font></td>
    </tr>
    <input type="submit" name="Submit" class="insert login" value="新增">
</div>
</form>
</div>
<p>&nbsp;</p>
<c:remove var="ErrMsg" scope='session'/>
</body>
</html>