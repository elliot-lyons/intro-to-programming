
public class ComplexDemo {

	public static void main(String[] args) {
		Complex a = new Complex(1, 1);
		Complex b = new Complex(1, 1);
		
		System.out.println("Sum is: " + Complex.toString(Complex.add(a, b)));
		System.out.println("Product is: " + Complex.toString(Complex.multiply(a, b)));
		System.out.println("Division is: " + Complex.toString(Complex.divide(a, b)));
	}

}
