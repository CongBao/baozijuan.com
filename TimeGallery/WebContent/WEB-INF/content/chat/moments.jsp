<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Moments</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
<style type="text/css">
	body {
		background-image: url(/TimeGallery/res/img/momentsbg.jpg);
		background-size: 100%;
		background-repeat: no-repeat;
		background-attachment: fixed;
		color: #fff;
	}
	a {
		color: #fff;
	}
	#hoverBtn {
		position: fixed;
	    right: 10%;
	    display: none;
	}
	#hoverBtn .upBtn {
		margin: 5px;
	}
	#hoverBtn .downBtn {
		margin: 5px;
	}
	.nav.nav-tabs.nav-justified > li > a {
		font-size: 1.5em;
		font-weight: bold;
	}
	.panel-title {
		font-style: italic;
		font-size: 1.5em;
	}
	.panel {
		background: rgba(255, 255, 255, 0.5);
	}
	.panel-body {
		color: #000;
	}
	.panel-body > p {
		font-size: 1.5em;
	}
</style>
</head>
<body>
	<header><%@ include file="../headerIn.jsp"%></header>
	<div class="container" style="margin-top: 3.7em;">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						Moments
						<a href="/TimeGallery/chat/index" class="btn btn-default pull-right">Return to index</a>
					</h1>
				</div>
				<div class="col-md-12">
					<ul class="nav nav-tabs nav-justified">
						<li role="presentation" class="active"><a href="#diaries" aria-controls="diaries" role="tab" data-toggle="tab">Her Diaries</a></li>
						<li role="presentation"><a href="#graphs" aria-controls="graphs" role="tab" data-toggle="tab">His Drawings</a></li>
						<li role="presentation"><a href="#sharings" aria-controls="sharings" role="tab" data-toggle="tab">Your Moments</a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="diaries">
							<br>
							<%@ include file="moments_diaries.jsp"%>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="graphs">
							<br>
							<%@ include file="moments_graphs.jsp"%>
							<!-- javascript -->
						</div>
						<div role="tabpanel" class="tab-pane fade" id="sharings">
							<br>
							<%@ include file="moments_sharings.jsp"%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer><%@ include file="../footer.jsp"%></footer>
	<div id="hoverBtn">
		<button class="upBtn btn btn-default btn-lg">
			<span class="glyphicon  glyphicon glyphicon-chevron-up"></span>
		</button>
		<br>
		<button class="downBtn btn btn-default btn-lg">
			<span class="glyphicon  glyphicon  glyphicon glyphicon-chevron-down"></span>
		</button>
	</div>
	<script type="text/javascript">
		var graphsNum = 89;
		$(function() {
			for (var i = 0; i < graphsNum; i++) {
				$("#graphs").append(
						"<div class='panel panel-default'>" +
						"<div class='panel-body'>" +
						"<div class='media' id='graph" + (i + 1) + "'>" +
						"<div class='media-left'>" +
						"<img class='media-object' alt='graph " + (i + 1) + "' src='/TimeGallery/res/photo/graphs/graph" + (i + 1) + ".jpg'>" +
						"</div>" +
						"<div class='media-body'>" +
						"<h4 class='media-heading'>" +
						"No. " + (i + 1) +
						"</h4>" +
						"</div>" +
						"</div>" +
						"</div>" +
						"</div>");
			}
			$("#graph1 > .media-body").append("<p>The stories are coming soon.</p>");
		});
		$(function() {
			$("#hoverBtn").css("top", window.screen.availHeight / 2 - 100 + "px");
			$(window).scroll(function() {
				if($(window).scrollTop() >= 100){
					$("#hoverBtn").fadeIn(300);
				} else {
					$("#hoverBtn").fadeOut(300);
				}
			});
			$("#hoverBtn .upBtn").click(function() {
				$("html, body").animate({scrollTop: "0px"}, 800);
			});
			$("#hoverBtn .downBtn").click(function() {
				$("html, body").animate({scrollTop: document.body.clientHeight + "px"}, 800);
			});
		});
	</script>
</body>
</html>