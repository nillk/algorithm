import java.util.Arrays;
import java.util.Scanner;

public class Q2096_GoDown {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] MAX = new int[3];
		int[] MIN = new int[3];
		int[] SCORE = new int[3];

		for (byte i = 0; i < 3; i++) {
			MIN[i] = MAX[i] = scan.nextInt();
		}

		while (--N > 0) {
			SCORE[0] = scan.nextInt();
			SCORE[1] = scan.nextInt();
			SCORE[2] = scan.nextInt();

			int leftSideMax = Math.max(MAX[0], MAX[1]);
			int rightSideMax = Math.max(MAX[1], MAX[2]);
			int leftSideMin = Math.min(MIN[0], MIN[1]);
			int rightSideMin = Math.min(MIN[1], MIN[2]);

			MAX[0] = SCORE[0] + leftSideMax;
			MAX[1] = SCORE[1] + Math.max(leftSideMax, rightSideMax);
			MAX[2] = SCORE[2] + rightSideMax;

			MIN[0] = SCORE[0] + leftSideMin;
			MIN[1] = SCORE[1] + Math.min(leftSideMin, rightSideMin);
			MIN[2] = SCORE[2] + rightSideMin;
		}

		Arrays.sort(MAX);
		Arrays.sort(MIN);
		System.out.printf("%d %d", MAX[2], MIN[0]);
		scan.close();
	}
}
