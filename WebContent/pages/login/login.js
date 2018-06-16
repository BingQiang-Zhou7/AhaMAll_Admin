// JavaScript Document

function GetUrlParameter(name)
{
	"use strict";
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)
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
	if (t == "true") {
		$("#error_tip").removeClass("hide");
	}
}


$(document).ready(
	function()
	{
		"use strict";
		$("button").click(
			function()
			{
				var admin = $("#admin").val();
				var pwd = $("#password").val();
				//alert(admin+"\t"+pwd);
				if(admin == "" || pwd == "")
					{
						//alert(admin+"\t"+pwd);
						$("#error_tip").removeClass("hide");
						$("#error_tip").text("please input information!");
						return false;
					}
			});
		
		$("#password").keyup(
			function()
			{
				var pwd = $("#password").val();
				if(pwd.length > 0)
					{
						$("#error_tip").addClass("hide");
					}
			}
		);
		
		$("#admin").blur(
			function()
			{
				//alert("hello");
				$("#admin_error_tip").addClass("hide");
				var admin = $("#admin").val();
				if(admin != null)
					{
						var url = "../../CheckAdminServlet?admin="+admin;
						//alert(url);
						ajaxGetResponeText("get",url,false);
						var text = $("#tempVar").text();
						if(text == "false")
							{
								$("#admin_error_tip").removeClass("hide");
							}else {
								$("#admin_error_tip").addClass("hide");
							}
					}
			});
	});


function ajaxGetResponeText(method,url,sysc)
{
	"use strict";
	var xmlhttp;
	//var text;
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
			  //alert(xmlhttp.responseText);
			  //fun.call(this,xmlhttp.responseText);
			  $("#tempVar").text(xmlhttp.responseText);
			  //return xmlhttp.responseText; 
			}
	  };
	xmlhttp.open(method,url,sysc);
	xmlhttp.send();
}