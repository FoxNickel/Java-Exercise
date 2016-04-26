package com.moneymanager;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class IOEditor extends JFrame{

	public IOEditor(){
		setTitle("��֧�༭");//���ڱ���
		setSize(900,400);//���ô��ڿ�Ⱥ͸߶�
		setLocationRelativeTo(null);//���ô��ھ���
		getContentPane().setLayout(null);//LayoutΪ��
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�ɹرյĴ���
		
		//�༭��֧��Ϣ
		Border leftTitleBorder = BorderFactory.createTitledBorder("�༭��֧��Ϣ");
		JPanel leftJpanel = new JPanel();
		leftJpanel.setBorder(leftTitleBorder);
		leftJpanel.setBounds(0, 0, 230, 355);
		getContentPane().add(leftJpanel);
		GridLayout gridLayout1 = new GridLayout(5, 2);
		gridLayout1.setVgap(5);
		leftJpanel.setLayout(gridLayout1);
		
		JLabel number = new JLabel();
		number.setText("��ţ�");
		number.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(number);
		
		JTextField numberInput = new JTextField();
		numberInput.setHorizontalAlignment(JTextField.CENTER);
		numberInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(numberInput);
		
		JLabel data = new JLabel();
		data.setText("����:");
		data.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(data);
		
		JTextField dataInput = new JTextField();
		dataInput.setHorizontalAlignment(JTextField.CENTER);
		dataInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(dataInput);
		
		JLabel type = new JLabel();
		type.setText("����:");
		type.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(type);
		
		JTextField typeInput = new JTextField();
		typeInput.setHorizontalAlignment(JTextField.CENTER);
		typeInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(typeInput);
		
		JLabel content = new JLabel();
		content.setText("����:");
		content.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(content);
		
		JTextField contentInput = new JTextField();
		contentInput.setHorizontalAlignment(JTextField.CENTER);
		contentInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(contentInput);
		
		JLabel money = new JLabel();
		money.setText("���:");
		money.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(money);
		
		JTextField moneyInput = new JTextField();
		moneyInput.setHorizontalAlignment(JTextField.CENTER);
		moneyInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(moneyInput);
		//�༭��֧��Ϣ
		
		//�м�����Button
		JButton insert = new JButton();
		insert.setText("¼��");
		insert.setBounds(235, 10, 120, 60);
		getContentPane().add(insert);
		
		JButton change = new JButton();
		change.setText("�޸�");
		change.setBounds(235, 80, 120, 60);
		getContentPane().add(change);
		
		JButton delete = new JButton();
		delete.setText("ɾ��");
		delete.setBounds(235, 150, 120, 60);
		getContentPane().add(delete);
		
		JButton search = new JButton();
		search.setText("��ѯ");
		search.setBounds(235, 220, 120, 60);
		getContentPane().add(search);
		
		JButton clear = new JButton();
		clear.setText("���");
		clear.setBounds(235, 290, 120, 60);
		getContentPane().add(clear);
		//�м�����Button
		
		//�ұߵ���֧��Ϣ
		Border rightTitleBorder = BorderFactory.createTitledBorder("��ʾ��֧��Ϣ");
		JPanel rightJpanel = new JPanel();
		rightJpanel.setBorder(rightTitleBorder);
		rightJpanel.setBounds(360, 0, 520, 355);
		rightJpanel.setLayout(null);
		getContentPane().add(rightJpanel);
		
		String columNames[] = {"���","����","����","����","���"};
		Object data1[][] = new Object[50][5];
		JTable sumTable = new JTable(data1, columNames);
		sumTable.setBounds(5, 50, 785, 400);
		//�������ӵ����Թ�����Scroll��
		JScrollPane tableScroll = new JScrollPane(sumTable);
		tableScroll.setBounds(5,20,510,400);
		rightJpanel.add(tableScroll);
		//�ұߵ���֧��Ϣ
	}
	
	
	public static void main(String[] args) {
		IOEditor iOEditor= new IOEditor();
		iOEditor.setVisible(true);
	}

}
