package sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	static int exchangeCount = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		int[] sortedArray = bubbleSort(A);
		for (int i = 0; i < sortedArray.length; i++) {

			if(i==sortedArray.length-1) {
				System.out.println(sortedArray[i]);
			} else {
				System.out.print(sortedArray[i] + " ");
			}
		}
		System.out.println(exchangeCount);

	}

	static int[] bubbleSort(int[] array) {

		int[] newArray = Arrays.copyOf(array, array.length);
		boolean flag = true;

		while(flag) {
			flag = false;

			for (int i = newArray.length-1; i > 0 ; i--) {
				int p = newArray[i];
				int q = newArray[i-1];
				if(p < q) {
					newArray[i-1] = p;
					newArray[i] = q;
					flag = true;
					exchangeCount++;
				}
			}

		}

		return newArray;
	}
}
