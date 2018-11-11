
var flag1 = false;
var flag2 = false;
var flag3 = false;
var flag4 = false;
var flag5 = false;
$(function () {
	$("#receiveName").blur(function () {
		var reg = /^.{1,20}$/;
		var txt = $("#receiveName").val();
		$("#receiveName_info").fadeOut();
		if (txt == "") {
			$("#receiveName_info").text("\u63a5\u6536\u59d3\u540d\u4e0d\u80fd\u4e3a\u7a7a").fadeIn();
		} else {
			if (reg.test(txt)) {
				$("#receiveName_info").text("\u53ef\u7528").fadeIn();
				flag1 = true;
			} else {
				$("#receiveName_info").text("\u683c\u5f0f\u6709\u8bef").fadeIn();
			}
		}
	});
	$("#fullAddress").blur(function () {
		var reg = /^.{1,200}$/;
		var txt = $("#fullAddress").val();
		$("#fullAddress_info").fadeOut();
		if (txt == "") {
			$("#fullAddress_info").text("\u5730\u5740\u4e0d\u80fd\u4e3a\u7a7a").fadeIn();
		} else {
			if (reg.test(txt)) {
				$("#fullAddress_info").text("\u53ef\u7528").fadeIn();
				flag2 = true;
			} else {
				$("#fullAddress_info").text("\u683c\u5f0f\u6709\u8bef").fadeIn();
			}
		}
	});
	$("#postalCode").blur(function () {
		var reg = /^[0-9]{6}$/;
		var txt = $("#postalCode").val();
		$("#postalCode_info").fadeOut();
		if (txt == "") {
			$("#postalCode_info").text("\u90ae\u7f16\u4e0d\u80fd\u4e3a\u7a7a").fadeIn();
		} else {
			if (reg.test(txt)) {
				$("#postalCode_info").text("\u53ef\u7528").fadeIn();
				flag3 = true;
			} else {
				$("#postalCode_info").text("\u683c\u5f0f\u6709\u8bef").fadeIn();
			}
		}
	});
	$("#phone").blur(function () {
		var reg = /^[0-9]{1,20}$/;
		var txt = $("#phone").val();
		$("#phone_info").fadeOut();
		if (txt == "") {
			$("#phone_info").text("\u4e0d\u80fd\u4e3a\u7a7a").fadeIn();
		} else {
			if (reg.test(txt)) {
				$("#phone_info").text("\u53ef\u7528").fadeIn();
				flag4 = true;
			} else {
				$("#phone_info").text("\u683c\u5f0f\u6709\u8bef").fadeIn();
			}
		}
	});
	$("#mobile").blur(function () {
		var reg = /^[0-9]{11}$/;
		var txt = $("#mobile").val();
		$("#mobile_info").fadeOut();
		if (txt == "") {
			$("#mobile_info").text("\u4e0d\u80fd\u4e3a\u7a7a").fadeIn();
		} else {
			if (reg.test(txt)) {
				$("#mobile_info").text("\u53ef\u7528").fadeIn();
				flag5 = true;
			} else {
				$("#mobile_info").text("\u683c\u5f0f\u6709\u8bef").fadeIn();
			}
		}
	});
});

function form_submit() {
	return flag1 && flag2 && flag3 && flag4 && flag5;
}

function change(value){
	if(value=='new'){
		$('#receiveName').val('');
		$('#fullAddress').val('');
		$('#postalCode').val('');
		$('#phone').val('');
		$('#mobile').val('');
	}
	if(value=='old'){
		location='';
	}
}
