package com.baozijuan.timegallery.action.user;

import static com.baozijuan.timegallery.service.UserManager.LOGIN_SUCCESS;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.baozijuan.timegallery.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class EditAccountAction extends UserBaseAction {

	private static final long serialVersionUID = -4650321173575587330L;

	private String oldAccount;
	private String verifyPassword;
	private String newAccount;

	public String getOldAccount() {
		return oldAccount;
	}

	public void setOldAccount(String oldAccount) {
		this.oldAccount = oldAccount;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public String getNewAccount() {
		return newAccount;
	}

	public void setNewAccount(String newAccount) {
		this.newAccount = newAccount;
	}

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		User user = userManager.getUserByAccount(getOldAccount());
		user.setPassword(getVerifyPassword());
		int result = userManager.validLogin(user);
		if (result == LOGIN_SUCCESS) {
			user.setPassword(getVerifyPassword());
			user = userManager.updateAccount(user, getNewAccount());
			if (user != null) {
				user = userManager.updateMailVerifyState(user, false);
				actionContext.getSession().put(WebConstant.USER, userManager.getUserBeanByAccount(user.getAccount()));
				actionContext.getSession().put(WebConstant.AUTHORITY,
						userManager.getAuthorityBeanByAccount(user.getAccount()));
				return SUCCESS;
			} else {
				actionContext.getSession().put(WebConstant.INTERCEPT_1, "Account is existed");
				return ERROR;
			}
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT_1, "Wrong Current Password");
			return ERROR;
		}
	}

}
