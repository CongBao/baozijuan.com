package com.baozijuan.timegallery.function;

import java.text.DateFormat;
import java.util.Date;

import com.baozijuan.timegallery.domain.User;
import com.baozijuan.timegallery.service.UserManager;

public class ExpManager {

	public static final int LOGIN = 1;
	public static final int COMMENT = 2;

	private User user;
	private UserManager userManager;

	private static ExpManager expManager = new ExpManager(null, null);

	private ExpManager(User user, UserManager userManager) {
		this.user = user;
		this.userManager = userManager;
	}

	public static ExpManager getInstance(User user, UserManager userManager) {
		expManager.user = user;
		expManager.userManager = userManager;
		return expManager;
	}

	public boolean isLoginToday() {
		String today = DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date());
		if (user.getLastLoginDate().equalsIgnoreCase(today))
			return true;
		return false;
	}

	public User addExp(int type) {
		user = userManager.updateExperience(user, user.getExp() + type);
		return checkLevelUp();
	}

	private User checkLevelUp() {
		if (user.getExp() >= user.getAuthority().getMaxExp())
			user = userManager.updateAuthority(user, user.getAuthority().getId() + 1);
		return user;
	}

}
