package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2042_SectionSum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		String[] nmk = reader.readLine().split(" ");
		int N = Integer.parseInt(nmk[0]);
		int M = Integer.parseInt(nmk[1]);
		int K = Integer.parseInt(nmk[2]);

		long[] numbers = new long[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Long.parseLong(reader.readLine());
		}

		long[] tree = new long[getTreeNodeSize(N)];
		init(numbers, tree, 1, 0, N - 1);

		for (int i = 0; i < M + K; i++) {
			String[] abc = reader.readLine().split(" ");
			int b = Integer.parseInt(abc[1]);
			if ("1".equals(abc[0])) {
				long c = Long.parseLong(abc[2]);
				long diff = c - numbers[b - 1];
				numbers[b - 1] = c;
				update(tree, 1, 0, N - 1, b - 1, diff);
			} else if ("2".equals(abc[0])) {
				int c = Integer.parseInt(abc[2]);
				result.append(sum(tree, 1, 0, N - 1, b - 1, c - 1) + "\n");
			}
		}

		System.out.println(result.toString());
	}

	private static int getTreeNodeSize(int n) {
		int depth = (int) Math.ceil(log2(n));
		return (int) Math.pow(2, depth + 1);
	}

	private static double log2(int n) {
		return Math.log(n) / Math.log(2);
	}

	private static long init(long[] numbers, long[] tree, int node, int start, int end) {
		if (start == end) {
			return tree[node] = numbers[start];
		} else {
			return tree[node] = init(numbers, tree, node * 2, start, (start + end) / 2) + init(numbers, tree, (node * 2) + 1, ((start + end) / 2) + 1, end);
		}
	}

	private static void update(long[] tree, int node, int start, int end, int index, long diff) {
		if (index < start || index > end) {
			return;
		}
		tree[node] += diff;
		if (start != end) {
			update(tree, node * 2, start, (start + end) / 2, index, diff);
			update(tree, (node * 2) + 1, ((start + end) / 2) + 1, end, index, diff);
		}
	}

	private static long sum(long[] tree, int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		return sum(tree, node * 2, start, (start + end) / 2, left, right) + sum(tree, (node * 2) + 1, ((start + end) / 2) + 1, end, left, right);
	}
}
