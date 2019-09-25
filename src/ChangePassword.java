import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ChangePassword{
	private JPasswordField passwordField;
    public JPanel ChangePasswordPage = new JPanel();
    Processor processor = new Processor();
    static JComboBox comboBox = new JComboBox();
    DefaultComboBoxModel model = new DefaultComboBoxModel();
	/**
	 * Create the panel.
	 */
	public ChangePassword() {
		ChangePasswordPage.setLayout(null);
		ChangePasswordPage.setBounds(0, 0, 720, 720);
		
		JLabel label = new JLabel("\u5E33\u865F");
		label.setBounds(138, 137, 149, 41);
		ChangePasswordPage.add(label);
		
		JLabel label_1 = new JLabel("密碼");
		label_1.setBounds(138, 255, 149, 41);
		ChangePasswordPage.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 313, 151, 25);
		ChangePasswordPage.add(passwordField);
		
		comboBox.setBounds(138, 191, 149, 31);
		ChangePasswordPage.add(comboBox);
		
		JButton button = new JButton("\u78BA\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.getEmployees().get(comboBox.getSelectedIndex()).setpassword(processor.ArrayToString(passwordField.getPassword()));
				processor.updatelist();
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button.setBounds(439, 408, 149, 58);
		ChangePasswordPage.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(processor.isEmployeeOrboss())
					FrameMake.cards.show(FrameMake.concards,"NormalMain");	
				else
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(439, 516, 149, 58);
		ChangePasswordPage.add(button_1);
		
		JLabel label_2 = new JLabel("更改密碼");
		label_2.setFont(new Font("細明體", Font.BOLD, 40));
		label_2.setBounds(138, 53, 237, 71);
		ChangePasswordPage.add(label_2);
		}
	
	public void ChangePasswordPageGetList() {
		model.removeAllElements();
		for(int i=0;i<processor.getEmployees().size();i++) {
			model.addElement(processor.getEmployees().get(i).getname());
			}
		comboBox.setModel(model);
	}
}
