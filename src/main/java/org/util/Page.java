package org.util;

public enum Page {
	
	LOGIN("/webpages/index.html"),
	REGISTER("/webpages/register.html"),
	USER("/webpages/user.html");
	
	private final String path;
	
	Page(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	
}