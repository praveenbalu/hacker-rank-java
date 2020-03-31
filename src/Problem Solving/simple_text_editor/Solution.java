package simple_text_editor;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	static class Operation {
		public int operation;
		public int k;
		public String str;

		public Operation(int operation, int k) {
			this.operation = operation;
			this.k = k;
		}

		public Operation(int operation, String str) {
			this.operation = operation;
			this.str = str;
		}
	}

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			StringBuilder textBox = new StringBuilder();
			int noOfOperations = input.nextInt();
			input.nextLine();

			Stack<Operation> lastTransactions = new Stack<>();

			List<Character> output = new LinkedList<>();

			for (int i = 1; i <= noOfOperations; i++) {

				int op = input.nextInt();
				switch (op) {
				case 1:
					String value = input.next();
					append(value, textBox);
					lastTransactions.push(new Operation(1, value.length()));
					break;
				case 2:
					int k = input.nextInt();
					String str = delete(k, textBox);
					lastTransactions.push(new Operation(2, str));
					break;
				case 3:
					k = input.nextInt();
					output.add(textBox.charAt(k - 1));
					break;
				case 4:
					if (!lastTransactions.isEmpty())
						undo(textBox, lastTransactions.pop());
					break;
				}
			}

			output.forEach(System.out::println);
		}
	}

	public static void append(String str, StringBuilder textBox) {
		textBox.append(str);
	}

	public static String delete(int k, StringBuilder textBox) {
		String str = textBox.substring(textBox.length() - k, textBox.length());
		textBox.setLength(textBox.length() - k);
		return str;
	}

	public static void undo(StringBuilder textBox, Operation operation) {
		int lastOperation = operation.operation;
		if (lastOperation == 1)
			delete(operation.k, textBox);
		else if (lastOperation == 2)
			append(operation.str, textBox);
	}
}
