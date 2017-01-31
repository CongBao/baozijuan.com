/* !
 * Time Gallery (www.baozijuan.com)
 * Copyright (C) 2016-2017 Bao Cong.
 */

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

var password = false;
var confirm = false;

$("#newPassword").blur(function() {
	var pass = $("#newPassword").val();
	var com = passComplexity(pass);
	if (com == 0) {
		password = false;
		$("#passGroup").attr("class", "form-group has-error has-feedback");
		$("#newPassword").siblings("span").remove();
		$("#newPassword").after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
	} else if (com > 0 && com < 3) {
		password = true;
		$("#passGroup").attr("class", "form-group has-warning has-feedback");
		$("#newPassword").siblings("span").remove();
		$("#newPassword").after('<span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>');
	} else {
		password = true;
		$("#passGroup").attr("class", "form-group has-success has-feedback");
		$("#newPassword").siblings("span").remove();
		$("#newPassword").after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
	}
	checkPass();
});

$("#confirmPassword").blur(function() {
	var confirmPass = $("#confirmPassword").val();
	var pass = $("#newPassword").val();
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
	if (password && confirm) {
		$("#submitPassword").removeAttr("disabled");
	} else {
		$("#submitPassword").attr("disabled", "disabled");
	}
}