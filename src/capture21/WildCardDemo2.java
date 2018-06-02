package capture21;

public class WildCardDemo2 {
	public static void main(String[] args) {
		GenericStack<Integer> intStack = new GenericStack<Integer>();
		intStack.push(1);
		intStack.push(2);
		intStack.push(-2);
		print(intStack);
	}
	
	/** Print objects and empties the stack */
	public static void print(GenericStack<?> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
