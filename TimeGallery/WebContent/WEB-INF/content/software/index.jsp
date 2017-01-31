<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Software Index</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/three.min.js"></script>
<style type="text/css">
	body {
		background: #000;
		color: #fff;
	}
	#webnav {
		margin-bottom: 0;
	}
	#foot {
		margin-top: -7.5em;
	}
	canvas {
		position: fixed;
    	z-index: -99;
	}
	a.btn {
		background: rgba(255,255,255,0);
		color: #fff;
	}
</style>
</head>
<body>
	<div id="contain"></div>
	<header><%@ include file="../headerIn.jsp"%></header>
	<div class="container">
		<div class="row" id="row">
			<div class="col-md-12 text-center">
				<h1>Nothing is impossible.</h1>
				<div class="col-md-offset-4 col-md-4">
					<a href="/TimeGallery/software/downloads" class="btn btn-default btn-lg btn-block">Browse for softwares</a>
				</div>
			</div>
		</div>
	</div>
	<footer id="foot"><%@ include file="../footer.jsp"%></footer>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/ball.js"></script>
	<script type="text/javascript">
		$("#webnav").attr("class", "navbar navbar-inverse navbar-static-top");
		var rowObj = document.getElementById('row');
		rowObj.style.marginTop = window.innerHeight / 2.45 + "px";
		rowObj.style.marginBottom = window.innerHeight / 2.45 + "px";
	</script>
</body>
</html>