package com.moneymanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainProgram {
	public static void main(String[] args) {
		//��ʼ�����ݿ�
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
		//��ʼ�����ݿ����
//		System.out.println(dataBase.userName);
//		System.out.println(dataBase.passWord);
		
		//��½����
		Login login = new Login(dataBase);
		login.setVisible(true);
		//��½�������
	}

}
