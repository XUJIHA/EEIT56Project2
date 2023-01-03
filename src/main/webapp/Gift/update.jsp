<%@page import="DisplaySouvenir.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
               "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}</title>

<link href="<c:url value='/Gift/css/update.css' />" rel="stylesheet" type="text/css" />
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript">


function setFocus()
{
     document.getElementById("souvenir_name").focus();
}

function confirmDelete() {
	if (confirm("確定刪除(編號:${bean.souvenir_no})?") ) {
		document.forms[0].action="SouDelete.do?souvenir_id=${bean.souvenir_id}&souvenir_no=${bean.souvenir_no}" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	}
}

function updateSouvenir() {
	if (confirm("確定更新(編號:${bean.souvenir_no})?") ) {
	    document.forms[0].action="SouUpdate.do" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	}
}

//}//updateSouvenir
// function updateSouvenir() {
// 	 console.log("click")
// 	 let id=$(this).attr("${bean.souvenir_id}");
// 	 console.log(id)
//      Swal.fire({
		
//        title: 'Are you sure?',
//        text: "You won't be able to revert this!",
//        icon: 'warning',
//        showCancelButton: true,
//        confirmButtonColor: '#3085d6',
//        cancelButtonColor: '#d33',
//        confirmButtonText: 'Yes, delete it!'
    	
//      }),function (isConfirm) {
// 			if (isConfirm) {
// 				//如果点击确认
// 			} else {
// 				setTimeout(function(){
// 					//关闭加载框
// 					swal.close();
// 					swal({title:"系统错误!",
// 							 type:"error"});
// 				},100);
// 			}
// 		}

// document.getElementById("update").onclick = function updateSouvenir() {
// 	swal("这是一个信息提示框!")
// };
// function updateSouvenir(){
// 	 console.log("click")
// 	 let id=$(this).attr("id");
// 	 console.log(id)
//      Swal.fire({
//        title: 'Are you sure?',
//        text: "You won't be able to revert this!",
//        icon: 'warning',
//        showCancelButton: true,
//        confirmButtonColor: '#3085d6',
//        cancelButtonColor: '#d33',
//        confirmButtonText: 'Yes, delete it!'
//      })
//      }
</script>

</head>
<div id='main'>
<center>
<c:choose>
   <c:when test="${not empty param.SOUID }">
     <c:set var="souvenir_name" value='${bean.souvenir_name}' />
     <c:set var="souvenir_no" value='${bean.souvenir_no}' />
     <c:set var="souvenir_price" value='${bean.souvenir_price}' />
     <c:set var="souvenir_des" value='${bean.souvenir_des}' />
     <c:set var="souvenir_num" value='${bean.souvenir_num}' />
   </c:when>
   <c:otherwise>
   <!-- 
     <c:out value="第二次"/>
      -->
     <c:set var="souvenir_name" value='${bean.souvenir_name}' />
     <c:set var="souvenir_no" value='${bean.souvenir_no}' />
     <c:set var="souvenir_price" value='${bean.souvenir_price}' />
     <c:set var="souvenir_des" value='${bean.souvenir_des}' />
     <c:set var="souvenir_num" value='${bean.souvenir_num}' />
   </c:otherwise>
</c:choose>
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

<div id="afterBookInsert">
     <font color='red' size='-1'>${ErrMsg.Exception}</font><br/>
  </div>
<div id="backToBookMaintainList">
     <a href="DisplayPageProducts?pageNo=${param.pageNo}">回維護首頁</a>    
</div>     
 
<form id="form1" name="form1" 
      method="post" action="SouUpdate.do" 
      enctype="multipart/form-data"
>
 <div class="right">
      <div class="log">
          <div class="logo">更新伴手禮資料<br><br></div>
          <div class="block">
               <div class="lw">名字&emsp;
              <input type="text" class="inputbox" name="souvenir_name"id="souvenir_name"value="${souvenir_name}"  ><br>
              <font color='red' size='-1'>
              ${ErrMsg.errsouvenir_name}
           </font>
        </div> 
                <div class="lw">編號&emsp;
              <input type="text" class="inputbox" name="souvenir_no" id="souvenir_no" 
              value="${souvenir_no}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_no}
           </font>
        </div> 
			 <div class="lw">介紹&emsp;
			  <textarea class="te" name="souvenir_des"  type="text" id="souvenir_des" 
              >${souvenir_des}
                </textarea>
<!-- 					<input class='inputbox des' name="souvenir_des" type="text" id="souvenir_des"  -->
<%--              value="${souvenir_des}" size="50"  /> --%>
           <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_des}
           </font>
             
        </div> 
             <div class="block">
               <div class="lw">價錢&emsp;
              <input type="text" class="inputbox" name="souvenir_price"  id="souvenir_price" 
              value="${souvenir_price}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_price}
           </font>
        </div> 
                 <div class="block">
               <div class="lw">數量&emsp;
              <input class="inputbox"  name="souvenir_num"  type="text" id="souvenir_num" 
              value="${souvenir_num}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_num}
           </font>
        </div> 
          </div>
      </div>
      <tr height='36' class="title_font">
        <td width="45">圖片</td>
        <td colspan="1">
            <tr>
             <td><img style="height:80px; width:80px; border-radius:30px;"
                     src="<c:url value='/_00_init/getSouImage?id=${bean.souvenir_id}' />"  />
                            
             </td>
             <td colspan='2'>
                 <input style="background:#FFFFFF" class='InputClass'  type="file" 
                      name="uploadFile" size="40" />
                 <font color='red' size='-1'>
                    ${ErrMsg.errSouvenir_pic} 
                 </font>
             </td>
           </tr>
           </td>
    </tr>
<!--     <input type="submit" name="Submit" class="login" value="新增"> -->
</div>

<tr height='35'>
<td colspan='6' align='center'>
        <input name="souvenir_id" type="hidden" id="souvenir_id" value="${param.SOUId }>" />        
<!--         <input type="button"  class="login "name="update" value="修改" onclick='updateSouvenir()'/> -->
<!-- 		<input type="button" id="update"  class="login update"name="update" value="修改" onclick="updateSouvenir()"/> -->
<%-- 		<button class="update"  id="${bean.souvenir_id}" onclick='updateSouvenir()'>修改</button> --%>
       <input type="button"  class="login"name="update" value="修改" onclick='updateSouvenir()'/>
        &nbsp;&nbsp;&nbsp;
        <input type="button"  class="login"name="delete" value="刪除" onclick="confirmDelete()" /> 
  </td>
  </tr>
</table>
</div>
</div>
  <div id="deleteMsg">
         ${ErrMsg.errDBMessage}		 
        <input type="hidden" name="pageNo" value="${param.pageNo}" />
  </div>
</form>
<p>&nbsp;</p>
</center>
</div>
</body>
</html>