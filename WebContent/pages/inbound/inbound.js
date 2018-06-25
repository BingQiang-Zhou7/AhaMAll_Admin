//JavaScript Document

$(document).ready(
	function()
	{
		"use strict";
		$("#add").click(
			function()
			{
				$(".cover").removeClass("hide");
				$("#newCode").removeAttr("disabled");
				$("#newCode").val("");
				$("#newName").val("");
				$("#newColor").val("");
				$("#newSize").val("");
				$("#newPrice").val("");
			}
		);
		$(".edit").click(
				function()
				{
					$(".cover").removeClass("hide");
					//alert("123");
					var price = $(this).parent().prev().children();
					//alert(description.val());
					$("#newPrice").val(price.val());
					var size = price.parent().prev().children();
					//alert(password.val());
					$("#newSize").val(size.val());
					var color = size.parent().prev().children();
					//alert(name.val());
					$("#newColor").val(color.val());
					var name = color.parent().prev().children();
					$("#newName").val(name.val());
					var code = name.parent().prev().children();
					$("#newCode").val(code.val());
					$("#newCode").attr("disabled","true");
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
					window.location.href = "../../ProductManagement?fuzzyStr="+fuzzy;
					//location.reload();
				}
			);
		$("#refresh").click(
				function()
				{
					window.location.href = "../../ProductManagement";
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
				var code = $("#newCode").val();
				var name = $("#newName").val();
				var color = $("#newColor").val();
				var size = $("#newSize").val();
				var price =$("#newPrice").val();
				
				if(code === "" || name === "" || color === "" || size === "" ||price === "")
					{
						//alert("null");
						$("#isNull").removeClass("hide");
						return false;
					}
				$("#newCode").removeAttr("disabled");
				//alert("null");
			}
		);
		
	}
);