package com.oracle.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.oracle.entity.Item;
import com.oracle.service.ItemService;

public class ElectItemView extends JFrame {
	private JTable table;
	ArrayList<Item> arr=null;
	public ElectItemView() {
		super();
		setTitle("��Ŀѡ��");
		setVisible(true);
		setSize(500, 300);
		DefaultTableModel tm=new DefaultTableModel();
		getContentPane().setLayout(new BorderLayout());
		
		
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		final JButton sureItem_btn = new JButton();
		sureItem_btn.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int sCount=table.getSelectedRowCount();
				if(sCount!=1){
					JOptionPane.showMessageDialog(null, "��ֻѡ��һ��");
				}else{
					int sRow=table.getSelectedRow();
					int num=(int) tm.getValueAt(sRow, 1);//������ʾ��Ŀ�ĵ�����Ϣ
					System.out.println(num);
				}
				
			}
		});
		sureItem_btn.setText("ȷ��");
		panel.add(sureItem_btn);
		
		
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(tm);
		tm.addColumn("��Ŀ����");
		tm.addColumn("��Ŀ���");
		ItemService eis=new ItemService();
		try {
			 arr=eis.getItem();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			// TODO Auto-generated catch block
//			e1.printStackTrace();
		}
		for (int i = 0; i < arr.size(); i++) {
			
			tm.addRow(new Object[]{arr.get(i).getProjectName(),arr.get(i).getSerialNumber()});
		}
		scrollPane.setViewportView(table);
	}
	
	
	

}
