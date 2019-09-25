import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NormalAccountManager  {

	/**
	 * Create the panel.
	 */
	public JPanel NormalAccountManager = new JPanel();
	public NormalAccountManager() {
		NormalAccountManager.setLayout(null);
		NormalAccountManager.setBounds(0, 0, 720, 720);
		
		JButton button = new JButton("更改密碼");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMake.cards.show(FrameMake.concards,"NormalChangePasswordPage");
			}
		});
		button.setFont(new Font("細明體", Font.BOLD, 40));
		button.setBounds(95, 178, 304, 93);
		NormalAccountManager.add(button);
		
		JButton button_2 = new JButton("修改個人資料");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMake.cards.show(FrameMake.concards,"ChangePersonalDataPage");
			}
		});
		button_2.setFont(new Font("細明體", Font.BOLD, 40));
		button_2.setBounds(95, 449, 304, 93);
		NormalAccountManager.add(button_2);
		
		JButton button_3 = new JButton("返回");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMake.cards.show(FrameMake.concards,"NormalMain");
			}
		});
		button_3.setFont(new Font("細明體", Font.BOLD, 30));
		button_3.setBounds(471, 609, 169, 45);
		NormalAccountManager.add(button_3);

	}
}
