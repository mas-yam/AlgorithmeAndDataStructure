package sort;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {

	static int count = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
	}

	static int[] shellSort(int[] array) {

		int[] newArray = Arrays.copyOf(array, array.length);


		return newArray;
	}

	static int[] insertionSort(int[] array, int g) {

		int[] newArray = Arrays.copyOf(array, array.length);
		for (int i = g; i < newArray.length - 1; i++) {

			int iVal = newArray[i];
			int j = i - g;

			while (j >= 0 && newArray[j] > iVal) {
				newArray[j+g] = newArray[j];
				j = j - g;
				count++;
			}
			newArray[j+g] = iVal;
		}

		return newArray;
	}
}
