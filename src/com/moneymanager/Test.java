package com.moneymanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test{
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=moneyManager";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "159753";
	static{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			java.sql.Statement statement = conn.createStatement();
			String insert = "insert into loginInfo(uid,upw) values('hdu','123')";
			statement.executeUpdate(insert);
			String sql = "select *from loginInfo";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}