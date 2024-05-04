package backjoon;

public class Q4673_SelfNumbers {
	private static boolean[] SELF_NUMBERS = new boolean[10001];

	public static void main(String[] args) {
		for (int i = 1; i < 10001; i++) {
			int n = d(i);
			while (n < 10001) {
				SELF_NUMBERS[n] = true;
				n = d(n);
			}
		}

		for (int i = 1; i < 10001; i++) {
			if (!SELF_NUMBERS[i]) {
				System.out.println(i);
			}
		}
	}

	private static int d(int n) {
		int result = n;
		while (n > 9) {
			result += n % 10;
			n /= 10;
		}
		result += n;
		return result;
	}
}
