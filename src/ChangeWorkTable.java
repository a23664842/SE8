import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.*;

public class ChangeWorkTable {
	public JPanel ChangeWorkTable = new JPanel();
	private JTable table;
    private JScrollPane scrollPane;
    private JTextField textField;
    private LinkedList<String> schelduleemployee = new LinkedList();
    static JComboBox c = new JComboBox();
    Processor processor = new Processor();
	DefaultComboBoxModel comboBoxModelmodel = new DefaultComboBoxModel();
	private DefaultTableModel defaultTableModel=null;
	/**
	 * Launch the application.
	 */
	
	public ChangeWorkTable() {
	
		ChangeWorkTable.setLayout(null);
		ChangeWorkTable.setBounds(0, 0, 720, 720);

        String data[][] =new String[8][5];
		for(int i=0;i<processor.getScheldules().get(0).size();) {
			for(int r=0;r<5;r++) {
				for(int col=0;col<8;col++) {
						data [col][r]= processor.getScheldules().get(0).get(i);
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
		ChangeWorkTable.add(scrollPane);
		
		table.setRowSelectionAllowed(false);
		table.setEnabled(true);
		table.setRowHeight(61);
		
		
		JLabel lblNewLabel = new JLabel("修改班表");
		lblNewLabel.setBounds(65, 29, 256, 43);
		lblNewLabel.setFont(new Font("細明體", Font.BOLD, 50));
		ChangeWorkTable.add(lblNewLabel);
		
		JButton button = new JButton("確定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				processor.getScheldules().clear();
				for(int week=0;week<18;week++) {
					schelduleemployee=new LinkedList();
					for(int i=0;i<5;i++) {
						for(int j=0;j<8;j++) {
							schelduleemployee.add(table.getValueAt(j, i).toString());
						}
					}
					processor.getScheldules().add(schelduleemployee);
				}
				processor.updatelist();
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button.setBounds(560, 537, 137, 55);
		ChangeWorkTable.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(560, 457, 137, 50);
		ChangeWorkTable.add(button_1);
		
		JButton reflashButton=new JButton("更新");
	     reflashButton.addMouseListener(new MouseAdapter() {
	     public void mouseClicked(MouseEvent e) { reflash();ChangeWorkTableGetList(); }
	     });
	     reflashButton.setBounds(560, 220, 137, 50);
	     ChangeWorkTable.add(reflashButton);
	}
	
	private void reflash(){
		for(int i=0;i<processor.getScheldules().get(0).size();) {
			for(int r=0;r<5;r++) {
				for(int c=0;c<8;c++) {
					defaultTableModel.setValueAt(processor.getScheldules().get(0).get(i), c, r);
						i++;
				}
			}
		}
	}
	
	
	public void ChangeWorkTableGetList() {
		c.removeAllItems();
		for(int i=0;i<processor.getEmployees().size();i++) {
			c.addItem(processor.getEmployees().get(i).getname());
		}
	}
}