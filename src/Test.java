import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
	private JFrame frame;
	static CardLayout cards = new CardLayout();
	static JPanel concards = new JPanel(cards);
	MainPage MPage = new MainPage();
	public void addComponentToPane(Container pane) {
		concards.add(MPage.MainPage,"MainPage");
		pane.add(concards, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
					window.frame.setSize(720, 720);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Test() {
		createAndShowGUI();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addComponentToPane(frame.getContentPane());
        WindowHandle window = new WindowHandle(frame);
        frame.addWindowListener(window);
        
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }	

}
