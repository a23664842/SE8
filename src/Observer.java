public class Observer
{
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public Observer(String name, String email, String phone, String password) {
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.password=password;
	}
	
	public Observer() {
		this.name="noname";
		this.email="noemail";
		this.phone="nophone";
	}
	
	public void setname(String a)
	{
		name = a;
	} 
	public String getname()
	{
		return name;
	}
	public void setemail(String b)
	{
		email = b;
	}
	public String getemail()
	{
		return email;
	}
	public void setphone(String c)
	{
		phone = c;	
	}
	public String getphone()
	{
		return phone;
	}
	public void setpassword(String d)
	{
		password = d;	
	}
	public String getpassword()
	{	
		return password;
	}

}

