/**
 * 
 */
package com.moneymanager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.text.FieldView;
import javax.xml.bind.JAXBContext;

public class MainMenu extends JFrame {

	public MainMenu() {
		/* 主窗口 */
		setTitle("欢迎使用个人理财账本");// 窗口标题
		setSize(800, 750);// 设置窗口宽度和高度
		setLocationRelativeTo(null);// 设置窗口居中
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);// 窗口大小不可变
		getContentPane().setLayout(null);// 设置为null后才能设置大小
		/* 主窗口结束 */

		/* 菜单栏 */
		JMenuBar topMenuBar = new JMenuBar();// 主菜单栏，用来装主菜单（MenuBar）
		setJMenuBar(topMenuBar);// 将主菜单栏显示
		JMenu systemManage = new JMenu("系统管理");// 主菜单1名称
		topMenuBar.add(systemManage);// 将主菜单1添加到MenuBar中去
		JMenuItem resetPassWord = new JMenuItem("密码重置");// 下拉子菜单1
		JMenuItem exit = new JMenuItem("退出系统");// 下拉子菜单2
		systemManage.add(resetPassWord);// 将下拉子菜单1显示出来
		systemManage.addSeparator();// 分隔符
		systemManage.add(exit);// 将下拉子菜单2显示出来
		// 密码重置按钮的点击事件
		resetPassWord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePassWord changePass = new changePassWord();
				changePass.setVisible(true);
			}
		});
		// 密码重置按钮的点击事件
		// 退出系统按钮的点击事件
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		// 退出系统按钮的点击事件
		JMenu ioManage = new JMenu("收支管理");// 主菜单2名称
		topMenuBar.add(ioManage);// 将主菜单2添加到MenuBar中去
		JMenuItem editIO = new JMenuItem("收支编辑");// 下拉子菜单
		ioManage.add(editIO);// 显示下拉子菜单
		// 收支编辑按钮的点击事件
		editIO.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				IOEditor iOEditor= new IOEditor();
				iOEditor.setVisible(true);
			}
		});
		// 收支编辑按钮的点击事件
		/* 菜单栏结束 */

		/* 查询条件栏 */
		// 上面的外大框
		Border titleBorder1 = BorderFactory.createTitledBorder("输入查询条件");
		JPanel topJpanel = new JPanel();
		topJpanel.setBorder(titleBorder1);
		topJpanel.setBounds(0, 0, 795, 200);
		getContentPane().add(topJpanel);
		// 上面的外大框

		GridLayout gridLayout2 = new GridLayout(3, 1);
		gridLayout2.setVgap(5);
		topJpanel.setLayout(gridLayout2);// 使topJpanel一分为三

		// 第一行
		JPanel topIndexJpanel1 = new JPanel();
		topJpanel.add(topIndexJpanel1);

		JLabel typeOfIO = new JLabel();
		typeOfIO.setText("收支类型:");
		typeOfIO.setSize(80, 20);
		typeOfIO.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel1.add(typeOfIO);// 收支类型

		String[] type = { "收入", "支出" };
		JComboBox<String> selsectTypeOfIO = new JComboBox<String>(type);
		selsectTypeOfIO.setEditable(true);
		selsectTypeOfIO.setMaximumRowCount(2);
		selsectTypeOfIO.setSelectedItem("收入");
		topIndexJpanel1.add(selsectTypeOfIO);// 选择收支类型的框

		JButton search1 = new JButton();
		search1.setText("查询");
		topIndexJpanel1.add(search1);// 查询按钮
		// 第一行结束

		// 第二行
		JPanel topIndexJpanel2 = new JPanel();
		topJpanel.add(topIndexJpanel2);
		topIndexJpanel2.setLayout(null);

		JLabel startTime = new JLabel();
		startTime.setText("起始时间:");
		startTime.setBounds(120, 10, 120, 22);
		startTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(startTime);// 起始时间

		JTextField inputStartTime = new JTextField();
		inputStartTime.setHorizontalAlignment(JTextField.CENTER);
		inputStartTime.setBounds(220, 10, 120, 25);
		inputStartTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(inputStartTime);

		JLabel endTime = new JLabel();
		endTime.setText("终止时间:");
		endTime.setBounds(350, 10, 120, 22);
		endTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(endTime);

		JTextField inputEndTime = new JTextField();
		inputEndTime.setHorizontalAlignment(JTextField.CENTER);
		inputEndTime.setBounds(450, 10, 120, 25);
		inputEndTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(inputEndTime);

		final JButton search2 = new JButton();
		search2.setText("查询");
		search2.setBounds(580, 5, 70, 30);
		topIndexJpanel2.add(search2);// 查询按钮
		// 第二行结束

		// 第三行
		JPanel topIndexJpanel3 = new JPanel();
		topJpanel.add(topIndexJpanel3);

		JLabel cautions = new JLabel();
		cautions.setText("注意:时间格式为YYYYMMDD,例如:20150901");
		cautions.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel3.add(cautions);// 注意
		// 第三行结束
		/* 查询条件栏结束 */

		/* 收支明细栏 */
		// 下面的大框
		Border titleBorder2 = BorderFactory.createTitledBorder("收支明细信息");
		JPanel bottomJpanel = new JPanel();
		bottomJpanel.setBorder(titleBorder2);
		bottomJpanel.setLayout(null);
		bottomJpanel.setBounds(0, 205, 795, 490);
		getContentPane().add(bottomJpanel);
		// 下面的大框

		// 个人总收支余额
		JLabel sum = new JLabel();
		sum.setText("个人总收支余额为5000元");
		sum.setBounds(270, 20, 250, 20);
		sum.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		bottomJpanel.add(sum);
		// 个人总收支余额结束

		// 收支明细表格
		String columNames[] = { "编号", "日期", "类型", "内容", "金额" };
		Object data[][] = new Object[50][5];
		JTable sumTable = new JTable(data, columNames);
		sumTable.setBounds(5, 50, 785, 400);
		// 将表格添加到可以滚动的Scroll中
		JScrollPane tableScroll = new JScrollPane(sumTable);
		tableScroll.setBounds(5, 50, 785, 400);
		bottomJpanel.add(tableScroll);
		// 收支明细表格结束

		/* 收支明细栏结束 */

		setVisible(true);// 显示所有组件
	}

	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
	}

}
