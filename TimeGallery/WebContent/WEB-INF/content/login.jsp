<%@ page import="com.baozijuan.timegallery.action.base.WebConstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
<style type="text/css">
	body {
		background-image: url(/TimeGallery/res/img/loginbg.jpg);
		background-size: 100%;
		background-repeat: no-repeat;
		background-attachment: fixed;
		color: #fff;
	}
	a {
		color: #aaa;
	}
	.btn-primary {
		background: rgba(51, 122, 183, 0.15);
	}
	.btn-default {
		background: rgba(100, 100, 100, 0.15);
		color: #fff;
	}
	.form-control {
		background: rgba(100, 100, 100, 0.15);
		color: #fff;
	}
	.jumbotron {
		background: rgba(100, 100, 100, 0.15);
	}
	.modal-header > button {
		color: #fff;
	}
	.modal-content {
		background: rgba(35, 35, 35, 0.15);
		color: #fff;
	}
</style>
</head>
<body>
	<header><%@ include file="headerOut.jsp"%></header>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h3 class="text-center">Sign in with your e-mail account</h3>
				<hr>
				<form class="form-horizontal" id="loginForm" method="post" action="login">
					<div class="form-group">
						<label for="signEmail" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="signEmail" placeholder="Email" name="user.account">
						</div>
					</div>
					<div class="form-group">
						<label for="signPassword" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="signPassword" placeholder="Password" name="user.password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<a href="/TimeGallery/forgetPassword">Forget password?</a>
						</div>
					</div>
					<!--<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label><input type="checkbox"> Remember me</label>
							</div>
						</div>
					</div>-->
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary">Sign in</button>
							<button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">Register</button>
							<label style="color: red;">&nbsp;
								<s:if test="#session.intercept != null">${sessionScope.intercept}</s:if>
								<%session.setAttribute(WebConstant.INTERCEPT, null);%>
							</label>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-6">
				<div class="jumbotron" style="padding: 35px;">
					<h1>Welcome!</h1>
					<p>This site is designed for personal purpose, recording the time we spent together and the stories we created together.</p>
					<p>
						<a href="/TimeGallery/about#about" class="btn btn-primary btn-large" target="_blank">Learn more »</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron" style="padding: 10px; margin-bottom: 0;">
					<div id="carousel-generic" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators" style="bottom: 5px;">
							<li data-target="#carousel-generic" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-generic" data-slide-to="1"></li>
							<li data-target="#carousel-generic" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img alt="index01" src="${pageContext.request.contextPath}/res/photo/login01.jpg">
							</div>
							<div class="item">
								<img alt="index02" src="${pageContext.request.contextPath}/res/photo/login02.jpg">
							</div>
							<div class="item">
								<img alt="index03" src="${pageContext.request.contextPath}/res/photo/login03.jpg">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer><%@ include file="footer.jsp"%></footer>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form class="form-horizontal" id="registForm" method="post" action="register">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Register</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-10">
								<span class="glyphicon glyphicon-user">&nbsp;</span> Account Information (Required)
							</label>
						</div>
						<div class="form-group" id="emailGroup">
							<label for="registEmail" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-8">
								<input type="email" class="form-control" id="registEmail" placeholder="Email" name="user.account" required="required">
							</div>
						</div>
						<div class="form-group" id="passGroup">
							<label for="registPassword" class="col-sm-2 control-label">Password</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="registPassword" placeholder="Password" name="user.password" required="required">
							</div>
						</div>
						<div class="form-group" id="passConfirmGroup">
							<label for="confirmPassword" class="col-sm-2 control-label">Confirm</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-10">
								<span class="glyphicon glyphicon-book">&nbsp;</span> Personal Information (Not Required)
							</label>
						</div>
						<div class="form-group">
							<label for="registNameF" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="registNameF" placeholder="Family Name" name="user.familyName">
							</div>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="registNameG" placeholder="Given Name" name="user.givenName">
							</div>
						</div>
						<div class="form-group">
							<label for="registNick" class="col-sm-2 control-label">Nickname</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="registNick" placeholder="Nickname" name="user.nickname">
							</div>
						</div>
						<div class="form-group">
							<label for="registGenderM" class="col-sm-2 control-label">Gender</label>
							<div class="col-sm-8">
								<label class="radio-inline">
									<input type="radio" id="registGenderM" name="user.gender" value="Male"> Male
								</label>
								<label class="radio-inline">
									<input type="radio" id="registGenderF" name="user.gender" value="Female"> Female
								</label>
								<label class="radio-inline">
									<input type="radio" id="registGenderO" name="user.gender" value="Other" checked="checked"> Other
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="registDoB" class="col-sm-2 control-label">DoB</label>
							<div class="col-sm-8">
								<input type="date" class="form-control" id="registDoB" placeholder="Date of Birth - format : mm / dd / yyyy" name="user.dob">
							</div>
						</div>
						<div class="form-group">
							<label for="registPhone" class="col-sm-2 control-label">Phone</label>
							<div class="col-sm-8">
								<input type="tel" class="form-control" id="registPhone" placeholder="Contact Phone Number" name="user.phone">
							</div>
						</div>
						<div class="form-group">
							<label for="registAddress" class="col-sm-2 control-label">Address</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="registAddress" placeholder="Address" name="user.address">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label>
										<input type="checkbox" required="required" id="agreement"> I agree to this site's
										<a href="/TimeGallery/about#terms" target="_blank">Terms of Use</a> and 
										<a href="/TimeGallery/about#policy" target="_blank">Privacy Policy</a>
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="reset" id="resetBtn" value="reset" class="btn btn-default">Reset</button>
						<button type="submit" id="submitBtn" value="submit" class="btn btn-primary" disabled="disabled">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#myModal").on("show.bs.modal", function(e) {
			$(".container").attr("style", "filter: blur(15px);");
		});
		$("#myModal").on("hidden.bs.modal", function(e) {
			$(".container").removeAttr("style");
		});
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.md5.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/login.js"></script>
</body>
</html>