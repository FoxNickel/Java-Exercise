package com.moneymanager;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	public Login(){
		super();
		setTitle("��ӭʹ�ø�������˱�");
		setSize(400,270);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������
		
		JLabel welcome = new JLabel();
		welcome.setText("��ӭʹ�ø������ϵͳ");
		welcome.setBounds(80, 10, 300, 20);
		welcome.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		getContentPane().add(welcome);//�ı�����ʾ��ӭ��ʾ��
		
		JLabel userName = new JLabel();
		userName.setText("�û���:");
		userName.setBounds(40, 60, 80, 20);
		userName.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		getContentPane().add(userName);//�ı�����ʾ�û��������֣�
		
		JTextField nameInput = new JTextField();
		nameInput.setHorizontalAlignment(JTextField.CENTER);
		nameInput.setBounds(130,55,200,30);
		nameInput.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		getContentPane().add(nameInput);//����������û�����
		
		JLabel passWord = new JLabel();
		passWord.setText("��    ��:");
		passWord.setBounds(40, 100, 80, 20);
		passWord.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		getContentPane().add(passWord);//�ı�����ʾ���������֣�
		
		JPasswordField passWordInput = new JPasswordField();
		passWordInput.setHorizontalAlignment(JTextField.CENTER);
		passWordInput.setBounds(130,95,200,30);
		passWordInput.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		passWordInput.setEchoChar('*');
		getContentPane().add(passWordInput);//������������룩
		
		final JButton login = new JButton();
		login.setText("��½");
		login.setContentAreaFilled(false);//��ť����ɫ
		getContentPane().add(login);
		login.setBounds(40,155,130,40);
		getContentPane().add(login);//��½��ť
		
		final JButton exit = new JButton();
		exit.setText("�˳�");
		exit.setContentAreaFilled(false);//��ť����ɫ
		getContentPane().add(login);
		exit.setBounds(195,155,135,40);
		getContentPane().add(exit);//�˳���ť
		
	}
	
	public static void main(String[] args) {
		Login login = new Login();
		login.setVisible(true);
	}
}
