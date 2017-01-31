package com.baozijuan.timegallery.action.user;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.baozijuan.timegallery.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class VerifyReqAction extends UserBaseAction {

	private static final long serialVersionUID = -3996649426067742356L;

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
		User user = userManager.getUserByAccount(account);
		if (user != null) {
			actionContext.getSession().put(WebConstant.VERIFY, user);
			return SEND_MAIL;
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT, "No account was required to verify");
			return ERROR;
		}
	}

}
