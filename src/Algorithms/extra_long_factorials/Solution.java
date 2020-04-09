package extra_long_factorials;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	// Complete the extraLongFactorials function below.
	static void extraLongFactorials(int n) {
		BigInteger fact = BigInteger.valueOf(1);
		while (n != 1) {
			fact = fact.multiply(BigInteger.valueOf(n--));
		}
		System.out.println(fact);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		extraLongFactorials(n);

		scanner.close();
	}
}
