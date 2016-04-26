package com.moneymanager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class changePassWord extends JFrame {

	public changePassWord() {
		setTitle("修改密码");// 窗口标题
		setSize(400, 270);// 设置窗口宽度和高度
		setLocationRelativeTo(null);// 设置窗口居中
		getContentPane().setLayout(null);// Layout为空
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 可关闭的窗口
		// 主窗口

		JLabel oldPass = new JLabel();
		oldPass.setText("旧密码:");
		oldPass.setBounds(40, 20, 80, 20);
		oldPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(oldPass);// 文本框（显示用户名三个字）

		JPasswordField oldPassInput = new JPasswordField();
		oldPassInput.setHorizontalAlignment(JTextField.CENTER);
		oldPassInput.setBounds(140, 15, 200, 30);
		oldPassInput.setEchoChar('*');// 输入后看到的是*
		oldPassInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(oldPassInput);// 输入框（输入用户名）

		JLabel newPass = new JLabel();
		newPass.setText("新密码:");
		newPass.setBounds(40, 65, 200, 20);
		newPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(newPass);// 文本框（显示密码两个字）

		JPasswordField newPassInput = new JPasswordField();
		newPassInput.setHorizontalAlignment(JTextField.CENTER);// 输入内容居中
		newPassInput.setBounds(140, 60, 200, 30);
		newPassInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		newPassInput.setEchoChar('*');// 输入后看到的是*
		getContentPane().add(newPassInput);// 输入框（输入密码）

		JLabel confirmNewPass = new JLabel();
		confirmNewPass.setText("确认新密码:");
		confirmNewPass.setBounds(20, 110, 200, 20);
		confirmNewPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(confirmNewPass);// 文本框（显示密码两个字）

		JPasswordField newPassInput2 = new JPasswordField();
		newPassInput2.setHorizontalAlignment(JTextField.CENTER);// 输入内容居中
		newPassInput2.setBounds(140, 105, 200, 30);
		newPassInput2.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		newPassInput2.setEchoChar('*');// 输入后看到的是*
		getContentPane().add(newPassInput2);// 输入框（输入密码）

		final JButton login = new JButton();
		login.setText("确定");
		login.setContentAreaFilled(false);// 按钮无颜色
		login.setBounds(40, 155, 130, 40);
		getContentPane().add(login);// 登陆按钮

		final JButton exit = new JButton();
		exit.setText("取消");
		exit.setContentAreaFilled(false);// 按钮无颜色
		exit.setBounds(195, 155, 135, 40);
		getContentPane().add(exit);// 退出按钮
		// 取消按钮的点击事件
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		// 取消按钮的点击事件
	}

	public static void main(String[] args) {
		changePassWord changePass = new changePassWord();
		changePass.setVisible(true);
	}

}
