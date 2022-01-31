
public abstract class ConnectPlayer {
	
	private int column;
	private int playerNumber;
	
	public ConnectPlayer(int playerNumber)			// player number is passed in. This determines what piece that player will use
	{												// i.e if playerNumber is 1, they will use 'x'. If playerNumber is 2, they will use 'y'
		this.playerNumber = playerNumber;
	}
	
	public void setColumn(int column)
	{
		this.column = column;
	}
	public int getColumn()
	{
		return column;
	}
	
	public abstract void askColumn();
	
	public int getPlayerNumber()
	{
		return playerNumber;
	}

}
