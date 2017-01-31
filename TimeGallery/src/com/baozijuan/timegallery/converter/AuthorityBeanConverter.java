package com.baozijuan.timegallery.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.baozijuan.timegallery.vo.AuthorityBean;

public class AuthorityBeanConverter extends StrutsTypeConverter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		AuthorityBean authorityBean = new AuthorityBean();
		String[] data = values[0].split(",");
		authorityBean.setId(Integer.parseInt(data[0]));
		authorityBean.setMaxExp(Integer.parseInt(data[1]));
		authorityBean.setPhoto(Boolean.parseBoolean(data[2]));
		authorityBean.setComment(Boolean.parseBoolean(data[3]));
		authorityBean.setSoftware(Boolean.parseBoolean(data[4]));
		return authorityBean;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		AuthorityBean authorityBean = (AuthorityBean) o;
		return authorityBean.toString();
	}

}
