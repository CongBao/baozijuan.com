package com.baozijuan.timegallery.action;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.opensymphony.xwork2.ActionContext;

public class LogoutAction extends UserBaseAction {

	private static final long serialVersionUID = 1625526715936533069L;

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		if (actionContext.getSession().get(WebConstant.USER) != null) {
			actionContext.getSession().put(WebConstant.USER, null);
			actionContext.getSession().put(WebConstant.AUTHORITY, null);
			actionContext.getSession().put(WebConstant.AUTHORITY_TABLE, null);
			return SUCCESS;
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT, "You haven't signed in.");
			return ERROR;
		}
	}
}
