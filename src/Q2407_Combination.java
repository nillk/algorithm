import java.util.Scanner;

public class Q2407_Combination {
	private static byte[] FAC;
	private static int FAC_SIZE;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte n = scan.nextByte();
		byte m = scan.nextByte();

		System.out.println(combination(n, m));

		scan.close();
	}

	public static String combination(int n, int m) {
		FAC = new byte[200];
		FAC[0] = 1;
		FAC_SIZE = 1;

		if (n > 2 * m) {
			for (int i = n - m + 1; i <= n; i++) {
				multiply(i);
			}
			for (int i = 2; i <= m; i++) {
				divide(i);
			}
		} else {
			for (int i = m + 1; i <= n; i++) {
				multiply(i);
			}
			for (int i = 2; i <= n - m; i++) {
				divide(i);
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = FAC_SIZE - 1; i >= 0; i--) {
			result.append(FAC[i]);
		}
		return result.toString();
	}

	private static void multiply(int num) {
		byte carry = 0;

		for (int i = 0; i < FAC_SIZE; i++) {
			int tmp = (FAC[i] * num) + carry;
			FAC[i] = (byte) (tmp % 10);
			carry = (byte) (tmp / 10);
		}

		while (carry > 0) {
			FAC[FAC_SIZE++] = (byte) (carry % 10);
			carry /= 10;
		}
	}

	private static void divide(int num) {
		byte remainder = 0;

		while (((remainder * 10) + FAC[FAC_SIZE - 1]) / num == 0) {
			remainder = (byte) ((remainder * 10) + FAC[FAC_SIZE - 1]);
			FAC[FAC_SIZE - 1] = 0;
			FAC_SIZE--;
		}

		for (int i = FAC_SIZE - 1; i >= 0; i--) {
			int tmp = (remainder * 10) + FAC[i];
			FAC[i] = (byte) (tmp / num);
			remainder = (byte) (tmp % num);
		}
	}
}
