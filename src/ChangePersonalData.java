import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ChangePersonalData{
	private JTextField textField;
    public JPanel ChangePersonalDataPage = new JPanel();
    private JTextField textField_1;
    private JTextField textField_2;
    Processor processor = new Processor();
	/**
	 * Create the panel.
	 */
	public ChangePersonalData() {
		ChangePersonalDataPage.setLayout(null);
		ChangePersonalDataPage.setBounds(0, 0, 720, 720);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(138, 137, 149, 41);
		ChangePersonalDataPage.add(label);
		
		JLabel label_1 = new JLabel("電話");
		label_1.setBounds(138, 255, 149, 41);
		ChangePersonalDataPage.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(138, 191, 149, 25);
		ChangePersonalDataPage.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u78BA\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(processor.isEmployeeOrboss()) {
					String name=processor.getEmployees().get(processor.getIndex()).getname();
					processor.getEmployees().get(processor.getIndex()).setname(textField.getText());
					processor.getEmployees().get(processor.getIndex()).setphone(textField_1.getText());
					processor.getEmployees().get(processor.getIndex()).setemail(textField_2.getText());
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					for(int i=0;i<18;i++) {
						for(int j=0;j<processor.getScheldules().get(i).size();j++) {
							if(processor.getScheldules().get(i).get(j).equalsIgnoreCase(name)) {
								processor.getScheldules().get(i).set(j, processor.getEmployees().get(processor.getIndex()).getname());
							}
						}
					}
					processor.updatelist();;
					FrameMake.cards.show(FrameMake.concards,"NormalMain");	
				}
				else {
					String name=processor.getBosses().get(processor.getIndex()).getname();
					processor.getBosses().get(processor.getIndex()).setname(textField.getText());
					processor.getBosses().get(processor.getIndex()).setphone(textField_1.getText());
					processor.getBosses().get(processor.getIndex()).setemail(textField_2.getText());
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					for(int i=0;i<18;i++) {
						for(int j=0;j<processor.getScheldules().get(i).size();j++) {
							if(processor.getScheldules().get(i).get(j).equalsIgnoreCase(name))
								processor.getScheldules().get(i).set(j, processor.getBosses().get(processor.getIndex()).getname());
						}
					}
					processor.updatelist();;
					FrameMake.cards.show(FrameMake.concards,"MainPage");
				}
		}
			});
		button.setBounds(439, 408, 149, 58);
		ChangePersonalDataPage.add(button);
		
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
		ChangePersonalDataPage.add(button_1);
		
		JLabel label_2 = new JLabel("更改個人資料");
		label_2.setFont(new Font("細明體", Font.BOLD, 40));
		label_2.setBounds(87, 53, 296, 71);
		ChangePersonalDataPage.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 418, 149, 25);
		ChangePersonalDataPage.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(138, 301, 149, 25);
		ChangePersonalDataPage.add(textField_2);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(138, 372, 149, 41);
		ChangePersonalDataPage.add(lblEmail);
		}
	
	
}