package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2293_Coin1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte n = scan.nextByte();
		short k = scan.nextShort();

		int[] coins = new int[n];
		for (byte i = 0; i < n; i++) {
			coins[i] = scan.nextInt();
		}
		Arrays.sort(coins);

		int[] count = new int[k + 1];
		count[0] = 1;
		for (byte i = 0; i < n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				count[j] += count[j - coins[i]];
			}
		}

		System.out.println(count[k]);
		scan.close();
	}
}
