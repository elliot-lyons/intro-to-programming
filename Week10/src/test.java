
public class test {

	public static void main(String[] args) {
		double[] array = {1,2,3,4,5};
		double count = 7;
		
		double average = computeRollingAverage( array, count );
		}
	
	public static double computeRollingAverage( double[] array, double count )
	{
		double sum = 0;
		double average = 0;
		int count1 = (int) count;
		
		if ( count1 > array.length )
		{
			count1 = array.length;
		}
		
		int count2 = count1;
		
		if ( array != null )
		{
			if ( count == 0 )
			{
				average = 0;
			}
			else
			{
				while ( count1 >= 1 )
				{		
					int index = array.length - count1;
					sum = sum + array[index];
					count1--;
				}
				
				average = sum / ( count2 );
			}
			
		}
		return average;
	}
}
