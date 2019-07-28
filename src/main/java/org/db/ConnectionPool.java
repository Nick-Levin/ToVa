package org.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public final class ConnectionPool {
	
	private static DataSource ds;
	
	private ConnectionPool() {}
	
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/tovaDb");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("[ERROR]: Failed to initialize datasource");
		}
	}
	
	public static final Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("[ERROR]: Failed to get connection from datasource, Connection to DB might be lost");
		}
	}
	
}
