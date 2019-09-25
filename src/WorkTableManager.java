import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WorkTableManager {

	/**
	 * Create the panel.
	 */
	Processor processor = new Processor();
	public JPanel WorkTableManager = new JPanel();
	
	public WorkTableManager() {
		WorkTableManager.setLayout(null);
		WorkTableManager.setBounds(0, 0, 720, 720);
		
		JButton btnNewButton = new JButton("新增班表");
		btnNewButton.setFont(new Font("細明體", Font.BOLD, 40));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameMake.cards.show(FrameMake.concards,"NewWorkTable");
			}
		});
		btnNewButton.setBounds(95, 42, 304, 93);
		WorkTableManager.add(btnNewButton);
		
		JButton button = new JButton("更改班表");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMake.cards.show(FrameMake.concards,"ChangeWorkTable");
			}
		});
		button.setFont(new Font("細明體", Font.BOLD, 40));
		button.setBounds(95, 177, 304, 93);
		WorkTableManager.add(button);
		
		JButton button_1 = new JButton("刪除班表");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMake.cards.show(FrameMake.concards,"DeleteWorkTablePage");
			}
		});
		button_1.setFont(new Font("細明體", Font.BOLD, 40));
		button_1.setBounds(95, 312, 304, 93);
		WorkTableManager.add(button_1);
		
		JButton button_2 = new JButton("調班");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMake.cards.show(FrameMake.concards,"ChangeWeekTable");
			}
		});
		button_2.setFont(new Font("細明體", Font.BOLD, 40));
		button_2.setBounds(95, 447, 304, 93);
		WorkTableManager.add(button_2);
		
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
		button_3.setBounds(471, 609, 169, 45);
		WorkTableManager.add(button_3);
		
		JButton button_4 = new JButton("出勤狀況");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameMake.cards.show(FrameMake.concards,"CheckWeekTable");
			}
		});
		button_4.setFont(new Font("細明體", Font.BOLD, 40));
		button_4.setBounds(95, 582, 304, 93);
		WorkTableManager.add(button_4);

	}
}
