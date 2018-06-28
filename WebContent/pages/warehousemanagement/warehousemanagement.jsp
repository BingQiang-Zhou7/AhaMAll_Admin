<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warehouse Management</title>
<link type="text/css" rel="stylesheet" href="../../maincss/main.css">
<link type="text/css" rel="stylesheet" href="../../mainjsp/main.css">
<script src="../../jquerylib/jquery-3.3.1.min.js"></script>
<script src="../../mainjsp/main.js"></script>
<script src="warehousemanagement.js"></script>
</head>
<body>
<%@include file="../../mainjsp/main.jsp" %>
		<div class="main_panel">
		<div class="user_manager">
			<div class="table_header">
				<div class="search" align="right">
					<input placeholder="search user info" maxlength="16" id="fuzzy">
					<button id="search">search</button>
				</div>
				<div class="table_info">
				<p><strong>Warehouse Information</strong></p>
				</div>
				<div class="table_opearter">
				<p class="left" id="add">add warehouse</p>
				<p id="refresh">refresh</p>
				</div>
			</div>
			<div class="table_style">
				<table>
					<tr>
						<th>number</th>
						<th>name</th>
						<th>administrator</th>
						<th>telephone</th>
						<th>storage</th>
						<th>operate</th>
					</tr>
					<c:if test="${not empty sessionScope.warehouses}">
					<c:forEach items="${sessionScope.warehouses}" var="warehouse">
					<tr>
						<td><input class="table_input" type="text" readonly value="${warehouse.getWarehouseNo()}" ></td>
						<td><input class="table_input" type="text" readonly value="${warehouse.getWarehouseName()}" ></td>
						<td><input class="table_input" type="text" readonly value="${warehouse.getWarehouseContact()}" ></td>
						<td><input class="table_input" type="text" readonly value="${warehouse.getWarehouseContactTele()}" ></td>
						<td><input class="table_input" type="text" readonly value="${warehouse.getWarehouseStorageCapacity()}" ></td>
						<td>
						<a href="javascript:void(0);" class="edit">edit</a>
						<a href="../../WarehouseManagement?warehouseNo=${warehouse.getWarehouseNo()}">delete</a>
						</td>
					</tr>
					</c:forEach>
					</c:if>
				</table>
				<c:if test="${empty sessionScope.warehouses}">
							<p id="NoInfo">No information found!</p>
					</c:if>
			</div>
			<div class="pagenumber" align="right">
				<table>
		        	<tbody>
		        		<tr>
		          			<td colspan="0" height="20" align="right">  
		          			 	第<span id="pageNo">${sessionScope.wPageNo}</span>页 &nbsp;   				
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
			<form method="get" action="../../WarehouseManagement">
				<ul>
					<li>
						<b style="font-size: 28px;">warehouse info</b>
					</li>
				</ul>
				<ul>
					<li>warehouse number</li>
					<li><input maxlength="16" name="newNumber" id="newNumber"></li>
					<li style="color: red;" class="hide" id="AccountTip">number is exist!</li>
				</ul>
				<ul>
					<li>warehouse name</li>
					<li><input maxlength="16" name="newName" id="newName"></li>
				</ul>
				<ul>
					<li>warehouse administrator</li>
					<li><input maxlength="16" name="newAdministrator" id="newAdministrator"></li>
				</ul>
				<ul>
					<li>warehouse telephone</li>
					<li><input maxlength="16" name="newTelephone" id="newTelephone"></li>
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