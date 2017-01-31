<%@ page import="com.baozijuan.timegallery.action.base.WebConstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mail Verify</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
</head>
<body>
	<header><%@include file="headerOut.jsp"%></header>
	<div class="container">
		<div class="row" id="row">
			<div class="col-md-12 text-center">
				<h3>An email has sent to your mailbox for verification.</h3>
				<h3>Please check it and enter the verification code in 10 minutes.</h3>
				<br />
				<form class="form-inline" method="post" action="verify">
					<div class="form-group">
						<label for="verifyCode">Enter Verification Code</label>
						<input type="text" class="form-control" id="verifyCode" placeholder="Verification Code" name="code">
					</div>
					<button type="submit" class="btn btn-primary">Confirm</button>
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
</body>
</html>