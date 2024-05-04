package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579_Stairs {
	private static short[] value;
	private static int[] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		short stairs = Short.parseShort(reader.readLine());
		value = new short[stairs + 1];
		cache = new int[stairs + 1];
		for (short i = 0; i < stairs; i++) {
			value[i + 1] = Short.parseShort(reader.readLine());
		}
		
		System.out.println(solve(stairs));

		reader.close();
	}

	private static int solve(int stairs) {
		if (stairs <= 0) return 0;
		if (cache[stairs] != 0) return cache[stairs];

		return cache[stairs] = value[stairs] + Math.max(value[stairs - 1] + solve(stairs - 3), solve(stairs - 2));
	}
}
