
public class ResizableCircle extends Circle implements Resizable {

	private double perimeter;
	private double area;
	
	ResizableCircle(double radius) 
	{
		super (radius);
	}

	@Override
	public void resize(int percent) 
	{	
		perimeter = getPerimeter() * ((100 - (double) percent) / 100);
		area = getArea() * (((100 - (double) percent) / 100) * ((100 - (double) percent) / 100));
	}
	
	@Override
	public void display()
	{
		System.out.printf("Perimeter of the circle is %.2f.%nArea of the circle is %.2f.", perimeter, area);
	}

}
