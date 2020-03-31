package balanced_brackets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	// Complete the isBalanced function below.
	static String isBalanced(String s) {
		List<Character> openBrackets = Arrays.asList('{', '[', '(');
		List<Character> closeBrackets = Arrays.asList('}', ']', ')');

		Stack<Character> brackets = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (openBrackets.contains(c))
				brackets.push(c);
			else {
				int openBracket = !brackets.isEmpty() ? openBrackets.indexOf(brackets.pop()) : Integer.MIN_VALUE;
				int closeBracket = closeBrackets.indexOf(c);
				if (openBracket != closeBracket)
					return "NO";
			}
		}
		return brackets.isEmpty() ? "YES" : "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();

			String result = isBalanced(s);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
