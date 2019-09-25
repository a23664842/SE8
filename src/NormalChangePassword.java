import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class NormalChangePassword {

	private JPasswordField passwordField;
    public JPanel NormalChangePasswordPage = new JPanel();
    Processor processor=new Processor();
	/**
	 * Create the panel.
	 */
	public NormalChangePassword() {
		NormalChangePasswordPage.setLayout(null);
		NormalChangePasswordPage.setBounds(0, 0, 720, 720);
		
		JLabel label_1 = new JLabel("密碼");
		label_1.setBounds(140, 137, 149, 41);
		NormalChangePasswordPage.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 195, 151, 25);
		NormalChangePasswordPage.add(passwordField);
		
		JButton button = new JButton("\u78BA\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.getEmployees().get(processor.getIndex()).setpassword(processor.ArrayToString(passwordField.getPassword()));
				passwordField.setText("");
				FrameMake.cards.show(FrameMake.concards,"NormalMain");
			}
		});
		button.setBounds(439, 408, 149, 58);
		NormalChangePasswordPage.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMake.cards.show(FrameMake.concards,"NormalMain");
			}
		});
		button_1.setBounds(439, 516, 149, 58);
		NormalChangePasswordPage.add(button_1);
		
		JLabel label_2 = new JLabel("更改密碼");
		label_2.setFont(new Font("細明體", Font.BOLD, 40));
		label_2.setBounds(138, 53, 237, 71);
		NormalChangePasswordPage.add(label_2);

	}
}
