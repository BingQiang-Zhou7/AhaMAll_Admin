//JavaScript Document

$(document).ready(
	function()
	{
		"use strict";
		$("#add").click(
			function()
			{
				$(".cover").removeClass("hide");
				$("#newNo").val("auto generate");
				$("#newWarehouse").val("");
				$("#newReceive").val("");
				$("#newtelephone").val("");
				
				getWarehouseInfo();
			}
		);
		$(".edit").click(
				function()
				{
					$(".cover").removeClass("hide");
					//alert("123");
					var telephone = $(this).parent().prev().children();
					//alert(description.val());
					$("#newtelephone").val(telephone.val());
					var receive = telephone.parent().prev().children();
					//alert(password.val());
					$("#newReceive").val(receive.val());
					var warehouse = receive.parent().prev().children();
					//alert(password.val());
					$("#newWarehouse").val(warehouse.val());
					var no = warehouse.parent().prev().prev().prev().children();
					$("#newNo").val(no.val());
				
					getWarehouseInfo();
				}
			);
		$("#close").click(
			function()
			{
				$(".cover").addClass("hide");
			}
		);
		$("#search").click(
				function()
				{
					var fuzzy = $("#fuzzy").val();
					//alert(fuzzy);
//					if(window.location.search === " " && fuzzy.length > 0)
//						{
//							alert(window.location.href);
//							
//						}
					window.location.href = "../../OutboundServlet?fuzzyStr="+fuzzy;
					//location.reload();
				}
			);
		$("#refresh").click(
				function()
				{
					window.location.href = "../../OutboundServlet";
					//location.reload();
				}
			);
		$("#newCode").blur(
			function()
			{
				$("#AccountTip").addClass("hide");
				var code = $("#newCode").val();
				if(code !== null)
					{
						var url = "../../CheckInfo?type=product&product="+code;
						//alert(url);
						ajaxGetResponeText("post",url,false);
						var text = $("#tempVar").text();
						//alert(text);
						if(text === "true")
							{
								$("#AccountTip").removeClass("hide");
							}else {
								$("#AccountTip").addClass("hide");
							}
						//$("#tempVar").text("");
					}
			}
		);
		$("#OK").click(
			function()
			{
				$("isNull").addClass("hide");
				//var no = $("#newNo").val();
				var from = $("#newFrom").val();
				var warehouse = $("#newWarehouse").val();
				
				if(from === "" || warehouse === "")
					{
						//alert("null");
						$("#isNull").removeClass("hide");
						return false;
					}
				$("#newNo").removeAttr("disabled");
				//alert("null");
			}
		);
		$("#Index").click(
				function()
				{
					var pageNo = Number($("#pageNo").text());
					if(pageNo === 1)
						{
							return;
						}
					$("#pageNo").text("1");
					var pageUrl;
					if(location.search !== "")
						{
							pageUrl = "../../OutboundServlet?"+location.search+"&pageNo=0";
						}
					else
						{
							pageUrl = "../../OutboundServlet?pageNo=0";
						}
					 $.ajax({ 
				        url:pageUrl,//servlet path
				        type:"POST",
				        async:false,
				        success:function(e){ 
				        	//console.log(pageUrl+" call success!");
				        	location.reload();
							//alert(pageUrl+" call success!");
				        }  
				    });
					
				}
			);
			$("#pageUp").click(
				function()
				{
					var pageNo = Number($("#pageNo").text());
					if(pageNo > 1)
						{
							pageNo=pageNo-1;
							$("#pageNo").text(pageNo);
						}
					else {
						//alert("1");
						return;
					}
					pageNo=pageNo-1;
					var pageUrl;
					if(location.search !== "")
						{
							pageUrl = "../../OutboundServlet?"+location.search+"&pageNo="+pageNo;
						}
					else
						{
							pageUrl = "../../OutboundServlet?pageNo="+pageNo;
						}
					 $.ajax({ 
				        url:pageUrl,//servlet path
				        type:"POST",
				        async:false,
				        success:function(e){ 
				            //alert(pageUrl+" call success!");
				        	//console.log(pageUrl+" call success!");
				        	location.reload();
				        }  
				    });
				}
			);
			$("#pageDown").click(
				function()
				{
					if($("#NoInfo")[0])
					{
						return;
					}
					var pageNo = Number($("#pageNo").text());
					$("#pageNo").text(pageNo+1);
					var pageUrl;
					if(location.search !== "")
						{
							pageUrl = "../../OutboundServlet?"+location.search+"&pageNo="+pageNo;
						}
					else
						{
							pageUrl = "../../OutboundServlet?pageNo="+pageNo;
						}
					 $.ajax({ 
				        url:pageUrl,//servlet path
				        type:"POST",
				        async:false,
				        success:function(e){ 
				           // alert(pageUrl+" call success!");
				        	//console.log(pageUrl+" call success!");
				        	location.reload();
				        }  
				    });
				}
			);
	}
);
function getWarehouseInfo() {
	$("option").remove(".child");
	
	var url = "../../RequestInfo?type=in";
	//alert(url);
	ajaxGetResponeText("post",url,false);
	var text = $("#tempVar").text();
	var strs = text.split('_');
	for (var i = 0; i < strs.length-1; i++)
		{
			var sign = "<option class=\"child\" value=\""+strs[i]+"\">"+strs[i]+"</option>";
			$("#newWarehouse").append(sign);
		}
	$("#tempVar").text("");
}