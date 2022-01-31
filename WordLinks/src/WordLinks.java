/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5: 5]
- Comment: My method creates a dictionary in the program from the text file words

- My method reads the words from the "words.txt" file. [Mark out of 5: 5]
- Comment: My method imports words.txt and reads the words from it 

- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5: 5]
- Comment: The method returns an ArrayList, which is turned into an a String array in the list to array function


2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: My method follows the method definition in the spec

- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of
 String references and returns it. [Mark out of 5: 5]
- Comment: The method takes in the comma separated user input and returns it as an ArrayList of Strings 


3. isUniqueList
- I have the correct method definition [Mark out of 5: 5]
- Comment: My method follows the method definition in the spec 

- My method compares each word in the array with the rest of the words in the list. [Mark out of 5: 5]
- Comment: The method loops through the entire ArrayList of input and checks to see if the other words
 		   are equal to it
 		   
- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
- Comment: It returns false and exits the method immediately if it finds a duplicated word

- Returns true is all the words are unique and false otherwise. [Mark out of 5: 5]
- Comment: If no duplicates are found, true is returned. If not, as above, false is returned


4. isEnglishWord
- I have the correct method definition [Mark out of 5: 5]
- Comment:  My method follows the method definition in the spec

- My method uses the binarySearch method in Arrays library class. [Mark out of 3: 3]
- Comment:  This method makes use of the binarySearch method from the Arrays ibrary lass

- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2: 2]
- Comment: If the value from the binarySearch method is >= 0, true is returned. If not false is returned


5. isDifferentByOne
- I have the correct method definition [Mark out of 5: 5]
- Comment:  My method follows the method definition in the spec

- My method loops through the length of a words comparing characters at the same position in both words
	searching for one difference. [Mark out of 10: 10]
- Comment: My method checks each character of two words. If there is more than a one character difference 
		   between them, or the length strings is different, false is returned. Otherwise, true is returned 


6. isWordChain
- I have the correct method definition [Mark out of 5: 5]
- Comment:  My method follows the method definition in the spec

- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message
	[Mark out of 10: 10]
- Comment: My method makes use of the above methods. The method name appears to be a boolean method name.
		   Therefore I return whether it is or isn't a valid word chain. I then use that result to print the 
		   appropriate message in main.


7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes
	covered in lectures [Mark out of 10: 10]
- Comment: Main calls the readDictionary to do this.

- Asks the user for input and calls isWordChain [Mark out of 5: 5]
- Comment: Main calls readWordList which asks for the user input. It then calls isWordChain and uses the boolean
		   returned to output the correct message as above


 Total Mark out of 100 (Add all the previous marks): 100
*/



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


public class WordLinks {
	
	public static final String QUIT_VAL = "-1";
	public static final String ERROR_VAL = "-2";

	public static void main(String[] args) {
		boolean quit = false;
		String[] dictionaryArray = listToArray(readDictionary());
		
		while (!quit)
		{
			ArrayList<String> wordList = readWordList();
		
			if (wordList.get(0).equals(QUIT_VAL))
			{
				quit = true;
			}
			
			if (!quit)
			{
				if (wordList.get(0).equals(ERROR_VAL))
				{
					System.out.print("Error. ");
				}
				
				else
				{
					if (isWordChain(wordList, dictionaryArray))
					{
						System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
					}
				
					else
					{
						System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
					}
				}
			}
		}
		
		System.out.println("Thank you for playing the word links game!");
	}
	
	private static ArrayList<String> readDictionary()
	{
		ArrayList<String> aL = new ArrayList<String>();
		
		try
		{
			FileReader fileReader = new FileReader("C:\\Users\\ellio\\eclipse-workspace\\"
	    		+ "WordLinks\\src\\words.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			boolean endOfFile = false;
			
			while(!endOfFile)
			{
				String word = bufferedReader.readLine();
				
				if (word != null)
				{
					aL.add(word);
				}
				
				else
				{
					endOfFile = true;
				}
			}
			
			bufferedReader.close();
		}
		
		catch (FileNotFoundException e)
		{
		    e.printStackTrace();
		}
		catch (IOException e)
		{
		    e.printStackTrace();
		}
		
		return aL;
	}
	
	private static ArrayList<String> readWordList()
	{	
		System.out.println("Enter a comma separated list of words (or an empty list to quit): ");		
		Scanner input = new Scanner(System.in);
		ArrayList<String> aL = new ArrayList<String>();
		

		input.useDelimiter("\n");
		
		String overall = "" + input.next();
		String current = "";
		
		int i = 0;
		
		if (overall.equals("\r"))
		{
			aL.add(QUIT_VAL);
		}
		
		
		else
		{
			while (i < overall.length())
			
			{
				char aChar = overall.charAt(i);
			
				if (aChar != ',' && aChar != ' ')
				{
					current += aChar;
				}
			
				else
				{
					if (current != "")
					{
						aL.add(current);
					}
				
					current = "";
				}
				
				i++;
			}
		}
		
		if (aL.size() == 0)
		{
			aL.add("ERROR_VAL");
		}
		
		return aL;	
	}
	
	private static boolean isUniqueList(ArrayList<String> aList)
	{
		for (int i = 0; i < aList.size(); i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (aList.get(i).equals(aList.get(j)))
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static boolean isEnglishWord(String[] aDictionary, String word)
	{		
		int search = Arrays.binarySearch(aDictionary, word);
		
		if (search >= 0)
		{
			return true;
		}
		
		return false;
	}
	
	private static boolean isDifferentByOne(String stringOne, String stringTwo)
	{
		int differentCount = 0;
		
		if (stringOne.length() == stringTwo.length())
		{
			for (int i = 0; i < stringOne.length(); i++)
			{
				if (stringOne.charAt(i) != stringTwo.charAt(i))
				{
					differentCount++;
				}
			}
		}
		
		if (differentCount == 1)
		{
			return true;
		}
		
		return false;
	}
	
	private static boolean isWordChain(ArrayList<String> aList, String[] theDictionary)
	{
		if (isUniqueList(aList))
		{
			for (int i = 0; i < aList.size(); i++)
			{
				String currentWord = aList.get(i);
				
				if (isEnglishWord(theDictionary, currentWord))
				{
					if (i > 0)
					{
						if (!isDifferentByOne(aList.get(i), aList.get(i - 1)))
						{
							return false;
						}
					}
				}
				
				else
				{
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	
	// this method is used to turn the dictionary ArrayList into an array so that it will work
	// for the binarySearch method called in the isEnglishWord method.
	
	private static String[] listToArray (ArrayList<String> aList)
	{
		String[] theArray = new String[aList.size()];
		
		for(int i = 0; i < aList.size(); i++)
		{
			theArray[i] = aList.get(i);
		}
		
		return theArray;
	}
}
