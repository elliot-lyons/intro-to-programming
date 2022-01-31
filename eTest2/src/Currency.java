
public class Currency implements Portfolio
{
	protected double amount;					// this tracks the live amount of your purchase. Any deflation or inflation is handled in setNewAmount
	protected double amountAtPurchase;			// this tracks the amount at purchase (i.e. how much your money was worth at the point of purchase)
	
	Currency (double amount)
	{
		this.amount = amount;
		amountAtPurchase = amount;
	}
	
	public void setNewAmount(double amount)				// this allows for a new rate to be set in main if there is any changes to the currency
	{													// (inflation or deflation)
		this.amount = amount;
	}

	@Override
	public double marketVal() 
	{
		return amount;
	}

	@Override
	public double profit()
	{
		return amount - amountAtPurchase;
	}
	
	public String toString()
	{
		return "Cash ( $ " + amountAtPurchase + " )";
	}
}
