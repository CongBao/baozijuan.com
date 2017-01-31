<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gallery of Us</title>
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
						Gallery of Us
						<a href="/TimeGallery/photo/index" class="btn btn-default pull-right">Return to index</a>
					</h1>
				</div>
				<div id="timeline">
					<div class="col-md-4">
						<ul id="dates">
							<li><a href="#t1">Apr. Wuhan</a></li>
							<li><a href="#t2">Jul. Suzhou</a></li>
							<li><a href="#t3">Aug. Shanghai</a></li>
							<li><a href="#t4">Aug. Changshu</a></li>
						</ul>
					</div>
					<div class="col-md-8">
						<ul id="issues">
							<li id="t1">
								<h1>April in Wuhan</h1>
								<div class="col-md-6">
									<p>At the beginning of April, which was the mid-term exam week of him, he traveled to Wuhan and spent four days with her.
										We traveled to Mo Hill in east lake, having lunch at Tanhualin road, and strolled on Yangtze River Bridge.
										When she attended the class, he waited under their teaching building to bring her back.</p>
								</div>
								<div class="col-md-6">
									<img alt="us01" src="/TimeGallery/res/photo/galleryOfUs01.jpg" width="230px">
								</div>
							</li>
							<li id="t2">
								<h1>July in Suzhou</h1>
								<p>She came back to Suzhou at the end of July.
									We traveled with two other friends from University of Wuhan in the three days.
									Ferris wheel and Eslite Bookstore were included.</p>
								<img alt="us02" src="/TimeGallery/res/photo/galleryOfUs02.jpg" width="500px">
							</li>
							<li id="t3">
								<h1>August in Shanghai</h1>
								<div class="col-md-6">
									<img alt="us03" src="/TimeGallery/res/photo/galleryOfUs03.jpg" width="270px">
								</div>
								<div class="col-md-6">
									<p>We spent four days in Shanghai at the beginning of August.
										The most famous attractions, such as Ocean Aquarium, Science and Technology Museum, and Nanjing Road, leaved our tracks.
										Delicious ice-cream in IKEA, and impressive time in skating rink.</p>
								</div>
							</li>
							<li id="t4">
								<h1>August in Changshu</h1>
								<p>It came to the end of August.
									We traveled in our hometown, watching the sunset in Kuncheng lake.
									Nothing have to do, just waiting for the star.</p>
								<img alt="us04" src="/TimeGallery/res/photo/galleryOfUs04.jpg" width="550px">
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