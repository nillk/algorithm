package backjoon;

import java.util.Scanner;

public class Q2914_Faktor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte A = scan.nextByte();
		byte I = scan.nextByte();
		System.out.println((A * I) - A + 1);
		scan.close();
	}
}
