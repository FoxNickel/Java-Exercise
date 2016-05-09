package com.moneymanager;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class Test extends JFrame {//������½���ڼ̳д�����JFrame
	
	public Test(){
		
		//���ô���
		setTitle("��������˱�");//���ô��ڱ���
	    setSize(550,555);//���ô��ڴ�С
		setLocationRelativeTo(null);//���ô��ھ���
		getContentPane().setLayout(null);//����Ϊ�������κβ��ֹ�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���رհ�ť�Ķ���Ϊ�˳�
		
		//�˵���
		JMenuBar topMenuBar = new JMenuBar();//����������
		JMenu systemManage = new JMenu("ϵͳ����");//����������1
		JMenu paymentManage = new JMenu("��֧����");//����������2
		JMenuItem resetPassWord = new JMenuItem("��������");//����������1�����˵�1
		JMenuItem exitSystem = new JMenuItem("�˳�ϵͳ");//����������1�����˵�2
		setJMenuBar(topMenuBar);//��ʾ����������
		topMenuBar.add(systemManage);//��ʾ����������1
		topMenuBar.add(paymentManage);//��ʾ��������������2
		systemManage.add(resetPassWord);//��ʾ����������1�����˵�1
		systemManage.addSeparator();//�ָ���
		systemManage.add(exitSystem);//��ʾ����������1�����˵�2
		
		//�������ѯ����������1
		JPanel areaJPanelFirst = new JPanel();//����1
		Border area1 = BorderFactory.createTitledBorder("�����ѯ����");//����1�߿�
		areaJPanelFirst.setBorder(area1);//��ʾ����1�߿�
		areaJPanelFirst.setBounds(3,5,530,150);//��������1�߿�λ�ü���С
		getContentPane().add(areaJPanelFirst);//�������ʾ����
		//��������1�Ĳ���
		final GridLayout gridLayout = new GridLayout(3,0);// �������񲼾ֹ���������
		gridLayout.setVgap(5);// ��������Ĵ�ֱ���
		areaJPanelFirst.setLayout(gridLayout);//��������1�ֳ����в������񲼾ֹ�����
		//����1����1����
		final JPanel topJPanel1= new JPanel();//����1��һ���ֿ�
		areaJPanelFirst.add(topJPanel1);
		final FlowLayout flow1 = new FlowLayout();// ���������ֹ���������
		flow1.setHgap(10);// ���������ˮƽ���
		flow1.setVgap(10);// ��������Ĵ�ֱ���
		topJPanel1.setLayout(flow1);//���õ�һ�������������ֹ�����
		
		//"��֧����"�ı���
		final JLabel paymentType = new JLabel();
		paymentType.setText("��֧���ͣ�");//��ǩ����֧���͡�
		//paymentType.setBounds( 300, 30, 60, 20);//�����ı����꼰��С
		paymentType.setFont(new Font(Font.DIALOG, Font.BOLD, 12));//�����������ͣ��Ӵ֣���С
		topJPanel1.add(paymentType);//����һ������ʾ����
        
		//"��֧����"ѡ���
		String[] paymentTypeChoice = {"����","֧��"}; //����ѡ������
		final JComboBox comboBox = new JComboBox(paymentTypeChoice);//����ѡ������
		comboBox.setEditable(false);//����ѡ���Ϊ���ɱ༭
		comboBox.setMaximumRowCount(2);//����ѡ��򵯳�ʱ��ʾѡ����������
		comboBox.insertItemAt("֧��",0);//������Ϊ0��λ�ò���һ��ѡ��
		comboBox.setSelectedItem("����");//��������Ϊ0��ѡ�ѡ��
		topJPanel1.add(comboBox);//��ѡ�����ӷ���1��
		
		//"��ѯ"��ť
		final JButton search1 = new JButton();// ������ť����
		search1.setContentAreaFilled(true);// ���ò����ư�ť����������
		search1.setText("��ѯ");
		search1.setBorderPainted(true);// ���û��ư�ť�ı߿�
		search1.setContentAreaFilled(false);//��ť����ɫ
		topJPanel1.add(search1);//����ѯ��ť��ӵ�����1��
		
		//����1����2����
		final JPanel topJPanel2 = new JPanel();//����1�ڶ����ֿ�
		areaJPanelFirst.add(topJPanel2);
		topJPanel2.setLayout(null);
		FlowLayout flow2 = new FlowLayout();// ���������ֹ���������
		flow2.setHgap(10);// ���������ˮƽ���
		flow2.setVgap(10);// ��������Ĵ�ֱ���
		topJPanel2.setLayout(flow2);//���õڶ�����Ϊ������
		
		//����ʼʱ�䡱�ı���
		final JLabel firstTime = new JLabel();
		firstTime.setText("��ʼʱ��");//��ǩ����ʼʱ�䡱
		//firstTime.setBounds( 300, 30, 60, 20);//�����ı����꼰��С
		firstTime.setFont(new Font(Font.DIALOG, Font.BOLD, 12));//�����������ͣ��Ӵ֣���С
		topJPanel2.add(firstTime);//���ڶ�������ʾ����
		
		//��ʼʱ�������
		JTextField firstTimeInput = new JTextField();
		firstTimeInput.setBounds(0, 0, 150, 25);
		firstTimeInput.setHorizontalAlignment(JTextField.CENTER);//��������ݾ��ж���
		firstTimeInput.setFont(new Font(Font.DIALOG, Font.BOLD, 12));//�����������ͣ��Ӵ֣���С
		topJPanel2.add(firstTimeInput);//�������ʾ����
		
		//����ֹʱ�䡱�ı���
		final JLabel lastTime = new JLabel();
		lastTime.setText("��ֹʱ��");//��ǩ����ʼʱ�䡱
		//firstTime.setBounds( 300, 30, 60, 20);//�����ı����꼰��С
		lastTime.setFont(new Font(Font.DIALOG, Font.BOLD, 12));//�����������ͣ��Ӵ֣���С
		firstTime.setPreferredSize(new Dimension(100,25));
		topJPanel2.add(lastTime);//���ڶ�������ʾ����
				
		//��ֹʱ�������
		JTextField lastTimeInput = new JTextField();
		lastTimeInput.setHorizontalAlignment(JTextField.CENTER);//��������ݾ��ж���
		lastTimeInput.setFont(new Font(Font.DIALOG, Font.BOLD, 12));//�����������ͣ��Ӵ֣���С
		lastTime.setPreferredSize(new Dimension(100,25));
		topJPanel2.add(lastTimeInput);//�������ʾ����
		
		//"��ѯ"��ť
		final JButton search2 = new JButton();// ������ť����
		search2.setContentAreaFilled(true);// ���ò����ư�ť����������
		search2.setText("��ѯ");
		search2.setBorderPainted(true);// ���û��ư�ť�ı߿�
		search2.setContentAreaFilled(false);//��ť����ɫ
		topJPanel2.add(search2);//����ѯ��ť��ӵ�����1��
		
		//����1����3����
		final JPanel topJPanel3 = new JPanel();//����1�������ֿ�
		areaJPanelFirst.add(topJPanel3);
		topJPanel3.setLayout(null);
		FlowLayout flow3 = new FlowLayout();// ���������ֹ���������
		flow3.setHgap(10);// ���������ˮƽ���
		flow3.setVgap(10);// ��������Ĵ�ֱ���
		topJPanel3.setLayout(flow3);//���õ�������Ϊ������
		
		//������ʾ
		final JLabel toolTip = new JLabel();
		toolTip.setText("ע�⣺ʱ���ʽΪYYYYMMDD�����磺20150901");
		topJPanel3.add(toolTip);//��ʾ������ʾ
		
	    //����֧��ϸ��Ϣ������2
		JPanel areaJPanelSecond = new JPanel();//����2
		Border area2 = BorderFactory.createTitledBorder("��֧��ϸ��Ϣ");//����2�߿�
		areaJPanelSecond.setBorder(area2);//��ʾ����2�߿�
		areaJPanelSecond.setBounds(3,160,530,325);//��������1�߿�λ�ü���С
		getContentPane().add(areaJPanelSecond);//�������ʾ����
					
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.setVisible(true);
	}
}
