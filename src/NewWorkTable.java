import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.util.*;

public class NewWorkTable {

	public JPanel NewWorkTable = new JPanel();
	private JTable table;
    private JScrollPane scrollPane;
    private JTextField textField;
    private LinkedList<String> schelduleemployee = new LinkedList();
    static JComboBox c = new JComboBox();
    Processor processor = new Processor();
	/**
	 * Launch the application.
	 */
	
	public NewWorkTable() {
	
		NewWorkTable.setLayout(null);
		NewWorkTable.setBounds(0, 0, 720, 720);
		
		
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{"\u7121", "\u7121", "\u7121", "\u7121", "\u7121"},
				{"\u7121", "\u7121", "\u7121", "\u7121", "\u7121"},
				{"\u7121", "\u7121", "\u7121", "\u7121", "\u7121"},
				{"\u7121", "\u7121", "\u7121", "\u7121", "\u7121"},
				{"\u7121", "\u7121", "\u7121", "\u7121", "\u7121"},
				{"\u7121", "\u7121", "\u7121", "\u7121", "\u7121"},
				{"\u7121", "\u7121", "\u7121", "\u7121", "\u7121"},
				{"\u7121", "\u7121", "\u7121", "\u7121", "\u7121"},
			},
			new String[] {
				"\u661F\u671F\u4E00", "\u661F\u671F\u4E8C", "\u661F\u671F\u4E09", "\u661F\u671F\u56DB", "\u661F\u671F\u4E94"
			}
		)) ;
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(c));
		table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(c));
		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(c));
		table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(c));
        table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(c));
		table.setCellSelectionEnabled(true);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(65, 172, 482, 513);
		NewWorkTable.add(scrollPane);
		
		table.setRowSelectionAllowed(false);
		table.setEnabled(true);
		table.setRowHeight(61);
		
		
		JLabel lblNewLabel = new JLabel("新增班表");
		lblNewLabel.setBounds(65, 29, 256, 43);
		lblNewLabel.setFont(new Font("細明體", Font.BOLD, 50));
		NewWorkTable.add(lblNewLabel);
		
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
		button.setBounds(561, 630, 137, 55);
		NewWorkTable.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameMake.cards.show(FrameMake.concards,"MainPage");
			}
		});
		button_1.setBounds(561, 550, 137, 50);
		NewWorkTable.add(button_1);
		
		JLabel label = new JLabel("學期班表");
		
		JButton reflashButton=new JButton("更新");
	     reflashButton.addMouseListener(new MouseAdapter() {
	     public void mouseClicked(MouseEvent e) { NewWorkTableGetList(); }
	     });
	     reflashButton.setBounds(560, 220, 137, 50);
	     NewWorkTable.add(reflashButton);
	}
	
	public void NewWorkTableGetList() {
		c.removeAllItems();
		for(int i=0;i<processor.getEmployees().size();i++) {
			c.addItem(processor.getEmployees().get(i).getname());
			}
	}
}