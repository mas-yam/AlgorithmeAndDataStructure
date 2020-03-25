package stack;

public class TrialStack {

	static int top = 0;
	static int[] stack = new int[Integer.MAX_VALUE / 1000];

	public static void main(String[] args) throws Exception {

		String test = "1 2 + 3 4 - *";
		for (String str : test.split(" ")) {

			if (str.equals("-")) {
				int a = pop();
				int b = pop();
				push(b - a);

			} else if (str.equals("*")) {
				int a = pop();
				int b = pop();
				push(b * a);

			} else if (str.equals("+")) {
				int a = pop();
				int b = pop();
				push(b + a);

			} else {
				push(Integer.parseInt(str));
			}
		}
		System.out.println(pop());
	}

	static int pop() throws Exception {

		if (top == 0) {
			throw new Exception("stack is enpty");
		}
		int num = stack[--top];
		stack[top] = 0; // 引き出し済みの要素は初期値で上書き

		return num;
	}

	static void push(int num) throws Exception {

		if (stack.length == top) {
			throw new Exception("stack is full to the brim");
		}
		stack[top++] = num;
	}
}
