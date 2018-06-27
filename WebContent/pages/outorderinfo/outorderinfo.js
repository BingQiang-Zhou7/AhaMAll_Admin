//JavaScript Document

$(document).ready(
	function()
	{
		"use strict";
		$(".add").click(
			function()
			{
				$(".cover").removeClass("hide");
				//alert("123");
				var count = $(this).parent().prev().children();
				//alert(description.val());
				$("#newCount").val(count.val());
				var size = count.parent().prev().children();
				//alert(password.val());
				$("#newSize").val(size.val());
				var color = size.parent().prev().children();
				//alert(password.val());
				$("#newColor").val(color.val());
				var code = color.parent().prev().children();
				$("#newCode").val(code.val());
				$("#newSize").attr("disabled","disable");
				$("#newColor").attr("disabled","disable");
				$("#newCode").attr("disabled","disable");
			}
		);
		$(".edit").click(
				function()
				{
					$(".cover").removeClass("hide");
					//alert("123");
					var count = $(this).parent().prev().children();
					//alert(description.val());
					$("#newCount").val(count.val());
					var size = count.parent().prev().children();
					//alert(password.val());
					$("#newSize").val(size.val());
					var color = size.parent().prev().children();
					//alert(password.val());
					$("#newColor").val(color.val());
					var code = color.parent().prev().children();
					$("#newCode").val(code.val());
					$("#newSize").attr("disabled","disable");
					$("#newColor").attr("disabled","disable");
					$("#newCode").attr("disabled","disable");
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
					window.location.href = "../../OutOrderInfoServlet?fuzzyStr="+fuzzy;
					//location.reload();
				}
			);
		$("#save").click(
				function()
				{
					window.location.href = "../../OutOrderInfoServlet?op=save";
					//location.reload();
				}
			);
		$("#refresh").click(
				function()
				{
					window.location.href = "../../OutOrderInfoServlet";
					//location.reload();
				}
			);
//		$("#newCode").blur(
//			function()
//			{
//				$("#AccountTip").addClass("hide");
//				var code = $("#newCode").val();
//				if(code !== null)
//					{
//						var url = "../../CheckInfo?type=product&product="+code;
//						//alert(url);
//						ajaxGetResponeText("post",url,false);
//						var text = $("#tempVar").text();
//						//alert(text);
//						if(text === "true")
//							{
//								$("#AccountTip").removeClass("hide");
//							}else {
//								$("#AccountTip").addClass("hide");
//							}
//						//$("#tempVar").text("");
//					}
//			}
//		);
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
				$("#newSize").removeAttr("disabled");
				$("#newColor").removeAttr("disabled");
				$("#newCode").removeAttr("disabled");
				//alert("null");
			}
		);
		$("#Index1").click(
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
							pageUrl = "../../OutOrderInfoServlet?"+location.search+"&pageNo=0";
						}
					else
						{
							pageUrl = "../../OutOrderInfoServlet?pageNo=0";
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
			$("#pageUp1").click(
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
							pageUrl = "../../OutOrderInfoServlet?"+location.search+"&pageNo="+pageNo;
						}
					else
						{
							pageUrl = "../../OutOrderInfoServlet?pageNo="+pageNo;
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
			$("#pageDown1").click(
				function()
				{
					if($("#NoInfo")[0])
					{
						return;
					}
					var pageNo = Number($("#pageNo").text());
					$("#pageNo").text(pageNo+1);
					//alert(pageNo+1);
					var pageUrl;
					if(location.search !== "")
						{
							pageUrl = "../../OutOrderInfoServlet?"+location.search+"&pageNo="+pageNo;
						}
					else
						{
							pageUrl = "../../OutOrderInfoServlet?pageNo="+pageNo;
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
			$("#Index2").click(
					function()
					{
						var pageNo = Number($("#pageNo2").text());
						if(pageNo === 1)
							{
								return;
							}
						$("#pageNo2").text("1");
						var pageUrl;
						if(location.search !== "")
							{
								pageUrl = "../../OutOrderInfoServlet?"+location.search+"&pageNo2=0";
							}
						else
							{
								pageUrl = "../../OutOrderInfoServlet?pageNo2=0";
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
				$("#pageUp2").click(
					function()
					{
						var pageNo = Number($("#pageNo2").text());
						if(pageNo > 1)
							{
								pageNo=pageNo-1;
								$("#pageNo2").text(pageNo);
							}
						else {
							//alert("1");
							return;
						}
						pageNo=pageNo-1;
						var pageUrl;
						if(location.search !== "")
							{
								pageUrl = "../../OutOrderInfoServlet?"+location.search+"&pageNo2="+pageNo;
							}
						else
							{
								pageUrl = "../../OutOrderInfoServlet?pageNo2="+pageNo;
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
				$("#pageDown2").click(
					function()
					{
						if($("#NoInfoProducts")[0])
						{
							return;
						}
						var pageNo = Number($("#pageNo2").text());
						$("#pageNo2").text(pageNo+1);
						var pageUrl;
						if(location.search !== "")
							{
								pageUrl = "../../OutOrderInfoServlet?"+location.search+"&pageNo2="+pageNo;
							}
						else
							{
								pageUrl = "../../OutOrderInfoServlet?pageNo2="+pageNo;
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
//function getWarehouseInfo() {
//	$("option").remove(".child");
//	
//	var url = "../../RequestInfo?type=in";
//	//alert(url);
//	ajaxGetResponeText("post",url,false);
//	var text = $("#tempVar").text();
//	var strs = text.split('_');
//	for (var i = 0; i < strs.length-1; i++)
//		{
//			var sign = "<option class=\"child\" value=\""+strs[i]+"\">"+strs[i]+"</option>";
//			$("#newWarehouse").append(sign);
//		}
//	$("#tempVar").text("");
//}