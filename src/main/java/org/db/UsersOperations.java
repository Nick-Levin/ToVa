package org.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.pojo.User;
import org.util.Encryptor;

public final class UsersOperations {
	
	private UsersOperations() {}
	
	public static void insert(User user) {
		try {
			final String query = "insert into users (id, username, password, email, role) values(?,?,?,?,?)";
			final Connection con = ConnectionPool.getConnection();
			final PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1, user.getId().toString());
			prep.setString(2, user.getUsername());
			prep.setString(3, user.getPassword());
			prep.setString(4, user.getEmail());
			prep.setString(5, user.getRole());
			prep.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("[ERROR]: " + e.getMessage());
		}
	}
	
	public static User getUser(String id) {
		try {
			final String query = "select * from users where id = ?";
			final Connection con = ConnectionPool.getConnection();
			final PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1, id);
			final ResultSet res = prep.executeQuery();
			
			res.next();
			final String _id = res.getString(1);
			final String username = res.getString(2);
			final String password = res.getString(3);
			final String email = res.getString(4);
			final String role = res.getString(5);
			
			return new User(_id, username, password, email, role);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("[ERROR]: " + e.getMessage());
		}
	}
	
	public static User getUser(String username, String password) {
		try {
			final String encryptedPass = Encryptor.encrypt(password);
			final String query = "select * from users where username = ? and password = ?";
			final Connection con = ConnectionPool.getConnection();
			final PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1, username);
			prep.setString(2, encryptedPass);
			final ResultSet res = prep.executeQuery();
			
			res.next();
			final String id = res.getString(1);
			final String _username = res.getString(2);
			final String _password = res.getString(3);
			final String email = res.getString(4);
			final String role = res.getString(5);
			
			return new User(id, _username, _password, email, role);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("[ERROR]: " + e.getMessage());
		}
	}
	
	public static boolean isExists(String username, String password) {
		try {
			final String query = "select count(*) from users where username = ? and password = ?";
			final String encryptedPass = Encryptor.encrypt(password);
			final Connection con = ConnectionPool.getConnection();
			final PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1, username);
			prep.setString(2, encryptedPass);
			final ResultSet res = prep.executeQuery();
			
			res.next();
			final int count = res.getInt(1);
			
			return count > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("[ERROR]: " + e.getMessage());
		}
	}
	
	public static boolean isExists(String username) {
		try {
			final String query = "select count(*) from users where username = ?";
			final Connection con = ConnectionPool.getConnection();
			final PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1, username);
			final ResultSet res = prep.executeQuery();
			
			res.next();
			int count = res.getInt(1);
			
			return count > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("[ERROR]: " + e.getMessage());
		}
	}
	
}