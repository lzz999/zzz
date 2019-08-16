package com.oracle.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.creter.emtity.TabltFrame;
/**
 * µÇÂ½
 * @author Administrator
 *
 */
public class RegisterJFrame extends JFrame {
	private JPasswordField passwordField;
	private JTextField textField;
	CusService ce = new CusService();
	public RegisterJFrame() {
		super();
		getContentPane().setLayout(null);

		final JLabel label = new JLabel();
		label.setText("ÓÃ»§Ãû");
		label.setBounds(91, 53, 66, 18);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(227, 51, 111, 22);
		getContentPane().add(textField);

		final JLabel label_1 = new JLabel();
		label_1.setText("ÃÜÂë");
		label_1.setBounds(91, 153, 66, 18);
		getContentPane().add(label_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(226, 151, 112, 22);
		getContentPane().add(passwordField);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				EnrollJFrame me = new EnrollJFrame();
				me.setVisible(true);
			}
		});
		button.setText("×¢²á");
		button.setBounds(61, 245, 106, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
		    String name  = textField.getText();
		    String pass = passwordField.getText();
		    Cus cus = new Cus(name,pass);
				try {
					ce.enter(cus);
					TabltFrame tf=new TabltFrame();
					tf.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
					//e1.printStackTrace();
				}
			}
		});
		button_1.setText("µÇÂ½");
		button_1.setBounds(245, 245, 106, 28);
		getContentPane().add(button_1);
	}

	
	
}