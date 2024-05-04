package backjoon;

import java.util.Scanner;

public class Q2609_GCDLCM {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		int B = scan.nextInt();
		
		int gcd = gcd(A, B);
		
		System.out.println(gcd);
		System.out.println((A * B) / gcd);

		scan.close();
	}

	private static int gcd(int a, int b) {
		int[] arr = new int[3];
		if (a > b) {
			arr[0] = a;
			arr[1] = b;
		} else {
			arr[0] = b;
			arr[1] = a;
		}
		
		while (arr[1] > 0) {
			arr[2] = arr[0] % arr[1];
			arr[0] = arr[1];
			arr[1] = arr[2];
		}

		return arr[0];
	}
}
