import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class NewAccount {
	private JTextField textField;
	private JPasswordField passwordField;
    public JPanel NewAccountPage = new JPanel();
    Processor processor = new Processor();
	/**
	 * Create the panel.
	 */
	public NewAccount() {
		NewAccountPage.setLayout(null);
		NewAccountPage.setBounds(0, 0, 720, 720);
		
		JLabel label = new JLabel("\u5E33\u865F");
		label.setBounds(138, 137, 149, 41);
		NewAccountPage.add(label);
		
		JLabel label_1 = new JLabel("±K½X");
		label_1.setBounds(138, 255, 149, 41);
		NewAccountPage.add(label_1);
		
		LimitedDocument limitedAccount = new LimitedDocument(10);
		limitedAccount.setAllowChar("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcdefghijklmnopqrstuvwxyz");
		textField = new JTextField();
		textField.setDocument(limitedAccount);
		textField.setBounds(138, 191, 149, 25);
		NewAccountPage.add(textField);
		textField.setColumns(10);
		
		LimitedDocument limitedPassword = new LimitedDocument(10);
		limitedPassword.setAllowChar("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcdefghijklmnopqrstuvwxyz");
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 313, 151, 25);
		passwordField.setDocument(limitedPassword);
		NewAccountPage.add(passwordField);
		
		JButton button = new JButton("\u78BA\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.getEmployees().add(new Employee(textField.getText(),processor.ArrayToString(passwordField.getPassword())));
				processor.saveEmployees();
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button.setBounds(439, 408, 149, 58);
		NewAccountPage.add(button);
		
		JButton button_1 = new JButton("ªð¦^");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(processor.isEmployeeOrboss())
					FrameMake.cards.show(FrameMake.concards,"NormalMain");	
				else
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(439, 516, 149, 58);
		NewAccountPage.add(button_1);
		
		JLabel label_2 = new JLabel("\u65B0\u589E\u5E33\u865F");
		label_2.setFont(new Font("²Ó©úÅé", Font.BOLD, 40));
		label_2.setBounds(138, 53, 237, 71);
		NewAccountPage.add(label_2);

	}
}
