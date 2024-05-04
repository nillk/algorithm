package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2156_Wine {
	private static short[] wines;
	private static int[] cache;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		wines = new short[n + 1];
		cache = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			wines[i] = Short.parseShort(reader.readLine());
		}

		solve(n);
		Arrays.sort(cache);

		System.out.println(cache[n]);
	}

	private static int solve(int n) {
		if (n <= 0) return 0;
		if (cache[n] != 0) return cache[n];

		return cache[n] = Math.max(wines[n] + Math.max(solve(n - 3) + wines[n - 1], solve(n - 2)), solve(n - 1));
	}
}