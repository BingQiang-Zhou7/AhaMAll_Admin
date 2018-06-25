//JavaScript Document

$(document).ready(
	function()
	{
		"use strict";
		$("#add").click(
			function()
			{
				$(".cover").removeClass("hide");
				$("#newNumber").removeAttr("disabled");
				$("#newNumber").val("");
				$("#newName").val("");
				$("#newAdministrator").val("");
				$("#newTelephone").val("");
			}
		);
		$(".edit").click(
				function()
				{
					$(".cover").removeClass("hide");
					//alert("123");
					var telephone = $(this).parent().prev().prev().children();
					//alert(description.val());
					$("#newTelephone").val(telephone.val());
					var administrator = telephone.parent().prev().children();
					//alert(password.val());
					$("#newAdministrator").val(administrator.val());
					var name = administrator.parent().prev().children();
					//alert(name.val());
					$("#newName").val(name.val());
					var number = name.parent().prev().children();
					$("#newNumber").val(number.val());
					$("#newNumber").attr("disabled","true");
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
					window.location.href = "../../WarehouseManagement?fuzzyStr="+fuzzy;
					//location.reload();
				}
			);
		$("#refresh").click(
				function()
				{
					window.location.reload();
				}
			);
		$("#newNumber").blur(
			function()
			{
				$("#AccountTip").addClass("hide");
				var warehouse = $("#newNumber").val();
				if(warehouse !== null)
					{
						var url = "../../CheckInfo?type=warehouse&warehouse="+warehouse;
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
				var number = $("#newNumber").val();
				var telephone = $("#newTelephone").val();
				var administrator = $("#newAdministrator").val();
				var name = $("#newName").val();
				if(number === "" || telephone === "" || administrator === "" || name === "")
					{
						$("#isNull").removeClass("hide");
						return false;
					}
				$("#newNumber").removeAttr("disabled");
				//alert("null");
			}
		);
		$("#Index").click(
			function()
			{
				var pageNo = Number($("#pageNo").text());
				if(pageNo == 1)
					{
						return;
					}
				$("#pageNo").text("1");
				var pageUrl;
				if(location.search !== "")
					{
						pageUrl = "../../WarehouseManagement?"+location.search+"&pageNo=0";
					}
				else
					{
						pageUrl = "../../WarehouseManagement?pageNo=0";
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
						pageUrl = "../../WarehouseManagement?"+location.search+"&pageNo="+pageNo;
					}
				else
					{
						pageUrl = "../../WarehouseManagement?pageNo="+pageNo;
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
						pageUrl = "../../WarehouseManagement?"+location.search+"&pageNo="+pageNo;
					}
				else
					{
						pageUrl = "../../WarehouseManagement?pageNo="+pageNo;
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