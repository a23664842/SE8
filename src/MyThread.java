import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class MyThread extends Thread {
	private static LinkedList<LinkedList<String>> scheldules = new LinkedList();
    Date date;
    Email email = new Email();
    Calendar cal=Calendar.getInstance();
    private static LinkedList<Employee> employees = new LinkedList();
    LinkedList<String> schelduleemployee = new LinkedList();

    public MyThread(){
    	this.scheldules.clear();
    	this.employees.clear();
    }

    @Override
    public void run(){
    	int i=1;
    	while(i==1) {
    	try {
    		date = new Date();
			BufferedReader employeebr = new BufferedReader(new FileReader("Employee.siban"));
			String currentstring;
			String[] estringarray= new String[8];
			String[] sestringarray= new String[40];

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
			int i2=0;				
			while ((currentstring = semployeebr.readLine()) != null) {
				sestringarray=currentstring.split("\t");
				
					for(int j=0;j<5;j++) {
						int match =0;
						for(int k=0;k<employees.size();k++) {
							if(sestringarray[j].equalsIgnoreCase(employees.get(k).getname()))
								match++;
						}
						if(match!=0) {
						schelduleemployee.set(i2+j*8,sestringarray[j]);
						
						}
						else
						schelduleemployee.set(i2+j*8,"無");
					}
				i2++;
			}
			scheldules.add(schelduleemployee);	
			}
			
    		cal.setTime(new Date());
    		int realweek=cal.get(Calendar.WEEK_OF_YEAR)-9;
    		if(date.getHours()<12&&date.getHours()>8) {
    			for(int index=0;index<employees.size();index++) {
				if(scheldules.get(realweek).get((date.getHours()-8)+(date.getDay()-1)*8).equalsIgnoreCase( 
						employees.get(index).getname())&&
						(date.getMinutes()==0)) {
					email.Send("還有十分鐘上班", employees.get(index).getemail());
					break;
				}
    			
			}}
			else if(12<date.getHours()&&date.getHours()<17) {
				for(int index=0;index<employees.size();index++) {
				if(scheldules.get(realweek).get((date.getHours()-9)+(date.getDay()-1)*8).equalsIgnoreCase( 
						employees.get(index).getname())&&
						date.getMinutes()==20) {
					email.Send("還有十分鐘上班", employees.get(index).getemail());	
					break;
				}
				}
				
			}
			Thread.sleep(60000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
        
    }
}