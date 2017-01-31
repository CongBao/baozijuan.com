<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chat Index</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/snow.js"></script>
<style type="text/css">
	body {
		background-image: url(/TimeGallery/res/img/chatbg.jpg);
		background-size: 100%;
		background-repeat: no-repeat;
		background-attachment: fixed;
		color: #fff;
	}
	.snow-container {
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		pointer-events: none;
		z-index: 100001;
	}
	a.btn {
		background: rgba(255,255,255,0);
		color: #fff;
	}
</style>
</head>
<body>
	<header><%@ include file="../headerIn.jsp"%></header>
	<div class="container" style="margin-top: 3.7em;">
		<div class="row" id="row">
			<div class="col-md-12 text-center">
				<h1>Select the most beautiful snowflake.</h1>
				<h1>Write down your most sincere words.</h1>
				<div class="col-md-offset-4 col-md-4">
					<a href="/TimeGallery/chat/moments" class="btn btn-default btn-lg btn-block">View the nicest moments</a>
				</div>
				<div class="snow-container"></div>
			</div>
		</div>
	</div>
	<footer><%@ include file="../footer.jsp"%></footer>
	<script type="text/javascript">
		var rowObj = document.getElementById('row');
		rowObj.style.marginTop = window.innerHeight / 3.1 + "px";
		rowObj.style.marginBottom = window.innerHeight / 3.1 + "px";
	</script>
</body>
</html>