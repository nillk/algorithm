package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2294_Coin2 {
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
		for (byte i = 0; i < n && coins[i] <= k; i++) {
			count[coins[i]] = 1;
		}

		for (byte i = 0; i < n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				if (count[j - coins[i]] != 0) {
					if (count[j] == 0 || count[j] > count[j - coins[i]] + 1) {
						count[j] = count[j - coins[i]] + 1;
					}
				}
			}
		}

		if (count[k] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(count[k]);
		}
		
		scan.close();
	}
}
