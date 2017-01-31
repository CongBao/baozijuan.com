package com.baozijuan.timegallery.action;

import static com.baozijuan.timegallery.service.UserManager.LOGIN_SUCCESS;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.baozijuan.timegallery.domain.User;
import com.baozijuan.timegallery.function.ExpManager;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends UserBaseAction {

	private static final long serialVersionUID = 3025278861797386243L;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		int result = userManager.validLogin(getUser());
		if (result == LOGIN_SUCCESS) {
			ExpManager expManager = ExpManager.getInstance(userManager.getUserByAccount(user.getAccount()),
					userManager);
			if (!expManager.isLoginToday())
				user = expManager.addExp(ExpManager.LOGIN);
			user = userManager.updateLoginDate(userManager.getUserByAccount(user.getAccount()));
			actionContext.getSession().put(WebConstant.USER, userManager.getUserBeanByAccount(user.getAccount()));
			actionContext.getSession().put(WebConstant.AUTHORITY,
					userManager.getAuthorityBeanByAccount(user.getAccount()));
			actionContext.getSession().put(WebConstant.AUTHORITY_TABLE, userManager.getAllAuthorities());
			return SUCCESS;
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT, "Wrong account or password");
			return ERROR;
		}
	}

}
