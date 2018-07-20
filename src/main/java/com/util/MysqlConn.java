package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConn {
	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/literature";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "HDLi7952";

	private Connection conn = null;
//	private PreparedStatement stmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	public void init() {
		
		try {
			// 注册 JDBC 驱动
			Class.forName(JDBC_DRIVER);
			// 打开链接
//             System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//             System.out.println();
//             System.out.println("成功连接");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String query(String table, String id) {
		String title = null;
		String sql;
		try {
			if(table.equals("reviews")) {
				id = "\'"+id+"\'";
				sql = String.format("SELECT text FROM %s WHERE id = %s", table, id);
				}
			else
				sql = String.format("SELECT lit_title FROM %s WHERE lit_id = %s", table, id);
			stmt = conn.createStatement();
//			stmt = conn.createStatement();
			//rs = stmt.executeQuery("SELECT foo FROM bar");
//			stmt.setString(1, "bio_literature");
//			stmt.setString(2, "61812");
			// or alternatively, if you don't know ahead of time that
			// the query will be a SELECT...
			rs = stmt.executeQuery(sql);
//			if (rs=stmt.executeQuery(sql)) {
//				rs = stmt.getResultSet();
//			}
			
			while(rs.next()) {
				if(table.equals("reviews"))
					title=(rs.getString("text"));
				else
					title=(rs.getString("lit_title"));
			}
				
			// Now do something with the ResultSet ....
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore
				stmt = null;
			}
		}
		return title;
	}
	
	public String[] queryDetail(String ca, String id) {
		String[] details = null;
		String sql = null;
		try {
			if(ca.equals("reviews")) {
				id = "\'"+id+"\'";
				sql = String.format("select * from %s where id=%s", ca, id);
			}
			else
				sql = String.format("select * from %s where lit_id=%s", ca, id);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			details = new String[rsmd.getColumnCount()];
			while (rs.next()) {
				for (int i = 0; i < details.length; i++) {
					details[i] = rs.getString(i + 1);
				} 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details;
	}
	public void closeConn() {
		try {
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		MysqlConn mc = new MysqlConn();
//		mc.init();
//		
////		ResultSet rs = mc.query("bio_literature","61807");
//		
//		String [] detail = mc.queryDetail("bio_literature","61807");
//		for(int i=0;i<detail.length;i++) {
//			System.out.println(detail[i]);
//		}
//	}
}
