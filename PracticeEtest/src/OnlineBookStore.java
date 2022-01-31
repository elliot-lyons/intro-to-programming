import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore
{
    public static int ISBN_INDEX = 0;
    public static int TITLE_INDEX = 1;
    public static int AUTHOR_INDEX = 2;
    public static int PUBLISHER_INDEX = 3;
    public static int PUBLISHER_YEAR_INDEX = 4;
    public static int QUANTITY_INDEX = 5;
    public static int PRICE_INDEX = 6;

    public static void main(String[] args)
    {
	ArrayList<Book> bookList = new ArrayList<Book>();
	
	try
	{
	    FileReader fileReader = new FileReader("C:\\Users\\ellio\\eclipse-workspace\\"
	    		+ "PracticeEtest\\src\\books.txt");// Enter the entire path of the file if needed
	    BufferedReader bufferedReader = new BufferedReader(fileReader);  
	    boolean endOfFile = false;

	    while(!endOfFile)
	    {
                String bookLine = bufferedReader.readLine();
	        if (bookLine != null)
		{
	            String[] bookData = bookLine.split(", ");
	            String isbn = bookData[ISBN_INDEX];
	            String title = bookData[TITLE_INDEX];
	            String author = bookData[AUTHOR_INDEX];
	            String publisher = bookData[PUBLISHER_INDEX];
	            int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
	            int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
	            double price = Double.parseDouble (bookData[PRICE_INDEX]);
	            Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
	            bookList.add(book);

	         }
		 else
		 {
	            endOfFile = true;
	         }
	    }
	         bufferedReader.close();    
	         fileReader.close();
        } // End try 

	catch (FileNotFoundException e)
	{
	    e.printStackTrace();
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}
	
	

	// Uncomment the following lines once you have implemented the required methods
	printBookDetails(bookList);
	purchaseBook(bookList);
    }
    
    public static void printBookDetails (ArrayList<Book> bookList)
	{
		for (int i = 0; i < bookList.size(); i++)
		{
			Book currentBook = bookList.get(i);
			System.out.print(currentBook.toString());
		}
	}
    
    public static Book getBook(ArrayList<Book> bookList, String title)
    {
    	for (int i = 0; i < bookList.size(); i++)
    	{
    		Book currentBook = bookList.get(i);
    		String currentTitle = currentBook.getTitle();
    		
    		if (currentTitle.equalsIgnoreCase(title))
    		{
    			return currentBook;
    		}
    	}
    	
    	return null;
    }
    
    public static void topUpCard(ChargeCard card, double amount)
    {
    	card.topUpFunds(amount);
    }
    
    public static void purchaseBook(ArrayList<Book> bookList)
    {
    	boolean error = false;
    	ChargeCard card = new ChargeCard();
    	
    	do
    	{
    		if (error)
    		{
    			System.out.print("Error. ");
    		}
    		
    		System.out.println("Enter initial amount in card: ");
    		Scanner input = new Scanner(System.in);
    		
    		if (input.hasNextDouble())
    		{
    			double initialFunds = input.nextDouble();
    			
    			if (initialFunds > 0)
    			{
    				card.setFunds(initialFunds);
    				error = false;
    			}
    			
    			else
    			{
    				error = true;
    			}
    		}
    		
    		else
    		{
    			error = true;
    		}
    			
    		input.nextLine();
    		
    	} while (error);
    	
    	boolean quit = false;
    	
    	while (!quit)
    	{
    		System.out.println("Enter book title: ");
    		Scanner input = new Scanner(System.in);
    		
    		
    		String title = input.nextLine();
    		
    		if (title.equalsIgnoreCase("quit"))
    		{
    			quit = true;
    		}
    		
    		else
    		{
    		
    			Book currentBook = getBook(bookList, title);
    		
    			if (currentBook != null)
    			{
    				if (currentBook.getQuantity() < 1)
    				{
    					System.out.println("There are no more copies of " + currentBook.getTitle() + ".");
    				}
    				
    				else
    				{
    					if (card.getFunds() < currentBook.getPrice())
    					{
    						System.out.println("You don't have enough for " + currentBook.getTitle() + ".");
    					}
    					
    					else
    					{
    						currentBook.setQuantity((currentBook.getQuantity() - 1));
    						card.removeFunds(currentBook.getPrice());
    						
    						System.out.println("Thank you for purchasing " + currentBook.getTitle());
    					}
    				}
    			}
    			else
    			{
    				System.out.print("Error. ");
    			}
    		}
			
    	}
    	
    	
    }
  }

    
