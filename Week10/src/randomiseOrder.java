import java.util.Random;

public class randomiseOrder {

	int[] array = { 1, 5, 2, 66, 27};
	
	
	// this function takes an array and randomises the contents of it. It essentially works its way through the first array
	// and puts it in a randomly generated place in the temporary array
	
	public static void randomiseOrder( int[] array )
	{
		if (array!=null)
		{
			Random generator = new Random();
			for (int index=0; index<array.length; index++ )
			{
				int otherIndex = generator.nextInt(array.length);
				int temp = array[index];
				array[index] = array[otherIndex];
				array[otherIndex] = temp;
			}
		}
	}
	
	// this function sorts an array into order
	
	public static void sort( int[] array )
	{
		if (array!=null)
		{	
			for (int index=0; index<array.length-1; index++)
			{
				int minimumIndex = index;
				for (int index2=index+1; index2<array.length; index2++)
				{
					if (array[index2] < array[minimumIndex])
						minimumIndex = index2;
				}
				int temp = array[index];
				array[index] = array[minimumIndex];
				array[minimumIndex] = temp;
			}
		}	
	}
}

