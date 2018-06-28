<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inbound Management</title>
<link type="text/css" rel="stylesheet" href="../../maincss/main.css">
<link type="text/css" rel="stylesheet" href="../../mainjsp/main.css">
<script src="../../jquerylib/jquery-3.3.1.min.js"></script>
<script src="../../mainjsp/main.js"></script>
<script src="inbound.js"></script>
</head>
<body>
<%@include file="../../mainjsp/main.jsp" %>
		<div class="main_panel">
		<div class="user_manager">
			<div class="table_header">
				<div class="search" align="right">
					<input placeholder="search info" maxlength="16" id="fuzzy">
					<button id="search">search</button>
				</div>
				<div class="table_info">
				<p><strong>Inbound Order Information</strong></p>
				</div>
				<div class="table_opearter">
				<p class="left" id="add">add Order</p>
				<p id="refresh">refresh</p>
				</div>
			</div>
			<div class="table_style">
				<table>
					<tr>
						<th>number</th>
						<th>date</th>
						<th>admin</th>
						<th>warehouse</th>
						<th>from</th>
						<th>operation</th>
					</tr>
					<c:if test="${not empty sessionScope.orderIns}">
					<c:forEach items="${sessionScope.orderIns}" var="orderIn">
					<tr>
						<td><a href="../../InOrderInfoServlet?orderNo=${orderIn.getOrderInNo()}&warehouse=${orderIn.getOrderInWarehouse()}&flag=${orderIn.getOrderInFlag()}">${orderIn.getOrderInNo()}</a></td>
						<td><input class="table_input" type="text" readonly value="${orderIn.getOrderInDate()}"></td>
						<td><input class="table_input" type="text" readonly value="${orderIn.getOrderinPerson()}"></td>
						<td><input class="table_input" type="text" readonly value="${orderIn.getOrderInWarehouse()}"></td>
						<td><textarea rows="1" cols="21" maxlength="128" readonly style="height: 20px;">${orderIn.getOrderInBefrom()}</textarea></td>
						<td>
						<a href="javascript:void(0);" class="edit">edit</a>
						<a href="../../InboundServlet?OrderInNo=${orderIn.getOrderInNo()}">delete</a>
						</td>
					</tr>
					</c:forEach>
					</c:if>
				</table>
				<c:if test="${empty sessionScope.orderIns}">
							<p id="NoInfo">No information found!</p>
					</c:if>
			</div>
			<div class="pagenumber" align="right">
				<table>
		        	<tbody>
		        		<tr>
		          			<td colspan="0" height="20" align="right">  
		          			 	第<span id="pageNo">${sessionScope.oIPageNo}</span>页 &nbsp;   				
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
			<form method="post" action="../../InboundServlet">
				<ul>
					<li>
						<b style="font-size: 28px;">OrderIn info</b>
					</li>
				</ul>
				<ul>
					<li>orderIn number</li>
					<li><input id="newNo" name="newNo" value="auto generate" disabled></li>
				</ul>
				<ul>
					<li>orderIn warehouse</li>
					<li>
						<select name="newWarehouse" id="newWarehouse">  
        				</select> 
        			</li>
				</ul>
				<ul>
					<li>orderIn from</li>
					<li><textarea rows="5" cols="21" maxlength="128" name="newFrom" id="newFrom"></textarea></li>
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