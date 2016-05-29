package com.moneymanager;

public class MainProgram {
	public static void main(String[] args) {
		//登陆前调用数据库
		DataBase dataBase = new DataBase();
		//登陆前调用数据库结束
		//登陆界面
		Login login = new Login(dataBase);
		login.setVisible(true);
		//登陆界面结束
	}

}
