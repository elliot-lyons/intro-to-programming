import java.util.*;
import java.io.*;
import java.nio.file.Path;

public class Game3 {


	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		ArrayList<Double> props = new ArrayList<Double>();
		
			int gameCount = 0;
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
		
			ArrayList<Integer> turns = new ArrayList<Integer>();
			ArrayList<Integer> winnings = new ArrayList<Integer>();
			
			ArrayList<Double> avgWinnings = new ArrayList<Double>();
			ArrayList<Double> varWinnings = new ArrayList<Double>();
			
			ArrayList<Double> avgProp = new ArrayList<Double>();
			ArrayList<Double> varProp = new ArrayList<Double>();
			ArrayList<Double> prop = new ArrayList<Double>();
			
			double turnsVar = 0;
			double winningsVar = 0;
		
		
			while (gameCount < 10000)
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
						turns.add(currentTime);
						winnings.add(currentTotal);
						prop.add((double) 1);
					}
				
					else if (bet > 100)
					{
						lossCount++;
						gameOver = true;
						amountLost = amountLost + currentTotal;
						bet = 1;
					
						turns.add(currentTime);
						winnings.add(currentTotal);
						prop.add((double) 0);
					
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
				//System.out.println(overall);
			
				totalTime = totalTime + currentTime;
				currentTotal = 0;
				gameCount++;
				
				runningWinningsAvg = (double) overall / (double) gameCount;
				
				avgWinnings.add(runningWinningsAvg);
				double runningWinningsVar = 0;
				
				for (int i = 0; i < gameCount; i++)
				{
					runningWinningsVar += (((double) winnings.get(i) - runningWinningsAvg) * ((double) winnings.get(i) - runningWinningsAvg));
				}
				
				runningWinningsVar /=  (double) (gameCount - 1); 
				varWinnings.add(runningWinningsVar);
				
				runningPropAvg = (double) winCount / (double) gameCount;
				//System.out.printf("Run prop: %.4f\n", runningPropAvg);
				
				avgProp.add(runningPropAvg);
				double runningPropVar = 0;
				
				for (int i = 0; i < gameCount; i++)
				{
					runningPropVar += ((prop.get(i) - runningPropAvg) * (prop.get(i) - runningPropAvg));
				}
				
				runningPropVar /=  (double) (gameCount - 1);
				//System.out.printf("Run prop var: %.4f\n", runningPropVar);
				
				varProp.add(runningPropVar);
			}
		
			int total = amountWon + amountLost;
			double average  = (double) total / (double) 10000;
			double avg = average;
		
			double propWon = (double) winCount / 10000;
			double propLost = 1 - propWon;
			props.add(propWon);
		
			double avgPlayTime = (double) totalTime / (double) 10000;
		
			System.out.printf("Games won: %d (proportion won: %.4f)\nGames lost: %d (proportion lost: %.4f)", winCount, propWon, lossCount, propLost);
		
			System.out.print("\n\nAmount won: $" + amountWon + "\nAmount lost: $" + (amountLost * -1) + "\n\nBiggest win: $10\nBiggest loss: -$" + 
						(biggestLoss * -1) + "\n\nTotal: " + (total < 0 ? "-$" + (total * -1) : "$" + total));
		
			System.out.print("\nAverage won / lost per game: " + (total < 0 ? "-$" : "$"));
		
			if (average < 0)
			{
				avgNeg = true;
				average = average * -1;
			}
			
			if (avgNeg)
			{
				average = average * -1;
			}
		
			System.out.printf("%.2f", average);
		
		
			System.out.print("\n\nTotal turns: " + totalTime + "\nLongest game: " + maxTime + " turns" + (maxWin ? " (win)" : " (loss)")
					+ "\nShortest game: " + minTime + " turns" + (minWin ? " (win)" : " (loss)"));
		
			System.out.printf("\nAverage playing time: %.2f turns", avgPlayTime);
		
			for (int i = 0; i < turns.size(); i++)
			{
				turnsVar += (((double) turns.get(i) - avgPlayTime) * ((double) turns.get(i) - avgPlayTime));
			}
		
			turnsVar /= 9999;
		
			for (int i = 0; i < winnings.size(); i++)
			{
				winningsVar += (((double) winnings.get(i) - avg) * ((double) winnings.get(i) - avg));
			}
		
			winningsVar /= 9999;
		
			System.out.printf("\n\nVariance of turns: %.2f\nVariance of winnings: %.2f\nProp var: %.4f", turnsVar, winningsVar, varProp.get(gameCount - 1));
			

			try {
			         File file = new File("C:\\Users\\ellio\\eclipse-workspace\\ProbProj\\src\\winavgs.txt");
			         
			         if (!file.exists())
			         {
			            file.createNewFile();
			         }
			         
			         FileWriter fw = new FileWriter(file.getAbsoluteFile());
		        	 BufferedWriter bw = new BufferedWriter(fw);
			         
			         for (int i = 0; i < avgWinnings.size(); i++)
			         {
			        	String content = Double.toString(avgWinnings.get(i)); 
			        	bw.write(content);
			        	bw.newLine();
			         }
			         
			         bw.close();
			         
			      } 
			
				catch (IOException e) {
			         e.printStackTrace();   
			}
			
			try {
		         File file = new File("C:\\Users\\ellio\\eclipse-workspace\\ProbProj\\src\\winvar.txt");
		         if (!file.exists()) {
		            file.createNewFile();
		         }
		         
		         FileWriter fw = new FileWriter(file.getAbsoluteFile());
	        	 BufferedWriter bw = new BufferedWriter(fw);
		         
		         for (int i = 0; i < varWinnings.size(); i++)
		         {
		        	String content = Double.toString(varWinnings.get(i)); 
		        	 bw.write(content);
		        	 bw.newLine();
		         }
		         
		         bw.close();
		         
		      } catch (IOException e) {
		         e.printStackTrace();
		       
		}
			
			try {
		         File file = new File("C:\\Users\\ellio\\eclipse-workspace\\ProbProj\\src\\propavgs.txt");
		         if (!file.exists()) {
		            file.createNewFile();
		         }
		         
		         FileWriter fw = new FileWriter(file.getAbsoluteFile());
	        	 BufferedWriter bw = new BufferedWriter(fw);
		         
		         for (int i = 0; i < avgProp.size(); i++)
		         {
		        	String content = Double.toString(avgProp.get(i)); 
		        	 bw.write(content);
		        	 bw.newLine();
		         }
		         
		         bw.close();
		         
		      } catch (IOException e) {
		         e.printStackTrace();
		       
		}
			
			try {
		         File file = new File("C:\\Users\\ellio\\eclipse-workspace\\ProbProj\\src\\propvar.txt");
		         if (!file.exists()) {
		            file.createNewFile();
		         }
		         
		         FileWriter fw = new FileWriter(file.getAbsoluteFile());
	        	 BufferedWriter bw = new BufferedWriter(fw);
		         
		         for (int i = 0; i < varProp.size(); i++)
		         {
		        	String content = Double.toString(varProp.get(i)); 
		        	 bw.write(content);
		        	 bw.newLine();
		         }
		         
		         bw.close();
		         
		      } catch (IOException e) {
		         e.printStackTrace();
		       
		}
			
		
			
//			System.out.println("\n\nRunning wins var: ");
//			
//			for (int i = 0; i < varWinnings.size(); i++)
//			{
//				System.out.printf("%.2f\n", varWinnings.get(i));
//			}
//			
//			System.out.println("\n\nRunning prop avg: ");
//			
//			for (int i = 0; i < avgProp.size(); i++)
//			{
//				System.out.printf("%.4f\n", avgProp.get(i));
//			}
//			
//			System.out.println("\n\nRunning prop var: ");
//			
//			for (int i = 0; i < avgProp.size(); i++)
//			{
//				System.out.printf("%.4f\n", varProp.get(i));
//			}
		
	}
	}

	
	//for (int i = 0; i < 5; i++)
	//{
		
	//}

