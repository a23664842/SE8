import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.*;
import javax.swing.table.*;
import java.awt.event.*;



public class MainPage {

	public JPanel MainPage = new JPanel();
    private JScrollPane scrollPane;
    static Processor processor=new Processor();
    private JTable table=new JTable();;
    private DefaultTableModel defaultTableModel=null;

	/**
	 * Launch the application.
	 */
	
	public MainPage() {
		
		JLabel lblNewLabel = new JLabel("系辦工讀班表");
	    JLabel label = new JLabel("\u6B61\u8FCE\u767B\u5165");
	    JButton button = new JButton("帳號管理");
	    JButton button_1 = new JButton("班表管理");
	    JButton button_2 = new JButton("Email寄送");
	    JButton button_3 = new JButton("公告管理");
		MainPage.setLayout(null);
		MainPage.setBounds(0, 0, 720, 720);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 79, 482, 513);
		MainPage.add(scrollPane);
		

		
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
		scrollPane.setViewportView(table);
		
		table.setRowSelectionAllowed(false);
		table.setEnabled(true);
		table.setRowHeight(61);
		
		
		lblNewLabel.setBounds(65, 29, 201, 43);
		lblNewLabel.setFont(new Font("細明體", Font.BOLD, 30));
		MainPage.add(lblNewLabel);
		
		
		label.setBounds(560, 13, 116, 43);
		MainPage.add(label);
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				processor.updatelist();

				FrameMake.cards.show(FrameMake.concards,"AccountManager");
	
			}
		});
		button.setBounds(560, 537, 137, 55);
		MainPage.add(button);
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.updatelist();
		
				FrameMake.cards.show(FrameMake.concards,"WorkTableManager");
			}
		});
		button_1.setBounds(560, 457, 137, 50);
		MainPage.add(button_1);
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.updatelist();
		
				FrameMake.cards.show(FrameMake.concards,"EmailSentPage");
			}
		});
		button_2.setBounds(560, 378, 137, 50);
		MainPage.add(button_2);
		
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.updatelist();
				
				FrameMake.cards.show(FrameMake.concards,"AnnouncementManager");
			}
		});
		button_3.setBounds(560, 300, 137, 50);
		MainPage.add(button_3);
		JButton reflashButton=new JButton("更新");
	     reflashButton.addMouseListener(new MouseAdapter() {
	     public void mouseClicked(MouseEvent e) { reflash(); }
	     });
	     reflashButton.setBounds(560, 220, 137, 50);
	     MainPage.add(reflashButton);
	     JButton button_4 = new JButton("登出");
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						FrameMake.cards.show(FrameMake.concards,"Login");
							processor.saveEmployees();
							
							
					} catch (Exception e2) {
						
					}
				}
			});
			button_4.setBounds(0, 600, 137, 50);
			MainPage.add(button_4);
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
}