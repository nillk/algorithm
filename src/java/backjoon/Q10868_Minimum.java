package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10868_Minimum {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		String[] split = reader.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);

		int treeSize = 1 << ((int) Math.ceil(Math.log(n) / Math.log(2)) + 1);

		int[] numbers = new int[n];
		int[] tree = new int[treeSize];

		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(reader.readLine());
		}

		init(tree, numbers, 1, 0, n - 1);

		for (int i = 0; i < m; i++) {
			String[] range = reader.readLine().split(" ");
			int a = Integer.parseInt(range[0]);
			int b = Integer.parseInt(range[1]);

			result.append(query(tree, 1, 0, n - 1, a - 1, b - 1));
			result.append("\n");
		}

		System.out.println(result.toString());
	}

	private static int init(int[] tree, int[] numbers, int node, int start, int end) {
		if (start == end) {
			return tree[node] = numbers[start];
		}

		return tree[node] = Math.min(
				init(tree, numbers, node * 2, start, (start + end) / 2),
				init(tree, numbers, (node * 2) + 1, ((start + end) / 2) + 1, end));
	}

	private static int query(int[] tree, int node, int start, int end, int a, int b) {
		if (a > end || b < start) {
			return Integer.MAX_VALUE;
		}
		if (a <= start && b >= end) {
			return tree[node];
		}

		return Math.min(
				query(tree, node * 2, start, (start + end) / 2, a, b),
				query(tree, (node * 2) + 1, ((start + end) / 2) + 1, end, a, b));
	}
}
