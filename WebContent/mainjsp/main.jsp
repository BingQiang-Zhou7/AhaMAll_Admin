<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="GB18030"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../maincss/main.css">
<link type="text/css" rel="stylesheet" href="index.css">
<script src="../jquerylib/jquery-3.3.1.min.js"></script>
<script src="index.js"></script>
</head>
<body>
	<div class="top_menu">
		<div class="title">
			<p>AhaMall</p>
		</div>
		<div class="show_menu">
			<p id="menu_operater">hide</p>
		</div>
		<div class="info">
		<c:if test="${not empty sessionScope.admin}">
			<p>${sessionScope.admin}</p>
			<p><a href="../../LogoutServlet">logout</a></p>
		</c:if>
		</div>
	</div>
	<div class="left_menu">
		<p>System Management</p>
		<ul><li><a href="../../UserManagement" id="usermanagement">User</a></li></ul>
		<ul><li><a href="../../ProductManagement" id="productmanagement">Product</a></li></ul>
		<ul><li><a href="../../WarehouseManagement"  id="warehousemanagement">Warehouse</a></li></ul>
		<p>Inventory Management</p>
		<ul><li><a href="../../OutboundServlet" id="outbound">Outbound</a></li></ul>
		<ul><li><a href="../../InboundServlet" id="inbound">Inbound</a></li></ul>
		<p>Extension Operater</p>
		<ul><li><a href="../changepassword/changepassword.jsp" id="changepassword">Change Password</a></li></ul>
	</div>
	<div id="tempVar" class="hide">hello</div>
</body>
</html>