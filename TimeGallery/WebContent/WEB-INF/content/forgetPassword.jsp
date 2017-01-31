<%@ page import="com.baozijuan.timegallery.action.base.WebConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Forget Password</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
<style type="text/css">
	#email {
		width: 280px;
	}
</style>
</head>
<body>
	<header><%@include file="headerOut.jsp"%></header>
	<div class="container">
		<div class="row" id="row">
			<div class="col-md-12 text-center">
				<h3>Please enter your e-mail account.</h3>
				<br>
				<form class="form-inline" method="post" action="forgetPassword">
					<div class="form-group" id="accountGroup">
						<label class="sr-only" for="email">Email</label>
						<input type="text" class="form-control" id="email" placeholder="Email" name="account">
					</div>
					<button type="submit" id="submitBtn" class="btn btn-primary" disabled="disabled">Confirm</button>
				</form>
				<h4 style="color: red;">&nbsp;
					<s:if test="#session.intercept != null">${sessionScope.intercept}</s:if>
					<%session.setAttribute(WebConstant.INTERCEPT, null);%>
				</h4>
			</div>
		</div>
	</div>
	<footer><%@ include file="footer.jsp"%></footer>
	<script type="text/javascript">
		var rowObj = document.getElementById('row');
		rowObj.style.marginTop = window.innerHeight / 4 + "px";
		rowObj.style.marginBottom = window.innerHeight / 4 + "px";
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/forgetPassword.js"></script>
</body>
</html>