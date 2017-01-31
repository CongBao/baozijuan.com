package com.baozijuan.timegallery.action.user;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.baozijuan.timegallery.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class EditPasswordAction extends UserBaseAction {

	private static final long serialVersionUID = 6557146598921583128L;

	private String account;
	private String oldPassword;
	private String newPassword;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		User user = userManager.getUserByAccount(getAccount());
		if (getOldPassword().equals(user.getPassword())) {
			user = userManager.updatePassword(user, getNewPassword());
			actionContext.getSession().put(WebConstant.USER, userManager.getUserBeanByAccount(user.getAccount()));
			actionContext.getSession().put(WebConstant.AUTHORITY,
					userManager.getAuthorityBeanByAccount(user.getAccount()));
			return SUCCESS;
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT_2, "Wrong Current Password");
			return ERROR;
		}
	}

}
