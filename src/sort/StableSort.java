package sort;

import java.util.Arrays;
import java.util.Scanner;

public class StableSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] C = new String[N];
		for (int i = 0; i < C.length; i++) {
			C[i] = sc.next();
		}

		String[] bubbleSorted = bubbleSort(C);
		String[] selectionSorted = selectionSort(C);

	}

	static String[] bubbleSort(String[] array) {

		String[] newArray = Arrays.copyOf(array,array.length);

		boolean judge = true;
		while(judge) {

			judge = false;

			for (int i = newArray.length-1; i > 0; i--) {

				String iStr = newArray[i];
				String iType = iStr.substring(0,1);
				int iVal = Integer.parseInt(iStr.substring(1));

				int j = i -1;
				String jStr = newArray[j];
				String jType = jStr.substring(0,1);
				int jVal = Integer.parseInt(jStr.substring(1));

				if(iVal < jVal) {
					newArray[i] = jStr;
					newArray[j] = iStr;
					judge = true;
				}
			}
		}

		return newArray;
	}

	static String[] selectionSort(String[] array) {

		String[] newArray = Arrays.copyOf(array,array.length);

		for (int i = 0; i < newArray.length-1; i++) {

			String iStr = newArray[i];

			int min = i;
			String minStr = null;
			String minType = null;
			int minVal = 0;
			for (int j = i; j < newArray.length; j++) {

				minStr = newArray[min];
				minType = minStr.substring(0,1);
				minVal = Integer.parseInt(minStr.substring(1));

				String jStr = newArray[j];
				String jType = jStr.substring(0,1);
				int jVal = Integer.parseInt(jStr.substring(1));

				if(jVal < minVal) {
					min = j;
				}
			}

			String toI = newArray[min];
			String toMin = newArray[i];

			newArray[i] = toI;
			newArray[min] = toMin;
		}

		return newArray;
	}
}
