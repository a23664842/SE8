import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;

public class Processor {
	Calendar cal=Calendar.getInstance(); 
	private static boolean employeeOrboss;
	private static int index;
	private static int chosen_one_index;
	private static LinkedList<Employee> employees = new LinkedList();
	private static LinkedList<Boss> bosses = new LinkedList();
	private LinkedList<String> schelduleemployee = new LinkedList();
	private static LinkedList<String> announcementtitle = new LinkedList();
	private static LinkedList<String> announcementtext = new LinkedList();
	private static LinkedList<LinkedList<String>> scheldules = new LinkedList();
	private static int realweek;
	private static LinkedList<String> checkornot = new LinkedList();

	Scheldule scheldule = new Scheldule();
	
	public LinkedList<String> getSchelduleemployee() {
		return schelduleemployee;
	}
	
	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		Processor.index = index;
	}

	public boolean isEmployeeOrboss() {		//true means employee
		return employeeOrboss;
	}

	public void setEmployeeOrboss(boolean employeeOrboss) {
		this.employeeOrboss = employeeOrboss;
	}

	public String ArrayToString(char array[]) {
	String b="";
	for(int i=0;i<array.length;i++) {
		b=b+array[i]; 
	}
	return b;
	}

	public static LinkedList<Employee> getEmployees() {
		return employees;
	}

	public static LinkedList<Boss> getBosses() {
		return bosses;
	}
	
	public boolean read() {
		
		try  {
			BufferedReader bossbr = new BufferedReader(new FileReader("Boss.siban"));
			BufferedReader employeebr = new BufferedReader(new FileReader("Employee.siban"));
			BufferedReader checkornotbr = new BufferedReader(new FileReader("Check.siban"));
			String[] checkornotarray = new String[720];
			String currentstring;
			String[] bstringarray= new String[5];
			String[] estringarray= new String[8];
			String[] sestringarray= new String[40];
			
			while ((currentstring = bossbr.readLine()) != null) {
				bstringarray=currentstring.split(" ");
				
					String name = bstringarray[0];
					String email = bstringarray[1];
					String phone = bstringarray[2];
					String password = bstringarray[3];
					String account = bstringarray[4];
					
					bosses.add(new Boss(name, email, phone, password,account));

			}
			while ((currentstring = employeebr.readLine()) != null) {
				estringarray=currentstring.split(" ");
				
				String name = estringarray[0];
				String email = estringarray[1];
				String phone = estringarray[2];
				String password = estringarray[3];
				int salary = Integer.parseInt(estringarray[4]);
				int worktime = Integer.parseInt(estringarray[5]);
				int warningpoint = Integer.parseInt(estringarray[6]);
				String ID = estringarray[7];
				
				employees.add(new Employee(name, email, phone, password, salary, worktime, warningpoint, ID));
			
			}
			for(int week=0;week<18;week++) {
				schelduleemployee = new LinkedList();
				String weekschelduename = "scheldue"+(week+1)+".siban";
				BufferedReader semployeebr = new BufferedReader(new FileReader(weekschelduename));
				schelduleemployee.clear();
				for(int index=0;index<40;index++) {
					schelduleemployee.add(Integer.toString(index));
				}
			int i=0;				
			while ((currentstring = semployeebr.readLine()) != null) {
				sestringarray=currentstring.split("\t");
				
					for(int j=0;j<5;j++) {
						int match =0;
						for(int k=0;k<employees.size();k++) {
							if(sestringarray[j].equalsIgnoreCase(employees.get(k).getname()))
								match++;
						}
						if(match!=0) {
						schelduleemployee.set(i+j*8,sestringarray[j]);
						
						}
						else
						schelduleemployee.set(i+j*8,"µL");
					}
				i++;
			}
			scheldules.add(schelduleemployee);	
			}
			cal.setTime(new Date());
			setRealweek(cal.get(Calendar.WEEK_OF_YEAR)-9);
			if(getRealweek()<18) {
			schelduleemployee=scheldules.get(getRealweek());
			}
			else {
				JOptionPane.showMessageDialog(null, "©ñ°²¤¤!");
			}
			
			while ((currentstring = checkornotbr.readLine()) != null) {
				checkornotarray=currentstring.split("\t");	
				checkornot.add(checkornotarray[0]);

				}
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean saveEmployees() {
			try {
				PrintWriter ef = new PrintWriter(new FileOutputStream("Employee.siban"));
				for(int i=0;i<employees.size();i++) {
					ef.println(employees.get(i).getname()+" "+employees.get(i).getemail()+" "+employees.get(i).getphone()
							+" "+employees.get(i).getpassword()+" "+employees.get(i).getsalary()+" "+
							employees.get(i).getworktime()+" "+employees.get(i).getwarningpoint()
							+" "+employees.get(i).getID());
					
				}
				ef.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return false;
			}		
			return true;
	}
	
	public boolean saveBosses() {
		try {
			PrintWriter bf = new PrintWriter(new FileOutputStream("Boss.siban"));
			for(int i=0;i<bosses.size();i++) {
				bf.println(bosses.get(i).getname()+" "+bosses.get(i).getemail()+" "+bosses.get(i).getphone()
						+" "+bosses.get(i).getpassword()+" "+bosses.get(i).getaccount());
			}	
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
	public boolean saveCheck() {
		try {
			PrintWriter bf = new PrintWriter(new FileOutputStream("Check.siban"));
			for(int i=0;i<checkornot.size();i++) {
			bf.println(checkornot.get(i));
			}
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	public static int getChosen_one_index() {
		return chosen_one_index;
	}

	public static void setChosen_one_index(int chosen_one_index) {
		Processor.chosen_one_index = chosen_one_index;
	}
	
	public void updatelist() {
		saveEmployees();
		saveBosses();
		scheldule.fileprint(scheldules);
		saveCheck();
		schelduleemployee.clear();
		bosses.clear();
		employees.clear();
		scheldules.clear();
		checkornot.clear();
		read();
		saveEmployees();
		saveBosses();		
		scheldule.fileprint(scheldules);
		saveCheck();
		
	}

	public static LinkedList<String> getAnnouncementtitle() {
		return announcementtitle;
	}

	public static void setAnnouncementtitle(LinkedList<String> announcementtitle) {
		Processor.announcementtitle = announcementtitle;
	}

	public static LinkedList<String> getAnnouncementtext() {
		return announcementtext;
	}

	public static void setAnnouncementtext(LinkedList<String> announcementtext) {
		Processor.announcementtext = announcementtext;
	}

	public static LinkedList<LinkedList<String>> getScheldules() {
		return scheldules;
	}

	public static void setScheldules(LinkedList<LinkedList<String>> scheldules) {
		Processor.scheldules = scheldules;
	}

	public static int getRealweek() {
		return realweek;
	}

	public static void setRealweek(int realweek) {
		Processor.realweek = realweek;
	}

	public static LinkedList<String> getCheckornot() {
		return checkornot;
	}

	public static void setCheckornot(LinkedList<String> checkornot) {
		Processor.checkornot = checkornot;
	}

	
	
}

	
