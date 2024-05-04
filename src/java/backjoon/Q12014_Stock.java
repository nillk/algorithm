package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12014_Stock {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());

		for (int i = 1; i <= T; i++) {
			int K = Integer.parseInt(reader.readLine().split(" ")[1]);

			String[] stock = reader.readLine().split(" ");

			System.out.printf("Case #%d\n", i);
			System.out.println(LIS_lowerbound(stock) >= K ? 1 : 0);
		}
	}

	private static int LIS_lowerbound(String[] stock) {
		int length = stock.length;
		int[] lis = new int[length];
		lis[0] = Integer.parseInt(stock[0]);
		int max = 1;
		for (int i = 1; i < length; i++) {
			int current = Integer.parseInt(stock[i]);
			if (current < lis[0]) {
				lis[0] = current;
				continue;
			} else if (current > lis[max - 1]) {
				lis[max++] = current;
			} else {
				lis[lowerBound(lis, 0, max - 1, current)] = current;
			}
		}

		return max;
	}

	private static int lowerBound(int[] lis, int left, int right, int value) {
		while (right - left > 1) {
			int m = (left + right) / 2;
			if (lis[m] >= value) {
				right = m;
			} else {
				left = m;
			}
		}
		return right;
	}
}
