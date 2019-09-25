import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class AccountManager{
	Processor processor = new Processor();
	ChangePassword changepassword = new ChangePassword();
	DeleteAccount deleteaccount = new DeleteAccount();
	/**
	 * Create the panel.
	 */
	public JPanel AccountManager = new JPanel();
	public AccountManager() {
		AccountManager.setLayout(null);
		AccountManager.setBounds(0, 0, 720, 720);
		
		JButton btnNewButton = new JButton("\u65B0\u589E\u5E33\u865F");
		btnNewButton.setFont(new Font("細明體", Font.BOLD, 40));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrameMake.cards.show(FrameMake.concards,"NewAccountPage");
			}
		});
		btnNewButton.setBounds(95, 42, 304, 93);
		AccountManager.add(btnNewButton);
		
		JButton button = new JButton("更改密碼");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepassword.ChangePasswordPageGetList();
				FrameMake.cards.show(FrameMake.concards,"ChangePasswordPage");
			}
		});
		button.setFont(new Font("細明體", Font.BOLD, 40));
		button.setBounds(95, 177, 304, 93);
		AccountManager.add(button);
		
		JButton button_1 = new JButton("刪除帳號");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteaccount.DeleteAccountPageGetList();
				FrameMake.cards.show(FrameMake.concards,"DeleteAccountPage");
			}
		});
		button_1.setFont(new Font("細明體", Font.BOLD, 40));
		button_1.setBounds(95, 312, 304, 93);
		AccountManager.add(button_1);
		
		JButton button_2 = new JButton("修改個人資料");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMake.cards.show(FrameMake.concards,"ChangePersonalDataPage");
			}
		});
		button_2.setFont(new Font("細明體", Font.BOLD, 40));
		button_2.setBounds(95, 447, 304, 93);
		AccountManager.add(button_2);
		
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
		AccountManager.add(button_3);
		
		JButton button_4 = new JButton("查看個人資料");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameMake.cards.show(FrameMake.concards,"CheckPersonalDataPage");
			}
		});
		button_4.setFont(new Font("細明體", Font.BOLD, 40));
		button_4.setBounds(95, 582, 304, 93);
		AccountManager.add(button_4);

	}
}
