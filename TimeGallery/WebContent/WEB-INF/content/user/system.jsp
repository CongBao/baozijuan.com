<%@ page import="com.baozijuan.timegallery.action.base.WebConstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>System Settings</title>
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
					<h1>System Settings</h1>
				</div>
				<div class="col-md-3">
					<ul class="nav nav-pills nav-stacked" role="tablist">
						<li role="presentation" class="active">
							<a href="#account" aria-controls="account" role="tab" data-toggle="pill">
								<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;Account
							</a>
						</li>
						<li role="presentation">
							<a href="#notification" aria-controls="notification" role="tab" data-toggle="pill">
								<span class="glyphicon glyphicon-bell"></span>&nbsp;&nbsp;&nbsp;Notification
							</a>
						</li>
						<li role="presentation">
							<a href="#email" aria-controls="email" role="tab" data-toggle="pill">
								<span class="glyphicon glyphicon-envelope"></span>&nbsp;&nbsp;&nbsp;Email
							</a>
						</li>
					</ul>
				</div>
				<div class="col-md-9">
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="account">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Change Account</h3>
								</div>
								<div class="panel-body">
									<form method="post" action="editAccount">
										<input type="hidden" name="account" value="${sessionScope.user.account}">
										<div class="form-group">
											<label for="oldAccount">Current Account</label>
											<input type="text" class="form-control" id="oldAccount" placeholder="${sessionScope.user.account}" readonly="readonly">
										</div>
										<div class="form-group" id="accountGroup">
											<label for="editAccount">New Account</label>
											<input type="text" class="form-control" id="editAccount" placeholder="New account" name="newAccount">
										</div>
										<div style="font-style: italic;">
											<label>Note</label>
											<p>After changing your account, the old one will not exist so you cannot login with your old account any more.
											   You should verify your new account by yourself in the profile page.</p>
										</div>
										<div class="form-group text-right">
											<label style="color: red;">
												<s:if test="#session.intercept_1 != null">${sessionScope.intercept_1}</s:if>
												<%session.setAttribute(WebConstant.INTERCEPT_1, null);%>&nbsp;
											</label>
											<button type="reset" id="resetAccount" value="reset" class="btn btn-default">Reset</button>
											<button type="submit" id="submitAccount" value="submit" class="btn btn-primary" disabled="disabled">Submit</button>
										</div>
									</form>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Change password</h3>
								</div>
								<div class="panel-body">
									<form method="post" action="editPassword">
										<input type="hidden" name="account" value="${sessionScope.user.account}">
										<div class="form-group">
											<label for="oldPassword">Current Password</label>
											<input type="password" class="form-control" id="oldPassword" placeholder="Current Password" name="oldPassword">
										</div>
										<div class="form-group" id="passGroup">
											<label for="editPassword">New Password</label>
											<input type="password" class="form-control" id="editPassword" placeholder="New Password" name="newPassword">
										</div>
										<div class="form-group" id="passConfirmGroup">
											<label for="confirmPassword">Confirm New Password</label>
											<input type="password" class="form-control" id="confirmPassword" placeholder="Confirm New Password">
										</div>
										<div class="form-group text-right">
											<label style="color: red;">
												<s:if test="#session.intercept_2 != null">${sessionScope.intercept_2}</s:if>
												<%session.setAttribute(WebConstant.INTERCEPT_2, null);%>&nbsp;
											</label>
											<button type="reset" id="resetPassword" value="reset" class="btn btn-default">Reset</button>
											<button type="submit" id="submitPassword" value="submit" class="btn btn-primary" disabled="disabled">Submit</button>
										</div>
									</form>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title" style="color: #D9534F">Delete Account</h3>
								</div>
								<div class="panel-body">
									<form method="post" action="deleteAccount">
										<input type="hidden" name="account" value="${sessionScope.user.account}">
										<label>Confirm</label>
										<div class="checkbox">
											<label><input type="checkbox" id="agreement">I'm sure I want to delete my account.</label>
										</div>
										<div style="font-style: italic;">
											<label>Note</label>
											<p>Once you delete your account, there is no going back. Please be certain.</p>
										</div>
										<button type="submit" id="deleteAccount" value="delete" class="btn btn-danger btn-lg btn-block" disabled="disabled">Delete Account</button>
									</form>
								</div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="notification">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Notification Setting</h3>
								</div>
								<div class="panel-body">Unavailable Now</div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="email">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Email Setting</h3>
								</div>
								<div class="panel-body">Unavailable Now</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer><%@ include file="../footer.jsp"%></footer>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/system.js"></script>
</body>
</html>