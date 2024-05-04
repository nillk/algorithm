package backjoon;

import java.util.Scanner;

public class Q10870_Fibonacci5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte n = scan.nextByte();

		int[] FIBO = new int[n + 5];
		FIBO[1] = 1;
		for (byte i = 2; i <= n; i++) {
			FIBO[i] = FIBO[i - 1] + FIBO[i - 2];
		}

		System.out.println(FIBO[n]);
		scan.close();
	}
}
