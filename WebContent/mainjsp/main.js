// JavaScript Document

var clientX;
var clientY;
$(document).ready(
	function()
	{
		"use strict";
		$("#menu_operater").click(
			function()
			{
				var text = $("#menu_operater").text();
				if(text === "hide")
					{
						$("#menu_operater").text("show");
						$(".left_menu").addClass("hide");
					}
				else
					{
						$("#menu_operater").text("hide");
						$(".left_menu").removeClass("hide");
					}
			}
		);
		
		
//		$(window).unload(
//			function()
//			{
//				alert("1111 call success!");
//				if(event.clientY < 0)
//					{
//						 $.ajax({ 
//								url:"../../ClearSession",//servlet path
//								type:"POST",
//								async:false,
//								success:function(){ 
//								   alert("call success!");
//									//console.log(pageUrl+" call success!");
//									//location.reload();
//								}  
//							});
//					}
//			});
//		$("a").click(
//			function()
//			{
//				var text = $(this).text();
//				$("a").each(
//					function()
//					{
//						if(text === $(this).text())
//							{
//								$(this).addClass("select");
//							}
//						else
//							{
//								$(this).removeClass("select");
//							}
//					}
//				);
//			}
//		);	
	}
);


$(window).on('clickd',function()
			{
	"use strict";
	clientX = event.clientX;
	clientY = event.clientY;
});

$(window).on('load', function () {
	"use strict";
	var url = window.location.pathname;
	var strs  =  url.split('/');
	//alert(strs);
	var pages = strs[strs.length-2];
	//alert(pages);
	$("a").each(
		function()
		{
			//alert(pages+$(this).attr("id"));
			if(pages === $(this).attr("id"))
				{
					$(this).addClass("select");
				}
			else
				{
					$(this).removeClass("select");
				}
		}
	);
});
//
//$(window).bind('onbeforeunload', function () {
//	"use strict";
//	alert(clientY);
//		if(clientY < 0)
//		{
//			alert(clientY);
//			console.log("hello");
//		}
////	if(window.event.clientY < 0)
////		{ss
////			return "exit";	
////		}
//});


//function load(pageUrl) { 
//	"use strict";
//    $.ajax({ 
//        url:pageUrl,//servlet path
//        type:"POST",
//        async:false,
//        success:function(e){ 
//            //alert(pageUrl+" call success!");
//        	//console.log(pageUrl+" call success!");
//        	location.reload();
//        }  
//    });
////    if ($("body").hasClass("OK") === false) {
////    	location.reload();
////	}
//}


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

function ajaxGetResponeText(method,url,sysc)
{
	"use strict";
	var xmlhttp;
	//var text;
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	  {
		  if (xmlhttp.readyState===4 && xmlhttp.status===200)
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