package stack;

public class SampleStack {

	String[] array = new String[Integer.MAX_VALUE / 1000];
	int top = 0;

	SampleStack() {
	}

	SampleStack(String[] array) {
		this.array = array;
	}

	public static void main(String[] args) {

		SampleStack stack = new SampleStack();
		stack.push("abc");
		stack.push("def");
		System.out.println(stack.pop());
	}

	void push(String str) {
		array[top++] = str;
	}

	String pop() {
		int target = --top;
		String str = array[target];
		array[target] = null;
		return str;
	}
}
