<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gallery of Him</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/timelinr.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/timelinr.js"></script>
<style type="text/css">
	a.btn {
		background: rgba(255,255,255,0);
		color: #fff;
	}
</style>
<script type="text/javascript">
	$(function(){
		$().timelinr({
			orientation: 'vertical',
			arrowKeys: 'true',
			issuesSpeed: 'normal',
			issuesTransparency: 0
		});
	});
</script>
</head>
<body>
	<header><%@ include file="../headerIn.jsp"%></header>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						Gallery of Him
						<a href="/TimeGallery/photo/index" class="btn btn-default pull-right">Return to index</a>
					</h1>
				</div>
				<div id="timeline">
					<div class="col-md-4">
						<ul id="dates">
							<li><a href="#t1">Apr. #1</a></li>
							<li><a href="#t2">Apr. #2</a></li>
							<li><a href="#t3">Aug. #1</a></li>
							<li><a href="#t4">Aug. #2</a></li>
						</ul>
					</div>
					<div class="col-md-8">
						<ul id="issues">
							<li id="t1">
								<h1>April in Wuhan</h1>
								<p>Making a phone call in Mo hill park.</p>
								<img alt="him01" src="/TimeGallery/res/photo/galleryOfHim01.jpg" width="550px">
							</li>
							<li id="t2">
								<h1>April in Wuhan</h1>
								<p>having lunch in Tanhualin road.</p>
								<img alt="him02" src="/TimeGallery/res/photo/galleryOfHim02.jpg" width="550px">
							</li>
							<li id="t3">
								<h1>August in Suzhou</h1>
								<p>Waiting for bus in Egret park.</p>
								<img alt="him03" src="/TimeGallery/res/photo/galleryOfHim03.jpg" width="300px">
							</li>
							<li id="t4">
								<h1>August in Shanghai</h1>
								<p>Skating at a skating rink on Renmin square.</p>
								<img alt="him04" src="/TimeGallery/res/photo/galleryOfHim04.jpg" width="300px">
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer><%@ include file="../footer.jsp"%></footer>
	<script type="text/javascript">
		$("#webnav").attr("class", "navbar navbar-inverse navbar-static-top");
	</script>
</body>
</html>