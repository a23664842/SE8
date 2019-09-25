import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;

public class DeleteAccount  {
    public JPanel DeleteAccountPage = new JPanel();
    static JComboBox comboBox = new JComboBox();
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    Processor processor = new Processor();
	/**
	 * Create the panel.
	 */
	public DeleteAccount() {
		DeleteAccountPage.setLayout(null);
		DeleteAccountPage.setBounds(0, 0, 720, 720);
		
		JLabel label = new JLabel("\u5E33\u865F");
		label.setBounds(138, 137, 149, 41);
		DeleteAccountPage.add(label);	
		comboBox.setBounds(138, 191, 149, 31);
		DeleteAccountPage.add(comboBox);
		
		JButton button = new JButton("\u78BA\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.getEmployees().remove(comboBox.getSelectedIndex());
				processor.updatelist();
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button.setBounds(439, 408, 149, 58);
		DeleteAccountPage.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(439, 516, 149, 58);
		DeleteAccountPage.add(button_1);
		
		JLabel label_2 = new JLabel("刪除帳號");
		label_2.setFont(new Font("細明體", Font.BOLD, 40));
		label_2.setBounds(138, 53, 237, 71);
		DeleteAccountPage.add(label_2);
		}
	
	public void DeleteAccountPageGetList() {
		model.removeAllElements();
		for(int i=0;i<processor.getEmployees().size();i++) {
			model.addElement(processor.getEmployees().get(i).getname());
			}
		comboBox.setModel(model);
	}
}
