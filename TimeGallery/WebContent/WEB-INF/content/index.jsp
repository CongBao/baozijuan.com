<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Time Gallery</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/TweenLite.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/EasePack.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/rAF.js"></script>
<style type="text/css">
	body {
		background-image: url(/TimeGallery/res/img/clock.jpg);
		background-size: 100%;
		background-repeat: no-repeat;
		background-attachment: fixed;
	}
	footer {
		background: #eee;
		border-radius: 6px 6px 0 0;
	}
	.main-header {
		position: relative;
		width: 100%;
		background: #333;
		overflow: hidden;
		background-size: cover;
		background-position: center center;
		z-index: 1;
		background-image: url('/TimeGallery/res/img/indexbg.jpg');
	}
	.main-title{
		position: absolute;
		margin: 0;
		padding: 0;
		color: #f9f1e9;
		text-align: center;
		top: 50%;
		left: 50%;
		-webkit-transform: translate3d(-50%,-50%,0);
		transform: translate3d(-50%,-50%,0);
		text-transform: uppercase;
		font-size: 6em;
		letter-spacing: 0.1em;
	}
	.time {
		margin: 13em 0 13em 0;
		color: #fff;
		text-shadow: 2px 2px 2px #000;
	}
	#time {
		font-size: 12em;
	}
	.carousel-caption > h3 {
		font-size: 3em;
	}
	.caption > p {
		text-align: left;
	}
