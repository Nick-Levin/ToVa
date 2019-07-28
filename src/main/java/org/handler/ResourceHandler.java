package org.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.util.Asset;
import org.util.LoaderUtil;

@WebServlet("/resource")
public class ResourceHandler extends HttpServlet {

	private static final long serialVersionUID = -3285925555269164260L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.addHeader("content-type", "image/jpeg");
		LoaderUtil.load(Asset.BACKGROUND_IMAGE, resp);
		
	}

}
