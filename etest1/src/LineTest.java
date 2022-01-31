
public class LineTest {

	public static void main(String[] args) {
		Point p1 = new Point(18, 7);
		Point p2 = new Point(18, 8);
		Line l1 = new Line(p1, p2);
		System.out.print("Line 1: x1 = " + l1.getP1().getX() + " y1 = " + l1.getP1().getY()
				+ " x2 = " + l1.getP2().getX() + " y2 = " + l1.getP2().getY() + 
				". Slope = " + l1.getSlope() + "\n");
		
		Line l2 = new Line(8, 7, 9, 6);
		System.out.print("Line 2: x1 = " + l2.getP1().getX() + " y1 = " + l2.getP1().getY()
				+ " x2 = " + l2.getP2().getX() + " y2 = " + l2.getP2().getY() + 
				". Slope = " + l2.getSlope());
	}
}
