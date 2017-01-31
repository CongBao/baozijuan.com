package com.baozijuan.timegallery.action.software;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.baozijuan.timegallery.action.base.UserBaseAction;

public class FileDownloadAction extends UserBaseAction {

	private static final long serialVersionUID = -1131407050852645085L;

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public InputStream getFile() throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(path);
	}

}
