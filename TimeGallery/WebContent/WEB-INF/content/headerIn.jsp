<%@ taglib prefix="s" uri="/struts-tags"%>
<nav id="webnav" class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button"
					class="navbar-toggle collapsed"
					data-toggle="collapse"
					data-target="#bs-navbar-collapse"
					aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/TimeGallery/index">Time Gallery</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/TimeGallery/index"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;&nbsp;Home</a></li>
				<li><a href="/TimeGallery/photo/index"><span class="glyphicon glyphicon-picture"></span>&nbsp;&nbsp;&nbsp;Photo</a></li>
				<li><a href="/TimeGallery/software/index"><span class="glyphicon glyphicon-download-alt"></span>&nbsp;&nbsp;&nbsp;Software</a></li>
				<li><a href="/TimeGallery/chat/index"><span class="glyphicon glyphicon-comment"></span>&nbsp;&nbsp;&nbsp;Chat</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<p class="navbar-text">Welcome, 
						<s:if test="#session.user.nickname != ''">${sessionScope.user.nickname}</s:if>
						<s:else>${sessionScope.user.givenName}</s:else>
					</p>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						<span class="glyphicon glyphicon-user"></span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li class="dropdown-header">Signed in as <b>${sessionScope.user.account}</b></li>
						<li class="dropdown-header">Last signed on ${sessionScope.user.lastLoginDate}</li>
						<li role="separator" class="divider"></li>
						<li><a href="/TimeGallery/user/notification"><span class="glyphicon glyphicon-bell"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Read Notifications</a></li>
						<li><a href="/TimeGallery/user/profile"><span class="glyphicon glyphicon-book"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;View Your Profile</a></li>
						<li><a href="/TimeGallery/user/system"><span class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System Settings</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="/TimeGallery/logout" style="color: #F00; font-weight: bold;"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sign Out</a></li>
					</ul>
				</li>
				<li>
					<form class="navbar-form" action="">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search in website">
						</div>
						<button type="submit" class="btn btn-default" id="searchBtn"><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;&nbsp;Search</button>
					</form>
				</li>
			</ul>
		</div>
	</div>
</nav>
<script type="text/javascript">
	$("#searchBtn").click(function() {
		alert("This function is unavailable now.");
	});
</script>