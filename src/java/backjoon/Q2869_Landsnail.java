package backjoon;

import java.util.Scanner;

public class Q2869_Landsnail {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int up = scan.nextInt();
		int down = scan.nextInt();
		int height = scan.nextInt();

		int diff = up - down;
		int day = (height - up) / diff;
		int leftHeight = ((height - up) % diff) + up;

		if (leftHeight <= up) {
			System.out.println(day + 1);
		} else {
			System.out.println(day + 2);
		}
		
		scan.close();
	}
}
