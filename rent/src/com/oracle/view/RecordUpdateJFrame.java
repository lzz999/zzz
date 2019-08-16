package com.java.ls1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Modify extends JFrame {
	private JTextField text_Job;
	private JTextField text_Name;
	private JTextField text_Id;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public Modify(final DefaultTableModel tm, final int rowNo, Record r,
			Service s) {
		getContentPane().setLayout(null);
		setSize(new Dimension(549, 443));

		final JLabel label = new JLabel();
		label.setText("\u9879\u76EE\u7F16\u53F7");
		label.setBounds(119, 70, 59, 24);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("\u4ED8\u6B3E\u91D1\u989D");
		label_1.setBounds(119, 164, 59, 24);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("\u53D1\u7968\u72B6\u6001");
		label_2.setBounds(119, 256, 87, 22);
		getContentPane().add(label_2);

		text_Id = new JTextField();
		text_Id.setText(tm.getValueAt(rowNo, 0).toString());
		text_Id.setEditable(false);
		text_Id.setBounds(317, 70, 87, 22);
		getContentPane().add(text_Id);

		text_Name = new JTextField();
		text_Name.setBounds(317, 162, 87, 22);
		getContentPane().add(text_Name);

		text_Job = new JTextField();
		text_Job.setBounds(317, 254, 87, 22);
		getContentPane().add(text_Job);

		textField = new JTextField();
		textField.setBounds(317, 116, 87, 22);
		getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setBounds(317, 208, 87, 22);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(317, 300, 87, 22);
		getContentPane().add(textField_2);
		textField.setText(tm.getValueAt(rowNo, 1).toString());
		text_Name.setText(tm.getValueAt(rowNo, 2).toString());
		textField_1.setText(tm.getValueAt(rowNo, 3).toString());
		text_Job.setText(tm.getValueAt(rowNo, 4).toString());
		textField_2.setText(tm.getValueAt(rowNo, 5).toString());

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String record_id = textField_3.getText();
				String id = text_Id.getText();
				String name = textField.getText();
				String Amount = text_Name.getText();
				String PaymentTime = textField_1.getText();
				String State = text_Job.getText();
				String Payee = textField_2.getText();

				// 2 将数据添加到表模型
				int id1 = Integer.parseUnsignedInt(record_id);
				int a = Integer.parseUnsignedInt(id);
				double amount = Double.parseDouble(Amount);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date paymentTime = null;
				try {
					paymentTime = (Date) sdf.parse(PaymentTime);
				} catch (ParseException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
				r.setRecord_id(id1);
				r.setSerialNumber(a);
				r.setPattern(name);
				r.setAmount(amount);
				r.setPaymentTime(paymentTime);
				r.setState(State);
				r.setPayee(Payee);
				r.setPayee(Payee);
				try {
					s.change(r);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				tm.setValueAt(id, rowNo, 0);
				tm.setValueAt(name, rowNo, 1);
				tm.setValueAt(amount, rowNo, 2);
				tm.setValueAt(PaymentTime, rowNo, 3);
				tm.setValueAt(State, rowNo, 4);
				tm.setValueAt(Payee, rowNo, 5);
				tm.setValueAt(id1, rowNo, 6);

			}
		});
		button.setText("确定");
		button.setBounds(213, 355, 106, 28);
		getContentPane().add(button);

		JLabel lblNewLabel = new JLabel("\u4ED8\u6B3E\u65B9\u5F0F");
		lblNewLabel.setBounds(119, 117, 59, 24);
		getContentPane().add(lblNewLabel);

		JLabel label_3 = new JLabel("\u4ED8\u6B3E\u65F6\u95F4");
		label_3.setBounds(119, 211, 87, 22);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u6536\u6B3E\u4EBA");
		label_4.setBounds(119, 301, 87, 22);
		getContentPane().add(label_4);

		JLabel label_5 = new JLabel("\u7F16\u53F7");
		label_5.setBounds(119, 23, 59, 24);
		getContentPane().add(label_5);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(317, 24, 87, 22);
		textField_3.setText(tm.getValueAt(rowNo, 6).toString());
		getContentPane().add(textField_3);

	}
}
