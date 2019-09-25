import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class NormalMain  {

	//
	public JPanel NormalMain = new JPanel();
    private DefaultTableModel model = null;
    private JScrollPane scrollPane;
    Processor processor=new Processor();
    Date date = new Date();
    private JTable table=new JTable();;
    private DefaultTableModel defaultTableModel=null;
    CheckAnnouncement checkAnnouncement = new CheckAnnouncement();
    WorkTime workTime = new WorkTime();
	JButton button_2 = new JButton("簽到");
	int check=0;
    
	/**
	 * Launch the application.
	 */
	
	public NormalMain() {
		
		NormalMain.setLayout(null);
		NormalMain.setBounds(0, 0, 720, 720);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 79, 482, 513);
		NormalMain.add(scrollPane);
		
		
		
		String data[][] =new String[8][5];
		for(int i=0;i<processor.getScheldules().get(processor.getRealweek()).size();) {
			for(int r=0;r<5;r++) {
				for(int c=0;c<8;c++) {
						data [c][r]= processor.getScheldules().get(processor.getRealweek()).get(i);
						i++;
				}
			}
		}
		
		String columnNames[] =
			{"\u661F\u671F\u4E00", "\u661F\u671F\u4E8C", "\u661F\u671F\u4E09", "\u661F\u671F\u56DB", "\u661F\u671F\u4E94"};
		defaultTableModel=new DefaultTableModel(data,columnNames);
		table = new JTable(defaultTableModel);
		table.setCellSelectionEnabled(true);
		//table.setDefaultRenderer(Object.class,new TableColor());  
		scrollPane.setViewportView(table);
		
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setRowHeight(61);
		
		JLabel lblNewLabel = new JLabel("系辦工讀班表");
		lblNewLabel.setBounds(65, 29, 201, 43);
		lblNewLabel.setFont(new Font("細明體", Font.BOLD, 30));
		NormalMain.add(lblNewLabel);
		
		JLabel label = new JLabel("\u6B61\u8FCE\u767B\u5165");
		label.setBounds(560, 13, 116, 43);
		NormalMain.add(label);
		
		JButton button = new JButton("帳號管理");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameMake.cards.show(FrameMake.concards,"NormalAccountManager");
			}
		});
		button.setBounds(560, 537, 137, 55);
		NormalMain.add(button);
		JButton button_1 = new JButton("查看工時");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				workTime.WorkTimeGetList();
				FrameMake.cards.show(FrameMake.concards,"WorkTimePage");
			}
		});
		button_1.setBounds(560, 457, 137, 50);
		NormalMain.add(button_1);
		
		JButton button_4 = new JButton("查看公告");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnnouncement.CheckAnnouncementGetList();
				FrameMake.cards.show(FrameMake.concards,"CheckAnnouncementPage");
			}
		});
		button_4.setBounds(560, 377, 137, 50);
		NormalMain.add(button_4);

		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(date.getHours()<12) {
						if(processor.getScheldules().get(processor.getRealweek()).get((date.getHours()-8)+(date.getDay()-1)*8).equalsIgnoreCase( 
								processor.getEmployees().get(processor.getIndex()).getname())&&
								(date.getMinutes()<20)) {
							processor.getEmployees().get(processor.getIndex()).setworktime();
							processor.saveEmployees();
							button_2.setEnabled(false);
							processor.getCheckornot().set(processor.getRealweek()*40+date.getHours()-8+(date.getDay()-1)*8, "true");
						}
						else JOptionPane.showMessageDialog(null, "不是簽到時間!");
					}
					else if(12<date.getHours()&&date.getHours()<17) {
						if(processor.getScheldules().get(processor.getRealweek()).get((date.getHours()-9)+(date.getDay()-1)*8).equalsIgnoreCase( 
								processor.getEmployees().get(processor.getIndex()).getname())&&
								date.getMinutes()>20&&date.getMinutes()<40) {
							processor.getEmployees().get(processor.getIndex()).setworktime();
							processor.saveEmployees();
							button_2.setEnabled(false);
							processor.getCheckornot().set(processor.getRealweek()*40+date.getHours()-9+(date.getDay()-1)*8, "true");
						}
						else JOptionPane.showMessageDialog(null, "不是簽到時間!");
					}
					else
						JOptionPane.showMessageDialog(null, "不是簽到時間!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "不是簽到時間!");
				}
			}
		});
		button_2.setBounds(560, 85, 137, 50);
		NormalMain.add(button_2);
		JButton button_3 = new JButton("登出");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					processor.setIndex(0);
					FrameMake.cards.show(FrameMake.concards,"Login");
						processor.saveEmployees();
						
						
				} catch (Exception e2) {
					
				}
			}
		});
		button_3.setBounds(0, 600, 137, 50);
		NormalMain.add(button_3);
		JButton reflashButton=new JButton("更新");
	     reflashButton.addMouseListener(new MouseAdapter() {
	     public void mouseClicked(MouseEvent e) { reflash(); }
	     });
	     reflashButton.setBounds(560, 220, 137, 50);
	     NormalMain.add(reflashButton);
}
	
	
	private void reflash(){
		for(int i=0;i<processor.getScheldules().get(processor.getRealweek()).size();) {
			for(int r=0;r<5;r++) {
				for(int c=0;c<8;c++) {
					defaultTableModel.setValueAt(processor.getScheldules().get(processor.getRealweek()).get(i), c, r);
						i++;
				}
			}
		}
	}
	
	public void check() {
		button_2.setEnabled(true);
	}
	
}