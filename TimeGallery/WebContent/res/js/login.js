/* !
 * Time Gallery (www.baozijuan.com)
 * Copyright (C) 2016-2017 Bao Cong.
 */

// status of each required part
var email = false;
var password = false;
var confirm = false;
var agree = false;

// reset button
$("#resetBtn").click(function() {
	$(".form-group.has-error.has-feedback").attr("class", "form-group");
	$(".form-group.has-warning.has-feedback").attr("class", "form-group");
	$(".form-group.has-success.has-feedback").attr("class", "form-group");
	$(".col-sm-8").children("span").remove();
	$("#submitBtn").attr("disabled", "disabled");
	email = false;
	password = false;
	confirm = false;
	agree = false;
});

// check if the email was valid
$("#registEmail")
		.blur(
				function() {
					var text = $("#registEmail").val();
					var atPos = text.indexOf("@");
					var dotPos = text.lastIndexOf(".");
					if (atPos < 1 || dotPos - atPos < 2
							|| dotPos == text.length - 1) {
						email = false;
						$("#emailGroup").attr("class",
								"form-group has-error has-feedback");
						$("#registEmail").siblings("span").remove();
						$("#registEmail")
								.after(
										'<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
					} else {
						email = true;
						$("#emailGroup").attr("class",
								"form-group has-success has-feedback");
						$("#registEmail").siblings("span").remove();
						$("#registEmail")
								.after(
										'<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
					}
					checkStatus();
				});

// the complexity of password
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

// check the complexity of password
$("#registPassword")
		.blur(
				function() {
					var pass = $("#registPassword").val();
					var com = passComplexity(pass);
					if (com == 0) {
						password = false;
						$("#passGroup").attr("class",
								"form-group has-error has-feedback");
						$("#registPassword").siblings("span").remove();
						$("#registPassword")
								.after(
										'<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
					} else if (com > 0 && com < 3) {
						password = true;
						$("#passGroup").attr("class",
								"form-group has-warning has-feedback");
						$("#registPassword").siblings("span").remove();
						$("#registPassword")
								.after(
										'<span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>');
					} else {
						password = true;
						$("#passGroup").attr("class",
								"form-group has-success has-feedback");
						$("#registPassword").siblings("span").remove();
						$("#registPassword")
								.after(
										'<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
					}
					checkStatus();
				});

// check if the confirmation was equal to the password
$("#confirmPassword")
		.blur(
				function() {
					var confirmPass = $("#confirmPassword").val();
					var pass = $("#registPassword").val();
					if (confirmPass.length == 0 || confirmPass != pass
							|| passComplexity(pass) == 0) {
						confirm = false;
						$("#passConfirmGroup").attr("class",
								"form-group has-error has-feedback");
						$("#confirmPassword").siblings("span").remove();
						$("#confirmPassword")
								.after(
										'<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
					} else {
						confirm = true;
						$("#passConfirmGroup").attr("class",
								"form-group has-success has-feedback");
						$("#confirmPassword").siblings("span").remove();
						$("#confirmPassword")
								.after(
										'<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
					}
					checkStatus();
				});

// check if the agreement checkbox was checked
$("#agreement").click(function() {
	if ($("#agreement").is(":checked")) {
		agree = true;
	} else {
		agree = false;
	}
	checkStatus();
});

// check the status of each required part and change the state of submit button
function checkStatus() {
	if (agree && email && password && confirm) {
		$("#submitBtn").removeAttr("disabled");
	} else {
		$("#submitBtn").attr("disabled", "disabled");
	}
}

// md5
$('#loginForm').submit(function() {
	$('#signPassword').val($.md5($('#signPassword').val()));
});

$('#registForm').submit(function() {
	$('#registPassword').val($.md5($('#registPassword').val()));
	$('#confirmPassword').val($.md5($('#confirmPassword').val()));
});