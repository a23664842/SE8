import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WorkTime  {

	public JPanel WorkTimePage = new JPanel();
	JLabel label_1 = new JLabel();
	JLabel lblName = new JLabel();
	JLabel label_3 = new JLabel();
	Processor processor = new Processor();
	/**
	 * Create the panel.
	 */
	public WorkTime() {
		WorkTimePage.setLayout(null);
		WorkTimePage.setBounds(0, 0, 720, 720);
		
		JLabel label = new JLabel("目前工時");
		label.setBounds(97, 137, 149, 41);
		WorkTimePage.add(label);
		
		label_1.setText(Integer.toString(processor.getEmployees().get(processor.getIndex()).salarycount()));
		label_1.setBounds(97, 407, 263, 41);
		WorkTimePage.add(label_1);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMake.cards.show(FrameMake.concards,"NormalMain");
			}
		});
		button_1.setBounds(439, 516, 149, 58);
		WorkTimePage.add(button_1);
		
		JLabel label_2 = new JLabel("查看工時");
		label_2.setFont(new Font("細明體", Font.BOLD, 40));
		label_2.setBounds(87, 53, 296, 71);
		WorkTimePage.add(label_2);
		
		lblName.setText(Integer.toString(processor.getEmployees().get(processor.getIndex()).getworktime()));
		lblName.setBounds(97, 191, 215, 41);
		WorkTimePage.add(lblName);
		int count=0;
		for(int week=0;week<18;week++) {
			for(int i=0;i<processor.getScheldules().get(week).size();i++) {
				if(processor.getScheldules().get(week).get(i).equalsIgnoreCase(
						processor.getEmployees().get(processor.getIndex()).getname())) {
					count++;
				}
			}
		}
		
		label_3.setText(Integer.toString(count));
		label_3.setBounds(97, 299, 215, 41);
		WorkTimePage.add(label_3);
		
		JLabel label_4 = new JLabel("本月薪資");
		label_4.setBounds(97, 353, 149, 41);
		WorkTimePage.add(label_4);
		
		JLabel label_5 = new JLabel("預計工時");
		label_5.setBounds(97, 245, 149, 41);
		WorkTimePage.add(label_5);
		
		JButton reflashButton=new JButton("更新");
	     reflashButton.addMouseListener(new MouseAdapter() {
	     public void mouseClicked(MouseEvent e) { WorkTimeGetList(); }
	     });
	     reflashButton.setBounds(560, 220, 137, 50);
	     WorkTimePage.add(reflashButton);
	}
	
	public void WorkTimeGetList() {
		int count=0;
		for(int week=0;week<18;week++) {
			for(int i=0;i<processor.getScheldules().get(week).size();i++) {
				if(processor.getScheldules().get(week).get(i).equalsIgnoreCase(
						processor.getEmployees().get(processor.getIndex()).getname())) {
					count++;
				}
			}
		}
			label_1.setText(Integer.toString(processor.getEmployees().get(processor.getIndex()).salarycount()));		
			lblName.setText(Integer.toString(processor.getEmployees().get(processor.getIndex()).getworktime()));
			label_3.setText(Integer.toString(count));			
	}
}