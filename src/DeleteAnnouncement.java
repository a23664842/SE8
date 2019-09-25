import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeleteAnnouncement {

	public JPanel DeleteAnnouncementPage = new JPanel();
	static JComboBox comboBox = new JComboBox();
    DefaultComboBoxModel model = new DefaultComboBoxModel();
	Processor processor = new Processor();
	/**
	 * Create the panel.
	 */
	public DeleteAnnouncement() {
		DeleteAnnouncementPage.setLayout(null);
		DeleteAnnouncementPage.setBounds(0, 0, 720, 720);
		
		JLabel label = new JLabel("公告");
		label.setBounds(138, 137, 149, 41);
		DeleteAnnouncementPage.add(label);
		
		comboBox.setBounds(138, 191, 149, 31);
		DeleteAnnouncementPage.add(comboBox);
		
		JButton button = new JButton("\u78BA\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.getAnnouncementtitle().remove(comboBox.getSelectedIndex());
				processor.getAnnouncementtext().remove(comboBox.getSelectedIndex());
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button.setBounds(439, 408, 149, 58);
		DeleteAnnouncementPage.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(439, 516, 149, 58);
		DeleteAnnouncementPage.add(button_1);
		
		JLabel label_2 = new JLabel("刪除公告");
		label_2.setFont(new Font("細明體", Font.BOLD, 40));
		label_2.setBounds(138, 53, 237, 71);
		DeleteAnnouncementPage.add(label_2);

	}
	
	public void DeleteAnnouncementGetList() {
		model.removeAllElements();
		for(int i=0;i<processor.getAnnouncementtitle().size();i++){
			model.addElement(processor.getAnnouncementtitle().get(i));
			}
		comboBox.setModel(model);
	}
}
