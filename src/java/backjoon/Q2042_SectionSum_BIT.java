package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2042_SectionSum_BIT {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		String[] nmk = reader.readLine().split(" ");
		int N = Integer.parseInt(nmk[0]);
		int M = Integer.parseInt(nmk[1]);
		int K = Integer.parseInt(nmk[2]);

		long[] numbers = new long[N + 1];
		long[] tree = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			numbers[i] = Long.parseLong(reader.readLine());
			update(tree, i, numbers[i]);
		}

		for (int i = 0; i < M + K; i++) {
			String[] abc = reader.readLine().split(" ");
			int b = Integer.parseInt(abc[1]);
			if ("1".equals(abc[0])) {
				long c = Long.parseLong(abc[2]);
				long diff = c - numbers[b];
				numbers[b] = c;
				update(tree, b, diff);
			} else if ("2".equals(abc[0])) {
				int c = Integer.parseInt(abc[2]);
				result.append(sum(tree, c) - sum(tree, b - 1));
				result.append("\n");
			}
		}

		System.out.println(result.toString());
	}

	private static void update(long[] tree, int i, long diff) {
		int length = tree.length;
		while (i < length) {
			tree[i] += diff;
			i += (i & -i);
		}
	}

	private static long sum(long[] tree, int i) {
		long sum = 0;
		while (i > 0) {
			sum += tree[i];
			i -= (i & -i);
		}
		return sum;
	}
}
