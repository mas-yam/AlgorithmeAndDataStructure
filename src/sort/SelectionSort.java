package sort;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];

		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		int exchangeCount = 0;
		for (int i = 0; i < A.length; i++) {

			int minIndex = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < A[minIndex]) {
					minIndex = j;
				}
			}
			int Ai = A[i];
			int Amin = A[minIndex];
			A[i] = Amin;
			A[minIndex] = Ai;
			exchangeCount++;
		}

		for (int i = 0; i < A.length; i++) {
			if(i==A.length-1) {
				System.out.println(A[i]);
			} else {
				System.out.print(A[i] + " ");
			}
		}
		System.out.println(exchangeCount);
	}
}
