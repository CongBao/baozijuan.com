/* !
 * Time Gallery (www.baozijuan.com)
 * Copyright (C) 2016-2017 Bao Cong.
 */

// check account
var account = false;
$("#editAccount").blur(function() {
	var text = $("#editAccount").val();
	var atPos = text.indexOf("@");
	var dotPos = text.lastIndexOf(".");
	if (atPos < 1 || dotPos - atPos < 2 || dotPos == text.length - 1) {
		account = false;
		$("#accountGroup").attr("class", "form-group has-error has-feedback");
		$("#editAccount").siblings("span").remove();
		$("#editAccount").after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
	} else {
		account = true;
		$("#accountGroup").attr("class", "form-group has-success has-feedback");
		$("#editAccount").siblings("span").remove();
		$("#editAccount").after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
	}
	if (account) {
		$("#submitAccount").removeAttr("disabled");
	} else {
		$("#submitAccount").attr("disabled", "disabled");
	}
});

$("#resetAccount").click(function() {
	$("#accountGroup").attr("class", "form-group");
	$("#editAccount").siblings("span").remove();
	$("#submitAccount").attr("disabled", "disabled");
	account = false;
});

// check password
function passComplexity(pass) {
	var com = 0;
	if (pass.length < 6) {
		return 0;
	}
	if (pass.match(/([0-9])+/)) {
		com++;
	}
	if (pass.match(/([a-z])+/)) {
		com++;
	}
	if (pass.match(/([A-Z])+/)) {
		com++;
	}
	if (pass.match(/[^a-zA-Z0-9]+/)) {
		com++;
	}
	return com;
}

var old = false;
var password = false;
var confirm = false;
$("#oldPassword").blur(function() {
	var pass = $("#oldPassword").val();
	if (pass.length == 0) {
		old = false;
	} else {
		old = true;
	}
	checkPass();
});

$("#editPassword").blur(function() {
	var pass = $("#editPassword").val();
	var com = passComplexity(pass);
	if (com == 0) {
		password = false;
		$("#passGroup").attr("class", "form-group has-error has-feedback");
		$("#editPassword").siblings("span").remove();
		$("#editPassword").after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
	} else if (com > 0 && com < 3) {
		password = true;
		$("#passGroup").attr("class", "form-group has-warning has-feedback");
		$("#editPassword").siblings("span").remove();
		$("#editPassword").after('<span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>');
	} else {
		password = true;
		$("#passGroup").attr("class", "form-group has-success has-feedback");
		$("#editPassword").siblings("span").remove();
		$("#editPassword").after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
	}
	checkPass();
});

$("#confirmPassword").blur(function() {
	var confirmPass = $("#confirmPassword").val();
	var pass = $("#editPassword").val();
	if (confirmPass.length == 0 || confirmPass != pass || passComplexity(pass) == 0) {
		confirm = false;
		$("#passConfirmGroup").attr("class", "form-group has-error has-feedback");
		$("#confirmPassword").siblings("span").remove();
		$("#confirmPassword").after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
	} else {
		confirm = true;
		$("#passConfirmGroup").attr("class", "form-group has-success has-feedback");
		$("#confirmPassword").siblings("span").remove();
		$("#confirmPassword").after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
	}
	checkPass();
});

function checkPass() {
	if (old && password && confirm) {
		$("#submitPassword").removeAttr("disabled");
	} else {
		$("#submitPassword").attr("disabled", "disabled");
	}
}

$("#resetPassword").click(function() {
	$("#passGroup").attr("class", "form-group");
	$("#passConfirmGroup").attr("class", "form-group");
	$("#editPassword").siblings("span").remove();
	$("#confirmPassword").siblings("span").remove();
	$("#submitPassword").attr("disabled", "disabled");
	old = false;
	password = false;
	confirm = false;
});

// check delete
$("#agreement").click(function() {
	if ($("#agreement").is(":checked")) {
		$("#deleteAccount").removeAttr("disabled");
	} else {
		$("#deleteAccount").attr("disabled", "disabled");
	}
});