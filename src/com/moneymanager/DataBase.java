package com.moneymanager;

public class DataBase {
	String userName;
	String passWord;
	final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=moneyManager";
	final String USERNAME = "sa";
	final String PASSWORD = "159753";
	static{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
