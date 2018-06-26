<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Outbound Management</title>
<link type="text/css" rel="stylesheet" href="../../maincss/main.css">
<link type="text/css" rel="stylesheet" href="../../mainjsp/main.css">
<script src="../../jquerylib/jquery-3.3.1.min.js"></script>
<script src="../../mainjsp/main.js"></script>
<script src="outbound.js"></script>
</head>
<body>
<%@include file="../../mainjsp/main.jsp" %>
		<div class="main_panel">
		<div class="user_manager">
			<div class="table_header">
				<div class="search" align="right">
					<input placeholder="search order info" maxlength="16" id="fuzzy">
					<button id="search">search</button>
				</div>
				<div class="table_info">
				<p><strong>Outbound Order Information</strong></p>
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
						<th>receive person</th>
						<th>telephone</th>
						<th>operate</th>
					</tr>
					<c:if test="${not empty sessionScope.orderOuts}">
					<c:forEach items="${sessionScope.orderOuts}" var="orderOut">
					<tr>
						<td><a href="../../OutOrderInfoServlet?orderNo=${orderOut.getOrderOutNo()}&warehouse=${orderOut.getOrderOutWarehouse()}&flag=${orderOut.getOrderOutFlag()}">${orderOut.getOrderOutNo()}</a></td>
						<td><input class="table_input" type="text" readonly value="${orderOut.getOrderOutDate()}"></td>
						<td><input class="table_input" type="text" readonly value="${orderOut.getOrderOutPerson()}"></td>
						<td><input class="table_input" type="text" readonly value="${orderOut.getOrderOutWarehouse()}"></td>
						<td><input class="table_input" type="text" readonly value="${orderOut.getOrderOutRperson()}"></td>
						<td><input class="table_input" type="text" readonly value="${orderOut.getOrderOutTel()}"></td>
						<td>
						<a href="javascript:void(0);" class="edit">edit</a>
						<a href="../../OutboundServlet?orderOutNo=${orderOut.getOrderOutNo()}">delete</a>
						</td>
					</tr>
					</c:forEach>
					</c:if>
				</table>
				<c:if test="${empty sessionScope.orderOuts}">
							<p id="NoInfo">No information found!</p>
					</c:if>
			</div>
			<div class="pagenumber" align="right">
				<table>
		        	<tbody>
		        		<tr>
		          			<td colspan="0" height="20" align="right">  
		          			 	第<span id="pageNo">${sessionScope.oOPageNo}</span>页 &nbsp;   				
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
			<form method="post" action="../../OutboundServlet">
				<ul>
					<li>
						<b style="font-size: 28px;">OrderOut info</b>
					</li>
				</ul>
				<ul>
					<li>number</li>
					<li><input id="newNo" name="newNo" value="auto generate" disabled></li>
				</ul>
				<ul>
					<li>warehouse</li>
					<li>
						<select name="newWarehouse" id="newWarehouse">  
        				</select> 
        			</li>
				</ul>
				<ul>
					<li>receive person</li>
					<li><input id="newReceive" name="newReceive" maxlength="16"></li>
				</ul>
				<ul>
					<li>telephone</li>
					<li><input id="newtelephone" name="newtelephone" maxlength="16"></li>
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