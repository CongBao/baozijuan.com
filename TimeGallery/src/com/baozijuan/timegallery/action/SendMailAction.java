package com.baozijuan.timegallery.action;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.baozijuan.timegallery.domain.User;
import com.baozijuan.timegallery.function.MailManager;
import com.opensymphony.xwork2.ActionContext;

public class SendMailAction extends UserBaseAction {

	private static final long serialVersionUID = -7469517563723619150L;

	private static final String VERIFY = "verify";
	private static final String RESET_PASS = "reset_pass";

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		User user = null;
		if ((user = (User) actionContext.getSession().get(WebConstant.VERIFY)) != null) {
			MailManager.getInstance().sendMail(user.getAccount());
			return VERIFY;
		} else if ((user = (User) actionContext.getSession().get(WebConstant.RESET_PASS)) != null) {
			MailManager.getInstance().sendMail(user.getAccount());
			return RESET_PASS;
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT, "No account was required to verify");
			return ERROR;
		}
	}

}
