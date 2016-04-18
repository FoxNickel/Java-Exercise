package com.moneymanager;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	public Login(){
		//super();
		setTitle("欢迎使用个人理财账本");//窗口标题
		setSize(400,270);//设置窗口宽度和高度
		setLocationRelativeTo(null);//设置窗口居中
		getContentPane().setLayout(null);//Layout为空
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//可关闭的窗口
		//主窗口
		
		JLabel welcome = new JLabel();
		welcome.setText("欢迎使用个人理财系统");
		welcome.setBounds(80, 10, 300, 20);//坐标，宽高
		welcome.setFont(new Font(Font.DIALOG,Font.BOLD,20));//字体设置（字体类型，加粗，大小）
		getContentPane().add(welcome);//将组件显示出来
		//文本框（显示欢迎提示）
		
		JLabel userName = new JLabel();
		userName.setText("用户名:");
		userName.setBounds(40, 60, 80, 20);
		userName.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		getContentPane().add(userName);//文本框（显示用户名三个字）
		
		JTextField nameInput = new JTextField();
		nameInput.setHorizontalAlignment(JTextField.CENTER);
		nameInput.setBounds(130,55,200,30);
		nameInput.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		getContentPane().add(nameInput);//输入框（输入用户名）
		
		JLabel passWord = new JLabel();
		passWord.setText("密    码:");
		passWord.setBounds(40, 100, 80, 20);
		passWord.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		getContentPane().add(passWord);//文本框（显示密码两个字）
		
		JPasswordField passWordInput = new JPasswordField();
		passWordInput.setHorizontalAlignment(JTextField.CENTER);//输入内容居中
		passWordInput.setBounds(130,95,200,30);
		passWordInput.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		passWordInput.setEchoChar('*');//输入后看到的是*
		getContentPane().add(passWordInput);//输入框（输入密码）
		
		final JButton login = new JButton();
		login.setText("登陆");
		login.setContentAreaFilled(false);//按钮无颜色
		login.setBounds(40,155,130,40);
		getContentPane().add(login);//登陆按钮
		
		final JButton exit = new JButton();
		exit.setText("退出");
		exit.setContentAreaFilled(false);//按钮无颜色
		exit.setBounds(195,155,135,40);
		getContentPane().add(exit);//退出按钮
		
	}
	
	public static void main(String[] args) {
		Login login = new Login();
		login.setVisible(true);
	}
}
