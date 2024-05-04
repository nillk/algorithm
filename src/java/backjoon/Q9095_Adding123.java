package backjoon;

import java.util.Scanner;

public class Q9095_Adding123 {
	public static void main(String[] args) {
		int[] Adding = new int[12];
		Adding[1] = 1;
		Adding[2] = 2;
		Adding[3] = 4;
		
		for (int i = 4; i < 12; i++) {
			Adding[i] = Adding[i - 1] + Adding[i - 2] + Adding[i - 3];
		}
		
		Scanner scan = new Scanner(System.in);
		byte n = scan.nextByte();
		while (n-- > 0) {
			byte num = scan.nextByte();
			System.out.println(Adding[num]);
		}
		scan.close();
	}
}
