/* !
 * Time Gallery (www.baozijuan.com)
 * Copyright (C) 2016-2017 Bao Cong.
 */

var account = false;
$("#email").blur(function() {
	var text = $("#email").val();
	var atPos = text.indexOf("@");
	var dotPos = text.lastIndexOf(".");
	if (atPos < 1 || dotPos - atPos < 2 || dotPos == text.length - 1) {
		account = false;
		$("#accountGroup").attr("class", "form-group has-error has-feedback");
		$("#email").siblings("span").remove();
		$("#email").after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
	} else {
		account = true;
		$("#accountGroup").attr("class", "form-group has-success has-feedback");
		$("#email").siblings("span").remove();
		$("#email").after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
	}
	if (account) {
		$("#submitBtn").removeAttr("disabled");
	} else {
		$("#submitBtn").attr("disabled", "disabled");
	}
});