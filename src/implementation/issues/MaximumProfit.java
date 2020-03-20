package implementation.issues;

import java.util.Scanner;

public class MaximumProfit {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long[] r = new long[n];

		for (int i = 0; i < n; i++) {
			r[i] = sc.nextLong();
		}

		long min = r[0];
		long revenue = r[1] - r[0];
		for (int i = 1; i < r.length; i++) {
			revenue = Math.max(r[i]-min, revenue);
			min = Math.min(r[i], min);
		}
		System.out.println(revenue);
		sc.close();
	}
}
