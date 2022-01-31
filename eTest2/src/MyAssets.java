
public abstract class MyAssets implements Portfolio 
{
	protected String symbol;
	protected double totalCost;
	protected double curPrice;
	
	MyAssets(String symbol, double curPrice)
	{
		this.symbol = symbol;
		this.curPrice = curPrice;
	}
	
	@Override
	public double profit() {
		return marketVal() - totalCost;
	}

}
