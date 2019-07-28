package org.util;

public enum Asset {
	
	BACKGROUND_IMAGE("/webpages/bg.jpg");
	
	private final String path;
	
	Asset(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
}