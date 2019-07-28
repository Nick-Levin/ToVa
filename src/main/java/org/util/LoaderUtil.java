package org.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public final class LoaderUtil {

	private LoaderUtil() {}
	
	public static final String load(Page page) {
		final StringBuilder sb = new StringBuilder();
		final InputStream is = LoaderUtil.class.getResourceAsStream(page.getPath());
		final int byteArrSize = 512;
		
		try {
			byte[] bytes = new byte[byteArrSize];

			while (is.read(bytes) > 0) {
				sb.append(new String(bytes));
				bytes = new byte[byteArrSize];
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("[ERROR]: Failed to load file " + page.getPath());
		} finally {
			try {
				is.close();
			} catch (Exception e2) {}
		}

		return sb.toString();
	}
	
	public static final void load(Asset asset, HttpServletResponse resp) {
		final InputStream is = LoaderUtil.class.getResourceAsStream(asset.getPath());
		
		try {
			final OutputStream out = resp.getOutputStream();
			byte[] bytes = new byte[4096];
			
			while(is.read(bytes) > 0) {
				out.write(bytes);
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				is.close();
			} catch (Exception e2) {}
		}
	}
	
}
