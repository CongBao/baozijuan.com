package com.baozijuan.timegallery.action;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.baozijuan.timegallery.domain.User;
import com.baozijuan.timegallery.function.MailManager;
import com.opensymphony.xwork2.ActionContext;

public class MailVerifyAction extends UserBaseAction {

	private static final long serialVersionUID = 4812464427086738115L;

	private static final String RESET_PASS = "reset_pass";

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		User user = null;
		if ((user = (User) actionContext.getSession().get(WebConstant.VERIFY)) != null) {
			if (getCode().equalsIgnoreCase(MailManager.VerifyCode.getVerifyCode())) {
				user = userManager.updateMailVerifyState(user, true);
				actionContext.getSession().put(WebConstant.VERIFY, null);
				actionContext.getSession().put(WebConstant.USER, userManager.getUserBeanByAccount(user.getAccount()));
				actionContext.getSession().put(WebConstant.AUTHORITY,
						userManager.getAuthorityBeanByAccount(user.getAccount()));
				actionContext.getSession().put(WebConstant.AUTHORITY_TABLE, userManager.getAllAuthorities());
				return SUCCESS;
			} else {
				actionContext.getSession().put(WebConstant.INTERCEPT, "Wrong verification code");
				return ERROR;
			}
		} else if ((user = (User) actionContext.getSession().get(WebConstant.RESET_PASS)) != null) {
			if (getCode().equalsIgnoreCase(MailManager.VerifyCode.getVerifyCode())) {
				user = userManager.updateMailVerifyState(user, true);
				return RESET_PASS;
			} else {
				actionContext.getSession().put(WebConstant.INTERCEPT, "Wrong verification code");
				return ERROR;
			}
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT, "No account was required to verify");
			return ERROR;
		}
	}

}
