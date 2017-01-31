<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Permission Denied</title>
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
				<h1>Sorry, you have no permission to access this zone.</h1>
				<div class="col-md-offset-4 col-md-4">
					<a href="/TimeGallery/index" class="btn btn-default btn-lg btn-block">Return to index</a>
				</div>
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