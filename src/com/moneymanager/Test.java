package com.moneymanager;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class Test extends JFrame {//创建登陆窗口继承窗体类JFrame
	
	public Test(){
		
		//设置窗口
		setTitle("个人理财账本");//设置窗口标题
	    setSize(550,555);//设置窗口大小
		setLocationRelativeTo(null);//设置窗口居中
		getContentPane().setLayout(null);//设置为不采用任何布局管理器
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭按钮的动作为退出
		
		//菜单栏
		JMenuBar topMenuBar = new JMenuBar();//顶部导航栏
		JMenu systemManage = new JMenu("系统管理");//导航栏名称1
		JMenu paymentManage = new JMenu("收支管理");//导航栏名称2
		JMenuItem resetPassWord = new JMenuItem("密码重置");//导航栏名称1下拉菜单1
		JMenuItem exitSystem = new JMenuItem("退出系统");//导航栏名称1下拉菜单2
		setJMenuBar(topMenuBar);//显示顶部导航栏
		topMenuBar.add(systemManage);//显示导航栏名称1
		topMenuBar.add(paymentManage);//显示顶部导航栏名称2
		systemManage.add(resetPassWord);//显示导航栏名称1下拉菜单1
		systemManage.addSeparator();//分隔符
		systemManage.add(exitSystem);//显示导航栏名称1下拉菜单2
		
		//“输入查询条件”区域1
		JPanel areaJPanelFirst = new JPanel();//区域1
		Border area1 = BorderFactory.createTitledBorder("输入查询条件");//区域1边框
		areaJPanelFirst.setBorder(area1);//显示区域1边框
		areaJPanelFirst.setBounds(3,5,530,150);//设置区域1边框位置及大小
		getContentPane().add(areaJPanelFirst);//将组件显示出来
		//设置区域1的布局
		final GridLayout gridLayout = new GridLayout(3,0);// 创建网格布局管理器对象
		gridLayout.setVgap(5);// 设置组件的垂直间距
		areaJPanelFirst.setLayout(gridLayout);//设置区域1分成三行采用网格布局管理器
		//区域1分栏1布局
		final JPanel topJPanel1= new JPanel();//区域1第一栏分块
		areaJPanelFirst.add(topJPanel1);
		final FlowLayout flow1 = new FlowLayout();// 创建流布局管理器对象
		flow1.setHgap(10);// 设置组件的水平间距
		flow1.setVgap(10);// 设置组件的垂直间距
		topJPanel1.setLayout(flow1);//设置第一分栏采用流布局管理器
		
		//"收支类型"文本框
		final JLabel paymentType = new JLabel();
		paymentType.setText("收支类型：");//标签“收支类型”
		//paymentType.setBounds( 300, 30, 60, 20);//设置文本坐标及大小
		paymentType.setFont(new Font(Font.DIALOG, Font.BOLD, 12));//设置字体类型，加粗，大小
		topJPanel1.add(paymentType);//将第一分栏显示出来
        
		//"收支类型"选择框
		String[] paymentTypeChoice = {"收入","支出"}; //创建选项数组
		final JComboBox comboBox = new JComboBox(paymentTypeChoice);//创建选择框对象
		comboBox.setEditable(false);//设置选择框为不可编辑
		comboBox.setMaximumRowCount(2);//设置选择框弹出时显示选项的最多行数
		comboBox.insertItemAt("支出",0);//在索引为0的位置插入一个选项
		comboBox.setSelectedItem("收入");//设置索引为0的选项被选中
		topJPanel1.add(comboBox);//将选择框添加分栏1中
		
		//"查询"按钮
		final JButton search1 = new JButton();// 创建按钮对象
		search1.setContentAreaFilled(true);// 设置不绘制按钮的内容区域
		search1.setText("查询");
		search1.setBorderPainted(true);// 设置绘制按钮的边框
		search1.setContentAreaFilled(false);//按钮无颜色
		topJPanel1.add(search1);//将查询按钮添加到分栏1中
		
		//区域1分栏2布局
		final JPanel topJPanel2 = new JPanel();//区域1第二栏分块
		areaJPanelFirst.add(topJPanel2);
		topJPanel2.setLayout(null);
		FlowLayout flow2 = new FlowLayout();// 创建流布局管理器对象
		flow2.setHgap(10);// 设置组件的水平间距
		flow2.setVgap(10);// 设置组件的垂直间距
		topJPanel2.setLayout(flow2);//设置第二分栏为流布局
		
		//“起始时间”文本框
		final JLabel firstTime = new JLabel();
		firstTime.setText("起始时间");//标签“起始时间”
		//firstTime.setBounds( 300, 30, 60, 20);//设置文本坐标及大小
		firstTime.setFont(new Font(Font.DIALOG, Font.BOLD, 12));//设置字体类型，加粗，大小
		topJPanel2.add(firstTime);//将第二分栏显示出来
		
		//起始时间输入框
		JTextField firstTimeInput = new JTextField();
		firstTimeInput.setBounds(0, 0, 150, 25);
		firstTimeInput.setHorizontalAlignment(JTextField.CENTER);//输入框内容居中对齐
		firstTimeInput.setFont(new Font(Font.DIALOG, Font.BOLD, 12));//设置字体类型，加粗，大小
		topJPanel2.add(firstTimeInput);//将组件显示出来
		
		//“终止时间”文本框
		final JLabel lastTime = new JLabel();
		lastTime.setText("终止时间");//标签“起始时间”
		//firstTime.setBounds( 300, 30, 60, 20);//设置文本坐标及大小
		lastTime.setFont(new Font(Font.DIALOG, Font.BOLD, 12));//设置字体类型，加粗，大小
		firstTime.setPreferredSize(new Dimension(100,25));
		topJPanel2.add(lastTime);//将第二分栏显示出来
				
		//终止时间输入框
		JTextField lastTimeInput = new JTextField();
		lastTimeInput.setHorizontalAlignment(JTextField.CENTER);//输入框内容居中对齐
		lastTimeInput.setFont(new Font(Font.DIALOG, Font.BOLD, 12));//设置字体类型，加粗，大小
		lastTime.setPreferredSize(new Dimension(100,25));
		topJPanel2.add(lastTimeInput);//将组件显示出来
		
		//"查询"按钮
		final JButton search2 = new JButton();// 创建按钮对象
		search2.setContentAreaFilled(true);// 设置不绘制按钮的内容区域
		search2.setText("查询");
		search2.setBorderPainted(true);// 设置绘制按钮的边框
		search2.setContentAreaFilled(false);//按钮无颜色
		topJPanel2.add(search2);//将查询按钮添加到分栏1中
		
		//区域1分栏3布局
		final JPanel topJPanel3 = new JPanel();//区域1第三栏分块
		areaJPanelFirst.add(topJPanel3);
		topJPanel3.setLayout(null);
		FlowLayout flow3 = new FlowLayout();// 创建流布局管理器对象
		flow3.setHgap(10);// 设置组件的水平间距
		flow3.setVgap(10);// 设置组件的垂直间距
		topJPanel3.setLayout(flow3);//设置第三分栏为流布局
		
		//文字提示
		final JLabel toolTip = new JLabel();
		toolTip.setText("注意：时间格式为YYYYMMDD，例如：20150901");
		topJPanel3.add(toolTip);//显示文字提示
		
	    //“收支明细信息”区域2
		JPanel areaJPanelSecond = new JPanel();//区域2
		Border area2 = BorderFactory.createTitledBorder("收支明细信息");//区域2边框
		areaJPanelSecond.setBorder(area2);//显示区域2边框
		areaJPanelSecond.setBounds(3,160,530,325);//设置区域1边框位置及大小
		getContentPane().add(areaJPanelSecond);//将组件显示出来
					
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.setVisible(true);
	}
}
