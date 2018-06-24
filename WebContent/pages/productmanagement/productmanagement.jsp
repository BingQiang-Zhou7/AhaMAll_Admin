<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Product Management</title>
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
				<p><strong>Product Information</strong></p>
				</div>
				<div class="table_opearter">
				<p class="left" id="add">add product</p>
				<p id="refresh">refresh</p>
				</div>
			</div>
			<div class="table_style">
				<table>
					<tr>
						<th>Code</th>
						<th>name</th>
						<th>color</th>
						<th>size</th>
						<th>price</th>
						<th>operate</th>
					</tr>
					<c:if test="${not empty sessionScope.products}">
					<c:forEach items="${sessionScope.products}" var="product">
					<tr>
						<td><input class="table_input" type="text" readonly value="${product.getClothingCode()}"></td>
						<td><input class="table_input" type="text" readonly value="${product.getClothingName()}"></td>
						<td><input class="table_input" type="text" readonly value="${product.getClothingColor()}"></td>
						<td><input class="table_input" type="text" readonly value="${product.getClothingSize()}"></td>
						<td><input class="table_input" type="text" readonly value="${product.getClothingPrice()}"></td>
						<td>
						<a href="javascript:void(0);" class="edit">edit</a>
						<a href="../../ProductManagement?code=${product.getClothingCode()}">delete</a>
						</td>
					</tr>
					</c:forEach>
					</c:if>
				</table>
				<c:if test="${empty sessionScope.products}">
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
						<b style="font-size: 28px;">product info</b>
					</li>
				</ul>
				<ul>
					<li>product code</li>
					<li><input maxlength="16" id="newCode" name="newCode"></li>
					<li style="color: red;" class="hide" id="AccountTip">account is exist!</li>
				</ul>
				<ul>
					<li>product name</li>
					<li><input maxlength="16" name="newName" id="newName"></li>
				</ul>
				<ul>
					<li>product color</li>
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
					<li>product size</li>
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
					<li>product price</li>
					<li><input type="number" min="0" step="0.01" name="newPrice"  id="newPrice"></li>
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