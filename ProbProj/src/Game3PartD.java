import java.util.ArrayList;
import java.util.Random;
import java.util.*;
import java.io.*;
import java.nio.file.Path;

public class Game3PartD {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		int limit = 0;
		
		ArrayList<Double> winPs = new ArrayList<Double>();
		ArrayList<Double> totals = new ArrayList<Double>();
		ArrayList<Double> times = new ArrayList<Double>();
	
		while (limit < 10000)
		{
			int currentTotal = 0;
			int winCount = 0;
			int lossCount = 0;
			int amountWon = 0;
			int amountLost = 0;
			int biggestLoss = 0;
			int overall = 0;
		
			double rand = 0;
			int x = 0;
			Random r = new Random();
		
			double odds = (double) 18 / (double) 37;
			boolean gameOver = false;
			int upperBound = 1;
			double runningWinningsAvg = 0;
			double runningPropAvg = 0;
		
			int totalTime = 0;
			int maxTime = 0;
			int minTime = 0;
			boolean win = false;
			boolean minWin = false;
			boolean maxWin = false;
			boolean avgNeg = false;
			
			double turnsVar = 0;
			double winningsVar = 0;
		
			for (int gCount = 0; gCount < 10000; gCount++)
			{
				int currentTime = 0;
				int bet = 1;
				gameOver = false;
		
				while (!gameOver)
				{
					currentTime++;
					x = r.nextInt(upperBound);
					rand = r.nextDouble();
			
					if (rand <= odds)
					{
						currentTotal = currentTotal + bet;
						bet = 1;
						win = true;
					}
			
					else
					{
						currentTotal = currentTotal - bet;
						bet = 2 * bet;
						win = false;
					}
			
					if (currentTotal == 10)
					{
						winCount++;
						gameOver = true;
						amountWon = amountWon + currentTotal;
//						turns.add(currentTime);
//						winnings.add(currentTotal);
//						prop.add((double) 1);
					}
			
					else if (bet > 100)
					{
						lossCount++;
						gameOver = true;
						amountLost = amountLost + currentTotal;
						bet = 1;
				
//						turns.add(currentTime);
//						winnings.add(currentTotal);
//						prop.add((double) 0);
				
						if (currentTotal < biggestLoss)
						{
							biggestLoss = currentTotal;
						}
					}	
				}
		
				if (totalTime == 0)
				{
					maxTime = currentTime;
					minTime = currentTime;
				}
		
				else
				{
					if (currentTime > maxTime)
					{
						maxTime = currentTime;
						maxWin = win;
					}
			
					if (currentTime < minTime)
					{
						minTime = currentTime;
						minWin = win;
					}
				}
			
				overall = overall + currentTotal;
			
				totalTime = totalTime + currentTime;
				currentTotal = 0;
			}
			
			System.out.print(winCount + "\n" + limit + "\n\n");
			
			double winP = (double) winCount / 10000;
			double total = (double) overall / 10000;
			double time = (double) totalTime / 10000;
			
			winPs.add(winP);
			totals.add(total);
			times.add(time);
			
			limit++;
		}
		
		try 
		{
			File file = new File("C:\\Users\\ellio\\eclipse-workspace\\ProbProj\\src\\winPr.txt");
	         
	         if (!file.exists())
	         {
	            file.createNewFile();
	         }
	         
	         FileWriter fw = new FileWriter(file.getAbsoluteFile());
        	 BufferedWriter bw = new BufferedWriter(fw);
	         
        	 for (int i = 0; i < limit; i++)
        	 {
        		 String content = Double.toString(winPs.get(i));
        		 bw.write(content);
        		 bw.newLine();
        	 }
	    
	         bw.close();     
	      } 
	
		catch (IOException e)
		{
	         e.printStackTrace();   
		}
		
		try 
		{
			File file = new File("C:\\Users\\ellio\\eclipse-workspace\\ProbProj\\src\\totals.txt");
	         
	         if (!file.exists())
	         {
	            file.createNewFile();
	         }
	         
	         FileWriter fw = new FileWriter(file.getAbsoluteFile());
        	 BufferedWriter bw = new BufferedWriter(fw);
	         
        	 for (int i = 0; i < limit; i++)
        	 {
        		 String content = Double.toString(totals.get(i));
        		 bw.write(content);
        		 bw.newLine();
        	 }
	    
	         bw.close();     
	      } 
	
		catch (IOException e)
		{
	         e.printStackTrace();   
		}
		
		try 
		{
			File file = new File("C:\\Users\\ellio\\eclipse-workspace\\ProbProj\\src\\times.txt");
	         
	         if (!file.exists())
	         {
	            file.createNewFile();
	         }
	         
	         FileWriter fw = new FileWriter(file.getAbsoluteFile());
        	 BufferedWriter bw = new BufferedWriter(fw);
        	 
        	 for (int i = 0; i < limit; i++)
        	 {
        		 String content = Double.toString(times.get(i));
        		 bw.write(content);
        		 bw.newLine();
        	 }
	    
	         bw.close();     
	      } 
	
		catch (IOException e)
		{
	         e.printStackTrace();   
		}
	}
}
