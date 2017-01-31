package com.baozijuan.timegallery.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.baozijuan.timegallery.vo.AuthorityBean;
import com.baozijuan.timegallery.vo.UserBean;

public class UserBeanConverter extends StrutsTypeConverter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		UserBean userBean = new UserBean();
		AuthorityBean authorityBean = new AuthorityBean();
		String[] data = values[0].split(",");
		userBean.setId(Integer.parseInt(data[0]));
		userBean.setAccount(data[1]);
		userBean.setFamilyName(data[2]);
		userBean.setGivenName(data[3]);
		userBean.setNickname(data[4]);
		userBean.setGender(data[5]);
		userBean.setDob(data[6]);
		userBean.setPhone(data[7]);
		userBean.setAddress(data[8]);
		userBean.setCreatedDate(data[9]);
		userBean.setUpdatedDate(data[10]);
		userBean.setLastLoginDate(data[11]);
		userBean.setSignature(data[12]);
		userBean.setDescription(data[13]);
		userBean.setMailVerified(Boolean.parseBoolean(data[14]));
		userBean.setExp(Integer.parseInt(data[15]));
		authorityBean.setId(Integer.parseInt(data[16]));
		authorityBean.setMaxExp(Integer.parseInt(data[17]));
		authorityBean.setPhoto(Boolean.parseBoolean(data[18]));
		authorityBean.setComment(Boolean.parseBoolean(data[19]));
		authorityBean.setSoftware(Boolean.parseBoolean(data[20]));
		userBean.setAuthority(authorityBean);
		return userBean;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		UserBean userBean = (UserBean) o;
		return userBean.toString();
	}

}
