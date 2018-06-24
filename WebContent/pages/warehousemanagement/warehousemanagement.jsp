<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>User Management</title>
<link type="text/css" rel="stylesheet" href="../../maincss/main.css">
<link type="text/css" rel="stylesheet" href="../../mainjsp/main.css">
<script src="../../jquerylib/jquery-3.3.1.min.js"></script>
<script src="../../mainjsp/main.js"></script>
<script src="productmanagement.js"></script>
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
				<p><strong>User Information</strong></p>
				</div>
				<div class="table_opearter">
				<p class="left" id="adduser">add user</p>
				<p id="refresh">refresh</p>
				</div>
			</div>
			<div class="table_style">
				<table>
					<tr>
						<th>account</th>
						<th>name</th>
						<th>password</th>
						<th>description</th>
						<th>operate</th>
					</tr>
					<c:if test="${not empty sessionScope.users}">
					<c:forEach items="${sessionScope.users}" var="user">
					<tr>
						<td><input class="table_input" type="text" readonly value="${user.getUserAccount()}" maxlength="16"></td>
						<td><input class="table_input" type="text" readonly value="${user.getUserName()}" maxlength="16"></td>
						<td><input class="table_input" type="text" readonly value="${user.getUserPassword()}" maxlength="16"></td>
						<td><textarea rows="1" cols="21" maxlength="128" readonly style="height: 20px;">${user.getUserDescription()}</textarea></td>
						<td>
						<a href="javascript:void(0);" class="edit">edit user</a>
						<a href="../../ProductManagement?account=${user.getUserAccount()}">delete user</a>
						</td>
					</tr>
					</c:forEach>
					</c:if>
				</table>
				<c:if test="${empty sessionScope.users}">
							<p>No information found!</p>
					</c:if>
			</div>
			<div class="pagenumber" align="right">
				<table>
		        	<tbody>
		        		<tr>
		          			<td colspan="0" height="20" align="right">     				
								<a href="#">首页</a>&nbsp; 
			      				<a href="#">上一页</a>&nbsp;
			      				<a href="#">下一页</a>&nbsp; 
			      				<a href="#">尾页</a>&nbsp; 
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
			<form method="post" action="../../ProductManagement">
				<ul>
					<li>
						<b style="font-size: 28px;">user info</b>
					</li>
				</ul>
				<ul>
					<li>user account</li>
					<li><input maxlength="16" id="newAccount" name="userAccount"></li>
					<li style="color: red;" class="hide" id="AccountTip">account is exist!</li>
				</ul>
				<ul>
					<li>user name</li>
					<li><input maxlength="16" name="userName" id="newName"></li>
				</ul>
				<ul>
					<li>user password</li>
					<li><input maxlength="16" name="userPassword" id="newPassword"></li>
				</ul>
				<ul>
					<li>user description</li>
					<li><textarea rows="5" cols="21" maxlength="128" name="userDescription" id="newDescription"></textarea></li>
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