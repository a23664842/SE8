import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.text.*;

public class Login {

		public JPanel LoginPage = new JPanel();
		private JPasswordField passwordField;
	    private JScrollPane scrollPane;
	    Processor processor = new Processor();
	    private JTable table=new JTable();;
	    private DefaultTableModel defaultTableModel=null;
	    
		public Login() {
			try {
				processor.read();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "讀取檔案失敗!");
			}
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
			LoginPage.setLayout(null);
			LoginPage.setBounds(0, 0, 720, 720);
			
			LimitedDocument limitedPassword = new LimitedDocument(10);
			limitedPassword.setAllowChar("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
					+ "abcdefghijklmnopqrstuvwxyz");
			passwordField = new JPasswordField();
			passwordField.setBounds(582, 222, 106, 25);
			LoginPage.add(passwordField);
			passwordField.setDocument(limitedPassword);
			
			LimitedDocument limitedAccount = new LimitedDocument(10);
			limitedAccount.setAllowChar("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
					+ "abcdefghijklmnopqrstuvwxyz");
			JFormattedTextField formattedTextField = new JFormattedTextField();
			formattedTextField.setDocument(limitedAccount);
			formattedTextField.setBounds(582, 159, 106, 25);

			LoginPage.add(formattedTextField);
			NormalMain normalMain = new NormalMain();
			JButton btnNewButton = new JButton("登入");

			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean loginfailed = true;
					for(int i=0;i<processor.getEmployees().size();i++) {
					if(formattedTextField.getText().equalsIgnoreCase(processor.getEmployees().get(i).getID())
							&&processor.ArrayToString(passwordField.getPassword()).
							equalsIgnoreCase(processor.getEmployees().get(i).getpassword())) {
						processor.setIndex(i);
						loginfailed = false;
						processor.setEmployeeOrboss(true);
						formattedTextField.setText("");
						passwordField.setText("");
						normalMain.check();
						FrameMake.cards.show(FrameMake.concards,"NormalMain");
					
					}}
					for(int i=0;i<processor.getBosses().size();i++) {
						if(formattedTextField.getText().equalsIgnoreCase(processor.getBosses().get(i).getaccount())
								&&processor.ArrayToString(passwordField.getPassword()).
								equalsIgnoreCase(processor.getBosses().get(i).getpassword())) {
						processor.setIndex(i);
						loginfailed = false;
						processor.setEmployeeOrboss(false);
						formattedTextField.setText("");
						passwordField.setText("");
						FrameMake.cards.show(FrameMake.concards,"MainPage");
					
					}}
					if(loginfailed)
						JOptionPane.showMessageDialog(null, "帳號或密碼錯誤!");
				}
			});
			btnNewButton.setBounds(582, 270, 106, 32);
			LoginPage.add(btnNewButton);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(64, 79, 482, 513);
			LoginPage.add(scrollPane);
			
			
			
			
			scrollPane.setViewportView(table);
			
			table.setRowSelectionAllowed(false);
			table.setEnabled(false);
			table.setRowHeight(61);
			
			JLabel lblNewLabel = new JLabel("系辦工讀班表");
			lblNewLabel.setBounds(65, 29, 201, 43);
			lblNewLabel.setFont(new Font("細明體", Font.BOLD, 30));
			LoginPage.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("帳號");
			lblNewLabel_1.setBounds(582, 126, 106, 32);
			LoginPage.add(lblNewLabel_1);
			
			JLabel label = new JLabel("\u5BC6\u78BC");
			label.setBounds(582, 197, 106, 25);
			LoginPage.add(label);
			JButton reflashButton=new JButton("更新");
		     reflashButton.addMouseListener(new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) { reflash(); }
		     });
		     reflashButton.setBounds(582, 350, 106, 32);
		     LoginPage.add(reflashButton);
			
		}
		
		
	public void SetTable(Object[][] rowData, Object[] columnNames){
		table = new JTable(rowData,columnNames);
		LoginPage.add(table);
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