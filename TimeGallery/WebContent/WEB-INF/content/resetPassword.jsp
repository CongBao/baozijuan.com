<%@ page import="com.baozijuan.timegallery.action.base.WebConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reset Password</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
</head>
<body>
	<header><%@include file="headerOut.jsp"%></header>
	<div class="container">
		<div class="row" id="row">
			<div class="col-md-offset-3 col-md-6">
				<h3 class="text-center">Please enter your new password.</h3>
				<br>
				<form class="form-horizontal" method="post" action="resetPassword">
					<div class="form-group" id="passGroup">
						<label for="newPassword" class="col-sm-4 control-label">New Password</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" id="newPassword" placeholder="New Password" name="password">
						</div>
					</div>
					<div class="form-group" id="passConfirmGroup">
						<label for="confirmPassword" class="col-sm-4 control-label">Confirm Password</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<button type="submit" id="submitPassword" class="btn btn-primary" disabled="disabled">Confirm</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<footer><%@ include file="footer.jsp"%></footer>
	<script type="text/javascript">
		var rowObj = document.getElementById('row');
		rowObj.style.marginTop = window.innerHeight / 6 + "px";
		rowObj.style.marginBottom = window.innerHeight / 6 + "px";
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/resetPassword.js"></script>
</body>
</html>