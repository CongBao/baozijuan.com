package com.baozijuan.timegallery.action;

import static com.baozijuan.timegallery.service.UserManager.REGIST_SUCCESS;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.baozijuan.timegallery.domain.User;
import com.baozijuan.timegallery.function.ExpManager;
import com.opensymphony.xwork2.ActionContext;

public class RegistAction extends UserBaseAction {

	private static final long serialVersionUID = -5888874328220254433L;

	private static final String SEND_MAIL = "send_mail";

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
		int result = userManager.validRegist(getUser());
		if (result == REGIST_SUCCESS) {
			ExpManager expManager = ExpManager.getInstance(userManager.getUserByAccount(user.getAccount()),
					userManager);
			if (!expManager.isLoginToday())
				user = expManager.addExp(ExpManager.LOGIN);
			user = userManager.updateLoginDate(userManager.getUserByAccount(user.getAccount()));
			actionContext.getSession().put(WebConstant.VERIFY, user);
			return SEND_MAIL;
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT, "Account is existed");
			return ERROR;
		}
	}

}
