package org.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.auth.Authenticator;
import org.db.UsersOperations;
import org.pojo.User;

@WebServlet("/loginAction")
public class LoginHandler extends HttpServlet {

	private static final long serialVersionUID = 8366598357239731464L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		final String[] queryParams = req.getQueryString().split("&");
		final String username = queryParams[0].split("=")[1];
		final String password = queryParams[1].split("=")[1];
		
		final boolean login = UsersOperations.isExists(username, password);
		
		resp.setContentType("application/json");
		
		if(login) {
			final User user = UsersOperations.getUser(username, password);
			final String token = Authenticator.createToken(user);
			
			resp.getWriter().write("{\"token\":\"" + token + "\"}");
		} else {
			final String json = "{\"msg\":\"username or password incorect\"}";
			resp.getWriter().write(json);
		}
		
	}

}
