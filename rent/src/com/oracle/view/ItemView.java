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

public class ItemView extends JFrame {
	DefaultTableModel tm = new DefaultTableModel();
	private JTable table = new JTable();

	public ItemView() {
		super();
		setResizable(false);
		setSize(600, 600);
		setTitle("��Ŀ��");

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		final JButton btn_Query = new JButton();
		btn_Query.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// ѡ��һ����Ϣ������밴ť,������Ŀ�����Ϊ���������ϸ�
				int count = table.getSelectedRowCount();
				if (count > 1) {
					JOptionPane.showMessageDialog(null, "ֻ��ѡ��һ��");

				} else if (count == 0) {
					JOptionPane.showMessageDialog(null, "��ѡ��һ��");

				} else {

					int chooseRow = table.getSelectedRow();
					int serialNumber = (int) tm.getValueAt(chooseRow, 0);
					System.out.println(".................");
				}

			}
		});
		btn_Query.setText("������Ŀ");
		panel.add(btn_Query);

		final JButton btn_Update = new JButton();
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// ѡ��һ����Ϣ����޸İ�ťʱ,����һ���޸����ݵĽ���,�ý�����������ť,
				// �ҳ�����Ŀ��Ŷ������޸�,����½�����޸İ�ť��,tmģ������Ӧ�е���Ϣ�޸������ݿ�����Ӧ�е����ݷ����޸�
				int count = table.getSelectedRowCount();
				if (count > 1) {
					JOptionPane.showMessageDialog(null, "ֻ���޸�һ��");

				} else if (count == 0) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ���");

				} else {
					// �����޸�
					int updateRow = table.getSelectedRow();
					UpdateJFrame uf = new UpdateJFrame(tm, updateRow);
					uf.setVisible(true);
				}

			}
		});
		btn_Update.setText("�޸�");
		panel.add(btn_Update);

		final JButton btn_Insert = new JButton();
		btn_Insert.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {

			}
		});
		btn_Insert.setText("����");
		panel.add(btn_Insert);

		final JButton btn_Delete = new JButton();
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// ���ɾ��ʱ,tmģ����ѡ���е���Ϣɾ�������ݿ��ж�Ӧ����ɾ��
				int count = table.getSelectedRowCount();
				if (count > 1) {
					JOptionPane.showMessageDialog(null, "ֻ��ɾ��һ��");

				} else if (count == 0) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");

				} else {
					// ��ɾ��
					// �û�ѡ��һ����Ŀ���ɾ�������жϸ����¼���Լ����ݱ����Ƿ��иñ�Ŷ�Ӧ����Ϣ����û�У���ֱ��ɾ������Ŀ��Ϣ�����У�
					// �������û�ȥɾ�������¼���Լ����ݱ��ж�Ӧ��ŵ���Ϣ��ɾ����Ϻ���ɾ����Ŀ��Ϣ
					int deleteRow = table.getSelectedRow();// ��ȡ��Ҫɾ���е�����
					int serialNumber = (int) tm.getValueAt(deleteRow, 0);// ��ȡ��Ҫɾ����Ŀ����Ŀ���
					// ��ѯ�����¼���Լ����ݱ����Ƿ��иñ�Ŷ�Ӧ����Ϣ תȥdao��
					ItemService is = new ItemService();
					boolean flag = true;
					int no = 0;
					try {
						flag = is.isBill(serialNumber);
						// �����жϸ����¼�����Ƿ��иñ�Ŷ�Ӧ����Ϣ
						boolean compare = is.isPayRecord(serialNumber);
						// ɾ����Ŀ���ж�Ӧ��Ŀ��ŵ���Ϣ
						no = is.delete(serialNumber);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						
						// e1.printStackTrace();
					}
					if (no == 1) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");

					}
				}

			}
		});
		btn_Delete.setText("ɾ��");
		panel.add(btn_Delete);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(table);
		table.setModel(tm);
		tm.addColumn("��Ŀ���");
		tm.addColumn("��Ŀ����");
		tm.addColumn("�ֹ����");
		tm.addColumn("˿�����");
		tm.addColumn("�ۼ����");
		tm.addColumn("�ֹ��ۼ�");
		tm.addColumn("˿���ۼ�");
		tm.addColumn("�ۼ��ۼ�");

	}

}