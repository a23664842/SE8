import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AnnouncementManager {
	Processor processor = new Processor();
	ChangeAnnouncement changeAnnouncement = new ChangeAnnouncement();
	DeleteAnnouncement deleteAnnouncement = new DeleteAnnouncement();
		/**
		 * Create the panel.
		 */
		public JPanel AnnouncementManager = new JPanel();
		public AnnouncementManager() {
			AnnouncementManager.setLayout(null);
			AnnouncementManager.setBounds(0, 0, 720, 720);
			
			JButton btnNewButton = new JButton("新增公告");
			btnNewButton.setFont(new Font("細明體", Font.BOLD, 40));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					FrameMake.cards.show(FrameMake.concards,"NewAnnouncementPage");
				}
			});
			btnNewButton.setBounds(95, 110, 304, 93);
			AnnouncementManager.add(btnNewButton);
			
			JButton button = new JButton("更改公告");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeAnnouncement.ChangeAnnouncementGetList();
					FrameMake.cards.show(FrameMake.concards,"ChangeAnnouncementPage");
				}
			});
			button.setFont(new Font("細明體", Font.BOLD, 40));
			button.setBounds(95, 313, 304, 93);
			AnnouncementManager.add(button);
			
			JButton button_1 = new JButton("刪除公告");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteAnnouncement.DeleteAnnouncementGetList();
					FrameMake.cards.show(FrameMake.concards,"DeleteAnnouncementPage");
				}
			});
			button_1.setFont(new Font("細明體", Font.BOLD, 40));
			button_1.setBounds(95, 516, 304, 93);
			AnnouncementManager.add(button_1);
			
			JButton button_3 = new JButton("返回");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(processor.isEmployeeOrboss())
						FrameMake.cards.show(FrameMake.concards,"NormalMain");	
					else
					FrameMake.cards.show(FrameMake.concards,"MainPage");
				}
			});
			button_3.setFont(new Font("細明體", Font.BOLD, 30));
			button_3.setBounds(477, 566, 169, 45);
			AnnouncementManager.add(button_3);


	}

}
