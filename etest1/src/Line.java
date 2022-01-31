
public class Line {

	private static int x1;
	private static int y1;
	private static int x2;
	private static int y2;
	
	public Line(Point p1, Point p2)
	{
		x1 = p1.getX();
		y1 = p1.getY();
		x2 = p2.getX();
		y2 = p2.getY();
	}
	
	public Line (int x1, int y1, int x2, int y2)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public static Point getP1()
	{
		Point p1 = new Point(x1, y1);
		return p1;
	}
	
	public static Point getP2()
	{
		Point p2 = new Point(x2, y2);
		return p2;
	}
	
	public static double getSlope() throws ArithmeticException
	{
		return (double)(y2 - y1) / (double)(x2 - x1);
	}
}
