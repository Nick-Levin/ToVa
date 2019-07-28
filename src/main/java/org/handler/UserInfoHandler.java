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

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.DecodedJWT;

@WebServlet("/user/info")
public class UserInfoHandler extends HttpServlet {

	private static final long serialVersionUID = 274794227052971097L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			final String token = req.getHeader("Authorization");
			System.out.println(token);
			final DecodedJWT jwt = Authenticator.Validate(token);
			final String id = jwt.getClaim("id").asString();
			final User user = UsersOperations.getUser(id);
			resp.addHeader("content-type", "application/json");
			resp.getWriter().write(JSON.toJSONString(user));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			resp.addHeader("content-type", "application/json");
			resp.getWriter().write("{\"msg\":\"Access denied, invalid token\"}");
		}
	}

}
