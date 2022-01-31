
public class Connect4Grid2DArray implements Connect4Grid {
	
	private static final String PLAYER_ONE_PIECE = "x";
	private static final String PLAYER_TWO_PIECE = "y";
	
	private String[][] theGrid;
	private int currentColumn;
	private String currentPlayer;
	private int currentRow;
	
	Connect4Grid2DArray()
	{
		theGrid = new String[6][15];
	}
	
	@Override
	public void emptyGrid()				// creates an empty grid
	{
		for (int row = 0; row < theGrid.length; row++)
		{
			for (int column = 0; column < theGrid[row].length; column++)
			{
				if (column == 0)
				{
					theGrid[row][column] = "|";
				}
				
				else
				{
					if ((column % 2) == 1)
					{
						theGrid[row][column] = " ";
					}
					
					else
					{
						theGrid[row][column] = "|";
					}
				}
			}
		}
	}
	
	@Override
	public String toString()			// creates a String of the current grid
	{
		String theString = "\n";
		
		for (int row = 0; row < theGrid.length; row++)
		{
			for (int column = 0; column < theGrid[row].length; column++)
			{
				theString = theString + theGrid[row][column];
			}
			
			theString = theString + "\n";
		}
		
		theString = theString + "\n";
		
		return theString;
	}

	@Override
	public boolean isValidColumn(int column)			// checks to see if the input column is within the bounds of the grid
	{
		if (column <= 0 || column > 7)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public boolean isColumnFull(int column)				// checks to see whether the requested column is full
	{
		currentColumn = ((column * 2) - 1);
		for (int row = 0; row < theGrid.length; row++)
		{
			if (theGrid[row][currentColumn].equals(" "))
			{
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public void dropPiece(ConnectPlayer player, int column)		// drops the appropriate player piece into the chosen column
	{
		if (player.getPlayerNumber() == 1)
		{
			currentPlayer = PLAYER_ONE_PIECE;
		}
		
		else
		{
			currentPlayer = PLAYER_TWO_PIECE;
		}
		
		currentColumn = ((column * 2) - 1);
		theGrid[currentRow][currentColumn] = currentPlayer;
	}

	@Override
	public boolean didLastPieceConnect4()			// checks to see whether the last inserted piece causes a connect four in the horizontal / vertical /
	{												// diagonal direction
		if (connectsHorizontally() || connectsVertically() || connectsDiagonally())
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isGridFull()						// checks to see if the grid is full
	{
		for (int row = 0; row < theGrid.length; row++)
		{
			for (int column = 1; column < theGrid[row].length - 1; column += 2)
			{
				if (theGrid[row][column].equals(" "))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void bottomRow(int column)				// finds the lowest row in the requested column
	{
		boolean emptyColumn = true;
		currentColumn = ((column * 2) - 1);
		
		for (int row = 1; row < theGrid.length && emptyColumn; row++)
		{
			if (theGrid[row][currentColumn].equals(PLAYER_ONE_PIECE) ||
					theGrid[row][currentColumn].equals(PLAYER_TWO_PIECE))
			{
				currentRow = row - 1;
				emptyColumn = false;
			}
		}
			
		if (emptyColumn)
		{
			currentRow = 5;
		}
	}
	
	// this checks the board to see if the last piece caused a connect 4 horizontally
	public boolean connectsHorizontally()
	{
		int count = 0;
		
		for (int columnCheck = currentColumn - 6; columnCheck <= currentColumn + 6 && columnCheck < theGrid[0].length - 1; columnCheck += 2)
		{
			if (columnCheck > 0)
			{
				if (theGrid[currentRow][columnCheck].equals(currentPlayer))
				{
					count++;
					
					if (count == 4)
					{
						return true;
					}
				}
				
				else
				{
					count = 0;
				}
			}
		}
		
		return false;
	}
	
	// this checks the board to see if the last piece caused a connect 4 vertically
	public boolean connectsVertically()
	{
		int count = 0;
		
		for (int rowCheck = currentRow + 3; rowCheck >= currentRow - 3 && rowCheck >= 0; rowCheck--)
		{
			if (rowCheck < theGrid.length)
			{
				if (theGrid[rowCheck][currentColumn].equals(currentPlayer))
				{
					count++;
					
					if (count == 4)
					{
						return true;
					}
				}
				
				else
				{
					count = 0;
				}
			}
		}
		
		return false;
	}
	
	// this checks the board to see if the last piece caused a connect 4 diagonally
	public boolean connectsDiagonally()
	{	
		// checking a connect four in the downwards-right direction
		int columnCheck = currentColumn - 4;
		int rowCheck = currentRow - 2;
		int count = 0;
		
		while (columnCheck < theGrid[0].length - 1 && rowCheck < theGrid.length)
		{
			if (columnCheck > 0 && rowCheck >= 0)
			{
				if (theGrid[rowCheck][columnCheck].equals(currentPlayer))
				{
					count++;
						
					if (count == 4)
					{
						return true;
					}
				}
			}
			
			columnCheck += 2;
			rowCheck++;
		}
		
		// checking a connect four in the upwards-right direction
		columnCheck = currentColumn - 4;
		rowCheck = currentRow + 2;
		count = 0;
		
		while (columnCheck < theGrid[0].length - 1 && rowCheck >= 0)
		{
			if (columnCheck > 0 && rowCheck < theGrid.length)
			{
				if (theGrid[rowCheck][columnCheck].equals(currentPlayer))
				{
					count++;
						
					if (count == 4)
					{
						return true;
					}
				}
			}
			
			columnCheck += 2;
			rowCheck--;
		}
		
		// checking a connect four in the upwards-left direction
		columnCheck = currentColumn + 4;
		rowCheck = currentRow + 2;
		count = 0;
		
		while (columnCheck > 0 && rowCheck >= 0)
		{
			if (columnCheck < theGrid[0].length - 1 && rowCheck < theGrid.length)
			{
				if (theGrid[rowCheck][columnCheck].equals(currentPlayer))
				{
					count++;
						
					if (count == 4)
					{
						return true;
					}
				}
			}
			
			columnCheck -= 2 ;
			rowCheck--;
		}
		
		// checking a connect four in the downwards-left direction
		columnCheck = currentColumn + 4;
		rowCheck = currentRow - 2;
		count = 0;
		
		while (columnCheck >= 1 && rowCheck < theGrid.length)
		{
			if (columnCheck < theGrid[0].length - 1 && rowCheck > 0)
			{
				if (theGrid[rowCheck][columnCheck].equals(currentPlayer))
				{
					count++;
						
					if (count == 4)
					{
						return true;
					}
				}
			}
			
			columnCheck -= 2;
			rowCheck++;
		}
		
		return false;
	}
}
