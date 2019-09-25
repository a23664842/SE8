import java.io.*;
import java.util.*;

public class Scheldule {
	private static LinkedList<String> name = new LinkedList();	
	private static LinkedList<LinkedList<String>> scheldules = new LinkedList();

	public boolean fileprint(LinkedList<LinkedList<String>> member)
	{
		try {
			scheldules.clear();
			for(int i = 0;i < member.size();i++)
			{
				scheldules.add(member.get(i));
			}

			String weekschelduename;
			for(int week = 0;week < scheldules.size();week++) {
				weekschelduename = "scheldue"+(week+1)+".siban";
			PrintWriter f  = new PrintWriter(new FileOutputStream(weekschelduename)); //f is scheldue.txt's object
			for(int j = 0;j <=7;j++) //let j = col,and i = row
			{
				for(int i = j;i <=39;i += 8)
				{
					f.print(scheldules.get(week).get(i)+"\t");
				}
				f.println("");
			}
			f.close();
			}
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}