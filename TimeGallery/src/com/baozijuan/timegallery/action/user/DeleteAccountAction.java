package com.baozijuan.timegallery.action.user;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.baozijuan.timegallery.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class DeleteAccountAction extends UserBaseAction {

	private static final long serialVersionUID = -25043625889162642L;

	private String account;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		User user = userManager.getUserByAccount(getAccount());
		if (user != null) {
			userManager.deleteAccount(user);
			return SUCCESS;
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT, "Error in deleting account");
			return ERROR;
		}
	}

}
