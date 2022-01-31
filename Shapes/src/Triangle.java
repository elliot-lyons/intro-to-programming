
public class Triangle implements Shape
{
	private String color;
	private int base;
	private int height;
	
	Triangle(String color, int base, int height)
	{
		this.color = color;
		this.base = base;
		this.height = height;
	}

	@Override
	public double getArea()
	{
		return ((double) (base /2) * height);
	}

	@Override
	public double getPerimeter()
	{
		return (base * 3);
	}
	
	public String toString()
	{
		return "The perimeter is " + getPerimeter() + ".\nThe area is " + getArea() + ".\n";
	}
}
