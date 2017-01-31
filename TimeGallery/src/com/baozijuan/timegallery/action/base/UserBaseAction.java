package com.baozijuan.timegallery.action.base;

import com.baozijuan.timegallery.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class UserBaseAction extends ActionSupport {

	private static final long serialVersionUID = 3154352724529987053L;

	protected UserManager userManager;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