</style>
</head>
<body>
	<header><%@ include file="headerIn.jsp"%></header>
	<div class="container-fluid">
		<div class="row">
			<div id="main-header" class="main-header">
				<canvas id="index-canvas"></canvas>
				<h1 class="main-title">Time Gallery</h1>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 text-center time">
				<h1 style="font-size: 6em;">We have been together for</h1>
				<h1 id="time"></h1>
				<h1>Time passes, second by second.</h1>
				<h1>We collect the best, in our gallery.</h1>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="jumbotron" style="padding: 10px;">
				<div id="carousel-generic" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carousel-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-generic" data-slide-to="1"></li>
						<li data-target="#carousel-generic" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img alt="index01" src="${pageContext.request.contextPath}/res/photo/index01.jpg">
							<div class="carousel-caption">
								<h3>Changshu Kuncheng Lake</h3>
								<p>Farewell to sunset, waiting for the bright of star.</p>
							</div>
						</div>
						<div class="item">
							<img alt="index02" src="${pageContext.request.contextPath}/res/photo/index02.jpg">
							<div class="carousel-caption">
								<h3>Shanghai Ocean Aquarium</h3>
								<p>Missing in the deep dark. Heart illuminated by week light.</p>
							</div>
						</div>
						<div class="item">
							<img alt="index03" src="${pageContext.request.contextPath}/res/photo/index03.jpg">
							<div class="carousel-caption">
								<h3>Soochow University</h3>
								<p>Meeting in the early summer. Green covers the old house.</p>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="jumbotron text-center">
				<h1>Welcome to our world!</h1>
				<h2>We record our life here. And now share them with you.</h2>
			</div>
			<div class="jumbotron text-center">
				<h1>What you can find from this site...</h1>
				<br>
				<div class="row">
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img alt="photo" src="/TimeGallery/res/photo/index04.png">
							<div class="caption">
								<h1>Photo</h1>
								<p>We collect our photos here. Record the dates and places. Remain the stories and happiness. Along the timeline, from origin, to forever.</p>
								<p><a href="/TimeGallery/photo/index" class="btn btn-primary btn-lg btn-block" role="button">Learn more</a></p>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img alt="photo" src="/TimeGallery/res/photo/index05.png">
							<div class="caption">
								<h1>Software</h1>
								<p>He developed some softwares in free time, including games and utilities. Much more apps will be released soon, for you and your love.</p>
								<p><a href="/TimeGallery/software/index" class="btn btn-primary btn-lg btn-block" role="button">Learn more</a></p>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img alt="photo" src="/TimeGallery/res/photo/index06.png">
							<div class="caption">
								<h1>Chat</h1>
								<p>She recorded their stories in diary, sharing the sweet time and amusing moment. Now you can join in, and share everything you like.</p>
								<p><a href="/TimeGallery/chat/index" class="btn btn-primary btn-lg btn-block" role="button">Learn more</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="jumbotron">
				<h2>If you have any question or suggestion, please contact me.</h2>
				<div class="row">
					<div class="col-md-6">
						<h2>Contact me via email</h2>
						<div class="media">
		  					<div class="media-left">
		  						<a href="mailto:bcbao1996@gmail.com"><img class="media-object" alt="Gmail" src="/TimeGallery/res/img/logo01.png"></a>
		  					</div>
		  					<div class="media-body">
		  						<h3 class="media-heading">Gmail</h3>
		  						<p>bcbao1996@gmail.com</p>
		  					</div>
		  				</div>
		  				<div class="media">
		  					<div class="media-left">
		  						<a href="mailto:bao_cong@outlook.com"><img class="media-object" alt="Outlook" src="/TimeGallery/res/img/logo02.png"></a>
		  					</div>
		  					<div class="media-body">
		  						<h3 class="media-heading">Outlook</h3>
		  						<p>bao_cong@outlook.com</p>
		  					</div>
		  				</div>
		  				<div class="media">
		  					<div class="media-left">
		  						<a href="mailto:bao_cong@126.com"><img class="media-object" alt="NetEase" src="/TimeGallery/res/img/logo03.png"></a>
		  					</div>
		  					<div class="media-body">
		  						<h3 class="media-heading">NetEase</h3>
		  						<p>bao_cong@126.com</p>
		  					</div>
		  				</div>
		  			</div>
		  			<div class="col-md-6">
		  				<h2>Follow me via media</h2>
		  				<div class="media">
		  					<div class="media-left">
		  						<a href="http://www.google.com"><img class="media-object" alt="Google+" src="/TimeGallery/res/img/logo04.png"></a>
		  					</div>
		  					<div class="media-body">
		  						<h3 class="media-heading">Google+</h3>
		  						<p>bcbao1996@gmail.com</p>
		  					</div>
		  				</div>
		  				<div class="media">
		  					<div class="media-left">
		  						<a href="http://www.twitter.com"><img class="media-object" alt="Twitter" src="/TimeGallery/res/img/logo05.png"></a>
		  					</div>
		  					<div class="media-body">
		  						<h3 class="media-heading">Twitter</h3>
		  						<p>@baocong96</p>
		  					</div>
		  				</div>
		  				<div class="media">
		  					<div class="media-left">
		  						<a href="http://www.facebook.com"><img class="media-object" alt="Facebook" src="/TimeGallery/res/img/logo06.png"></a>
		  					</div>
		  					<div class="media-body">
		  						<h3 class="media-heading">Facebook</h3>
		  						<p>bao_cong@outlook.com</p>
		  					</div>
		  				</div>
		  			</div>
		  		</div>
			</div>
		</div>
	</div>
	<footer><%@ include file="footer.jsp"%></footer>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/star.js"></script>
	<script type="text/javascript">
	var start = new Date(2015, 11, 31, 19, 0, 0); // actually 2015,12,31
	function showTime() {
	    var date = new Date();
	    var delta = date.getTime() - start.getTime();
	    $("#time").html(function () {
			var ss = 1000;
			var mm = ss * 60;
			var HH = mm * 60;
			var dd = HH * 24;

			var day = Math.floor(delta / dd);
			var hour = Math.floor((delta - day * dd) / HH);
			var min = Math.floor((delta - day * dd - hour * HH) / mm);
			var sec = Math.floor((delta - day * dd - hour * HH - min * mm) / ss);

			return day + " d "
			+ (hour < 10 ? "0" + hour : hour) + " h "
			+ (min < 10 ? "0" + min : min) + " m "
			+ (sec < 10 ? "0" + sec : sec) + " s";
		});
	    /*$("#time").html((date.getHours() < 10 ? "0" + date.getHours() : date.getHours())
                + ":"
                + (date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes())
                + ":"
                + (date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds()));*/
	    setTimeout("showTime()", 1000);
	}
	$(function(){
	    showTime();
	})
	</script>
</body>
</html>