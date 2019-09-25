import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


class WindowHandle extends WindowAdapter {
	  JFrame f;
	  public WindowHandle(JFrame f) {this.f=f;}
	  public void windowClosing(WindowEvent e) {
	    int result=JOptionPane.showConfirmDialog(f,
	               "確定要結束程式嗎?",
	               "確認訊息",
	               JOptionPane.YES_NO_OPTION,
	               JOptionPane.WARNING_MESSAGE);
	    if (result==JOptionPane.YES_OPTION) {System.exit(0);}
	    }   
	  }