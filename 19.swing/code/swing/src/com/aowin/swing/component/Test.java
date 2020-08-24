package com.aowin.swing.component;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

public class Test {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		Container con = frame.getContentPane();  //容器
		
		//con.setBackground(Color.blue);
		
		//添加组件：默认组件铺满整个界面，可通过设置布局排列组件
		frame.setLayout(new FlowLayout());
		//按钮
		JButton button = new JButton("按钮内容");
		frame.add(button);
		//修改按钮上显示的内容
		button.setText("修改后的按钮");
		
		
		//文本标记
		JLabel label = new JLabel("文字标记");
		frame.add(label);
		label.setForeground(Color.red);  //设置前景色==》文字颜色
		
		
		//图标按钮
		ImageIcon icon = new ImageIcon("caomei.jpg");
		JButton iconBut = new JButton(icon);
		frame.add(iconBut);
		//iconBut.setIcon(icon);  //修改图标
		
		
		
		JLabel accountLabel = new JLabel("请输入账号");
		//文本框
		JTextField accountField = new JTextField(15);  //初始宽度
		
		//设置文本框的初始内容
		accountField.setText("初始内容");
		//获取文本框中的内容
		String text = accountField.getText();
		System.out.println("account:" + text);
		
		//容器JPanel--可以将单一组件作为整体
		JPanel panel = new JPanel();
		panel.add(accountLabel);
		panel.add(accountField);
//		frame.add(accountLabel);
//		frame.add(accountField);
		frame.add(panel);
		
		
		JLabel passLabel = new JLabel("请输入密码");
		JPasswordField passField = new JPasswordField(15);  //初始宽度
		
		JPanel p2 = new JPanel();
		p2.add(passLabel);
		p2.add(passField);
		frame.add(p2);
		
		//设置密码框暗文字符
		passField.setEchoChar('￥');
		
		//获取密码
		char[] passarr = passField.getPassword();
		String pass = new String(passarr);
		System.out.println(pass);
		
		//多行多列的文本域
		//JTextArea area = new JTextArea(5, 10);
		JTextArea area = new JTextArea("初始内容",5, 10);
		//frame.add(area);
		
		//设置area换行
		area.setLineWrap(true);
		
		//如果行比较多的时候出现滚动条
		JScrollPane  sp = new JScrollPane(area);
		frame.add(sp);
		
		//多选框
		JLabel l = new JLabel("爱好：");
		
		JCheckBox box1 = new JCheckBox("美食");
		JCheckBox box2 = new JCheckBox("游戏");
		JCheckBox box3 = new JCheckBox("编码");
		
		frame.add(l);
		frame.add(box1);
		frame.add(box2);
		frame.add(box3);
		
		//设置默认选中
		box3.setSelected(true);
		
		
		//单选
		JRadioButton but = new JRadioButton("男");
		JRadioButton but2 = new JRadioButton("女");
		
		//一组中选择一个==>ButtonGroup逻辑分组，不是物理组件
		ButtonGroup sexGroup = new ButtonGroup();
		sexGroup.add(but);
		sexGroup.add(but2);
		
		//设置选项
		but.setSelected(true);
		
		frame.add(but);
		frame.add(but2);
		
		
		if(but.isSelected()) {
			System.out.println("选中男");
		}else if(but2.isSelected()) {
			System.out.println("选中女");
		}
		
		
		//列表组件
		String[] data = {"语文","数学","英语","java"};
		JList<String> list = new JList<String>(data);
		frame.add(list);
		
		//设置选中项
		list.setSelectedIndex(2);
		//获取选中项的内容
		String value = list.getSelectedValue();
		System.out.println(value);
		
		
		//下拉列表
		Vector<String> items = new Vector<String>();
		items.add("杭州");
		items.add("温州");
		items.add("宁波");
		JComboBox<String> combo = new JComboBox<String>(items);
		
		//设置默认选项
		combo.setSelectedIndex(2);
		frame.add(combo);
		
		//获取选中项
		String item = (String) combo.getSelectedItem();
		System.out.println(item);
		
		
		//增加菜单==》JMenuBar    JMenu    JMenuItem
		
		JMenu menu = new JMenu("File");
		JMenuItem item1 = new JMenuItem("New");
		JMenuItem item2 = new JMenuItem("Open File");
		
		menu.add(item1);
		menu.add(item2);
		
		//增加分隔线
		menu.addSeparator();
		
		//增加有子项的菜单项
		JMenu sysMenu = new JMenu("System");
		sysMenu.add(new JMenuItem("Windows"));
		sysMenu.add(new JMenuItem("Unix"));
		menu.add(sysMenu);
		
		
		//菜单栏
		JMenuBar bar = new JMenuBar();
		bar.add(menu);
		
