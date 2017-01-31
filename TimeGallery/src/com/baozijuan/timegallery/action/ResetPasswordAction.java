package com.baozijuan.timegallery.action;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.baozijuan.timegallery.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class ResetPasswordAction extends UserBaseAction {

	private static final long serialVersionUID = 2775167753540843849L;

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		User user = (User) actionContext.getSession().get(WebConstant.RESET_PASS);
		if (user != null) {
			userManager.updatePassword(user, getPassword());
			actionContext.getSession().put(WebConstant.RESET_PASS, null);
			return LOGIN;
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT, "No account was required to reset password");
			return ERROR;
		}
	}

}
