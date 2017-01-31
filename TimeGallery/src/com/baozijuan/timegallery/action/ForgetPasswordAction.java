package com.baozijuan.timegallery.action;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.opensymphony.xwork2.ActionContext;

public class ForgetPasswordAction extends UserBaseAction {

	private static final long serialVersionUID = 7936859495463025529L;

	private static final String SEND_MAIL = "send_mail";

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
		if (account == null)
			return ERROR;
		if (userManager.isUserExist(getAccount())) {
			actionContext.getSession().put(WebConstant.RESET_PASS, userManager.getUserByAccount(account));
			return SEND_MAIL;
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT, "Account not exist");
			return ERROR;
		}
	}

}
