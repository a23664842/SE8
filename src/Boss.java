public class Boss extends Observer
{
	private String account;
	
	public Boss(String name, String email, String phone, String password, String account) {
		super(name, email, phone, password);
		this.account=account;
	}

	public void setaccount(String c)
	{
		account = c;
	}
	public String getaccount()
	{
		return account;
	}
}