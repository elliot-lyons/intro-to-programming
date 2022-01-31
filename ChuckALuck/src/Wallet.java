
public class Wallet {

	private double cash;
	
	public Wallet()
	{
		cash = 0;
	}
	
	public void takeMoney(double money)
	{
		cash = cash - money;
	}
	
	public void addMoney(double money)
	{
		if (money > 0.0)
		{
			cash = cash + money;
		}
	}
	
	public boolean canPlay (double money)
	{
		if (money > 0.0 && cash >= money)
		{
			return true;
		}
		
		return false;
	}
	
	public double currentCash()
	{
		return cash;
	}
	
	public double result(double initial)
	{
		return cash - initial;
	}
	
	public String cashToString()
	{
		return "Current cash = " + cash + " dollars.";
	}

}
