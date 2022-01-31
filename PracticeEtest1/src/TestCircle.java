import java.util.Formatter;
public class TestCircle {

	public static void main(String[] args) {
		Circle theCircle = new Circle(100);
		ResizableCircle rCircle = new ResizableCircle(100);
		
		System.out.printf("Perimeter of the circle is %.2f.%nArea of the circle is %.2f.%n", theCircle.getPerimeter(), theCircle.getArea());
		rCircle.resize(10);
		rCircle.display();
	}

}
