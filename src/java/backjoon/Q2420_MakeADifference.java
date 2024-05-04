package backjoon;

import java.util.Scanner;

public class Q2420_MakeADifference {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long m = scan.nextLong();

		if (n < m) {
			long tmp = n;
			n = m;
			m = tmp;
		}

		System.out.println(Math.abs(n - m));
		scan.close();
	}
}
