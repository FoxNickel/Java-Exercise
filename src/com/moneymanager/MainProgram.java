package com.moneymanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainProgram {
	public static void main(String[] args) {
		//初始化数据库
		final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=moneyManager";
		final String USERNAME = "sa";
		final String PASSWORD = "159753";
		LoginInfo dataBase = new LoginInfo();
		try {
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			java.sql.Statement statement = conn.createStatement();
			String sql = "select *from loginInfo";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				dataBase.userName = rs.getString(1);
				dataBase.passWord = rs.getString(2);
			}
			rs.close();
			conn.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//初始化数据库结束
//		System.out.println(dataBase.userName);
//		System.out.println(dataBase.passWord);
		
		//登陆界面
		Login login = new Login(dataBase);
		login.setVisible(true);
		//登陆界面结束
	}

}
