/**
 * 
 */
package com.moneymanager;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends JFrame{
	
	public MainMenu(){
		//主窗口
		setTitle("欢迎使用个人理财账本");//窗口标题
		setSize(600,550);//设置窗口宽度和高度
		setLocationRelativeTo(null);//设置窗口居中
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//主窗口结束
		
		//菜单栏
		JMenuBar topMenuBar = new JMenuBar();//主菜单栏，用来装主菜单（MenuBar）
		setJMenuBar(topMenuBar);//将主菜单栏显示
		JMenu systemManage = new JMenu("系统管理");//主菜单1名称
		topMenuBar.add(systemManage);//将主菜单1添加到MenuBar中去
		JMenuItem resetPassWord = new JMenuItem("密码重置");//下拉子菜单1
		JMenuItem exit = new JMenuItem("退出系统");//下拉子菜单2
		systemManage.add(resetPassWord);//将下拉子菜单1显示出来
		systemManage.addSeparator();//分隔符
		systemManage.add(exit);//将下拉子菜单2显示出来
		
		JMenu ioManage = new JMenu("收支管理");//主菜单2名称
		topMenuBar.add(ioManage);//将主菜单2添加到MenuBar中去
		JMenuItem editIO = new JMenuItem("收支编辑");//下拉子菜单
		ioManage.add(editIO);//显示下拉子菜单
		//菜单栏结束
		
		setVisible(true);//显示主窗口
	}
	
	
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
	}

}
