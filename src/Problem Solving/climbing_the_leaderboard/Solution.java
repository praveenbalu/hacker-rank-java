package climbing_the_leaderboard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	private static int[] currentRanks;

	static int[] climbingLeaderboard(int[] scores, String[] alice) {
		int[] ranks = new int[alice.length];
		for (int i = 0; i < alice.length; i++) {
			int aliceScore = Integer.parseInt(alice[i]);
			ranks[i] = getRank(aliceScore, scores, currentRanks);
		}

		return ranks;
	}

	private static int getRank(int aliceScore, int[] scores, int[] currentRanks) {
		int rank = 0;
		int startPoint = 0;
		int endPoint = scores.length - 1;

		while (startPoint <= endPoint) {
			int middle = (startPoint + endPoint) / 2;

			if (aliceScore == scores[middle]) {
				rank = currentRanks[middle];
				break;
			} else if (aliceScore < scores[middle]) {
				rank = currentRanks[middle] + 1;
				startPoint = middle + 1;
			} else
				endPoint = middle - 1;
		}

		return rank == 0 && aliceScore > scores[0] ? 1 : rank;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int scoresCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[scoresCount];
		currentRanks = new int[scoresCount];
		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < scoresCount; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
			if (i == 0)
				currentRanks[i] = 1;
			else
				currentRanks[i] = (scores[i] == scores[i - 1]) ? currentRanks[i - 1] : currentRanks[i - 1] + 1;
		}

		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] aliceItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] result = climbingLeaderboard(scores, aliceItems);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
