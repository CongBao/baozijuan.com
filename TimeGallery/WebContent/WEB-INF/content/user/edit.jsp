<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit Profile</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/res/img/time.png" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.js"></script>
</head>
<body>
	<header><%@ include file="../headerIn.jsp"%></header>
	<div class="container" style="margin-top: 3.7em;">
		<div class="row">
			<div class="page-header">
				<h3>
					Edit Profile - ${sessionScope.user.account}
					<a href="/TimeGallery/user/profile" class="btn btn-default pull-right">Cancel</a>
				</h3>
			</div>
			<form method="post" action="editProfile">
				<input type="hidden" name="userBean.id" value="${sessionScope.user.id}">
				<input type="hidden" name="userBean.account" value="${sessionScope.user.account}">
				<input type="hidden" name="userBean.createdDate" value="${sessionScope.user.createdDate}">
				<input type="hidden" name="userBean.updatedDate" value="${sessionScope.user.updatedDate}">
				<input type="hidden" name="userBean.lastLoginDate" value="${sessionScope.user.lastLoginDate}">
				<input type="hidden" name="userBean.mailVerified" value="${sessionScope.user.mailVerified}">
				<input type="hidden" name="userBean.exp" value="${sessionScope.user.exp}">
				<input type="hidden" name="userBean.authority" value="${sessionScope.authority}">
				<div class="col-md-6">
					<h4 class="text-center">Description Context</h4>
					<div class="form-group">
						<label for="editSignature">Signature</label>
						<input type="text" class="form-control" id="editSignature" placeholder="${sessionScope.user.signature}" name="userBean.signature">
					</div>
					<div class="form-group">
						<label for="editDescription">Self Description</label>
						<textarea class="form-control" rows="7" id="editDescription" placeholder="${sessionScope.user.description}" name="userBean.description"></textarea>
					</div>
					<div style="font-style: italic;">
						<label>Note</label>
						<p>Please press the submit button to update your profile.
						   Any input box that was empty or had no change in original value will not update your data.
						   To update your account or password, please refer to system settings.</p>
					</div>
				</div>
				<div class="col-md-6">
					<h4 class="text-center">Personal Information</h4>
					<div class="form-group">
						<label for="editNick">Nickname</label>
						<input type="text" class="form-control" id="editNick" placeholder="${sessionScope.user.nickname}" name="userBean.nickname">
					</div>
					<div class="form-group">
						<label for="editNameF">Family Name</label>
						<input type="text" class="form-control" id="editNameF" placeholder="${sessionScope.user.familyName}" name="userBean.familyName">
					</div>
					<div class="form-group">
						<label for="editNameG">Given Name</label>
						<input type="text" class="form-control" id="editNameG" placeholder="${sessionScope.user.givenName}" name="userBean.givenName">
					</div>
					<div class="form-group">
						<label for="editGenderM">Gender</label>
						<div class="col-md-12">
							<label class="radio-inline">
								<input type="radio" id="editGenderM" name="userBean.gender" value="Male"> Male
							</label>
							<label class="radio-inline">
								<input type="radio" id="editGenderF" name="userBean.gender" value="Female"> Female
							</label>
							<label class="radio-inline">
								<input type="radio" id="editGenderO" name="userBean.gender" value="Other"> Other
							</label>
						</div>
					</div>
					<br>
					<div class="form-group">
						<label for="editDoB">Date of Birth</label>
						<input type="date" class="form-control" id="editDoB" placeholder="${sessionScope.user.dob}" name="userBean.dob">
					</div>
					<div class="form-group">
						<label for="editPhone">Phone</label>
						<input type="tel" class="form-control" id="editPhone" placeholder="${sessionScope.user.phone}" name="userBean.phone">
					</div>
					<div class="form-group">
						<label for="editAddress">Address</label>
						<input type="text" class="form-control" id="editAddress" placeholder="${sessionScope.user.address}" name="userBean.address">
					</div>
				</div>
				<div class="col-md-12 text-right">
					<hr>
					<div class="form-group">
						<button type="reset" id="resetBtn" value="reset" class="btn btn-default">Reset</button>
						<button type="submit" id="submitBtn" value="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<footer><%@ include file="../footer.jsp"%></footer>
	<script type="text/javascript">
	var gender = "${sessionScope.user.gender}";
	if (gender == "Male")
		$("#editGenderM").attr("checked", "checked");
	else if (gender == "Female")
		$("#editGenderF").attr("checked", "checked");
	else if (gender == "Other")
		$("#editGenderO").attr("checked", "checked");

	/*$("#submitBtn").click(function() {
		$("input[type!='radio']").each(function() {
			if ($(this).val() == "")
				$(this).val("");
		});
		$("textarea").each(function() {
			if ($(this).val() == "")
				$(this).val("");
		});
	});*/
	</script>
</body>
</html>