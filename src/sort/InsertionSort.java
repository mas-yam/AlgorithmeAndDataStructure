package sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		System.out.println("昇順ソート↓");
		InsertionSort.ascendingSort(A);

		System.out.println("降順ソート↓");
		InsertionSort.descendingSort(A);
	}

	/**
	 * 昇順ソート
	 */
	static int[] ascendingSort(int[] array) {

		int[] newArray = Arrays.copyOf(array, array.length);
		for (int k = 0; k < newArray.length; k++) {

			if(k== newArray.length-1) {
				System.out.println(newArray[k]);
			} else {
				System.out.print(newArray[k] + " ");
			}
		}

		for (int i = 1; i < newArray.length; i++) {
			int v = newArray[i];
			int j = i -1;
			while(j>=0 && newArray[j] > v) {
				newArray[j+1] = newArray[j];
				j--;
			}
			newArray[j+1] = v;
			for (int k = 0; k < newArray.length; k++) {

				if(k== newArray.length-1) {
					System.out.println(newArray[k]);
				} else {
					System.out.print(newArray[k] + " ");
				}
			}
		}
		return newArray;
	}

	/**
	 * 降順ソート
	 */
	static int[] descendingSort(int[] array) {

		int[] newArray = Arrays.copyOf(array, array.length);
		for (int k = 0; k < newArray.length; k++) {

			if(k== newArray.length-1) {
				System.out.println(newArray[k]);
			} else {
				System.out.print(newArray[k] + " ");
			}
		}

		for (int i = 0; i < newArray.length; i++) {
			int v = newArray[i];
			int j = i - 1;
			while(j>=0 && newArray[j] < v) {
				newArray[j+1] = newArray[j];
				j--;
			}
			newArray[j+1] = v;
			for (int k = 0; k < newArray.length; k++) {

				if(k== newArray.length-1) {
					System.out.println(newArray[k]);
				} else {
					System.out.print(newArray[k] + " ");
				}
			}
		}
		return newArray;
	}
}
