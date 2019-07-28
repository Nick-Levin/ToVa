package org.handler;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.db.UsersOperations;
import org.pojo.User;

import com.alibaba.fastjson.JSON;

@WebServlet("/registerAction")
public class RegisterHandler extends HttpServlet {

	private static final long serialVersionUID = -8027529793203210797L;

	@Override
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		final String error1 = "{\"msg\":\"Missing fields\"}";
		final String error2 = "{\"msg\":\"Username already exists\"}";
		
		final Scanner scan = new Scanner(req.getInputStream(), "UTF-8").useDelimiter("\\A");
		final String body = scan.hasNext() ? scan.next() : "";
		
		if(body.isEmpty()) {
			resp.getWriter().write(error1);
			return;
		}
		
		final User user = JSON.parseObject(body, User.class);
		
		if(UsersOperations.isExists(user.getUsername())) {
			resp.getWriter().write(error2);
			return;
		}
		
		UsersOperations.insert(user);
		
		resp.getWriter().write(JSON.toJSONString(user));
		
	}

}






