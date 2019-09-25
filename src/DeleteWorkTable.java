import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeleteWorkTable {


	public JPanel DeleteWorkTablePage = new JPanel();
	Processor processor = new Processor();
	/**
	 * Create the panel.
	 */
	public DeleteWorkTable() {
		DeleteWorkTablePage.setLayout(null);
		DeleteWorkTablePage.setBounds(0, 0, 720, 720);
		
		JButton button = new JButton("\u78BA\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<processor.getScheldules().size();i++) {
					for(int j=0;j<processor.getScheldules().get(i).size();j++) {
						processor.getScheldules().get(i).set(j,"無");
					}
				}
				processor.updatelist();
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button.setBounds(439, 408, 149, 58);
		DeleteWorkTablePage.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(439, 516, 149, 58);
		DeleteWorkTablePage.add(button_1);
		
		JLabel label_2 = new JLabel("刪除班表");
		label_2.setFont(new Font("細明體", Font.BOLD, 40));
		label_2.setBounds(138, 53, 237, 71);
		DeleteWorkTablePage.add(label_2);
		
		

	}
}
