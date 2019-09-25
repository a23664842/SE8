import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.util.*;

public class ChangeAnnouncement {
	Processor processor = new Processor();
	static JComboBox comboBox = new JComboBox();
    DefaultComboBoxModel model = new DefaultComboBoxModel();
	/**
	 * Create the panel.
	 */
	JPanel ChangeAnnouncementPage = new JPanel();
	public ChangeAnnouncement() {
		ChangeAnnouncementPage.setLayout(null);
		ChangeAnnouncementPage.setBounds(0, 0, 720, 720);
		
		JLabel label = new JLabel("選擇公告");
		label.setBounds(72, 122, 149, 41);
		ChangeAnnouncementPage.add(label);
		
		JLabel label_1 = new JLabel("更改公告");
		label_1.setBounds(72, 206, 149, 41);
		ChangeAnnouncementPage.add(label_1);
		
		
		comboBox.setBounds(72, 168, 163, 25);
		ChangeAnnouncementPage.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(72, 259, 448, 412);
		ChangeAnnouncementPage.add(textArea);
		
		JButton button = new JButton("\u78BA\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.getAnnouncementtext().set(comboBox.getSelectedIndex(), textArea.getText());
				FrameMake.cards.show(FrameMake.concards,"MainPage");
				
			}
		});
		button.setBounds(541, 505, 149, 58);
		ChangeAnnouncementPage.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(541, 613, 149, 58);
		ChangeAnnouncementPage.add(button_1);
		
		JLabel label_2 = new JLabel("更改公告");
		label_2.setFont(new Font("細明體", Font.BOLD, 40));
		label_2.setBounds(72, 37, 237, 71);
		ChangeAnnouncementPage.add(label_2);
		
		

	}
	
	public void ChangeAnnouncementGetList() {
		model.removeAllElements();
		for(int i=0;i<processor.getAnnouncementtitle().size();i++){
			model.addElement(processor.getAnnouncementtitle().get(i));
			}
		comboBox.setModel(model);
	}
	
}


