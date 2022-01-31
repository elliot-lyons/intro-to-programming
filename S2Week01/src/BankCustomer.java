import java.util.ArrayList;

public class BankCustomer {
	
	private int accountNumber;
	private String customerName;
	private String customerAddress;
	private String customerDOB;
	
	public int getAccountNumber()
	{
		return accountNumber;
	}
	public void setAccountNumber(int accNumber)
	{
		accountNumber = accNumber;
	}
	
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String name)
	{
		customerName = name;
	}
	
	public String getCustomerAddress()
	{
		return customerAddress;
	}
	public void setCustomerAddress(String address)
	{
		customerAddress = address;
	}
	
	public String getCustomerDOB()
	{
		return customerDOB;
	}
	public void setCustomerDOB(String dob)
	{
		customerDOB = dob;
	}
	
	public static String findCustomer(BankCustomer[] custArr, int accNo)
	{
		for (int i = 0; i < custArr.length; i++)
		{
			BankCustomer curCustomer = custArr[i];
			int custAccNum = curCustomer.getAccountNumber();
			
			if (accNo == custAccNum)
			{
				return curCustomer.getCustomerName();
			}
		}
		
		return null;
	}
	
	public static String findCustomer(BankCustomer[] custArray, String dob, String address)
	{
		for (int i = 0; i < custArray.length; i++)
		{
			BankCustomer curCustomer = custArray[i];
			String custDob = curCustomer.getCustomerDOB();
			String custAddress = curCustomer.getCustomerAddress();
			
			if (custDob == dob && custAddress.equals(address))
			{
				return curCustomer.getCustomerName();
			}
		}
		return null;
	}
	
	public static BankCustomer findCustomer(ArrayList<BankCustomer> custArray, int accNum)
	{
		ArrayList<BankCustomer> custArrayList = new ArrayList<>();
		custArrayList.add(new BankCustomer);
		
		for (int i = 0; i < custArray.size(); i++)
		{
			BankCustomer curCustomer = 
		}
	}

	public static void main(String[] args) {
		BankCustomer cust1 = new BankCustomer();
		BankCustomer[] bankCustomerArray = new BankCustomer[10];

		cust1.setAccountNumber(123);
		cust1.setCustomerName("Elliot Lyons");
		cust1.setCustomerAddress("Naas");
		cust1.setCustomerDOB("24/03/2002");
		
		bankCustomerArray[0] = cust1;
		
		findCustomer(bankCustomerArray, 255);
		findCustomer(bankCustomerArray, "24/03/2002", "Naas");
		
	}

}
