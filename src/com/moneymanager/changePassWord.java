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
		setTitle("�޸�����");// ���ڱ���
		setSize(400, 270);// ���ô��ڿ�Ⱥ͸߶�
		setLocationRelativeTo(null);// ���ô��ھ���
		getContentPane().setLayout(null);// LayoutΪ��
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �ɹرյĴ���
		// ������

		JLabel oldPass = new JLabel();
		oldPass.setText("������:");
		oldPass.setBounds(40, 20, 80, 20);
		oldPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(oldPass);// �ı�����ʾ�û��������֣�

		JPasswordField oldPassInput = new JPasswordField();
		oldPassInput.setHorizontalAlignment(JTextField.CENTER);
		oldPassInput.setBounds(140, 15, 200, 30);
		oldPassInput.setEchoChar('*');// ����󿴵�����*
		oldPassInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(oldPassInput);// ����������û�����

		JLabel newPass = new JLabel();
		newPass.setText("������:");
		newPass.setBounds(40, 65, 200, 20);
		newPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(newPass);// �ı�����ʾ���������֣�

		JPasswordField newPassInput = new JPasswordField();
		newPassInput.setHorizontalAlignment(JTextField.CENTER);// �������ݾ���
		newPassInput.setBounds(140, 60, 200, 30);
		newPassInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		newPassInput.setEchoChar('*');// ����󿴵�����*
		getContentPane().add(newPassInput);// ������������룩

		JLabel confirmNewPass = new JLabel();
		confirmNewPass.setText("ȷ��������:");
		confirmNewPass.setBounds(20, 110, 200, 20);
		confirmNewPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(confirmNewPass);// �ı�����ʾ���������֣�

		JPasswordField newPassInput2 = new JPasswordField();
		newPassInput2.setHorizontalAlignment(JTextField.CENTER);// �������ݾ���
		newPassInput2.setBounds(140, 105, 200, 30);
		newPassInput2.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		newPassInput2.setEchoChar('*');// ����󿴵�����*
		getContentPane().add(newPassInput2);// ������������룩

		final JButton login = new JButton();
		login.setText("ȷ��");
		login.setContentAreaFilled(false);// ��ť����ɫ
		login.setBounds(40, 155, 130, 40);
		getContentPane().add(login);// ��½��ť

		final JButton exit = new JButton();
		exit.setText("ȡ��");
		exit.setContentAreaFilled(false);// ��ť����ɫ
		exit.setBounds(195, 155, 135, 40);
		getContentPane().add(exit);// �˳���ť
		// ȡ����ť�ĵ���¼�
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		// ȡ����ť�ĵ���¼�
	}

	public static void main(String[] args) {
		changePassWord changePass = new changePassWord();
		changePass.setVisible(true);
	}

}
