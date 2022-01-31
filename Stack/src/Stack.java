import java.util.ArrayList;

public class Stack {
	
	public static void main(String[] args) {
		ArrayList<String> stack = new ArrayList<String>();
		
		push("1", stack);
		push("2", stack);
		pop(stack);
		System.out.println(peek(stack));
		
		push("3", stack);
		push("4", stack);
		
		System.out.println(peek(stack));
		
		move(stack, "1");
		System.out.println(peek(stack));
	}
	
	private static void push(String element, ArrayList<String> stack)
	{
		stack.add(element);
	}
	
	private static void pop(ArrayList<String> stack)
	{
		ArrayList<String> poppedStack = new ArrayList<String>();
		
		if (stack.size() > 0)
		{
		
			for (int i = 0; i < stack.size() - 1; i++)
			{
				poppedStack.add(stack.get(i));
			}
		
			stack = poppedStack;
		}
	}
	
	private static String peek(ArrayList<String> stack)
	{
		if (stack.size() < 1)
		{
			return "-1";
		}
		
		return stack.get(stack.size() - 1);
	}
	
	private static int search(ArrayList<String> stack, String searched)
	{
		for (int i = 0; i < stack.size(); i++)
		{
			if (stack.get(i).equals(searched))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	private static void move(ArrayList<String> stack, String swap)
	{
		int index = search(stack, swap);
		
		if (index > -1)
		{
			ArrayList<String> newStack = new ArrayList<String>();
			
			for (int i = 0; i < index; i++)
			{
				newStack.add(stack.get(i));
			}
			
			for (int j = index; j < stack.size() - 1; j++)
			{
				newStack.add(stack.get(j + 1));
			}
			
			newStack.add(stack.get(index));
			stack = newStack;
		}
	}

}
