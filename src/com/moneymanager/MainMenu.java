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
		//������
		setTitle("��ӭʹ�ø�������˱�");//���ڱ���
		setSize(600,550);//���ô��ڿ�Ⱥ͸߶�
		setLocationRelativeTo(null);//���ô��ھ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�����ڽ���
		
		//�˵���
		JMenuBar topMenuBar = new JMenuBar();//���˵���������װ���˵���MenuBar��
		setJMenuBar(topMenuBar);//�����˵�����ʾ
		JMenu systemManage = new JMenu("ϵͳ����");//���˵�1����
		topMenuBar.add(systemManage);//�����˵�1��ӵ�MenuBar��ȥ
		JMenuItem resetPassWord = new JMenuItem("��������");//�����Ӳ˵�1
		JMenuItem exit = new JMenuItem("�˳�ϵͳ");//�����Ӳ˵�2
		systemManage.add(resetPassWord);//�������Ӳ˵�1��ʾ����
		systemManage.addSeparator();//�ָ���
		systemManage.add(exit);//�������Ӳ˵�2��ʾ����
		
		JMenu ioManage = new JMenu("��֧����");//���˵�2����
		topMenuBar.add(ioManage);//�����˵�2��ӵ�MenuBar��ȥ
		JMenuItem editIO = new JMenuItem("��֧�༭");//�����Ӳ˵�
		ioManage.add(editIO);//��ʾ�����Ӳ˵�
		//�˵�������
		
		setVisible(true);//��ʾ������
	}
	
	
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
	}

}
