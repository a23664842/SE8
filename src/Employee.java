public class Employee extends Observer
{
	private int salary;
	private int worktime;
	private int warningpoint;
	private String ID;
	private int default_salary=10;
	
	public Employee(String name, String email, String phone, String password, int salary,
			int worktime, int warningpoint, String ID) {
		super(name, email, phone, password);
		this.salary=salary;
		this.worktime=worktime;
		this.warningpoint=warningpoint;
		this.ID=ID;
	}
	
	public Employee(String ID, String password) {
		super();
		this.setpassword(password);
		this.setID(ID);
		this.default_salary=10;
		this.worktime=0;
		this.warningpoint=0;
	}

	public int salarycount()
	{
		return salary*worktime;
	}
	public void warningpointcount()
	{
		warningpoint = warningpoint +1;
	}
	public void setsalary(int a)
	{
		salary = a;
	} 
	public int getsalary()
	{
		return salary;
	}
	public void setworktime()
	{
		worktime += 1;
	} 
	public int getworktime()
	{
		return worktime;
	}
	public void setwarningpoint(int c)
	{
		 warningpoint = c;
	} 
	public int getwarningpoint()
	{
		return  warningpoint;
	}
	public void setID(String c)
	{
		 ID = c;
	} 
	public String getID()
	{
		return  ID;
	}
}