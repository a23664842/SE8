import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class ChangeWeekTable {
	public JPanel ChangeWeekTable = new JPanel();
	JComboBox c = new JComboBox();
	DefaultComboBoxModel comboBoxModelmodel = new DefaultComboBoxModel();
    private JScrollPane scrollPane;
    Processor processor = new Processor();
    private JTable table=new JTable();
    private DefaultTableModel defaultTableModel=null;
    JComboBox c2 = new JComboBox();
	DefaultComboBoxModel comboBoxModelmodel2 = new DefaultComboBoxModel();
	/**
	 * Launch the application.
	 */
	
	public ChangeWeekTable() {	
		ChangeWeekTable.setLayout(null);
		ChangeWeekTable.setBounds(0, 0, 720, 720);
		
		c2.setBounds(0, 0, 149, 31);
		ChangeWeekTable.add(c2);
		
		c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c2.getSelectedIndex()>=0&&c2.getSelectedIndex()<18) {
					reflash();
				}
			}
		});
		
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
		
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(c));
		table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(c));
		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(c));
		table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(c));
        table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(c));
		table.setCellSelectionEnabled(true);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(64, 79, 482, 513);
		ChangeWeekTable.add(scrollPane);
		
		table.setRowSelectionAllowed(false);
		table.setEnabled(true);
		table.setRowHeight(61);
		
		
		JLabel lblNewLabel = new JLabel("調班");
		lblNewLabel.setBounds(65, 29, 201, 43);
		lblNewLabel.setFont(new Font("細明體", Font.BOLD, 50));
		ChangeWeekTable.add(lblNewLabel);
		
		JButton button = new JButton("確定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				processor.getScheldules().get(c2.getSelectedIndex()).clear();
				for(int i=0;i<5;i++) {
					for(int j=0;j<8;j++) {
						processor.getScheldules().get(c2.getSelectedIndex()).add(table.getValueAt(j, i).toString());
					}
				}
				processor.updatelist();
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button.setBounds(560, 537, 137, 55);
		ChangeWeekTable.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(560, 457, 137, 50);
		ChangeWeekTable.add(button_1);
		JButton reflashButton=new JButton("更新");
	     reflashButton.addMouseListener(new MouseAdapter() {
	     public void mouseClicked(MouseEvent e) { reflash();ChangeWeekTableGetList(); }
	     });
	     reflashButton.setBounds(560, 220, 137, 50);
	     ChangeWeekTable.add(reflashButton);
	}
	
	private void reflash(){
		if(c2.getSelectedIndex()>=0&&c2.getSelectedIndex()<18) {
		for(int i=0;i<processor.getScheldules().get(c2.getSelectedIndex()).size();) {
			for(int r=0;r<5;r++) {
				for(int c=0;c<8;c++) {
					defaultTableModel.setValueAt(processor.getScheldules().get(c2.getSelectedIndex()).get(i), c, r);
						i++;
				}
			}
		}
		}
	}
	
	public void ChangeWeekTableGetList() {
		c.removeAllItems();
		for(int i=0;i<processor.getEmployees().size();i++) {
			c.addItem(processor.getEmployees().get(i).getname());
		}
		c.addItem("無");
		c2.removeAllItems();
		for(int i=0;i<18;i++) {
			c2.addItem(Integer.toString(i+1));
		}
	}
}
