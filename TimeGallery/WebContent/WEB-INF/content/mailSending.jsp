<%@ page import="com.baozijuan.timegallery.action.base.WebConstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sending Mail</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
</head>
<body>
	<header><%@ include file="headerOut.jsp"%></header>
	<div class="container">
		<div class="row" id="row">
			<div class="col-md-12 text-center">
				<s:if test="#session.intercept != null">
					<h4 style="color: red;">
						${sessionScope.intercept}
						<%session.setAttribute(WebConstant.INTERCEPT, null);%>
					</h4>
				</s:if>
				<s:else>
					<h3>A verification email is sending to your mailbox. Please wait for some seconds...</h3>
					<h3>If no response, you can <a href="/TimeGallery/login">click here</a> to sign in and verify your email later.</h3>
				</s:else>
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