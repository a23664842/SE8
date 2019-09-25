import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EmailSent{

	/**
	 * Create the panel.
	 */
	JPanel EmailSentPage = new JPanel();
	Processor processor = new Processor();
	Email email = new Email();
	public EmailSent() {
		EmailSentPage.setLayout(null);
		EmailSentPage.setBounds(0, 0, 720, 720);
		
		JLabel label_1 = new JLabel("郵件內容");
		label_1.setBounds(72, 100, 149, 41);
		EmailSentPage.add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(72, 154, 448, 517);
		EmailSentPage.add(textArea);
		
		JButton button = new JButton("\u78BA\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String destination = null;
				String text =textArea.getText();
				  for(int i=1;i<processor.getEmployees().size();i++) {
					  destination = processor.getEmployees().get(0).getemail();
						email.Send(text,destination);
				  }

				
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button.setBounds(541, 505, 149, 58);
		EmailSentPage.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(processor.isEmployeeOrboss())
					FrameMake.cards.show(FrameMake.concards,"NormalMain");	
				else
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(541, 613, 149, 58);
		EmailSentPage.add(button_1);
		
		JLabel label_2 = new JLabel("寄送郵件");
		label_2.setFont(new Font("細明體", Font.BOLD, 40));
		label_2.setBounds(72, 37, 237, 71);
		EmailSentPage.add(label_2);
	}
	}


