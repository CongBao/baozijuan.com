package com.baozijuan.timegallery.action.user;

import com.baozijuan.timegallery.action.base.UserBaseAction;
import com.baozijuan.timegallery.action.base.WebConstant;
import com.baozijuan.timegallery.domain.User;
import com.baozijuan.timegallery.vo.UserBean;
import com.opensymphony.xwork2.ActionContext;

public class EditProfileAction extends UserBaseAction {

	private static final long serialVersionUID = -8305185164524321597L;

	private UserBean userBean;

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		User user = userManager.updateUserInfo(getUserBean());
		if (user != null) {
			actionContext.getSession().put(WebConstant.USER, userManager.getUserBeanByAccount(user.getAccount()));
			actionContext.getSession().put(WebConstant.AUTHORITY, userManager.getAuthorityBeanByAccount(user.getAccount()));
			return SUCCESS;
		} else {
			actionContext.getSession().put(WebConstant.INTERCEPT, "Error in update");
			return ERROR;
		}
	}

}
