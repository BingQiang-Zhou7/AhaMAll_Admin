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
					window.location.href = "../../WarehouseManagement";
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
		
	}
);