package backjoon;

import java.util.Scanner;

public class Q2193_PinaryNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte n = scan.nextByte();

		long[][] DP = new long[n][2];
		DP[0][0] = 1;
		DP[0][1] = 0;

		for (byte i = 1; i < n; i++) {
			DP[i][0] = DP[i - 1][1];
			DP[i][1] = DP[i - 1][0] + DP[i - 1][1];
		}

		System.out.println(DP[n - 1][0] + DP[n - 1][1]);
		scan.close();
	}
}
