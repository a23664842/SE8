import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.*;

public class CheckAnnouncement{
    public JPanel CheckAnnouncementPage = new JPanel();
    Processor processor = new Processor();
    JTextArea textArea = new JTextArea();
    JLabel label_1 = new JLabel("���D�W��");
    int i=0;
	/**
	 * Create the panel.
	 */
	public CheckAnnouncement() {
		CheckAnnouncementPage.setLayout(null);
		CheckAnnouncementPage.setBounds(0, 0, 720, 720);
		
		JLabel label = new JLabel("���D");
		label.setBounds(97, 137, 149, 41);
		CheckAnnouncementPage.add(label);
		
		
		textArea.setBounds(72, 259, 448, 412);
		textArea.setEditable(false);
		CheckAnnouncementPage.add(textArea);
		
		
		label_1.setBounds(97, 191, 149, 41);
		CheckAnnouncementPage.add(label_1);
		
		JButton button_1 = new JButton("��^");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(processor.isEmployeeOrboss())
					FrameMake.cards.show(FrameMake.concards,"NormalMain");	
				
			}
		});
		button_1.setBounds(539, 516, 149, 58);
		CheckAnnouncementPage.add(button_1);
		
		JLabel label_2 = new JLabel("���i��");
		label_2.setFont(new Font("�ө���", Font.BOLD, 40));
		label_2.setBounds(87, 53, 296, 71);
		CheckAnnouncementPage.add(label_2);
		
		JButton button = new JButton("�W�@��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(processor.getAnnouncementtitle().size()==0) {
					label_1.setText("�L");
					textArea.setText("�L");
				}
				else {
				i--;
				if(i<processor.getAnnouncementtitle().size()&&i>=0){
					label_1.setText(processor.getAnnouncementtitle().get(i));
					textArea.setText(processor.getAnnouncementtext().get(i));
				}
				else {					
					i=processor.getAnnouncementtitle().size()-1;
					label_1.setText(processor.getAnnouncementtitle().get(i));
					textArea.setText(processor.getAnnouncementtext().get(i));
					
				}
				}
			}
		});
		button.setBounds(539, 336, 149, 58);
		CheckAnnouncementPage.add(button);
		JButton button_2 = new JButton("�U�@��");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(processor.getAnnouncementtitle().size()==0) {
					label_1.setText("�L");
					textArea.setText("�L");
				}
				else {
				i++;
				if(i<processor.getAnnouncementtitle().size()&&i>=0){
					label_1.setText(processor.getAnnouncementtitle().get(i));
					textArea.setText(processor.getAnnouncementtext().get(i));
					
				}
				else {
					i=0;
					label_1.setText(processor.getAnnouncementtitle().get(i));
					textArea.setText(processor.getAnnouncementtext().get(i));
					
				}
				}
			}
		});
		button_2.setBounds(539, 407, 149, 58);
		CheckAnnouncementPage.add(button_2);
	}
	
	public void CheckAnnouncementGetList() {
		if(processor.getAnnouncementtitle().size()==0) {
			label_1.setText("�L");
			textArea.setText("�L");
		}
		else {
			label_1.setText(processor.getAnnouncementtitle().get(0));
			textArea.setText(processor.getAnnouncementtext().get(0));
		}
	}
	
}