
public class Complex {

	private double x;
	private double y;
	
	public Complex()
	{
		x = 0;
		y = 0;
	}
	
	public Complex (double real, double imaginary)
	{
		x = real;
		y = imaginary;
	}
	
	public static Complex add(Complex a, Complex b)
	{
		return new Complex((a.x + b.x), (a.y + b.y));
	}
	
	public static Complex multiply(Complex a, Complex b)
	{
		return new Complex (((a.x * b.x) - (a.y * b.y)), ((a.x * b.x) + (a.y * b.y)));
	}
	
	public static Complex divide(Complex a, Complex b)
	{
		double imaginaryPart = ((a.y * b.x) - (a.x * b.y));
		double divisor = ((b.x * b.x) + (b.y * b.y));
		imaginaryPart = imaginaryPart / divisor;
		
		return new Complex(((a.x * b.x) + (a.y * b.y)), imaginaryPart);
	}
	
	public static String toString(Complex a)
	{
		return "" + a.x + ((a.y >= 0) ? " +" : "" ) + " " + a.y + "i";
	}
}
