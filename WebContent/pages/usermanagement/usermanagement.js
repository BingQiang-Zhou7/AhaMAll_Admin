// JavaScript Document

$(document).ready(
	function()
	{
		"use strict";
		$("#adduser").click(
			function()
			{
				$(".cover").removeClass("hide");
			}
		);
		$("#close").click(
			function()
			{
				$(".cover").addClass("hide");
			}
		);
	}
);