
public class Rectangle implements Shape
{
	private String color;
	private int length;
	private int width;
	
	Rectangle(String color, int length, int width)
	{
		this.color = color;
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double getArea()
	{
		return length * width;
	}

	@Override
	public double getPerimeter() 
	{
		return (length * 2) + (width * 2);
	}
	
	public String toString()
	{
		return "The perimeter is " + getPerimeter() + ".\nThe area is " + getArea() + ".\n";
	}
}
