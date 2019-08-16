package com.java.ls1;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PayRecord extends JFrame {
	Service s = new Service();
	private JTable table;

	private DefaultTableModel dtm = new DefaultTableModel();
	private Record r = new Record();

	public PayRecord() {
		setSize(500, 500);
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		final JButton button = new JButton();
		// ��
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int rowCount = dtm.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					dtm.removeRow(0);
				}
				try {
					ArrayList<Record> list = s.queryByName(dtm);
					for (Record record : list) {
						String paymentTime = new SimpleDateFormat("yyyy-MM-dd")
								.format(record.getPaymentTime());
						dtm.addRow(new Object[] { record.getSerialNumber(),
								record.getPattern(), record.getAmount(),
								paymentTime, record.getState(),
								record.getPayee(), record.getRecord_id() });
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button.setText("��ѯ");
		panel.add(button);
		final JButton button_1 = new JButton();
		// �޸�
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int no = table.getSelectedRowCount();
				if (no > 1) {
					// һ��ֻ���޸�һ��
					JOptionPane.showMessageDialog(null, "һ��ֻ���޸�һ��");
				} else if (no == 0) {
					// ��ѡ��Ҫ�޸ĵ���
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ���");
				} else {
					// ȷ��Ҫ�޸���
					int confirmNo = JOptionPane.showConfirmDialog(null,
							"ȷ��Ҫ�޸���?");
					// System.out.println(confirmNo+"....");
					if (confirmNo == 0) {
						// ���;
						int rowNo = table.getSelectedRow();// ��ȡ�е�����
						// System.out.println(rowNo);
						Modify m = new Modify(dtm, rowNo, r, s);
						m.setVisible(true);
					}
				}
			}
		});
		button_1.setText("�޸�");
		panel.add(button_1);

		final JButton button_2 = new JButton();
		// ɾ��
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int no = table.getSelectedRowCount();
				if (no > 1) {
					// һ��ֻ��ɾһ��
					JOptionPane.showMessageDialog(null, "һ��ֻ��ɾһ��");
				} else if (no == 0) {
					// ��ѡ��Ҫɾ������
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");
				} else {
					// ɾ
					int confirmNo = JOptionPane.showConfirmDialog(null,
							"ȷ��Ҫɾ����?");
					// System.out.println(confirmNo+"....");
					if (confirmNo == 0) {
						// ��ɾ
						int rowNo = table.getSelectedRow();// ��ȡ�е�����
						// System.out.println(rowNo);

						int id = (int) dtm.getValueAt(rowNo, 6);
						dtm.removeRow(rowNo);
						r.setRecord_id(id);
						int no1 = s.delete(r.getRecord_id());
						if (no1 != 0) {
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						} else {
							JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
						}
					}

				}
			}
		});
		button_2.setText("ɾ��");
		panel.add(button_2);

		JButton button_3 = new JButton("\u589E\u52A0");
		// ����
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
				Increase increase = new Increase(dtm, s);
				increase.setVisible(true);
			}
		});
		button_3.setActionCommand("\u589E\u52A0");
		panel.add(button_3);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		dtm.addColumn("��Ŀ���");
		dtm.addColumn("���ʽ");
		dtm.addColumn("������");
		dtm.addColumn("����ʱ��");
		dtm.addColumn("��Ʊ״̬");
		dtm.addColumn("�տ���");
		dtm.addColumn("���");

	}

	public static void main(String[] args) {
		new PayRecord().setVisible(true);

	}
}
