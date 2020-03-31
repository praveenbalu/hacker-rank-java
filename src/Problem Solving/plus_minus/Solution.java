package plus_minus;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution {

	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		long positive = 0;
		long negative = 0;
		long zero = 0;
		double size = arr.length;
		for (int value : arr) {
			if (value == 0)
				++zero;
			else if (value > 0)
				++positive;
			else
				++negative;
		}
		DecimalFormat df = new DecimalFormat("#.######");

		System.out.println(df.format(positive / size));
		System.out.println(df.format(negative / size));
		System.out.println(df.format(zero / size));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);

		scanner.close();
	}
}
