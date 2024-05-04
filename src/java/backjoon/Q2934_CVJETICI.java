package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2934_CVJETICI {
	static int[] count = new int[100001];
	static int[] tree = new int[100001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());

		while (N-- > 0) {
			String[] LR = reader.readLine().split(" ");
			int L = Integer.parseInt(LR[0]);
			int R = Integer.parseInt(LR[1]);

			int left = query(L);
			int right = query(R);

			result.append(left + right - count[L] - count[R] + "\n");

			count[L] = left;
			count[R] = right;

			update(L + 1, 1);
			update(R, -1);
		}

		System.out.println(result.toString());
	}

	private static int query(int point) {
		int sum = 0;

		for (int i = point; i > 0; i -= i & -i) {
			sum += tree[i];
		}

		return sum;
	}

	private static void update(int point, int diff) {
		for (int i = point; i <= 100000; i += i & -i) {
			tree[i] += diff;
		}
	}
}
