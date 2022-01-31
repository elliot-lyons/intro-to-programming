
public class Circle implements GeometricObject {
	
	protected double radius;
	
	Circle(double radius)
	{
		this.radius = radius;
	}
	
	@Override
	public double getPerimeter()
	{
		return (2 * radius) * Math.PI;
	}
	
	@Override
	public double getArea()
	{
		return (radius * radius) * Math.PI;
	}

}
