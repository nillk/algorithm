package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9465_Stickers {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(reader.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(reader.readLine());
			byte[][] stickers = new byte[2][N];
			int[][] DP = new int[2][N];
			String[] first = reader.readLine().split(" ");
			String[] second = reader.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				stickers[0][j] = Byte.parseByte(first[j]);
				stickers[1][j] = Byte.parseByte(second[j]);

				if (j == 0) {
					DP[0][j] = stickers[0][j];
					DP[1][j] = stickers[1][j];
				} else if (j == 1) {
					DP[0][j] = stickers[0][j] + stickers[1][j - 1];
					DP[1][j] = stickers[1][j] + stickers[0][j - 1];
				} else {
					DP[0][j] = stickers[0][j] + Math.max(DP[1][j - 1], DP[1][j - 2]);
					DP[1][j] = stickers[1][j] + Math.max(DP[0][j - 1], DP[0][j - 2]);
				}
			}

			System.out.println(DP[0][N - 1] > DP[1][N - 1] ? DP[0][N - 1] : DP[1][N - 1]);
		}

		reader.close();
	}
}
