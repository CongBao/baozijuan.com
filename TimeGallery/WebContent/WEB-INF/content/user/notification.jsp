<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Notifications</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
</head>
<body>
	<header><%@ include file="../headerIn.jsp"%></header>
	<div class="container" style="margin-top: 3.7em;">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>Notifications</h1>
				</div>
				<div class="col-md-3">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">Filter</h3>
						</div>
						<div class="panel-body">
							<ul class="nav nav-pills nav-stacked" role="tablist">
								<li role="presentation" class="active">
									<a href="#combine" aria-controls="combine" role="tab" data-toggle="pill" class="text-muted">
										<span class="glyphicon glyphicon-stop"></span>&nbsp;&nbsp;&nbsp;Combine View
									</a>
								</li>
								<li role="presentation">
									<a href="#system" aria-controls="system" role="tab" data-toggle="pill" class="text-success">
										<span class="glyphicon glyphicon-stop"></span>&nbsp;&nbsp;&nbsp;From System
									</a>
								</li>
								<li role="presentation">
									<a href="#user" aria-controls="user" role="tab" data-toggle="pill" class="text-info">
										<span class="glyphicon glyphicon-stop"></span>&nbsp;&nbsp;&nbsp;From User
									</a>
								</li>
								<li role="presentation">
									<a href="#other" aria-controls="other" role="tab" data-toggle="pill" class="text-warning">
										<span class="glyphicon glyphicon-stop"></span>&nbsp;&nbsp;&nbsp;From Other Source
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-9">
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="combine">
						
						<!-- Reserve for further development -->
						<!-- This is just an example -->
						
							<div class="panel-group" id="combineGroup" role="tablist" aria-multiselectable="true">
								<div class="panel panel-success">
									<div class="panel-heading" role="tab" id="msg01headC">
										<h3 class="panel-title">
											<a role="button" data-toggle="collapse" data-parent="#combineGroup" href="#msg01textC" aria-expanded="false" aria-controls="msg01textC">
												Welcome!
											</a>
											<i class="pull-right">from System on ${sessionScope.user.createdDate}</i>
										</h3>
									</div>
									<div id="msg01textC" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="msg01headC">
										<div class="panel-body">
											<p>Welcome to baozijuan.com!</p>
											<p>Time Gallery is a sub site of baozijuan.com, aiming to record our daily life and share them with our friends.
											In this site, you can view photos of us, download softwares that developed by me, and chat with other users, building your own homepage and sharing your stories with friends.
											You may think that this site is just designed to show affection. Yeah, I cannot deny it, but it is just one of the reasons.
											I hope this site could attract you to share your own stories with others, and also hope you to discuss techniques with me.</p>
											<p>To protect privacy and let my efforts pay off, I design an authority system to control your actions. Details can be found in your profile page.
											This site is still under developing. Many functions are reserved for future building but you cannot access now.
											As the only developer of this site, I'm glad to receive your suggestions or ideas about this site.
											It will be kind if you would like to exchange your knowledges of web developing with me.</p>
											<p>Hope you have a good time in my site.</p>
											<p>12th Sep 2016</p>
											<p>Bao Cong</p>
										</div>
									</div>
								</div>
							</div>
							<div class="panel-group" id="combineGroup" role="tablist" aria-multiselectable="true">
								<div class="panel panel-success">
									<div class="panel-heading" role="tab" id="msg02headC">
										<h3 class="panel-title">
											<a role="button" data-toggle="collapse" data-parent="#combineGroup" href="#msg02textC" aria-expanded="false" aria-controls="msg02textC">
												Happy New Year!
											</a>
											<i class="pull-right">from System on 2017-1-1</i>
										</h3>
									</div>
									<div id="msg02textC" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="msg02headC">
										<div class="panel-body">
											<p>Wish you a happy new year!</p>
											<p>Glad to see you again. This site updated after almost half a year, finally, because I'm so busy (lazy?)...
											There is a good news that since September of 2016, this site has been deployed on a server in London,
											which means it will run 24h a day and 7d a week until I don't have money to maintain the server...
											(Actually the server is a student benefit from GitHub.)</p>
											<p>Today is the first anniversary of my GF and me. So very happy you can visit my site to eat some dog food (I'm sorry if I put too much).
											I also release my fourth self-designed game - Journey of Adam. It is a puzzle game telling the story of a robot boy.
											Though it is just a demo and very short, hoping you could like it. This game is a first anniversary work, so... you know.
											I uploaded my past works on the site. If you are interested in them, you can download them and have a look.</p>
											<p>No one know when will I update this site next time, but everyone know that you will have a good luck this year.</p>
											<p>Best wishes.</p>
											<p>1st Jan 2017</p>
											<p>Bao Cong</p>
										</div>
									</div>
								</div>
							</div>
							
						</div>
						<div role="tabpanel" class="tab-pane" id="system">
						
							<div class="panel-group" id="systemGroup" role="tablist" aria-multiselectable="true">
								<div class="panel panel-success">
									<div class="panel-heading" role="tab" id="msg01headS">
										<h3 class="panel-title">
											<a role="button" data-toggle="collapse" data-parent="#systemGroup" href="#msg01textS" aria-expanded="false" aria-controls="msg01textS">
												Welcome!
											</a>
											<i class="pull-right">from System on ${sessionScope.user.createdDate}</i>
										</h3>
									</div>
									<div id="msg01textS" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="msg01headS">
										<div class="panel-body">
											<p>Welcome to baozijuan.com!</p>
											<p>Time Gallery is a sub site of baozijuan.com, aiming to record our daily life and share them with our friends.
											In this site, you can view photos of us, download softwares that developed by me, and chat with other users, building your own homepage and sharing your stories with friends.
											You may think that this site is just designed to show affection. Yeah, I cannot deny it, but it is just one of the reasons.
											I hope this site could attract you to share your own stories with others, and also hope you to discuss techniques with me.</p>
											<p>To protect privacy and let my efforts pay off, I design an authority system to control your actions. Details can be found in your profile page.
											This site is still under developing. Many functions are reserved for future building but you cannot access now.
											As the only developer of this site, I'm glad to receive your suggestions or ideas about this site.
											It will be kind if you would like to exchange your knowledges of web developing with me.</p>
											<p>Hope you have a good time in my site.</p>
											<p>12th Sep 2016</p>
											<p>Bao Cong</p>
										</div>
									</div>
								</div>
							</div>
							<div class="panel-group" id="combineGroup" role="tablist" aria-multiselectable="true">
								<div class="panel panel-success">
									<div class="panel-heading" role="tab" id="msg02headS">
										<h3 class="panel-title">
											<a role="button" data-toggle="collapse" data-parent="#combineGroup" href="#msg02textS" aria-expanded="false" aria-controls="msg02textS">
												Happy New Year!
											</a>
											<i class="pull-right">from System on 2017-1-1</i>
										</h3>
									</div>
									<div id="msg02textS" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="msg02headS">
										<div class="panel-body">
											<p>Wish you a happy new year!</p>
											<p>Glad to see you again. This site updated after almost half a year, finally, because I'm so busy (lazy?)...
											There is a good news that since September of 2016, this site has been deployed on a server in London,
											which means it will run 24h a day and 7d a week until I don't have money to maintain the server...
											(Actually the server is a student benefit from GitHub.)</p>
											<p>Today is the first anniversary of my GF and me. So very happy you can visit my site to eat some dog food (I'm sorry if I put too much).
											I also release my fourth self-designed game - Journey of Adam. It is a puzzle game telling the story of a robot boy.
											Though it is just a demo and very short, hoping you could like it. This game is a first anniversary work, so... you know.
											I uploaded my past works on the site. If you are interested in them, you can download them and have a look.</p>
											<p>No one know when will I update this site next time, but everyone know that you will have a good luck this year.</p>
											<p>Best wishes.</p>
											<p>1st Jan 2017</p>
											<p>Bao Cong</p>
										</div>
									</div>
								</div>
							</div>
							
						</div>
						<div role="tabpanel" class="tab-pane" id="user">
							<div class="panel panel-info">
								<div class="panel-body">No Notification</div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="other">
							<div class="panel panel-warning">
								<div class="panel-body">No Notification</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer><%@ include file="../footer.jsp"%></footer>
</body>
</html>