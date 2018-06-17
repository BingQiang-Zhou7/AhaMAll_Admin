// JavaScript Document
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
		$("a").click(
			function()
			{
				var text = $(this).text();
				$("a").each(
					function()
					{
						if(text === $(this).text())
							{
								$(this).addClass("select");
							}
						else
							{
								$(this).removeClass("select");
							}
					}
				);
			}
		);
	}
);