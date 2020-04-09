package stair_case;

import java.util.Scanner;

public class Solution {

	// Complete the staircase function below.
	static void staircase(int n) {
		StringBuilder sb = new StringBuilder("#");

		for (int i = 0; i < n; i++) {
			System.out.println(String.format("%" + n + "s", sb));
			sb.append("#");
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		staircase(n);

		scanner.close();
	}
}
