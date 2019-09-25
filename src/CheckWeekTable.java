import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CheckWeekTable  {
	public JPanel CheckWeekTable = new JPanel();
	private JTable table;
    private DefaultTableModel defaultTableModel = null;
    private JScrollPane scrollPane;
    Processor processor = new Processor();
    int week=processor.getRealweek();
    TableColor tableColor =new TableColor();
    JLabel lblNewLabel2 = new JLabel("第"+Integer.toString(processor.getRealweek()+1)+"周");
	/**
	 * Launch the application.
	 */
	
	public CheckWeekTable() {
	
		CheckWeekTable.setLayout(null);
		CheckWeekTable.setBounds(0, 0, 720, 720);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 79, 482, 513);
		CheckWeekTable.add(scrollPane);
		
		
		
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
		
		
		
		DefaultTableCellRenderer rendere = new TableColor(processor.getRealweek(), Color.BLUE, Color.PINK);
		table.getColumnModel().getColumn(0).setCellRenderer(rendere);
	    table.getColumnModel().getColumn(1).setCellRenderer(rendere);
	    table.getColumnModel().getColumn(2).setCellRenderer(rendere);
	    table.getColumnModel().getColumn(3).setCellRenderer(rendere);
	    table.getColumnModel().getColumn(4).setCellRenderer(rendere);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		table.setRowSelectionAllowed(false);
		table.setEnabled(true);
		table.setRowHeight(61);
		
		JLabel lblNewLabel = new JLabel("出勤狀況");
		lblNewLabel.setBounds(65, 29, 201, 43);
		lblNewLabel.setFont(new Font("細明體", Font.BOLD, 30));
		CheckWeekTable.add(lblNewLabel);
		
		
		lblNewLabel2.setBounds(0, 0, 201, 43);
		lblNewLabel2.setFont(new Font("細明體", Font.BOLD, 30));
		CheckWeekTable.add(lblNewLabel2);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(processor.isEmployeeOrboss())
					FrameMake.cards.show(FrameMake.concards,"NormalMain");	
				else
				FrameMake.cards.show(FrameMake.concards,"MainPage");
	
			}
		});
		button.setBounds(560, 537, 137, 55);
		CheckWeekTable.add(button);
		
		JButton button_1 = new JButton("下一頁");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				week++;
				if(week<processor.getScheldules().size()&&week>=0) {
					for(int i=0;i<processor.getScheldules().get(week).size();) {
						for(int r=0;r<5;r++) {
							for(int c=0;c<8;c++) {
								defaultTableModel.setValueAt(processor.getScheldules().get(week).get(i), c, r);
								i++;
							}
						}
					}
					DefaultTableCellRenderer rendere = new TableColor(week, Color.BLUE, Color.PINK);
					table.getColumnModel().getColumn(0).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(1).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(2).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(3).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(4).setCellRenderer(rendere);
				    lblNewLabel2.setText("第"+Integer.toString(week+1)+"周");
				}
				else {
					week=0;
					for(int i=0;i<processor.getScheldules().get(week).size();) {
						for(int r=0;r<5;r++) {
							for(int c=0;c<8;c++) {
								defaultTableModel.setValueAt(processor.getScheldules().get(week).get(i), c, r);
								i++;
							}
						}
					}
					DefaultTableCellRenderer rendere = new TableColor(week, Color.BLUE, Color.PINK);
					table.getColumnModel().getColumn(0).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(1).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(2).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(3).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(4).setCellRenderer(rendere);
				    lblNewLabel2.setText("第"+Integer.toString(week+1)+"周");
				}
			}
		});
		button_1.setBounds(560, 457, 137, 50);
		CheckWeekTable.add(button_1);
		
		JButton button_2 = new JButton("上一頁");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				week--;
				if(week<processor.getScheldules().size()&&week>=0) {
					for(int i=0;i<processor.getScheldules().get(week).size();) {
						for(int r=0;r<5;r++) {
							for(int c=0;c<8;c++) {
								defaultTableModel.setValueAt(processor.getScheldules().get(week).get(i), c, r);
								i++;
							}
						}
					}
					DefaultTableCellRenderer rendere = new TableColor(week, Color.BLUE, Color.PINK);
					table.getColumnModel().getColumn(0).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(1).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(2).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(3).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(4).setCellRenderer(rendere);
				    lblNewLabel2.setText("第"+Integer.toString(week+1)+"周");
				}
				else { 
					week=processor.getScheldules().size()-1;
					for(int i=0;i<processor.getScheldules().get(week).size();) {
						for(int r=0;r<5;r++) {
							for(int c=0;c<8;c++) {
								defaultTableModel.setValueAt(processor.getScheldules().get(week).get(i), c, r);
								i++;
							}
						}
					}
					DefaultTableCellRenderer rendere = new TableColor(week, Color.BLUE, Color.PINK);
					table.getColumnModel().getColumn(0).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(1).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(2).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(3).setCellRenderer(rendere);
				    table.getColumnModel().getColumn(4).setCellRenderer(rendere);
				    lblNewLabel2.setText("第"+Integer.toString(week+1)+"周");
				}
			}
		});
		button_2.setBounds(560, 378, 137, 50);
		CheckWeekTable.add(button_2);
	}
	
	private void reflash(){
		for(int i=0;i<processor.getScheldules().get(week).size();) {
			for(int r=0;r<5;r++) {
				for(int c=0;c<8;c++) {
					defaultTableModel.setValueAt(processor.getScheldules().get(week).get(i), c, r);
						i++;
				}
			}
		}
		DefaultTableCellRenderer rendere = new TableColor(week, Color.BLUE, Color.PINK);
		table.getColumnModel().getColumn(0).setCellRenderer(rendere);
	    table.getColumnModel().getColumn(1).setCellRenderer(rendere);
	    table.getColumnModel().getColumn(2).setCellRenderer(rendere);
	    table.getColumnModel().getColumn(3).setCellRenderer(rendere);
	    table.getColumnModel().getColumn(4).setCellRenderer(rendere);
	    lblNewLabel2.setText("第"+Integer.toString(week+1)+"周");
	}
	
}