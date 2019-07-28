package org.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.util.LoaderUtil;
import org.util.Page;

@WebServlet("/user")
public class UserPage extends HttpServlet {

	private static final long serialVersionUID = 6882449974820300833L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.addHeader("content-type", "text/html");
		resp.getWriter().write(LoaderUtil.load(Page.USER));
	}

}
