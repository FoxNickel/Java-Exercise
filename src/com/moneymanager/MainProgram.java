package com.moneymanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainProgram {
	public static void main(String[] args) {
		//登陆前调用数据库
		DataBase dataBase = new DataBase();
		try {
			Connection conn = DriverManager.getConnection(dataBase.URL,dataBase.USERNAME,dataBase.PASSWORD);
			java.sql.Statement statement = conn.createStatement();
			String sql = "select * from loginInfo";
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
		//登陆前调用数据库结束
		
		//登陆界面
		Login login = new Login(dataBase);
		login.setVisible(true);
		//登陆界面结束
	}

}
