import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewAnnouncement  {

	/**
	 * Create the panel.
	 */
	Processor processor = new Processor();
	JPanel NewAnnouncementPage = new JPanel();
	private JTextField textField;
	public NewAnnouncement() {
		NewAnnouncementPage.setLayout(null);
		NewAnnouncementPage.setBounds(0, 0, 720, 720);
		
		JLabel label = new JLabel("���i�W��");
		label.setBounds(72, 122, 149, 41);
		NewAnnouncementPage.add(label);
		
		JLabel label_1 = new JLabel("�s�W���i");
		label_1.setBounds(72, 206, 149, 41);
		NewAnnouncementPage.add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(72, 259, 448, 412);
		NewAnnouncementPage.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(72, 168, 448, 25);
		NewAnnouncementPage.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u78BA\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.getAnnouncementtitle().add(textField.getText());
				processor.getAnnouncementtext().add(textArea.getText());
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button.setBounds(541, 505, 149, 58);
		NewAnnouncementPage.add(button);
		
		JButton button_1 = new JButton("��^");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(541, 613, 149, 58);
		NewAnnouncementPage.add(button_1);
		
		JLabel label_2 = new JLabel("�s�W���i");
		label_2.setFont(new Font("�ө���", Font.BOLD, 40));
		label_2.setBounds(72, 37, 237, 71);
		NewAnnouncementPage.add(label_2);

	}
	}


