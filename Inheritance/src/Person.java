
public class Person {
	private String firstName;
	private String lastName;
	private String address;
	protected int id;
	
	public Person()
	{
		firstName = "";
		lastName = "";
		address = "";
		id = 0;
	}
	
	public Person(String firstName, String lastName, String address, int id)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.id = id;
	}
	
	public void setFirstName(String name)
	{
		firstName = name;
	}
	
	public void setLastName(String name)
	{
		lastName = name;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void display()
	{
		System.out.printf("First Name: %s%nLast Name: %s%nAddress: %s%nID: %d%n%n", firstName, lastName, address, id);
	}

}
