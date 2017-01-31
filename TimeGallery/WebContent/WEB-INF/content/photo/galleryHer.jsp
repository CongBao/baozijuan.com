<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gallery of Her</title>
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
						Gallery of Her
						<a href="/TimeGallery/photo/index" class="btn btn-default pull-right">Return to index</a>
					</h1>
				</div>
				<div id="timeline">
					<div class="col-md-4">
						<ul id="dates">
							<li><a href="#t1">Apr. #1</a></li>
							<li><a href="#t2">Apr. #2</a></li>
							<li><a href="#t3">Jul. #1</a></li>
							<li><a href="#t4">Jul. #2</a></li>
							<li><a href="#t5">Aug. #1</a></li>
							<li><a href="#t6">Aug. #2</a></li>
							<li><a href="#t7">Aug. #3</a></li>
							<li><a href="#t8">Aug. #4</a></li>
						</ul>
					</div>
					<div class="col-md-8">
						<ul id="issues">
							<li id="t1">
								<h1>April in Wuhan</h1>
								<p>Panda rice on Tanhualin road.</p>
								<img alt="her01" src="/TimeGallery/res/photo/galleryOfHer01.jpg" width="550px">
							</li>
							<li id="t2">
								<h1>April in Wuhan</h1>
								<p>Sauted yogurt in University of Wuhan.</p>
								<img alt="her02" src="/TimeGallery/res/photo/galleryOfHer02.jpg" width="230px">
							</li>
							<li id="t3">
								<h1>July in Suzhou</h1>
								<p>Coffee in Suzhou Museum</p>
								<img alt="her03" src="/TimeGallery/res/photo/galleryOfHer03.jpg" width="230px">
							</li>
							<li id="t4">
								<h1>July in Suzhou</h1>
								<p>Mung bean soup in Pingjiang road.</p>
								<img alt="her04" src="/TimeGallery/res/photo/galleryOfHer04.jpg" width="550px">
							</li>
							<li id="t5">
								<h1>August in Shanghai</h1>
								<p>Steamed buns in Nanjing road.</p>
								<img alt="her05" src="/TimeGallery/res/photo/galleryOfHer05.jpg" width="550px">
							</li>
							<li id="t6">
								<h1>August in Shanghai</h1>
								<p>Chafing dish in New World square.</p>
								<img alt="her06" src="/TimeGallery/res/photo/galleryOfHer06.jpg" width="550px">
							</li>
							<li id="t7">
								<h1>August in Shanghai</h1>
								<p>Beefsteak in Renmin square.</p>
								<img alt="her07" src="/TimeGallery/res/photo/galleryOfHer07.jpg" width="550px">
							</li>
							<li id="t8">
								<h1>August in Shanghai</h1>
								<p>Ice-cream in Renmin square.</p>
								<img alt="her08" src="/TimeGallery/res/photo/galleryOfHer08.jpg" width="550px">
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