		//可以添加多个菜单项
		JMenu editMenu = new JMenu("Edit");
		bar.add(editMenu);
		
		frame.setJMenuBar(bar);
		
		//增加表格
		String[] columnNames = {"学号","名字","性别","年龄"};  //列名
		//String[][] initdata = {};
		String[][] initdata = {{"1001","laowang","男","27"},{"1002","xiaopeng","女","25"}};
		DefaultTableModel model = new DefaultTableModel(initdata,columnNames);
		JTable table = new JTable(model);
		JScrollPane sp2 = new JScrollPane(table);
		frame.add(sp2);
		
		//表格的操作
		//新增一行
		String[] row = {"1003","xiaoming","男","20"};
		model.addRow(row);
		
		//删除一行(参数是索引)
		//model.removeRow(0);  //第一行
		
		
		//清空表格数据
//		int count = table.getRowCount();
//		for(int i=0;i<count;i++) {
//			//model.removeRow(i);  //错误
//			model.removeRow(0);
//		}
		
//		for(int i=table.getRowCount()-1;i>=0;i--) {
//			model.removeRow(i);
//		}
		
		
		
		//获取选中行
		//int[] rowIndexs = table.getSelectedRows();  //获取多个选中行的索引
		
		int index = table.getSelectedRow();  //选中的行的索引
		//System.out.println(index);  //-1,没有选中行
		
		//假设选中第二行
		index = 1;
		
		//获取一行的数据
		String sno = (String) model.getValueAt(index, 0);
		String sname = (String) model.getValueAt(index, 1);
		System.out.println(sno+","+sname);
		
		//修改数据
		model.setValueAt("小明", 2, 1);
		
		
		//在已知表格的情况下获取tablemodel
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		System.out.println(model == m);  //true
		
		
		

		frame.setSize(500, 500);  //默认以左上角为坐标
		frame.setLocation(200, 0);  //设置初始位置
		frame.setVisible(true);  //显示可见，一般放在最后
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //关闭窗口的时候程序结束，根据需求
	
	
		//对话框
		//parentComponent
		
		//消息提示
		//JOptionPane.showMessageDialog(null, "swing组件！！！", "message", JOptionPane.PLAIN_MESSAGE);
		//JOptionPane.showMessageDialog(frame, "swing组件！！！", "message", JOptionPane.ERROR_MESSAGE);
				
	
		//输入框
//		String input = JOptionPane.showInputDialog(frame, "请输入名字", "default");
//		System.out.println(input);  //输入值，如果点击取消，返回null
		
		//确认框
		//int c = JOptionPane.showConfirmDialog(frame, "确认删除？", "确认操作", JOptionPane.OK_CANCEL_OPTION);
		//int c = JOptionPane.showConfirmDialog(frame, "确认删除？", "确认操作", JOptionPane.YES_NO_CANCEL_OPTION);
		//返回值表示点击的操作按钮：确认--》0    取消==》2
		//System.out.println(c);
//		if(c==JOptionPane.OK_OPTION) {
//			System.out.println("点击确认");
//		}
//		
//		if(c==JOptionPane.CANCEL_OPTION) {
//			System.out.println("点击取消");
//		}
//		
//		if(c == JOptionPane.NO_OPTION) {
//			System.out.println("点击否");
//		}
		
		
		//文件选择框
		JFileChooser chooser = new JFileChooser();
		//设置文件过滤器
//				chooser.setFileFilter(new FileFilter() {
//					
//					@Override
//					public String getDescription() {
//						// TODO Auto-generated method stub
//						return null;
//					}
//					
//					@Override
//					public boolean accept(File f) {
//						if(f.isDirectory() || f.getName().endsWith(".txt")) {
//							return true;
//						}
//						return false;
//					}
//				});
				
				//打开文件
		//int c = chooser.showOpenDialog(frame);  //返回值表示是否确认打开一个文件
				
//		if(c == JFileChooser.APPROVE_OPTION) {
//			System.out.println("打开文件");
//			File file = chooser.getSelectedFile();
//			System.out.println(file.getName());
//		}
//		if(c == JFileChooser.CANCEL_OPTION) {
//			System.out.println("取消打开");
//		}
		
		
		//保存文件
		int c = chooser.showSaveDialog(frame);
		if(c==JFileChooser.APPROVE_OPTION) {
			//System.out.println("保存");
			File f = chooser.getSelectedFile();
			System.out.println(f.getName());
			//如果文件不存在则创建
				try {
					f.createNewFile();
					FileWriter writer = new FileWriter(f);
					writer.write("hello world");
					writer.flush();
					writer.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
		}else{
			System.out.println("取消");
		}
	}

}
