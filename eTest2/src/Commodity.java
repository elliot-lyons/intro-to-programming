
public class Commodity extends MyAssets
{
	protected int totalShares;
	
	Commodity(String symbol, double curPrice) 
	{
		super(symbol, curPrice);
	}
	
	public void purchase(int totalShares, double purchasedPrice)		// this purchases some shares of a commodity. This wasn't in the spec sheet
	{																	// but in the main class, so unsure if this is in the right place
		this.totalShares = totalShares;
		totalCost = totalShares * purchasedPrice;
	}
	
	public void setCurrentPrice(double newPrice)
	{
		curPrice = newPrice;
	}
	
	@Override
	public double marketVal() 
	{
		return curPrice * totalShares;
	}
	
	public String toString()
	{
		return "" + symbol + " ( " + totalShares + " shares, $ " + totalCost +  " total cost )";
	}
}
