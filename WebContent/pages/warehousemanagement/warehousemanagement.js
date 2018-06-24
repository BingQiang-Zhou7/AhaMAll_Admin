//JavaScript Document

$(document).ready(
	function()
	{
		"use strict";
		$("#adduser").click(
			function()
			{
				$(".cover").removeClass("hide");
				$("#newAccount").removeAttr("disabled");
				$("#newAccount").val("");
				$("#newDescription").val("");
				$("#newPassword").val("");
				$("#newName").val("");
			}
		);
		$(".edit").click(
				function()
				{
					$(".cover").removeClass("hide");
					//alert("123");
					var description = $(this).parent().prev().children();
					//alert(description.val());
					$("#newDescription").val(description.val());
					var password = description.parent().prev().children();
					//alert(password.val());
					$("#newPassword").val(password.val());
					var name = password.parent().prev().children();
					//alert(name.val());
					$("#newName").val(name.val());
					var account = name.parent().prev().children();
					$("#newAccount").val(account.val());
					$("#newAccount").attr("disabled","true");
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
		$("#newAccount").blur(
			function()
			{
				$("#AccountTip").addClass("hide");
				var user = $("#newAccount").val();
				if(user !== null)
					{
						var url = "../../CheckInfo?type=user&user="+user;
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
				var account = $("#newAccount").val();
				var description = $("#newDescription").val();
				var password = $("#newPassword").val();
				var name = $("#newName").val();
				if(name === "" || password === "" || description === "" || account === "")
					{
						//alert("null");
						$("#isNull").removeClass("hide");
						return false;
					}
				//alert("null");
			}
		);
		
	}
);