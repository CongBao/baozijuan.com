<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Photo Index</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/particle.js"></script>
<style type="text/css">
	body {
		background: #222;
		color: #fff;
	}
	a.list-group-item {
		background: rgba(255,255,255,0);
		color: #fff;
	}
	footer {
		margin-top: -1em;
	}
	canvas {
		position: absolute;
    	z-index: -99;
	}
</style>
</head>
<body>
	<div id="contain"></div>
	<header><%@ include file="../headerIn.jsp"%></header>
	<div class="container">
		<div class="row" id="row">
			<div class="text-center">
				<h1>Find the stars that belong to you.</h1>
				<h1>Collect them in our time gallery.</h1>
				<div class="col-md-offset-4 col-md-4">
					<hr>
					<div class="list-group">
						<a href="/TimeGallery/photo/galleryHer" class="list-group-item">Gallery of her</a>
						<a href="/TimeGallery/photo/galleryHim" class="list-group-item">Gallery of him</a>
						<a href="/TimeGallery/photo/galleryUs" class="list-group-item">Gallery of&nbsp;&nbsp;us&nbsp;</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer><%@ include file="../footer.jsp"%></footer>
	<script type="text/javascript">
		$("#webnav").attr("class", "navbar navbar-inverse navbar-static-top");
		var rowObj = document.getElementById('row');
		rowObj.style.marginTop = window.innerHeight / 4 + "px";
		rowObj.style.marginBottom = window.innerHeight / 4 + "px";
	</script>
</body>
</html>