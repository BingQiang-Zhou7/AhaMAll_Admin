<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		<c:if test="${flag == '0'}">
			<div class="table_header">
				<div class="search" align="right">
					<input placeholder="search info" maxlength="16" id="fuzzy">
					<button id="search">search</button>
				</div>
				<div class="table_info">
				<p><strong>Warehouse product</strong></p>
				</div>
				<div class="table_opearter">
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
						<th>operation</th>
					</tr>
					<c:if test="${not empty sessionScope.warehouseProducts}">
					<c:forEach items="${sessionScope.warehouseProducts}" var="warehouseProduct">
					<tr>
						<td><input class="table_input" type="text" readonly value="${warehouseProduct.getOrderInDetailsCode()}"></td>
						<td><input class="table_input" type="text" readonly value="${warehouseProduct.getOrderInDetailsColor()}"></td>
						<td><input class="table_input" type="text" readonly value="${warehouseProduct.getOrderInDetailsSize()}"></td>
						<td><input class="table_input" type="text" readonly value="${warehouseProduct.getOrderInDetailsCount()}"></td>
						<td>
						<a href="javascript:void(0);" class="add">add</a>
						<a class="hide" href="../../OutOrderInfoServlet?code=${warehouseProduct.getOrderInDetailsCode()}&color=${orderProduct.getOrderInDetailsColor()}&size=${orderProduct.getOrderInDetailsSize()}">delete</a>
						</td>
					</tr>
					</c:forEach>
					</c:if>
				</table>
				<c:if test="${empty sessionScope.warehouseProducts}">
							<p id="NoInfo">No information found!</p>
					</c:if>
			</div>
			<div class="pagenumber" align="right">
				<table>
		        	<tbody>
		        		<tr>
		          			<td colspan="0" height="20" align="right">  
		          			 	第<span id="pageNo">${sessionScope.opPageNo}</span>页 &nbsp;   				
								<a href="javascript:void(0);" id="Index1">首页</a>&nbsp;
			      				<a href="javascript:void(0);" id="pageUp1">上一页</a>&nbsp;
			      				<a href="javascript:void(0);" id="pageDown1">下一页</a>&nbsp; 
			      				<a href="javascript:void(0);">尾页</a>&nbsp; 
										&nbsp;
							</td>
		          		</tr>
		        	</tbody>
		        </table>
			</div>
			
			<div class="line"></div>
		</c:if>
		
		
			<div class="table_header">
				<div class="search hide" align="right">
					<input placeholder="search order info" maxlength="16" id="fuzzy">
					<button id="search">search</button>
				</div>
				<div class="table_info">
				<p><strong>Order Detail Information : ${orderNo}</strong></p>
				</div>
				<div class="table_opearter">
				<c:if test="${flag == '0'}">
					<p class="left" id="save">save</p>
				</c:if>
				<p class="left hide" id="refresh">refresh</p>
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
						<th>operation</th>
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
							<p id="NoInfoProducts">No information found!</p>
					</c:if>
			</div>
			<div class="pagenumber" align="right">
				<table>
		        	<tbody>
		        		<tr>
		          			<td colspan="0" height="20" align="right">  
		          			 	第<span id="pageNo2">${sessionScope.oppPageNo}</span>页 &nbsp;   				
								<a href="javascript:void(0);" id="Index2">首页</a>&nbsp;
			      				<a href="javascript:void(0);" id="pageUp2">上一页</a>&nbsp;
			      				<a href="javascript:void(0);" id="pageDown2">下一页</a>&nbsp; 
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
					<li>count</li>
					<li><input type="number" id="newCount" name="newCount" step="1" min="1"></li>
				</ul>
				<ul>
					<li id = "isNull" style="color: red;" class="hide">Information can't be empty!</li>
					<li>
						<button id="OK">OK</button>
					</li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>