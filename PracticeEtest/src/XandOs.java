import java.util.Scanner;

public class XandOs {
	
	public static final char BLANK = ' ';
	public static final char NOUGHT = 'O';
	public static final char CROSS = 'X';
	public static final int BOARD_SIZE = 3;
	
	public static void main(String[] args) {
		char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
		clearBoard (board);
		char currentPlayerPiece = CROSS;
		Scanner input = new Scanner(System.in);
	
		while ((!isBoardFull(board)) && (winner(board) == BLANK))
		{
			printBoard(board);
			int row=-1;
			int column=-1;
	 
			do
			{
				System.out.print("Enter move for " + currentPlayerPiece + ": ");
				char[] inputCharacters = input.next().toCharArray();
	 
				if ((inputCharacters.length >= 2) &&
						(inputCharacters[0] >= 'A') && (inputCharacters[0] <= 'C') &&
						(inputCharacters[1] >= '1') && (inputCharacters[1] <= '3'))
				{
					row = (int) (inputCharacters[0]-'A');
					column = (int) (inputCharacters[1]-'1');
	 
					if (!canMakeMove(board,row,column))
						System.out.println(" Invalid entry. This location is already occupied.");
				}
	 
				else System.out.println(" Invalid entry. You must enter a row and column(e.g. B2 is the center piece on the board).");
	 
			} while ((row == -1) || (!canMakeMove(board,row,column)));
	 
			makeMove(board,currentPlayerPiece,row,column);
			currentPlayerPiece = (currentPlayerPiece==CROSS)?NOUGHT:CROSS;
		}
	
		printBoard(board);
	
		if (winner(board) == BLANK)
		{
			System.out.println("It was a draw.");
		}
		
		else 
		{
			System.out.println("The winner was " + winner(board));
			input.close();
		} 
	}
	
	public static void clearBoard(char[][] aBoard)
	{
		for (int row = 0; row < aBoard.length; row++)
		{
			for (int col = 0; col < aBoard[0].length; col++)
			{
				aBoard[row][col] = BLANK;
			}
		}
	}
	
	public static void printBoard(char[][] aBoard)
	{
		System.out.print("A ");
		otherPrint(aBoard, 0);
		System.out.print("B ");
		otherPrint(aBoard, 1);
		System.out.print("C ");
		otherPrint(aBoard, 2);
		
		System.out.println("  1   2   3");
	}
	
	public static void otherPrint(char[][] aBoard, int row)
	{
		for (int col = 0; col < aBoard[0].length; col++)
		{
			if (col == 0)
			{
				System.out.print(aBoard[col][row]);
			}
			else
			{
			System.out.print(" | " + aBoard[col][row]);
			}
			
			if (row < aBoard.length - 1)
			{
			System.out.println(" ---|---|---");
			}
		}
	System.out.print("\n");
	}
	
	public static boolean canMakeMove(char[][] aBoard, int row, int column)
	{
		if (aBoard[row][column] == BLANK)
		{
			return true;
		}
		
		return false;
	}
	
	public static void makeMove(char[][] aBoard, char playerPiece, int row, int column)
	{
		aBoard[row][column] = playerPiece;
	}
	
	public static boolean isBoardFull(char[][] aBoard)
	{
		for (int row = 0; row < aBoard.length; row++)
		{
			for (int col = 0; col < aBoard[0].length; col++)
			{
				if (aBoard[row][col] == BLANK)
				{
					return false;
				}
			}
		}
		return true;
	}
				
	public static char winner(char[][] aBoard)
	{
		for (int count = 1; count < 2; count++)
		{
			char currentChar = NOUGHT;
			
			if (count == 2)
			{
				currentChar = CROSS;
			}
			
			if (horizontalCheck(aBoard, currentChar) || verticalCheck(aBoard, currentChar) 
					|| diagonalCheck(aBoard, currentChar))
			{
				return currentChar;
			}	
		}
		return BLANK;
	}
	
	public static boolean horizontalCheck(char[][] aBoard, char aCharacter)
	{
		boolean check = false;
		
		for (int row = 0; row < aBoard.length && !check; row++)
		{
			check = true;
			
			for (int col = 0; col < aBoard[0].length && check; col++)
			{
				if (aBoard[row][col] != aCharacter)
				{
					check = false;
				}
			}
		}
		return check;
	}
	
	public static boolean verticalCheck(char[][] aBoard, char aCharacter)
	{
		boolean check = false;
		
		for (int col = 0; col < aBoard[0].length && !check; col++)
		{
			check = true;
			
			for (int row = 0; row < aBoard.length && check; row++)
			{
				if (aBoard[row][col] != aCharacter)
				{
					check = false;
				}
			}
		}
		return check;
	}
	
	public static boolean diagonalCheck(char[][] aBoard, char aCharacter)
	{
		boolean check = true;
		
		for (int i = 0; i < aBoard.length && check; i++)
		{
			if (aBoard[i][i] != aCharacter)
			{
				check = false;
			}
		}
		
		if (check == false)
		{
			check = true;
			
			for (int i = aBoard.length - 1; i <= 0 && check; i--)
			{
				if (aBoard[i][i] != aCharacter)
				{
					check = false;
				}
			}
		}
		return check;	
	}
	
}
