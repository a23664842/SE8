import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckPersonalData{
    public JPanel CheckPersonalDataPage = new JPanel();
    Processor processor = new Processor();
    int i=0;
	/**
	 * Create the panel.
	 */
	public CheckPersonalData() {
		CheckPersonalDataPage.setLayout(null);
		CheckPersonalDataPage.setBounds(0, 0, 720, 720);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(97, 137, 149, 41);
		CheckPersonalDataPage.add(label);
		
		JLabel label_1 = new JLabel("員工信箱");
		label_1.setBounds(97, 407, 263, 41);
		CheckPersonalDataPage.add(label_1);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(processor.isEmployeeOrboss())
					FrameMake.cards.show(FrameMake.concards,"NormalMain");	
				else
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(439, 516, 149, 58);
		CheckPersonalDataPage.add(button_1);
		
		JLabel label_2 = new JLabel("個人資料");
		label_2.setFont(new Font("細明體", Font.BOLD, 40));
		label_2.setBounds(87, 53, 296, 71);
		CheckPersonalDataPage.add(label_2);
		
		JLabel lblName = new JLabel("員工姓名");
		lblName.setBounds(97, 191, 215, 41);
		CheckPersonalDataPage.add(lblName);
		
		JLabel label_3 = new JLabel("員工電話");
		label_3.setBounds(97, 299, 215, 41);
		CheckPersonalDataPage.add(label_3);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setBounds(97, 353, 149, 41);
		CheckPersonalDataPage.add(label_4);
		
		JButton button = new JButton("上一頁");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=i>0?i-1:processor.getEmployees().size()-1;
				label_1.setText(processor.getEmployees().get(i).getemail());
				lblName.setText(processor.getEmployees().get(i).getname());
				label_3.setText(processor.getEmployees().get(i).getphone());
			}
		});
		button.setBounds(439, 336, 149, 58);
		CheckPersonalDataPage.add(button);
		
		JButton button_2 = new JButton("下一頁");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				i=i<processor.getEmployees().size()-1?i+1:0;
				label_1.setText(processor.getEmployees().get(i).getemail());
				lblName.setText(processor.getEmployees().get(i).getname());
				label_3.setText(processor.getEmployees().get(i).getphone());
					
			}
		});
		button_2.setBounds(439, 407, 149, 58);
		CheckPersonalDataPage.add(button_2);
		
		JLabel label_5 = new JLabel("\u96FB\u8A71");
		label_5.setBounds(97, 245, 149, 41);
		CheckPersonalDataPage.add(label_5);

	}
}