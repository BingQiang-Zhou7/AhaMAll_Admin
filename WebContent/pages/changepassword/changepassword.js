// JavaScript Document
function GetUrlParameter(name)
{
	"use strict";
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!==null)
	 {
		return  decodeURIComponent(r[2]);	 
	 }
	else
		{
			return null;
		}
}

function load() {
	"use strict";
	var t = GetUrlParameter("isNotMatch");
	if (t === "true") {
		$("#ErrorTip").text("Old password isn't match!");
		$("#ErrorTip").removeClass("hide");
	}
}


$(document).ready
(
	function()
	{
		"use strict";
		$("#newPwd2,#newPwd1").blur(
			function()
			{
				var newPwd1 = $("#newPwd1").val();
				var newPwd2 = $("#newPwd2").val();
				if (newPwd1 !== null && newPwd1 != "" && newPwd2 !== null && newPwd2 !== "") {
					if(newPwd1 !== newPwd2)
					   {
					   		$("#ErrorTip").removeClass("hide");
					   		$("button").attr("disabled","true");
					   }
					else {
						if ($("#oldPwd").val() !== null && $("#oldPwd").val() != "") {
							$("button").removeAttr("disabled");
						}
						else {
							$("button").attr("disabled","true");
						}
					}
				}
			}
		);
		$("#oldPwd").blur(
				function()
				{
					var oldPwd = $("#oldPwd").val();
						if ($("#oldPwd").val() !== null && $("#oldPwd").val() != "") {
							var newPwd1 = $("#newPwd1").val();
							var newPwd2 = $("#newPwd2").val();
							if (newPwd1 !== null && newPwd1 != "" && newPwd2 !== null && newPwd2 != "") {
								$("button").removeAttr("disabled");
							}
						}
						else {
								$("button").attr("disabled","true");
						}
				}
			);
	}
);