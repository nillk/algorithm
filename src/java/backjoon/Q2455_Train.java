package backjoon;

import java.util.Scanner;

public class Q2455_Train {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int capacity = 0;
		int max = 0;

		for (byte i = 0; i < 4; i++) {
			int out = scan.nextInt();
			int in = scan.nextInt();

			capacity -= out;
			max = Math.max(max, capacity);

			capacity += in;
			max = Math.max(max, capacity);
		}

		System.out.println(max);
	}
}
