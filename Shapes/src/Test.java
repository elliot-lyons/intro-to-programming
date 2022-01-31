
public class Test
{
	public static void main(String[] args)
	{
		Rectangle theRectangle = new Rectangle("black", 10, 5);
		Square theSquare = new Square("red", 10);
		Triangle theTriangle = new Triangle("white", 10, 5);
		
		System.out.print(theRectangle.toString());
		System.out.print(theSquare.toString());
		System.out.print(theTriangle.toString());
	}
}
