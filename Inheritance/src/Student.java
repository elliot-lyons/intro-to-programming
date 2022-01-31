
public class Student extends Person{
	
	private double gpa;
	
	public Student(String firstName, String lastName, String address, int id, double gpa)
	{
		super(firstName, lastName, address, id);
		this.gpa = gpa;
	}
	
	public void setGpa(double gpa)
	{
		this.gpa = gpa;
	}
	
	public double getGpa()
	{
		return gpa;
	}
	
	@Override
	public void display()
	{
		System.out.printf("First Name: %s%nLast Name: %s%nAddress: %s%nID: %d%nGPA: %.1f%n%n", getFirstName(), getLastName(), getAddress(), getId(), gpa);
	}
}