<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Order Management</title>
<link type="text/css" rel="stylesheet" href="../../maincss/main.css">
<link type="text/css" rel="stylesheet" href="../../mainjsp/main.css">
<script src="../../jquerylib/jquery-3.3.1.min.js"></script>
<script src="../../mainjsp/main.js"></script>
<script src="outorderinfo.js"></script>
</head>
<body>
<div class="top_menu">
		<div class="title">
			<p>AhaMall</p>
		</div>
		<div class="info">
		<c:if test="${not empty sessionScope.admin}">
			<p>${sessionScope.admin}</p>
			<p><a href="../../LogoutServlet">logout</a></p>
		</c:if>
		<p><a href="../../OutboundServlet">back</a></p>
		</div>
	</div>
		<div class="main_panel">
		<div class="user_manager">
			<div class="table_header">
				<div class="search" align="right">
					<input placeholder="search order info" maxlength="16" id="fuzzy">
					<button id="search">search</button>
				</div>
				<div class="table_info">
				<p><strong>Order Detail Information : ${orderNo}</strong></p>
				</div>
				<div class="table_opearter">
				<c:if test="${flag == '0'}">
					<p class="left" id="add">add</p>
					<p class="left" id="save">save</p>
				</c:if>
				<p class="left" id="refresh">refresh</p>
				</div>
			</div>
			<div class="table_style">
				<table>
					<tr>
						<th>code</th>
						<th>color</th>
						<th>size</th>
						<th>count</th>
						<c:if test="${flag == '0'}">
						<th>operate</th>
						</c:if>
					</tr>
					<c:if test="${not empty sessionScope.orderProducts}">
					<c:forEach items="${sessionScope.orderProducts}" var="orderProduct">
					<tr>
						<td><input class="table_input" type="text" readonly value="${orderProduct.getOrderInDetailsCode()}"></td>
						<td><input class="table_input" type="text" readonly value="${orderProduct.getOrderInDetailsColor()}"></td>
						<td><input class="table_input" type="text" readonly value="${orderProduct.getOrderInDetailsSize()}"></td>
						<td><input class="table_input" type="text" readonly value="${orderProduct.getOrderInDetailsCount()}"></td>
						<c:if test="${flag == '0'}">
						<td>
						<a href="javascript:void(0);" class="edit">edit</a>
						<a href="../../OutOrderInfoServlet?code=${orderProduct.getOrderInDetailsCode()}&color=${orderProduct.getOrderInDetailsColor()}&size=${orderProduct.getOrderInDetailsSize()}">delete</a>
						</td>
						</c:if>
					</tr>
					</c:forEach>
					</c:if>
				</table>
				<c:if test="${empty sessionScope.orderProducts}">
							<p id="NoInfo">No information found!</p>
					</c:if>
			</div>
			<div class="pagenumber" align="right">
				<table>
		        	<tbody>
		        		<tr>
		          			<td colspan="0" height="20" align="right">  
		          			 	第<span id="pageNo">${sessionScope.opPageNo}</span>页 &nbsp;   				
								<a href="javascript:void(0);" id="Index">首页</a>&nbsp;
			      				<a href="javascript:void(0);" id="pageUp">上一页</a>&nbsp;
			      				<a href="javascript:void(0);" id="pageDown">下一页</a>&nbsp; 
			      				<a href="javascript:void(0);">尾页</a>&nbsp; 
										&nbsp;
							</td>
		          		</tr>
		        	</tbody>
		        </table>
			</div>
		</div>
	</div>
	<div class="cover hide">
		<div class="input_message_box">
			<div class="close"><img id="close" src="../../images/close.png"></div>
			<form method="post" action="../../OutOrderInfoServlet">
				<ul>
					<li>
						<b style="font-size: 28px;">Order detail info</b>
					</li>
				</ul>
				<ul>
					<li>code</li>
					<li><input id="newCode" name="newCode" value="auto generate" disabled></li>
				</ul>
				<ul>
					<li>color</li>
					<li>
						<select name="newColor" id="newColor">  
			                <option value="Red">Red</option>  
			                <option value="Orange">Orange</option>  
			                <option value="Yellow">Yellow</option>  
			                <option value="Green">Green</option>
			                <option value="Cyan">Cyan</option>
			                <option value="Blue">Blue</option>  
			                <option value="Purple">Purple</option>  
        				</select>  
        			</li>
				</ul>
				<ul>
					<li>size</li>
					<li>
						<select name="newSize" id="newSize">  
			                <option value="150">150</option>  
			                <option value="155">155</option>  
			                <option value="160">160</option>  
			                <option value="165">165</option>
			                <option value="170">170</option>  
			                <option value="175">175</option> 
			                <option value="180">180</option>  
			                <option value="185">185</option> 
			                <option value="190">190</option>  
        				</select>
        			</li>
				</ul>
				<ul>
					<li>name</li>
					<li><input id="newName" name="newName" maxlength="16"></li>
				</ul>
				<ul>
					<li>price</li>
					<li><input id="newPrice" name="newPrice" maxlength="16"></li>
				</ul>
				<ul>
					<li>count</li>
					<li><input id="newCount" name="newCount" maxlength="16"></li>
				</ul>
				<ul>
					<li id = "isNull" style="color: red;" class="hide">Information can't be empty!</li>
					<li>
						<button type="submit" id="OK">OK</button>
					</li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>