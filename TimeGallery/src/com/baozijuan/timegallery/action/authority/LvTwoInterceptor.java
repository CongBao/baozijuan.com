package com.baozijuan.timegallery.action.authority;

import com.baozijuan.timegallery.action.base.WebConstant;
import com.baozijuan.timegallery.vo.AuthorityBean;
import com.baozijuan.timegallery.vo.UserBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LvTwoInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -5915963029898291286L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		UserBean user = (UserBean) actionContext.getSession().get(WebConstant.USER);
		AuthorityBean authority = (AuthorityBean) actionContext.getSession().get(WebConstant.AUTHORITY);
		if (user == null || authority == null) {
			actionContext.getSession().put(WebConstant.INTERCEPT, "Please login first");
			return Action.LOGIN;
		} else if (authority.getId() < 3) {
			actionContext.getSession().put(WebConstant.INTERCEPT, "Permission denied");
			return WebConstant.PERMISSION_DENIED;
		} else {
			return invocation.invoke();
		}
	}

}
