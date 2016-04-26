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
		setTitle("收支编辑");//窗口标题
		setSize(900,400);//设置窗口宽度和高度
		setLocationRelativeTo(null);//设置窗口居中
		getContentPane().setLayout(null);//Layout为空
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//可关闭的窗口
		
		//编辑收支信息
		Border leftTitleBorder = BorderFactory.createTitledBorder("编辑收支信息");
		JPanel leftJpanel = new JPanel();
		leftJpanel.setBorder(leftTitleBorder);
		leftJpanel.setBounds(0, 0, 230, 355);
		getContentPane().add(leftJpanel);
		GridLayout gridLayout1 = new GridLayout(5, 2);
		gridLayout1.setVgap(5);
		leftJpanel.setLayout(gridLayout1);
		
		JLabel number = new JLabel();
		number.setText("编号：");
		number.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(number);
		
		JTextField numberInput = new JTextField();
		numberInput.setHorizontalAlignment(JTextField.CENTER);
		numberInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(numberInput);
		
		JLabel data = new JLabel();
		data.setText("日期:");
		data.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(data);
		
		JTextField dataInput = new JTextField();
		dataInput.setHorizontalAlignment(JTextField.CENTER);
		dataInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(dataInput);
		
		JLabel type = new JLabel();
		type.setText("类型:");
		type.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(type);
		
		JTextField typeInput = new JTextField();
		typeInput.setHorizontalAlignment(JTextField.CENTER);
		typeInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(typeInput);
		
		JLabel content = new JLabel();
		content.setText("内容:");
		content.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(content);
		
		JTextField contentInput = new JTextField();
		contentInput.setHorizontalAlignment(JTextField.CENTER);
		contentInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(contentInput);
		
		JLabel money = new JLabel();
		money.setText("金额:");
		money.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(money);
		
		JTextField moneyInput = new JTextField();
		moneyInput.setHorizontalAlignment(JTextField.CENTER);
		moneyInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(moneyInput);
		//编辑收支信息
		
		//中间的五个Button
		JButton insert = new JButton();
		insert.setText("录入");
		insert.setBounds(235, 10, 120, 60);
		getContentPane().add(insert);
		
		JButton change = new JButton();
		change.setText("修改");
		change.setBounds(235, 80, 120, 60);
		getContentPane().add(change);
		
		JButton delete = new JButton();
		delete.setText("删除");
		delete.setBounds(235, 150, 120, 60);
		getContentPane().add(delete);
		
		JButton search = new JButton();
		search.setText("查询");
		search.setBounds(235, 220, 120, 60);
		getContentPane().add(search);
		
		JButton clear = new JButton();
		clear.setText("清空");
		clear.setBounds(235, 290, 120, 60);
		getContentPane().add(clear);
		//中间的五个Button
		
		//右边的收支信息
		Border rightTitleBorder = BorderFactory.createTitledBorder("显示收支信息");
		JPanel rightJpanel = new JPanel();
		rightJpanel.setBorder(rightTitleBorder);
		rightJpanel.setBounds(360, 0, 520, 355);
		rightJpanel.setLayout(null);
		getContentPane().add(rightJpanel);
		
		String columNames[] = {"编号","日期","类型","内容","金额"};
		Object data1[][] = new Object[50][5];
		JTable sumTable = new JTable(data1, columNames);
		sumTable.setBounds(5, 50, 785, 400);
		//将表格添加到可以滚动的Scroll中
		JScrollPane tableScroll = new JScrollPane(sumTable);
		tableScroll.setBounds(5,20,510,400);
		rightJpanel.add(tableScroll);
		//右边的收支信息
	}
	
	
	public static void main(String[] args) {
		IOEditor iOEditor= new IOEditor();
		iOEditor.setVisible(true);
	}

}
