import java.io.*;

public class Tutorial {

    public static void main(String args[]) throws IOException {

        FileWriter writer = new FileWriter("out.txt");
        toDocument(writer);

    }

    public static void toDocument(FileWriter fw)
    {
    	BufferedWriter bw = new BufferedWriter(fw);
    	
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
    	{
			String word;
			System.out.println("Enter first word");
			
			while ((word = br.readLine()) != null)
			{
				bw.write(word);
				bw.write(" ");
				System.out.println("Enter next word");
			}
    	}	
        catch (Exception e)
		{
			System.out.print("Error");
		}
        
    }

}

