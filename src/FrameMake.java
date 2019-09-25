import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.Date;
import java.util.LinkedList;

public class FrameMake {

	private JFrame frame;
	static CardLayout cards = new CardLayout();
	static JPanel concards = new JPanel(cards);
	Login log = new Login();
	MainPage MPage = new MainPage();
	WorkTableManager WorkTMPage = new WorkTableManager();
	ChangeWeekTable ChangeWeekTPage = new ChangeWeekTable();
	AccountManager AccountManagerPage = new AccountManager();
	AnnouncementManager AnnouncementManagerPage = new AnnouncementManager();
	ChangeAnnouncement ChangeAnnouncementPage = new ChangeAnnouncement();
	ChangePassword ChangePasswordPage = new ChangePassword();
	ChangePersonalData ChangePersonalDataPage = new ChangePersonalData();
	ChangeWorkTable ChangeWorkTablePage = new ChangeWorkTable();
	CheckAnnouncement CheckAnnouncementPage = new CheckAnnouncement();
	CheckWeekTable CheckWeekTablePage = new CheckWeekTable();
	CheckPersonalData CheckPersonalDataPage = new CheckPersonalData();
	DeleteAccount DeleteAccountPage = new DeleteAccount();
	DeleteAnnouncement DeleteAnnouncementPage = new DeleteAnnouncement();
	DeleteWorkTable DeleteWorkTablePage = new DeleteWorkTable();
	EmailSent EmailSentPage = new EmailSent();
	NewAccount NewAccountPage = new NewAccount();
	NewAnnouncement NewAccouncementPage = new NewAnnouncement();
	NewWorkTable NewWorkTablePage = new NewWorkTable();
	NormalAccountManager NormalAccountManagerPage = new NormalAccountManager();
	NormalChangePassword NormalChangePasswordPage = new NormalChangePassword();
	NormalMain NormalMainPage = new NormalMain();
	WorkTime WorkTimePage = new WorkTime();
	Processor processor = new Processor();
    Date date = new Date();
    Email email = new Email();
    static LinkedList<LinkedList<String>> scheldules = Processor.getScheldules();
    static LinkedList<Employee> employees = Processor.getEmployees();
	
	/*
	 * store every panel
	 */
	public void addComponentToPane(Container pane) {
        

         
        //Create the panel that contains the "cards".
		concards.add(log.LoginPage,"Login"); 
		concards.add(MPage.MainPage,"MainPage");
		concards.add(WorkTMPage.WorkTableManager,"WorkTableManager");
		concards.add(ChangeWeekTPage.ChangeWeekTable,"ChangeWeekTable");
		concards.add(AccountManagerPage.AccountManager,"AccountManager");
		concards.add(AnnouncementManagerPage.AnnouncementManager,"AnnouncementManager");
		concards.add(ChangeAnnouncementPage.ChangeAnnouncementPage,"ChangeAnnouncementPage");
		concards.add(ChangePasswordPage.ChangePasswordPage,"ChangePasswordPage");
		concards.add(ChangePersonalDataPage.ChangePersonalDataPage,"ChangePersonalDataPage");
		concards.add(ChangeWorkTablePage.ChangeWorkTable,"ChangeWorkTable");
		concards.add(CheckAnnouncementPage.CheckAnnouncementPage,"CheckAnnouncementPage");
		concards.add(CheckWeekTablePage.CheckWeekTable,"CheckWeekTable");
		concards.add(CheckPersonalDataPage.CheckPersonalDataPage,"CheckPersonalDataPage");
		concards.add(DeleteAccountPage.DeleteAccountPage,"DeleteAccountPage");
		concards.add(DeleteAnnouncementPage.DeleteAnnouncementPage,"DeleteAnnouncementPage");
		concards.add(DeleteWorkTablePage.DeleteWorkTablePage,"DeleteWorkTablePage");
		concards.add(EmailSentPage.EmailSentPage,"EmailSentPage");
		concards.add(NewAccountPage.NewAccountPage,"NewAccountPage");
		concards.add(NewAccouncementPage.NewAnnouncementPage,"NewAnnouncementPage");
		concards.add(NewWorkTablePage.NewWorkTable,"NewWorkTable");
		concards.add(NormalAccountManagerPage.NormalAccountManager,"NormalAccountManager");
		concards.add(NormalChangePasswordPage.NormalChangePasswordPage,"NormalChangePasswordPage");
		concards.add(NormalMainPage.NormalMain,"NormalMain");
		concards.add(WorkTimePage.WorkTimePage,"WorkTimePage");
        pane.add(concards, BorderLayout.CENTER);
        cards.show(concards,"Login");
    }
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMake window = new FrameMake();
					window.frame.setVisible(true);
					window.frame.setSize(720, 720);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		MyThread MyThread = new MyThread();
		MyThread.start();
		
		
	}

	/**
	 * Create the application.
	 */
	public FrameMake() {
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