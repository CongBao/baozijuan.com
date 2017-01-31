<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>View Profile</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
<style type="text/css">
	th, td {
		text-align: center;
		vertical-align: middle !important;
	}
	
	.glyphicon-ok {
		color: #0F0;
	}
	
	.glyphicon-remove {
		color: #F00;
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
						<s:if test="#session.user.nickname != ''">${sessionScope.user.nickname}</s:if>
						<s:else>${sessionScope.user.givenName} ${sessionScope.user.familyName}</s:else>
						<small>${sessionScope.user.signature}</small>
						<a href="/TimeGallery/user/edit" class="btn btn-default pull-right"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;Edit Profile</a>
					</h1>
				</div>
				<div>
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#account" aria-controls="account" role="tab" data-toggle="tab">Account Info</a></li>
						<li role="presentation"><a href="#personal" aria-controls="personal" role="tab" data-toggle="tab">Personal Info</a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="account">
							<div class="col-md-6">
								<table class="table table-hover">
									<thead>
										<tr><td colspan="2"><h4>Account Details</h4></td></tr>
									</thead>
									<tbody>
										<tr>
											<th>Unique ID Number</th>
											<td>${sessionScope.user.id}</td>
										</tr>
										<tr>
											<th>Email Account</th>
											<td>${sessionScope.user.account}</td>
										</tr>
										<tr>
											<th>Email Verification State</th>
											<td>
												<s:if test="#session.user.mailVerified">Verified</s:if>
												<s:else>
													Not Verified
													<a id="mail_verify" href="/TimeGallery/user/verifyReq?account=${sessionScope.user.account}" class="btn btn-default btn-xs">Verify Now</a>
												</s:else>
											</td>
										</tr>
										<tr>
											<th>Account Created Date</th>
											<td>${sessionScope.user.createdDate}</td>
										</tr>
									</tbody>
									<tfoot>
										<tr><td colspan="2" class="text-right"><i>* Last updated on ${sessionScope.user.updatedDate}</i></td></tr>
									</tfoot>
								</table>
							</div>
							<div class="col-md-6">
								<table class="table table-hover">
									<thead>
										<tr><td colspan="2"><h4>Authority Details</h4></td></tr>
									</thead>
									<tbody>
										<tr>
											<th>Authority Level</th>
											<td>Level ${sessionScope.authority.id}</td>
										</tr>
										<tr>
											<th>Experience</th>
											<td>
												<div class="progress" style="margin-bottom: 0;">
													<div class="progress-bar"
														 id = "exp_progress"
														 role="progressbar"
														 aria-valuenow="${sessionScope.user.exp}"
														 aria-valuemin="0"
														 aria-valuemax="${sessionScope.authority.maxExp}">
														 ${sessionScope.user.exp} / ${sessionScope.authority.maxExp}
													</div>
												</div>
											</td>
										</tr>
									</tbody>
									<tfoot>
										<tr><td colspan="2">
											<button class="btn btn-default btn-block"
													type="button"
													data-toggle="modal"
													data-target="#authorityModal">
													Click to see details of authorities in each level
											</button>
										</td></tr>
									</tfoot>
								</table>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="personal">
							<div class="col-md-6">
								<table class="table table-hover">
									<thead>
										<tr><td colspan="2"><h4>Personal Information</h4></td></tr>
									</thead>
									<tbody>
										<tr>
											<th>Nickname</th>
											<td>
												<s:if test="#session.user.nickname != ''">${sessionScope.user.nickname}</s:if>
												<s:else>No Data</s:else>
											</td>
										</tr>
										<tr>
											<th>Family Name</th>
											<td>
												<s:if test="#session.user.familyName != ''">${sessionScope.user.familyName}</s:if>
												<s:else>No Data</s:else>
											</td>
										</tr>
										<tr>
											<th>Given Name</th>
											<td>
												<s:if test="#session.user.givenName != ''">${sessionScope.user.givenName}</s:if>
												<s:else>No Data</s:else>
											</td>
										</tr>
										<tr>
											<th>Gender</th>
											<td>
												${sessionScope.user.gender}
											</td>
										</tr>
										<tr>
											<th>Date of Birth</th>
											<td>
												<s:if test="#session.user.dob != ''">${sessionScope.user.dob}</s:if>
												<s:else>No Data</s:else>
											</td>
										</tr>
										<tr>
											<th>Contact Phone</th>
											<td>
												<s:if test="#session.user.phone != ''">${sessionScope.user.phone}</s:if>
												<s:else>No Data</s:else>
											</td>
										</tr>
										<tr>
											<th>Address</th>
											<td>
												<s:if test="#session.user.address != ''">${sessionScope.user.address}</s:if>
												<s:else>No Data</s:else>
											</td>
										</tr>
									</tbody>
									<tfoot>
										<tr><td colspan="2" class="text-right"><i>* Last updated on ${sessionScope.user.updatedDate}</i></td></tr>
									</tfoot>
								</table>
							</div>
							<div class="col-md-6">
								<table class="table">
									<thead>
										<tr><td><h4>Self Description</h4></td></tr>
									</thead>
									<tbody>
										<tr><td>
											<div class="well well-lg">${sessionScope.user.description}</div>
										</td></tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer><%@ include file="../footer.jsp"%></footer>
	<!-- Modal -->
	<div class="modal fade" id="authorityModal" tabindex="-1" role="dialog" aria-labelledby="authorityModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="authorityModalLabel">Authority Details</h4>
				</div>
				<div class="modal-body">
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<th rowspan="2">Level</th>
								<th colspan="3">Permission in each zone</th>
								<th rowspan="2">Exp to next level</th>
							</tr>
							<tr>
								<th>Chat or Comment</th>
								<th>View Photo</th>
								<th>Download Software</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#session.authTable" id="at">
								<tr>
									<td><s:property value="#at.id"/></td>
									<td>
										<s:if test="#at.comment"><span class="glyphicon glyphicon-ok"></span></s:if>
										<s:else><span class="glyphicon glyphicon-remove"></span></s:else>
									</td>
									<td>
										<s:if test="#at.photo"><span class="glyphicon glyphicon-ok"></span></s:if>
										<s:else><span class="glyphicon glyphicon-remove"></span></s:else>
									</td>
									<td>
										<s:if test="#at.software"><span class="glyphicon glyphicon-ok"></span></s:if>
										<s:else><span class="glyphicon glyphicon-remove"></span></s:else>
									</td>
									<td><s:property value="#at.maxExp"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot>
							<tr><td colspan="5" class="text-left">
								<b>How to gain experience?</b><br>
								<ul>
									<li>Sign in everyday -- 1 exp</li>
									<li>Comment under any zone -- 2 exp</li>
									<li>Publish a topic or an article in chat zone -- 5 exp</li>
								</ul>
							</td></tr>
						</tfoot>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var exp = ${sessionScope.user.exp};
		var max = ${sessionScope.authority.maxExp};
		$("#exp_progress").attr("style", "width: " + exp/max*100 + "%;");
	</script>
</body>
</html>